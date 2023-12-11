package com.mdsql.ui.model;

import com.mdsql.bussiness.entities.Entorno;
import com.mdsql.bussiness.entities.Historico;
import com.mdval.ui.model.DefaultTableModel;
import com.mdval.ui.model.cabeceras.Cabecera;

import java.util.List;

public class EntornoTableModel extends DefaultTableModel<Entorno> {

	/**
	 *
	 */
	private static final long serialVersionUID = -8306918464859990294L;

	/**
	 * @param cabecera
	 */
	public EntornoTableModel(Cabecera cabecera) {
		super(cabecera);
	}

	/**
	 * @param columnNames
	 * @param columnClasses
	 */
	public EntornoTableModel(List<String> columnNames, List<Class<?>> columnClasses) {
		super(columnNames, columnClasses);
	}

	/**
	 * @param data
	 * @param columnNames
	 * @param columnClasses
	 */
	public EntornoTableModel(List<Entorno> data, List<String> columnNames, List<Class<?>> columnClasses) {
		super(data, columnNames, columnClasses);
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Entorno row = data.get(rowIndex);

		if (columnIndex == 0) {
			return row.getBbdd();
		} else if (1 == columnIndex) {
			return row.getEsquema();
		} else if (2 == columnIndex) {
			return row.getPassword();
		} else if (3 == columnIndex) {
			return row.getComentario();
		} else if (4 == columnIndex) {
			return row.getHabilitado();
		}

		return null;
	}
}
