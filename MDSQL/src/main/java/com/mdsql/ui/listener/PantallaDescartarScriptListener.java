package com.mdsql.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.JButton;

import com.mdsql.bussiness.entities.InputDescartarScript;
import com.mdsql.bussiness.entities.OutputDescartarScript;
import com.mdsql.bussiness.service.ScriptService;
import com.mdsql.ui.PantallaDescartarScript;
import com.mdsql.ui.utils.ListenerSupport;
import com.mdsql.ui.utils.MDSQLUIHelper;
import com.mdsql.utils.Constants;
import com.mdval.exceptions.ServiceException;
import com.mdval.ui.utils.OnLoadListener;
import com.mdval.ui.utils.observer.Observable;
import com.mdval.ui.utils.observer.Observer;

public class PantallaDescartarScriptListener extends ListenerSupport implements ActionListener, OnLoadListener, Observer {

	private PantallaDescartarScript pantallaDescartarScript;
	
	public PantallaDescartarScriptListener(PantallaDescartarScript pantallaDescartarScript) {
		super();
		this.pantallaDescartarScript = pantallaDescartarScript;
	}

	public void addObservador(Observer o) {
		this.addObserver(o);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton jButton = (JButton) e.getSource();
		
		if (Constants.PANTALLA_DESCARTAR_SCRIPT_BTN_ACEPTAR.equals(jButton.getActionCommand())) {
			aceptar();
		}
		
		if (Constants.PANTALLA_DESCARTAR_SCRIPT_BTN_CANCELAR.equals(jButton.getActionCommand())) {
			cancelar();
		}
		
	}

	private void aceptar() {
		try {
			ScriptService scriptService = (ScriptService) getService(Constants.SCRIPT_SERVICE);
			
			String inputDescartarScript = (String) pantallaDescartarScript.getParams().get("inputDescartarScript");
			
			OutputDescartarScript descartarScript = scriptService.descartarScript(inputDescartarScript);
			
		} catch (ServiceException e) {
			Map<String, Object> params = MDSQLUIHelper.buildError(e);
			MDSQLUIHelper.showPopup(pantallaDescartarScript.getFrameParent(), Constants.CMD_ERROR, params);
		}
	}
	
	private void cancelar() {
		pantallaDescartarScript.dispose();
	}
	
	@Override
	public void update(Observable o, Object cmd) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onLoad() {
		// TODO Auto-generated method stub
		
	}
}
