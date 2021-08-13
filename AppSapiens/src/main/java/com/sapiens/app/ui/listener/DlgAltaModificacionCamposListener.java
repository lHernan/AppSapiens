package com.sapiens.app.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.sapiens.app.ui.glosarios.DlgAltaModificacionCampos;
import com.sapiens.app.utils.Constants;

public class DlgAltaModificacionCamposListener extends ListenerSupport implements ActionListener {

	private DlgAltaModificacionCampos dlgAltaModificacionCampos;

	public DlgAltaModificacionCamposListener(DlgAltaModificacionCampos dlgAltaModificacionCampos) {
		super();
		this.dlgAltaModificacionCampos = dlgAltaModificacionCampos;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton jButton = (JButton) e.getSource();

		if (Constants.DLG_ALTA_MODIFICACION_CAMPOS_BTN_ACEPTAR.equals(jButton.getName())) {
			eventBtnAlta();
		}

		if (Constants.DLG_ALTA_MODIFICACION_CAMPOS_BTN_CANCELAR.equals(jButton.getName())) {
			dlgAltaModificacionCampos.dispose();
		}
	}

	private void eventBtnAlta() {
		
	}

}
