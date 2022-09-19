package com.mdsql.ui.model;

import java.util.List;

import com.mdsql.bussiness.entities.Peticion;
import com.mdval.ui.model.DefaultTableModel;

/**
 * @author federico
 *
 */
public class ProcesarScriptUltimasPeticionesTableModel extends DefaultTableModel<Peticion> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4191724356955356391L;

	/**
	 * @param columnNames
	 * @param columnClasses
	 */
	public ProcesarScriptUltimasPeticionesTableModel(List<String> columnNames, List<Class<?>> columnClasses) {
		super(columnNames, columnClasses);
	}
	
	/**
	 * @param data
	 * @param columnNames
	 * @param columnClasses
	 */
	public ProcesarScriptUltimasPeticionesTableModel(List<Peticion> data, List<String> columnNames, List<Class<?>> columnClasses) {
		super(data, columnNames, columnClasses);
	}
	
	public Object getValueAt(int rowIndex, int columnIndex) {
		Peticion row = data.get(rowIndex);
		
		if (0 == columnIndex) {
			return row.getPeticion();
		} else if (1 == columnIndex) {
			return row.getSolicitado();
		} else if (2 == columnIndex) {
			return row.getEstado();
		} else if (3 == columnIndex) {
			return row.getFecha();
		} else if (4 == columnIndex) {
			return row.getUsuario();
		} else if (5 == columnIndex) {
			return row.getDescripcion();
		} else if (6 == columnIndex) {
			return row.getComentarioEntrega();	
		} 
 
		return null;
	}
}
