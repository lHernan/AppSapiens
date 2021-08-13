package com.sapiens.app.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.sapiens.app.ui.glosarios.DlgBajaGlosario;
import com.sapiens.app.utils.Constants;

public class DlgBajaGlosarioListener extends ListenerSupport implements ActionListener {

	private DlgBajaGlosario dlgBajaGlosario;

	public DlgBajaGlosarioListener(DlgBajaGlosario dlgBajaGlosario) {
		super();
		this.dlgBajaGlosario = dlgBajaGlosario;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton jButton = (JButton) e.getSource();

		if (Constants.DLG_BAJA_GLOSARIO_BTN_ACEPTAR.equals(jButton.getName())) {
			eventBtnAceptar();
		}

		if (Constants.DLG_BAJA_GLOSARIO_BTN_CANCELAR.equals(jButton.getName())) {
			dlgBajaGlosario.dispose();
		}
	}

	private void eventBtnAceptar() {
		// TODO Auto-generated method stub
		
	}

}
