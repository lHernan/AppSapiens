package com.mdsql.bussiness.service;

import java.util.List;

import com.mdsql.bussiness.entities.InputSeleccionarProcesados;
import com.mdsql.bussiness.entities.Proceso;
import com.mdsql.exceptions.ServiceException;

/**
 * @author hcarreno
 */
public interface ProcesoService {

    List<Proceso> seleccionarProcesados(InputSeleccionarProcesados inputSeleccionarProcesados) throws ServiceException;

}
