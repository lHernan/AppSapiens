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
public class CuadreObjeto implements Serializable {

    private String nombreObjeto;
    private String tipoObjeto;
    private String tipoAccion;
    private BigDecimal numeroOperacionBBDD;
    private BigDecimal numeroOperacionScript;

}
