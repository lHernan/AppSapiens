package com.mdsql.bussiness.service.impl;

import com.mdsql.bussiness.entities.CampoGlosario;
import com.mdsql.bussiness.entities.DetValidacion;
import com.mdsql.bussiness.entities.InformeCambios;
import com.mdsql.bussiness.entities.InformeValidacion;
import com.mdsql.bussiness.service.InformeService;
import com.mdsql.exceptions.ServiceException;
import com.mdsql.utils.Constants;
import com.mdval.utils.LogWrapper;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.Array;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

/**
 * @author hcarreno
 */
@Service(Constants.INFORME_SERVICE)
@Slf4j
public class InformeServiceImpl extends ServiceSupport implements InformeService {

    @Autowired
    private DataSource dataSource;

    @Override
    @SneakyThrows
    public InformeValidacion generarInformeValidacion(BigDecimal codigoValidacion) {
        String runSP = createCall("p_generar_informe_val", Constants.CALL_06_ARGS);

        try (Connection conn = dataSource.getConnection();
             CallableStatement callableStatement = conn.prepareCall(runSP)) {

            String typeDetValidacion = createCallType(Constants.T_T_DET_VALIDACION);
            String typeCampoGlosario = createCallType(Constants.T_T_CAMPO_GLOSARIO);
            String typeError = createCallTypeError();

            logProcedure(runSP, codigoValidacion);

            callableStatement.setBigDecimal(1, codigoValidacion);
            callableStatement.registerOutParameter(2, Types.ARRAY, typeDetValidacion);
            callableStatement.registerOutParameter(3, Types.ARRAY, typeDetValidacion);
            callableStatement.registerOutParameter(4, Types.ARRAY, typeCampoGlosario);
            callableStatement.registerOutParameter(5, Types.INTEGER);
            callableStatement.registerOutParameter(6, Types.ARRAY, typeError);

            callableStatement.execute();

            Integer result = callableStatement.getInt(5);

            if (result == 0) {
                throw buildException(callableStatement.getArray(6));
            }

            Array arrayErroneos = callableStatement.getArray(2);
            Array arrayOtraDefinicion = callableStatement.getArray(3);
            Array arrayDefinicionGlosarios = callableStatement.getArray(4);

            List<DetValidacion> listaErroneos = getListaErroneos(arrayErroneos);
            List<DetValidacion> listaOtraDefinicion = getListaOtraDefinicion(arrayOtraDefinicion);
            List<CampoGlosario> listaDefinicionGlosario = getListaDefinicionGlosario(arrayDefinicionGlosarios);

            return InformeValidacion.builder()
                    .listaErroneos(listaErroneos)
                    .listaOtraDefinicion(listaOtraDefinicion)
                    .listaDefinicionGlosario(listaDefinicionGlosario)
                    .build();

        } catch (SQLException e) {
            LogWrapper.error(log, "[InformeService.generarInformeValidacion] Error: %s", e.getMessage());
            throw new ServiceException(e);
        }
    }

    @Override
    @SneakyThrows
    public List<InformeCambios> informeCambios(String codigoProyecto, Date fechaDesde, Date fechaHasta) {
        String runSP = createCall("p_informe_cambios", Constants.CALL_06_ARGS);

        try (Connection conn = dataSource.getConnection();
             CallableStatement callableStatement = conn.prepareCall(runSP)) {

            String typeInformeCambios = createCallType(Constants.T_T_INFORME_CAMBIOS);
            String typeError = createCallTypeError();

            logProcedure(runSP, codigoProyecto, fechaDesde, fechaHasta);

            callableStatement.setString(1, codigoProyecto);
            callableStatement.setDate(2, fechaDesde);
            callableStatement.setDate(3, fechaHasta);
            callableStatement.registerOutParameter(4, Types.ARRAY, typeInformeCambios);
            callableStatement.registerOutParameter(5, Types.INTEGER);
            callableStatement.registerOutParameter(6, Types.ARRAY, typeError);

            callableStatement.execute();

            Integer result = callableStatement.getInt(5);

            if (result == 0) {
                throw buildException(callableStatement.getArray(6));
            }

            List<InformeCambios> informeCambios = new ArrayList<>();
            Array arrayInformeCambios = callableStatement.getArray(4);

            if (arrayInformeCambios != null) {
                Object[] rows = (Object[]) arrayInformeCambios.getArray();
                for (Object row : rows) {
                    Object[] cols = ((oracle.jdbc.OracleStruct) row).getAttributes();
                    InformeCambios historicoProceso = InformeCambios.builder()
                            .codigoPeticion((String) cols[0])
                            .idProceso((BigDecimal) cols[1])
                            .nombreObjetoPadre((String) cols[2])
                            .tipoObjetoPadre((String) cols[3])
                            .tipoAccionPadre((String) cols[4])
                            .nombreObjeto((String) cols[5])
                            .nombreObjetoDestino((String) cols[6])
                            .tipoObjeto((String) cols[7])
                            .tipoAccion((String) cols[8])
                            .tipoDato((String) cols[9])
                            .numeroLongitud((BigDecimal) cols[10])
                            .numeroDecimal((BigDecimal) cols[11])
                            .descripcionEstadoProceso((String) cols[12])
                            .fechaProceso((Date) cols[13])
                            .codigoSubProyecto((String) cols[14])
                            .codigoUsuarioPeticion((String) cols[15])
                            .codigoUsuario((String) cols[16])
                            .descripcionEstadoScript((String) cols[17])
                            .nombreScript((String) cols[18])
                            .build();
                    informeCambios.add(historicoProceso);
                }
            }
            return informeCambios;
        } catch (SQLException e) {
            LogWrapper.error(log, "[InformeService.informeCambios] Error:  %s", e.getMessage());
            throw new ServiceException(e);
        }

    }

    @SneakyThrows
    private List<DetValidacion> getListaErroneos(Array arrayErroneos) {
        List<DetValidacion> listaErroneos = new ArrayList<>();
        if (arrayErroneos != null) {
            Object[] rows = (Object[]) arrayErroneos.getArray();
            for (Object row : rows) {
                Object[] cols = ((oracle.jdbc.OracleStruct) row).getAttributes();

                DetValidacion detValidacion = DetValidacion.builder()
                        .numeroValidacion((BigDecimal) cols[0])
                        .numeroElementoValid((BigDecimal) cols[1])
                        .descripcionElemento((String) cols[2])
                        .nombreElemento((String) cols[3])
                        .tipoDato((String) cols[4])
                        .numeroLongitud((BigDecimal) cols[5])
                        .numeroDecimal((BigDecimal) cols[6])
                        .codigoEstadoValid((BigDecimal) cols[7])
                        .txtDescripcionValid((String) cols[8])
                        .build();

                listaErroneos.add(detValidacion);
            }
        }
        return listaErroneos;
    }

    @SneakyThrows
    private List<DetValidacion> getListaOtraDefinicion(Array arrayOtraDefinicion) {
        List<DetValidacion> listaOtraDefinicion = new ArrayList<>();
        if (arrayOtraDefinicion != null) {
            Object[] rows = (Object[]) arrayOtraDefinicion.getArray();
            for (Object row : rows) {
                Object[] cols = ((oracle.jdbc.OracleStruct) row).getAttributes();

                DetValidacion detValidacion = DetValidacion.builder()
                        .numeroValidacion((BigDecimal) cols[0])
                        .numeroElementoValid((BigDecimal) cols[1])
                        .descripcionElemento((String) cols[2])
                        .nombreElemento((String) cols[3])
                        .tipoDato((String) cols[4])
                        .numeroLongitud((BigDecimal) cols[5])
                        .numeroDecimal((BigDecimal) cols[6])
                        .codigoEstadoValid((BigDecimal) cols[7])
                        .txtDescripcionValid((String) cols[8])
                        .build();

                listaOtraDefinicion.add(detValidacion);
            }
        }
        return listaOtraDefinicion;
    }

    @SneakyThrows
    private List<CampoGlosario> getListaDefinicionGlosario(Array arrayDefinicionGlosarios) {
        List<CampoGlosario> listaDefinicionGlosario = new ArrayList<>();
        if (arrayDefinicionGlosarios != null) {
            Object[] rows = (Object[]) arrayDefinicionGlosarios.getArray();
            for (Object row : rows) {
                Object[] cols = ((oracle.jdbc.OracleStruct) row).getAttributes();

                CampoGlosario campoGlosario = CampoGlosario.builder()
                        .nombreColumna((String) cols[0])
                        .tipoDato((String) cols[1])
                        .numeroLongitud((BigDecimal) cols[2])
                        .numeroDecimal((BigDecimal) cols[3])
                        .codigoGlosario((BigDecimal) cols[4])
                        .mcaExcepcion((String) cols[5])
                        .txtComentario((String) cols[6])
                        .txtExcepcion((String) cols[7])
                        .codigoUsuario((String) cols[8])
                        .fechaActualizacion((Date) cols[9])
                        .build();

                listaDefinicionGlosario.add(campoGlosario);
            }
        }
        return listaDefinicionGlosario;
    }
}
