package com.mdsql.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;

import org.apache.commons.collections.CollectionUtils;

import com.mdsql.bussiness.entities.BBDD;
import com.mdsql.bussiness.entities.OutputRegistraEjecucionType;
import com.mdsql.bussiness.entities.Proceso;
import com.mdsql.bussiness.entities.Script;
import com.mdsql.bussiness.entities.Session;
import com.mdsql.bussiness.entities.Type;
import com.mdsql.bussiness.service.ScriptService;
import com.mdsql.ui.DlgRechazar;
import com.mdsql.ui.PantallaEjecutarTypes;
import com.mdsql.ui.PantallaVerCuadresScript;
import com.mdsql.ui.PantallaVerErroresScript;
import com.mdsql.ui.model.TypesTableModel;
import com.mdsql.ui.utils.ListenerSupport;
import com.mdsql.ui.utils.MDSQLUIHelper;
import com.mdsql.ui.utils.collections.CreateTypeScriptsClosure;
import com.mdsql.utils.MDSQLAppHelper;
import com.mdsql.utils.MDSQLConstants;
import com.mdval.exceptions.ServiceException;
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
		Map<String, Object> params = new HashMap<>();

		Script seleccionado = pantallaEjecutarTypes.getSeleccionado();
		Proceso proceso = pantallaEjecutarTypes.getProceso();

		params.put("script", seleccionado);
		params.put("proceso", proceso);

		PantallaVerCuadresScript pantallaVerCuadresScript = (PantallaVerCuadresScript) MDSQLUIHelper
				.createDialog(pantallaEjecutarTypes.getFrameParent(), MDSQLConstants.CMD_VER_CUADRES_SCRIPT, params);
		MDSQLUIHelper.show(pantallaVerCuadresScript);
	}
	
	public void eventBtnVerErrores() {
		Map<String, Object> params = new HashMap<>();

		Proceso proceso = pantallaEjecutarTypes.getProceso();
		Script seleccionado = proceso.getScriptLanza();
		
		params.put("script", seleccionado);
		params.put("proceso", proceso);
		params.put("tipo", "type");

		PantallaVerErroresScript pantallaVerErroresScript = (PantallaVerErroresScript) MDSQLUIHelper
				.createDialog(pantallaEjecutarTypes.getFrameParent(), MDSQLConstants.CMD_VER_ERRORES_SCRIPT, params);
		MDSQLUIHelper.show(pantallaVerErroresScript);
	}
	
	public void eventBtnAceptar() {
		try {
			ScriptService scriptService = (ScriptService) getService(MDSQLConstants.SCRIPT_SERVICE);
			Proceso proceso = pantallaEjecutarTypes.getProceso();
			BBDD bbdd = proceso.getBbdd();
			
			Session session = (Session) MDSQLAppHelper.getGlobalProperty(MDSQLConstants.SESSION);
			String selectedRoute = session.getSelectedRoute();

			TypesTableModel tableModelTypes = (TypesTableModel) pantallaEjecutarTypes.getTblTypes()
					.getModel();
			List<Type> types = tableModelTypes.getData();
			
			CollectionUtils.forAllDo(types, new CreateTypeScriptsClosure(selectedRoute));
			
			// En este caso sólo se ejecuta el script lanza
			Script scriptLanza = proceso.getScriptLanza();
			
			OutputRegistraEjecucionType ejecucion = scriptService.executeScript(bbdd, scriptLanza.getNombreScript(), scriptLanza.getLineasScript());
			updateCurrentProcess(proceso, ejecucion);
			if ("Error".equals(ejecucion.getDescripcionEstadoProceso())) {
				pantallaEjecutarTypes.getBtnVerErrores().setEnabled(Boolean.TRUE);
				proceso.setDescripcionEstadoProceso(ejecucion.getDescripcionEstadoProceso());
				pantallaEjecutarTypes.getTxtEstadoEjecucion().setText(ejecucion.getDescripcionEstadoProceso());;
			}
			else {
				pantallaEjecutarTypes.getReturnParams().put("idProceso", proceso.getIdProceso());
				pantallaEjecutarTypes.getReturnParams().put("entregar", Boolean.TRUE);
				pantallaEjecutarTypes.getReturnParams().put("cmd", MDSQLConstants.PANTALLA_EJECUTAR_SCRIPTS_BTN_ACEPTAR);

				pantallaEjecutarTypes.dispose();
			}
			
		} catch (ServiceException e) {
			Map<String, Object> errParams = MDSQLUIHelper.buildError(e);
			MDSQLUIHelper.showPopup(pantallaEjecutarTypes.getFrameParent(), MDSQLConstants.CMD_ERROR, errParams);
		}
	}		

	@Override
	public void onLoad() {
		Proceso proceso = (Proceso) pantallaEjecutarTypes.getParams().get("proceso");
		pantallaEjecutarTypes.setProceso(proceso);

		// Obtiene los types
		List<Type> types = proceso.getTypes();
		TypesTableModel tableModelTypes = (TypesTableModel) pantallaEjecutarTypes.getTblTypes()
				.getModel();
		tableModelTypes.setData(types);
	}
	
	private void updateCurrentProcess(Proceso proceso, OutputRegistraEjecucionType ejecucion) {
		proceso.setCodigoEstadoProceso(ejecucion.getCodigoEstadoProceso());
		proceso.setDescripcionEstadoProceso(ejecucion.getDescripcionEstadoProceso());

		Session session = (Session) MDSQLAppHelper.getGlobalProperty(MDSQLConstants.SESSION);
		session.setProceso(proceso);
	}
}