package com.mdsql.ui.model;

import java.util.List;

import com.mdsql.bussiness.entities.Type;
import com.mdval.ui.model.DefaultTableModel;

public class FramePrincipalTypesTableModel extends DefaultTableModel<Type> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8306918464859990294L;

	/**
	 * @param columnNames
	 * @param columnClasses
	 */
	public FramePrincipalTypesTableModel(List<String> columnNames, List<Class<?>> columnClasses) {
		super(columnNames, columnClasses);
	}
	
	/**
	 * @param data
	 * @param columnNames
	 * @param columnClasses
	 */
	public FramePrincipalTypesTableModel(List<Type> data, List<String> columnNames, List<Class<?>> columnClasses) {
		super(data, columnNames, columnClasses);
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Type row = data.get(rowIndex);
		
		if (0 == columnIndex) {
			return row.getNumeroOrdenType().intValue();
		} else if (1 == columnIndex) {
			return row.getNombreObjeto();
		} 
 
		return null;
	}
}
