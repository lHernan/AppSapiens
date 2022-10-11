package com.mdsql.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Observer;

import javax.swing.JButton;

import com.mdsql.bussiness.entities.OutputReparaScript;
import com.mdsql.bussiness.service.ScriptService;
import com.mdsql.exceptions.ServiceException;
import com.mdsql.ui.PantallaRepararScript;
import com.mdsql.ui.utils.ListenerSupport;
import com.mdsql.ui.utils.MDSQLUIHelper;
import com.mdsql.utils.Constants;

public class PantallaRepararScriptListener extends ListenerSupport implements ActionListener, OnLoadListener, Observer {

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
		JButton jButton = (JButton) e.getSource();
		
		if (Constants.PANTALLA_REPARAR_SCRIPT_BTN_ACEPTAR.equals(jButton.getActionCommand())) {
			aceptar();
		}
		if (Constants.PANTALLA_REPARAR_SCRIPT_BTN_CANCELAR.equals(jButton.getActionCommand())) {
			cancelar();
		}
	}

	private void aceptar() {
		try {
			ScriptService scriptService = (ScriptService) getService(Constants.SCRIPT_SERVICE);

			String inputReparaScript = (String) pantallaRepararScript.getParams().get("inputReparaScript");
			
			String idProceso = String.valueOf(Long.valueOf(inputReparaScript));
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
