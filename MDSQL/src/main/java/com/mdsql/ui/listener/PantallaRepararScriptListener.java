package com.mdsql.ui.listener;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Map;

import javax.swing.AbstractButton;

import com.mdsql.bussiness.entities.InputReparaScript;
import com.mdsql.bussiness.entities.Modelo;
import com.mdsql.bussiness.entities.OutputReparaScript;
import com.mdsql.bussiness.entities.Proceso;
import com.mdsql.bussiness.entities.Session;
import com.mdsql.bussiness.service.ScriptService;
import com.mdsql.ui.PantallaRepararScript;
import com.mdsql.ui.utils.ListenerSupport;
import com.mdsql.ui.utils.MDSQLUIHelper;
import com.mdsql.utils.MDSQLAppHelper;
import com.mdsql.utils.MDSQLConstants;
import com.mdval.exceptions.ServiceException;
import com.mdval.ui.utils.observer.Observer;

public class PantallaRepararScriptListener extends ListenerSupport implements ActionListener {

	private PantallaRepararScript pantallaRepararScript;
	
	private File archivoReprocesado;
	
	private File archivoReparacion;
	
	public PantallaRepararScriptListener(PantallaRepararScript pantallaRepararScript) {
		super();
		this.pantallaRepararScript = pantallaRepararScript;
	}
	
	public void addObservador(Observer o) {
		this.addObserver(o);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		AbstractButton jButton = (AbstractButton) e.getSource();
		
		if (MDSQLConstants.PANTALLA_REPARAR_SCRIPT_BTN_ACEPTAR.equals(jButton.getActionCommand())) {
			aceptar();
		}
		
		if (MDSQLConstants.PANTALLA_REPARAR_SCRIPT_BTN_CANCELAR.equals(jButton.getActionCommand())) {
			pantallaRepararScript.dispose();
		}
		
		if (MDSQLConstants.PANTALLA_REPARAR_SCRIPT_RBTN_REPROCESAR_SCRIPT.equals(jButton.getActionCommand())) {
			enablePreprocesarScript(Boolean.TRUE);
		}
		
		if (MDSQLConstants.PANTALLA_REPARAR_SCRIPT_RBTN_NO_REPROCESAR_SCRIPT.equals(jButton.getActionCommand())) {
			enablePreprocesarScript(Boolean.FALSE);
		}
		
		if (MDSQLConstants.PANTALLA_REPARAR_SCRIPT_RBTN_SCRIPT_PROCESADO.equals(jButton.getActionCommand())) {
			enableScriptReparacion(Boolean.FALSE);
		}
		
		if (MDSQLConstants.PANTALLA_REPARAR_SCRIPT_RBTN_SCRIPT_REPARACION.equals(jButton.getActionCommand())) {
			enableScriptReparacion(Boolean.TRUE);
		}
		
		if (MDSQLConstants.PANTALLA_REPARAR_SCRIPT_BTN_ABRIR_FICHERO.equals(jButton.getActionCommand())) {
			abrirScript();
		}
		
		if (MDSQLConstants.PANTALLA_REPARAR_SCRIPT_BTN_ABRIR_FICHERO_REPARACION.equals(jButton.getActionCommand())) {
			abrirScriptReparacion();
		}
	}

	/**
	 * 
	 */
	private void abrirScript() {
		Session session = (Session) MDSQLAppHelper.getGlobalProperty(MDSQLConstants.SESSION);
		String rutaInicial = session.getSelectedRoute();
	
		MDSQLUIHelper.abrirScript(rutaInicial, pantallaRepararScript.getTxtScript(), archivoReprocesado,
				pantallaRepararScript.getFrameParent());	
	}
	
	/**
	 * 
	 */
	private void abrirScriptReparacion() {
		Session session = (Session) MDSQLAppHelper.getGlobalProperty(MDSQLConstants.SESSION);
		String rutaInicial = session.getSelectedRoute();
	
		MDSQLUIHelper.abrirScript(rutaInicial, pantallaRepararScript.getTxtScriptReparacion(), archivoReparacion,
				pantallaRepararScript.getFrameParent());		
	}

	/**
	 * @param value
	 */
	private void enableScriptReparacion(Boolean value) {
		pantallaRepararScript.getBtnAbrirFicheroReparacion().setEnabled(value);
		pantallaRepararScript.getTxtScriptReparacion().setEnabled(value);
	}

	/**
	 * @param value
	 */
	private void enablePreprocesarScript(Boolean value) {
		pantallaRepararScript.getBtnAbrirFichero().setEnabled(value);
		pantallaRepararScript.getTxtScript().setEnabled(value);
	}

	/**
	 * 
	 */
	private void aceptar() {
		try {
			ScriptService scriptService = (ScriptService) getService(MDSQLConstants.SCRIPT_SERVICE);
			
			Proceso proceso = (Proceso) pantallaRepararScript.getParams().get("proceso");
			Modelo modelo = proceso.getModelo();
			
			// El modelo tiene histórico
			String tieneHistorico = modelo.getMcaHis();
			if (MDSQLConstants.S.equals(tieneHistorico)) {
				
			}
			else {
				InputReparaScript inputReparaScript = new InputReparaScript();
				String script = (String) pantallaRepararScript.getParams().get("script");
				inputReparaScript.setNombreScriptNew(script);
				
				OutputReparaScript repararScript = scriptService.repararScript(inputReparaScript);
			}

		} catch (ServiceException e) {
			Map<String, Object> params = MDSQLUIHelper.buildError(e);
			MDSQLUIHelper.showPopup(pantallaRepararScript.getFrameParent(), MDSQLConstants.CMD_ERROR, params);
		}
	}

}
