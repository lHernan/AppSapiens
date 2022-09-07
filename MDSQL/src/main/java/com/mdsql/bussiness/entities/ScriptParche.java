package com.mdsql.bussiness.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class ScriptParche implements Serializable {

    private BigDecimal numeroOrden;
    private BigDecimal codigoEstadoEjecucion;
    private String descripcionEstadoEjecucion;
    private Date fechaScript;
    private BigDecimal idProceso;
    private BigDecimal numeroIteracion;
    private BigDecimal numeroEjecucion;
    private String nombreScript;
    private String txtComentario;

}
