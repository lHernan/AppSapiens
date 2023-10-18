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
import com.mdsql.utils.MDSQLAppHelper;
import com.mdsql.utils.MDSQLConstants;
import com.mdval.exceptions.ServiceException;
import com.mdval.ui.utils.OnLoadListener;
import com.mdval.utils.AppHelper;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

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
		String valuePS = (String) pantallaPermisosGeneralesporModeloporTipoObjeto.getCmbPermisoSinonimo().getSelectedItem();

		if ("Permiso".equals(valuePS)) {
			guardarPermiso(pantallaPermisosGeneralesporModeloporTipoObjeto);
		}

		if (("Sinónimo").equals(valuePS)) {
			guardarSinonimo(pantallaPermisosGeneralesporModeloporTipoObjeto);
		}
	}

	private void guardarSinonimo(PantallaPermisosGeneralesporModeloporTipoObjeto pantallaPermisosGeneralesporModeloporTipoObjeto) {
		try {
			Session session = (Session) MDSQLAppHelper.getGlobalProperty(MDSQLConstants.SESSION);
			PermisosService permisosService = (PermisosService) getService(MDSQLConstants.PERMISOS_SERVICE);
			Modelo modelo = pantallaPermisosGeneralesporModeloporTipoObjeto.getModelo();

			// Guardar
			String codProyecto = pantallaPermisosGeneralesporModeloporTipoObjeto.getModelo().getCodigoProyecto();
			Grant grant = (Grant) pantallaPermisosGeneralesporModeloporTipoObjeto.getCmbReceptorPermiso().getSelectedItem();
			Propietario propietario = (Propietario) pantallaPermisosGeneralesporModeloporTipoObjeto.getCmbPropietarioSinonimo().getSelectedItem();

			String codUsrGrant = grant.getCodGrant();
			String codOwnerSyn = propietario.getCodPropietario();

			String desEntorno = (String) pantallaPermisosGeneralesporModeloporTipoObjeto.getCmbEntorno().getSelectedItem();
			String tipoObjeto = (String) pantallaPermisosGeneralesporModeloporTipoObjeto.getCmbTipoObjeto().getSelectedItem();
			String funcionNombre = pantallaPermisosGeneralesporModeloporTipoObjeto.getTxtFuncionNombre().getText();
			String mcaIncluirPDC = (String) pantallaPermisosGeneralesporModeloporTipoObjeto.getCmbIncluirPDC().getSelectedItem();
			String mcaHabilitado = AppHelper.normalizeValueToCheck(pantallaPermisosGeneralesporModeloporTipoObjeto.getChkHabilitado().isSelected());
			String codPeticion = pantallaPermisosGeneralesporModeloporTipoObjeto.getTxtPeticion().getText();
			String codUsr = session.getCodUsr();

			permisosService.guardarSinonimo(codProyecto, codUsrGrant, codOwnerSyn, desEntorno, tipoObjeto, funcionNombre, mcaIncluirPDC, mcaHabilitado, codPeticion, codUsr);

			// Actualizar
			actualizarSinonimos(modelo);
		} catch (ServiceException e) {
			Map<String, Object> errParams = MDSQLUIHelper.buildError(e);
			MDSQLUIHelper.showPopup(pantallaPermisosGeneralesporModeloporTipoObjeto.getFrameParent(), MDSQLConstants.CMD_ERROR, errParams);
		}
	}

	private void guardarPermiso(PantallaPermisosGeneralesporModeloporTipoObjeto pantallaPermisosGeneralesporModeloporTipoObjeto) {
		try {
			Session session = (Session) MDSQLAppHelper.getGlobalProperty(MDSQLConstants.SESSION);
			PermisosService permisosService = (PermisosService) getService(MDSQLConstants.PERMISOS_SERVICE);
			Modelo modelo = pantallaPermisosGeneralesporModeloporTipoObjeto.getModelo();

			// Guardar
			String codProyecto = pantallaPermisosGeneralesporModeloporTipoObjeto.getModelo().getCodigoProyecto();
			Grant grant = (Grant) pantallaPermisosGeneralesporModeloporTipoObjeto.getCmbReceptorPermiso().getSelectedItem();

			String codUsrGrant = grant.getCodGrant();
			String valGrant = grant.getDesGrant();

			String desEntorno = (String) pantallaPermisosGeneralesporModeloporTipoObjeto.getCmbEntorno().getSelectedItem();
			String tipoObjeto = (String) pantallaPermisosGeneralesporModeloporTipoObjeto.getCmbTipoObjeto().getSelectedItem();
			String mcaGrantOption = (String) pantallaPermisosGeneralesporModeloporTipoObjeto.getCmbWithGrantOpcion().getSelectedItem();
			String mcaIncluirPDC = (String) pantallaPermisosGeneralesporModeloporTipoObjeto.getCmbIncluirPDC().getSelectedItem();
			String mcaHabilitado = AppHelper.normalizeValueToCheck(pantallaPermisosGeneralesporModeloporTipoObjeto.getChkHabilitado().isSelected());
			String codPeticion = pantallaPermisosGeneralesporModeloporTipoObjeto.getTxtPeticion().getText();
			String codUsr = session.getCodUsr();

			permisosService.guardarPermiso(codProyecto, codUsrGrant, valGrant, desEntorno, tipoObjeto, mcaGrantOption, mcaIncluirPDC, mcaHabilitado, codPeticion, codUsr);

			// Actualizar
			actualizarPermisos(modelo);
		} catch (ServiceException e) {
			Map<String, Object> errParams = MDSQLUIHelper.buildError(e);
			MDSQLUIHelper.showPopup(pantallaPermisosGeneralesporModeloporTipoObjeto.getFrameParent(), MDSQLConstants.CMD_ERROR, errParams);
		}
	}

	private void eventBtnInforme() {
		
	}

	@Override
	public void onLoad() {
		try {
			TipoObjetoService tipoObjetoService = (TipoObjetoService) getService(MDSQLConstants.TIPO_OBJETO_SERVICE);
			PropietarioService propietarioService = (PropietarioService) getService(MDSQLConstants.PROPIETARIO_SERVICE);

			Modelo modelo = (Modelo) pantallaPermisosGeneralesporModeloporTipoObjeto.getParams().get("modelo");
			pantallaPermisosGeneralesporModeloporTipoObjeto.setModelo(modelo);

			actualizarPermisos(modelo);
			actualizarSinonimos(modelo);

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

	private void actualizarSinonimos(Modelo modelo) throws ServiceException {
		PermisosService permisosService = (PermisosService) getService(MDSQLConstants.PERMISOS_SERVICE);

		List<Sinonimo> sinonimosGenerales = permisosService.consultaSinonimosGenerales(modelo);
		if (CollectionUtils.isNotEmpty(sinonimosGenerales)) {
			fillSinonimosGenerales(sinonimosGenerales);
		}
	}

	private void actualizarPermisos(Modelo modelo) throws ServiceException {
		PermisosService permisosService = (PermisosService) getService(MDSQLConstants.PERMISOS_SERVICE);

		List<Permiso> permisosGenerales = permisosService.consultaPermisosGenerales(modelo);
		if (CollectionUtils.isNotEmpty(permisosGenerales)) {
			fillPermisosGenerales(permisosGenerales);
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
