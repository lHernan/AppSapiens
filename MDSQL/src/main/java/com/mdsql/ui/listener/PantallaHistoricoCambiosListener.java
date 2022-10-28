package com.mdsql.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;

import com.mdsql.bussiness.entities.SeleccionHistorico;
import com.mdsql.bussiness.entities.TextoLinea;
import com.mdsql.bussiness.service.ProcesoService;
import com.mdsql.ui.PantallaConsultaPeticiones;
import com.mdsql.ui.PantallaHistoricoCambios;
import com.mdsql.ui.model.SeleccionHistoricoTableModel;
import com.mdsql.ui.utils.ListenerSupport;
import com.mdsql.ui.utils.MDSQLUIHelper;
import com.mdsql.utils.Constants;

public class PantallaHistoricoCambiosListener extends ListenerSupport implements ActionListener, OnLoadListener, Observer {

	private PantallaHistoricoCambios pantallaHistoricoCambios;
	
	public PantallaHistoricoCambiosListener(PantallaHistoricoCambios pantallaHistoricoCambios) {
		super();
		this.pantallaHistoricoCambios = pantallaHistoricoCambios;
	}
	
	public void addObservador(Observer o) {
		this.addObserver(o);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton jButton = (JButton) e.getSource();
		
		if (Constants.PANTALLA_HISTORICO_CAMBIOS_BUSCAR_MODELO.equals(jButton.getActionCommand())) {
			buscarModelo();
		}
		if (Constants.PANTALLA_HISTORICO_CAMBIOS_BUSCAR.equals(jButton.getActionCommand())) {
			buscar();
		}
		if (Constants.PANTALLA_HISTORICO_CAMBIOS_INFORME_CAMBIOS.equals(jButton.getActionCommand())) {
			informeCambios();
		}
		if (Constants.PANTALLA_HISTORICO_CAMBIOS_VER_DETALLE_SCRIPT.equals(jButton.getActionCommand())) {
			verDetalleScript();
		}
		if (Constants.PANTALLA_HISTORICO_CAMBIOS_RESUMEN_PROCESADO.equals(jButton.getActionCommand())) {
			resumenProcesado();
		}
		if (Constants.PANTALLA_HISTORICO_CAMBIOS_CANCELAR.equals(jButton.getActionCommand())) {
			cancelar();
		}
	}

	private void cancelar() {
		pantallaHistoricoCambios.dispose();
		
	}

	private void resumenProcesado() {
		// TODO Auto-generated method stub
		
	}

	private void verDetalleScript() {
		// TODO Auto-generated method stub
		
	}

	private void informeCambios() {
		// TODO Auto-generated method stub
		
	}

	private void buscar() {
		try {
			ProcesoService procesoService = (ProcesoService) getService(Constants.PROCESO_SERVICE);

			String codigoProyecto = (String) pantallaHistoricoCambios.getParams().get("codigoProyecto");
			List<TextoLinea> lineas = (List<TextoLinea>) pantallaHistoricoCambios.getParams().get("script");
			List<SeleccionHistorico> seleccionarHistorico = procesoService.seleccionarHistorico(codigoProyecto, lineas);

		} catch (ServiceException e) {
			Map<String, Object> params = MDSQLUIHelper.buildError(e);
			MDSQLUIHelper.showPopup(pantallaHistoricoCambios.getFrameParent(), Constants.CMD_ERROR, params);
		}
		
	}

	private void buscarModelo() {
		// TODO Auto-generated method stub
		
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
