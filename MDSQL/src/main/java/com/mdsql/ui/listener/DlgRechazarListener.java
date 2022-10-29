package com.mdsql.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.mdsql.ui.DlgRechazar;
import com.mdsql.ui.utils.ListenerSupport;
import com.mdsql.utils.Constants;

public class DlgRechazarListener extends ListenerSupport implements ActionListener {
	
	private DlgRechazar dlgRechazar;
	
	public DlgRechazarListener(DlgRechazar dlgRechazar) {
		super();
		this.dlgRechazar = dlgRechazar;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton jButton = (JButton) e.getSource();
		
		if (Constants.DLG_RECHAZAR_BTN_ACEPTAR.equals(jButton.getActionCommand())) {
			
		}

		if (Constants.DLG_RECHAZAR_BTN_CANCELAR.equals(jButton.getActionCommand())) {
			dlgRechazar.dispose();
		}
	}
}
