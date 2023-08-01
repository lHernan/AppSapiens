package com.mdsql.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import org.apache.commons.lang3.StringUtils;

import com.mdsql.bussiness.entities.HistoricoProceso;
import com.mdsql.bussiness.entities.InformeCambios;
import com.mdsql.bussiness.entities.InputConsutaHistoricoProceso;
import com.mdsql.bussiness.entities.Modelo;
import com.mdsql.bussiness.entities.OutputConsultaHistoricoProceso;
import com.mdsql.bussiness.service.ExcelGeneratorService;
import com.mdsql.bussiness.service.HistoricoService;
import com.mdsql.bussiness.service.InformeService;
import com.mdsql.ui.PantallaDetalleScript;
import com.mdsql.ui.PantallaHistoricoCambios;
import com.mdsql.ui.PantallaResumenProcesado;
import com.mdsql.ui.PantallaSeleccionModelos;
import com.mdsql.ui.model.HistoricoObjetoTableModel;
import com.mdsql.ui.utils.ListenerSupport;
import com.mdsql.ui.utils.MDSQLUIHelper;
import com.mdsql.utils.ConfigurationSingleton;
import com.mdsql.utils.MDSQLConstants;
import com.mdsql.utils.MDSQLConstants.EstadosProcesado;
import com.mdsql.utils.MDSQLConstants.EstadosScript;
import com.mdsql.utils.MDSQLConstants.Operaciones;
import com.mdsql.utils.MDSQLConstants.TiposObjeto;
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
		Map<String, Object> params = new HashMap<>();

		HistoricoProceso seleccionado = pantallaHistoricoCambios.getSeleccionado();

		params.put("idProceso", seleccionado.getIdProceso());
		params.put("entregar", Boolean.FALSE);

		PantallaResumenProcesado pantallaResumenProcesado = (PantallaResumenProcesado) MDSQLUIHelper
				.createDialog(pantallaHistoricoCambios.getFrameParent(), MDSQLConstants.CMD_RESUMEN_PROCESADO, params);
		MDSQLUIHelper.show(pantallaResumenProcesado);

	}

	private void verDetalleScript() {
		Map<String, Object> params = new HashMap<>();

		HistoricoProceso seleccionado = pantallaHistoricoCambios.getSeleccionado();

		params.put("script", seleccionado.getNombreScript());
		params.put("proceso", seleccionado.getIdProceso());
		params.put("numeroOrden", seleccionado.getNumeroOrden());

		PantallaDetalleScript pantallaDetalleScript = (PantallaDetalleScript) MDSQLUIHelper
				.createDialog(pantallaHistoricoCambios.getFrameParent(), MDSQLConstants.CMD_DETALLE_SCRIPT, params);
		MDSQLUIHelper.show(pantallaDetalleScript);
	}

	private void informeCambios() {
		try {
			InformeService informeService = (InformeService) getService(MDSQLConstants.INFORME_SERVICE);
			ExcelGeneratorService excelGeneratorService = (ExcelGeneratorService) getService(MDSQLConstants.EXCEL_GENERATOR_SERVICE);
			
			ConfigurationSingleton configuration = ConfigurationSingleton.getInstance();
			String path = configuration.getConfig("RutaInformes");
			
			String codigoProyecto = pantallaHistoricoCambios.getTxtModelo().getText().toUpperCase();
			String desde = pantallaHistoricoCambios.getTxtDesde().getText();
			String hasta = pantallaHistoricoCambios.getTxtHasta().getText();
			Date fechaDesde = (StringUtils.isNotBlank(desde)) ? dateBuscarFormatter.stringToDate(desde) : null;
			Date fechaHasta = (StringUtils.isNotBlank(hasta)) ? dateBuscarFormatter.stringToDate(hasta) : null;
			
			List<InformeCambios> listaCambios = informeService.informeCambios(codigoProyecto, fechaDesde, fechaHasta);
			String sDesde = dateInformeFormatter.dateToString(fechaDesde);
			String sHasta = dateInformeFormatter.dateToString(fechaHasta);
			
			if(listaCambios.isEmpty()) {
				JOptionPane.showMessageDialog(pantallaHistoricoCambios.getFrameParent(), "No hay datos para generar informe");
			}else
			excelGeneratorService.generarExcelHistoricoCambios(listaCambios, path, codigoProyecto, sDesde, sHasta);
		} catch (ServiceException | ParseException | IOException e) {
			Map<String, Object> params = MDSQLUIHelper.buildError(e);
			MDSQLUIHelper.showPopup(pantallaHistoricoCambios.getFrameParent(), MDSQLConstants.CMD_ERROR, params);
		}
	}

	private void buscar() {
		try {
			HistoricoService historicoService = (HistoricoService) getService(MDSQLConstants.HISTORICO_SERVICE);
			
			InputConsutaHistoricoProceso inputConsutaHistoricoProceso = new InputConsutaHistoricoProceso();
			
			String codigoProyecto = pantallaHistoricoCambios.getTxtModelo().getText();
			inputConsutaHistoricoProceso.setCodigoProyecto(codigoProyecto);
			
			String nombreObjetoPadre = pantallaHistoricoCambios.getTxtObjetoPadre().getText();
			inputConsutaHistoricoProceso.setNombreObjetoPadre(nombreObjetoPadre);
			
			/*String tipoObjetoPadre = (String) pantallaHistoricoCambios.getCmbTipoObjetoPadre().getSelectedItem();
			inputConsutaHistoricoProceso.setTipoObjetoPadre(tipoObjetoPadre);*/
			
			TiposObjeto tiposObjetoPadre = (TiposObjeto) pantallaHistoricoCambios.getCmbTipoObjetoPadre().getSelectedItem();
			if (!Objects.isNull(tiposObjetoPadre)) {
				inputConsutaHistoricoProceso.setCodigoTipoObjeto(new BigDecimal(tiposObjetoPadre.getIndex()));
			}
			else {
				inputConsutaHistoricoProceso.setCodigoTipoObjeto(null);
			}
			
			/*String tipoAccionPadre = (String) pantallaHistoricoCambios.getCmbOperacionPadre().getSelectedItem();
			inputConsutaHistoricoProceso.setTipoAccionPadre(tipoAccionPadre);*/
			
			Operaciones operacionesPadre = (Operaciones) pantallaHistoricoCambios.getCmbOperacionPadre().getSelectedItem();
			if (!Objects.isNull(operacionesPadre)) {
				inputConsutaHistoricoProceso.setCodigoOperacion(new BigDecimal(operacionesPadre.getIndex()));
			}
			else {
				inputConsutaHistoricoProceso.setCodigoOperacion(null);
			}
			
			
			String nombreObjeto = pantallaHistoricoCambios.getTxtObjeto().getText();
			inputConsutaHistoricoProceso.setNombreObjeto(nombreObjeto);
			
			/*String tipoObjeto = (String) pantallaHistoricoCambios.getCmbTipoObjeto().getSelectedItem();
			inputConsutaHistoricoProceso.setTipoObjeto(tipoObjeto);*/
			
			TiposObjeto tiposObjeto = (TiposObjeto) pantallaHistoricoCambios.getCmbTipoObjeto().getSelectedItem();
			if (!Objects.isNull(tiposObjeto)) {
				inputConsutaHistoricoProceso.setCodigoTipoObjeto(new BigDecimal(tiposObjeto.getIndex()));
			}
			else {
				inputConsutaHistoricoProceso.setCodigoTipoObjeto(null);
			}
			
			/*String tipoAccion = (String) pantallaHistoricoCambios.getCmbOperacion().getSelectedItem();
			inputConsutaHistoricoProceso.setTipoAccion(tipoAccion);*/
			
			Operaciones operaciones = (Operaciones) pantallaHistoricoCambios.getCmbOperacion().getSelectedItem();
			if (!Objects.isNull(operaciones)) {
				inputConsutaHistoricoProceso.setCodigoOperacion(new BigDecimal(operaciones.getIndex()));
			}
			else {
				inputConsutaHistoricoProceso.setCodigoOperacion(null);
			}
			
			String desde = pantallaHistoricoCambios.getTxtDesde().getText();
			String hasta = pantallaHistoricoCambios.getTxtHasta().getText();
			Date fechaDesde = (StringUtils.isNotBlank(desde)) ? dateBuscarFormatter.stringToDate(desde) : null;
			Date fechaHasta = (StringUtils.isNotBlank(hasta)) ? dateBuscarFormatter.stringToDate(hasta) : null;
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
			
			
			OutputConsultaHistoricoProceso outputConsultaHistoricoProceso = historicoService.consultarHistoricoProceso(inputConsutaHistoricoProceso);
			
			// Hay avisos
			if (outputConsultaHistoricoProceso.getResult() == 2) {
				ServiceException serviceException = outputConsultaHistoricoProceso.getServiceException();
				Map<String, Object> params = MDSQLUIHelper.buildWarnings(serviceException.getErrors());
				MDSQLUIHelper.showPopup(pantallaHistoricoCambios.getFrameParent(), MDSQLConstants.CMD_WARN, params);
			}
			
			populateModel(outputConsultaHistoricoProceso.getHistoricoProcesos());
			
			pantallaHistoricoCambios.getBtnResumen().setEnabled(Boolean.FALSE);
			pantallaHistoricoCambios.getBtnVerDetalle().setEnabled(Boolean.FALSE);
			
			
		} catch (ServiceException | ParseException e) {
			Map<String, Object> params = MDSQLUIHelper.buildError(e);
			MDSQLUIHelper.showPopup(pantallaHistoricoCambios.getFrameParent(), MDSQLConstants.CMD_ERROR, params);
		}

	}

	private void buscarModelo() {
		Map<String, Object> params = new HashMap<>();
		
		String codigoProyecto = pantallaHistoricoCambios.getTxtModelo().getText();
		if (StringUtils.isNotBlank(codigoProyecto)) {
			params.put("codigoProyecto", codigoProyecto);
		}

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
