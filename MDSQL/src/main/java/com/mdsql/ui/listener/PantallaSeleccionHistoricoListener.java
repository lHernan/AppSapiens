package com.mdsql.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.mdsql.ui.modelos.PantallaSeleccionHistorico;
import com.mdsql.ui.utils.ListenerSupport;
import com.mdsql.utils.Constants;

public class PantallaSeleccionHistoricoListener extends ListenerSupport implements ActionListener{

	private PantallaSeleccionHistorico pantallaSeleccionHistorico;
	
	public PantallaSeleccionHistoricoListener(PantallaSeleccionHistorico pantallaSeleccionHistorico) {
		super();
		this.pantallaSeleccionHistorico = pantallaSeleccionHistorico;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton jButton = (JButton) e.getSource();
		
		if (Constants.PANTALLA_SELECCION_HISTORICA_BTN_AÑADIR.equals(jButton.getActionCommand())) {
			pantallaSeleccionHistorico.dispose();
		}
		
		if (Constants.PANTALLA_SELECCION_HISTORICA_BTN_GENERAR.equals(jButton.getActionCommand())) {
			pantallaSeleccionHistorico.dispose();
		}
		
		if (Constants.PANTALLA_SELECCION_HISTORICA_BTN_CANCELAR.equals(jButton.getActionCommand())) {
			pantallaSeleccionHistorico.dispose();
		}
	}
	
}
