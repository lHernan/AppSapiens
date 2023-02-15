package com.mdsql.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;

import org.apache.commons.collections.CollectionUtils;

import com.mdsql.bussiness.entities.BBDD;
import com.mdsql.bussiness.entities.OutputRegistraEjecucion;
import com.mdsql.bussiness.entities.Proceso;
import com.mdsql.bussiness.entities.Script;
import com.mdsql.bussiness.entities.Session;
import com.mdsql.bussiness.service.ScriptService;
import com.mdsql.ui.DlgRechazar;
import com.mdsql.ui.PantallaEjecutarTypes;
import com.mdsql.ui.PantallaVerCuadresScript;
import com.mdsql.ui.PantallaVerErroresScript;
import com.mdsql.ui.model.ScriptsTableModel;
import com.mdsql.ui.model.TypesTableModel;
import com.mdsql.ui.utils.ListenerSupport;
import com.mdsql.ui.utils.MDSQLUIHelper;
import com.mdsql.ui.utils.collections.ScriptSelectedPredicate;
import com.mdsql.ui.utils.collections.UpdateScriptsClosure;
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

		Script seleccionado = pantallaEjecutarTypes.getSeleccionado();
		Proceso proceso = pantallaEjecutarTypes.getProceso();

		params.put("script", seleccionado);
		params.put("proceso", proceso);
		params.put("tipo", "scripts");

		PantallaVerErroresScript pantallaVerErroresScript = (PantallaVerErroresScript) MDSQLUIHelper
				.createDialog(pantallaEjecutarTypes.getFrameParent(), MDSQLConstants.CMD_VER_ERRORES_SCRIPT, params);
		MDSQLUIHelper.show(pantallaVerErroresScript);
	}
	
	@SuppressWarnings("unchecked")
	public void eventBtnAceptar() {
		try {
			ScriptService scriptService = (ScriptService) getService(MDSQLConstants.SCRIPT_SERVICE);

			Proceso proceso = pantallaEjecutarTypes.getProceso();
			BBDD bbdd = proceso.getBbdd();

			List<Script> vigente = ((ScriptsTableModel) pantallaEjecutarTypes.getTblVigenteTypes().getModel()).getData();
			List<Script> historico = ((ScriptsTableModel) pantallaEjecutarTypes.getTblHistoricoTypes().getModel())
					.getData();

			// Filtrar los scripts seleccionados
			vigente = new ArrayList<>(CollectionUtils.select(vigente, new ScriptSelectedPredicate()));
			historico = new ArrayList<>(CollectionUtils.select(historico, new ScriptSelectedPredicate()));

			// Une los scripts y los ordena
			List<Script> scripts = new ArrayList<>(CollectionUtils.union(vigente, historico));
			Collections.sort(scripts, (left, right) -> left.getNumeroOrden().compareTo(right.getNumeroOrden()));

			// Ejecuta los scripts
			List<OutputRegistraEjecucion> ejecuciones = scriptService.executeScripts(bbdd, scripts);

			// Actualizar los scripts de las tablas y las repinta
			vigente = ((ScriptsTableModel) pantallaEjecutarTypes.getTblVigenteTypes().getModel()).getData();
			CollectionUtils.forAllDo(vigente, new UpdateScriptsClosure(ejecuciones));

			historico = ((ScriptsTableModel) pantallaEjecutarTypes.getTblHistoricoTypes().getModel()).getData();
			CollectionUtils.forAllDo(historico, new UpdateScriptsClosure(ejecuciones));

			/**
			 * Si hay scripts en estado Descuadrado o Error, hay que desmarcar los
			 * siguientes y deshabilitar el botón Aceptar
			 */
			scripts = new ArrayList<>(CollectionUtils.union(vigente, historico));
			Integer numeroOrden = hayErrores(scripts);
			if (numeroOrden > 0) {
				desmarcar(vigente, numeroOrden);
				desmarcar(historico, numeroOrden);
				pantallaEjecutarTypes.getBtnAceptar().setEnabled(Boolean.FALSE);
			}
			
			pantallaEjecutarTypes.getTblVigenteTypes().repaint();
			pantallaEjecutarTypes.getTblHistoricoTypes().repaint();

			// Actualizar los scripts en el proceso en sesión
			updateCurrentProcess(proceso, ejecuciones);

			pantallaEjecutarTypes.getTxtEstadoEjecucion().setText(proceso.getDescripcionEstadoProceso());

			/**
			 * Ver si todos los scripts están ejecutados y el estado del proceso es
			 * Ejecutado para mostrar la pantalla de resumen del procesado
			 */
			if (isAllExecuted(proceso.getScripts())) {
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

		// Obtiene los scripts
		List<Script> scripts = proceso.getScripts();
		TypesTableModel tableModelTypes = (TypesTableModel) pantallaEjecutarTypes.getTblVigenteTypes()
				.getModel();
		tableModelTypes.setData(scripts);
	}
	private void updateCurrentProcess(Proceso proceso, List<OutputRegistraEjecucion> ejecuciones) {
		List<Script> scripts = proceso.getScripts();
		CollectionUtils.forAllDo(scripts, new UpdateScriptsClosure(ejecuciones));

		if (CollectionUtils.isNotEmpty(ejecuciones)) {
			OutputRegistraEjecucion ejecucion = ejecuciones.get(0);
			proceso.setCodigoEstadoProceso(ejecucion.getCodigoEstadoProceso());
			proceso.setDescripcionEstadoProceso(ejecucion.getDescripcionEstadoProceso());
		}

		Session session = (Session) MDSQLAppHelper.getGlobalProperty(MDSQLConstants.SESSION);
		session.setProceso(proceso);
	}

	/**
	 * @param scripts
	 * @return
	 */
	private Boolean isAllExecuted(List<Script> scripts) {
		for (Script script : scripts) {
			if (!"Ejecutado".equals(script.getDescripcionEstadoScript())) {
				return Boolean.FALSE;
			}
		}
		return Boolean.TRUE;
	}

	/**
	 * @param scripts
	 * @return
	 */
	private Integer hayErrores(List<Script> scripts) {
		for (Script script : scripts) {
			if ("Error".equals(script.getDescripcionEstadoScript())
					|| "Descuadrado".equals(script.getDescripcionEstadoScript())) {
				return script.getNumeroOrden().intValue();
			}
		}
		return 0;
	}
	
	/**
	 * @param scripts
	 * @param numeroOrden
	 */
	private void desmarcar(List<Script> scripts, Integer numeroOrden) {
		for (Script script : scripts) {
			Integer orden = script.getNumeroOrden().intValue();
			
			if (orden > numeroOrden) {
				script.setSelected(Boolean.FALSE);
			}
		}
		
	}
}