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
public class ErrorScript implements Serializable {

    private BigDecimal numeroOrden;
    private Date fechaError;
    private BigDecimal idProceso;
    private BigDecimal numeroIteracion;
    private BigDecimal numeroEjecucion;
    private String nombreScript;
    private BigDecimal numeroSentencia;
    private String txtError;

}
