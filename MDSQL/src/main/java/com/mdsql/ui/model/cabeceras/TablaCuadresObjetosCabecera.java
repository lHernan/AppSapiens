package com.mdsql.ui.model.cabeceras;

/**
 * @author federico
 *
 */
public class TablaCuadresObjetosCabecera extends Cabecera {
	
	public void setupCabecera() {
		columnIdentifiers.add("Nombre Objeto");
		columnIdentifiers.add("Tipo Objeto");
		columnIdentifiers.add("Acción");
		columnIdentifiers.add("BBDD");
		columnIdentifiers.add("SCRIPT");
		
		columnClasses.add(String.class);
		columnClasses.add(String.class);
		columnClasses.add(String.class);
		columnClasses.add(String.class);
		columnClasses.add(String.class);
	}
}
