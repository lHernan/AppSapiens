package com.mdsql.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;

import com.mdsql.bussiness.entities.*;
import com.mdsql.bussiness.service.ModeloService;
import com.mdsql.bussiness.service.PermisosService;
import com.mdsql.bussiness.service.PropietarioService;
import com.mdsql.bussiness.service.TipoObjetoService;
import com.mdsql.ui.PantallaMantenimientoVariables;
import com.mdsql.ui.model.*;
import com.mdsql.ui.utils.ListenerSupport;
import com.mdsql.ui.utils.MDSQLUIHelper;
import com.mdsql.utils.MDSQLConstants;
import com.mdval.exceptions.ServiceException;
import com.mdval.ui.utils.OnLoadListener;
import org.apache.commons.collections.CollectionUtils;

public class PantallaMantenimientoVariablesListener extends ListenerSupport implements ActionListener, OnLoadListener {
	private PantallaMantenimientoVariables pantallaMantenimientoVariables;
	
	public PantallaMantenimientoVariablesListener(PantallaMantenimientoVariables pantallaMantenimientoVariables) {
		super();
		this.pantallaMantenimientoVariables = pantallaMantenimientoVariables;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton jButton = (JButton) e.getSource();
		
		if (MDSQLConstants.PANTALLA_MANTENIMIENTO_VARIABLES_GUARDAR.equals(jButton.getActionCommand())) {
			eventBtnGuardar();
		}

		if (MDSQLConstants.PANTALLA_MANTENIMIENTO_VARIABLES_CANCELAR.equals(jButton.getActionCommand())) {
			pantallaMantenimientoVariables.dispose();
		}
	}
	
	private void eventBtnGuardar() {
		
	}

	@Override
	public void onLoad() {
		try {
			TipoObjetoService tipoObjetoService = (TipoObjetoService) getService(MDSQLConstants.TIPO_OBJETO_SERVICE);

			Modelo modelo = (Modelo) pantallaMantenimientoVariables.getParams().get("modelo");
			pantallaMantenimientoVariables.setModelo(modelo);

			actualizarVariables(modelo);

			// Rellenar combos
			List<String> tipos = tipoObjetoService.consultarTiposVariable();

			if (CollectionUtils.isNotEmpty(tipos)) {
				TipoObjetoComboBoxModel tipoObjetoComboBoxModel = new TipoObjetoComboBoxModel(tipos);
				pantallaMantenimientoVariables.getCmbTipoVariable().setModel(tipoObjetoComboBoxModel);
			}
		} catch (ServiceException e) {
			Map<String, Object> errParams = MDSQLUIHelper.buildError(e);
			MDSQLUIHelper.showPopup(pantallaMantenimientoVariables.getFrameParent(), MDSQLConstants.CMD_ERROR, errParams);
		}
	}

	private void actualizarVariables(Modelo modelo) throws ServiceException {
		ModeloService modeloService = (ModeloService) getService(MDSQLConstants.MODELO_SERVICE);

		List<Variable> variables = modeloService.consultaVariables(modelo);
		if (CollectionUtils.isNotEmpty(variables)) {
			fillVariables(variables);
		}
	}

	private void fillVariables(List<Variable> variables) {
		// Obtiene el modelo y lo actualiza
		VariableTableModel tableModel = (VariableTableModel) pantallaMantenimientoVariables
				.getTblVariables().getModel();
		tableModel.clearData();

		tableModel.setData(variables);
	}
}
