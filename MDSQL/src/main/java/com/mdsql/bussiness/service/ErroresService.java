package com.mdsql.bussiness.service;

import com.mdsql.bussiness.entities.ErrorScript;
import com.mdsql.bussiness.entities.Modelo;
import com.mdsql.bussiness.entities.OutputErroresScript;
import com.mdsql.exceptions.ServiceException;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author hcarreno
 */
public interface ErroresService {

	OutputErroresScript consultaErroresScript(BigDecimal idProceso, BigDecimal numeroOrden);

	List<ErrorScript> consultaErroresType(BigDecimal idProceso, BigDecimal numeroOrden);

}
