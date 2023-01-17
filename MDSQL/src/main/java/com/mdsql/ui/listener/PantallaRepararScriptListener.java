package com.mdsql.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.AbstractButton;

import com.mdsql.bussiness.entities.InputReparaScript;
import com.mdsql.bussiness.entities.OutputReparaScript;
import com.mdsql.bussiness.service.ScriptService;
import com.mdsql.ui.PantallaRepararScript;
import com.mdsql.ui.utils.ListenerSupport;
import com.mdsql.ui.utils.MDSQLUIHelper;
import com.mdsql.utils.Constants;
import com.mdval.exceptions.ServiceException;
import com.mdval.ui.utils.observer.Observer;

public class PantallaRepararScriptListener extends ListenerSupport implements ActionListener {

	private PantallaRepararScript pantallaRepararScript;
	
	public PantallaRepararScriptListener(PantallaRepararScript pantallaRepararScript) {
		super();
		this.pantallaRepararScript= pantallaRepararScript;
	}
	
	public void addObservador(Observer o) {
		this.addObserver(o);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		AbstractButton jButton = (AbstractButton) e.getSource();
		
		if (Constants.PANTALLA_REPARAR_SCRIPT_BTN_ACEPTAR.equals(jButton.getActionCommand())) {
			aceptar();
		}
		
		if (Constants.PANTALLA_REPARAR_SCRIPT_BTN_CANCELAR.equals(jButton.getActionCommand())) {
			cancelar();
		}
		
		if (Constants.PANTALLA_REPARAR_SCRIPT_RBTN_REPROCESAR_SCRIPT.equals(jButton.getActionCommand())) {
			enablePreprocesarScript(Boolean.TRUE);
		}
		
		if (Constants.PANTALLA_REPARAR_SCRIPT_RBTN_NO_REPROCESAR_SCRIPT.equals(jButton.getActionCommand())) {
			enablePreprocesarScript(Boolean.FALSE);
		}
		
		if (Constants.PANTALLA_REPARAR_SCRIPT_RBTN_SCRIPT_PROCESADO.equals(jButton.getActionCommand())) {
			enableScriptReparacion(Boolean.FALSE);
		}
		
		if (Constants.PANTALLA_REPARAR_SCRIPT_RBTN_SCRIPT_REPARACION.equals(jButton.getActionCommand())) {
			enableScriptReparacion(Boolean.TRUE);
		}
	}

	private void enableScriptReparacion(Boolean value) {
		pantallaRepararScript.getBtnAbrirFicheroReparacion().setEnabled(value);
		pantallaRepararScript.getTxtScriptReparacion().setEnabled(value);
	}

	private void enablePreprocesarScript(Boolean value) {
		pantallaRepararScript.getBtnAbrirFichero().setEnabled(value);
		pantallaRepararScript.getTxtScript().setEnabled(value);
	}

	private void aceptar() {
		try {
			ScriptService scriptService = (ScriptService) getService(Constants.SCRIPT_SERVICE);

			InputReparaScript inputReparaScript = new InputReparaScript();
			String script = (String) pantallaRepararScript.getParams().get("inputReparaScript");
			inputReparaScript.setNombreScriptNew(script);
			
			OutputReparaScript repararScript = scriptService.repararScript(inputReparaScript);

		} catch (ServiceException e) {
			Map<String, Object> params = MDSQLUIHelper.buildError(e);
			MDSQLUIHelper.showPopup(pantallaRepararScript.getFrameParent(), Constants.CMD_ERROR, params);
		}
	}

	private void cancelar() {
		pantallaRepararScript.dispose();
	}

}
