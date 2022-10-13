package com.mdsql.bussiness.service;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import com.mdsql.bussiness.entities.InformeCambios;
import com.mdsql.bussiness.entities.InformeValidacion;

/**
 * @author hcarreno
 */
public interface InformeService {

    /**
     * @param codigoValidacion
     * @return InformeValidacion
     */
    InformeValidacion generarInformeValidacion(BigDecimal codigoValidacion);

    /**
     * @param codigoProyecto
     * @param fechaDesde
     * @param fechaHasta
     * @return InformeCambiosList
     */
    List<InformeCambios> informeCambios(String codigoProyecto, Date fechaDesde, Date fechaHasta);

}
