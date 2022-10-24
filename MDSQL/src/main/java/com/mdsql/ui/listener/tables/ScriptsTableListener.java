package com.mdsql.ui.listener.tables;

import java.util.Objects;

import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.mdsql.bussiness.entities.Script;
import com.mdsql.ui.PantallaEjecutarScripts;
import com.mdsql.ui.utils.ListenerSupport;
import com.mdval.utils.LogWrapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class ScriptsTableListener extends ListenerSupport implements ListSelectionListener {

	protected PantallaEjecutarScripts pantallaEjecutarScripts;

	public ScriptsTableListener(PantallaEjecutarScripts pantallaEjecutarScripts) {
		super();
		this.pantallaEjecutarScripts = pantallaEjecutarScripts;
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (e.getValueIsAdjusting())
			return;

		ListSelectionModel lsm = (ListSelectionModel) e.getSource();
		Integer index = lsm.getMinSelectionIndex();
		
		Script seleccionado = getScriptSeleccionado(index);

		if (!Objects.isNull(seleccionado)) {
			LogWrapper.debug(log, "Selected: %s", seleccionado.toString());
			pantallaEjecutarScripts.setSeleccionado(seleccionado);
			
			pantallaEjecutarScripts.disableButtons();
			pantallaEjecutarScripts.getBtnDetalleScript().setEnabled(Boolean.TRUE);
			
			// TODO - Según el estado del script, habilitar el resto de botones
		}
	}

	/**
	 * @param index
	 * @return
	 */
	protected abstract Script getScriptSeleccionado(Integer index);

}
