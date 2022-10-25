package com.mdsql.ui.listener.tables;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import com.mdsql.ui.PantallaEjecutarScripts;

public class VigenteScriptsTableModelListener implements TableModelListener {

	private PantallaEjecutarScripts pantallaEjecutarScripts;

	public VigenteScriptsTableModelListener(PantallaEjecutarScripts pantallaEjecutarScript) {
		this.pantallaEjecutarScripts = pantallaEjecutarScript;
	}

	@Override
	public void tableChanged(TableModelEvent e) {
		
	}
}
