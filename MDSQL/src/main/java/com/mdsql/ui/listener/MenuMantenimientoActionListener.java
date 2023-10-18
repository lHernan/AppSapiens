package com.mdsql.ui.listener;

import com.mdsql.bussiness.entities.*;
import com.mdsql.ui.*;
import com.mdsql.ui.utils.ListenerSupport;
import com.mdsql.ui.utils.MDSQLUIHelper;
import com.mdsql.utils.MDSQLConstants;
import com.mdval.ui.utils.DialogSupport;
import com.mdval.ui.utils.FrameSupport;
import lombok.extern.slf4j.Slf4j;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

/**
 * @author federico
 *
 */
@Slf4j
public class MenuMantenimientoActionListener extends ListenerSupport implements ActionListener {

	private FrameSupport framePrincipal;

	private PantallaProcesarScript pantallaProcesarScript;

	private DialogSupport pantallaEjecutar;

	/**
	 * @param framePrincipal
	 */
	public MenuMantenimientoActionListener(FrameSupport framePrincipal) {
		this.framePrincipal = framePrincipal;
	}

	/**
	 *
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		JMenuItem item = (JMenuItem) e.getSource();
		String actionCommand = item.getActionCommand();

		if ("PERMISOS_GENERALES".equals(actionCommand)) {
			evtPermisosGenerales();
		}

		if ("PERMISOS_OBJETO".equals(actionCommand)) {
			evtPermisosObjeto();
		}
	}

	/**
	 * 
	 */
	private void evtPermisosGenerales() {
		Modelo seleccionado = getModelo();
		Map<String, Object> params;

		params = new HashMap<>();
		params.put("modelo", seleccionado);

		PantallaPermisosGeneralesporModeloporTipoObjeto pantallaPermisosGeneralesporModeloporTipoObjeto = (PantallaPermisosGeneralesporModeloporTipoObjeto) MDSQLUIHelper.createDialog(framePrincipal,
				MDSQLConstants.CMD_PERMISOS_GENERALES, params);
		MDSQLUIHelper.show(pantallaPermisosGeneralesporModeloporTipoObjeto);
	}

	private void evtPermisosObjeto() {
		Modelo seleccionado = getModelo();
		Map<String, Object> params;

		params = new HashMap<>();
		params.put("modelo", seleccionado);

		PantallaDetallePermisosPorObjeto pantallaDetallePermisosPorObjeto = (PantallaDetallePermisosPorObjeto) MDSQLUIHelper.createDialog(framePrincipal,
				MDSQLConstants.CMD_PERMISOS_OBJETO, params);
		MDSQLUIHelper.show(pantallaDetallePermisosPorObjeto);
	}

	private Modelo getModelo() {
		Map<String, Object> params = new HashMap<>();
		PantallaSeleccionModelos pantallaSeleccionModelos = (PantallaSeleccionModelos) MDSQLUIHelper.createDialog(framePrincipal,
				MDSQLConstants.CMD_SEARCH_MODEL, params);
		MDSQLUIHelper.show(pantallaSeleccionModelos);
		Modelo seleccionado = pantallaSeleccionModelos.getSeleccionado();
		return seleccionado;
	}
}
