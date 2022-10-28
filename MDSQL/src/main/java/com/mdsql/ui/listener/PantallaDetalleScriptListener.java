package com.mdsql.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;

import org.hibernate.service.spi.ServiceException;

import com.mdsql.bussiness.entities.DetObjeto;
import com.mdsql.bussiness.service.ScriptService;
import com.mdsql.ui.PantallaDetalleScript;
import com.mdsql.ui.PantallaInformacionModelo;
import com.mdsql.ui.utils.ListenerSupport;
import com.mdsql.ui.utils.MDSQLUIHelper;
import com.mdsql.utils.Constants;

public class PantallaDetalleScriptListener extends ListenerSupport implements ActionListener, OnLoadListener, Observer {

	private PantallaDetalleScript pantallaDetalleScript;
	
	public PantallaDetalleScriptListener(PantallaDetalleScript pantallaDetalleScript) {
		super();
		this.pantallaDetalleScript = pantallaDetalleScript;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton jButton = (JButton) e.getSource();
		
		if (Constants.PANTALLA_DETALLE_SCRIPT_CANCELAR.equals(jButton.getActionCommand())) {
			cancelar();
		}
		
	}
	
	private void cancelar() {
		pantallaDetalleScript.dispose();
	}

	@Override
	public void update(Observable o, Object cmd) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onLoad() {
		try {
			ScriptService scriptService = (ScriptService) getService(Constants.SCRIPT_SERVICE);
			
			String idProceso = (String) pantallaDetalleScript.getParams().get("idProceso");
			
			List<DetObjeto> detalleObjetosScripts = scriptService.detalleObjetosScripts(idProceso);
			
		}catch (ServiceException e) {
			Map<String, Object> params = MDSQLUIHelper.buildError(e);
			MDSQLUIHelper.showPopup(pantallaDetalleScript.getFrameParent(), Constants.CMD_ERROR, params);
		}
	}

}
