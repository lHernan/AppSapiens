package com.mdsql.ui.renderer;

import com.mdsql.bussiness.entities.BBDD;
import com.mdsql.bussiness.entities.NivelImportancia;
import org.apache.commons.lang3.StringUtils;

import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxRenderer;
import java.awt.*;
import java.util.Objects;

public class NivelImportanciaRenderer extends BasicComboBoxRenderer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3517770689739103773L;

	@SuppressWarnings("rawtypes")
	public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected,
			boolean cellHasFocus) {
		super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

		NivelImportancia nivelImportancia = (NivelImportancia) value;

		if (Objects.isNull(nivelImportancia)) {
			setText(StringUtils.EMPTY);
		} else {
			setText(nivelImportancia.getDescripcionNivelAviso());
		}
		return this;
	}
}
