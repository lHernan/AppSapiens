package com.mdsql.bussiness.service;

import com.mdsql.bussiness.entities.InputProcesaType;
import com.mdsql.bussiness.entities.OutputProcesaType;

/**
 * @author hcarreno
 */
public interface TypeService {

    OutputProcesaType procesarType(InputProcesaType inputProcesaType);

}
