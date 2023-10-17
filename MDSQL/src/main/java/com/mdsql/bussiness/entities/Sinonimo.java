package com.mdsql.bussiness.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Sinonimo {

    private String receptor;

    private String tipoObjeto;

    private String entorno;

    private String propietario;

    private String incluirPDC;

    private Boolean habilitada;

    private String peticion;

    private String funcionNombre;
}
