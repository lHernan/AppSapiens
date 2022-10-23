package com.mdsql.ui.listener.tables;

import com.mdsql.bussiness.entities.Script;
import com.mdsql.ui.PantallaEjecutarScripts;
import com.mdsql.ui.model.ScriptsTableModel;

public class HistoricoScriptsTableListener extends ScriptsTableListener {

	public HistoricoScriptsTableListener(PantallaEjecutarScripts pantallaEjecutarScript) {
		super(pantallaEjecutarScript);
	}

	@Override
	protected Script getScriptSeleccionado(PantallaEjecutarScripts pantallaEjecutarScripts, Integer index) {
		ScriptsTableModel tableModel = (ScriptsTableModel) pantallaEjecutarScripts
				.getTblHistorico().getModel();
		return tableModel.getSelectedRow(index);
	}
}
