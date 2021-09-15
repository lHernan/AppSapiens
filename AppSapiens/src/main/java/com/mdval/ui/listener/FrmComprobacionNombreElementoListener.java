package com.mdval.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import com.mdval.bussiness.entities.Modelo;
import com.mdval.bussiness.entities.SubProyecto;
import com.mdval.bussiness.entities.TipoElemento;
import com.mdval.bussiness.entities.ValidaParticula;
import com.mdval.bussiness.service.TipoElementoService;
import com.mdval.bussiness.service.ValidacionService;
import com.mdval.ui.consultas.FrmComprobacionNombreElemento;
import com.mdval.ui.model.SubProyectoComboBoxModel;
import com.mdval.ui.model.TipoElementoComboBoxModel;
import com.mdval.ui.model.ValidaParticulaTableModel;
import com.mdval.ui.modelos.FrmDefinicionModelos;
import com.mdval.ui.utils.ListenerSupport;
import com.mdval.ui.utils.OnLoadListener;
import com.mdval.ui.utils.UIHelper;
import com.mdval.utils.AppHelper;
import com.mdval.utils.Constants;

/**
 * @author federico
 *
 */
public class FrmComprobacionNombreElementoListener extends ListenerSupport implements ActionListener, OnLoadListener, Observer {

	private FrmComprobacionNombreElemento frmComprobacionNombreElemento;
	
	private FrmDefinicionModelos frmDefinicionModelos;

	public FrmComprobacionNombreElementoListener(FrmComprobacionNombreElemento frmComprobacionNombreElemento) {
		super();
		this.frmComprobacionNombreElemento = frmComprobacionNombreElemento;
	}
	
	public void addObservador(Observer o) {
		this.addObserver(o);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton jButton = (JButton) e.getSource();

		if (Constants.FRM_COMPROBACION_NOMBRE_ELEMENTO_BTN_BUSCAR.equals(jButton.getActionCommand())) {
			eventBtnBuscarModelo();
		}
		
		if (Constants.FRM_COMPROBACION_NOMBRE_ELEMENTO_BTN_COMPROBAR.equals(jButton.getActionCommand())) {
			eventBtnComprobar();
		}
	}

	/**
	 * 
	 */
	private void eventBtnBuscarModelo() {
		Map<String, Object> params = new HashMap<>();
		params.put("fromMenu", Boolean.FALSE);
		
		frmDefinicionModelos = (FrmDefinicionModelos) UIHelper.createFrame(Constants.CMD_BUSCAR_MODELOS, params);
		UIHelper.show(frmDefinicionModelos);

		frmDefinicionModelos.getFrmDefinicionModelosListener().addObservador(this);
	}

	/**
	 * 
	 */
	private void eventBtnComprobar() {
		try {
			String sCodigoNorma = frmComprobacionNombreElemento.getTxtCodNorma().getText();
			BigDecimal codigoNorma = AppHelper.toBigDecimal(sCodigoNorma);
			
			String codigoProyecto = frmComprobacionNombreElemento.getTxtModeloProyecto().getText();
			
			String codSubModelo = StringUtils.EMPTY;
			SubProyecto selectedSubProyecto = (SubProyecto) frmComprobacionNombreElemento.getCmbSubmodelo().getSelectedItem();
			if (!Objects.isNull(selectedSubProyecto)) {
				codSubModelo = selectedSubProyecto.getCodigoSubProyecto();
			}
			
			BigDecimal codigoElemento = null;
			TipoElemento selectedTipoElemento = (TipoElemento) frmComprobacionNombreElemento.getCmbElemento().getSelectedItem();
			if (!Objects.isNull(selectedTipoElemento)) {
				codigoElemento = selectedTipoElemento.getCodigoElemento();
			}
			
			String nombreComprobar = frmComprobacionNombreElemento.getTxtNombreComprobar().getText();
			
			List<ValidaParticula> validaciones = comprobar(codigoNorma, codigoProyecto, codSubModelo, codigoElemento, nombreComprobar);
			populateModel(validaciones);
		} catch (Exception e) {
			Map<String, Object> params = buildError(e);
			showPopup(frmComprobacionNombreElemento, Constants.CMD_ERROR, params);
		}
	}
	
	/**
	 * @param codigoNorma
	 * @param codigoProyecto
	 * @param codigoSubProyecto
	 * @param codigoElemento
	 * @param nombreElemento
	 * @return
	 */
	private List<ValidaParticula> comprobar(BigDecimal codigoNorma, String codigoProyecto, String codigoSubProyecto, BigDecimal codigoElemento, String nombreElemento) {
		ValidacionService validacionService = (ValidacionService) getService(Constants.VALIDACION_SERVICE);
		List<ValidaParticula> validaciones = validacionService.validarElemento(codigoNorma, codigoProyecto, codigoSubProyecto, codigoElemento, nombreElemento);
		return validaciones;
	}

	/**
	 * Vuelca la lista de glosarios encontrados en la tabla
	 * 
	 * @return
	 */
	private void populateModel(List<ValidaParticula> validaciones) {
		// Obtiene el modelo y lo actualiza
		ValidaParticulaTableModel tableModel = (ValidaParticulaTableModel) frmComprobacionNombreElemento
				.getTblValidaParticula().getModel();
		tableModel.setData(validaciones);
	}

	/**
	 *
	 */
	@Override
	public void onLoad() {
		TipoElementoService tipoElementoService = (TipoElementoService) getService(Constants.TIPO_ELEMENTO_SERVICE);
		
		List<TipoElemento> elementos = tipoElementoService.consultarTiposElementos(StringUtils.EMPTY);
		
		TipoElementoComboBoxModel modelElementos = new TipoElementoComboBoxModel(elementos);
		frmComprobacionNombreElemento.getCmbElemento().setModel(modelElementos);
	}

	@Override
	public void update(Observable o, Object arg) {
		String cmd = (String) arg;
		
		if (Constants.FRM_DEFINICION_MODELOS_BTN_SELECCIONAR.equals(cmd)) {
			Modelo seleccionado = frmDefinicionModelos.getSeleccionado();
			
			if (!Objects.isNull(seleccionado)) {
				frmComprobacionNombreElemento.getTxtModeloProyecto().setText(seleccionado.getCodigoProyecto());
				List<SubProyecto> subProyectos = seleccionado.getSubProyectos();
				
				if (CollectionUtils.isNotEmpty(subProyectos)) {
					SubProyectoComboBoxModel modelSubProyectos = new SubProyectoComboBoxModel(subProyectos);
					frmComprobacionNombreElemento.getCmbSubmodelo().setModel(modelSubProyectos);
				}
 			}
		}
	}
}
