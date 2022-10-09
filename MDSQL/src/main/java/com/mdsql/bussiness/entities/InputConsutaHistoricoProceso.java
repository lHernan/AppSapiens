package com.mdsql.bussiness.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

/**
 * @author hcarreno
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class InputConsutaHistoricoProceso implements Serializable {

    private String codigoProyecto;
    private String nombreObjetoPadre;
    private String tipoObjetoPadre;
    private String tipoAccionPadre;
    private String nombreObjeto;
    private String tipoObjeto;
    private String tipoAccion;
    private Date fechaDesde;
    private Date fechaHasta;
    private BigDecimal codigoEstadoProceso;
    private BigDecimal codigoEstadoScript;

}
