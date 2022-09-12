package com.mdsql.bussiness.service.impl;

import com.mdsql.bussiness.entities.ObjetoHis;
import com.mdsql.bussiness.entities.Objetos;
import com.mdsql.bussiness.entities.TextoLinea;
import com.mdsql.bussiness.service.HistoricoService;
import com.mdsql.exceptions.ServiceException;
import com.mdsql.utils.Constants;
import com.mdsql.utils.LogWrapper;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import oracle.jdbc.internal.OracleConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Array;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Struct;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;


/**
 * @author hcarreno
 */
@Service(Constants.HISTORICO_SERVICE)
@Slf4j
public class HistoricoServiceImpl extends ServiceSupport implements HistoricoService {

    @Autowired
    private DataSource dataSource;

    @Override
    @SneakyThrows
    public void altaHistorico(List<Objetos> objetosList, String codigoProyecto, String codigoPeticion, String codigoUsuario) {
        String runSP = createCall("p_alta_historico", Constants.CALL_06_ARGS);

        try (Connection conn = dataSource.getConnection();
             CallableStatement callableStatement = conn.prepareCall(runSP)) {

            String tableObjetos = createCallType(Constants.T_T_OBJETOS);
            String recordObjetos = createCallType(Constants.T_R_OBJETOS);

            String typeError = createCallTypeError();

            logProcedure(runSP, objetosList, codigoProyecto, codigoPeticion, codigoUsuario);

            Struct[] structObjetos = new Struct[objetosList.size()];

            int arrayIndexLinea = 0;
            for (Objetos data : objetosList) {
                structObjetos[arrayIndexLinea++] = conn.createStruct(recordObjetos,
                        new Object[]{data.getTipoObjeto(), data.getNombreObjeto()});
            }

            Array arrayObjetos = ((OracleConnection) conn).createOracleArray(tableObjetos, structObjetos);

            callableStatement.setArray(1, arrayObjetos);
            callableStatement.setString(2, codigoProyecto);
            callableStatement.setString(3, codigoPeticion);
            callableStatement.setString(4, codigoUsuario);

            callableStatement.registerOutParameter(5, Types.INTEGER);
            callableStatement.registerOutParameter(6, Types.ARRAY, typeError);

            callableStatement.execute();

            Integer result = callableStatement.getInt(5);

            if (result == 0) {
                throw buildException(callableStatement.getArray(6));
            }
        } catch (SQLException e) {
            LogWrapper.error(log, "[HistoricoService.altaHistorico] Error: %s", e.getMessage());
            throw new ServiceException(e);
        }

    }


    @Override
    @SneakyThrows
    public List<ObjetoHis> seleccionarHistorico(List<TextoLinea> lineasScript, String codigoProyecto) {
        String runSP = createCall("p_sel_historico", Constants.CALL_05_ARGS);

        try (Connection conn = dataSource.getConnection();
             CallableStatement callableStatement = conn.prepareCall(runSP)) {

            String tableLinea = createCallType(Constants.T_T_LINEA);
            String recordLinea = createCallType(Constants.T_R_LINEA);

            String typeObjetoHis = createCallType(Constants.T_T_OBJ_HIS);

            String typeError = createCallTypeError();

            logProcedure(runSP, lineasScript, codigoProyecto);

            Struct[] structLinea = new Struct[lineasScript.size()];

            int arrayIndexLinea = 0;
            for (TextoLinea data : lineasScript) {
                structLinea[arrayIndexLinea++] = conn.createStruct(recordLinea,
                        new Object[]{data.getValor()});
            }

            Array arrayLinea = ((OracleConnection) conn).createOracleArray(tableLinea, structLinea);

            callableStatement.setArray(1, arrayLinea);
            callableStatement.setString(2, codigoProyecto);
            callableStatement.registerOutParameter(3, Types.ARRAY, typeObjetoHis);

            callableStatement.registerOutParameter(4, Types.INTEGER);
            callableStatement.registerOutParameter(5, Types.ARRAY, typeError);

            callableStatement.execute();

            Integer result = callableStatement.getInt(4);

            if (result == 0) {
                throw buildException(callableStatement.getArray(5));
            }


            List<ObjetoHis> objetoHisList = new ArrayList<>();
            Array arrayTypes = callableStatement.getArray(3);

            if (arrayTypes != null) {
                Object[] rows = (Object[]) arrayTypes.getArray();
                for (Object row : rows) {
                    Object[] cols = ((oracle.jdbc.OracleStruct) row).getAttributes();

                    ObjetoHis objeto = ObjetoHis.builder()
                            .nombreObjeto((String) cols[0])
                            .tipoObjeto((String) cols[1])
                            .descripcionTipoObjeto((String) cols[2])
                            .descripcionTipoObjeto((String) cols[3])
                            .build();

                    objetoHisList.add(objeto);
                }
            }

            return objetoHisList;

        } catch (
                SQLException e) {
            LogWrapper.error(log, "[HistoricoService.seleccionarHistorico] Error: %s", e.getMessage());
            throw new ServiceException(e);
        }
    }

}
