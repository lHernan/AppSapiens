package com.mdsql.ui.model;

import java.util.List;

import com.mdsql.bussiness.entities.Modelo;

/**
 * @author federico
 *
 */
public class DefinicionModelosTableModel extends DefaultTableModel<Modelo> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4191724356955356391L;

	/**
	 * @param columnNames
	 * @param columnClasses
	 */
	public DefinicionModelosTableModel(List<String> columnNames, List<Class<?>> columnClasses) {
		super(columnNames, columnClasses);
	}
	
	/**
	 * @param data
	 * @param columnNames
	 * @param columnClasses
	 */
	public DefinicionModelosTableModel(List<Modelo> data, List<String> columnNames, List<Class<?>> columnClasses) {
		super(data, columnNames, columnClasses);
	}
	
	public Object getValueAt(int rowIndex, int columnIndex) {
		Modelo row = data.get(rowIndex);
		
		
 
		return null;
	}
}
