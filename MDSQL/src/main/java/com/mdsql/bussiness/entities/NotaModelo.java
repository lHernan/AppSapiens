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
public class NotaModelo implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 3697494311301739263L;

    private String importancia;
    private String titulo;
    private String habilitado;
    private String peticion;
    private String descripcion;
}
