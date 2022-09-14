package com.mdsql.bussiness.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Script implements Serializable {

    private String tipoScript;
    private String txtScript;
    private String nombreScript;
    private String codigoEstadoScript;
    private String descripcionEstadoScript;
    private BigDecimal numeroOrden;
    private String nombreScriptLanza;
    private String txtScriptLanza;
    private String nombreScriptLog;

}
