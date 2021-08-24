package com.mdval.ui.renderer;

import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class BooleanRenderer extends LabelRenderer implements TableCellRenderer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2863654858834389960L;

	public BooleanRenderer() {
		super();
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		Boolean val = (Boolean) value;

		setSelected(isSelected);
		super.setHorizontalAlignment(LEFT);

		String valor = (Boolean.TRUE.equals(val)) ? literales.getLiteral("si") : literales.getLiteral("no");
		super.setText(valor);

		return this;
	}

}