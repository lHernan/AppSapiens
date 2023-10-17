package com.mdsql.ui.model;

import com.mdsql.bussiness.entities.Sinonimo;
import com.mdval.ui.model.DefaultTableModel;
import com.mdval.ui.model.cabeceras.Cabecera;

import java.util.List;

/**
 * @author federico
 *
 */
public class SinonimosGeneralesTableModel extends DefaultTableModel<Sinonimo> {

	/**
	 *
	 */
	private static final long serialVersionUID = -4191724356955356391L;

	/**
	 * @param cabecera
	 */
	public SinonimosGeneralesTableModel(Cabecera cabecera) {
		super(cabecera);
	}

	/**
	 * @param columnNames
	 * @param columnClasses
	 */
	public SinonimosGeneralesTableModel(List<String> columnNames, List<Class<?>> columnClasses) {
		super(columnNames, columnClasses);
	}

	/**
	 * @param data
	 * @param columnNames
	 * @param columnClasses
	 */
	public SinonimosGeneralesTableModel(List<Sinonimo> data, List<String> columnNames, List<Class<?>> columnClasses) {
		super(data, columnNames, columnClasses);
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		Sinonimo row = data.get(rowIndex);

		if (0 == columnIndex) {
			return row.getReceptor();
		} else if (1 == columnIndex) {
			return row.getTipoObjeto();
		} else if (2 == columnIndex) {
			return row.getEntorno();
		} else if (3 == columnIndex) {
			return row.getPropietario();
		} else if (4 == columnIndex) {
			return row.getIncluirPDC();
		} else if (5 == columnIndex) {
			return row.getHabilitada();
		} else if (6 == columnIndex) {
			return row.getPeticion();
		} else if (7 == columnIndex) {
			return row.getFuncionNombre();
		}

		return null;
	}
}
