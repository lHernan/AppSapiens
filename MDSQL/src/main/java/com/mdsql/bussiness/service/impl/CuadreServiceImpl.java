package com.mdsql.bussiness.service.impl;

import com.mdsql.bussiness.entities.CuadreObjeto;
import com.mdsql.bussiness.entities.CuadreOperacion;
import com.mdsql.bussiness.service.CuadreService;
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
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

/**
 * @author hcarreno
 */
@Service(Constants.CUADRE_SERVICE)
@Slf4j
public class CuadreServiceImpl extends ServiceSupport implements CuadreService {

    @Autowired
    private DataSource dataSource;

    @Override
    @SneakyThrows
    public List<CuadreOperacion> consultaCuadreOperacionesScript(BigDecimal idProceso, BigDecimal numeroOrden) {
        String runSP = createCall("p_con_cuadre_oper_script", Constants.CALL_05_ARGS);

        try (Connection conn = dataSource.getConnection();
             CallableStatement callableStatement = conn.prepareCall(runSP)) {

            String typeCuadreOperaciones = createCallType(Constants.T_T_CUADRE_OPER);
            String typeError = createCallTypeError();

            logProcedure(runSP, idProceso, numeroOrden);

            callableStatement.setBigDecimal(1, idProceso);
            callableStatement.setBigDecimal(2, numeroOrden);
            callableStatement.registerOutParameter(3, Types.ARRAY, typeCuadreOperaciones);
            callableStatement.registerOutParameter(4, Types.INTEGER);
            callableStatement.registerOutParameter(5, Types.ARRAY, typeError);

            callableStatement.execute();

            Integer result = callableStatement.getInt(4);

            if (result == 0) {
                throw buildException(callableStatement.getArray(5));
            }

            List<CuadreOperacion> cuadreOperacions = new ArrayList<>();
            Array arrayCuadreOperaciones = callableStatement.getArray(3);

            if (arrayCuadreOperaciones != null) {
                Object[] rows = (Object[]) arrayCuadreOperaciones.getArray();
                for (Object row : rows) {
                    Object[] cols = ((oracle.jdbc.OracleStruct) row).getAttributes();

                    CuadreOperacion cuadreOperacion = CuadreOperacion.builder()
                            .tipoObjeto((String) cols[0])
                            .tipoAccion((String) cols[1])
                            .numeroOperacionBBDD((BigDecimal) cols[2])
                            .numeroOperacionScript((BigDecimal) cols[3])
                            .build();

                    cuadreOperacions.add(cuadreOperacion);
                }
            }

            return cuadreOperacions;
        } catch (SQLException e) {
            LogWrapper.error(log, "[CuadreService.consultaCuadreOperacionesScript] Error:  %s", e.getMessage());
            throw new ServiceException(e);
        }
    }

    @Override
    @SneakyThrows
    public List<CuadreObjeto> consultaCuadreOperacionesObjetoScript(BigDecimal idProceso, BigDecimal numeroOrden) {
        String runSP = createCall("p_con_cuadre_obj_script", Constants.CALL_05_ARGS);

        try (Connection conn = dataSource.getConnection();
             CallableStatement callableStatement = conn.prepareCall(runSP)) {

            String typeCuadreObjetoScript = createCallType(Constants.T_T_CUADRE_OBJ);
            String typeError = createCallTypeError();

            logProcedure(runSP, idProceso, numeroOrden);

            callableStatement.setBigDecimal(1, idProceso);
            callableStatement.setBigDecimal(2, numeroOrden);
            callableStatement.registerOutParameter(3, Types.ARRAY, typeCuadreObjetoScript);
            callableStatement.registerOutParameter(4, Types.INTEGER);
            callableStatement.registerOutParameter(5, Types.ARRAY, typeError);

            callableStatement.execute();

            Integer result = callableStatement.getInt(4);

            if (result == 0) {
                throw buildException(callableStatement.getArray(5));
            }

            List<CuadreObjeto> cuadreObjetos = new ArrayList<>();
            Array arrayCuadreOperaciones = callableStatement.getArray(3);

            if (arrayCuadreOperaciones != null) {
                Object[] rows = (Object[]) arrayCuadreOperaciones.getArray();
                for (Object row : rows) {
                    Object[] cols = ((oracle.jdbc.OracleStruct) row).getAttributes();

                    CuadreObjeto cuadreObjeto = CuadreObjeto.builder()
                            .tipoObjeto((String) cols[0])
                            .tipoAccion((String) cols[1])
                            .numeroOperacionBBDD((BigDecimal) cols[2])
                            .numeroOperacionScript((BigDecimal) cols[3])
                            .build();

                    cuadreObjetos.add(cuadreObjeto);
                }
            }

            return cuadreObjetos;
        } catch (SQLException e) {
            LogWrapper.error(log, "[CuadreService.consultaCuadreOperacionesObjetoScript] Error:  %s", e.getMessage());
            throw new ServiceException(e);
        }
    }
}
