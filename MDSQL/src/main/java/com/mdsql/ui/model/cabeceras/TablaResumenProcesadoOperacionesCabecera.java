package com.mdsql.ui.model.cabeceras;

/**
 * @author federico
 *
 */
public class TablaResumenProcesadoOperacionesCabecera extends Cabecera {
	
	public void setupCabecera() {
		columnIdentifiers.add("Tipo objeto");
		columnIdentifiers.add("Acción");
		columnIdentifiers.add("BBDD");
		columnIdentifiers.add("Script");
		
		columnClasses.add(String.class);
		columnClasses.add(String.class);
		columnClasses.add(String.class);
		columnClasses.add(String.class);
	}
}
