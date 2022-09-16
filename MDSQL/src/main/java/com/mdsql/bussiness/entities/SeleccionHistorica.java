package com.mdsql.bussiness.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class SeleccionHistorica {
	
	private String configurado;
	private String objeto;
	private String tipo;
	private String historico;
	private String vigente;
}
