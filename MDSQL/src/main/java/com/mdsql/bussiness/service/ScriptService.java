package com.mdsql.bussiness.service;

import java.math.BigDecimal;
import java.util.List;

import com.mdsql.bussiness.entities.BBDD;
import com.mdsql.bussiness.entities.InputProcesaScript;
import com.mdsql.bussiness.entities.OutputExcepcionScript;
import com.mdsql.bussiness.entities.OutputProcesaScript;
import com.mdsql.bussiness.entities.OutputRegistraEjecucion;
import com.mdsql.bussiness.entities.Script;

/**
 * @author hcarreno
 */
public interface ScriptService {

    OutputProcesaScript procesarScript(InputProcesaScript inputProcesaScript);

    OutputExcepcionScript excepcionScript(BigDecimal idProceso, BigDecimal numeroOrden, String txtComentario, String codigoUsuario);

    List<OutputRegistraEjecucion> executeScripts(BBDD bbdd, List<Script> listaVigente, List<Script> listaHistorico);

}
