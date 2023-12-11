package com.mdsql.bussiness.service;

import com.mdsql.bussiness.entities.TipoObjeto;
import com.mdsql.bussiness.entities.TipoParticula;
import com.mdval.exceptions.ServiceException;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author hcarreno
 */
public interface TipoObjetoService {

    List<String> consultarTiposObjeto() throws ServiceException;

    List<String> consultarTiposVariable() throws ServiceException;
}
