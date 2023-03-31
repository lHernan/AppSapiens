package com.mdsql.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.swing.AbstractButton;

import org.apache.commons.collections.CollectionUtils;

import com.mdsql.bussiness.entities.InputDescartarScript;
import com.mdsql.bussiness.entities.OutputDescartarScript;
import com.mdsql.bussiness.entities.Proceso;
import com.mdsql.bussiness.entities.Session;
import com.mdsql.bussiness.service.ScriptService;
import com.mdsql.ui.PantallaAjustarLogEjecucion;
import com.mdsql.ui.PantallaDescartarScript;
import com.mdsql.ui.utils.ListenerSupport;
import com.mdsql.ui.utils.MDSQLUIHelper;
import com.mdsql.utils.MDSQLAppHelper;
import com.mdsql.utils.MDSQLConstants;
import com.mdval.exceptions.ServiceException;

public class PantallaDescartarScriptListener extends ListenerSupport implements ActionListener {

	private PantallaDescartarScript pantallaDescartarScript;

	private File archivo;

	private File archivoReparacion;

	public PantallaDescartarScriptListener(PantallaDescartarScript pantallaDescartarScript) {
		this.pantallaDescartarScript = pantallaDescartarScript;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		AbstractButton jButton = (AbstractButton) e.getSource();

		if (MDSQLConstants.PANTALLA_DESCARTAR_SCRIPT_BTN_ABRIR_PROCESAR.equals(jButton.getActionCommand())) {
			abrirScriptProcesar();
		}

		if (MDSQLConstants.PANTALLA_DESCARTAR_SCRIPT_BTN_ABRIR_PARCHE.equals(jButton.getActionCommand())) {
			abrirScriptParche();
		}

		if (MDSQLConstants.PANTALLA_DESCARTAR_SCRIPT_BTN_ACEPTAR.equals(jButton.getActionCommand())) {
			aceptar();
		}

		if (MDSQLConstants.PANTALLA_DESCARTAR_SCRIPT_BTN_CANCELAR.equals(jButton.getActionCommand())) {
			pantallaDescartarScript.dispose();
		}

		if (MDSQLConstants.PANTALLA_DESCARTAR_SCRIPT_RBTN_REDUCIR.equals(jButton.getActionCommand())) {
			enableLoadParche(Boolean.FALSE);
		}

		if (MDSQLConstants.PANTALLA_DESCARTAR_SCRIPT_RBTN_AMPLIAR.equals(jButton.getActionCommand())) {
			enableLoadParche(Boolean.TRUE);
		}

	}

	private void abrirScriptParche() {
		Session session = (Session) MDSQLAppHelper.getGlobalProperty(MDSQLConstants.SESSION);
		String rutaInicial = session.getSelectedRoute();
		
		archivoReparacion = MDSQLUIHelper.abrirScript(rutaInicial, pantallaDescartarScript.getTxtScriptParche(),
				pantallaDescartarScript.getFrameParent());
	}

	private void abrirScriptProcesar() {
		Session session = (Session) MDSQLAppHelper.getGlobalProperty(MDSQLConstants.SESSION);
		String rutaInicial = session.getSelectedRoute();
		
		archivo = MDSQLUIHelper.abrirScript(rutaInicial, pantallaDescartarScript.getTxtScriptProcesar(),
				pantallaDescartarScript.getFrameParent());
	}

	/**
	 * @param value
	 */
	private void enableLoadParche(Boolean value) {
		pantallaDescartarScript.getBtnAbrirScriptParche().setEnabled(value);
		pantallaDescartarScript.getTxtScriptParche().setEnabled(value);
	}

	/**
	 * 
	 */
	private void aceptar() {
		try {
			Map<String, Object> params = new HashMap<>();
			
			Session session = (Session) MDSQLAppHelper.getGlobalProperty(MDSQLConstants.SESSION);
			Proceso proceso = session.getProceso();
			
			params.put("proceso", proceso);

			PantallaAjustarLogEjecucion pantallaAjustarLogEjecucion = (PantallaAjustarLogEjecucion) MDSQLUIHelper
					.createDialog(pantallaDescartarScript.getFrameParent(), MDSQLConstants.CMD_AJUSTAR_LOG_EJECUCION, params);
			MDSQLUIHelper.show(pantallaAjustarLogEjecucion);
			
			ScriptService scriptService = (ScriptService) getService(MDSQLConstants.SCRIPT_SERVICE);

			InputDescartarScript inputDescartarScript = createInputDescartarScript();
			OutputDescartarScript descartarScript = scriptService.descartarScript(inputDescartarScript);
			
			if (CollectionUtils.isNotEmpty(descartarScript.getListaScriptNew())) {
				
			}

		} catch (ServiceException e) {
			Map<String, Object> params = MDSQLUIHelper.buildError(e);
			MDSQLUIHelper.showPopup(pantallaDescartarScript.getFrameParent(), MDSQLConstants.CMD_ERROR, params);
		}
	}

	private InputDescartarScript createInputDescartarScript() {
		InputDescartarScript inputDescartarScript = new InputDescartarScript();
		
		inputDescartarScript.setNombreScript(archivo.getName());
		
		return inputDescartarScript;
	}
}
