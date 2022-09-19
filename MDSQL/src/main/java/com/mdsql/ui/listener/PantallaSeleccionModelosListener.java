package com.mdsql.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;

import com.mdsql.bussiness.entities.Modelo;
import com.mdsql.bussiness.service.ModeloService;
import com.mdsql.exceptions.ServiceException;
import com.mdsql.ui.model.SeleccionModelosTableModel;
import com.mdsql.ui.modelos.PantallaSeleccionModelos;
import com.mdsql.ui.utils.ListenerSupport;
import com.mdsql.ui.utils.MDSQLUIHelper;
import com.mdsql.utils.Constants;

/**
 * @author federico
 *
 */
public class PantallaSeleccionModelosListener extends ListenerSupport implements ActionListener {

	private PantallaSeleccionModelos pantallaSeleccionModelos;

	public PantallaSeleccionModelosListener(PantallaSeleccionModelos pantallaSeleccionModelos) {
		super();
		this.pantallaSeleccionModelos = pantallaSeleccionModelos;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton jButton = (JButton) e.getSource();

		if (Constants.PANTALLA_SELECCION_MODELOS_BTN_BUSCAR.equals(jButton.getActionCommand())) {
			eventBtnBuscar();
		}
		
		if (Constants.PANTALLA_SELECCION_MODELOS_BTN_SELECCIONAR.equals(jButton.getActionCommand())) {
			evntBtnSeleccionar();
		}
	}

	/*
	 * 
	 */
	private void eventBtnBuscar() {
		try {
			String codModelo = pantallaSeleccionModelos.getTxtCodModelo().getText();
			String nombreModelo = pantallaSeleccionModelos.getTxtNombreModelo().getText();
			String codSubmodelo = pantallaSeleccionModelos.getTxtCodSubmodelo().getText();

			List<Modelo> modelos = buscar(codModelo, nombreModelo, codSubmodelo);
			populateModel(modelos);
			
		} catch (ServiceException e) {
			Map<String, Object> params = MDSQLUIHelper.buildError(e);
			MDSQLUIHelper.showPopup(pantallaSeleccionModelos.getFrameParent(), Constants.CMD_ERROR, params);
		}
	}

	/**
	 * 
	 */
	private void evntBtnSeleccionar() {
		pantallaSeleccionModelos.getReturnParams().put("seleccionado", pantallaSeleccionModelos.getSeleccionado());
		pantallaSeleccionModelos.dispose();
	}

	/**
	 * @param codModelo
	 * @param nombreModelo
	 * @param codSubmodelo
	 * @return
	 * @throws ServiceException 
	 */
	private List<Modelo> buscar(String codModelo, String nombreModelo, String codSubmodelo) throws ServiceException {
		ModeloService modeloService = (ModeloService) getService(Constants.MODELO_SERVICE);
		
		return modeloService.consultaModelos(codModelo, nombreModelo, codSubmodelo);
	}

	/**
	 * @param modelos
	 */
	private void populateModel(List<Modelo> modelos) {
		// Obtiene el modelo y lo actualiza
		SeleccionModelosTableModel tableModel = (SeleccionModelosTableModel) pantallaSeleccionModelos
				.getTblModelos().getModel();
		tableModel.setData(modelos);
	}
}
