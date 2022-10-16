package com.mdsql.ui.model.cabeceras;

/**
 * @author federico
 *
 */
public class TablaTypesCabecera extends Cabecera {
	
	public void setupCabecera() {
		columnIdentifiers.add("Orden");
		columnIdentifiers.add("Objeto");
		
		columnClasses.add(Integer.class);
		columnClasses.add(String.class);
	}
}
