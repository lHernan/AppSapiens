package com.mdsql.ui.model;

import com.mdsql.bussiness.entities.Aviso;
import com.mdsql.bussiness.entities.Historico;
import com.mdsql.bussiness.entities.NotaModelo;
import com.mdval.ui.model.DefaultTableModel;
import com.mdval.ui.model.cabeceras.Cabecera;

import java.util.List;

public class NotasModeloTableModel extends DefaultTableModel<Aviso> {

	/**
	 *
	 */
	private static final long serialVersionUID = -8306918464859990294L;

	/**
	 * @param cabecera
	 */
	public NotasModeloTableModel(Cabecera cabecera) {
		super(cabecera);
	}

	/**
	 * @param columnNames
	 * @param columnClasses
	 */
	public NotasModeloTableModel(List<String> columnNames, List<Class<?>> columnClasses) {
		super(columnNames, columnClasses);
	}

	/**
	 * @param data
	 * @param columnNames
	 * @param columnClasses
	 */
	public NotasModeloTableModel(List<Aviso> data, List<String> columnNames, List<Class<?>> columnClasses) {
		super(data, columnNames, columnClasses);
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Aviso row = data.get(rowIndex);

		if (columnIndex == 0) {
			return row.getNivelImportancia().getDescripcionNivelAviso();
		} else if (1 == columnIndex) {
			return row.getTxtAviso();
		} else if (2 == columnIndex) {
			return row.getMcaHabilitado();
		} else if (3 == columnIndex) {
			return row.getCodigoPeticion();
		} else if (4 == columnIndex) {
			return row.getDescripcionAviso();
		}

		return null;
	}
}
