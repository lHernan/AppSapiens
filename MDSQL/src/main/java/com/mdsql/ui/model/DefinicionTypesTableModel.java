package com.mdsql.ui.model;

import java.util.List;

import com.mdsql.bussiness.entities.Type;

public class DefinicionTypesTableModel extends DefaultTableModel<Type> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param columnNames
	 * @param columnClasses
	 */
	public DefinicionTypesTableModel(List<String> columnNames, List<Class<?>> columnClasses) {
		super(columnNames, columnClasses);
	}
	
	/**
	 * @param data
	 * @param columnNames
	 * @param columnClasses
	 */
	public DefinicionTypesTableModel(List<Type> data, List<String> columnNames, List<Class<?>> columnClasses) {
		super(data, columnNames, columnClasses);
	}
	
	public Object getValueAt(int rowIndex, int columnIndex) {
		Type row = data.get(rowIndex);
		
		if (0 == columnIndex) {
			return row.getOrden();
		} else if (1 == columnIndex) {
			return row.getEstado();
		} else if (2 == columnIndex) {
			return row.getFecha();
		} else if (3 == columnIndex) {
			return row.getEjecucion();
		} else if (4 == columnIndex) {
			return row.getTYS();
		} else if (5 == columnIndex) {
			return row.getTYB();
		}else if (6 == columnIndex) {
			return row.getPDC();	
		} else if (7 == columnIndex) {
			return row.getObjetoType();
		}
		
		return null;
	}

}
