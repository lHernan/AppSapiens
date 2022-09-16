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
import com.mdsql.ui.PantallaProcesarScript;
import com.mdsql.ui.utils.ListenerSupport;
import com.mdsql.ui.utils.MDSQLUIHelper;
import com.mdsql.utils.Constants;
import com.mdsql.utils.LogWrapper;
import com.mdval.ui.utils.DialogSupport;

import lombok.extern.slf4j.Slf4j;

/**
 * @author federico
 *
 */
@Slf4j
public class PantallaProcesarScriptActionListener extends ListenerSupport implements ActionListener {
	
	private PantallaProcesarScript pantallaProcesarScript;

	/**
	 * @param framePrincipal
	 */
	public PantallaProcesarScriptActionListener(PantallaProcesarScript pantallaProcesarScript) {
		this.pantallaProcesarScript = pantallaProcesarScript;
	}

	/**
	 *
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton jButton = (JButton) e.getSource();

		if (Constants.PANTALLA_PROCESADO_SCRIPT_SEARCH_MODEL.equals(jButton.getActionCommand())) {
			eventBtnSearchModel();
		}
		
		if (Constants.PANTALLA_PROCESADO_SCRIPT_CANCELAR.equals(jButton.getActionCommand())) {
			pantallaProcesarScript.dispose();
		}
		
		if (Constants.PANTALLA_PROCESADO_SCRIPT_PROCESAR.equals(jButton.getActionCommand())) {
			eventBtnProcesar();
		}
	}

	/**
	 * 
	 */
	private void eventBtnProcesar() {
		DialogSupport dialog = MDSQLUIHelper.createDialog(pantallaProcesarScript.getFrameParent(), Constants.CMD_SELECCION_HISTORICO);
		MDSQLUIHelper.show(dialog);
	}

	/**
	 * 
	 */
	private void eventBtnSearchModel() {
		DialogSupport dialog = MDSQLUIHelper.createDialog(pantallaProcesarScript.getFrameParent(), Constants.CMD_SEARCH_MODEL);
		MDSQLUIHelper.show(dialog);
	}
}
