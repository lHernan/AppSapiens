package com.mdval.ui.model.cabeceras;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.AbstractButton;

import com.mdval.ui.utils.TableSupport;

public class TableItemListener implements ItemListener {

	private TableSupport table;

	public TableItemListener(TableSupport table) {
		super();
		this.table = table;
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		Object source = e.getSource();
		Integer column = ((CheckBoxHeader) source).getColumn();
		
		if (source instanceof AbstractButton == false)
			return;
		
		boolean checked = e.getStateChange() == ItemEvent.SELECTED;
		for (int x = 0, y = table.getRowCount(); x < y; x++) {
			table.setValueAt(new Boolean(checked), x, column);
		}
	}

}
