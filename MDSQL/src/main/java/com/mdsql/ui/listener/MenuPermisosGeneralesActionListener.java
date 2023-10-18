package com.mdsql.ui.listener;

import com.mdsql.bussiness.entities.*;
import com.mdsql.bussiness.service.ProcesoService;
import com.mdsql.ui.*;
import com.mdsql.ui.model.FramePrincipalTypesTableModel;
import com.mdsql.ui.utils.ListenerSupport;
import com.mdsql.ui.utils.MDSQLUIHelper;
import com.mdsql.utils.ConfigurationSingleton;
import com.mdsql.utils.MDSQLAppHelper;
import com.mdsql.utils.MDSQLConstants;
import com.mdsql.utils.MDSQLConstants.Procesado;
import com.mdval.exceptions.ServiceException;
import com.mdval.ui.utils.DialogSupport;
import com.mdval.ui.utils.FrameSupport;
import com.mdval.ui.utils.OnLoadListener;
import com.mdval.ui.utils.UIHelper;
import com.mdval.utils.LogWrapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import javax.swing.*;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author federico
 *
 */
@Slf4j
public class MenuPermisosGeneralesActionListener extends ListenerSupport implements ActionListener {

	private FrameSupport framePrincipal;

	private PantallaProcesarScript pantallaProcesarScript;

	private DialogSupport pantallaEjecutar;

	/**
	 * @param framePrincipal
	 */
	public MenuPermisosGeneralesActionListener(FrameSupport framePrincipal) {
		this.framePrincipal = framePrincipal;
	}

	/**
	 *
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		JMenuItem item = (JMenuItem) e.getSource();

		evtSeleccionModelo();
	}

	/**
	 * 
	 */
	private void evtSeleccionModelo() {
		Map<String, Object> params = new HashMap<>();
		PantallaSeleccionModelos pantallaSeleccionModelos = (PantallaSeleccionModelos) MDSQLUIHelper.createDialog(framePrincipal,
				MDSQLConstants.CMD_SEARCH_MODEL, params);
		MDSQLUIHelper.show(pantallaSeleccionModelos);
		Modelo seleccionado = pantallaSeleccionModelos.getSeleccionado();

		params = new HashMap<>();
		params.put("modelo", seleccionado);

		PantallaPermisosGeneralesporModeloporTipoObjeto pantallaPermisosGeneralesporModeloporTipoObjeto = (PantallaPermisosGeneralesporModeloporTipoObjeto) MDSQLUIHelper.createDialog(framePrincipal,
				MDSQLConstants.CMD_PERMISOS_GENERALES, params);
		MDSQLUIHelper.show(pantallaPermisosGeneralesporModeloporTipoObjeto);
	}
}
