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
public class Modelo implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1060226242769948540L;
	
	private String seleccionada;
	private String orden;
	private String estado;
	private String fecha;
	private String ejecucion;
	private String operaciones;
	private String objetos;
	private String script;

}
