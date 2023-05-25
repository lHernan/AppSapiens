package com.mdsql.ui.model.cabeceras;

import java.math.BigDecimal;

import com.mdval.ui.model.cabeceras.Cabecera;

/**
 * @author federico
 *
 */
public class TablaConsultaPeticionesCabecera extends Cabecera {
	
	public void setupCabecera() {
		columnIdentifiers.add("Peticion");
		columnIdentifiers.add("Estado");
		columnIdentifiers.add("Fecha");
		columnIdentifiers.add("Modelo");
		columnIdentifiers.add("Submodelo");
		columnIdentifiers.add("Solicitado");
		columnIdentifiers.add("Descripcion");
		columnIdentifiers.add("Usuario");
		
		columnClasses.add(BigDecimal.class);
		columnClasses.add(String.class);
		columnClasses.add(String.class);
		columnClasses.add(String.class);
		columnClasses.add(String.class);
		columnClasses.add(String.class);
		columnClasses.add(String.class);
		columnClasses.add(String.class);
	}
}
