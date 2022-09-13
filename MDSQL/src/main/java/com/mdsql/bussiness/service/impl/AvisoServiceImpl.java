package com.mdsql.bussiness.service.impl;

import java.math.BigDecimal;
import java.sql.Array;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mdsql.bussiness.entities.Aviso;
import com.mdsql.bussiness.service.AvisoService;
import com.mdsql.exceptions.ServiceException;
import com.mdsql.utils.Constants;
import com.mdsql.utils.LogWrapper;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;


/**
 * @author hcarreno
 */
@Service(Constants.AVISO_SERVICE)
@Slf4j
public class AvisoServiceImpl extends ServiceSupport implements AvisoService {

    @Autowired
    private DataSource dataSource;


    @Override
    @SneakyThrows
    public List<Aviso> consultaAvisosModelo(String codigoProyecto) {
        String runSP = createCall("p_con_avisos_modelo", Constants.CALL_04_ARGS);

        try (Connection conn = dataSource.getConnection();
             CallableStatement callableStatement = conn.prepareCall(runSP)) {

            String typeAviso = createCallType(Constants.T_T_AVISO);
            String typeError = createCallTypeError();

            logProcedure(runSP, codigoProyecto);

            callableStatement.setString(1, codigoProyecto);
            callableStatement.registerOutParameter(2, Types.ARRAY, typeAviso);
            callableStatement.registerOutParameter(3, Types.INTEGER);
            callableStatement.registerOutParameter(4, Types.ARRAY, typeError);

            callableStatement.execute();

            Integer result = callableStatement.getInt(3);

            if (result == 0) {
                throw buildException(callableStatement.getArray(4));
            }

            List<Aviso> avisos = new ArrayList<>();
            Array arrayAvisos = callableStatement.getArray(2);

            if (arrayAvisos != null) {
                Object[] rows = (Object[]) arrayAvisos.getArray();
                for (Object row : rows) {
                    Object[] cols = ((oracle.jdbc.OracleStruct) row).getAttributes();

                    Aviso aviso = Aviso.builder()
                            .codigoNivelAviso((BigDecimal) cols[0])
                            .descripcionNivelAviso((String) cols[1])
                            .codigoAviso((BigDecimal) cols[2])
                            .descripcionAviso((String) cols[3])
                            .txtAviso((String) cols[4])
                            .codigoPeticion((String) cols[5])
                            .fechaAlta((java.util.Date) cols[6])
                            .codigoUsrAlta((String) cols[7])
                            .mcaHabilitado((String) cols[8])
                            .fechaActualizacion((Date) cols[9])
                            .codigoUsuario((String) cols[10])
                            .build();

                    avisos.add(aviso);
                }
            }
            return avisos;
        } catch (SQLException e) {
            LogWrapper.error(log, "[AvisoService.consultaAvisosModelo] Error:  %s", e.getMessage());
            throw new ServiceException(e);
        }
    }

}
