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
public class OutputRegistraEjecucionType implements Serializable {

    private BigDecimal codigoEstadoProceso;
    private String descripcionEstadoProceso;
    private List<Type> listaType;

}
