package com.mdsql.bussiness.service;

import com.mdsql.bussiness.entities.InputProcesaScript;
import com.mdsql.bussiness.entities.OutputExcepcionScript;
import com.mdsql.bussiness.entities.OutputProcesaScript;

import java.math.BigDecimal;

/**
 * @author hcarreno
 */
public interface ScriptService {

    OutputProcesaScript procesarScript(InputProcesaScript inputProcesaScript);

    OutputExcepcionScript excepcionScript(BigDecimal idProceso, BigDecimal numeroOrden, String txtComentario, String codigoUsuario);

}
