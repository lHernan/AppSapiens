package com.mdsql.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Objects;

import javax.swing.JButton;
import javax.swing.JFileChooser;

import org.apache.commons.lang3.StringUtils;

import com.mdsql.ui.FramePrincipal;
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
			File file = loadScript();
			if (!Objects.isNull(file)) {
				
			}
		}
		
		if (Constants.FRAME_PRINCIPAL_CARGAR_SCRIPT_OBJETOS.equals(jButton.getActionCommand())) {
			File file = loadScript();
			if (!Objects.isNull(file)) {
				
			}
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
}
