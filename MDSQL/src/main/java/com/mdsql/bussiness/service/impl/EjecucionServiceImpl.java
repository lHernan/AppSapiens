package com.mdsql.bussiness.service.impl;

import com.mdsql.bussiness.entities.OutputRegistraEjecucion;
import com.mdsql.bussiness.entities.TextoLinea;
import com.mdsql.bussiness.service.EjecucionService;
import com.mdsql.exceptions.ServiceException;
import com.mdsql.utils.Constants;
import com.mdval.utils.LogWrapper;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import oracle.jdbc.driver.OracleConnection;
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
import java.util.List;


/**
 * @author hcarreno
 */
@Service(Constants.EJECUCION_SERVICE)
@Slf4j
public class EjecucionServiceImpl extends ServiceSupport implements EjecucionService {

    @Autowired
    private DataSource dataSource;


    @Override
    @SneakyThrows
    public OutputRegistraEjecucion registraEjecucion(BigDecimal idProceso, BigDecimal numeroOrden, String codigoUsuario, List<TextoLinea> lineas) {
        String runSP = createCall("p_registra_ejecucion", Constants.CALL_13_ARGS);

        try (Connection conn = dataSource.getConnection();
             CallableStatement callableStatement = conn.prepareCall(runSP)) {

            String tableLinea = createCallType(Constants.T_T_LINEA);
            String recordLinea = createCallType(Constants.T_R_LINEA);

            String typeError = createCallTypeError();

            logProcedure(runSP, idProceso, numeroOrden, codigoUsuario, lineas);

            Struct[] structLinea = new Struct[lineas.size()];

            int arrayIndexLinea = 0;
            for (TextoLinea data : lineas) {
                structLinea[arrayIndexLinea++] = conn.createStruct(recordLinea,
                        new Object[]{data.getValor()});
            }

            Array arrayLinea = ((OracleConnection) conn).createOracleArray(tableLinea, structLinea);

            callableStatement.setBigDecimal(1, idProceso);
            callableStatement.setBigDecimal(2, numeroOrden);
            callableStatement.setString(3, codigoUsuario);
            callableStatement.setArray(4, arrayLinea);
            callableStatement.registerOutParameter(5, Types.NUMERIC);
            callableStatement.registerOutParameter(6, Types.VARCHAR);
            callableStatement.registerOutParameter(7, Types.VARCHAR);
            callableStatement.registerOutParameter(8, Types.NUMERIC);
            callableStatement.registerOutParameter(9, Types.VARCHAR);
            callableStatement.registerOutParameter(10, Types.VARCHAR);
            callableStatement.registerOutParameter(11, Types.VARCHAR);

            callableStatement.registerOutParameter(12, Types.INTEGER);
            callableStatement.registerOutParameter(13, Types.ARRAY, typeError);

            callableStatement.execute();

            Integer result = callableStatement.getInt(12);

            if (result == 0) {
                throw buildException(callableStatement.getArray(13));
            }

            BigDecimal codigoEstadoProceso = callableStatement.getBigDecimal(5);
            String descripcionEstadoProceso = callableStatement.getString(6);
            String nombreScript = callableStatement.getString(7);
            BigDecimal codigoEstadoScript = callableStatement.getBigDecimal(8);
            String descripcionEstadoScript = callableStatement.getString(9);
            String txtCuadreOperacion = callableStatement.getString(10);
            String txtCuadreObj = callableStatement.getString(11);

            OutputRegistraEjecucion outputRegistraEjecucion = OutputRegistraEjecucion.builder()
                    .codigoEstadoProceso(codigoEstadoProceso)
                    .descripcionEstadoProceso(descripcionEstadoProceso)
                    .nombreScript(nombreScript)
                    .codigoEstadoScript(codigoEstadoScript)
                    .descripcionEstadoScript(descripcionEstadoScript)
                    .txtCuadreOperacion(txtCuadreOperacion)
                    .txtCuadreObj(txtCuadreObj)
                    .build();

            return outputRegistraEjecucion;

        } catch (
                SQLException e) {
            LogWrapper.error(log, "[TypeService.registraEjecucion] Error: %s", e.getMessage());
            throw new ServiceException(e);
        }
    }

}
