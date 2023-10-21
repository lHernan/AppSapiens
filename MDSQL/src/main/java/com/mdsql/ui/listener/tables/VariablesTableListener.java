package com.mdsql.ui.listener.tables;

import com.mdsql.bussiness.entities.Entorno;
import com.mdsql.bussiness.entities.Variable;
import com.mdsql.ui.PantallaMantenimientoEntornos;
import com.mdsql.ui.PantallaMantenimientoVariables;
import com.mdsql.ui.model.EntornoTableModel;
import com.mdsql.ui.model.VariableTableModel;
import com.mdsql.ui.utils.ListenerSupport;
import com.mdval.utils.AppHelper;
import com.mdval.utils.LogWrapper;
import lombok.extern.slf4j.Slf4j;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.util.Objects;

@Slf4j
public class VariablesTableListener extends ListenerSupport implements ListSelectionListener {

	private PantallaMantenimientoVariables pantallaMantenimientoVariables;

	public VariablesTableListener(PantallaMantenimientoVariables pantallaMantenimientoVariables) {
		super();
		this.pantallaMantenimientoVariables = pantallaMantenimientoVariables;
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (e.getValueIsAdjusting())
	        return;
		
		ListSelectionModel lsm = (ListSelectionModel) e.getSource();
		Integer index = lsm.getMinSelectionIndex();
		
		VariableTableModel tableModel = (VariableTableModel) pantallaMantenimientoVariables.getTblVariables().getModel();
		
		Variable seleccionada = tableModel.getSelectedRow(index);
		if (!Objects.isNull(seleccionada)) {
			LogWrapper.debug(log, "Selected: %s", seleccionada.toString());


			pantallaMantenimientoVariables.getBtnGuardar().setEnabled(Boolean.TRUE);
		}
	}

	
}
