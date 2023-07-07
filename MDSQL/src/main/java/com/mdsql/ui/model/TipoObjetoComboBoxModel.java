package com.mdsql.ui.model;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 * @author federico
 *
 */
public class TipoObjetoComboBoxModel extends AbstractListModel<String> implements ComboBoxModel<String> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8083638254718894808L;

	private String[] tipos = new String[] { "Ningún valor seleccionado", "Tabla", "Columna", "Comentario", "Vista", "Vista Materializada",
			"Secuencia", "PK", "FK", "Índice", "Partición", "Subpartición", "Sinónimo", "Type", "Check constraints",
			"Permiso" };

	private String selection = null;

	@Override
	public int getSize() {
		return tipos.length;
	}

	@Override
	public String getElementAt(int index) {
		return tipos[index];
	}

	@Override
	public void setSelectedItem(Object anItem) {
		selection = (String) anItem;
	}

	@Override
	public Object getSelectedItem() {
		return selection;
	}

}
