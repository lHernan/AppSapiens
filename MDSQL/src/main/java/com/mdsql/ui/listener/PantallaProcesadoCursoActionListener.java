package com.mdsql.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.mdsql.ui.PantallaProcesadoCurso;
import com.mdsql.ui.utils.ListenerSupport;
import com.mdsql.utils.Constants;

public class PantallaProcesadoCursoActionListener extends ListenerSupport implements ActionListener{

	private PantallaProcesadoCurso pantallaProcesadoCurso;
	
	/**
	 * @param framePrincipal
	 */
	public PantallaProcesadoCursoActionListener(PantallaProcesadoCurso pantallaProcesadoCurso) {
		this.pantallaProcesadoCurso = pantallaProcesadoCurso;
	}

	/**
	 *
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton jButton = (JButton) e.getSource();

		if (Constants.PANTALLA_PROCESADO_CURSO_VER_LOG.equals(jButton.getActionCommand())) {
			eventBtnVerLog();
		}
		
		if (Constants.PANTALLA_PROCESADO_CURSO_VER_ERRORES.equals(jButton.getActionCommand())) {
			eventBtnVerErrores();
		}
		
		if (Constants.PANTALLA_PROCESADO_CURSO_DETALLE_SCRIPT.equals(jButton.getActionCommand())) {
			eventBtnDetalleScript();
		}
		
		if (Constants.PANTALLA_PROCESADO_CURSO_ENTREGAR.equals(jButton.getActionCommand())) {
			eventBtnEntregar();
		}
		
		if (Constants.PANTALLA_PROCESADO_CURSO_CANCELAR.equals(jButton.getActionCommand())) {
			pantallaProcesadoCurso.dispose();
		}
	}

	private void eventBtnEntregar() {
		// TODO Auto-generated method stub
		
	}

	private void eventBtnDetalleScript() {
		// TODO Auto-generated method stub
		
	}

	private void eventBtnVerErrores() {
		// TODO Auto-generated method stub
		
	}

	private void eventBtnVerLog() {
		// TODO Auto-generated method stub
		
	}
}
