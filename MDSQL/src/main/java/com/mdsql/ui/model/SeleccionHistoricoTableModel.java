package com.mdsql.ui.model;

import java.util.List;

import com.mdsql.bussiness.entities.SeleccionHistorico;
import com.mdval.ui.model.DefaultTableModel;

/**
 * @author federico
 *
 */
public class SeleccionHistoricoTableModel extends DefaultTableModel<SeleccionHistorico> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4191724356955356391L;

	/**
	 * @param columnNames
	 * @param columnClasses
	 */
	public SeleccionHistoricoTableModel(List<String> columnNames, List<Class<?>> columnClasses) {
		super(columnNames, columnClasses);
	}
	
	/**
	 * @param data
	 * @param columnNames
	 * @param columnClasses
	 */
	public SeleccionHistoricoTableModel(List<SeleccionHistorico> data, List<String> columnNames, List<Class<?>> columnClasses) {
		super(data, columnNames, columnClasses);
	}
	
	public Object getValueAt(int rowIndex, int columnIndex) {
		SeleccionHistorico row = data.get(rowIndex);
		
		if (0 == columnIndex) {
			return row.getConfigurado();
		} else if (1 == columnIndex) {
			return row.getObjeto();
		} else if (2 == columnIndex) {
			return row.getTipo();
		} else if (3 == columnIndex) {
			return row.getHistorico();
		} else if (4 == columnIndex) {
			return row.getVigente();
		}  
		
		return null;
	}
}
