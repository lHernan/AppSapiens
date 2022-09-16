package com.mdsql.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.mdsql.ui.PantallaEjecutarTypes;
import com.mdsql.ui.utils.ListenerSupport;
import com.mdsql.utils.Constants;

public class PantallaEjecutarTypesActionListener extends ListenerSupport implements ActionListener {

	private PantallaEjecutarTypes pantallaEjecutarTypes; 
	
	public PantallaEjecutarTypesActionListener(PantallaEjecutarTypes pantallaEjecutarTypes) {
		this.pantallaEjecutarTypes = pantallaEjecutarTypes;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton jButton = (JButton) e.getSource();
		
		if (Constants.PANTALLA_EJECUTAR_TYPES_BTN_RECHAZAR.equals(jButton.getActionCommand())) {
			eventBtnRechazar();
		}
		
		if (Constants.PANTALLA_EJECUTAR_TYPES_BTN_VER_CUADRES.equals(jButton.getActionCommand())) {
			eventBtnVerCuadres();
		}
		
		if (Constants.PANTALLA_EJECUTAR_TYPES_BTN_VER_ERRORES.equals(jButton.getActionCommand())) {
			eventBtnVerErrores();
		}
		
		if (Constants.PANTALLA_EJECUTAR_TYPES_BTN_ACEPTAR.equals(jButton.getActionCommand())) {
			eventBtnAceptar();
		}
		
		if (Constants.PANTALLA_EJECUTAR_TYPES_BTN_CANCELAR.equals(jButton.getActionCommand())) {
			eventBtnCancelar();
		}
		
	}
	
	public void eventBtnRechazar() {
		
	}

	public void eventBtnVerCuadres() {
		
	}
	
	public void eventBtnVerErrores() {
		
	}
	
	public void eventBtnAceptar() {
		
	}
	
	public void eventBtnCancelar() {
		
	}
	
}
