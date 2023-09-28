package com.mdsql.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.mdsql.ui.PantallaPermisosGeneralesporModeloporTipoObjeto;
import com.mdsql.ui.utils.ListenerSupport;
import com.mdsql.utils.MDSQLConstants;
import com.mdval.ui.utils.OnLoadListener;

public class PantallaPermisosGeneralesporModeloporTipoObjetoListener extends ListenerSupport implements ActionListener, OnLoadListener {
	private PantallaPermisosGeneralesporModeloporTipoObjeto pantallaPermisosGeneralesporModeloporTipoObjeto;

	public PantallaPermisosGeneralesporModeloporTipoObjetoListener(PantallaPermisosGeneralesporModeloporTipoObjeto pantallaPermisosGeneralesporModeloporTipoObjeto) {
		super();
		this.pantallaPermisosGeneralesporModeloporTipoObjeto = pantallaPermisosGeneralesporModeloporTipoObjeto;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton jButton = (JButton) e.getSource();
		
		if (MDSQLConstants.PANTALLA_PERMISOS_GENERALES_POR_MODELO_POR_TIPO_OBJETO_GUARDAR.equals(jButton.getActionCommand())) {
			eventBtnGuardar();
		}

		if (MDSQLConstants.PANTALLA_PERMISOS_GENERALES_POR_MODELO_POR_TIPO_OBJETO_INFORME.equals(jButton.getActionCommand())) {
			eventBtnInforme();
		}

		if (MDSQLConstants.PANTALLA_PERMISOS_GENERALES_POR_MODELO_POR_TIPO_OBJETO_CANCELAR.equals(jButton.getActionCommand())) {
			pantallaPermisosGeneralesporModeloporTipoObjeto.dispose();
		}
	}
	
	private void eventBtnGuardar() {
		
	}
	
	private void eventBtnInforme() {
		
	}
}
