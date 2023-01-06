package com.mdsql.ui.model;

import java.util.List;

import com.mdsql.bussiness.entities.Objeto;
import com.mdval.ui.model.DefaultTableModel;
import com.mdval.ui.model.cabeceras.Cabecera;

/**
 * @author federico
 *
 */
public class CuadresObjetosTableModel extends DefaultTableModel<Objeto> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4191724356955356391L;
	
	/**
	 * @param cabecera
	 */
	public CuadresObjetosTableModel(Cabecera cabecera) {
		super(cabecera);
	}

	/**
	 * @param columnNames
	 * @param columnClasses
	 */
	public CuadresObjetosTableModel(List<String> columnNames, List<Class<?>> columnClasses) {
		super(columnNames, columnClasses);
	}
	
	/**
	 * @param data
	 * @param columnNames
	 * @param columnClasses
	 */
	public CuadresObjetosTableModel(List<Objeto> data, List<String> columnNames, List<Class<?>> columnClasses) {
		super(data, columnNames, columnClasses);
	}
	
	public Object getValueAt(int rowIndex, int columnIndex) {
		Objeto row = data.get(rowIndex);
		
		return null;
	}
}
