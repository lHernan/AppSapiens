package com.mdsql.ui.model;

import java.util.List;

import com.mdsql.bussiness.entities.ErrorScript;
import com.mdsql.bussiness.entities.SeleccionHistorico;
import com.mdval.ui.model.DefaultTableModel;

public class VerErroresScriptTableModel DefaultTableModel<ErrorScript> {
	
	
	/**
	 * @param columnNames
	 * @param columnClasses
	 */
	public VerErroresScriptTableModel(List<String> columnNames, List<Class<?>> columnClasses) {
		super(columnNames, columnClasses);
	}
	
	/**
	 * @param data
	 * @param columnNames
	 * @param columnClasses
	 */
	public VerErroresScriptTableModel(List<ErrorScript> data, List<String> columnNames, List<Class<?>> columnClasses) {
		super(data, columnNames, columnClasses);
	}
	
	public Object getValueAt(int rowIndex, int columnIndex) {
		ErrorScript row = data.get(rowIndex);
		
		if (0 == columnIndex) {
			return row.getOrden();
		} else if (1 == columnIndex) {
			return row.getFecha();
		} else if (2 == columnIndex) {
			return row.getProcesado();
		} else if (3 == columnIndex) {
			return row.getEjecucion();
		} else if (4 == columnIndex) {
			return row.getIteracion();
		} else if (5 == columnIndex) {
			return row.getScript();
		} else if (6 == columnIndex) {
			return row.getError();
		} 
		
		return null;
	}
}
