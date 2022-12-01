package com.mdsql.ui.model;

import java.util.List;

import com.mdsql.bussiness.entities.DetObjeto;
import com.mdsql.bussiness.entities.Script;
import com.mdval.ui.model.DefaultTableModel;

public class InformacionModeloTableModel extends DefaultTableModel<DetObjeto> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8306918464859990294L;

	/**
	 * @param columnNames
	 * @param columnClasses
	 */
	public InformacionModeloTableModel(List<String> columnNames, List<Class<?>> columnClasses) {
		super(columnNames, columnClasses);
	}

	/**
	 * @param data
	 * @param columnNames
	 * @param columnClasses
	 */
	public InformacionModeloTableModel(List<DetObjeto> data, List<String> columnNames, List<Class<?>> columnClasses) {
		super(data, columnNames, columnClasses);
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		DetObjeto row = data.get(rowIndex);

//		if (columnIndex == 0) {
//			return row.getNivel();
//		} else if (1 == columnIndex) {
//			return row.getTitulo();
//		} else if (2 == columnIndex) {
//			return row.getDescripcion();
//		} else if (3 == columnIndex) {
//			return row.getPeticion();
//		} else if (4 == columnIndex) {
//			return row.getHabilitado();
//		} else if (5 == columnIndex) {
//			return row.getUsuario();
//		} else if (6 == columnIndex) {
//			return row.getActualizado();
//		} 

		return null;
	}
}
