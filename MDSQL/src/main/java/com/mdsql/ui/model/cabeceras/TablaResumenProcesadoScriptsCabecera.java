package com.mdsql.ui.model.cabeceras;

import java.util.Date;

/**
 * @author federico
 *
 */
public class TablaResumenProcesadoScriptsCabecera extends Cabecera {
	
	public void setupCabecera() {
		columnIdentifiers.add("Orden");
		columnIdentifiers.add("Estado");
		columnIdentifiers.add("Fecha");
		columnIdentifiers.add("Operaciones");
		columnIdentifiers.add("Objetos");
		columnIdentifiers.add("Script");
		
		columnClasses.add(Integer.class);
		columnClasses.add(String.class);
		columnClasses.add(Date.class);
		columnClasses.add(String.class);
		columnClasses.add(String.class);
		columnClasses.add(String.class);
	}
}
