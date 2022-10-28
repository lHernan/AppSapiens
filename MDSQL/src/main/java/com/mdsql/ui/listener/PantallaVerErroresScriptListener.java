package com.mdsql.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;

import com.mdsql.bussiness.entities.ErrorScript;
import com.mdsql.bussiness.entities.Proceso;
import com.mdsql.bussiness.entities.Script;
import com.mdsql.bussiness.service.ErroresService;
import com.mdsql.ui.PantallaVerErroresScript;
import com.mdsql.ui.utils.ListenerSupport;
import com.mdsql.ui.utils.MDSQLUIHelper;
import com.mdsql.utils.Constants;
import com.mdval.exceptions.ServiceException;
import com.mdval.ui.utils.OnLoadListener;
import com.mdval.ui.utils.observer.Observer;

public class PantallaVerErroresScriptListener extends ListenerSupport implements ActionListener, OnLoadListener {
	
	private PantallaVerErroresScript pantallaVerErroresScript;
	
	public PantallaVerErroresScriptListener(PantallaVerErroresScript pantallaVerErroresScript) {
		super();
		this.pantallaVerErroresScript = pantallaVerErroresScript;
	}
	
	public void addObservador(Observer o) {
		this.addObserver(o);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton jButton = (JButton) e.getSource();

		if (Constants.PANTALLA_VER_ERRORES_SCRIPT_BTN_CANCELAR.equals(jButton.getActionCommand())) {
			pantallaVerErroresScript.dispose();
		}
	}

	@Override
	public void onLoad() {
		try {
			ErroresService erroresService = (ErroresService) getService(Constants.ERRORES_SERVICE);
			
			Script script = (Script) pantallaVerErroresScript.getParams().get("script");
			Proceso proceso = (Proceso) pantallaVerErroresScript.getParams().get("proceso");
			
			BigDecimal idProceso = proceso.getIdProceso();
			BigDecimal numeroOrden = script.getNumeroOrden();
			List<ErrorScript> seleccion = erroresService.consultaErroresType(idProceso, numeroOrden);

		} catch (ServiceException e) {
			Map<String, Object> params = MDSQLUIHelper.buildError(e);
			MDSQLUIHelper.showPopup(pantallaVerErroresScript.getFrameParent(), Constants.CMD_ERROR, params);
		}
	}
}
