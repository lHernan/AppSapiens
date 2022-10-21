package com.mdsql.ui.model.cabeceras;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;

/**
 * @author federico
 *
 */
public class TablaScriptsCabecera extends Cabecera {
	
	public void setupCabecera() {
		columnIdentifiers.add(StringUtils.EMPTY);
		columnIdentifiers.add("Orden");
		columnIdentifiers.add("Estado");
		columnIdentifiers.add("Fecha");
		columnIdentifiers.add("Ejecución");
		columnIdentifiers.add("Operaciones");
		columnIdentifiers.add("Objetos");
		columnIdentifiers.add("Script");
		
		columnClasses.add(Boolean.class);
		columnClasses.add(Integer.class);
		columnClasses.add(String.class);
		columnClasses.add(Date.class);
		columnClasses.add(String.class);
		columnClasses.add(String.class);
		columnClasses.add(String.class);
		columnClasses.add(String.class);
	}
}
