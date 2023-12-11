package com.mdsql.ui.model;

import com.mdsql.utils.LiteralesSingleton;
import com.mdval.utils.LogWrapper;
import lombok.extern.slf4j.Slf4j;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author federico
 *
 */
@Slf4j
public class PermisoSinonimoComboBoxModel extends AbstractListModel<String> implements ComboBoxModel<String> {

	/**
	 *
	 */
	private static final long serialVersionUID = -8083638254718894808L;

	private List<String> responses;

	private String selection = null;

	/**
	 *
	 */
	public PermisoSinonimoComboBoxModel() {
		super();
		
		responses = new ArrayList<>();
		responses.add(null);
		responses.add("Permiso");
		responses.add("Sinónimo");
	}

	@Override
	public int getSize() {
		return responses.size();
	}

	@Override
	public String getElementAt(int index) {
		return responses.get(index);
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
