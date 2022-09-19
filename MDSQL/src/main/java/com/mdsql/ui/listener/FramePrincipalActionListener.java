package com.mdsql.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Objects;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;

import org.apache.commons.lang3.StringUtils;

import com.mdsql.ui.FramePrincipal;
import com.mdsql.ui.utils.ListenerSupport;
import com.mdsql.ui.utils.MDSQLUIHelper;
import com.mdsql.utils.Constants;
import com.mdval.ui.utils.DialogSupport;
import com.mdval.utils.LogWrapper;

import lombok.extern.slf4j.Slf4j;

/**
 * @author federico
 *
 */
@Slf4j
public class FramePrincipalActionListener extends ListenerSupport implements ActionListener {
	
	private FramePrincipal framePrincipal;

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
			
		}
		
		if (Constants.FRAME_PRINCIPAL_EXECUTE.equals(jButton.getActionCommand())) {
			evtEjecutarScript();
		}
		
		if (Constants.FRAME_PRINCIPAL_ENTREGAR_PROCESADO.equals(jButton.getActionCommand())) {
			
		}
	}

	/**
	 * 
	 */
	private void evtLoadScript() {
		File file = loadScript();
		if (!Objects.isNull(file)) {
			try {
				framePrincipal.getFrmSQLScript().setTitle(file.getName());
				framePrincipal.getTxtSQLCode().setText(StringUtils.EMPTY);
				dumpContentToText(file, framePrincipal.getTxtSQLCode());
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
		File file = loadScript();
		if (!Objects.isNull(file)) {
			
		}
	}
	
	/**
	 * 
	 */
	private void evtProcesarScript() {
		DialogSupport dialog = MDSQLUIHelper.createDialog(framePrincipal, Constants.CMD_PROCESAR_SCRIPT);
		MDSQLUIHelper.show(dialog);
	}
	
	/**
	 * 
	 */
	private void evtEjecutarScript() {
		DialogSupport dialog = MDSQLUIHelper.createDialog(framePrincipal, Constants.CMD_EJECUTAR_SCRIPT);
		MDSQLUIHelper.show(dialog);
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
	 * @param rutaInicial
	 * @return
	 */
	private File selectFile(String rutaInicial) {
		File file = null;
		JFileChooser chooser = new JFileChooser();
		chooser.setCurrentDirectory(new File(rutaInicial));
		chooser.setDialogTitle(literales.getLiteral("panelPrincipal.tituloChooser"));
		chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		//
		// disable the "All files" option.
		//
		chooser.setAcceptAllFileFilterUsed(false);
		//
		if (chooser.showOpenDialog(framePrincipal) == JFileChooser.APPROVE_OPTION) {
			LogWrapper.debug(log, "Archivo seleccionado: %s", chooser.getSelectedFile());
			file = chooser.getSelectedFile();
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
}
