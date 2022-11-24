package com.mdsql.ui.listener.tables;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import com.mdsql.bussiness.entities.Script;
import com.mdsql.ui.PantallaEjecutarScripts;
import com.mdsql.ui.model.ScriptsTableModel;

public class VigenteScriptsTableModelListener implements TableModelListener {

	private PantallaEjecutarScripts pantallaEjecutarScripts;

	public VigenteScriptsTableModelListener(PantallaEjecutarScripts pantallaEjecutarScript) {
		this.pantallaEjecutarScripts = pantallaEjecutarScript;
	}

	@Override
	public void tableChanged(TableModelEvent e) {
		ScriptsTableModel tableModel = (ScriptsTableModel) e.getSource();

		Script script = tableModel.getSelectedRow(e.getFirstRow());
		Boolean selected = script.getSelected();

		// Están en orden en la tabla
		for (int i = e.getFirstRow(); i < 2; i++) {
			Script scr = tableModel.getSelectedRow(i);

			if (!"Ejecutado".equals(scr.getDescripcionEstadoScript())
					|| !"Error".equals(scr.getDescripcionEstadoScript())
					|| !"Descuadrado".equals(scr.getDescripcionEstadoScript())) {
				scr.setSelected(selected);
			}
		}

		ScriptsTableModel historicoTableModel = (ScriptsTableModel) pantallaEjecutarScripts.getTblHistorico()
				.getModel();
		for (int i = 0; i < historicoTableModel.getRowCount(); i++) {
			Script scr = historicoTableModel.getSelectedRow(i);
			if (!"Ejecutado".equals(scr.getDescripcionEstadoScript())
					|| !"Error".equals(scr.getDescripcionEstadoScript())
					|| !"Descuadrado".equals(scr.getDescripcionEstadoScript())) {
				scr.setSelected(selected);
			}
		}

		// Forzamos el repintado de la tabla para actualizar los cambios
		pantallaEjecutarScripts.getTblVigente().repaint();
		pantallaEjecutarScripts.getTblHistorico().repaint();

		pantallaEjecutarScripts.getTblVigente().clearSelection();
		pantallaEjecutarScripts.getTblHistorico().clearSelection();
		pantallaEjecutarScripts.setSeleccionado(null);
		pantallaEjecutarScripts.enableButtons(Boolean.FALSE);
	}
}
