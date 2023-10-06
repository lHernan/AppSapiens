package com.mdsql.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.mdsql.ui.PantallaMantenimientoEntornos;
import com.mdsql.ui.utils.ListenerSupport;
import com.mdsql.utils.MDSQLConstants;
import com.mdval.ui.utils.OnLoadListener;

public class PantallaMantenimientoEntornosListener extends ListenerSupport implements ActionListener, OnLoadListener {
	private PantallaMantenimientoEntornos pantallaMantenimientoEntornos;

	public PantallaMantenimientoEntornosListener(PantallaMantenimientoEntornos pantallaMantenimientoEntornos) {
		super();
		this.pantallaMantenimientoEntornos = pantallaMantenimientoEntornos;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton jButton = (JButton) e.getSource();
		
		if (MDSQLConstants.PANTALLA_MANTENIMIENTO_ENTORNOS_BUSCAR.equals(jButton.getActionCommand())) {
			eventBtnBuscar();
		}

		if (MDSQLConstants.PANTALLA_MANTENIMIENTO_ENTORNOS_GRABAR.equals(jButton.getActionCommand())) {
			eventBtnGrabar();
		}

		if (MDSQLConstants.PANTALLA_MANTENIMIENTO_ENTORNOS_CANCELAR.equals(jButton.getActionCommand())) {
			pantallaMantenimientoEntornos.dispose();
		}
	}
	
	private void eventBtnBuscar() {
		
	}
	
	private void eventBtnGrabar() {
		
	}

	@Override
	public void onLoad() {
		// TODO Auto-generated method stub
		
	}
}
