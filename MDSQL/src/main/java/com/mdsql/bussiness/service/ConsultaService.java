package com.mdsql.bussiness.service;

import java.util.List;

import com.mdsql.bussiness.entities.Estado;
import com.mdsql.bussiness.entities.Operacion;
import com.mdsql.bussiness.entities.TipoObjeto;

/**
 * @author hcarreno
 */
public interface ConsultaService {

    /**
     * @return TipoObjetoList
     */
    List<TipoObjeto> consultaTiposObjeto();

    /**
     * @return EstadoList
     */
    List<Estado> consultaEstadosProcesado();

    /**
     * @return EstadoList
     */
    List<Estado> consultaEstadosScript();

    /**
     * @return OperacionList
     */
    List<Operacion> consultaOperaciones();


}
