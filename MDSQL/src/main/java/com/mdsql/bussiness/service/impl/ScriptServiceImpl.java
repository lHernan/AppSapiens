package com.mdsql.bussiness.service.impl;

import com.mdsql.bussiness.entities.BBDD;
import com.mdsql.bussiness.entities.DetObjeto;
import com.mdsql.bussiness.entities.InputDescartarScript;
import com.mdsql.bussiness.entities.InputProcesaScript;
import com.mdsql.bussiness.entities.InputReparaScript;
import com.mdsql.bussiness.entities.OutputDescartarScript;
import com.mdsql.bussiness.entities.OutputExcepcionScript;
import com.mdsql.bussiness.entities.OutputProcesaScript;
import com.mdsql.bussiness.entities.OutputRegistraEjecucion;
import com.mdsql.bussiness.entities.OutputReparaScript;
import com.mdsql.bussiness.entities.Script;
import com.mdsql.bussiness.entities.ScriptOld;
import com.mdsql.bussiness.entities.SeleccionHistorico;
import com.mdsql.bussiness.entities.TextoLinea;
import com.mdsql.bussiness.service.BBDDService;
import com.mdsql.bussiness.service.EjecucionService;
import com.mdsql.bussiness.service.ScriptService;
import com.mdsql.exceptions.ServiceException;
import com.mdsql.utils.ConfigurationSingleton;
import com.mdsql.utils.Constants;
import com.mdval.utils.AppGlobalSingleton;
import com.mdval.utils.AppHelper;
import com.mdval.utils.LogWrapper;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import oracle.jdbc.internal.OracleConnection;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.sql.Array;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Struct;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @author hcarreno
 */
@Service(Constants.SCRIPT_SERVICE)
@Slf4j
public class ScriptServiceImpl extends ServiceSupport implements ScriptService {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private BBDDService bbddService;

    @Autowired
    private EjecucionService ejecucionService;


    @Override
    public OutputProcesaScript procesarScript(InputProcesaScript inputProcesaScript) throws ServiceException {
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
            for (SeleccionHistorico data : inputProcesaScript.getListaObjetoHis()) {
                String mcaVigente = AppHelper.normalizeValueToCheck(data.getVigente());
                String mcaHistorico = AppHelper.normalizeValueToCheck(data.getHistorico());

                structObjHis[arrayIndexObjHis++] = conn.createStruct(recordObjHis,
                        new Object[]{data.getObjeto(), data.getTipo(), mcaVigente, mcaHistorico});
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
                            .nombreScript((String) cols[2])
                            .codigoEstadoScript((BigDecimal) cols[3])
                            .descripcionEstadoScript((String) cols[4])
                            .numeroOrden((BigDecimal) cols[5])
                            .nombreScriptLanza((String) cols[6])
                            .txtScriptLanza((String) cols[7])
                            .nombreScriptLog((String) cols[8])
                            .build();

                    fillScriptLines(script, cols);

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

    /**
     * @param script
     * @param cols
     * @throws SQLException
     */
    private void fillScriptLines(Script script, Object[] cols) throws SQLException {
        try {
            Array arrayScript = (Array) cols[1];
            if (!Objects.isNull(arrayScript)) {
                List<TextoLinea> arrayTextoLinea = new ArrayList<>();
                Object[] subs = (Object[]) arrayScript.getArray();
                for (Object sub : subs) {
                    Object[] texto_cols = ((oracle.jdbc.OracleStruct) sub).getAttributes();

                    TextoLinea textoLinea = TextoLinea.builder()
                            .valor((String) texto_cols[0])
                            .build();
                    arrayTextoLinea.add(textoLinea);
                }

                script.setLineasScript(arrayTextoLinea);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            LogWrapper.error(log, "[ScriptService.fillScriptLines] Error: %s", e.getMessage());
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

    @Override
    @SneakyThrows
    public List<OutputRegistraEjecucion> executeScripts(BBDD bbdd, List<Script> listaVigente, List<Script> listaHistorico) {
        String selectedRoute = (String) AppGlobalSingleton.getInstance().getProperty(Constants.SELECTED_ROUTE);
        String ruta = selectedRoute.concat(FileSystems.getDefault().getSeparator()); //TODO obtener  idProceso
        String nombreEsquema = StringUtils.EMPTY;
        String nombreBBDD = StringUtils.EMPTY;
        String codigoUsuario = (String) AppGlobalSingleton.getInstance().getProperty(Constants.COD_USR);
        List<OutputRegistraEjecucion> listOutputLogs = new ArrayList<>();
        ConfigurationSingleton configuration = ConfigurationSingleton.getInstance();
        String txtClaveEncriptada = configuration.getConfig(Constants.TOKEN).substring(17, 29);

        if (!CollectionUtils.isEmpty(listaVigente)) {
            listaVigente.sort(Comparator.comparing(Script::getNumeroOrden));
            for (Script script : listaVigente) {
                if (StringUtils.isNotBlank(script.getNombreScript())
                        && CollectionUtils.isNotEmpty(script.getLineasScript())) {
                    writeFileFromList(Paths.get(ruta.concat(script.getNombreScript())), script.getLineasScript());
                }
                if (StringUtils.isNotBlank(script.getNombreScriptLanza())
                        && StringUtils.isNotBlank(script.getTxtScriptLanza())) {
                    if (script.getNumeroOrden().compareTo(new BigDecimal("1")) == 0
                            || script.getNumeroOrden().compareTo(new BigDecimal("2")) == 0) {
                        nombreEsquema = bbdd.getNombreEsquema();
                        nombreBBDD = bbdd.getNombreBBDD();
                    }
                    String lanzaFile = ruta.concat(script.getNombreScriptLanza());
                    writeFileFromString(Paths.get(lanzaFile), script.getTxtScriptLanza().concat(System.lineSeparator()));
                    //String password = bbddService.consultaPasswordBBDD(nombreBBDD, nombreEsquema, txtClaveEncriptada); //TODO uncomment

                    executeLanzaFile(nombreEsquema, nombreBBDD, "vigente", lanzaFile);//TODO uncomment replace with password
                    String logFile = ruta.concat(script.getNombreScriptLog());
                    List<TextoLinea> logLinesList = readLogFile(logFile);
                    //TODO replace Bidecimal.ZERO with idProceso
//                    OutputRegistraEjecucion outputRegistraEjecucion = ejecucionService.registraEjecucion(BigDecimal.ZERO, script.getNumeroOrden(), codigoUsuario, logLinesList);
//                    listOutputLogs.add(outputRegistraEjecucion);

                }
            }
        }

        if (!CollectionUtils.isEmpty(listaHistorico)) {
            listaHistorico.sort(Comparator.comparing(Script::getNumeroOrden));
            for (Script script : listaHistorico) {
                if (StringUtils.isNotBlank(script.getNombreScript())
                        && CollectionUtils.isNotEmpty(script.getLineasScript())) {
                    writeFileFromList(Paths.get(ruta.concat(script.getNombreScript())), script.getLineasScript());
                }
                if (StringUtils.isNotBlank(script.getNombreScriptLanza())
                        && StringUtils.isNotBlank(script.getTxtScriptLanza())) {
                    if (script.getNumeroOrden().compareTo(new BigDecimal("3")) == 0
                            || script.getNumeroOrden().compareTo(new BigDecimal("4")) == 0) {
                        nombreEsquema = bbdd.getNombreEsquemaHis();
                        nombreBBDD = bbdd.getNombreBBDDHis();
                    }
                    String lanzaFile = ruta.concat(script.getNombreScriptLanza());
                    writeFileFromString(Paths.get(lanzaFile), script.getTxtScriptLanza().concat(System.lineSeparator()));
                    //String password = bbddService.consultaPasswordBBDD(nombreBBDD, nombreEsquema, txtClaveEncriptada); //TODO uncomment

                    executeLanzaFile(nombreEsquema, nombreBBDD, "vigente", lanzaFile);//TODO uncomment replace with password
                    String logFile = ruta.concat(script.getNombreScriptLog());
                    List<TextoLinea> logLinesList = readLogFile(logFile);
                    //TODO replace Bidecimal.ZERO with idProceso
//                    OutputRegistraEjecucion outputRegistraEjecucion = ejecucionService.registraEjecucion(BigDecimal.ZERO, script.getNumeroOrden(), codigoUsuario, logLinesList);
//                    listOutputLogs.add(outputRegistraEjecucion);
                }
            }
        }

        return listOutputLogs;
    }

    @Override
    @SneakyThrows
    public OutputReparaScript repararScript(InputReparaScript inputReparaScript) {
        String runSP = createCall("p_repara_script", Constants.CALL_21_ARGS);

        try (Connection conn = dataSource.getConnection();
             CallableStatement callableStatement = conn.prepareCall(runSP)) {

            String tableLinea = createCallType(Constants.T_T_LINEA);
            String recordLinea = createCallType(Constants.T_R_LINEA);

            String typeScriptOld = createCallType(Constants.T_T_SCRIPT_OLD);
            String typeScript = createCallType(Constants.T_T_SCRIPT);

            String typeError = createCallTypeError();

            logProcedure(runSP, inputReparaScript.getIdProceso(), inputReparaScript.getNumeroOrden(), inputReparaScript.getCodigoUsuario(), inputReparaScript.getMcaReprocesa(), inputReparaScript.getMcaMismoScript(),
                    inputReparaScript.getNombreScriptNew(), inputReparaScript.getTxtRutaNew(), inputReparaScript.getScriptNew(), inputReparaScript.getTxtComentario(), inputReparaScript.getNombreScriptParche(),
                    inputReparaScript.getTxtRutaParche(), inputReparaScript.getScriptParche());

            Struct[] structLineaScriptNew = new Struct[inputReparaScript.getScriptNew().size()];

            int arrayIndexLinea = 0;
            for (TextoLinea data : inputReparaScript.getScriptNew()) {
                structLineaScriptNew[arrayIndexLinea++] = conn.createStruct(recordLinea,
                        new Object[]{data.getValor()});
            }

            Struct[] structLineaScriptParche = new Struct[inputReparaScript.getScriptParche().size()];

            int arrayIndexLineaParche = 0;
            for (TextoLinea data : inputReparaScript.getScriptParche()) {
                structLineaScriptParche[arrayIndexLineaParche++] = conn.createStruct(recordLinea,
                        new Object[]{data.getValor()});
            }

            Array arrayLineaScriptNew = ((OracleConnection) conn).createOracleArray(tableLinea, structLineaScriptNew);
            Array arrayLineaScriptParche = ((OracleConnection) conn).createOracleArray(tableLinea, structLineaScriptParche);

            callableStatement.setBigDecimal(1, inputReparaScript.getIdProceso());
            callableStatement.setBigDecimal(2, inputReparaScript.getNumeroOrden());
            callableStatement.setString(3, inputReparaScript.getCodigoUsuario());
            callableStatement.setString(4, inputReparaScript.getMcaReprocesa());
            callableStatement.setString(5, inputReparaScript.getMcaMismoScript());
            callableStatement.setString(6, inputReparaScript.getNombreScriptNew());
            callableStatement.setString(7, inputReparaScript.getTxtRutaNew());
            callableStatement.setArray(8, arrayLineaScriptNew);
            callableStatement.setString(9, inputReparaScript.getTxtComentario());
            callableStatement.setString(10, inputReparaScript.getNombreScriptParche());
            callableStatement.setString(11, inputReparaScript.getTxtRutaParche());
            callableStatement.setArray(12, arrayLineaScriptParche);
            callableStatement.registerOutParameter(13, Types.VARCHAR);
            callableStatement.registerOutParameter(14, Types.ARRAY, tableLinea);
            callableStatement.registerOutParameter(15, Types.VARCHAR);
            callableStatement.registerOutParameter(16, Types.ARRAY, tableLinea);
            callableStatement.registerOutParameter(17, Types.VARCHAR);
            callableStatement.registerOutParameter(18, Types.ARRAY, typeScriptOld);
            callableStatement.registerOutParameter(19, Types.ARRAY, typeScript);

            callableStatement.registerOutParameter(20, Types.INTEGER);
            callableStatement.registerOutParameter(21, Types.ARRAY, typeError);

            callableStatement.execute();

            Integer result = callableStatement.getInt(20);

            if (result == 0) {
                throw buildException(callableStatement.getArray(21));
            }


            List<TextoLinea> scriptRepara = new ArrayList<>();
            Array arrayScriptRepara = callableStatement.getArray(14);

            if (arrayScriptRepara != null) {
                Object[] rows = (Object[]) arrayScriptRepara.getArray();
                for (Object row : rows) {
                    Object[] cols = ((oracle.jdbc.OracleStruct) row).getAttributes();

                    TextoLinea textoLinea = TextoLinea.builder()
                            .valor((String) cols[0])
                            .build();

                    scriptRepara.add(textoLinea);
                }
            }

            List<TextoLinea> scriptLanza = new ArrayList<>();
            Array arrayScriptLanza = callableStatement.getArray(16);

            if (arrayScriptLanza != null) {
                Object[] rows = (Object[]) arrayScriptLanza.getArray();
                for (Object row : rows) {
                    Object[] cols = ((oracle.jdbc.OracleStruct) row).getAttributes();

                    TextoLinea textoLinea = TextoLinea.builder()
                            .valor((String) cols[0])
                            .build();

                    scriptLanza.add(textoLinea);
                }
            }

            List<ScriptOld> listaScriptOld = new ArrayList<>();
            Array arrayScriptOld = callableStatement.getArray(18);

            if (arrayScriptOld != null) {
                Object[] rows = (Object[]) arrayScriptOld.getArray();
                for (Object row : rows) {
                    Object[] cols = ((oracle.jdbc.OracleStruct) row).getAttributes();

                    ScriptOld scriptOld = ScriptOld.builder()
                            .nombreScriptOld((String) cols[0])
                            .nombreScriptNew((String) cols[1])
                            .build();

                    listaScriptOld.add(scriptOld);
                }
            }

            List<Script> listaScript = new ArrayList<>();
            Array arrayScript = callableStatement.getArray(19);

            if (arrayScript != null) {
                Object[] rows = (Object[]) arrayScript.getArray();
                for (Object row : rows) {
                    Object[] cols = ((oracle.jdbc.OracleStruct) row).getAttributes();

                    Script script = Script.builder()
                            .tipoScript((String) cols[0])
                            .nombreScript((String) cols[2])
                            .codigoEstadoScript((BigDecimal) cols[3])
                            .descripcionEstadoScript((String) cols[4])
                            .numeroOrden((BigDecimal) cols[5])
                            .nombreScriptLanza((String) cols[6])
                            .txtScriptLanza((String) cols[7])
                            .nombreScriptLog((String) cols[8])
                            .build();

                    fillLineasScript(script, cols);

                    listaScript.add(script);
                }
            }

            String nombreScriptRepara = callableStatement.getString(13);
            String nombreScriptLanza = callableStatement.getString(15);
            String nombreLogRepara = callableStatement.getString(17);

            OutputReparaScript outputProcesaScript = OutputReparaScript.builder()
                    .nombreScriptRepara(nombreScriptRepara)
                    .scriptRepara(scriptRepara)
                    .nombreScriptLanza(nombreScriptLanza)
                    .scriptLanza(scriptLanza)
                    .nombreLogRepara(nombreLogRepara)
                    .listaScriptOld(listaScriptOld)
                    .listaScript(listaScript)
                    .build();

            return outputProcesaScript;

        } catch (
                SQLException e) {
            LogWrapper.error(log, "[ScriptService.repararScript] Error: %s", e.getMessage());
            throw new ServiceException(e);
        }
    }


    private void fillLineasScript(Script script, Object[] cols) throws SQLException {
        try {
            Array arrayLineasScript = (Array) cols[1];
            if (!Objects.isNull(arrayLineasScript)) {
                List<TextoLinea> textoLineas = new ArrayList<>();
                Object[] subs = (Object[]) arrayLineasScript.getArray();
                for (Object sub : subs) {
                    Object[] sub_cols = ((oracle.jdbc.OracleStruct) sub).getAttributes();

                    TextoLinea textoLinea = TextoLinea.builder()
                            .valor((String) sub_cols[0])
                            .build();
                    textoLineas.add(textoLinea);
                }

                script.setLineasScript(textoLineas);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            LogWrapper.error(log, "[ScriptService.fillLineasScript] Error: %s", e.getMessage());
        }
    }

    @Override
    @SneakyThrows
    public OutputDescartarScript descartarScript(InputDescartarScript inputDescartarScript) {
        String runSP = createCall("p_descartar_script", Constants.CALL_18_ARGS);

        try (Connection conn = dataSource.getConnection();
             CallableStatement callableStatement = conn.prepareCall(runSP)) {

            String tableLinea = createCallType(Constants.T_T_LINEA);
            String recordLinea = createCallType(Constants.T_R_LINEA);

            String typeScriptOld = createCallType(Constants.T_T_SCRIPT_OLD);
            String typeScript = createCallType(Constants.T_T_SCRIPT);

            String typeError = createCallTypeError();

            logProcedure(runSP, inputDescartarScript.getScript(), inputDescartarScript.getIdProceso(), inputDescartarScript.getCodigoUsuario(), inputDescartarScript.getNombreScript(), inputDescartarScript.getTipoCambio(),
                    inputDescartarScript.getNombreScriptNew(), inputDescartarScript.getTxtRutaNew(), inputDescartarScript.getTxtComentario(), inputDescartarScript.getNombreScriptParche(), inputDescartarScript.getTxtRutaParche(),
                    inputDescartarScript.getScriptParche());

            Struct[] structLineaScript = new Struct[inputDescartarScript.getScript().size()];

            int arrayIndexLinea = 0;
            for (TextoLinea data : inputDescartarScript.getScript()) {
                structLineaScript[arrayIndexLinea++] = conn.createStruct(recordLinea,
                        new Object[]{data.getValor()});
            }

            Struct[] structLineaScriptParche = new Struct[inputDescartarScript.getScriptParche().size()];

            int arrayIndexLineaParche = 0;
            for (TextoLinea data : inputDescartarScript.getScriptParche()) {
                structLineaScriptParche[arrayIndexLineaParche++] = conn.createStruct(recordLinea,
                        new Object[]{data.getValor()});
            }

            Array arrayLineaScript = ((OracleConnection) conn).createOracleArray(tableLinea, structLineaScript);
            Array arrayLineaScriptParche = ((OracleConnection) conn).createOracleArray(tableLinea, structLineaScriptParche);

            callableStatement.setArray(1, arrayLineaScript);
            callableStatement.setBigDecimal(2, inputDescartarScript.getIdProceso());
            callableStatement.setString(3, inputDescartarScript.getCodigoUsuario());
            callableStatement.setString(4, inputDescartarScript.getNombreScript());
            callableStatement.setString(5, inputDescartarScript.getTipoCambio());
            callableStatement.setString(6, inputDescartarScript.getNombreScriptNew());
            callableStatement.setString(7, inputDescartarScript.getTxtRutaNew());
            callableStatement.setString(8, inputDescartarScript.getTxtComentario());
            callableStatement.setString(9, inputDescartarScript.getNombreScriptParche());
            callableStatement.setString(10, inputDescartarScript.getTxtRutaParche());
            callableStatement.setArray(11, arrayLineaScriptParche);
            callableStatement.registerOutParameter(12, Types.ARRAY, typeScript);
            callableStatement.registerOutParameter(13, Types.ARRAY, typeScriptOld);
            callableStatement.registerOutParameter(14, Types.ARRAY, typeScript);
            callableStatement.registerOutParameter(15, Types.NUMERIC);
            callableStatement.registerOutParameter(16, Types.VARCHAR);

            callableStatement.registerOutParameter(17, Types.INTEGER);
            callableStatement.registerOutParameter(18, Types.ARRAY, typeError);

            callableStatement.execute();

            Integer result = callableStatement.getInt(17);

            if (result == 0) {
                throw buildException(callableStatement.getArray(18));
            }

            List<Script> listaParches = new ArrayList<>();
            Array arrayParches = callableStatement.getArray(12);

            if (arrayParches != null) {
                Object[] rows = (Object[]) arrayParches.getArray();
                for (Object row : rows) {
                    Object[] cols = ((oracle.jdbc.OracleStruct) row).getAttributes();

                    Script script = Script.builder()
                            .tipoScript((String) cols[0])
                            .nombreScript((String) cols[2])
                            .codigoEstadoScript((BigDecimal) cols[3])
                            .descripcionEstadoScript((String) cols[4])
                            .numeroOrden((BigDecimal) cols[5])
                            .nombreScriptLanza((String) cols[6])
                            .txtScriptLanza((String) cols[7])
                            .nombreScriptLog((String) cols[8])
                            .build();

                    fillLineasScript(script, cols);

                    listaParches.add(script);
                }
            }

            List<ScriptOld> listaScriptOld = new ArrayList<>();
            Array arrayScriptOld = callableStatement.getArray(13);

            if (arrayScriptOld != null) {
                Object[] rows = (Object[]) arrayScriptOld.getArray();
                for (Object row : rows) {
                    Object[] cols = ((oracle.jdbc.OracleStruct) row).getAttributes();

                    ScriptOld scriptOld = ScriptOld.builder()
                            .nombreScriptOld((String) cols[0])
                            .nombreScriptNew((String) cols[1])
                            .build();

                    listaScriptOld.add(scriptOld);
                }
            }

            List<Script> listaScriptNew = new ArrayList<>();

            Array arrayScriptNew = callableStatement.getArray(14);

            if (arrayScriptNew != null) {
                Object[] rows = (Object[]) arrayScriptNew.getArray();
                for (Object row : rows) {
                    Object[] cols = ((oracle.jdbc.OracleStruct) row).getAttributes();

                    Script script = Script.builder()
                            .tipoScript((String) cols[0])
                            .nombreScript((String) cols[2])
                            .codigoEstadoScript((BigDecimal) cols[3])
                            .descripcionEstadoScript((String) cols[4])
                            .numeroOrden((BigDecimal) cols[5])
                            .nombreScriptLanza((String) cols[6])
                            .txtScriptLanza((String) cols[7])
                            .nombreScriptLog((String) cols[8])
                            .build();

                    fillLineasScript(script, cols);

                    listaScriptNew.add(script);
                }
            }

            BigDecimal codigoEstadoProceso = callableStatement.getBigDecimal(13);
            String descripcionEstadoProceso = callableStatement.getString(15);

            OutputDescartarScript outputDescartarScript = OutputDescartarScript.builder()
                    .listaParches(listaParches)
                    .listaScriptOld(listaScriptOld)
                    .listaScriptNew(listaScriptNew)
                    .codigoEstadoProceso(codigoEstadoProceso)
                    .descripcionEstadoProceso(descripcionEstadoProceso)
                    .build();

            return outputDescartarScript;

        } catch (
                SQLException e) {
            LogWrapper.error(log, "[ScriptService.descartarScript] Error: %s", e.getMessage());
            throw new ServiceException(e);
        }
    }

    @Override
    @SneakyThrows
    public List<DetObjeto> detalleObjetosScripts(BigDecimal idProceso, BigDecimal numeroOrden) {
        String runSP = createCall("p_detalle_objetos_scripts", Constants.CALL_05_ARGS);

        try (Connection conn = dataSource.getConnection();
             CallableStatement callableStatement = conn.prepareCall(runSP)) {

            String typeDetObjeto = createCallType(Constants.T_T_DET_OBJETO);

            String typeError = createCallTypeError();

            logProcedure(runSP, idProceso, numeroOrden);

            callableStatement.setBigDecimal(1, idProceso);
            callableStatement.setBigDecimal(2, numeroOrden);
            callableStatement.registerOutParameter(3, Types.ARRAY, typeDetObjeto);

            callableStatement.registerOutParameter(4, Types.INTEGER);
            callableStatement.registerOutParameter(5, Types.ARRAY, typeError);

            callableStatement.execute();

            Integer result = callableStatement.getInt(4);

            if (result == 0) {
                throw buildException(callableStatement.getArray(5));
            }

            List<DetObjeto> detObjetoList = new ArrayList<>();
            Array arrayDetObjeto = callableStatement.getArray(3);

            if (arrayDetObjeto != null) {
                Object[] rows = (Object[]) arrayDetObjeto.getArray();
                for (Object row : rows) {
                    Object[] cols = ((oracle.jdbc.OracleStruct) row).getAttributes();

                    DetObjeto detObjeto = DetObjeto.builder()
                            .numeroSentencia((BigDecimal) cols[0])
                            .nombreObjetoPadre((String) cols[1])
                            .tipoObjetoPadre((String) cols[2])
                            .tipoAccionPadre((String) cols[3])
                            .nombreObjeto((String) cols[4])
                            .nombreObjetoDestino((String) cols[5])
                            .tipoObjeto((String) cols[6])
                            .tipoAccion((String) cols[7])
                            .tipoDato((String) cols[8])
                            .numeroLongitud((BigDecimal) cols[9])
                            .numeroDecimal((BigDecimal) cols[10])
                            .build();

                    detObjetoList.add(detObjeto);
                }
            }
            return detObjetoList;
        } catch (
                SQLException e) {
            LogWrapper.error(log, "[ScriptService.detalleObjetosScripts] Error: %s", e.getMessage());
            throw new ServiceException(e);
        }
    }

    @SneakyThrows
    private void executeLanzaFile(String nombreEsquema, String nombreBBDD, String password, String fileLocation) {

        String connection = String.format(Constants.FORMATO_CONEXION, nombreEsquema, password, nombreBBDD);
        ProcessBuilder processBuilder = new ProcessBuilder(Constants.SQL_PLUS,
                connection, String.format(Constants.FORMATO_FICHERO, fileLocation));

        processBuilder.redirectErrorStream(true);
        Process process = processBuilder.start();

        BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String currentLine;

        LogWrapper.debug(log, "[ScriptService.executeScriptFile] Inicio Ejecucion fichero: %s", fileLocation);
        while (((currentLine = in.readLine()) != null)) {
            LogWrapper.debug(log, " ".concat(currentLine));
        }

        in.close();
        int exitCode = process.waitFor();

        LogWrapper.debug(log, "[ScriptService.executeScriptFile] Fin Ejecucion exitCode: %s", exitCode);
    }

    @SneakyThrows
    private static void writeFileFromString(Path path, String content) {
        Files.write(path, content.getBytes(StandardCharsets.US_ASCII), StandardOpenOption.CREATE);
    }

    @SneakyThrows
    private static void writeFileFromList(Path path, List<TextoLinea> textoLineaList) {
        List<String> scriptLines = new ArrayList<>();
        for (TextoLinea texto : textoLineaList) {
            scriptLines.add(texto.getValor());
        }
        Files.write(path, scriptLines, StandardCharsets.US_ASCII, StandardOpenOption.CREATE);
    }

    @SneakyThrows
    private static List<TextoLinea> readLogFile(String logPath) {
        List<TextoLinea> logLinesList = new ArrayList<>();
        List<String> allLines = Files.readAllLines(Paths.get(logPath));
        for (String line : allLines) {
            TextoLinea textoLinea = TextoLinea.builder().valor(line).build();
            logLinesList.add(textoLinea);
        }
        return logLinesList;
    }

}
