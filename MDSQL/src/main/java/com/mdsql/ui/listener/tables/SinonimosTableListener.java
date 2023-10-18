package com.mdsql.ui.listener.tables;

import com.mdsql.bussiness.entities.Modelo;
import com.mdsql.bussiness.entities.Permiso;
import com.mdsql.bussiness.entities.Sinonimo;
import com.mdsql.ui.PantallaDetallePermisosPorObjeto;
import com.mdsql.ui.PantallaSeleccionModelos;
import com.mdsql.ui.model.PermisosTableModel;
import com.mdsql.ui.model.SeleccionModelosTableModel;
import com.mdsql.ui.model.SinonimosTableModel;
import com.mdsql.ui.utils.ListenerSupport;
import com.mdval.utils.LogWrapper;
import lombok.extern.slf4j.Slf4j;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.util.Objects;

@Slf4j
public class SinonimosTableListener extends ListenerSupport implements ListSelectionListener {

	private PantallaDetallePermisosPorObjeto pantallaDetallePermisosPorObjeto;

	public SinonimosTableListener(PantallaDetallePermisosPorObjeto pantallaDetallePermisosPorObjeto) {
		super();
		this.pantallaDetallePermisosPorObjeto = pantallaDetallePermisosPorObjeto;
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (e.getValueIsAdjusting())
			return;

		ListSelectionModel lsm = (ListSelectionModel) e.getSource();
		Integer index = lsm.getMinSelectionIndex();

		SinonimosTableModel tableModel = (SinonimosTableModel) pantallaDetallePermisosPorObjeto.getTblPermisos().getModel();

		Sinonimo seleccionado = tableModel.getSelectedRow(index);
		if (!Objects.isNull(seleccionado)) {
			LogWrapper.debug(log, "Selected: %s", seleccionado.toString());
			pantallaDetallePermisosPorObjeto.getBtnModificacion().setEnabled(Boolean.TRUE);
			pantallaDetallePermisosPorObjeto.getTblPermisos().clearSelection();
		}
	}

	
}
