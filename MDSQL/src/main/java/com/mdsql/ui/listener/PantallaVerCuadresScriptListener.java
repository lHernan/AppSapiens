package com.mdsql.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;

import com.mdsql.bussiness.entities.SeleccionHistorico;
import com.mdsql.bussiness.service.CuadreService;
import com.mdsql.bussiness.service.ErroresService;
import com.mdsql.bussiness.service.ProcesoService;
import com.mdsql.exceptions.ServiceException;
import com.mdsql.ui.PantallaVerCuadresScript;
import com.mdsql.ui.PantallaVerErroresScript;
import com.mdsql.ui.model.SeleccionHistoricoTableModel;
import com.mdsql.ui.model.VerErroresScriptTableModel;
import com.mdsql.ui.utils.ListenerSupport;
import com.mdsql.ui.utils.MDSQLUIHelper;
import com.mdsql.utils.Constants;

public class PantallaVerCuadresScriptListener extends ListenerSupport implements ActionListener, OnLoadListener, Observer {
	
	private PantallaVerCuadresScript pantallaVerCuadresScript;
	
	public PantallaVerCuadresScriptListener(PantallaVerCuadresScript pantallaVerCuadresScript) {
		super();
		this.pantallaVerCuadresScript = pantallaVerCuadresScript;
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
			CuadreService cuadreService = (CuadreService) getService(Constants.CUADRE_SERVICE);

			String idProceso = (String) pantallaVerCuadresScript.getParams().get("idProceso");
			List<String> numeroOrden = (List<String>) pantallaVerCuadresScript.getParams().get("numeroOrden");
			List<CuadreService> seleccion = cuadreService.consultaErroresType(idProceso, numeroOrden);

		} catch (ServiceException e) {
			Map<String, Object> params = MDSQLUIHelper.buildError(e);
			MDSQLUIHelper.showPopup(pantallaVerCuadresScript.getFrameParent(), Constants.CMD_ERROR, params);
		}
	}
	
	private void cancelar() {
		pantallaVerCuadresScript.dispose();
		
	}
}
