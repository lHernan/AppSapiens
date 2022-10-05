package com.mdsql.ui.listener.tables;

import javax.swing.event.ListSelectionListener;

import com.mdsql.ui.PantallaProcesadoCurso;
import com.mdsql.ui.utils.ListenerSupport;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PentallaProcesadoCursoPrincipalTableListener extends ListenerSupport implements ListSelectionListener{

	private PantallaProcesadoCurso pantallaProcesadoCurso; 
	
	public PentallaProcesadoCursoPrincipalTableListener(PantallaProcesadoCurso pantallaProcesadoCurso) {
		super();
		this.pantallaProcesadoCurso= pantallaProcesadoCurso;
	}
}
