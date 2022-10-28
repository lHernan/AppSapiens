package com.mdsql.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;

import org.hibernate.service.spi.ServiceException;

import com.mdsql.bussiness.entities.DetObjeto;
import com.mdsql.bussiness.entities.Proceso;
import com.mdsql.bussiness.entities.Script;
import com.mdsql.bussiness.service.ScriptService;
import com.mdsql.ui.PantallaDetalleScript;
import com.mdsql.ui.utils.ListenerSupport;
import com.mdsql.ui.utils.MDSQLUIHelper;
import com.mdsql.utils.Constants;
import com.mdval.ui.utils.OnLoadListener;
import com.mdval.ui.utils.observer.Observable;

public class PantallaDetalleScriptListener extends ListenerSupport implements ActionListener, OnLoadListener {

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
	public void onLoad() {
		try {
			ScriptService scriptService = (ScriptService) getService(Constants.SCRIPT_SERVICE);
			
			Script script = (Script) pantallaDetalleScript.getParams().get("script");
			Proceso proceso = (Proceso) pantallaDetalleScript.getParams().get("proceso");
			
			BigDecimal idProceso = proceso.getIdProceso();
			BigDecimal numeroOrden = script.getNumeroOrden();
			
			List<DetObjeto> detalleObjetosScripts = scriptService.detalleObjetosScripts(idProceso, numeroOrden);
			
		}catch (ServiceException e) {
			Map<String, Object> params = MDSQLUIHelper.buildError(e);
			MDSQLUIHelper.showPopup(pantallaDetalleScript.getFrameParent(), Constants.CMD_ERROR, params);
		}
	}

}
