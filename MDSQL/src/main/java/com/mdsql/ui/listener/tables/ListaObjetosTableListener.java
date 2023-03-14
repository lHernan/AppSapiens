package com.mdsql.ui.listener.tables;

import java.util.Objects;

import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.mdsql.bussiness.entities.Type;
import com.mdsql.ui.FramePrincipal;
import com.mdsql.ui.model.FramePrincipalTypesTableModel;
import com.mdsql.ui.utils.ListenerSupport;
import com.mdval.utils.LogWrapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ListaObjetosTableListener extends ListenerSupport implements ListSelectionListener {

	private FramePrincipal framePrincipal;

	public ListaObjetosTableListener(FramePrincipal framePrincipal) {
		super();
		this.framePrincipal = framePrincipal;
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (e.getValueIsAdjusting())
	        return;
		
		ListSelectionModel lsm = (ListSelectionModel) e.getSource();
		Integer index = lsm.getMinSelectionIndex();
		
		FramePrincipalTypesTableModel tableModel = (FramePrincipalTypesTableModel) framePrincipal.getTblListaObjetos().getModel();
		
		Type seleccionado = tableModel.getSelectedRow(index);
		if (!Objects.isNull(seleccionado)) {
			LogWrapper.debug(log, "Selected: %s", seleccionado.toString());
			framePrincipal.setTypeSeleccionado(seleccionado);
			
		}
	}

	
}
