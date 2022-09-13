package com.mdsql.ui.model;

import java.util.List;

import com.mdsql.bussiness.entities.Modelo;

/**
*
* @author USUARIO1
*/
public class DefinicionScriptsTableModel extends DefaultTableModel<Modelo> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param columnNames
	 * @param columnClasses
	 */
	public DefinicionScriptsTableModel(List<Modelo> data, List<String> columnNames, List<Class<?>> columnClasses) {
		super(data, columnNames, columnClasses);
	}

	/**
	 * @param data
	 * @param columnNames
	 * @param columnClasses
	 */
	public Object getValueAt(int rowIndex, int columnIndex) {
		Modelo row = data.get(rowIndex);
		
		if (0 == columnIndex) {
			return row.getSelecionada();
		} else if (1 == columnIndex) {
			return row.getOrden();
		} else if (2 == columnIndex) {
			return row.getEstado();
		} else if (3 == columnIndex) {
			return row.getFecha();
		} else if (4 == columnIndex) {
			return row.getEjecucion();
		} else if (5 == columnIndex) {
			return row.getOperaciones();
		} else if (6 == columnIndex) {
			return row.getObjetos();	
		} else if (7 == columnIndex) {
			return row.getScript();
		}  
		return null;
	}
}
