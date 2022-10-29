package com.mdsql.ui.model;

import java.util.List;

import com.mdsql.bussiness.entities.Operacion;
import com.mdval.ui.model.DefaultTableModel;

/**
 * @author federico
 *
 */
public class CuadresOperacionesTableModel extends DefaultTableModel<Operacion> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4191724356955356391L;

	/**
	 * @param columnNames
	 * @param columnClasses
	 */
	public CuadresOperacionesTableModel(List<String> columnNames, List<Class<?>> columnClasses) {
		super(columnNames, columnClasses);
	}
	
	/**
	 * @param data
	 * @param columnNames
	 * @param columnClasses
	 */
	public CuadresOperacionesTableModel(List<Operacion> data, List<String> columnNames, List<Class<?>> columnClasses) {
		super(data, columnNames, columnClasses);
	}
	
	public Object getValueAt(int rowIndex, int columnIndex) {
		Operacion row = data.get(rowIndex);
		
		return null;
	}
}
