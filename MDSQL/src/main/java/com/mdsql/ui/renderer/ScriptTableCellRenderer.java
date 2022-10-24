package com.mdsql.ui.renderer;

import java.awt.Color;
import java.awt.Component;
import java.util.Objects;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import com.mdsql.bussiness.entities.Script;
import com.mdsql.ui.model.ScriptsTableModel;
import com.mdsql.utils.Constants;
import com.mdsql.utils.Constants.ColorCeldaScript;

public class ScriptTableCellRenderer extends DefaultTableCellRenderer {

	private static final long serialVersionUID = 1L;

	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int col) {

		Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);
		Script script = ((ScriptsTableModel) table.getModel()).getSelectedRow(row);
		
		if (!Objects.isNull(script)) {
			String descripcion = script.getDescripcionEstadoScript();
			setColorCelda(c, descripcion, col, isSelected);
		}

		return c;
	}

	/**
	 * @param c
	 * @param s
	 */
	private void setColorCelda(Component c, String s, int col, boolean isSelected) {
		ColorCeldaScript colorCelda = ColorCeldaScript.getByName(s);
		Color bgColor = Objects.isNull(colorCelda) ? Color.WHITE : colorCelda.getValue();

		c.setForeground(Color.black);

		Color color = (col == 0) ? bgColor
				: (!isSelected) ? Color.WHITE : Constants.CELL_SELECTED_BGCOLOR;
		c.setBackground(color);
	}
}