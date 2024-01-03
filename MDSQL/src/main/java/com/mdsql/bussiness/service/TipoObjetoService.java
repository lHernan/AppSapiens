package com.mdsql.bussiness.service;

import java.util.List;

import com.mdval.exceptions.ServiceException;

/**
 * @author hcarreno
 */
public interface TipoObjetoService {

    List<String> consultarTiposObjeto() throws ServiceException;

    List<String> consultarTiposVariable() throws ServiceException;
}
