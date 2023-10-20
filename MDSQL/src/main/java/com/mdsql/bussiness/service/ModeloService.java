package com.mdsql.bussiness.service;

import com.mdsql.bussiness.entities.NivelImportancia;
import com.mdsql.bussiness.entities.OutputConsultaModelos;
import com.mdval.exceptions.ServiceException;

import java.util.List;

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
	OutputConsultaModelos consultaModelos(String codigoProyecto, String nombreModelo, String codigoSubProyecto)
			throws ServiceException;
}
