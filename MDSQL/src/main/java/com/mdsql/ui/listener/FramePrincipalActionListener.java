package com.mdsql.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;

import com.mdsql.ui.FramePrincipal;
import com.mdsql.ui.utils.ListenerSupport;
import com.mdsql.ui.utils.MDSQLUIHelper;
import com.mdsql.utils.Constants;
import com.mdsql.utils.LogWrapper;
import com.mdval.ui.utils.UIHelper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FramePrincipalActionListener extends ListenerSupport implements ActionListener {
	
	private FramePrincipal framePrincipal;

	public FramePrincipalActionListener(FramePrincipal framePrincipal) {
		this.framePrincipal = framePrincipal;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton jButton = (JButton) e.getSource();

		if (Constants.FRAME_PRINCIPAL_LOAD_SCRIPT.equals(jButton.getActionCommand())) {
			JDialog dialog = MDSQLUIHelper.createDialog(framePrincipal, Constants.CMD_LOAD_SCRIPT);
			UIHelper.show(dialog);
		}
	}
	
	private File selectFile() {
		File file = null;
		JFileChooser chooser = new JFileChooser();
		chooser.setCurrentDirectory(new File("."));
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
