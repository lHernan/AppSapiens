package com.mdsql.ui.model;

import java.util.List;

import com.mdsql.bussiness.entities.Aviso;
import com.mdval.ui.model.DefaultTableModel;

public class ProcesadoCursoPrincipalTableModel extends DefaultTableModel<Aviso> {

	/**
	 * @param columnNames
	 * @param columnClasses
	 */
	public ProcesadoCursoPrincipalTableModel(List<String> columnNames, List<Class<?>> columnClasses) {
		super(columnNames, columnClasses);
	}
	
	/**
	 * @param data
	 * @param columnNames
	 * @param columnClasses
	 */
	public ProcesadoCursoPrincipalTableModel(List<Aviso> data, List<String> columnNames, List<Class<?>> columnClasses) {
		super(data, columnNames, columnClasses);
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}
}
