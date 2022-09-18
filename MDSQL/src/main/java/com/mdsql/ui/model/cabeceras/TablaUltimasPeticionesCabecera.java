package com.mdsql.ui.model.cabeceras;

/**
 * @author federico
 *
 */
public class TablaUltimasPeticionesCabecera extends Cabecera {
	
	public void setupCabecera() {
		columnIdentifiers.add("Petición");
		columnIdentifiers.add("Solicitado");
		columnIdentifiers.add("Estado");
		columnIdentifiers.add("Fecha");
		columnIdentifiers.add("Usuario");
		columnIdentifiers.add("Descripción");
		columnIdentifiers.add("Comentario Entrega");
		
		columnClasses.add(String.class);
		columnClasses.add(String.class);
		columnClasses.add(String.class);
		columnClasses.add(String.class);
		columnClasses.add(String.class);
		columnClasses.add(String.class);
		columnClasses.add(String.class);
	}
}
