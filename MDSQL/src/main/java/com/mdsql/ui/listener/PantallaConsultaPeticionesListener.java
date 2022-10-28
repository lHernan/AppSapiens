package com.mdsql.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.Map;

import javax.swing.JButton;

import com.mdsql.bussiness.entities.OutputConsultaProcesado;
import com.mdsql.bussiness.service.ProcesoService;
import com.mdsql.ui.PantallaConsultaPeticiones;
import com.mdsql.ui.utils.ListenerSupport;
import com.mdsql.ui.utils.MDSQLUIHelper;
import com.mdsql.utils.Constants;
import com.mdval.exceptions.ServiceException;
import com.mdval.ui.utils.OnLoadListener;

public class PantallaConsultaPeticionesListener extends ListenerSupport implements ActionListener, OnLoadListener {

	private PantallaConsultaPeticiones pantallaConsultaPeticiones;
	
	public PantallaConsultaPeticionesListener(PantallaConsultaPeticiones pantallaConsultaPeticiones) {
		super();
		this.pantallaConsultaPeticiones = pantallaConsultaPeticiones;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton jButton = (JButton) e.getSource();
		
		if (Constants.PANTALLA_CONSULTA_PETICIONES_BUSCAR.equals(jButton.getActionCommand())) {
			buscar();
		}
		if (Constants.PANTALLA_CONSULTA_PETICIONES_CARGAR_PROCESADO.equals(jButton.getActionCommand())) {
			cargarProcesado();
		}
		if (Constants.PANTALLA_CONSULTA_PETICIONES_CANCELAR.equals(jButton.getActionCommand())) {
			cancelar();
		}
	}

	private void cargarProcesado() {
		try {
			ProcesoService procesadoService = (ProcesoService) getService(Constants.PROCESO_SERVICE);
			
			// TODO - Ver de donde sale el id proceso, si es del procesado en curso
			BigDecimal idProceso = new BigDecimal(0);
			OutputConsultaProcesado consultaProcesado = procesadoService.consultaProcesado(idProceso);
			
		} catch (ServiceException e) {
			Map<String, Object> params = MDSQLUIHelper.buildError(e);
			MDSQLUIHelper.showPopup(pantallaConsultaPeticiones.getFrameParent(), Constants.CMD_ERROR, params);
		}
		
	}

	private void buscar() {
		// TODO Auto-generated method stub
		
	}
	
	private void cancelar() {
		pantallaConsultaPeticiones.dispose();
	}

	@Override
	public void onLoad() {
		// TODO Auto-generated method stub
		
	}
}
