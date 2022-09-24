package com.mdsql.bussiness.service.impl;

import java.math.BigDecimal;
import java.sql.Array;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.Date;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mdsql.bussiness.entities.InputSeleccionarProcesados;
import com.mdsql.bussiness.entities.Proceso;
import com.mdsql.bussiness.service.ProcesoService;
import com.mdsql.exceptions.ServiceException;
import com.mdsql.utils.Constants;
import com.mdval.utils.LogWrapper;

import lombok.extern.slf4j.Slf4j;


/**
 * @author hcarreno
 */
@Service(Constants.PROCESO_SERVICE)
@Slf4j
public class ProcesoServiceImpl extends ServiceSupport implements ProcesoService {

    @Autowired
    private DataSource dataSource;

    @Override
    public List<Proceso> seleccionarProcesados(InputSeleccionarProcesados inputSeleccionarProcesados) throws ServiceException {
        String runSP = createCall("p_sel_procesados", Constants.CALL_12_ARGS);

        try (Connection conn = dataSource.getConnection();
             CallableStatement callableStatement = conn.prepareCall(runSP)) {

            String typeProceso = createCallType(Constants.T_T_PROCESO);
            String typeError = createCallTypeError();

            logProcedure(runSP, inputSeleccionarProcesados.getPCodigoPeticion(), inputSeleccionarProcesados.getPCodigoUsuarioPeticion(),
                    inputSeleccionarProcesados.getPFechaInicio(), inputSeleccionarProcesados.getPFechaFin(),
                    inputSeleccionarProcesados.getPCodigoUsuario(), inputSeleccionarProcesados.getPCodigoproyecto(),
                    inputSeleccionarProcesados.getPCodigoSubProyecto(), inputSeleccionarProcesados.getPDescripcionEstadoProceso(),
                    inputSeleccionarProcesados.getPUltimas());

            callableStatement.setString(1, inputSeleccionarProcesados.getPCodigoPeticion());
            callableStatement.setString(2, inputSeleccionarProcesados.getPCodigoUsuarioPeticion());
            callableStatement.setDate(3, (java.sql.Date) inputSeleccionarProcesados.getPFechaInicio());
            callableStatement.setDate(4, (java.sql.Date) inputSeleccionarProcesados.getPFechaFin());
            callableStatement.setString(5, inputSeleccionarProcesados.getPCodigoUsuario());
            callableStatement.setString(6, inputSeleccionarProcesados.getPCodigoproyecto());
            callableStatement.setString(7,  inputSeleccionarProcesados.getPCodigoSubProyecto());
            callableStatement.setString(8,  inputSeleccionarProcesados.getPDescripcionEstadoProceso());
            callableStatement.setBigDecimal(9,  inputSeleccionarProcesados.getPUltimas());
            callableStatement.registerOutParameter(10, Types.ARRAY, typeProceso);
            callableStatement.registerOutParameter(11, Types.INTEGER);
            callableStatement.registerOutParameter(12, Types.ARRAY, typeError);

            callableStatement.execute();

            Integer result = callableStatement.getInt(11);

            if (result == 0) {
                throw buildException(callableStatement.getArray(12));
            }

            List<Proceso> procesos = new ArrayList<>();
            Array arrayProcesos = callableStatement.getArray(10);

            if (arrayProcesos != null) {
                Object[] rows = (Object[]) arrayProcesos.getArray();
                for (Object row : rows) {
                    Object[] cols = ((oracle.jdbc.OracleStruct) row).getAttributes();

                    Proceso proceso = Proceso.builder()
                            .idProceso((BigDecimal) cols[0])
                            .codigoPeticion((String) cols[1])
                            .codigoUsrPeticion((String) cols[2])
                            .fechaInicio((Date) cols[3])
                            .codigoUsr((String) cols[4])
                            .codigoEstadoProceso((BigDecimal) cols[5])
                            .descripcionEstadoProceso((String) cols[6])
                            .mcaInicial((String) cols[7])
                            .txtDescripcion((String) cols[8])
                            .txtObservacionEntrega((String) cols[9])
                            .mcaErrores((String) cols[10])
                            .build();

                    procesos.add(proceso);
                }
            }

            return procesos;
        } catch (SQLException e) {
            LogWrapper.error(log, "[ProcesoService.seleccionarProcesados] Error:  %s", e.getMessage());
            throw new ServiceException(e);
        }
    }
}
