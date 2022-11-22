package com.mdsql.ui.listener.tables;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import com.mdsql.bussiness.entities.Script;
import com.mdsql.ui.PantallaEjecutarScripts;
import com.mdsql.ui.model.ScriptsTableModel;
import com.mdval.utils.LogWrapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HistoricoScriptsTableModelListener implements TableModelListener {

	private PantallaEjecutarScripts pantallaEjecutarScripts;

	public HistoricoScriptsTableModelListener(PantallaEjecutarScripts pantallaEjecutarScript) {
		this.pantallaEjecutarScripts = pantallaEjecutarScript;
	}

	@Override
	public void tableChanged(TableModelEvent e) {
		ScriptsTableModel tableModel = (ScriptsTableModel) e.getSource();

		Script script = tableModel.getSelectedRow(e.getFirstRow());
		Integer numeroOrden = script.getNumeroOrden().intValue();
		Boolean selected = script.getSelected();
		LogWrapper.debug(log, "Orden script seleccionado: %d", numeroOrden);

		for (int i = e.getFirstRow(); i < 2; i++) {
			Script scr = tableModel.getSelectedRow(i);

			if (!"Ejecutado".equals(scr.getDescripcionEstadoScript())) {
				scr.setSelected(selected);
			}
		}

		// Forzamos el repintado de las tablas para actualizar los cambios
		pantallaEjecutarScripts.getTblHistorico().repaint();
	}
}
