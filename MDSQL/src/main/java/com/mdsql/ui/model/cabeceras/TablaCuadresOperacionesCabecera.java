package com.mdsql.ui.model.cabeceras;

import com.mdval.ui.model.cabeceras.Cabecera;

/**
 * @author federico
 *
 */
public class TablaCuadresOperacionesCabecera extends Cabecera {
	
	public void setupCabecera() {
		columnIdentifiers.add("Tipo Objeto");
		columnIdentifiers.add("Acción");
		columnIdentifiers.add("BBDD");
		columnIdentifiers.add("SCRIPT");
		
		columnClasses.add(String.class);
		columnClasses.add(String.class);
		columnClasses.add(String.class);
		columnClasses.add(String.class);
		
		columnSizes.add(200);
		columnSizes.add(120);
		columnSizes.add(120);
		columnSizes.add(500);
	}
}
