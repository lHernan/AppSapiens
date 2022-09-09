package com.mdsql.bussiness.service;

import com.mdsql.bussiness.entities.InputProcesaScript;
import com.mdsql.bussiness.entities.OutputProcesaScript;

/**
 * @author hcarreno
 */
public interface ScriptService {

    OutputProcesaScript procesarScript(InputProcesaScript inputProcesaScript);

}
