package com.mdsql.ui.model;

import java.util.List;

import com.mdsql.bussiness.entities.Script;
import com.mdval.ui.model.DefaultTableModel;

public class TypesTableModel extends DefaultTableModel<Script> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8306918464859990294L;

	/**
	 * @param columnNames
	 * @param columnClasses
	 */
	public TypesTableModel(List<String> columnNames, List<Class<?>> columnClasses) {
		super(columnNames, columnClasses);
	}

	/**
	 * @param data
	 * @param columnNames
	 * @param columnClasses
	 */
	public TypesTableModel(List<Script> data, List<String> columnNames, List<Class<?>> columnClasses) {
		super(data, columnNames, columnClasses);
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Script row = data.get(rowIndex);

		if (0 == columnIndex) {
			return row.getSelected();
		} else if (1 == columnIndex) {
			return row.getNumeroOrden().intValue();
		} else if (2 == columnIndex) {
			return row.getDescripcionEstadoScript();
		} else if (3 == columnIndex) {
			return row.getFecha();
		} else if (7 == columnIndex) {
			return row.getNombreScript();
		}

		return null;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		Script row = data.get(rowIndex);
		if (0 == columnIndex) {
			if ("Ejecutado".equals(row.getDescripcionEstadoScript())) {
				row.setSelected(Boolean.FALSE);
				fireTableCellUpdated(rowIndex, columnIndex);
				return;
			}
			
			row.setSelected((Boolean) aValue);
			fireTableCellUpdated(rowIndex, columnIndex);
		} 
	}
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		Script row = data.get(rowIndex);
		
		if (0 == columnIndex) {
			if ("Ejecutado".equals(row.getDescripcionEstadoScript())) {
				return false;
			}
			
			return true;
		}
		
		return false;
	}
}
