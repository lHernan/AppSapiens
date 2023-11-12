package com.mdsql.ui.listener;

import com.mdsql.bussiness.entities.Historico;
import com.mdsql.bussiness.entities.Modelo;
import com.mdsql.bussiness.entities.Session;
import com.mdsql.bussiness.service.HistoricoService;
import com.mdsql.bussiness.service.TipoObjetoService;
import com.mdsql.ui.PantallaHistoricoAlta;
import com.mdsql.ui.PantallaHistoricoBaja;
import com.mdsql.ui.PantallaSeleccionModelos;
import com.mdsql.ui.model.TipoObjetoComboBoxModel;
import com.mdsql.ui.utils.ListenerSupport;
import com.mdsql.ui.utils.MDSQLUIHelper;
import com.mdsql.utils.MDSQLAppHelper;
import com.mdsql.utils.MDSQLConstants;
import com.mdval.exceptions.ServiceException;
import com.mdval.ui.utils.OnLoadListener;
import com.mdval.utils.AppHelper;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class PantallaHistoricoAltaListener extends ListenerSupport implements ActionListener, OnLoadListener {

	private PantallaHistoricoAlta pantallaHistoricoAlta;

	public PantallaHistoricoAltaListener(PantallaHistoricoAlta pantallaHistoricoAlta) {
		super();
		this.pantallaHistoricoAlta = pantallaHistoricoAlta;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton jButton = (JButton) e.getSource();

		if (MDSQLConstants.PANTALLA_HISTORICO_ALTA_BUSCAR_MODELO.equals(jButton.getActionCommand())) {
			eventBtnBuscarModelo();
		}

		if (MDSQLConstants.PANTALLA_HISTORICO_ALTA_BTN_ACEPTAR.equals(jButton.getActionCommand())) {
			alta();
		}

		if (MDSQLConstants.PANTALLA_HISTORICO_ALTA_BTN_CANCELAR.equals(jButton.getActionCommand())) {
			pantallaHistoricoAlta.getReturnParams().put("response", "KO");
			pantallaHistoricoAlta.dispose();
		}
	}

	private void eventBtnBuscarModelo() {
		Modelo seleccionado = null;
		Map<String, Object> params = new HashMap<>();

		String codigoProyecto = pantallaHistoricoAlta.getTxtModelo().getText();

		if (StringUtils.isNotBlank(codigoProyecto)) {
			params.put("codigoProyecto", codigoProyecto);
		}

		PantallaSeleccionModelos pantallaSeleccionModelos = (PantallaSeleccionModelos) MDSQLUIHelper.createDialog(pantallaHistoricoAlta.getFrameParent(),
				MDSQLConstants.CMD_SEARCH_MODEL, params);
		MDSQLUIHelper.show(pantallaSeleccionModelos);
		seleccionado = pantallaSeleccionModelos.getSeleccionado();
		pantallaHistoricoAlta.setModeloSeleccionado(seleccionado);
		pantallaHistoricoAlta.getTxtModelo().setText(seleccionado.getCodigoProyecto());
	}

	@Override
	public void onLoad() {
		try {
			TipoObjetoService tipoObjetoService = (TipoObjetoService) getService(MDSQLConstants.TIPO_OBJETO_SERVICE);

			// Rellenar combos
			List<String> tipos = tipoObjetoService.consultarTiposObjeto();

			if (CollectionUtils.isNotEmpty(tipos)) {
				TipoObjetoComboBoxModel tipoObjetoComboBoxModel = new TipoObjetoComboBoxModel(tipos);
				pantallaHistoricoAlta.getCmbTipoObjeto().setModel(tipoObjetoComboBoxModel);
			}
		} catch (ServiceException e) {
			pantallaHistoricoAlta.getReturnParams().put("response", "KO");
			Map<String, Object> errParams = MDSQLUIHelper.buildError(e);
			MDSQLUIHelper.showPopup(pantallaHistoricoAlta.getFrameParent(), MDSQLConstants.CMD_ERROR, errParams);
		}
	}

	private void alta() {
		try {
			HistoricoService historicoService = (HistoricoService) getService(MDSQLConstants.HISTORICO_SERVICE);
			Session session = (Session) MDSQLAppHelper.getGlobalProperty(MDSQLConstants.SESSION);
			String codUsr = session.getCodUsr();

			Modelo modeloSeleccionado = pantallaHistoricoAlta.getModeloSeleccionado();

			if (!Objects.isNull(modeloSeleccionado)) {
				String codigoProyecto = modeloSeleccionado.getCodigoProyecto();
				String tipoObjeto = (String) pantallaHistoricoAlta.getCmbTipoObjeto().getSelectedItem();
				String nombreObjeto = pantallaHistoricoAlta.getTxtNombreObjeto().getText();
				String peticion = pantallaHistoricoAlta.getTxtPeticion().getText();
				String historificada = AppHelper.normalizeValueToCheck(pantallaHistoricoAlta.getChkHistorificada().isSelected());

				historicoService.altaHistorico(codigoProyecto, nombreObjeto, tipoObjeto, historificada, peticion, codUsr);
				pantallaHistoricoAlta.getReturnParams().put("response", "OK");
			}
			else {
				pantallaHistoricoAlta.getReturnParams().put("response", "KO");
			}
		} catch (ServiceException e) {
			pantallaHistoricoAlta.getReturnParams().put("response", "KO");
			Map<String, Object> errParams = MDSQLUIHelper.buildError(e);
			MDSQLUIHelper.showPopup(pantallaHistoricoAlta.getFrameParent(), MDSQLConstants.CMD_ERROR, errParams);
		}

		pantallaHistoricoAlta.dispose();
	}
}
