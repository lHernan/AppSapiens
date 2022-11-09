package com.mdsql.ui.listener.tables;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import com.mdsql.bussiness.entities.Script;
import com.mdsql.ui.PantallaEjecutarScripts;
import com.mdsql.ui.model.ScriptsTableModel;
import com.mdval.utils.LogWrapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class VigenteScriptsTableModelListener implements TableModelListener {

	private PantallaEjecutarScripts pantallaEjecutarScripts;

	public VigenteScriptsTableModelListener(PantallaEjecutarScripts pantallaEjecutarScript) {
		this.pantallaEjecutarScripts = pantallaEjecutarScript;
	}

	@Override
	public void tableChanged(TableModelEvent e) {
		ScriptsTableModel tableModel = (ScriptsTableModel) e.getSource();

		Script script = tableModel.getSelectedRow(e.getFirstRow());
		Integer numeroOrden = script.getNumeroOrden().intValue();
		Boolean selected = script.getSelected();
		LogWrapper.debug(log, "Orden script seleccionado: %d", numeroOrden);
		
		if (numeroOrden > 1) {
			// Están en orden en la tabla
			for (int i = e.getFirstRow(); i >= 0; i--) {
				Script scr = tableModel.getSelectedRow(i);
				
				if (!"Ejecutado".equals(scr.getDescripcionEstadoScript())) {
					scr.setSelected(selected);
				}
			}
			
			// Forzamos el repintado de la tabla para actualizar los cambios
			pantallaEjecutarScripts.getTblVigente().repaint();
		}
	}
}
