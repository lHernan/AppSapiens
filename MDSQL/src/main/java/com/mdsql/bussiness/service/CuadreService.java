package com.mdsql.bussiness.service;

import com.mdsql.bussiness.entities.CuadreObjeto;
import com.mdsql.bussiness.entities.CuadreOperacion;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author hcarreno
 */
public interface CuadreService {

    /**
     * @param idProceso
     * @param numeroOrden
     *
     * @return cuadreOperacionList
     */
    List<CuadreOperacion> consultaCuadreOperacionesScript(BigDecimal idProceso, BigDecimal numeroOrden);

    /**
     * @param idProceso
     * @param numeroOrden
     *
     * @return cuadreObjetoList
     */
    List<CuadreObjeto> consultaCuadreOperacionesObjetoScript(BigDecimal idProceso, BigDecimal numeroOrden);

}
