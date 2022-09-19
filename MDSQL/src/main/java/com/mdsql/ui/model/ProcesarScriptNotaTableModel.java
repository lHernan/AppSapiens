package com.mdsql.ui.model;

import java.util.List;

import com.mdsql.bussiness.entities.Nota;
import com.mdval.ui.model.DefaultTableModel;

/**
 * @author federico
 *
 */
public class ProcesarScriptNotaTableModel extends DefaultTableModel<Nota> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4191724356955356391L;

	/**
	 * @param columnNames
	 * @param columnClasses
	 */
	public ProcesarScriptNotaTableModel(List<String> columnNames, List<Class<?>> columnClasses) {
		super(columnNames, columnClasses);
	}
	
	/**
	 * @param data
	 * @param columnNames
	 * @param columnClasses
	 */
	public ProcesarScriptNotaTableModel(List<Nota> data, List<String> columnNames, List<Class<?>> columnClasses) {
		super(data, columnNames, columnClasses);
	}
	
	public Object getValueAt(int rowIndex, int columnIndex) {
		Nota row = data.get(rowIndex);
		
		if (0 == columnIndex) {
			return row.getNivel();
		} else if (1 == columnIndex) {
			return row.getTitulo();
		} else if (2 == columnIndex) {
			return row.getDescripcion();
		} else if (3 == columnIndex) {
			return row.getPeticion();
		} else if (4 == columnIndex) {
			return row.getHabilitado();
		} else if (5 == columnIndex) {
			return row.getUsuario();
		} else if (6 == columnIndex) {
			return row.getActualizado();	
		} 
 
		return null;
	}
}
