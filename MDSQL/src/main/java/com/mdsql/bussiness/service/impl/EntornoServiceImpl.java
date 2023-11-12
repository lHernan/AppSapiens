package com.mdsql.bussiness.service.impl;

import com.mdsql.bussiness.entities.Entorno;
import com.mdsql.bussiness.service.EntornoService;
import com.mdsql.utils.MDSQLConstants;
import com.mdval.exceptions.ServiceException;
import com.mdval.utils.LogWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service(MDSQLConstants.ENTORNO_SERVICE)
@Slf4j
public class EntornoServiceImpl extends ServiceSupport implements EntornoService {

    @Autowired
    private DataSource dataSource;

    @Override
    public List<Entorno> consultarEntornos(String nomBBDD, String nomEsquema, String claveEncriptacion, String mcaHabilitado) throws ServiceException {
        String runSP = createCall("p_busca_entornos", MDSQLConstants.CALL_07_ARGS);
        
        Integer begin = 16;
        Integer end = begin + 12;
        String claveMandar = claveEncriptacion.substring(begin, end);

        try (Connection conn = dataSource.getConnection();
             CallableStatement callableStatement = conn.prepareCall(runSP)) {

            String typeEntorno = createCallType(MDSQLConstants.T_T_ENTORNO);
            String typeError = createCallTypeError();

            logProcedure(runSP, nomBBDD, nomEsquema, claveMandar, mcaHabilitado);

            callableStatement.setString(1, nomBBDD);
            callableStatement.setString(2, nomEsquema);
            callableStatement.setString(3, claveMandar);
            callableStatement.setString(4, mcaHabilitado);
            callableStatement.registerOutParameter(5, Types.ARRAY, typeEntorno);
            callableStatement.registerOutParameter(6, Types.INTEGER);
            callableStatement.registerOutParameter(7, Types.ARRAY, typeError);

            callableStatement.execute();

            Integer result = callableStatement.getInt(6);

            if (result == 0) {
                throw buildException(callableStatement.getArray(7));
            }

            List<Entorno> entornos = new ArrayList<>();
            Array arrayEntornos = callableStatement.getArray(5);

            if (arrayEntornos != null) {
                Object[] rows = (Object[]) arrayEntornos.getArray();
                for (Object row : rows) {
                    Object[] cols = ((oracle.jdbc.OracleStruct) row).getAttributes();

                    Entorno entorno = Entorno.builder()
                            .bbdd((String) cols[0])
                            .esquema((String) cols[1])
                            .password((String) cols[2])
                            .habilitado((String) cols[3])
                            .comentario((String) cols[4])
                            .build();

                    entornos.add(entorno);
                }
            }
            return entornos;
        } catch (SQLException e) {
            LogWrapper.error(log, "[EntornoService.consultarEntornos] Error:  %s", e.getMessage());
            throw new ServiceException(e);
        }
    }

    @Override
    public void guardarEntorno(String nomBBDD, String nomEsquema, String claveEncriptacion, String password, String mcaHabilitado, String comentario, String codUsr) throws ServiceException {
        String runSP = createCall("p_mnto_entorno", MDSQLConstants.CALL_09_ARGS);
        
        Integer begin = 16;
        Integer end = begin + 12;
        String claveMandar = claveEncriptacion.substring(begin, end);

        try (Connection conn = dataSource.getConnection();
             CallableStatement callableStatement = conn.prepareCall(runSP)) {

            String typeError = createCallTypeError();

            logProcedure(runSP, nomBBDD, nomEsquema, claveMandar, password, mcaHabilitado, comentario, codUsr);

            callableStatement.setString(1, nomBBDD);
            callableStatement.setString(2, nomEsquema);
            callableStatement.setString(3, claveMandar);
            callableStatement.setString(4, password);
            callableStatement.setString(5, mcaHabilitado);
            callableStatement.setString(6, comentario);
            callableStatement.setString(7, codUsr);

            callableStatement.registerOutParameter(8, Types.INTEGER);
            callableStatement.registerOutParameter(9, Types.ARRAY, typeError);

            callableStatement.execute();

            Integer result = callableStatement.getInt(8);

            if (result == 0) {
                throw buildException(callableStatement.getArray(9));
            }

        } catch (SQLException e) {
            LogWrapper.error(log, "[EntornoService.guardarEntorno] Error:  %s", e.getMessage());
            throw new ServiceException(e);
        }
    }
}
