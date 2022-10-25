package com.mdsql.ui.model;

import java.util.List;

import org.apache.commons.collections.Closure;
import org.apache.commons.collections.CollectionUtils;

import com.mdsql.bussiness.entities.Script;
import com.mdval.ui.model.DefaultTableModel;

public class ScriptsTableModel extends DefaultTableModel<Script> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8306918464859990294L;

	/**
	 * @param columnNames
	 * @param columnClasses
	 */
	public ScriptsTableModel(List<String> columnNames, List<Class<?>> columnClasses) {
		super(columnNames, columnClasses);
	}

	/**
	 * @param data
	 * @param columnNames
	 * @param columnClasses
	 */
	public ScriptsTableModel(List<Script> data, List<String> columnNames, List<Class<?>> columnClasses) {
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
			row.setSelected((Boolean) aValue);
		} 
	}
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return (0 == columnIndex) ? true : false;
	}

	public void setAllSelected() {
		CollectionUtils.forAllDo(data, new Closure() {

			@Override
			public void execute(Object input) {
				Script script = (Script) input;
				script.setSelected(Boolean.TRUE);
			}

		});
	}
}
