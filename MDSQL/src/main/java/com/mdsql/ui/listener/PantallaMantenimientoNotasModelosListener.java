package com.mdsql.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.mdsql.ui.PantallaMantenimientoNotasModelos;
import com.mdsql.ui.utils.ListenerSupport;
import com.mdsql.utils.MDSQLConstants;
import com.mdval.ui.utils.OnLoadListener;

public class PantallaMantenimientoNotasModelosListener extends ListenerSupport implements ActionListener, OnLoadListener {
	private PantallaMantenimientoNotasModelos pantallaMantenimientoNotasModelos;
	
	public PantallaMantenimientoNotasModelosListener(PantallaMantenimientoNotasModelos pantallaMantenimientoNotasModelos) {
		super();
		this.pantallaMantenimientoNotasModelos = pantallaMantenimientoNotasModelos;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton jButton = (JButton) e.getSource();
		
		if (MDSQLConstants.PANTALLA_MANTENIMIENTO_NOTAS_MODELOS_GUARDAR.equals(jButton.getActionCommand())) {
			eventBtnGuardar();
		}

		if (MDSQLConstants.PANTALLA_MANTENIMIENTO_NOTAS_MODELOS_CANCELAR.equals(jButton.getActionCommand())) {
			pantallaMantenimientoNotasModelos.dispose();
		}
	}
	
	private void eventBtnGuardar() {
		
	}

	@Override
	public void onLoad() {
		// TODO Auto-generated method stub
		
	}
}
