package com.mdsql.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;

import com.mdsql.bussiness.entities.SeleccionHistorico;
import com.mdsql.bussiness.service.ProcesoService;
import com.mdsql.exceptions.ServiceException;
import com.mdsql.ui.PantallaSeleccionHistorico;
import com.mdsql.ui.model.SeleccionHistoricoTableModel;
import com.mdsql.ui.utils.ListenerSupport;
import com.mdsql.ui.utils.MDSQLUIHelper;
import com.mdsql.utils.Constants;
import com.mdval.ui.utils.OnLoadListener;

public class PantallaSeleccionHistoricoListener extends ListenerSupport implements ActionListener, OnLoadListener {

	private PantallaSeleccionHistorico pantallaSeleccionHistorico;
	
	public PantallaSeleccionHistoricoListener(PantallaSeleccionHistorico pantallaSeleccionHistorico) {
		super();
		this.pantallaSeleccionHistorico = pantallaSeleccionHistorico;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton jButton = (JButton) e.getSource();
		
		if (Constants.PANTALLA_SELECCION_HISTORICA_BTN_AÑADIR.equals(jButton.getActionCommand())) {
			añadirHistorico();
		}
		
		if (Constants.PANTALLA_SELECCION_HISTORICA_BTN_GENERAR.equals(jButton.getActionCommand())) {
			generarHistorico();
		}
		
		if (Constants.PANTALLA_SELECCION_HISTORICA_BTN_CANCELAR.equals(jButton.getActionCommand())) {
			cancelar();
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void onLoad() {
		try {
			ProcesoService procesoService = (ProcesoService) getService(Constants.PROCESO_SERVICE);
			
			String codigoProyecto = (String) pantallaSeleccionHistorico.getParams().get("codigoProyecto");
			List<String> lineas = (List<String>) pantallaSeleccionHistorico.getParams().get("script");
			List<SeleccionHistorico> seleccion = procesoService.seleccionarHistorico(codigoProyecto, lineas);
			
			populateModelSeleccion(seleccion);
		} catch (ServiceException e) {
			Map<String, Object> params = MDSQLUIHelper.buildError(e);
			MDSQLUIHelper.showPopup(pantallaSeleccionHistorico.getFrameParent(), Constants.CMD_ERROR, params);
		}
	}
	
	private void añadirHistorico() {
//		try {
//			List<TextoLinea> lineasScript = pantallaSeleccionHistorico.getTxtLineasScript().getText();
//			String codigoProyecto = pantallaSeleccionHistorico.getTxtCodigoProyecto().getText();
//			
//			List<ObjetoHis> objetosHis = añadir(lineasScript, codigoProyecto);
//			
//		} catch (Exception e) {
//			Map<String, Object> params = MDSQLUIHelper.buildError(e);
//			MDSQLUIHelper.showPopup(pantallaSeleccionHistorico, Constants.CMD_ERROR, params);
//		}
	}
	
	private void generarHistorico() {
		pantallaSeleccionHistorico.dispose();
	}
	
	private void cancelar() {
		pantallaSeleccionHistorico.dispose();
	}
	
	/**
	 * @param avisos
	 */
	private void populateModelSeleccion(List<SeleccionHistorico> seleccion) {
		// Obtiene el modelo y lo actualiza
		SeleccionHistoricoTableModel tableModel = (SeleccionHistoricoTableModel) pantallaSeleccionHistorico.getTblHistorico()
				.getModel();
		tableModel.setData(seleccion);
	}
}
