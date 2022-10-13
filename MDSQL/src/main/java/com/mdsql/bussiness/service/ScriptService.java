package com.mdsql.bussiness.service;

import java.math.BigDecimal;
import java.util.List;

import com.mdsql.bussiness.entities.BBDD;
import com.mdsql.bussiness.entities.DetObjeto;
import com.mdsql.bussiness.entities.InputDescartarScript;
import com.mdsql.bussiness.entities.InputProcesaScript;
import com.mdsql.bussiness.entities.InputReparaScript;
import com.mdsql.bussiness.entities.OutputDescartarScript;
import com.mdsql.bussiness.entities.OutputExcepcionScript;
import com.mdsql.bussiness.entities.OutputProcesaScript;
import com.mdsql.bussiness.entities.OutputRegistraEjecucion;
import com.mdsql.bussiness.entities.OutputReparaScript;
import com.mdsql.bussiness.entities.Script;
import com.mdval.exceptions.ServiceException;

/**
 * @author hcarreno
 */
public interface ScriptService {

    OutputProcesaScript procesarScript(InputProcesaScript inputProcesaScript) throws ServiceException;

    OutputExcepcionScript excepcionScript(BigDecimal idProceso, BigDecimal numeroOrden, String txtComentario, String codigoUsuario);

    List<OutputRegistraEjecucion> executeScripts(BBDD bbdd, List<Script> listaVigente, List<Script> listaHistorico);

    OutputReparaScript repararScript(InputReparaScript inputReparaScript);

    OutputDescartarScript descartarScript(InputDescartarScript inputDescartarScript);

    List<DetObjeto> detalleObjetosScripts(BigDecimal idProceso, BigDecimal numeroOrden);

	OutputReparaScript repararScript(String inputReparaScript) throws ServiceException;

}
