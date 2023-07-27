package com.mdsql.ui.model;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

import com.mdsql.utils.MDSQLConstants.TiposObjeto;


/**
 * @author federico
 *
 */
public class TipoObjetoComboBoxModel extends AbstractListModel<TiposObjeto> implements ComboBoxModel<TiposObjeto> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8083638254718894808L;

	private TiposObjeto[] tipos = TiposObjeto.values();

	private TiposObjeto selection = null;

	@Override
	public int getSize() {
		return tipos.length;
	}

	@Override
	public TiposObjeto getElementAt(int index) {
		return tipos[index];
	}

	@Override
	public void setSelectedItem(Object anItem) {
		selection = (TiposObjeto) anItem;
	}

	@Override
	public Object getSelectedItem() {
		return selection;
	}

}
