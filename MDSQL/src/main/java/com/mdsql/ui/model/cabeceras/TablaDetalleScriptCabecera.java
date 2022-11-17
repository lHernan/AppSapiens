package com.mdsql.ui.model.cabeceras;

import java.util.Date;

/**
 * @author federico
 *
 */
public class TablaDetalleScriptCabecera extends Cabecera {
	
	public void setupCabecera() {
		columnIdentifiers.add("Sentencia");
		columnIdentifiers.add("Objeto padre");
		columnIdentifiers.add("Tipo objeto");
		columnIdentifiers.add("Acción");
		columnIdentifiers.add("Objeto");
		columnIdentifiers.add("Tipo objeto");
		columnIdentifiers.add("Acción");
		columnIdentifiers.add("Tipo dato");
		columnIdentifiers.add("Precisión");
		columnIdentifiers.add("Escala");
		
		columnClasses.add(String.class);
		columnClasses.add(String.class);
		columnClasses.add(String.class);
		columnClasses.add(String.class);
		columnClasses.add(String.class);
		columnClasses.add(String.class);
		columnClasses.add(String.class);
		columnClasses.add(String.class);
		columnClasses.add(String.class);
		columnClasses.add(String.class);
	}
}
