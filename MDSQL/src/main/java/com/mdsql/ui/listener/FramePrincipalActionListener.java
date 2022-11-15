package com.mdsql.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import com.mdsql.bussiness.entities.Proceso;
import com.mdsql.bussiness.entities.Script;
import com.mdsql.bussiness.entities.Session;
import com.mdsql.bussiness.entities.TextoLinea;
import com.mdsql.bussiness.entities.Type;
import com.mdsql.ui.FramePrincipal;
import com.mdsql.ui.PantallaEjecutarScripts;
import com.mdsql.ui.PantallaEjecutarTypes;
import com.mdsql.ui.PantallaProcesarScript;
import com.mdsql.ui.model.FramePrincipalTypesTableModel;
import com.mdsql.ui.utils.ListenerSupport;
import com.mdsql.ui.utils.MDSQLUIHelper;
import com.mdsql.utils.Constants;
import com.mdsql.utils.Constants.Procesado;
import com.mdsql.utils.MDSQLAppHelper;
import com.mdval.ui.utils.DialogSupport;
import com.mdval.ui.utils.OnLoadListener;
import com.mdval.utils.LogWrapper;

import lombok.extern.slf4j.Slf4j;

/**
 * @author federico
 *
 */
@Slf4j
public class FramePrincipalActionListener extends ListenerSupport implements ActionListener, OnLoadListener {

	private FramePrincipal framePrincipal;

	private PantallaProcesarScript pantallaProcesarScript;
	
	private DialogSupport pantallaEjecutar;

	/**
	 * @param framePrincipal
	 */
	public FramePrincipalActionListener(FramePrincipal framePrincipal) {
		this.framePrincipal = framePrincipal;
	}

	/**
	 *
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton jButton = (JButton) e.getSource();

		if (Constants.FRAME_PRINCIPAL_LOAD_SCRIPT.equals(jButton.getActionCommand())) {
			evtLoadScript();
		}

		if (Constants.FRAME_PRINCIPAL_CARGAR_SCRIPT_OBJETOS.equals(jButton.getActionCommand())) {
			evtLoadScriptObjects();
		}

		if (Constants.FRAME_PRINCIPAL_PROCESAR_SCRIPT.equals(jButton.getActionCommand())) {
			evtProcesarScript();
		}

		if (Constants.FRAME_PRINCIPAL_SAVE.equals(jButton.getActionCommand())) {
			evtGuardarScript();
		}

		if (Constants.FRAME_PRINCIPAL_LIMPIAR_SCRIPT.equals(jButton.getActionCommand())) {
			evtLimpiarScript();
		}

		if (Constants.FRAME_PRINCIPAL_EXECUTE.equals(jButton.getActionCommand())) {
			evtEjecutar();
		}

		if (Constants.FRAME_PRINCIPAL_PROCESADO_CURSO.equals(jButton.getActionCommand())) {
			evtProcesadoEnCurso();
		}

		if (Constants.FRAME_PRINCIPAL_ENTREGAR_PROCESADO.equals(jButton.getActionCommand())) {
			evtEntregarScript();
		}

		if (Constants.FRAME_PRINCIPAL_BTN_UNDO.equals(jButton.getActionCommand())) {
			evtUndo();
		}

		if (Constants.FRAME_PRINCIPAL_BTN_REDO.equals(jButton.getActionCommand())) {
			evtRedo();
		}

		if (Constants.FRAME_PRINCIPAL_BTN_CUT.equals(jButton.getActionCommand())) {
			framePrincipal.getTxtSQLCode().cut();
		}

		if (Constants.FRAME_PRINCIPAL_BTN_COPY.equals(jButton.getActionCommand())) {
			framePrincipal.getTxtSQLCode().copy();
		}

		if (Constants.FRAME_PRINCIPAL_BTN_PASTE.equals(jButton.getActionCommand())) {
			framePrincipal.getTxtSQLCode().paste();
		}
	}

	private void evtEntregarScript() {
		Session session = (Session) MDSQLAppHelper.getGlobalProperty(Constants.SESSION);
		Proceso proceso = session.getProceso();

		if (!Objects.isNull(proceso) && "Ejecutado".equals(proceso.getDescripcionEstadoProceso())) {
			DialogSupport dialog = MDSQLUIHelper.createDialog(framePrincipal, Constants.CMD_ENTREGAR_SCRIPT);
			MDSQLUIHelper.show(dialog);
		
			updateProcesadoEnCurso(Constants.CMD_ENTREGAR_SCRIPT);
		}
	}

	/**
	 * 
	 */
	private void evtProcesadoEnCurso() {

		Map<String, Object> params = new HashMap<>();

		Session session = (Session) MDSQLAppHelper.getGlobalProperty(Constants.SESSION);
		Proceso proceso = session.getProceso();

		if (!Objects.isNull(proceso)) {
			params.put("proceso", proceso);

			DialogSupport procesadoEnCurso = MDSQLUIHelper.createDialog(framePrincipal,
					Constants.CMD_PROCESADO_EN_CURSO, params);
			MDSQLUIHelper.show(procesadoEnCurso);
		} else {
			// Aviso de que no hay procesado en curso
			JOptionPane.showMessageDialog(framePrincipal, "No hay procesado en curso");
		}

	}

	/**
	 * Opción seleccionada: "Deshacer".
	 * 
	 * Deshace el último cambio realizado en el documento actual.
	 */
	private void evtUndo() {
		try {
			// deshace el último cambio realizado sobre el documento en el área de edición
			framePrincipal.getUndoManager().undo();
		} catch (CannotUndoException ex) { // en caso de que ocurra una excepción
			Map<String, Object> params = MDSQLUIHelper.buildError(ex);
			MDSQLUIHelper.showPopup(framePrincipal, Constants.CMD_ERROR, params);
		}

		// actualiza el estado de las opciones "Deshacer" y "Rehacer"
		framePrincipal.updateEditionControls();
	}

	/**
	 * Opción seleccionada: "Rehacer".
	 * 
	 * Rehace el último cambio realizado en el documento actual.
	 */
	private void evtRedo() {
		try {
			// rehace el último cambio realizado sobre el documento en el área de edición
			framePrincipal.getUndoManager().redo();
		} catch (CannotRedoException ex) { // en caso de que ocurra una excepción
			Map<String, Object> params = MDSQLUIHelper.buildError(ex);
			MDSQLUIHelper.showPopup(framePrincipal, Constants.CMD_ERROR, params);
		}

		// actualiza el estado de las opciones "Deshacer" y "Rehacer"
		framePrincipal.updateEditionControls();
	}

	/**
	 * 
	 */
	private void evtGuardarScript() {
		if (!Objects.isNull(framePrincipal.getCurrentFile())) {
			if (confirmSave()) {
				actionSave();
			} else {
				// Aviso de que no se ha modificado
				JOptionPane.showMessageDialog(framePrincipal, "El script no se ha modificado");
			}
		}
	}

	/**
	 * 
	 */
	private void evtLimpiarScript() {
		Session session = (Session) MDSQLAppHelper.getGlobalProperty(Constants.SESSION);
		Proceso proceso = session.getProceso();
		
		if (Objects.isNull(proceso)) {
			resetFramePrincipal();
		} else {
			if ("Entregado".equals(proceso.getDescripcionEstadoProceso())) {
				resetFramePrincipal();
			}
		}
	}

	/**
	 * 
	 */
	private void evtLoadScript() {
		if (confirmSave()) {
			actionSave();
		}

		resetFramePrincipal();

		File file = loadScript();
		if (!Objects.isNull(file)) {
			try {
				setContent(file);
				framePrincipal.setCurrentFile(file);

				framePrincipal.getTabPanel().setEnabledAt(0, Boolean.TRUE);
				framePrincipal.getTabPanel().setEnabledAt(1, Boolean.TRUE);
				framePrincipal.getTabPanel().setEnabledAt(2, Boolean.FALSE);

				framePrincipal.getTabPanel().setSelectedIndex(0);

				// set the procesado
				framePrincipal.setProcesado(Procesado.SCRIPT);
			} catch (IOException e1) {
				Map<String, Object> params = MDSQLUIHelper.buildError(e1);
				MDSQLUIHelper.showPopup(framePrincipal, Constants.CMD_ERROR, params);
			}
		}
	}

	/**
	 * 
	 */
	private void evtLoadScriptObjects() {
		if (confirmSave()) {
			actionSave();
		}

		resetFramePrincipal();

		File file = loadScript();
		if (!Objects.isNull(file)) {
			try {
				setContent(file);
				framePrincipal.setCurrentFile(file);

				framePrincipal.getTabPanel().setEnabledAt(0, Boolean.FALSE);
				framePrincipal.getTabPanel().setEnabledAt(1, Boolean.FALSE);
				framePrincipal.getTabPanel().setEnabledAt(2, Boolean.TRUE);

				framePrincipal.getTabPanel().setSelectedIndex(2);

				// set the procesado
				framePrincipal.setProcesado(Procesado.TYPE);
			} catch (IOException e1) {
				Map<String, Object> params = MDSQLUIHelper.buildError(e1);
				MDSQLUIHelper.showPopup(framePrincipal, Constants.CMD_ERROR, params);
			}
		}
	}

	/**
	 * 
	 */
	@SuppressWarnings("unchecked")
	private void evtProcesarScript() {
		Session session = (Session) MDSQLAppHelper.getGlobalProperty(Constants.SESSION);
		Proceso proceso = session.getProceso();

		if (!Objects.isNull(proceso)) {
			// Aviso de que no hay procesado en curso
			JOptionPane.showMessageDialog(framePrincipal,
					"Ya hay un procesado en curso. Debe finalizarlo o rechazarlo pulsando sobre Ejecutar script");
		} else {
			Map<String, Object> params = new HashMap<>();
			params.put("procesado", framePrincipal.getProcesado());
			// Update session
			session.setProcesado(framePrincipal.getProcesado());
			
			// Las líneas del script vienen directamente del text area
			params.put("script", MDSQLUIHelper.toTextoLineas(framePrincipal.getTxtSQLCode()));
			params.put("file", framePrincipal.getCurrentFile());

			pantallaProcesarScript = (PantallaProcesarScript) MDSQLUIHelper.createDialog(framePrincipal,
					Constants.CMD_PROCESAR_SCRIPT, params);
			MDSQLUIHelper.show(pantallaProcesarScript);
			
			
			if (Procesado.SCRIPT.equals(framePrincipal.getProcesado())) {
				List<Script> scripts = (List<Script>) pantallaProcesarScript.getReturnParams().get("scripts");
				fillProcesadoScript(scripts);
			}

			if (Procesado.TYPE.equals(framePrincipal.getProcesado())) {
				List<Type> types = (List<Type>) pantallaProcesarScript.getReturnParams().get("types");
				fillProcesadoType(types);
			}

			framePrincipal.getTxtSQLCode().setEditable(Boolean.FALSE);
			framePrincipal.getTxtSQLCode().setEnabled(Boolean.FALSE);

			updateProcesadoEnCurso(Constants.CMD_PROCESAR_SCRIPT);
		}
	}

	/**
	 * 
	 */
	private void evtEjecutar() {
		Session session = (Session) MDSQLAppHelper.getGlobalProperty(Constants.SESSION);
		Proceso proceso = session.getProceso();

		if (!Objects.isNull(proceso)) {
			Map<String, Object> params = new HashMap<>();
			params.put("proceso", proceso);
			
			String item = StringUtils.EMPTY;
			if (Procesado.SCRIPT.equals(framePrincipal.getProcesado())) {
				item = Constants.CMD_EJECUTAR_SCRIPT;
				pantallaEjecutar = (PantallaEjecutarScripts) MDSQLUIHelper.createDialog(framePrincipal, item, params);
				MDSQLUIHelper.show(pantallaEjecutar);
			}

			if (Procesado.TYPE.equals(framePrincipal.getProcesado())) {
				item = Constants.CMD_EJECUTAR_TYPE;
				pantallaEjecutar = (PantallaEjecutarTypes) MDSQLUIHelper.createDialog(framePrincipal, item, params);
				MDSQLUIHelper.show(pantallaEjecutar);
			}
			
			String estado = (String) pantallaEjecutar.getReturnParams().get("estado");
			if ("RECHAZADO".equals(estado)) {
				resetFramePrincipal();
			}
			
			updateProcesadoEnCurso(item);
		} else {
			// Aviso de que no hay procesado en curso
			JOptionPane.showMessageDialog(framePrincipal, "Es necesario procesar un script");
		}
	}

	/**
	 * @return
	 */
	private File loadScript() {
		File file = null;

		DialogSupport dialog = MDSQLUIHelper.createDialog(framePrincipal, Constants.CMD_LOAD_SCRIPT);
		MDSQLUIHelper.show(dialog);

		String rutaInicial = (String) dialog.getReturnParams().get("RutaInicial");
		if (StringUtils.isNotBlank(rutaInicial)) {
			file = selectFile(rutaInicial);
		}

		return file;
	}

	/**
	 * @param file
	 * @throws IOException
	 */
	private void setContent(File file) throws IOException {
		framePrincipal.getTxtSQLCode().setText(StringUtils.EMPTY);
		dumpContentToText(file, framePrincipal.getTxtSQLCode());

		framePrincipal.getTxtSQLCode().getDocument().addUndoableEditListener(framePrincipal.getEditorEventHandler());

		framePrincipal.getUndoManager().die(); // se limpia el buffer del administrador de edición
		framePrincipal.updateEditionControls(); // se actualiza el estado de las
		// opciones "Deshacer" y "Rehacer"

		framePrincipal.getFrmSQLScript().setTitle(file.getName());
		framePrincipal.setHasChanged(Boolean.FALSE);

		framePrincipal.getTxtSQLCode().setEditable(Boolean.TRUE);
		framePrincipal.getTxtSQLCode().setEnabled(Boolean.TRUE);
	}

	/**
	 * @param rutaInicial
	 * @return
	 */
	private File selectFile(String rutaInicial) {
		File file = null;

		JFileChooser chooser = getJFileChooser();
		chooser.setCurrentDirectory(new File(rutaInicial));
		//
		// disable the "All files" option.
		//
		chooser.setAcceptAllFileFilterUsed(false);
		//
		if (chooser.showOpenDialog(framePrincipal) == JFileChooser.APPROVE_OPTION) {
			file = chooser.getSelectedFile();
			LogWrapper.debug(log, "Archivo seleccionado: %s", file.getAbsolutePath());
			String ruta = file.getParent();
			
			Session session = (Session) MDSQLAppHelper.getGlobalProperty(Constants.SESSION);
			session.setSelectedRoute(ruta);
			LogWrapper.debug(log, "Ruta global: %s", session.getSelectedRoute());
		}

		return file;
	}

	/**
	 * @param file
	 * @param txtScript
	 */
	private void dumpContentToText(File file, JTextArea txtScript) throws IOException {
		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

			String line = reader.readLine();

			while (line != null) {
				txtScript.append(line);
				txtScript.append("\n");

				line = reader.readLine();
			}
		}
	}

	/**
	 * @param file
	 * @param txtScript
	 */
	private void dumpContentToText(List<TextoLinea> lineas, JTextArea txtScript) {

		for (TextoLinea linea : lineas) {
			txtScript.append(linea.getValor());
			txtScript.append("\n");
		}
	}

	/**
	 * @return
	 */
	private Boolean confirmSave() {
		Boolean hasChanged = framePrincipal.getHasChanged();
		if (!Objects.isNull(hasChanged) && Boolean.TRUE.equals(hasChanged)) { // si el documento esta marcado como
																				// modificado
			// le ofrece al usuario guardar los cambios
			int option = JOptionPane.showConfirmDialog(framePrincipal, "¿Desea guardar los cambios?");

			switch (option) {
			case JOptionPane.YES_OPTION: // si elige que si
				return Boolean.TRUE; // guarda el archivo
			case JOptionPane.CANCEL_OPTION: // si elige cancelar
				return Boolean.FALSE; // cancela esta operación
			// en otro caso se continúa con la operación y no se guarda el documento actual
			}
		}

		return Boolean.FALSE;
	}

	/**
	 * Opción seleccionada: "Guardar".
	 * 
	 * Guarda el documento actual en el archivo asociado actualmente.
	 */
	private void actionSave() {
		if (Objects.isNull(framePrincipal.getCurrentFile())) { // si no hay un archivo asociado al documento actual
			actionSaveAs(); // invoca el método actionSaveAs()
		} else if (framePrincipal.getHasChanged()) { // si el documento esta marcado como modificado
			try {
				// abre un flujo de datos hacia el archivo asociado al documento actual
				BufferedWriter bw = new BufferedWriter(new FileWriter(framePrincipal.getCurrentFile()));
				// escribe desde el flujo de datos hacia el archivo
				framePrincipal.getTxtSQLCode().write(bw);
				bw.close(); // cierra el flujo

				// marca el estado del documento como no modificado
				framePrincipal.setHasChanged(Boolean.FALSE);

				framePrincipal.getUndoManager().die(); // se limpia el buffer del administrador de edición
				framePrincipal.updateEditionControls(); // se actualiza el estado de las

				// Le pone el nombre del archivo al título del editor
				framePrincipal.getFrmSQLScript().setTitle(framePrincipal.getCurrentFile().getName());
			} catch (IOException ex) { // en caso de que ocurra una excepción
				Map<String, Object> params = MDSQLUIHelper.buildError(ex);
				MDSQLUIHelper.showPopup(framePrincipal, Constants.CMD_ERROR, params);
			}
		}
	}

	/**
	 * Opción seleccionada: "Guardar como".
	 * 
	 * Le permite al usuario elegir la ubicación donde se guardará el documento
	 * actual.
	 */
	private void actionSaveAs() {
		JFileChooser fc = getJFileChooser(); // obtiene un JFileChooser

		// presenta un dialogo modal para que el usuario seleccione un archivo
		int state = fc.showSaveDialog(framePrincipal);
		if (state == JFileChooser.APPROVE_OPTION) { // si elige guardar en el archivo
			File f = fc.getSelectedFile(); // obtiene el archivo seleccionado

			try {
				// abre un flujo de datos hacia el archivo asociado seleccionado
				BufferedWriter bw = new BufferedWriter(new FileWriter(f));
				// escribe desde el flujo de datos hacia el archivo
				framePrincipal.getTxtSQLCode().write(bw);
				bw.close(); // cierra el flujo

				// nuevo título de la ventana con el nombre del archivo guardado
				framePrincipal.getFrmSQLScript().setTitle(f.getName());

				// establece el archivo guardado como el archivo actual
				framePrincipal.setCurrentFile(f);
				// marca el estado del documento como no modificado
				framePrincipal.setHasChanged(Boolean.FALSE);
			} catch (IOException ex) { // en caso de que ocurra una excepción
				Map<String, Object> params = MDSQLUIHelper.buildError(ex);
				MDSQLUIHelper.showPopup(framePrincipal, Constants.CMD_ERROR, params);
			}
		}
	}

	/**
	 * @return
	 */
	private JFileChooser getJFileChooser() {
		JFileChooser chooser = new JFileChooser();
		chooser.setDialogTitle(literales.getLiteral("panelPrincipal.tituloChooser"));
		chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

		return chooser;
	}

	/**
	 * 
	 */
	private void resetFramePrincipal() {
		/// limpia el contenido del area de edición
		framePrincipal.getTxtSQLCode().setText(StringUtils.EMPTY);
		framePrincipal.getFrmSQLScript().setTitle(StringUtils.EMPTY);

		framePrincipal.getUndoManager().die(); // limpia el buffer del administrador de edición
		framePrincipal.updateEditionControls(); // actualiza el estado de las opciones "Deshacer" y "Rehacer"

		// marca el estado del documento como no modificado
		framePrincipal.setHasChanged(Boolean.FALSE);

		framePrincipal.disableEditionButtons();
		framePrincipal.disableTabs();
		framePrincipal.resetFrames();

		framePrincipal.setCurrentFile(null);
	}

	/**
	 * 
	 */
	private void updateProcesadoEnCurso(String cmd) {
		Session session = (Session) MDSQLAppHelper.getGlobalProperty(Constants.SESSION);
		Proceso proceso = session.getProceso();
		
		if (Constants.CMD_PROCESAR_SCRIPT.equals(cmd)) {
			proceso = (Proceso) pantallaProcesarScript.getReturnParams().get("proceso");
		}
		
		if (Constants.CMD_EJECUTAR_SCRIPT.equals(cmd) || Constants.CMD_EJECUTAR_TYPE.equals(cmd)) {
			Proceso p = (Proceso) pantallaEjecutar.getReturnParams().get("proceso");
			
			if ((!Objects.isNull(p))) {
				if ("Rechazado".equals(p.getDescripcionEstadoProceso())) {
					proceso = null;
				}
				else {
					proceso = p;
				}
			}
		}
		
		if (Constants.CMD_ENTREGAR_SCRIPT.equals(cmd)) {
			proceso = null;
		}
		
		session.setProceso(proceso);
		
		// Save session to disk
		MDSQLAppHelper.serializeToDisk(session, Constants.SESSION);
	}

	/**
	 * @param types
	 */
	private void fillProcesadoType(List<Type> types) {
		// Obtiene el modelo y lo actualiza
		FramePrincipalTypesTableModel tableModel = (FramePrincipalTypesTableModel) framePrincipal.getJTable1()
				.getModel();
		tableModel.setData(types);
		
		framePrincipal.getTabPanel().setEnabledAt(0, Boolean.FALSE);
		framePrincipal.getTabPanel().setEnabledAt(1, Boolean.FALSE);
		framePrincipal.getTabPanel().setEnabledAt(2, Boolean.TRUE);
	}

	/**
	 * @param scripts
	 */
	private void fillProcesadoScript(List<Script> scripts) {
		if (CollectionUtils.isNotEmpty(scripts)) {
			for (Script script: scripts) {
				if ("SQL".equals(script.getTipoScript())) {
					framePrincipal.getIfrmSQLModificado().setTitle(script.getNombreScript());
					framePrincipal.getTxtSQLModificado().setText(StringUtils.EMPTY);
					dumpContentToText(script.getLineasScript(), framePrincipal.getTxtSQLModificado());
					framePrincipal.getIfrmLanzaSQLModificado().setTitle(script.getNombreScriptLanza());
					framePrincipal.getTxtLanzaSQLModificado().setText(script.getTxtScriptLanza());
				}
		
				if ("PDC".equals(script.getTipoScript())) {
					framePrincipal.getIfrmPDC().setTitle(script.getNombreScript());
					framePrincipal.getTxtPDC().setText(StringUtils.EMPTY);
					dumpContentToText(script.getLineasScript(), framePrincipal.getTxtPDC());
					framePrincipal.getIfrmLanzaPDC().setTitle(script.getNombreScriptLanza());
					framePrincipal.getTxtLanzaPDC().setText(script.getTxtScriptLanza());
				}
		
				if ("SQLH".equals(script.getTipoScript())) {
					framePrincipal.getIfrmSQLH().setTitle(script.getNombreScript());
					framePrincipal.getTxtSQLH().setText(StringUtils.EMPTY);
					dumpContentToText(script.getLineasScript(), framePrincipal.getTxtSQLH());
					framePrincipal.getIfrmLanzaSQLH().setTitle(script.getNombreScriptLanza());
					framePrincipal.getTxtLanzaSQLH().setText(script.getTxtScriptLanza());
				}
		
				if ("PDCH".equals(script.getTipoScript())) {
					framePrincipal.getIfrmPDCH().setTitle(script.getNombreScript());
					framePrincipal.getTxtPDCH().setText(StringUtils.EMPTY);
					dumpContentToText(script.getLineasScript(), framePrincipal.getTxtPDCH());
					framePrincipal.getIfrmLanzaPDCH().setTitle(script.getNombreScriptLanza());
					framePrincipal.getTxtLanzaPDCH().setText(script.getTxtScriptLanza());
				}
			}
			
			framePrincipal.getTabPanel().setEnabledAt(0, Boolean.TRUE);
			framePrincipal.getTabPanel().setEnabledAt(1, Boolean.TRUE);
			framePrincipal.getTabPanel().setEnabledAt(2, Boolean.FALSE);
		}
	}

	@Override
	public void onLoad() {
		framePrincipal.disableTabs();
		
		Session session = (Session) MDSQLAppHelper.getGlobalProperty(Constants.SESSION);
		if (!Objects.isNull(session)) {
			Proceso proceso = session.getProceso();
	
			if (!Objects.isNull(proceso)) {
				List<Script> scripts = proceso.getScripts();
				if (CollectionUtils.isNotEmpty(scripts)) {
					fillProcesadoScript(scripts);
				}
				
				List<Type> types = proceso.getTypes();
				if (CollectionUtils.isNotEmpty(types)) {
					fillProcesadoType(types);
				}
			}
		}
	}
}
