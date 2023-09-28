package com.mdsql.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.mdsql.ui.PantallaDetallePermisosPorObjeto;
import com.mdsql.ui.PantallaPermisosGeneralesporModeloporTipoObjeto;
import com.mdsql.ui.utils.ListenerSupport;
import com.mdsql.utils.MDSQLConstants;
import com.mdval.ui.utils.OnLoadListener;

public class PantallaDetallePermisosPorObjetoListener extends ListenerSupport implements ActionListener, OnLoadListener {
	private PantallaDetallePermisosPorObjeto pantallaDetallePermisosPorObjeto;
	
	public PantallaDetallePermisosPorObjetoListener(PantallaDetallePermisosPorObjeto pantallaDetallePermisosPorObjeto) {
		super();
		this.pantallaDetallePermisosPorObjeto = pantallaDetallePermisosPorObjeto;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton jButton = (JButton) e.getSource();
		
		if (MDSQLConstants.PANTALLA_DETALLE_PERMISOS_POR_OBJETO_GUARDAR.equals(jButton.getActionCommand())) {
			eventBtnGuardar();
		}
		
		if (MDSQLConstants.PANTALLA_DETALLE_PERMISOS_POR_OBJETO_ALTA.equals(jButton.getActionCommand())) {
			eventBtnAlta();
		}
		
		if (MDSQLConstants.PANTALLA_DETALLE_PERMISOS_POR_OBJETO_MODIFICACION.equals(jButton.getActionCommand())) {
			eventBtnModificacion();
		}

		if (MDSQLConstants.PANTALLA_DETALLE_PERMISOS_POR_OBJETO_INFORME.equals(jButton.getActionCommand())) {
			eventBtnInforme();
		}

		if (MDSQLConstants.PANTALLA_DETALLE_PERMISOS_POR_OBJETO_CANCELAR.equals(jButton.getActionCommand())) {
			pantallaDetallePermisosPorObjeto.dispose();
		}
	}
	
	private void eventBtnGuardar() {
		
	}
	
	private void eventBtnAlta() {
		
	}
	
	private void eventBtnModificacion() {
		
	}
	
	private void eventBtnInforme() {
			
	}
}
