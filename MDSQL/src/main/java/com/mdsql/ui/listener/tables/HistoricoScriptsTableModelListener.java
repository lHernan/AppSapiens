package com.mdsql.ui.listener.tables;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import com.mdsql.ui.PantallaEjecutarScripts;

public class HistoricoScriptsTableModelListener implements TableModelListener {
	
	private PantallaEjecutarScripts pantallaEjecutarScripts;

	public HistoricoScriptsTableModelListener(PantallaEjecutarScripts pantallaEjecutarScript) {
		this.pantallaEjecutarScripts = pantallaEjecutarScript;
	}

	@Override
	public void tableChanged(TableModelEvent e) {
	
	}
}
