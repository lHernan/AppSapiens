package com.mdsql.ui.model;

import java.util.List;

import com.mdsql.bussiness.entities.SeleccionHistorica;

/**
 * @author federico
 *
 */
public class DefinicionSeleccionTableModel extends DefaultTableModel<SeleccionHistorica> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4191724356955356391L;

	/**
	 * @param columnNames
	 * @param columnClasses
	 */
	public DefinicionSeleccionTableModel(List<String> columnNames, List<Class<?>> columnClasses) {
		super(columnNames, columnClasses);
	}
	
	/**
	 * @param data
	 * @param columnNames
	 * @param columnClasses
	 */
	public DefinicionSeleccionTableModel(List<SeleccionHistorica> data, List<String> columnNames, List<Class<?>> columnClasses) {
		super(data, columnNames, columnClasses);
	}
	
	public Object getValueAt(int rowIndex, int columnIndex) {
		SeleccionHistorica row = data.get(rowIndex);
		
		if (0 == columnIndex) {
			return row.getConfigurado();
		} else if (1 == columnIndex) {
			return row.getObjeto();
		} else if (2 == columnIndex) {
			return row.getTipo();
		} else if (3 == columnIndex) {
			return row.getHistorico();
		} else if (4 == columnIndex) {
			return row.getVigente();
		} 
		
		return null;
	}
}
