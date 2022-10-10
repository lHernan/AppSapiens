package com.mdsql.ui.model.cabeceras;

/**
 * @author federico
 *
 */
public class TablaResumenProcesadoObjetosCabecera extends Cabecera {
	
	public void setupCabecera() {
		columnIdentifiers.add("Nombre objeto");
		columnIdentifiers.add("Tipo objeto");
		columnIdentifiers.add("Acción");
		columnIdentifiers.add("BBDD");
		columnIdentifiers.add("Script");
		
		columnClasses.add(String.class);
		columnClasses.add(String.class);
		columnClasses.add(String.class);
		columnClasses.add(String.class);
		columnClasses.add(String.class);
	}
}
