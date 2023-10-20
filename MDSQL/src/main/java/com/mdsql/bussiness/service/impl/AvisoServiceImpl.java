package com.mdsql.bussiness.service.impl;

import java.math.BigDecimal;
import java.sql.Array;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import com.mdsql.bussiness.entities.NivelImportancia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mdsql.bussiness.entities.Aviso;
import com.mdsql.bussiness.service.AvisoService;
import com.mdsql.utils.MDSQLConstants;
import com.mdval.exceptions.ServiceException;
import com.mdval.utils.LogWrapper;

import lombok.extern.slf4j.Slf4j;


/**
 * @author hcarreno
 */
@Service(MDSQLConstants.AVISO_SERVICE)
@Slf4j
public class AvisoServiceImpl extends ServiceSupport implements AvisoService {

    @Autowired
    private DataSource dataSource;


    @Override
    public List<Aviso> consultaAvisosModelo(String codigoProyecto) throws ServiceException {
        String runSP = createCall("p_con_avisos_modelo", MDSQLConstants.CALL_04_ARGS);

        try (Connection conn = dataSource.getConnection();
             CallableStatement callableStatement = conn.prepareCall(runSP)) {

            String typeAviso = createCallType(MDSQLConstants.T_T_AVISO);
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

                    NivelImportancia nivelImportancia = NivelImportancia.builder()
                            .codigoNivelAviso((BigDecimal) cols[0])
                            .descripcionNivelAviso((String) cols[1])
                            .build();
                    aviso.setNivelImportancia(nivelImportancia);

                    avisos.add(aviso);
                }
            }
            return avisos;
        } catch (SQLException e) {
            LogWrapper.error(log, "[AvisoService.consultaAvisosModelo] Error:  %s", e.getMessage());
            throw new ServiceException(e);
        }
    }

    @Override
    public List<NivelImportancia> consultaNivelesImportancia() throws ServiceException {
        return Collections.emptyList();
    }

    @Override
    public void altaAviso(String codigoProyecto, String descripcionAviso, String txtAviso, String codNivelAviso, String codPeticion, String codUsr) throws ServiceException {

    }

    @Override
    public void modificarAviso(String codigoProyecto, BigDecimal codigoAviso, String descripcionAviso, String txtAviso, String codNivelAviso, String mcaHabilitado, String codPeticion, String codUsr) throws ServiceException {

    }

}
