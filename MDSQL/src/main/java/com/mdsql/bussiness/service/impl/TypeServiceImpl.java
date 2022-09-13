package com.mdsql.bussiness.service.impl;

import java.math.BigDecimal;
import java.sql.Array;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Struct;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mdsql.bussiness.entities.InputProcesaType;
import com.mdsql.bussiness.entities.OutputProcesaType;
import com.mdsql.bussiness.entities.TextoLinea;
import com.mdsql.bussiness.entities.Type;
import com.mdsql.bussiness.service.TypeService;
import com.mdsql.exceptions.ServiceException;
import com.mdsql.utils.Constants;
import com.mdsql.utils.LogWrapper;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import oracle.jdbc.internal.OracleConnection;


/**
 * @author hcarreno
 */
@Service(Constants.TYPE_SERVICE)
@Slf4j
public class TypeServiceImpl extends ServiceSupport implements TypeService {

    @Autowired
    private DataSource dataSource;


    @Override
    @SneakyThrows
    public OutputProcesaType procesarType(InputProcesaType inputProcesaType) {
        String runSP = createCall("p_procesa_type", Constants.CALL_22_ARGS);

        try (Connection conn = dataSource.getConnection();
             CallableStatement callableStatement = conn.prepareCall(runSP)) {

            String tableLinea = createCallType(Constants.T_T_LINEA);
            String recordLinea = createCallType(Constants.T_R_LINEA);

            String typeType = createCallType(Constants.T_T_TYPE);

            String typeError = createCallTypeError();

            logProcedure(runSP, inputProcesaType.getLineasScript(), inputProcesaType.getPCodigoProyecto(), inputProcesaType.getPCodigoSubProyecto(), inputProcesaType.getPCodigoPeticion(), inputProcesaType.getPCodigoDemanda(),
                    inputProcesaType.getPCodigoDemanda(), inputProcesaType.getPCodigoUsr(), inputProcesaType.getPCodigoUsrPeticion(), inputProcesaType.getPNombreBBDD(), inputProcesaType.getPNombreEsquema(),
                    inputProcesaType.getPNombreFichaEntrada(), inputProcesaType.getPTxtRutaEntrada(), inputProcesaType.getPTxtDescripcion());

            Struct[] structLinea = new Struct[inputProcesaType.getLineasScript().size()];

            int arrayIndexLinea = 0;
            for (TextoLinea data : inputProcesaType.getLineasScript()) {
                structLinea[arrayIndexLinea++] = conn.createStruct(recordLinea,
                        new Object[]{data.getValor()});
            }

            Array arrayLinea = ((OracleConnection) conn).createOracleArray(tableLinea, structLinea);

            callableStatement.setArray(1, arrayLinea);
            callableStatement.setString(2, inputProcesaType.getPCodigoProyecto());
            callableStatement.setString(3, inputProcesaType.getPCodigoSubProyecto());
            callableStatement.setString(4, inputProcesaType.getPCodigoPeticion());
            callableStatement.setString(5, inputProcesaType.getPCodigoDemanda());
            callableStatement.setString(6, inputProcesaType.getPCodigoUsr());
            callableStatement.setString(7, inputProcesaType.getPCodigoUsrPeticion());
            callableStatement.setString(8, inputProcesaType.getPNombreBBDD());
            callableStatement.setString(9, inputProcesaType.getPNombreEsquema());
            callableStatement.setString(10, inputProcesaType.getPNombreFichaEntrada());
            callableStatement.setString(11, inputProcesaType.getPTxtRutaEntrada());
            callableStatement.setString(12, inputProcesaType.getPTxtDescripcion());
            callableStatement.registerOutParameter(13, Types.NUMERIC);
            callableStatement.registerOutParameter(14, Types.DATE);
            callableStatement.registerOutParameter(15, Types.NUMERIC);
            callableStatement.registerOutParameter(16, Types.VARCHAR);
            callableStatement.registerOutParameter(17, Types.VARCHAR);
            callableStatement.registerOutParameter(18, Types.VARCHAR);
            callableStatement.registerOutParameter(19, Types.VARCHAR);
            callableStatement.registerOutParameter(20, Types.ARRAY, typeType);

            callableStatement.registerOutParameter(21, Types.INTEGER);
            callableStatement.registerOutParameter(22, Types.ARRAY, typeError);

            callableStatement.execute();

            Integer result = callableStatement.getInt(21);

            if (result == 0) {
                throw buildException(callableStatement.getArray(22));
            }


            List<Type> types = new ArrayList<>();
            Array arrayTypes = callableStatement.getArray(22);

            if (arrayTypes != null) {
                Object[] rows = (Object[]) arrayTypes.getArray();
                for (Object row : rows) {
                    Object[] cols = ((oracle.jdbc.OracleStruct) row).getAttributes();

                    Type type = Type.builder()
                            .numeroOrdenType((BigDecimal) cols[0])
                            .codigoEstadoScript((BigDecimal) cols[1])
                            .descripcionEstadoScript((String) cols[2])

                            .build();

                    types.add(type);
                }
            }

            BigDecimal idProceso = callableStatement.getBigDecimal(18);
            Date pFechaProceso = callableStatement.getDate(19);
            BigDecimal pCodigoEstadoProceso = callableStatement.getBigDecimal(20);
            String pDescripcionEstadoProceso = callableStatement.getString(21);

            OutputProcesaType outputProcesaScript = OutputProcesaType.builder()
                    .idProceso(idProceso)
                    .pFechaProceso(pFechaProceso)
                    .pCodigoEstadoProceso(pCodigoEstadoProceso)
                    .pDescripcionEstadoProceso(pDescripcionEstadoProceso)
                    .listaType(types)
                    .build();

            return outputProcesaScript;

        } catch (
                SQLException e) {
            LogWrapper.error(log, "[ScriptService.procesarScript] Error: %s", e.getMessage());
            throw new ServiceException(e);
        }
    }
}
