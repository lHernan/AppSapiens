package com.mdsql.ui.model;

import java.util.List;

import com.mdsql.bussiness.entities.ScriptParche;
import com.mdval.ui.model.DefaultTableModel;

public class VerParchesScriptTableModel extends DefaultTableModel<ScriptParche> {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5715520235047183111L;

	/**
	 * @param columnNames
	 * @param columnClasses
	 */
	public VerParchesScriptTableModel(List<String> columnNames, List<Class<?>> columnClasses) {
		super(columnNames, columnClasses);
	}
	
	/**
	 * @param data
	 * @param columnNames
	 * @param columnClasses
	 */
	public VerParchesScriptTableModel(List<ScriptParche> data, List<String> columnNames, List<Class<?>> columnClasses) {
		super(data, columnNames, columnClasses);
	}
	
	public Object getValueAt(int rowIndex, int columnIndex) {
		ScriptParche row = data.get(rowIndex);
		
		
		
		return null;
	}
}
