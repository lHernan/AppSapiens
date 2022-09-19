package com.mdsql.bussiness.entities;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Peticion implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1060226242769948540L;
	
	private String peticion;
	private String solicitado;
	private String estado;
	private String fecha;
	private String usuario;
	private String descripcion;
	private String comentarioEntrega;
}
