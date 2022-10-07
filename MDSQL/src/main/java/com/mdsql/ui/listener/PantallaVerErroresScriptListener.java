package com.mdsql.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;

import com.mdsql.bussiness.entities.SeleccionHistorico;
import com.mdsql.bussiness.service.ErroresService;
import com.mdsql.bussiness.service.ProcesoService;
import com.mdsql.exceptions.ServiceException;
import com.mdsql.ui.PantallaVerErroresScript;
import com.mdsql.ui.model.SeleccionHistoricoTableModel;
import com.mdsql.ui.model.VerErroresScriptTableModel;
import com.mdsql.ui.utils.ListenerSupport;
import com.mdsql.ui.utils.MDSQLUIHelper;
import com.mdsql.utils.Constants;

public class PantallaVerErroresScriptListener extends ListenerSupport implements ActionListener, OnLoadListener, Observer {
	
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
			cancelar();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void onLoad() {
		try {
			ErroresService erroresService = (ErroresService) getService(Constants.ERRORES_SERVICE);

			String idProceso = (String) pantallaVerErroresScript.getParams().get("idProceso");
			List<String> numeroOrden = (List<String>) pantallaVerErroresScript.getParams().get("numeroOrden");
			List<ErroresService> seleccion = erroresService.consultaErroresType(idProceso, numeroOrden);

		} catch (ServiceException e) {
			Map<String, Object> params = MDSQLUIHelper.buildError(e);
			MDSQLUIHelper.showPopup(pantallaVerErroresScript.getFrameParent(), Constants.CMD_ERROR, params);
		}
	}
	
	private void cancelar() {
		pantallaVerErroresScript.dispose();
		
	}
}
