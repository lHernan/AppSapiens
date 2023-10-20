package com.mdsql.ui.listener.tables;

import com.mdsql.bussiness.entities.Historico;
import com.mdsql.bussiness.entities.Proceso;
import com.mdsql.ui.PantallaMantenimientoHistorico;
import com.mdsql.ui.PantallaProcesar;
import com.mdsql.ui.model.HistoricoTableModel;
import com.mdsql.ui.model.ProcesarScriptUltimasPeticionesTableModel;
import com.mdsql.ui.utils.ListenerSupport;
import com.mdval.utils.LogWrapper;
import lombok.extern.slf4j.Slf4j;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.util.Objects;

@Slf4j
public class HistoricoTableListener extends ListenerSupport implements ListSelectionListener {

	private PantallaMantenimientoHistorico pantallaMantenimientoHistorico;

	public HistoricoTableListener(PantallaMantenimientoHistorico pantallaMantenimientoHistorico) {
		super();
		this.pantallaMantenimientoHistorico = pantallaMantenimientoHistorico;
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (e.getValueIsAdjusting())
			return;

		ListSelectionModel lsm = (ListSelectionModel) e.getSource();
		Integer index = lsm.getMinSelectionIndex();

		HistoricoTableModel tableModel = (HistoricoTableModel) pantallaMantenimientoHistorico
				.getTblMantenimientoHistorico().getModel();

		Historico seleccionado = tableModel.getSelectedRow(index);
		if (!Objects.isNull(seleccionado)) {
			LogWrapper.debug(log, "Selected: %s", seleccionado.toString());
			pantallaMantenimientoHistorico.setSeleccionado(seleccionado);
			pantallaMantenimientoHistorico.getBtnBaja().setEnabled(Boolean.TRUE);
		}
	}

}
