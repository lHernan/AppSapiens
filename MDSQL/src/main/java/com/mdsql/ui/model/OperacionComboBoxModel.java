package com.mdsql.ui.model;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 * @author federico
 *
 */
public class OperacionComboBoxModel extends AbstractListModel<String> implements ComboBoxModel<String> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8083638254718894808L;

	private String[] operaciones = new String[] { "Ningún valor seleccionado", "Creación", "Modificación", "Borrado" };

	private String selection = null;

	@Override
	public int getSize() {
		return operaciones.length;
	}

	@Override
	public String getElementAt(int index) {
		return operaciones[index];
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
