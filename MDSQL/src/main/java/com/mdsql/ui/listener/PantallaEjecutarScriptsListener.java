package com.mdsql.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;
import java.util.Observer;

import javax.swing.JButton;

import com.mdsql.bussiness.entities.Modelo;
import com.mdsql.bussiness.service.ModeloService;
import com.mdsql.ui.PantallaEjecutarScripts;
import com.mdsql.ui.model.DefinicionScriptsTableModel;
import com.mdsql.ui.utils.ListenerSupport;
import com.mdsql.utils.Constants;

public class PantallaEjecutarScriptsListener extends ListenerSupport implements ActionListener {

	private PantallaEjecutarScripts pantallaEjecutarScripts;
			
	public PantallaEjecutarScriptsListener(PantallaEjecutarScripts pantallaEjecutarScripts) {
		super();
		this.pantallaEjecutarScripts = pantallaEjecutarScripts;
	}
	
	public void addObservador(Observer o) {
		this.addObserver(o);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton jButton = (JButton) e.getSource();

		if (Constants.FRM_DEFINICION_SCRIPTS_BTN_RECHAZAR.equals(jButton.getActionCommand())) {
			eventBtnRechazar();
		}
		
		if (Constants.FRM_DEFINICION_SCRIPTS_BTN_VER_LOG.equals(jButton.getActionCommand())) {
			eventBtnVerLog();
		}
		
		if (Constants.FRM_DEFINICION_SCRIPTS_BTN_DETALLE_SCRIPT.equals(jButton.getActionCommand())) {
			eventBtnDetalleScript();
		}
		
		if (Constants.FRM_DEFINICION_SCRIPTS_BTN_DESCARTAR.equals(jButton.getActionCommand())) {
			eventBtnDescartar();
		}
		
		if (Constants.FRM_DEFINICION_SCRIPTS_BTN_REPARAR.equals(jButton.getActionCommand())) {
			eventBtnReparar();
		}
		
		if (Constants.FRM_DEFINICION_SCRIPTS_BTN_VER_CUADROS.equals(jButton.getActionCommand())) {
			eventBtnVerCuadros();
		}
		
		if (Constants.FRM_DEFINICION_SCRIPTS_BTN_VER_ERRORES.equals(jButton.getActionCommand())) {
			eventBtnVerErrores();
		}
		
		if (Constants.FRM_DEFINICION_SCRIPTS_BTN_EXCEPCION.equals(jButton.getActionCommand())) {
			eventBtnExcepcion();
		}
		
		if (Constants.FRM_DEFINICION_SCRIPTS_BTN_ACEPTAR.equals(jButton.getActionCommand())) {
			eventBtnAceptar();
		}
		
		if (Constants.FRM_DEFINICION_SCRIPTS_BTN_CANCELAR.equals(jButton.getActionCommand())) {
			eventBtnCancelar();
		}
	}
	
	private void eventBtnRechazar(){
		
	}
	
	private void eventBtnVerLog(){
		
	}
	
	private void eventBtnDetalleScript() {
		
	}
	
	private void eventBtnDescartar() {
		
	}
	
	private void eventBtnReparar() {
		
	}
	
	private void eventBtnVerCuadros() {
		
	}
	
	private void eventBtnVerErrores() {
		
	}
	
	private void eventBtnExcepcion() {
		
	}
	
	private void eventBtnAceptar() {
		
	}
	
	private void eventBtnCancelar() {
		
	}
}
