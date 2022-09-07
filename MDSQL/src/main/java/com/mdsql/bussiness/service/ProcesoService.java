package com.mdsql.bussiness.service;

import com.mdsql.bussiness.entities.InputSeleccionarProcesados;
import com.mdsql.bussiness.entities.Proceso;

import java.util.List;

/**
 * @author hcarreno
 */
public interface ProcesoService {

    List<Proceso> seleccionarProcesados(InputSeleccionarProcesados inputSeleccionarProcesados);

}
