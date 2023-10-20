package com.mdsql.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import javax.swing.JButton;

import com.mdsql.bussiness.entities.Modelo;
import com.mdsql.ui.PantallaMantenimientoNotasModelos;
import com.mdsql.ui.PantallaSeleccionModelos;
import com.mdsql.ui.model.HistoricoTableModel;
import com.mdsql.ui.model.NotasModeloTableModel;
import com.mdsql.ui.utils.ListenerSupport;
import com.mdsql.ui.utils.MDSQLUIHelper;
import com.mdsql.utils.MDSQLConstants;
import com.mdval.ui.utils.OnLoadListener;
import org.apache.commons.lang3.StringUtils;

public class PantallaMantenimientoNotasModelosListener extends ListenerSupport implements ActionListener {
	private PantallaMantenimientoNotasModelos pantallaMantenimientoNotasModelos;
	
	public PantallaMantenimientoNotasModelosListener(PantallaMantenimientoNotasModelos pantallaMantenimientoNotasModelos) {
		super();
		this.pantallaMantenimientoNotasModelos = pantallaMantenimientoNotasModelos;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton jButton = (JButton) e.getSource();
		
		if (MDSQLConstants.PANTALLA_MANTENIMIENTO_NOTAS_MODELOS_GUARDAR.equals(jButton.getActionCommand())) {
			eventBtnGuardar();
		}

		if (MDSQLConstants.PANTALLA_MANTENIMIENTO_NOTAS_MODELOS_BUSCAR_MODELO.equals(jButton.getActionCommand())) {
			eventBtnBuscarModelo();
			cargarModelo(pantallaMantenimientoNotasModelos.getModeloSeleccionado());
		}

		if (MDSQLConstants.PANTALLA_MANTENIMIENTO_NOTAS_MODELOS_CANCELAR.equals(jButton.getActionCommand())) {
			pantallaMantenimientoNotasModelos.dispose();
		}
	}

	private void eventBtnBuscarModelo() {
		Modelo seleccionado = null;
		Map<String, Object> params = new HashMap<>();

		String codigoProyecto = pantallaMantenimientoNotasModelos.getTxtCodigoProyecto().getText();

		if (StringUtils.isNotBlank(codigoProyecto)) {
			params.put("codigoProyecto", codigoProyecto);
		}

		PantallaSeleccionModelos pantallaSeleccionModelos = (PantallaSeleccionModelos) MDSQLUIHelper.createDialog(pantallaMantenimientoNotasModelos.getFrameParent(),
				MDSQLConstants.CMD_SEARCH_MODEL, params);
		MDSQLUIHelper.show(pantallaSeleccionModelos);
		seleccionado = pantallaSeleccionModelos.getSeleccionado();
		pantallaMantenimientoNotasModelos.setModeloSeleccionado(seleccionado);
	}
	
	private void eventBtnGuardar() {
		
	}

	private void cargarModelo(Modelo modeloSeleccionado) {
		clearForm();
		clearList();

		if (!Objects.isNull(modeloSeleccionado)) {
			pantallaMantenimientoNotasModelos.getBtnGuardar().setEnabled(Boolean.TRUE);
		}
	}

	private void clearForm() {
		pantallaMantenimientoNotasModelos.getTxtPeticion().setText(StringUtils.EMPTY);
		pantallaMantenimientoNotasModelos.getCmbImportancia().setSelectedItem(null);
		pantallaMantenimientoNotasModelos.getChkHabilitada().setSelected(Boolean.FALSE);
		pantallaMantenimientoNotasModelos.getTxtTitulo().setText(StringUtils.EMPTY);
		pantallaMantenimientoNotasModelos.getTxtDescripcion().setText(StringUtils.EMPTY);
		pantallaMantenimientoNotasModelos.getTxtUsuarioAlta().setText(StringUtils.EMPTY);
		pantallaMantenimientoNotasModelos.getTxtFechaAlta().setText(StringUtils.EMPTY);
		pantallaMantenimientoNotasModelos.getTxtUsuarioModificacion().setText(StringUtils.EMPTY);
		pantallaMantenimientoNotasModelos.getTxtFechaModificacion().setText(StringUtils.EMPTY);
	}

	private void clearList() {
		NotasModeloTableModel tableModel = (NotasModeloTableModel) pantallaMantenimientoNotasModelos
				.getTblNotasModelos().getModel();
		tableModel.clearData();
	}
}
