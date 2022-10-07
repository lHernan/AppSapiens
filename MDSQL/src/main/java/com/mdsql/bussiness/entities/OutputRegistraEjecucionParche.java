package com.mdsql.bussiness.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class OutputRegistraEjecucionParche implements Serializable {

    private BigDecimal codigoEstadoProceso;
    private String descripcionEstadoProceso;
    private String nombreScript;
    private BigDecimal codigoEstadoScript;
    private String descripcionEstadoScript;
    private String txtCuadreOperacion;
    private String txtCuadreObjeto;

}
