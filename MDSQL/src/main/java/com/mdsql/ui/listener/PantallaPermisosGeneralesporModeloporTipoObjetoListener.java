package com.mdsql.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;

import com.mdsql.bussiness.entities.*;
import com.mdsql.bussiness.service.*;
import com.mdsql.ui.PantallaPermisosGeneralesporModeloporTipoObjeto;
import com.mdsql.ui.model.*;
import com.mdsql.ui.utils.ListenerSupport;
import com.mdsql.ui.utils.MDSQLUIHelper;
import com.mdsql.utils.MDSQLConstants;
import com.mdval.exceptions.ServiceException;
import com.mdval.ui.utils.OnLoadListener;
import org.apache.commons.collections.CollectionUtils;

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

	@Override
	public void onLoad() {
		try {
			PermisosService permisosService = (PermisosService) getService(MDSQLConstants.PERMISOS_SERVICE);
			TipoObjetoService tipoObjetoService = (TipoObjetoService) getService(MDSQLConstants.TIPO_OBJETO_SERVICE);
			PropietarioService propietarioService = (PropietarioService) getService(MDSQLConstants.PROPIETARIO_SERVICE);

			Modelo modelo = (Modelo) pantallaPermisosGeneralesporModeloporTipoObjeto.getParams().get("modelo");
			pantallaPermisosGeneralesporModeloporTipoObjeto.setModelo(modelo);

			List<Permiso> permisosGenerales = permisosService.consultaPermisosGenerales(modelo);
			List<Sinonimo> sinonimosGenerales = permisosService.consultaSinonimosGenerales(modelo);

			if (CollectionUtils.isNotEmpty(permisosGenerales)) {
				fillPermisosGenerales(permisosGenerales);
			}

			if (CollectionUtils.isNotEmpty(sinonimosGenerales)) {
				fillSinonimosGenerales(sinonimosGenerales);
			}

			// Rellenar combos
			List<String> tipos = tipoObjetoService.consultarTiposObjeto();
			List<Propietario> propietarios = propietarioService.consultarPropietariosModelo(modelo);
			List<Grant> receptores = propietarioService.consultarReceptoresModelo(modelo);

			if (CollectionUtils.isNotEmpty(tipos)) {
				TipoObjetoComboBoxModel tipoObjetoComboBoxModel = new TipoObjetoComboBoxModel(tipos);
				pantallaPermisosGeneralesporModeloporTipoObjeto.getCmbTipoObjeto().setModel(tipoObjetoComboBoxModel);
			}

			if (CollectionUtils.isNotEmpty(propietarios)) {
				PropietarioComboBoxModel propietarioComboBoxModel = new PropietarioComboBoxModel(propietarios);
				pantallaPermisosGeneralesporModeloporTipoObjeto.getCmbPropietarioSinonimo().setModel(propietarioComboBoxModel);
			}

			if (CollectionUtils.isNotEmpty(receptores)) {
				GrantComboBoxModel grantComboBoxModel = new GrantComboBoxModel(receptores);
				pantallaPermisosGeneralesporModeloporTipoObjeto.getCmbReceptorPermiso().setModel(grantComboBoxModel);
			}
		} catch (ServiceException e) {
			Map<String, Object> errParams = MDSQLUIHelper.buildError(e);
			MDSQLUIHelper.showPopup(pantallaPermisosGeneralesporModeloporTipoObjeto.getFrameParent(), MDSQLConstants.CMD_ERROR, errParams);
		}
	}

	private void fillPermisosGenerales(List<Permiso> permisosGenerales) throws ServiceException {
		// Obtiene el modelo y lo actualiza
		PermisosGeneralesTableModel tableModel = (PermisosGeneralesTableModel) pantallaPermisosGeneralesporModeloporTipoObjeto
				.getTblPermisos().getModel();
		tableModel.clearData();

		tableModel.setData(permisosGenerales);
	}

	private void fillSinonimosGenerales(List<Sinonimo> sinonimosGenerales) throws ServiceException {
		// Obtiene el modelo y lo actualiza
		SinonimosGeneralesTableModel tableModel = (SinonimosGeneralesTableModel) pantallaPermisosGeneralesporModeloporTipoObjeto
				.getTblSinonimos().getModel();
		tableModel.clearData();

		tableModel.setData(sinonimosGenerales);
	}
}
