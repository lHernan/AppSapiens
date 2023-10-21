package com.mdsql.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.mdsql.bussiness.entities.Modelo;
import com.mdsql.ui.PantallaMantenimientoVariables;
import com.mdsql.ui.utils.ListenerSupport;
import com.mdsql.utils.MDSQLConstants;
import com.mdval.ui.utils.OnLoadListener;

public class PantallaMantenimientoVariablesListener extends ListenerSupport implements ActionListener, OnLoadListener {
	private PantallaMantenimientoVariables pantallaMantenimientoVariables;
	
	public PantallaMantenimientoVariablesListener(PantallaMantenimientoVariables pantallaMantenimientoVariables) {
		super();
		this.pantallaMantenimientoVariables = pantallaMantenimientoVariables;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton jButton = (JButton) e.getSource();
		
		if (MDSQLConstants.PANTALLA_MANTENIMIENTO_VARIABLES_GUARDAR.equals(jButton.getActionCommand())) {
			eventBtnGuardar();
		}

		if (MDSQLConstants.PANTALLA_MANTENIMIENTO_VARIABLES_CANCELAR.equals(jButton.getActionCommand())) {
			pantallaMantenimientoVariables.dispose();
		}
	}
	
	private void eventBtnGuardar() {
		
	}

	@Override
	public void onLoad() {
		Modelo modelo = (Modelo) pantallaMantenimientoVariables.getParams().get("modelo");
		pantallaMantenimientoVariables.setModelo(modelo);
		
	}
}
