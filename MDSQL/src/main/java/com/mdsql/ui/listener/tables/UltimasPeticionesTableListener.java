package com.mdsql.ui.listener.tables;

import java.util.Objects;

import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.mdsql.bussiness.entities.Proceso;
import com.mdsql.ui.PantallaProcesarScript;
import com.mdsql.ui.model.ProcesarScriptUltimasPeticionesTableModel;
import com.mdsql.ui.utils.ListenerSupport;
import com.mdval.utils.LogWrapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UltimasPeticionesTableListener extends ListenerSupport implements ListSelectionListener {

	private PantallaProcesarScript pantallaProcesarScript;

	public UltimasPeticionesTableListener(PantallaProcesarScript pantallaProcesarScript) {
		super();
		this.pantallaProcesarScript = pantallaProcesarScript;
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (e.getValueIsAdjusting())
	        return;
		
		ListSelectionModel lsm = (ListSelectionModel) e.getSource();
		Integer index = lsm.getMinSelectionIndex();
		
		ProcesarScriptUltimasPeticionesTableModel tableModel = (ProcesarScriptUltimasPeticionesTableModel) pantallaProcesarScript.getTblUltimasPeticiones().getModel();
		
		Proceso seleccionado = tableModel.getSelectedRow(index);
		if (!Objects.isNull(seleccionado)) {
			LogWrapper.debug(log, "Selected: %s", seleccionado.toString());
			pantallaProcesarScript.setProcesoSeleccionado(seleccionado);
		}
	}

	
}
