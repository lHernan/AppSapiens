package com.mdsql.bussiness.entities;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author hcarreno
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OutputProcesaType extends OutputProcesa {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6168650459690301885L;
	
	private String pNombreScriptLanza;
	private String pTxtScriptLanza;
	private String pNombreScriptLog;

	private List<TextoLinea> txtScriptLanza;
    private List<Type> listaType;
}
