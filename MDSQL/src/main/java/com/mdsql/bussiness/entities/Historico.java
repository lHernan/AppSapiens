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
public class Historico implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -3330091903761565934L;
	private String nombreObjeto;
    private String historificado;
    private String mcaTrh;
    private String tipoObjeto;
    private String peticion;
    private Date fechaActualizacion;
    private String codigoUsuario;
}
