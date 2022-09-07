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
public class ScriptEjecutado implements Serializable {

    private BigDecimal numeroOrden;
    private String codigoEstadoScript;
    private String descripcionEstadoScript;
    private Date fechaEjecucion;
    private String txtCuadreOperacion;
    private String txtCueadreObj;
    private String nombreScript;
    private String mcaErrores;

}
