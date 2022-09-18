package com.mdsql.ui.listener.tables;

import java.util.Objects;

import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.mdsql.bussiness.entities.Modelo;
import com.mdsql.ui.model.DefinicionModelosTableModel;
import com.mdsql.ui.modelos.PantallaSeleccionModelos;
import com.mdsql.ui.utils.ListenerSupport;
import com.mdsql.utils.LogWrapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PantallaSeleccionModelosTableListener extends ListenerSupport implements ListSelectionListener {

	private PantallaSeleccionModelos pantallaSeleccionModelos;

	public PantallaSeleccionModelosTableListener(PantallaSeleccionModelos pantallaSeleccionModelos) {
		super();
		this.pantallaSeleccionModelos = pantallaSeleccionModelos;
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (e.getValueIsAdjusting())
	        return;
		
		ListSelectionModel lsm = (ListSelectionModel) e.getSource();
		Integer index = lsm.getMinSelectionIndex();
		
		DefinicionModelosTableModel tableModel = (DefinicionModelosTableModel) pantallaSeleccionModelos.getTblModelos().getModel();
		
		Modelo seleccionado = tableModel.getSelectedRow(index);
		if (!Objects.isNull(seleccionado)) {
			LogWrapper.debug(log, "Selected: %s", seleccionado.toString());
			pantallaSeleccionModelos.setSeleccionado(seleccionado);
			pantallaSeleccionModelos.getBtnSeleccionar().setEnabled(Boolean.TRUE);
		}
	}

	
}
