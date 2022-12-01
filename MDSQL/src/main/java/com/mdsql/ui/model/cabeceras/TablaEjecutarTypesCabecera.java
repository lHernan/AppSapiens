package com.mdsql.ui.model.cabeceras;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import com.mdval.ui.model.cabeceras.Cabecera;

/**
 * @author federico
 *
 */
public class TablaEjecutarTypesCabecera extends Cabecera {
	
	public void setupCabecera() {
		columnIdentifiers.add(StringUtils.EMPTY);
		columnIdentifiers.add("Orden");
		columnIdentifiers.add("Estado");
		columnIdentifiers.add("Fecha");
		columnIdentifiers.add("Drop");
		columnIdentifiers.add("TYS");
		columnIdentifiers.add("TYB");
		columnIdentifiers.add("PDC");
		columnIdentifiers.add("Objeto Type");
		
		columnClasses.add(Boolean.class);
		columnClasses.add(Integer.class);
		columnClasses.add(String.class);
		columnClasses.add(Date.class);
		columnClasses.add(String.class);
		columnClasses.add(String.class);
		columnClasses.add(String.class);
		columnClasses.add(String.class);
		columnClasses.add(String.class);
	}
}
