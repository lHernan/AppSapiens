package com.mdsql.ui.model;

import java.util.List;

import com.mdsql.bussiness.entities.ErrorScript;
import com.mdval.ui.model.DefaultTableModel;

public class VerErroresScriptTableModel extends DefaultTableModel<ErrorScript> {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5715520235047183111L;

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
		
		
		
		return null;
	}
}
