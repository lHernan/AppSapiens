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

}
