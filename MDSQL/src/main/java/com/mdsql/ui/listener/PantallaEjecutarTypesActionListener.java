package com.mdsql.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;

import org.apache.commons.lang3.StringUtils;

import com.mdsql.bussiness.entities.SeleccionHistorico;
import com.mdsql.bussiness.service.ProcesoService;
import com.mdsql.bussiness.service.TypeService;
import com.mdsql.exceptions.ServiceException;
import com.mdsql.ui.PantallaEjecutarTypes;
import com.mdsql.ui.model.EjecutarTypesTableModel;
import com.mdsql.ui.model.ProcesarScriptNotaTableModel;
import com.mdsql.ui.model.SeleccionHistoricoTableModel;
import com.mdsql.ui.utils.ListenerSupport;
import com.mdsql.ui.utils.MDSQLUIHelper;
import com.mdsql.utils.Constants;

public class PantallaEjecutarTypesActionListener extends ListenerSupport implements ActionListener {

	private PantallaEjecutarTypes pantallaEjecutarTypes; 
	
	public PantallaEjecutarTypesActionListener(PantallaEjecutarTypes pantallaEjecutarTypes) {
		this.pantallaEjecutarTypes = pantallaEjecutarTypes;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton jButton = (JButton) e.getSource();
		
		if (Constants.PANTALLA_EJECUTAR_TYPES_BTN_RECHAZAR.equals(jButton.getActionCommand())) {
			eventBtnRechazar();
		}
		
		if (Constants.PANTALLA_EJECUTAR_TYPES_BTN_VER_CUADRES.equals(jButton.getActionCommand())) {
			eventBtnVerCuadres();
		}
		
		if (Constants.PANTALLA_EJECUTAR_TYPES_BTN_VER_ERRORES.equals(jButton.getActionCommand())) {
			eventBtnVerErrores();
		}
		
		if (Constants.PANTALLA_EJECUTAR_TYPES_BTN_ACEPTAR.equals(jButton.getActionCommand())) {
			eventBtnAceptar();
		}
		
		if (Constants.PANTALLA_EJECUTAR_TYPES_BTN_CANCELAR.equals(jButton.getActionCommand())) {
			eventBtnCancelar();
		}
		
	}
	
	public void eventBtnRechazar() {
		pantallaEjecutarTypes.getTxtEstadoEjecucion().setText(StringUtils.EMPTY);
		pantallaEjecutarTypes.getTxtModelo().setText(StringUtils.EMPTY);
		pantallaEjecutarTypes.getTxtSubmodelo().setText(StringUtils.EMPTY);
		pantallaEjecutarTypes.getTxtSD().setText(StringUtils.EMPTY);
		pantallaEjecutarTypes.getTxtSolicitadaPor().setText(StringUtils.EMPTY);
		pantallaEjecutarTypes.getTxtEsquema().setText(StringUtils.EMPTY);
		pantallaEjecutarTypes.getTxtBBDD().setText(StringUtils.EMPTY);
		
		((EjecutarTypesTableModel) pantallaEjecutarTypes.getTblTypes().getModel().clearData()).clearData();
		
		pantallaEjecutarTypes.getBtnRechazar().setEnabled(Boolean.FALSE);
		pantallaEjecutarTypes.getBtnVerCuadres().setEnabled(Boolean.FALSE);
		pantallaEjecutarTypes.getBtnVerErrores().setEnabled(Boolean.FALSE);
		pantallaEjecutarTypes.getBtnAceptar().setEnabled(Boolean.FALSE);
	}

	public void eventBtnVerCuadres() {
		
	}
	
	public void eventBtnVerErrores() {
		
	}
	
	public void eventBtnAceptar() {
		
	}
	
	public void eventBtnCancelar() {
		pantallaEjecutarTypes.dispose();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void onLoad() {
		try {
			TypeService typeService = (TypeService) getService(Constants.PROCESO_SERVICE);

			String typeProyecto = (String) pantallaEjecutarTypes.getParams().get("codigoProyecto");

			// TODO - Preguntar cómo añadir los objetos nuevos

			if (checkAllConfigured(
					(EjecutarTypesTableModel) pantallaEjecutarTypes.getTblTypes().getModel())) {
				pantallaEjecutarTypes.getBtnRechazar().setEnabled(Boolean.FALSE);
			}
		} catch (ServiceException e) {
			Map<String, Object> params = MDSQLUIHelper.buildError(e);
			MDSQLUIHelper.showPopup(pantallaEjecutarTypes.getFrameParent(), Constants.CMD_ERROR, params);
		}
	}
	
}
