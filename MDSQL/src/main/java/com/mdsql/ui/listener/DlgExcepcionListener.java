package com.mdsql.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.mdsql.ui.DlgExcepcion;
import com.mdsql.ui.utils.ListenerSupport;
import com.mdsql.utils.Constants;

public class DlgExcepcionListener extends ListenerSupport implements ActionListener {
	
	private DlgExcepcion dlgExcepcion;
	
	public DlgExcepcionListener(DlgExcepcion dlgExcepcion) {
		super();
		this.dlgExcepcion = dlgExcepcion;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton jButton = (JButton) e.getSource();
		
		if (Constants.DLG_EXCEPTION_BTN_ACEPTAR.equals(jButton.getActionCommand())) {
			
		}

		if (Constants.DLG_EXCEPTION_BTN_CANCELAR.equals(jButton.getActionCommand())) {
			dlgExcepcion.dispose();
		}
	}
}
