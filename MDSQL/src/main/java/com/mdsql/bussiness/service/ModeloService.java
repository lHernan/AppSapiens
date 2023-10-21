package com.mdsql.bussiness.service;

import com.mdsql.bussiness.entities.Modelo;
import com.mdsql.bussiness.entities.NivelImportancia;
import com.mdsql.bussiness.entities.OutputConsultaModelos;
import com.mdsql.bussiness.entities.Variable;
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

    List<Variable> consultaVariables(Modelo modelo) throws ServiceException;

    void actualizarVariableModelo(String codigoProyecto, String codigoVariable, String entorno, String bbdd, String tipoVariable, String valorVariable, String valorSustituir, String codigoPeticion, String mcaInterno, String mcaHabilitado, String codUsr) throws ServiceException;
}
