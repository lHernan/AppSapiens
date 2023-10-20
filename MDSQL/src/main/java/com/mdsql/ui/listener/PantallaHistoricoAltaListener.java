package com.mdsql.ui.listener;

import com.mdsql.bussiness.service.TipoObjetoService;
import com.mdsql.ui.PantallaHistoricoAlta;
import com.mdsql.ui.PantallaHistoricoBaja;
import com.mdsql.ui.model.TipoObjetoComboBoxModel;
import com.mdsql.ui.utils.ListenerSupport;
import com.mdsql.utils.MDSQLConstants;
import com.mdval.ui.utils.OnLoadListener;
import org.apache.commons.collections.CollectionUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PantallaHistoricoAltaListener extends ListenerSupport implements ActionListener, OnLoadListener {

	private PantallaHistoricoAlta pantallaHistoricoAlta;

	public PantallaHistoricoAltaListener(PantallaHistoricoAlta pantallaHistoricoAlta) {
		super();
		this.pantallaHistoricoAlta = pantallaHistoricoAlta;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton jButton = (JButton) e.getSource();

		if (MDSQLConstants.PANTALLA_HISTORICO_ALTA_BTN_ACEPTAR.equals(jButton.getActionCommand())) {

			pantallaHistoricoAlta.dispose();
		}

		if (MDSQLConstants.PANTALLA_HISTORICO_ALTA_BTN_CANCELAR.equals(jButton.getActionCommand())) {
			pantallaHistoricoAlta.getReturnParams().put("response", "KO");
			pantallaHistoricoAlta.dispose();
		}
	}

	@Override
	public void onLoad() {
		TipoObjetoService tipoObjetoService = (TipoObjetoService) getService(MDSQLConstants.TIPO_OBJETO_SERVICE);

		// Rellenar combos
		List<String> tipos = tipoObjetoService.consultarTiposObjeto();

		if (CollectionUtils.isNotEmpty(tipos)) {
			TipoObjetoComboBoxModel tipoObjetoComboBoxModel = new TipoObjetoComboBoxModel(tipos);
			pantallaHistoricoAlta.getCmbTipoObjeto().setModel(tipoObjetoComboBoxModel);
		}
	}
}
