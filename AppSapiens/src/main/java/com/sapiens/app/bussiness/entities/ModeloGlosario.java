package com.sapiens.app.bussiness.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder(toBuilder = true)
public class ModeloGlosario {

    private Integer codigoProyecto;
    private Integer numeroEsquema;
    private Integer numeroModelo;
    private String descripcionNorma;
    private String descripcionGlosario;
    private String nombreBbdd;
    private String usuario;
    private Date fechaActualizacion;
}
