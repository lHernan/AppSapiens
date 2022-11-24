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
import com.mdsql.ui.DlgExcepcion;
import com.mdsql.ui.DlgRechazar;
import com.mdsql.ui.PantallaDetalleScript;
import com.mdsql.ui.PantallaEjecutarScripts;
import com.mdsql.ui.PantallaRepararScript;
import com.mdsql.ui.PantallaVerCuadresScript;
import com.mdsql.ui.PantallaVerErroresScript;
import com.mdsql.ui.model.BBDDComboBoxModel;
import com.mdsql.ui.model.ScriptsTableModel;
import com.mdsql.ui.utils.ListenerSupport;
import com.mdsql.ui.utils.MDSQLUIHelper;
import com.mdsql.ui.utils.collections.ScriptSelectedClosure;
import com.mdsql.ui.utils.collections.ScriptSelectedPredicate;
import com.mdsql.ui.utils.collections.UpdateScriptsClosure;
import com.mdsql.utils.Constants;
import com.mdsql.utils.MDSQLAppHelper;
import com.mdsql.utils.collections.ScriptPredicate;
import com.mdval.exceptions.ServiceException;
import com.mdval.ui.utils.OnLoadListener;

public class PantallaEjecutarScriptsListener extends ListenerSupport implements ActionListener, OnLoadListener {

	private PantallaEjecutarScripts pantallaEjecutarScripts;

	public PantallaEjecutarScriptsListener(PantallaEjecutarScripts pantallaEjecutarScripts) {
		super();
		this.pantallaEjecutarScripts = pantallaEjecutarScripts;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton jButton = (JButton) e.getSource();

		if (Constants.PANTALLA_EJECUTAR_SCRIPTS_BTN_RECHAZAR.equals(jButton.getActionCommand())) {
			eventBtnRechazar();
		}

		if (Constants.PANTALLA_EJECUTAR_SCRIPTS_BTN_VER_LOG.equals(jButton.getActionCommand())) {
			eventBtnVerLog();
		}

		if (Constants.PANTALLA_EJECUTAR_SCRIPTS_BTN_DETALLE_SCRIPT.equals(jButton.getActionCommand())) {
			eventBtnDetalleScript();
		}

		if (Constants.PANTALLA_EJECUTAR_SCRIPTS_BTN_DESCARTAR.equals(jButton.getActionCommand())) {
			eventBtnDescartar();
		}

		if (Constants.PANTALLA_EJECUTAR_SCRIPTS_BTN_REPARAR.equals(jButton.getActionCommand())) {
			eventBtnReparar();
		}

		if (Constants.PANTALLA_EJECUTAR_SCRIPTS_BTN_VER_CUADRES.equals(jButton.getActionCommand())) {
			eventBtnVerCuadres();
		}

		if (Constants.PANTALLA_EJECUTAR_SCRIPTS_BTN_VER_ERRORES.equals(jButton.getActionCommand())) {
			eventBtnVerErrores();
		}

		if (Constants.PANTALLA_EJECUTAR_SCRIPTS_BTN_EXCEPCION.equals(jButton.getActionCommand())) {
			eventBtnExcepcion();
		}

		if (Constants.PANTALLA_EJECUTAR_SCRIPTS_BTN_ACEPTAR.equals(jButton.getActionCommand())) {
			eventBtnAceptar();
		}

		if (Constants.PANTALLA_EJECUTAR_SCRIPTS_BTN_CANCELAR.equals(jButton.getActionCommand())) {
			pantallaEjecutarScripts.getReturnParams().put("estado", "EN_CURSO");
			pantallaEjecutarScripts.dispose();
		}
	}

	private void eventBtnRechazar() {
		Map<String, Object> params = new HashMap<>();

		Proceso proceso = pantallaEjecutarScripts.getProceso();

		params.put("proceso", proceso);

		DlgRechazar dlgRechazar = (DlgRechazar) MDSQLUIHelper.createDialog(pantallaEjecutarScripts.getFrameParent(),
				Constants.CMD_RECHAZAR_PROCESADO, params);
		MDSQLUIHelper.show(dlgRechazar);

		proceso = (Proceso) dlgRechazar.getReturnParams().get("proceso");
		pantallaEjecutarScripts.getReturnParams().put("proceso", proceso);
		pantallaEjecutarScripts.getReturnParams().put("estado", "RECHAZADO");
		pantallaEjecutarScripts.dispose();
	}

	private void eventBtnVerLog() {

	}

	private void eventBtnDetalleScript() {
		Map<String, Object> params = new HashMap<>();

		Script seleccionado = pantallaEjecutarScripts.getSeleccionado();
		Proceso proceso = pantallaEjecutarScripts.getProceso();

		params.put("script", seleccionado);
		params.put("proceso", proceso);

		PantallaDetalleScript pantallaDetalleScript = (PantallaDetalleScript) MDSQLUIHelper
				.createDialog(pantallaEjecutarScripts.getFrameParent(), Constants.CMD_DETALLE_SCRIPT, params);
		MDSQLUIHelper.show(pantallaDetalleScript);
	}

	private void eventBtnDescartar() {

	}

	private void eventBtnReparar() {
		Map<String, Object> params = new HashMap<>();

		Script seleccionado = pantallaEjecutarScripts.getSeleccionado();
		Proceso proceso = pantallaEjecutarScripts.getProceso();

		params.put("script", seleccionado);
		params.put("proceso", proceso);

		PantallaRepararScript pantallaRepararScript = (PantallaRepararScript) MDSQLUIHelper
				.createDialog(pantallaEjecutarScripts.getFrameParent(), Constants.CMD_REPARAR_SCRIPT, params);
		MDSQLUIHelper.show(pantallaRepararScript);
	}

	private void eventBtnVerCuadres() {
		Map<String, Object> params = new HashMap<>();

		Script seleccionado = pantallaEjecutarScripts.getSeleccionado();
		Proceso proceso = pantallaEjecutarScripts.getProceso();

		params.put("script", seleccionado);
		params.put("proceso", proceso);

		PantallaVerCuadresScript pantallaVerCuadresScript = (PantallaVerCuadresScript) MDSQLUIHelper
				.createDialog(pantallaEjecutarScripts.getFrameParent(), Constants.CMD_VER_CUADRES_SCRIPT, params);
		MDSQLUIHelper.show(pantallaVerCuadresScript);
	}

	private void eventBtnVerErrores() {
		Map<String, Object> params = new HashMap<>();

		Script seleccionado = pantallaEjecutarScripts.getSeleccionado();
		Proceso proceso = pantallaEjecutarScripts.getProceso();

		params.put("script", seleccionado);
		params.put("proceso", proceso);
		params.put("tipo", "scripts");

		PantallaVerErroresScript pantallaVerErroresScript = (PantallaVerErroresScript) MDSQLUIHelper
				.createDialog(pantallaEjecutarScripts.getFrameParent(), Constants.CMD_VER_ERRORES_SCRIPT, params);
		MDSQLUIHelper.show(pantallaVerErroresScript);
	}

	private void eventBtnExcepcion() {
		Map<String, Object> params = new HashMap<>();

		Script seleccionado = pantallaEjecutarScripts.getSeleccionado();
		Proceso proceso = pantallaEjecutarScripts.getProceso();

		params.put("script", seleccionado);
		params.put("proceso", proceso);

		DlgExcepcion dlgExcepcion = (DlgExcepcion) MDSQLUIHelper.createDialog(pantallaEjecutarScripts.getFrameParent(),
				Constants.CMD_EXCEPCION_SCRIPT, params);
		MDSQLUIHelper.show(dlgExcepcion);
	}

	@SuppressWarnings("unchecked")
	private void eventBtnAceptar() {
		try {
			ScriptService scriptService = (ScriptService) getService(Constants.SCRIPT_SERVICE);

			Proceso proceso = pantallaEjecutarScripts.getProceso();
			BBDD bbdd = proceso.getBbdd();

			List<Script> vigente = ((ScriptsTableModel) pantallaEjecutarScripts.getTblVigente().getModel()).getData();
			List<Script> historico = ((ScriptsTableModel) pantallaEjecutarScripts.getTblHistorico().getModel())
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
			vigente = ((ScriptsTableModel) pantallaEjecutarScripts.getTblVigente().getModel()).getData();
			CollectionUtils.forAllDo(vigente, new UpdateScriptsClosure(ejecuciones));

			historico = ((ScriptsTableModel) pantallaEjecutarScripts.getTblHistorico().getModel()).getData();
			CollectionUtils.forAllDo(historico, new UpdateScriptsClosure(ejecuciones));

			pantallaEjecutarScripts.getTblVigente().repaint();
			pantallaEjecutarScripts.getTblHistorico().repaint();

			/**
			 * Si hay scripts en estado Descuadrado o Error, hay que desmarcar los
			 * siguientes y deshabilitar el botón Aceptar
			 */
			scripts = new ArrayList<>(CollectionUtils.union(vigente, historico));
			if (hayErrores(scripts)) {
				pantallaEjecutarScripts.getBtnAceptar().setEnabled(Boolean.FALSE);
			}

			// Actualizar los scripts en el proceso en sesión
			updateCurrentProcess(proceso, ejecuciones);

			pantallaEjecutarScripts.getTxtEstadoEjecucion().setText(proceso.getDescripcionEstadoProceso());

			/**
			 * Ver si todos los scripts están ejecutados y el estado del proceso es
			 * Ejecutado para mostrar la pantalla de resumen del procesado
			 */
			if (isAllExecuted(proceso.getScripts())) {
				pantallaEjecutarScripts.getReturnParams().put("idProceso", proceso.getIdProceso());
				pantallaEjecutarScripts.getReturnParams().put("entregar", Boolean.TRUE);
				pantallaEjecutarScripts.getReturnParams().put("cmd", Constants.PANTALLA_EJECUTAR_SCRIPTS_BTN_ACEPTAR);

				pantallaEjecutarScripts.dispose();
			}
		} catch (ServiceException e) {
			Map<String, Object> errParams = MDSQLUIHelper.buildError(e);
			MDSQLUIHelper.showPopup(pantallaEjecutarScripts.getFrameParent(), Constants.CMD_ERROR, errParams);
		}
	}

	@Override
	public void onLoad() {
		Proceso proceso = (Proceso) pantallaEjecutarScripts.getParams().get("proceso");
		pantallaEjecutarScripts.setProceso(proceso);

		List<BBDD> bbdds = proceso.getBbdds();
		if (CollectionUtils.isNotEmpty(bbdds)) {
			BBDDComboBoxModel modelBBDD = new BBDDComboBoxModel(bbdds);
			pantallaEjecutarScripts.getCmbBBDD().setModel(modelBBDD);
		}

		// Obtiene los scripts
		List<Script> scripts = proceso.getScripts();

		// Actualiza las tablas
		String[] filtroVigentes = { "SQL", "PDC" };
		List<Script> vigentes = filterListScriptsFrom(scripts, filtroVigentes);

		ScriptsTableModel tableModelVigente = (ScriptsTableModel) pantallaEjecutarScripts.getTblVigente().getModel();
		tableModelVigente.setData(vigentes);

		String[] filtroHistorico = { "SQLH", "PDCH" };
		List<Script> historicos = filterListScriptsFrom(scripts, filtroHistorico);

		ScriptsTableModel tableModelHistorico = (ScriptsTableModel) pantallaEjecutarScripts.getTblHistorico()
				.getModel();
		tableModelHistorico.setData(historicos);
	}

	/**
	 * @param scripts
	 * @param filtro
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private List<Script> filterListScriptsFrom(List<Script> scripts, String[] filtro) {
		List<Script> filteredList = new ArrayList<Script>(CollectionUtils.select(scripts, new ScriptPredicate(filtro)));
		// En principio estarán todos seleccionados
		CollectionUtils.forAllDo(filteredList, new ScriptSelectedClosure());

		return filteredList;
	}

	/**
	 * @param ejecuciones
	 */
	private void updateCurrentProcess(Proceso proceso, List<OutputRegistraEjecucion> ejecuciones) {
		List<Script> scripts = proceso.getScripts();
		CollectionUtils.forAllDo(scripts, new UpdateScriptsClosure(ejecuciones));

		if (CollectionUtils.isNotEmpty(ejecuciones)) {
			OutputRegistraEjecucion ejecucion = ejecuciones.get(0);
			proceso.setCodigoEstadoProceso(ejecucion.getCodigoEstadoProceso());
			proceso.setDescripcionEstadoProceso(ejecucion.getDescripcionEstadoProceso());
		}

		Session session = (Session) MDSQLAppHelper.getGlobalProperty(Constants.SESSION);
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
	private boolean hayErrores(List<Script> scripts) {
		for (Script script : scripts) {
			if ("Error".equals(script.getDescripcionEstadoScript())
					|| "Descuadrado".equals(script.getDescripcionEstadoScript())) {
				return Boolean.TRUE;
			}
		}
		return Boolean.FALSE;
	}
}
