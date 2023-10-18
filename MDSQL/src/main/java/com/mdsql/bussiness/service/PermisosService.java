package com.mdsql.bussiness.service;

import com.mdsql.bussiness.entities.BBDD;
import com.mdsql.bussiness.entities.Modelo;
import com.mdsql.bussiness.entities.Permiso;
import com.mdsql.bussiness.entities.Sinonimo;
import com.mdval.exceptions.ServiceException;

import java.util.List;

/**
 * @author hcarreno
 */
public interface PermisosService {

    List<Permiso> consultaPermisosGenerales(Modelo modelo) throws ServiceException;

    List<Sinonimo> consultaSinonimosGenerales(Modelo modelo) throws ServiceException;

    List<String> consultarPermisosPorTipoObjeto(String tipoObjeto) throws ServiceException;

    void guardarPermiso(String codProyecto, String codUsrGrant, String valGrant, String desEntorno, String tipoObjeto, String mcaGrantOption, String mcaIncluirPDC, String mcaHabilitado, String codPeticion, String codUsr) throws ServiceException;

    void guardarSinonimo(String codProyecto, String codUsrGrant, String codOwnerSyn, String desEntorno, String tipoObjeto, String funcionNombre, String mcaIncluirPDC, String mcaHabilitado, String codPeticion, String codUsr) throws ServiceException;
}
