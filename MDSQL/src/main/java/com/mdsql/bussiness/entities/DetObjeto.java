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
public class DetObjeto implements Serializable {

    private BigDecimal numeroSentencia;
    private String nombreObjetoPadre;
    private String tipoObjetoPadre;
    private String descripcionTipoObjetoPadre;
    private String tipoAccionPadre;
    private String nombreObjeto;
    private String tipoObjeto;
    private String descripcionTipoObjeto;
    private String tipoAccion;
    private String tipoDato;
    private BigDecimal numeroLongitud;
    private BigDecimal numeroDecimal;

}
