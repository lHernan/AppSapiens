package com.mdsql.ui.model;

import java.util.List;

import com.mdsql.bussiness.entities.DetObjeto;
import com.mdsql.bussiness.entities.Script;
import com.mdval.ui.model.DefaultTableModel;

public class AjustarLogEjecucionTableModel extends DefaultTableModel<DetObjeto> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8306918464859990294L;

	/**
	 * @param columnNames
	 * @param columnClasses
	 */
	public AjustarLogEjecucionTableModel(List<String> columnNames, List<Class<?>> columnClasses) {
		super(columnNames, columnClasses);
	}

	/**
	 * @param data
	 * @param columnNames
	 * @param columnClasses
	 */
	public AjustarLogEjecucionTableModel(List<DetObjeto> data, List<String> columnNames, List<Class<?>> columnClasses) {
		super(data, columnNames, columnClasses);
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		DetObjeto row = data.get(rowIndex);

		if (columnIndex == 0) {
			return row.getScript();
		} else if (1 == columnIndex) {
			return row.getProcesado();
		} else if (2 == columnIndex) {
			return row.getIteracion();
		} else if (3 == columnIndex) {
			return row.getEjecucion();
		} else if (4 == columnIndex) {
			return row.getSentencia();
		} else if (5 == columnIndex) {
			return row.getTipoObjeto();
		} else if (6 == columnIndex) {
			return row.getAccion();
		} else if (7 == columnIndex) {
			return row.getNombre();
		} else if (8 == columnIndex) {
			return row.getEstado();
		} else if (9 == columnIndex) {
			return row.getEliminado();
		} else if (10 == columnIndex) {
			return row.getCOmentado();
		}

		return null;
	}
}
