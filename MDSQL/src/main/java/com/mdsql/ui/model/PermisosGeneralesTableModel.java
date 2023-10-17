package com.mdsql.ui.model;

import com.mdsql.bussiness.entities.Permiso;
import com.mdsql.bussiness.entities.SeleccionHistorico;
import com.mdval.ui.model.DefaultTableModel;
import com.mdval.ui.model.cabeceras.Cabecera;

import java.util.List;

/**
 * @author federico
 *
 */
public class PermisosGeneralesTableModel extends DefaultTableModel<Permiso> {

	/**
	 *
	 */
	private static final long serialVersionUID = -4191724356955356391L;

	/**
	 * @param cabecera
	 */
	public PermisosGeneralesTableModel(Cabecera cabecera) {
		super(cabecera);
	}

	/**
	 * @param columnNames
	 * @param columnClasses
	 */
	public PermisosGeneralesTableModel(List<String> columnNames, List<Class<?>> columnClasses) {
		super(columnNames, columnClasses);
	}

	/**
	 * @param data
	 * @param columnNames
	 * @param columnClasses
	 */
	public PermisosGeneralesTableModel(List<Permiso> data, List<String> columnNames, List<Class<?>> columnClasses) {
		super(data, columnNames, columnClasses);
	}
	
	public Object getValueAt(int rowIndex, int columnIndex) {
		Permiso row = data.get(rowIndex);
		
		if (0 == columnIndex) {
			return row.getReceptor();
		} else if (1 == columnIndex) {
			return row.getTipoObjeto();
		} else if (2 == columnIndex) {
			return row.getPermiso();
		} else if (3 == columnIndex) {
			return row.getEntorno();
		} else if (4 == columnIndex) {
			return row.getGrantOption();
		} else if (5 == columnIndex) {
			return row.getIncluirPDC();
		} else if (6 == columnIndex) {
			return row.getHabilitada();
		} else if (7 == columnIndex) {
			return row.getPeticion();
		}

		return null;
	}
}
