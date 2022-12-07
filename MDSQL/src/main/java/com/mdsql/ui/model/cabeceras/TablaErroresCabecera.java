package com.mdsql.ui.model.cabeceras;

import java.util.Date;

import com.mdval.ui.model.cabeceras.Cabecera;

/**
 * @author federico
 *
 */
public class TablaErroresCabecera extends Cabecera {
	
	public void setupCabecera() {
		columnIdentifiers.add("Orden");
		columnIdentifiers.add("Fecha");
		columnIdentifiers.add("Procesado");
		columnIdentifiers.add("Ejecución");
		columnIdentifiers.add("Iteración");
		columnIdentifiers.add("Script");
		columnIdentifiers.add("Error");
		
		columnClasses.add(Integer.class);
		columnClasses.add(Date.class);
		columnClasses.add(String.class);
		columnClasses.add(String.class);
		columnClasses.add(Integer.class);
		columnClasses.add(String.class);
		columnClasses.add(String.class);
		
		columnSizes.add(75);
		columnSizes.add(100);
		columnSizes.add(150);
		columnSizes.add(150);
		columnSizes.add(150);
		columnSizes.add(250);
		columnSizes.add(500);
	}
}
