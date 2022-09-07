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
public class Type implements Serializable {

    private BigDecimal numeeroOrdenType;
    private BigDecimal codigoEstadoScript;
    private String descripcionEstadoScript;
    private Date fechaCambio;
    private BigDecimal numeroEjecucion;
    private String txtCuadreTYS;
    private String txtCuadreTYB;
    private String txtCuadrePDC;
    private String txtCuadreDROP;
    private String nombreObjeto;
    private ScriptType scriptType;
    private String nombreScriptLanza;
    private TextoLinea txtScriptLanza;
    private String nombreScriptLog;

}
