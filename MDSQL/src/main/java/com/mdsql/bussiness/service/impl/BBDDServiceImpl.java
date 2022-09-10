package com.mdsql.bussiness.service.impl;

import com.mdsql.bussiness.entities.BBDD;
import com.mdsql.bussiness.service.BBDDService;
import com.mdsql.exceptions.ServiceException;
import com.mdsql.utils.Constants;
import com.mdsql.utils.LogWrapper;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
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
@Service(Constants.BBDD_SERVICE)
@Slf4j
public class BBDDServiceImpl extends ServiceSupport implements BBDDService {

    @Autowired
    private DataSource dataSource;

    @Override
    @SneakyThrows
    public List<BBDD> consultaBBDDModelo(String codigoProyecto) {
        String runSP = createCall("p_con_bbdd_modelo", Constants.CALL_04_ARGS);

        try (Connection conn = dataSource.getConnection();
             CallableStatement callableStatement = conn.prepareCall(runSP)) {

            String typeBBDD = createCallType(Constants.T_T_BBDD);
            String typeError = createCallTypeError();

            logProcedure(runSP, codigoProyecto);

            callableStatement.setString(1, codigoProyecto);
            callableStatement.registerOutParameter(2, Types.ARRAY, typeBBDD);
            callableStatement.registerOutParameter(3, Types.INTEGER);
            callableStatement.registerOutParameter(4, Types.ARRAY, typeError);

            callableStatement.execute();

            Integer result = callableStatement.getInt(3);

            if (result == 0) {
                throw buildException(callableStatement.getArray(4));
            }

            List<BBDD> bbdds = new ArrayList<>();
            Array arrayBBDDs = callableStatement.getArray(2);

            if (arrayBBDDs != null) {
                Object[] rows = (Object[]) arrayBBDDs.getArray();
                for (Object row : rows) {
                    Object[] cols = ((oracle.jdbc.OracleStruct) row).getAttributes();

                    BBDD bbdd = BBDD.builder()
                            .nombreBBDD((String) cols[0])
                            .nombreEsquema((String) cols[1])
                            .nombreBBDDHis((String) cols[2])
                            .nombreEsquemaHis((String) cols[3])
                            .mcaDefecto((String) cols[4])
                            .build();

                    bbdds.add(bbdd);
                }
            }
            return bbdds;
        } catch (SQLException e) {
            LogWrapper.error(log, "[BBDDService.consultaBBDDModelo] Error:  %s", e.getMessage());
            throw new ServiceException(e);
        }
    }

}
