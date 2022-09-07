package com.mdsql.bussiness.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class CuadreOperacion implements Serializable {

    private String tipoObjeto;
    private String descripcionTipoObjeto;
    private String tipoAccion;
    private BigDecimal numeroOperacionBBDD;
    private BigDecimal numeroOperacionScript;

}
