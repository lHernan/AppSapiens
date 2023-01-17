package com.mdsql.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;

import com.mdsql.bussiness.entities.Proceso;
import com.mdsql.bussiness.entities.Script;
import com.mdsql.ui.DlgRechazar;
import com.mdsql.ui.PantallaEjecutarTypes;
import com.mdsql.ui.model.TypesTableModel;
import com.mdsql.ui.utils.ListenerSupport;
import com.mdsql.ui.utils.MDSQLUIHelper;
import com.mdsql.utils.MDSQLConstants;
import com.mdval.ui.utils.OnLoadListener;

public class PantallaEjecutarTypesActionListener extends ListenerSupport implements ActionListener, OnLoadListener {

	private PantallaEjecutarTypes pantallaEjecutarTypes; 
	
	public PantallaEjecutarTypesActionListener(PantallaEjecutarTypes pantallaEjecutarTypes) {
		this.pantallaEjecutarTypes = pantallaEjecutarTypes;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton jButton = (JButton) e.getSource();
		
		if (MDSQLConstants.PANTALLA_EJECUTAR_TYPES_BTN_RECHAZAR.equals(jButton.getActionCommand())) {
			eventBtnRechazar();
		}
		
		if (MDSQLConstants.PANTALLA_EJECUTAR_TYPES_BTN_VER_CUADRES.equals(jButton.getActionCommand())) {
			eventBtnVerCuadres();
		}
		
		if (MDSQLConstants.PANTALLA_EJECUTAR_TYPES_BTN_VER_ERRORES.equals(jButton.getActionCommand())) {
			eventBtnVerErrores();
		}
		
		if (MDSQLConstants.PANTALLA_EJECUTAR_TYPES_BTN_ACEPTAR.equals(jButton.getActionCommand())) {
			eventBtnAceptar();
		}
		
		if (MDSQLConstants.PANTALLA_EJECUTAR_TYPES_BTN_CANCELAR.equals(jButton.getActionCommand())) {
			pantallaEjecutarTypes.dispose();
		}
		
	}
	
	public void eventBtnRechazar() {
		Map<String, Object> params = new HashMap<>();

		Proceso proceso = pantallaEjecutarTypes.getProceso();

		params.put("proceso", proceso);

		DlgRechazar dlgRechazar = (DlgRechazar) MDSQLUIHelper.createDialog(pantallaEjecutarTypes.getFrameParent(),
				MDSQLConstants.CMD_RECHAZAR_PROCESADO, params);
		MDSQLUIHelper.show(dlgRechazar);

		proceso = (Proceso) dlgRechazar.getReturnParams().get("proceso");
		pantallaEjecutarTypes.getReturnParams().put("proceso", proceso);
		pantallaEjecutarTypes.getReturnParams().put("estado", "RECHAZADO");
		pantallaEjecutarTypes.dispose();
	}

	public void eventBtnVerCuadres() {
		
	}
	
	public void eventBtnVerErrores() {
		
	}
	
	public void eventBtnAceptar() {
		
	}
	
	@Override
	public void onLoad() {
		Proceso proceso = (Proceso) pantallaEjecutarTypes.getParams().get("proceso");
		pantallaEjecutarTypes.setProceso(proceso);

		// Obtiene los scripts
		List<Script> scripts = proceso.getScripts();
		TypesTableModel tableModelTypes = (TypesTableModel) pantallaEjecutarTypes.getTblTypes()
				.getModel();
		tableModelTypes.setData(scripts);
	}
}
