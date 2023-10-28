package com.mdsql.bussiness.service.impl;

import com.mdsql.bussiness.entities.Modelo;
import com.mdsql.bussiness.entities.Permiso;
import com.mdsql.bussiness.entities.Sinonimo;
import com.mdsql.bussiness.service.PermisosService;
import com.mdsql.utils.MDSQLConstants;
import com.mdval.exceptions.ServiceException;
import com.mdval.utils.LogWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service(MDSQLConstants.PERMISOS_SERVICE)
@Slf4j
public class PermisosServiceImpl extends ServiceSupport implements PermisosService {

    @Autowired
    private DataSource dataSource;

    @Override
    public List<Permiso> consultaPermisosGenerales(Modelo modelo) throws ServiceException {
        return Collections.emptyList();
    }

    @Override
    public List<Sinonimo> consultaSinonimosGenerales(Modelo modelo) throws ServiceException {
        return Collections.emptyList();
    }

    @Override
    public List<String> consultarPermisosPorTipoObjeto(String tipoObjeto) throws ServiceException {
        String runSP = createCall("p_con_per_tipo_obj", MDSQLConstants.CALL_04_ARGS);

        try (Connection conn = dataSource.getConnection();
             CallableStatement callableStatement = conn.prepareCall(runSP)) {

            String typePermiso = createCallType(MDSQLConstants.T_T_PERMISO);
            String typeError = createCallTypeError();

            logProcedure(runSP, tipoObjeto);

            callableStatement.setString(1, tipoObjeto);
            callableStatement.registerOutParameter(2, Types.ARRAY, typePermiso);
            callableStatement.registerOutParameter(3, Types.INTEGER);
            callableStatement.registerOutParameter(4, Types.ARRAY, typeError);

            callableStatement.execute();

            Integer result = callableStatement.getInt(3);

            if (result == 0) {
                throw buildException(callableStatement.getArray(4));
            }

            List<String> tipos = new ArrayList<>();
            Array arrayTipo = callableStatement.getArray(2);

            if (arrayTipo != null) {
                Object[] rows = (Object[]) arrayTipo.getArray();
                for (Object row : rows) {
                    Object[] cols = ((oracle.jdbc.OracleStruct) row).getAttributes();
                    String tipo = (String) cols[0];
                    tipos.add(tipo);
                }
            }
            return tipos;
        } catch (SQLException e) {
            LogWrapper.error(log, "[PermisosService.consultarPermisosPorTipoObjeto] Error:  %s", e.getMessage());
            throw new ServiceException(e);
        }
    }

    @Override
    public void guardarPermiso(String codProyecto, String codUsrGrant, String valGrant, String desEntorno, String tipoObjeto, String mcaGrantOption, String mcaIncluirPDC, String mcaHabilitado, String codPeticion, String codUsr) throws ServiceException {

    }

    @Override
    public void guardarSinonimo(String codProyecto, String codUsrGrant, String codOwnerSyn, String desEntorno, String tipoObjeto, String funcionNombre, String mcaIncluirPDC, String mcaHabilitado, String codPeticion, String codUsr) throws ServiceException {

    }
}
