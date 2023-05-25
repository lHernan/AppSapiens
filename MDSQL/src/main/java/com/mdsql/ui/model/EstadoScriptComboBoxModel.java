package com.mdsql.ui.model;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

import com.mdsql.utils.MDSQLConstants.EstadosScript;

/**
 * @author federico
 *
 */
public class EstadoScriptComboBoxModel extends AbstractListModel<EstadosScript> implements ComboBoxModel<EstadosScript> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8083638254718894808L;

	private EstadosScript[] estados = EstadosScript.values();

	private EstadosScript selection = null;

	@Override
	public int getSize() {
		return estados.length;
	}

	@Override
	public EstadosScript getElementAt(int index) {
		return estados[index];
	}

	@Override
	public void setSelectedItem(Object anItem) {
		selection = (EstadosScript) anItem;
	}

	@Override
	public Object getSelectedItem() {
		return selection;
	}

}
