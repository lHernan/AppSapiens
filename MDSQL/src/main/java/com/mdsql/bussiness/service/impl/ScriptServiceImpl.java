package com.mdsql.bussiness.service.impl;

import com.mdsql.bussiness.entities.InputProcesaScript;
import com.mdsql.bussiness.entities.ObjetoHis;
import com.mdsql.bussiness.entities.OutputExcepcionScript;
import com.mdsql.bussiness.entities.OutputProcesaScript;
import com.mdsql.bussiness.entities.Script;
import com.mdsql.bussiness.entities.TextoLinea;
import com.mdsql.bussiness.service.ScriptService;
import com.mdsql.exceptions.ServiceException;
import com.mdsql.utils.Constants;
import com.mdsql.utils.LogWrapper;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import oracle.jdbc.internal.OracleConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
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

/**
 * @author hcarreno
 */
@Service(Constants.SCRIPT_SERVICE)
@Slf4j
public class ScriptServiceImpl extends ServiceSupport implements ScriptService {

    @Autowired
    private DataSource dataSource;

    @Override
    @SneakyThrows
    public OutputProcesaScript procesarScript(InputProcesaScript inputProcesaScript) {
        String runSP = createCall("p_procesa_script", Constants.CALL_24_ARGS);

        try (Connection conn = dataSource.getConnection();
             CallableStatement callableStatement = conn.prepareCall(runSP)) {

            String tableLinea = createCallType(Constants.T_T_LINEA);
            String recordLinea = createCallType(Constants.T_R_LINEA);

            String tableObjHis = createCallType(Constants.T_T_OBJ_HIS);
            String recordObjHis = createCallType(Constants.T_R_OBJ_HIS);

            String typeScript = createCallType(Constants.T_T_SCRIPT);

            String typeError = createCallTypeError();

            logProcedure(runSP, inputProcesaScript.getLineasScript(), inputProcesaScript.getPCodigoProyecto(), inputProcesaScript.getPCodigoSubProyecto(), inputProcesaScript.getPCodigoPeticion(), inputProcesaScript.getPCodigoDemanda(),
                    inputProcesaScript.getPCodigoDemanda(), inputProcesaScript.getPCodigoUsr(), inputProcesaScript.getPCodigoUsrPeticion(), inputProcesaScript.getPMcaReprocesa(), inputProcesaScript.getPNombreBBDD(),
                    inputProcesaScript.getPNombreEsquema(), inputProcesaScript.getPMcaHIS(), inputProcesaScript.getPNombreBBDDHIS(), inputProcesaScript.getPNombreEsquemaHis(), inputProcesaScript.getPNombreFichaEntrada(),
                    inputProcesaScript.getPTxtRutaEntrada(), inputProcesaScript.getListaObjetoHis(), inputProcesaScript.getPTxtRutaEntrada());

            Struct[] structLinea = new Struct[inputProcesaScript.getLineasScript().size()];

            int arrayIndexLinea = 0;
            for (TextoLinea data : inputProcesaScript.getLineasScript()) {
                structLinea[arrayIndexLinea++] = conn.createStruct(recordLinea,
                        new Object[]{data.getValor()});
            }

            Array arrayLinea = ((OracleConnection) conn).createOracleArray(tableLinea, structLinea);

            Struct[] structObjHis = new Struct[inputProcesaScript.getListaObjetoHis().size()];

            int arrayIndexObjHis = 0;
            for (ObjetoHis data : inputProcesaScript.getListaObjetoHis()) {
                structObjHis[arrayIndexObjHis++] = conn.createStruct(recordObjHis,
                        new Object[]{data.getNombreObjeto(), data.getTipoObjeto(), data.getDescripcionTipoObjeto(), data.getMcaHis()});
            }

            Array arrayObjHis = ((OracleConnection) conn).createOracleArray(tableObjHis, structObjHis);

            callableStatement.setArray(1, arrayLinea);
            callableStatement.setString(2, inputProcesaScript.getPCodigoProyecto());
            callableStatement.setString(3, inputProcesaScript.getPCodigoSubProyecto());
            callableStatement.setString(4, inputProcesaScript.getPCodigoPeticion());
            callableStatement.setString(5, inputProcesaScript.getPCodigoDemanda());
            callableStatement.setString(6, inputProcesaScript.getPCodigoUsr());
            callableStatement.setString(7, inputProcesaScript.getPCodigoUsrPeticion());
            callableStatement.setString(8, inputProcesaScript.getPMcaReprocesa());
            callableStatement.setString(9, inputProcesaScript.getPNombreBBDD());
            callableStatement.setString(10, inputProcesaScript.getPNombreEsquema());
            callableStatement.setString(11, inputProcesaScript.getPMcaHIS());
            callableStatement.setString(12, inputProcesaScript.getPNombreBBDDHIS());
            callableStatement.setString(13, inputProcesaScript.getPNombreEsquemaHis());
            callableStatement.setString(14, inputProcesaScript.getPNombreFichaEntrada());
            callableStatement.setString(15, inputProcesaScript.getPTxtRutaEntrada());
            callableStatement.setArray(16, arrayObjHis);
            callableStatement.setString(17, inputProcesaScript.getPTxtDescripcion());
            callableStatement.registerOutParameter(18, Types.NUMERIC);
            callableStatement.registerOutParameter(19, Types.DATE);
            callableStatement.registerOutParameter(20, Types.NUMERIC);
            callableStatement.registerOutParameter(21, Types.VARCHAR);
            callableStatement.registerOutParameter(22, Types.ARRAY, typeScript);

            callableStatement.registerOutParameter(23, Types.INTEGER);
            callableStatement.registerOutParameter(24, Types.ARRAY, typeError);

            callableStatement.execute();

            Integer result = callableStatement.getInt(18);

            if (result == 0) {
                throw buildException(callableStatement.getArray(19));
            }


            List<Script> scripts = new ArrayList<>();
            Array arrayScripts = callableStatement.getArray(22);

            if (arrayScripts != null) {
                Object[] rows = (Object[]) arrayScripts.getArray();
                for (Object row : rows) {
                    Object[] cols = ((oracle.jdbc.OracleStruct) row).getAttributes();

                    Script script = Script.builder()
                            .tipoScript((String) cols[0])
                            .txtScript((String) cols[1])
                            .nombreScript((String) cols[2])
                            .codigoEstadoScript((String) cols[3])
                            .descripcionEstadoScript((String) cols[4])
                            .numeroOrden((BigDecimal) cols[5])
                            .nombreScriptLanza((String) cols[6])
                            .txtScriptLanza((String) cols[7])
                            .nombreScriptLog((String) cols[8])
                            .build();

                    scripts.add(script);
                }
            }

            BigDecimal idProceso = callableStatement.getBigDecimal(18);
            Date pFechaProceso = callableStatement.getDate(19);
            BigDecimal pCodigoEstadoProceso = callableStatement.getBigDecimal(20);
            String pDescripcionEstadoProceso = callableStatement.getString(21);

            OutputProcesaScript outputProcesaScript = OutputProcesaScript.builder()
                    .idProceso(idProceso)
                    .pFechaProceso(pFechaProceso)
                    .pCodigoEstadoProceso(pCodigoEstadoProceso)
                    .pDescripcionEstadoProceso(pDescripcionEstadoProceso)
                    .listaScripts(scripts)
                    .build();

            return outputProcesaScript;

        } catch (SQLException e) {
            LogWrapper.error(log, "[ScriptService.procesarScript] Error: %s", e.getMessage());
            throw new ServiceException(e);
        }
    }

    @Override
    @SneakyThrows
    public OutputExcepcionScript excepcionScript(BigDecimal idProceso, BigDecimal numeroOrden, String txtComentario, String codigoUsuario) {
        String runSP = createCall("p_excepcion_script", Constants.CALL_10_ARGS);

        try (Connection conn = dataSource.getConnection();
             CallableStatement callableStatement = conn.prepareCall(runSP)) {


            String typeError = createCallTypeError();

            logProcedure(runSP, idProceso, numeroOrden, txtComentario, codigoUsuario);


            callableStatement.setBigDecimal(1, idProceso);
            callableStatement.setBigDecimal(2, numeroOrden);
            callableStatement.setString(3, txtComentario);
            callableStatement.setString(4, codigoUsuario);
            callableStatement.registerOutParameter(5, Types.NUMERIC);
            callableStatement.registerOutParameter(6, Types.VARCHAR);
            callableStatement.registerOutParameter(7, Types.NUMERIC);
            callableStatement.registerOutParameter(8, Types.VARCHAR);

            callableStatement.registerOutParameter(9, Types.INTEGER);
            callableStatement.registerOutParameter(10, Types.ARRAY, typeError);

            callableStatement.execute();

            Integer result = callableStatement.getInt(9);

            if (result == 0) {
                throw buildException(callableStatement.getArray(10));
            }

            BigDecimal codigoEstadoProceso = callableStatement.getBigDecimal(5);
            String descripcionEstadoProceso = callableStatement.getString(6);
            BigDecimal codigoEstadoScript = callableStatement.getBigDecimal(7);
            String descripcionEstadoScript = callableStatement.getString(8);

            OutputExcepcionScript outputExcepcionScript = OutputExcepcionScript.builder()
                    .codigoEstadoProceso(codigoEstadoProceso)
                    .descripcionEstadoProceso(descripcionEstadoProceso)
                    .codigoEstadoScript(codigoEstadoScript)
                    .descripcionEstadoScript(descripcionEstadoScript)
                    .build();

            return outputExcepcionScript;

        } catch (SQLException e) {
            LogWrapper.error(log, "[ScriptService.excepcionScript] Error: %s", e.getMessage());
            throw new ServiceException(e);
        }
    }

}
