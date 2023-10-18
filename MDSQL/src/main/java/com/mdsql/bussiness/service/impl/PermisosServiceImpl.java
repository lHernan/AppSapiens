package com.mdsql.bussiness.service.impl;

import com.mdsql.bussiness.entities.Modelo;
import com.mdsql.bussiness.entities.Permiso;
import com.mdsql.bussiness.entities.Sinonimo;
import com.mdsql.bussiness.service.PermisosService;
import com.mdsql.utils.MDSQLConstants;
import com.mdval.exceptions.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service(MDSQLConstants.PERMISOS_SERVICE)
@Slf4j
public class PermisosServiceImpl implements PermisosService {
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
        return Collections.emptyList();
    }

    @Override
    public void guardarPermiso(String codProyecto, String codUsrGrant, String valGrant, String desEntorno, String tipoObjeto, String mcaGrantOption, String mcaIncluirPDC, String mcaHabilitado, String codPeticion, String codUsr) throws ServiceException {

    }

    @Override
    public void guardarSinonimo(String codProyecto, String codUsrGrant, String codOwnerSyn, String desEntorno, String tipoObjeto, String funcionNombre, String mcaIncluirPDC, String mcaHabilitado, String codPeticion, String codUsr) throws ServiceException {

    }
}
