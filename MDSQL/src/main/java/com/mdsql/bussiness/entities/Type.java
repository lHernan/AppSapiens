package com.mdsql.bussiness.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Type implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private BigDecimal numeroOrdenType;
	private BigDecimal codigoEstadoScript;
	private String descripcionEstadoScript;
	private String orden;
	private String estado;
	private String fecha;
	private String ejecucion;
	private String TYS;
	private String TYB;
	private String PDC;
	private String objetoType;
}
