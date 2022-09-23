package com.mdsql.bussiness.service;

import java.util.List;

import com.mdsql.bussiness.entities.Aviso;
import com.mdsql.exceptions.ServiceException;

/**
 * @author hcarreno
 */
public interface AvisoService {


    List<Aviso> consultaAvisosModelo(String codigoProyecto) throws ServiceException;

}
