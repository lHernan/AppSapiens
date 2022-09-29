package com.mdsql.bussiness.service;

import com.mdsql.bussiness.entities.OutputConsultaEntrega;

import java.math.BigDecimal;

/**
 * @author hcarreno
 */
public interface EntregaService {


    /**
     * @param codigoProyecto
     * @param idProceso
     * @return OutputConsultaEntrega
     */
    OutputConsultaEntrega consultaRutaEntrega(String codigoProyecto, BigDecimal idProceso);

    /**
     * @param idProceso
     * @param codigoUsuario
     * @param txtComentario
     * @return descripcionEstadoProceso
     */
    String entregarPeticion(BigDecimal idProceso, String codigoUsuario, String txtComentario);


}
