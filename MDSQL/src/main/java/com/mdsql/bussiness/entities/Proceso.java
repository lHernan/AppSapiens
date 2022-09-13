package com.mdsql.bussiness.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Proceso implements Serializable {

    private BigDecimal idProceso;
    private String codigoPeticion;
    private String codigoUsrPeticion;
    private Date fechaInicio;
    private String codigoUsr;
    private BigDecimal codigoEstadoProceso;
    private String descripcionEstadoProceso;
    private String mcaInicial;
    private String txtDescripcion;
    private String txtObservacionEntrega;
    private String mcaErrores;

}
