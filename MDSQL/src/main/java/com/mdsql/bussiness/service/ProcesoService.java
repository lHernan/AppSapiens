package com.mdsql.bussiness.service;

import java.util.List;

import com.mdsql.bussiness.entities.InputSeleccionarProcesados;
import com.mdsql.bussiness.entities.Proceso;
import com.mdsql.bussiness.entities.SeleccionHistorico;
import com.mdsql.exceptions.ServiceException;

/**
 * @author hcarreno
 */
public interface ProcesoService {

	/**
	 * @param inputSeleccionarProcesados
	 * @return
	 * @throws ServiceException
	 */
	List<Proceso> seleccionarProcesados(InputSeleccionarProcesados inputSeleccionarProcesados) throws ServiceException;

	/**
	 * @param codProyecto
	 * @param lineas
	 * @return
	 * @throws ServiceException
	 */
	List<SeleccionHistorico> seleccionarHistorico(String codProyecto, List<String> lineas) throws ServiceException;

	/**
	 * @param listaObjetos
	 * @param codigoProyecto
	 * @param codigoPeticion
	 * @param codigoUsuario
	 * @return
	 */
	void altaHistorico(List<SeleccionHistorico> listaObjetos, String codigoProyecto, String codigoPeticion, String codigoUsuario) throws ServiceException;
}
