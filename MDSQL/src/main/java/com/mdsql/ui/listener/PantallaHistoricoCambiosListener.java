package com.mdsql.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.swing.JButton;

import com.mdsql.bussiness.entities.Modelo;
import com.mdsql.bussiness.entities.SeleccionHistorico;
import com.mdsql.bussiness.entities.TextoLinea;
import com.mdsql.bussiness.service.ProcesoService;
import com.mdsql.ui.PantallaHistoricoCambios;
import com.mdsql.ui.PantallaSeleccionModelos;
import com.mdsql.ui.utils.ListenerSupport;
import com.mdsql.ui.utils.MDSQLUIHelper;
import com.mdsql.utils.MDSQLConstants;
import com.mdval.exceptions.ServiceException;
import com.mdval.ui.utils.OnLoadListener;

public class PantallaHistoricoCambiosListener extends ListenerSupport implements ActionListener, OnLoadListener {

	private PantallaHistoricoCambios pantallaHistoricoCambios;

	public PantallaHistoricoCambiosListener(PantallaHistoricoCambios pantallaHistoricoCambios) {
		super();
		this.pantallaHistoricoCambios = pantallaHistoricoCambios;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton jButton = (JButton) e.getSource();

		if (MDSQLConstants.PANTALLA_HISTORICO_CAMBIOS_BUSCAR_MODELO.equals(jButton.getActionCommand())) {
			buscarModelo();
		}
		if (MDSQLConstants.PANTALLA_HISTORICO_CAMBIOS_BUSCAR.equals(jButton.getActionCommand())) {
			buscar();
		}
		if (MDSQLConstants.PANTALLA_HISTORICO_CAMBIOS_INFORME_CAMBIOS.equals(jButton.getActionCommand())) {
			informeCambios();
		}
		if (MDSQLConstants.PANTALLA_HISTORICO_CAMBIOS_VER_DETALLE_SCRIPT.equals(jButton.getActionCommand())) {
			verDetalleScript();
		}
		if (MDSQLConstants.PANTALLA_HISTORICO_CAMBIOS_RESUMEN_PROCESADO.equals(jButton.getActionCommand())) {
			resumenProcesado();
		}
		if (MDSQLConstants.PANTALLA_HISTORICO_CAMBIOS_CANCELAR.equals(jButton.getActionCommand())) {
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
			ProcesoService procesoService = (ProcesoService) getService(MDSQLConstants.PROCESO_SERVICE);

			String codigoProyecto = (String) pantallaHistoricoCambios.getParams().get("codigoProyecto");
			List<TextoLinea> lineas = (List<TextoLinea>) pantallaHistoricoCambios.getParams().get("script");
			List<SeleccionHistorico> seleccionarHistorico = procesoService.seleccionarHistorico(codigoProyecto, lineas);

		} catch (ServiceException e) {
			Map<String, Object> params = MDSQLUIHelper.buildError(e);
			MDSQLUIHelper.showPopup(pantallaHistoricoCambios.getFrameParent(), MDSQLConstants.CMD_ERROR, params);
		}

	}

	private void buscarModelo() {
		Map<String, Object> params = new HashMap<>();

		PantallaSeleccionModelos pantallaSeleccionModelos = (PantallaSeleccionModelos) MDSQLUIHelper
				.createDialog(pantallaHistoricoCambios.getFrameParent(), MDSQLConstants.CMD_SEARCH_MODEL, params);
		MDSQLUIHelper.show(pantallaSeleccionModelos);
		Modelo seleccionado = pantallaSeleccionModelos.getSeleccionado();
		
		if (!Objects.isNull(seleccionado)) {
			pantallaHistoricoCambios.getTxtModelo().setText(seleccionado.getCodigoProyecto());
		}
	}

	@Override
	public void onLoad() {
		// TODO Auto-generated method stub

	}

}
