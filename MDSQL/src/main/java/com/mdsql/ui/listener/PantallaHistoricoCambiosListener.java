package com.mdsql.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.swing.JButton;

import org.apache.commons.lang3.StringUtils;

import com.mdsql.bussiness.entities.HistoricoProceso;
import com.mdsql.bussiness.entities.InputConsutaHistoricoProceso;
import com.mdsql.bussiness.entities.Modelo;
import com.mdsql.bussiness.service.HistoricoService;
import com.mdsql.ui.PantallaHistoricoCambios;
import com.mdsql.ui.PantallaSeleccionModelos;
import com.mdsql.ui.model.HistoricoObjetoTableModel;
import com.mdsql.ui.utils.ListenerSupport;
import com.mdsql.ui.utils.MDSQLUIHelper;
import com.mdsql.utils.MDSQLConstants;
import com.mdsql.utils.MDSQLConstants.EstadosProcesado;
import com.mdsql.utils.MDSQLConstants.EstadosScript;
import com.mdval.exceptions.ServiceException;

public class PantallaHistoricoCambiosListener extends ListenerSupport implements ActionListener {

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
			HistoricoService historicoService = (HistoricoService) getService(MDSQLConstants.HISTORICO_SERVICE);
			
			InputConsutaHistoricoProceso inputConsutaHistoricoProceso = new InputConsutaHistoricoProceso();
			
			String codigoProyecto = pantallaHistoricoCambios.getTxtModelo().getText();
			inputConsutaHistoricoProceso.setCodigoProyecto(codigoProyecto);
			
			String nombreObjetoPadre = pantallaHistoricoCambios.getTxtObjetoPadre().getText();
			inputConsutaHistoricoProceso.setNombreObjetoPadre(nombreObjetoPadre);
			
			String tipoObjetoPadre = (String) pantallaHistoricoCambios.getCmbTipoObjetoPadre().getSelectedItem();
			inputConsutaHistoricoProceso.setTipoObjetoPadre(tipoObjetoPadre);
			
			String tipoAccionPadre = (String) pantallaHistoricoCambios.getCmbOperacionPadre().getSelectedItem();
			inputConsutaHistoricoProceso.setTipoAccionPadre(tipoAccionPadre);
			
			String nombreObjeto = pantallaHistoricoCambios.getTxtObjeto().getText();
			inputConsutaHistoricoProceso.setNombreObjeto(nombreObjeto);
			
			String tipoObjeto = (String) pantallaHistoricoCambios.getCmbTipoObjeto().getSelectedItem();
			inputConsutaHistoricoProceso.setTipoObjeto(tipoObjeto);
			
			String tipoAccion = (String) pantallaHistoricoCambios.getCmbOperacion().getSelectedItem();
			inputConsutaHistoricoProceso.setTipoAccion(tipoAccion);
			
			String desde = pantallaHistoricoCambios.getTxtDesde().getText();
			String hasta = pantallaHistoricoCambios.getTxtHasta().getText();
			Date fechaDesde = (StringUtils.isNotBlank(desde)) ? dateFormatter.stringToDate(desde) : null;
			Date fechaHasta = (StringUtils.isNotBlank(hasta)) ? dateFormatter.stringToDate(hasta) : null;
			inputConsutaHistoricoProceso.setFechaDesde(fechaDesde);
			inputConsutaHistoricoProceso.setFechaHasta(fechaHasta);
			
			EstadosScript estadoScript = (EstadosScript) pantallaHistoricoCambios.getCmbEstadoScript().getSelectedItem();
			if (!Objects.isNull(estadoScript)) {
				inputConsutaHistoricoProceso.setCodigoEstadoScript(new BigDecimal(estadoScript.getIndex()));
			}
			else {
				inputConsutaHistoricoProceso.setCodigoEstadoScript(null);
			}
			
			EstadosProcesado estadoProcesado = (EstadosProcesado) pantallaHistoricoCambios.getCmbEstadoProcesado().getSelectedItem();
			if (!Objects.isNull(estadoProcesado)) {
				inputConsutaHistoricoProceso.setCodigoEstadoProceso(new BigDecimal(estadoProcesado.getIndex()));
			}
			else {
				inputConsutaHistoricoProceso.setCodigoEstadoProceso(null);
			}
			
			
			List<HistoricoProceso> historicos = historicoService.consultarHistoricoProceso(inputConsutaHistoricoProceso);
			populateModel(historicos);
		} catch (ServiceException | ParseException e) {
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

	/**
	 * @param modelos
	 */
	private void populateModel(List<HistoricoProceso> historicos) {
		// Obtiene el modelo y lo actualiza
		HistoricoObjetoTableModel tableModel = (HistoricoObjetoTableModel) pantallaHistoricoCambios
				.getTblHistoricoObjetos().getModel();
		tableModel.setData(historicos);
		
		pantallaHistoricoCambios.getTblHistoricoObjetos().repaint();
	}

}
