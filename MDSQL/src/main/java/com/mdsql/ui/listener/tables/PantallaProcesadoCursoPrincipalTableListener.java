package com.mdsql.ui.listener.tables;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.mdsql.ui.PantallaProcesadoCurso;
import com.mdsql.ui.utils.ListenerSupport;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PantallaProcesadoCursoPrincipalTableListener extends ListenerSupport implements ListSelectionListener{

	private PantallaProcesadoCurso pantallaProcesadoCurso; 
	
	public PantallaProcesadoCursoPrincipalTableListener(PantallaProcesadoCurso pantallaProcesadoCurso) {
		super();
		this.pantallaProcesadoCurso= pantallaProcesadoCurso;
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
