package com.mdsql.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import antlr.collections.List;
import java.util.Map;

import javax.swing.JButton;

import com.mdsql.bussiness.entities.ObjetoHis;
import com.mdsql.bussiness.entities.TextoLinea;
import com.mdsql.bussiness.service.HistoricoService;
import com.mdsql.ui.modelos.PantallaSeleccionHistorico;
import com.mdsql.ui.utils.ListenerSupport;
import com.mdsql.utils.Constants;

public class PantallaSeleccionHistoricoListener extends ListenerSupport implements ActionListener{

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
	
	private void añadirHistorico() {
		try {
			List<TextoLinea> lineasScript = pantallaSeleccionHistorico.getTxtLineasScript().getText();
			String codigoProyecto = pantallaSeleccionHistorico.getTxtCodigoProyecto().getText();
			
			List<ObjetoHis> objetosHis = añadir(lineasScript, codigoProyecto);
			
		} catch (Exception e) {
			Map<String, Object> params = buildError(e);
			showPopup(pantallaSeleccionHistorico, Constants.CMD_ERROR, params);
		}
	}
	
	private List añadir(List<TextoLinea> lineasScript, String codigoProyecto) {
		HistoricoService historicoService = (HistoricoService) getService(Constants.BBDD_SERVICE);
		
		return historicoService.seleccionarHistorico(List<TextoLinea> lineasScript, codigoProyecto);
	}
	
	private void generarHistorico() {
		pantallaSeleccionHistorico.dispose();
	}
	
	private void cancelar() {
		pantallaSeleccionHistorico.dispose();
	}
}
