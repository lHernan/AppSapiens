package com.mdsql.ui.model;

import java.util.List;

import com.mdsql.bussiness.entities.DetObjeto;
import com.mdsql.bussiness.entities.Script;
import com.mdval.ui.model.DefaultTableModel;

public class DetalleScriptTableModel extends DefaultTableModel<DetObjeto> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8306918464859990294L;

	/**
	 * @param columnNames
	 * @param columnClasses
	 */
	public DetalleScriptTableModel(List<String> columnNames, List<Class<?>> columnClasses) {
		super(columnNames, columnClasses);
	}

	/**
	 * @param data
	 * @param columnNames
	 * @param columnClasses
	 */
	public DetalleScriptTableModel(List<DetObjeto> data, List<String> columnNames, List<Class<?>> columnClasses) {
		super(data, columnNames, columnClasses);
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		DetObjeto row = data.get(rowIndex);

		

		return null;
	}
}
