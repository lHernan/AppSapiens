package com.mdsql.ui.model;

import java.util.List;

import com.mdsql.bussiness.entities.DetObjeto;
import com.mdval.ui.model.DefaultTableModel;

/**
 * @author federico
 *
 */
public class ResumenProcesadoObjetosTableModel extends DefaultTableModel<DetObjeto> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4191724356955356391L;

	/**
	 * @param columnNames
	 * @param columnClasses
	 */
	public ResumenProcesadoObjetosTableModel(List<String> columnNames, List<Class<?>> columnClasses) {
		super(columnNames, columnClasses);
	}
	
	/**
	 * @param data
	 * @param columnNames
	 * @param columnClasses
	 */
	public ResumenProcesadoObjetosTableModel(List<DetObjeto> data, List<String> columnNames, List<Class<?>> columnClasses) {
		super(data, columnNames, columnClasses);
	}
	
	public Object getValueAt(int rowIndex, int columnIndex) {
		DetObjeto row = data.get(rowIndex);
		
		if (0 == columnIndex) {
			return row.getNombreObjeto();
		} else if (1 == columnIndex) {
			return row.getTipoObjeto();
		} else if (2 == columnIndex) {
			return row.getTipoAccion();
		} else if (3 == columnIndex) {
			return row.getBbdd();
		} else if (4 == columnIndex) {
			return row.getScript();
		} 
 
		return null;
	}
}
