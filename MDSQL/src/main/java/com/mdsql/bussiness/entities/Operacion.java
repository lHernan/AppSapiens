package com.mdsql.bussiness.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Operacion implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8271362075599903713L;
	
	private String tipoObjeto;
	private String accion;
	private String bbdd;
	private String script;

}
