package com.mdsql.ui.model.cabeceras;

import java.util.Date;

/**
 * @author federico
 *
 */
public class TablaParchesCabecera extends Cabecera {
	
	public void setupCabecera() {
		columnIdentifiers.add("Orden");
		columnIdentifiers.add("Estado");
		columnIdentifiers.add("Fecha");
		columnIdentifiers.add("Procesado");
		columnIdentifiers.add("Ejecucion");
		columnIdentifiers.add("Iteracion");
		columnIdentifiers.add("Script");
		columnIdentifiers.add("Comentario");
		
		columnClasses.add(Integer.class);
		columnClasses.add(String.class);
		columnClasses.add(Date.class);
		columnClasses.add(String.class);
		columnClasses.add(String.class);
		columnClasses.add(Integer.class);
		columnClasses.add(String.class);
		columnClasses.add(String.class);
	}
}
