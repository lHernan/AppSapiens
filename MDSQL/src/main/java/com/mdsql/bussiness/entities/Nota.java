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
public class Nota implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1060226242769948540L;
	
	private String nivel;
	private String titulo;
	private String descripcion;
	private String peticion;
	private String habilitado;
	private String usuario;
	private String actualizado;
}
