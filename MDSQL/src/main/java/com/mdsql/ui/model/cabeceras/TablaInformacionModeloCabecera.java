package com.mdsql.ui.model.cabeceras;

import java.math.BigDecimal;

import lombok.Getter;

/**
 * @author federico
 *
 */
public class TablaInformacionModeloCabecera extends Cabecera {
	
	public void setupCabecera() {
		columnIdentifiers.add("Nivel");
		columnIdentifiers.add("Titulo");
		columnIdentifiers.add("Descripción");
		columnIdentifiers.add("Petición");
		columnIdentifiers.add("Habilitado");
		columnIdentifiers.add("Usuario");
		columnIdentifiers.add("Actualizado");
		
		columnClasses.add(BigDecimal.class);
		columnClasses.add(String.class);
		columnClasses.add(String.class);
		columnClasses.add(String.class);
		columnClasses.add(String.class);
		columnClasses.add(String.class);
		columnClasses.add(String.class);
	}
}
