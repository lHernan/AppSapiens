package com.mdsql.bussiness.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class OutputConsultaProcesado implements Serializable {

    private String nombreModelo;
    private String codigoUsrPeticion;
    private String nombreBBDDHistorico;
    private String descripcionSubProyecto;
    private String nombreEsquema;
    private String nombreesquemaHistorico;
    private String codigoPeticion;
    private String nombreBBDD;
    private BigDecimal codigoEstadoProceso;
    private String descripcionEstadoProceso;
    private String codigoUsuario;
    private Date fechaProceso;
    private String txtComentario;
    private String mcaInicial;
    private String txtRutaEntrada;
    private List<ScriptEjecutado> listaScriptsEjecutados;

}
