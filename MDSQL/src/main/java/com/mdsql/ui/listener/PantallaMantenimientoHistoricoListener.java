package com.mdsql.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;
import java.util.*;

import javax.swing.*;

import com.mdsql.bussiness.entities.*;
import com.mdsql.bussiness.service.*;
import com.mdsql.ui.PantallaHistoricoAlta;
import com.mdsql.ui.PantallaHistoricoBaja;
import com.mdsql.ui.PantallaMantenimientoHistorico;
import com.mdsql.ui.PantallaSeleccionModelos;
import com.mdsql.ui.model.HistoricoTableModel;
import com.mdsql.ui.model.PermisosTableModel;
import com.mdsql.ui.model.TipoObjetoComboBoxModel;
import com.mdsql.ui.utils.ListenerSupport;
import com.mdsql.ui.utils.MDSQLUIHelper;
import com.mdsql.utils.ConfigurationSingleton;
import com.mdsql.utils.MDSQLConstants;
import com.mdval.exceptions.ServiceException;
import com.mdval.ui.utils.OnLoadListener;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

public class PantallaMantenimientoHistoricoListener extends ListenerSupport implements ActionListener, OnLoadListener {
	private PantallaMantenimientoHistorico pantallaMantenimientoHistorico;
	
	public PantallaMantenimientoHistoricoListener(PantallaMantenimientoHistorico pantallaMantenimientoHistorico) {
		super();
		this.pantallaMantenimientoHistorico = pantallaMantenimientoHistorico;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton jButton = (JButton) e.getSource();
		
		if (MDSQLConstants.PANTALLA_MANTENIMIENTO_HISTORICO_BUSCAR_MODELO.equals(jButton.getActionCommand())) {
			eventBtnBuscarModelo();
		}
		
		if (MDSQLConstants.PANTALLA_MANTENIMIENTO_HISTORICO_BUSCAR.equals(jButton.getActionCommand())) {
			eventBtnBuscar();
		}
		if (MDSQLConstants.PANTALLA_MANTENIMIENTO_HISTORICO_ALTA.equals(jButton.getActionCommand())) {
			eventBtnAlta();
		}
		
		if (MDSQLConstants.PANTALLA_MANTENIMIENTO_HISTORICO_BAJA.equals(jButton.getActionCommand())) {
			eventBtnBaja();
		}

		if (MDSQLConstants.PANTALLA_MANTENIMIENTO_HISTORICO_INFORME.equals(jButton.getActionCommand())) {
			eventBtnInforme();
		}

		if (MDSQLConstants.PANTALLA_MANTENIMIENTO_HISTORICO_CANCELAR.equals(jButton.getActionCommand())) {
			pantallaMantenimientoHistorico.dispose();
		}
	}

	private void eventBtnBuscarModelo() {
		Modelo seleccionado = null;
		Map<String, Object> params = new HashMap<>();

		String codigoProyecto = pantallaMantenimientoHistorico.getTxtModelo().getText();

		if (StringUtils.isNotBlank(codigoProyecto)) {
			params.put("codigoProyecto", codigoProyecto);
		}

		PantallaSeleccionModelos pantallaSeleccionModelos = (PantallaSeleccionModelos) MDSQLUIHelper.createDialog(pantallaMantenimientoHistorico.getFrameParent(),
				MDSQLConstants.CMD_SEARCH_MODEL, params);
		MDSQLUIHelper.show(pantallaSeleccionModelos);
		seleccionado = pantallaSeleccionModelos.getSeleccionado();
		pantallaMantenimientoHistorico.setModeloSeleccionado(seleccionado);
	}
	
	private void eventBtnBuscar() {
		buscar();
	}

	private void eventBtnAlta() {
		Map<String, Object> params = new HashMap<>();

		PantallaHistoricoAlta pantallaHistoricoAlta = (PantallaHistoricoAlta) MDSQLUIHelper.createDialog(pantallaMantenimientoHistorico.getFrameParent(),
				MDSQLConstants.CMD_HISTORICO_ALTA, params);
		MDSQLUIHelper.show(pantallaHistoricoAlta);

		String response = (String) pantallaHistoricoAlta.getReturnParams().get("response");
		if (!Objects.isNull(response) && "OK".equals(response)) {
			buscar();
		}
	}
	
	private void eventBtnBaja() {
		Map<String, Object> params = new HashMap<>();

		params.put("historico", pantallaMantenimientoHistorico.getSeleccionado());
		params.put("modelo", pantallaMantenimientoHistorico.getModeloSeleccionado());

		PantallaHistoricoBaja pantallaHistoricoBaja = (PantallaHistoricoBaja) MDSQLUIHelper.createDialog(pantallaMantenimientoHistorico.getFrameParent(),
				MDSQLConstants.CMD_HISTORICO_BAJA, params);
		MDSQLUIHelper.show(pantallaHistoricoBaja);

		String response = (String) pantallaHistoricoBaja.getReturnParams().get("response");
		if (!Objects.isNull(response) && "OK".equals(response)) {
			buscar();
		}
	}
	
	private void eventBtnInforme() {
		informe();
	}

	@Override
	public void onLoad() {
		try {
			TipoObjetoService tipoObjetoService = (TipoObjetoService) getService(MDSQLConstants.TIPO_OBJETO_SERVICE);

			// Rellenar combos
			List<String> tipos = tipoObjetoService.consultarTiposObjeto();

			if (CollectionUtils.isNotEmpty(tipos)) {
				TipoObjetoComboBoxModel tipoObjetoComboBoxModel = new TipoObjetoComboBoxModel(tipos);
				pantallaMantenimientoHistorico.getCmbTipoObjeto().setModel(tipoObjetoComboBoxModel);
			}
		} catch (ServiceException e) {
			Map<String, Object> errParams = MDSQLUIHelper.buildError(e);
			MDSQLUIHelper.showPopup(pantallaMantenimientoHistorico.getFrameParent(), MDSQLConstants.CMD_ERROR, errParams);
		}
	}

	private void buscar() {
		try {
			HistoricoService historicoService = (HistoricoService) getService(MDSQLConstants.HISTORICO_SERVICE);

			String codigoProyecto = pantallaMantenimientoHistorico.getTxtModelo().getText();
			String tipoObjeto = (String) pantallaMantenimientoHistorico.getCmbTipoObjeto().getSelectedItem();

			List<Historico> lista = historicoService.consultarHistorico(codigoProyecto, tipoObjeto);

			fillHistorico(lista);
		} catch (ServiceException e) {
			Map<String, Object> errParams = MDSQLUIHelper.buildError(e);
			MDSQLUIHelper.showPopup(pantallaMantenimientoHistorico.getFrameParent(), MDSQLConstants.CMD_ERROR, errParams);
		}
	}

	private void informe() {
		try {
			HistoricoService historicoService = (HistoricoService) getService(MDSQLConstants.HISTORICO_SERVICE);

			String codigoProyecto = pantallaMantenimientoHistorico.getTxtModelo().getText();
			String tipoObjeto = (String) pantallaMantenimientoHistorico.getCmbTipoObjeto().getSelectedItem();

			List<Historico> lista = historicoService.consultarHistorico(codigoProyecto, tipoObjeto);

			fillInforme(codigoProyecto, lista);
		} catch (ServiceException e) {
			Map<String, Object> errParams = MDSQLUIHelper.buildError(e);
			MDSQLUIHelper.showPopup(pantallaMantenimientoHistorico.getFrameParent(), MDSQLConstants.CMD_ERROR, errParams);
		}
	}

	private void fillInforme(String codigoProyecto, List<Historico> lista) {
		try {
			InformeService informeService = (InformeService) getService(MDSQLConstants.INFORME_SERVICE);
			ExcelGeneratorService excelGeneratorService = (ExcelGeneratorService) getService(MDSQLConstants.EXCEL_GENERATOR_SERVICE);

			ConfigurationSingleton configuration = ConfigurationSingleton.getInstance();
			String path = configuration.getConfig("RutaInformes");

			if(lista.isEmpty()) {
				JOptionPane.showMessageDialog(pantallaMantenimientoHistorico.getFrameParent(), "No hay datos para generar informe");
			} else {
				excelGeneratorService.generarExcelHistorico(lista, path, codigoProyecto, new Date());
			}
		} catch (IOException e) {
			Map<String, Object> params = MDSQLUIHelper.buildError(e);
			MDSQLUIHelper.showPopup(pantallaMantenimientoHistorico.getFrameParent(), MDSQLConstants.CMD_ERROR, params);
		}
	}

	private void fillHistorico(List<Historico> list) throws ServiceException {
		// Obtiene el modelo y lo actualiza
		HistoricoTableModel tableModel = (HistoricoTableModel) pantallaMantenimientoHistorico
				.getTblMantenimientoHistorico().getModel();
		tableModel.clearData();

		tableModel.setData(list);
		pantallaMantenimientoHistorico.getBtnBaja().setEnabled(Boolean.FALSE);
	}
}
