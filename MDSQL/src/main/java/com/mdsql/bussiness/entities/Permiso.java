package com.mdsql.bussiness.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Permiso {

    private String receptor;

    private String tipoObjeto;

    private String permiso;

    private String entorno;

    private String grantOption;

    private String incluirPDC;

    private Boolean habilitada;

    private String peticion;
}
