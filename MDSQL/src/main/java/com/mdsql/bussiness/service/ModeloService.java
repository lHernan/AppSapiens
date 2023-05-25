package com.mdsql.bussiness.service;

import java.util.List;

import com.mdsql.bussiness.entities.Modelo;
import com.mdval.exceptions.ServiceException;

/**
 * @author hcarreno
 */
public interface ModeloService {
	
	/**
	 * @param codigoProyecto
	 * @param nombreModelo
	 * @param codigoSubProyecto
	 * @return
	 * @throws ServiceException
	 */
	List<Modelo> consultaModelos(String codigoProyecto, String nombreModelo, String codigoSubProyecto)
			throws ServiceException;

}
