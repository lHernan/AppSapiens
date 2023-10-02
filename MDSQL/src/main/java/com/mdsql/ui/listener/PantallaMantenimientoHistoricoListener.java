package com.mdsql.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.mdsql.ui.PantallaMantenimientoHistorico;
import com.mdsql.ui.utils.ListenerSupport;
import com.mdsql.utils.MDSQLConstants;
import com.mdval.ui.utils.OnLoadListener;

public class PantallaMantenimientoHistoricoListener extends ListenerSupport implements ActionListener, OnLoadListener {
	private PantallaMantenimientoHistorico pantallaMantenimientoHistorico;
	
	public PantallaMantenimientoHistoricoListener(PantallaMantenimientoHistorico pantallaMantenimientoHistorico) {
		super();
		this.pantallaMantenimientoHistorico = pantallaMantenimientoHistorico;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton jButton = (JButton) e.getSource();
		
		if (MDSQLConstants.PANTALLA_MANTENIMIENTO_HISTORICO_BUSCAR_MODELO.equals(jButton.getActionCommand())) {
			eventBtnBuscarModelo();
		}
		
		if (MDSQLConstants.PANTALLA_MANTENIMIENTO_HISTORICO_BUSCAR.equals(jButton.getActionCommand())) {
			eventBtnBuscar();
		}
		if (MDSQLConstants.PANTALLA_MANTENIMIENTO_HISTORICO_ALTA.equals(jButton.getActionCommand())) {
			eventBtnAlta();
		}
		
		if (MDSQLConstants.PANTALLA_MANTENIMIENTO_HISTORICO_BAJA.equals(jButton.getActionCommand())) {
			eventBtnBaja();
		}

		if (MDSQLConstants.PANTALLA_MANTENIMIENTO_HISTORICO_INFORME.equals(jButton.getActionCommand())) {
			eventBtnInforme();
		}

		if (MDSQLConstants.PANTALLA_MANTENIMIENTO_HISTORICO_CANCELAR.equals(jButton.getActionCommand())) {
			pantallaMantenimientoHistorico.dispose();
		}
	}
	
	private void eventBtnBuscarModelo() {
		
	}
	
	private void eventBtnBuscar() {
		
	}
	
	private void eventBtnAlta() {
		
	}
	
	private void eventBtnBaja() {
		
	}
	
	private void eventBtnInforme() {
		
	}

	@Override
	public void onLoad() {
		// TODO Auto-generated method stub
		
	}
}
