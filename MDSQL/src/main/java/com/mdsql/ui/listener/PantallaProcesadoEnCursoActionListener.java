package com.mdsql.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.mdsql.ui.PantallaProcesadoEnCurso;
import com.mdsql.ui.utils.ListenerSupport;
import com.mdsql.utils.Constants;
import com.mdval.ui.utils.observer.Observer;

/**
 * @author federico
 *
 */
public class PantallaProcesadoEnCursoActionListener extends ListenerSupport implements ActionListener {

	private PantallaProcesadoEnCurso pantallaProcesadoEnCurso;

	/**
	 * @param framePrincipal
	 */
	public PantallaProcesadoEnCursoActionListener(PantallaProcesadoEnCurso pantallaProcesadoEnCurso) {
		this.pantallaProcesadoEnCurso = pantallaProcesadoEnCurso;
	}
	
	public void addObservador(Observer o) {
		this.addObserver(o);
	}

	/**
	 *
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton jButton = (JButton) e.getSource();

		if (Constants.PANTALLA_PROCESADO_SCRIPT_CANCELAR.equals(jButton.getActionCommand())) {
			pantallaProcesadoEnCurso.dispose();
		}
	}
}
