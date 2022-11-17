package com.mdsql.ui.model.cabeceras;

import java.math.BigDecimal;

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
		
		columnClasses.add(BigDecimal.class);
		columnClasses.add(String.class);
		columnClasses.add(String.class);
		columnClasses.add(String.class);
		columnClasses.add(String.class);
		columnClasses.add(String.class);
		columnClasses.add(String.class);
		columnClasses.add(String.class);
		columnClasses.add(BigDecimal.class);
		columnClasses.add(BigDecimal.class);
	}
}
