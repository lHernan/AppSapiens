package com.mdsql.bussiness.service;

import java.math.BigDecimal;

import com.mdsql.bussiness.entities.InputProcesaScript;
import com.mdsql.bussiness.entities.OutputExcepcionScript;
import com.mdsql.bussiness.entities.OutputProcesaScript;

/**
 * @author hcarreno
 */
public interface ScriptService {

    OutputProcesaScript procesarScript(InputProcesaScript inputProcesaScript);

    OutputExcepcionScript excepcionScript(BigDecimal idProceso, BigDecimal numeroOrden, String txtComentario, String codigoUsuario);

    boolean executeScriptFile(String nombreEsquema, String nombreBBDD, String password, String fileLocation);

}
