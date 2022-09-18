package com.mdsql.bussiness.service;

import java.util.List;

import com.mdsql.bussiness.entities.Modelo;
import com.mdsql.exceptions.ServiceException;

/**
 * @author hcarreno
 */
public interface ModeloService {
	// TODO refactor, delete old methods
	List<Modelo> consultaModelos(String codigoProyecto, String nombreModelo, String codigoSubProyecto)
			throws ServiceException;

}
