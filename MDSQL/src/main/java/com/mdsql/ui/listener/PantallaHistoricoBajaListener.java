package com.mdsql.ui.listener;

import com.mdsql.ui.PantallaBuscadorFicheros;
import com.mdsql.ui.PantallaHistoricoBaja;
import com.mdsql.ui.utils.ListenerSupport;
import com.mdsql.utils.MDSQLConstants;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PantallaHistoricoBajaListener extends ListenerSupport implements ActionListener {

	private PantallaHistoricoBaja pantallaHistoricoBaja;

	public PantallaHistoricoBajaListener(PantallaHistoricoBaja pantallaHistoricoBaja) {
		super();
		this.pantallaHistoricoBaja = pantallaHistoricoBaja;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton jButton = (JButton) e.getSource();

		if (MDSQLConstants.PANTALLA_HISTORICO_BAJA_BTN_ACEPTAR.equals(jButton.getActionCommand())) {

			pantallaHistoricoBaja.dispose();
		}

		if (MDSQLConstants.PANTALLA_HISTORICO_BAJA_BTN_CANCELAR.equals(jButton.getActionCommand())) {
			pantallaHistoricoBaja.getReturnParams().put("response", "KO");
			pantallaHistoricoBaja.dispose();
		}
	}
}
