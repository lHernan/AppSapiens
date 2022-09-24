package com.mdsql.ui.renderer;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import org.apache.commons.lang3.StringUtils;

import com.mdsql.utils.Constants.ColorCelda;

public class NivelAvisosTableCellRenderer extends DefaultTableCellRenderer {

	private static final long serialVersionUID = 1L;

	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int col) {

		Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);
		Object valueAt = table.getModel().getValueAt(row, col);
		String s = StringUtils.EMPTY;
		if (valueAt != null) {
			s = valueAt.toString();
			setColorCelda(c, s, col);
		}

		return c;
	}

	/**
	 * @param c
	 * @param s
	 */
	private void setColorCelda(Component c, String s, int col) {
		ColorCelda colorCelda = ColorCelda.getByName(s);
		
		c.setForeground(Color.black);
		
		Color color = (col == 0) ? colorCelda.getValue() : Color.WHITE; 
		c.setBackground(color);
	}
}