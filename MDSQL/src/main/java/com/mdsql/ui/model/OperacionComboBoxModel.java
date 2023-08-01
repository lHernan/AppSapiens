package com.mdsql.ui.model;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

import com.mdsql.utils.MDSQLConstants.Operaciones;

/**
 * @author federico
 *
 */
public class OperacionComboBoxModel extends AbstractListModel<Operaciones> implements ComboBoxModel<Operaciones> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8083638254718894808L;

	private Operaciones[] operaciones = Operaciones.values();

	private Operaciones selection = null;

	@Override
	public int getSize() {
		return operaciones.length;
	}

	@Override
	public Operaciones getElementAt(int index) {
		return operaciones[index];
	}

	@Override
	public void setSelectedItem(Object anItem) {
		selection = (Operaciones) anItem;
	}

	@Override
	public Object getSelectedItem() {
		return selection;
	}

}
