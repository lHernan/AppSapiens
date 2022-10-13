package com.mdsql.bussiness.service.impl;

import java.sql.Array;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mdsql.bussiness.entities.Estado;
import com.mdsql.bussiness.entities.Operacion;
import com.mdsql.bussiness.entities.TipoObjeto;
import com.mdsql.bussiness.service.ConsultaService;
import com.mdsql.utils.Constants;
import com.mdval.exceptions.ServiceException;
import com.mdval.utils.LogWrapper;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

/**
 * @author hcarreno
 */
@Service(Constants.CONSULTA_SERVICE)
@Slf4j
public class ConsultaServiceImpl extends ServiceSupport implements ConsultaService {

    @Autowired
    private DataSource dataSource;

    @Override
    @SneakyThrows
    public List<TipoObjeto> consultaTiposObjeto() {
        String runSP = createCall("p_con_tipos_objeto", Constants.CALL_03_ARGS);

        try (Connection conn = dataSource.getConnection();
             CallableStatement callableStatement = conn.prepareCall(runSP)) {

            String typeTipoObjeto = createCallType(Constants.T_T_TIP_OBJETO);
            String typeError = createCallTypeError();

            logProcedure(runSP);

            callableStatement.registerOutParameter(1, Types.ARRAY, typeTipoObjeto);
            callableStatement.registerOutParameter(2, Types.INTEGER);
            callableStatement.registerOutParameter(3, Types.ARRAY, typeError);

            callableStatement.execute();

            Integer result = callableStatement.getInt(2);

            if (result == 0) {
                throw buildException(callableStatement.getArray(3));
            }

            List<TipoObjeto> tipoObjetos = new ArrayList<>();
            Array arrayTipoObjetos = callableStatement.getArray(1);

            if (arrayTipoObjetos != null) {
                Object[] rows = (Object[]) arrayTipoObjetos.getArray();
                for (Object row : rows) {
                    Object[] cols = ((oracle.jdbc.OracleStruct) row).getAttributes();
                    TipoObjeto tipoObjeto = TipoObjeto.builder()
                            .tipoObjeto((String) cols[0])
                            .build();
                    tipoObjetos.add(tipoObjeto);
                }
            }
            return tipoObjetos;
        } catch (SQLException e) {
            LogWrapper.error(log, "[ConsultaService.consultaTiposObjeto] Error:  %s", e.getMessage());
            throw new ServiceException(e);
        }
    }

    @Override
    @SneakyThrows
    public List<Estado> consultaEstadosProcesado() {
        String runSP = createCall("p_con_estados_proc", Constants.CALL_03_ARGS);

        try (Connection conn = dataSource.getConnection();
             CallableStatement callableStatement = conn.prepareCall(runSP)) {

            String typeEstado = createCallType(Constants.T_T_ESTADO);
            String typeError = createCallTypeError();

            logProcedure(runSP);

            callableStatement.registerOutParameter(1, Types.ARRAY, typeEstado);
            callableStatement.registerOutParameter(2, Types.INTEGER);
            callableStatement.registerOutParameter(3, Types.ARRAY, typeError);

            callableStatement.execute();

            Integer result = callableStatement.getInt(2);

            if (result == 0) {
                throw buildException(callableStatement.getArray(3));
            }

            List<Estado> estados = new ArrayList<>();
            Array arrayEstados = callableStatement.getArray(1);

            if (arrayEstados != null) {
                Object[] rows = (Object[]) arrayEstados.getArray();
                for (Object row : rows) {
                    Object[] cols = ((oracle.jdbc.OracleStruct) row).getAttributes();
                    Estado estado = Estado.builder()
                            .codigoEstado((String) cols[0])
                            .descripcionEstado((String) cols[1])
                            .build();
                    estados.add(estado);
                }
            }
            return estados;
        } catch (SQLException e) {
            LogWrapper.error(log, "[ConsultaService.consultaEstadosProcesado] Error:  %s", e.getMessage());
            throw new ServiceException(e);
        }
    }

    @Override
    @SneakyThrows
    public List<Estado> consultaEstadosScript() {
        String runSP = createCall("p_con_estados_scrip", Constants.CALL_03_ARGS);

        try (Connection conn = dataSource.getConnection();
             CallableStatement callableStatement = conn.prepareCall(runSP)) {

            String typeOperacion = createCallType(Constants.T_T_OPERACION);
            String typeError = createCallTypeError();

            logProcedure(runSP);

            callableStatement.registerOutParameter(1, Types.ARRAY, typeOperacion);
            callableStatement.registerOutParameter(2, Types.INTEGER);
            callableStatement.registerOutParameter(3, Types.ARRAY, typeError);

            callableStatement.execute();

            Integer result = callableStatement.getInt(2);

            if (result == 0) {
                throw buildException(callableStatement.getArray(3));
            }

            List<Estado> estados = new ArrayList<>();
            Array arrayEstados = callableStatement.getArray(1);

            if (arrayEstados != null) {
                Object[] rows = (Object[]) arrayEstados.getArray();
                for (Object row : rows) {
                    Object[] cols = ((oracle.jdbc.OracleStruct) row).getAttributes();
                    Estado estado = Estado.builder()
                            .codigoEstado((String) cols[0])
                            .descripcionEstado((String) cols[1])
                            .build();
                    estados.add(estado);
                }
            }
            return estados;
        } catch (SQLException e) {
            LogWrapper.error(log, "[ConsultaService.consultaEstadosScript] Error:  %s", e.getMessage());
            throw new ServiceException(e);
        }
    }

    @Override
    @SneakyThrows
    public List<Operacion> consultaOperaciones() {
        String runSP = createCall("p_con_operaciones", Constants.CALL_03_ARGS);

        try (Connection conn = dataSource.getConnection();
             CallableStatement callableStatement = conn.prepareCall(runSP)) {

            String typeEstado = createCallType(Constants.T_T_ESTADO);
            String typeError = createCallTypeError();

            logProcedure(runSP);

            callableStatement.registerOutParameter(1, Types.ARRAY, typeEstado);
            callableStatement.registerOutParameter(2, Types.INTEGER);
            callableStatement.registerOutParameter(3, Types.ARRAY, typeError);

            callableStatement.execute();

            Integer result = callableStatement.getInt(2);

            if (result == 0) {
                throw buildException(callableStatement.getArray(3));
            }

            List<Operacion> operaciones = new ArrayList<>();
            Array arrayOperaciones = callableStatement.getArray(1);

            if (arrayOperaciones != null) {
                Object[] rows = (Object[]) arrayOperaciones.getArray();
                for (Object row : rows) {
                    Object[] cols = ((oracle.jdbc.OracleStruct) row).getAttributes();
                    Operacion operacion = Operacion.builder()
                            .tipoAccion((String) cols[0])
                            .descripcionAccion((String) cols[1])
                            .build();
                    operaciones.add(operacion);
                }
            }
            return operaciones;
        } catch (SQLException e) {
            LogWrapper.error(log, "[ConsultaService.consultaOperaciones] Error:  %s", e.getMessage());
            throw new ServiceException(e);
        }
    }
}
