package com.mdsql.ui.model;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import com.mdsql.bussiness.entities.Aviso;

public class ProcesadoCursoPrincipalTableModel extends DefaultTableModel<Aviso>{

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
}
