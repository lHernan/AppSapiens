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
public class OutputExcepcionScript implements Serializable {

    private BigDecimal codigoEstadoProceso;
    private String descripcionEstadoProceso;
    private BigDecimal codigoEstadoScript;
    private String descripcionEstadoScript;

}
