package com.mdsql.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import com.mdsql.bussiness.entities.SeleccionHistorico;
import com.mdsql.bussiness.entities.Session;
import com.mdsql.bussiness.entities.TextoLinea;
import com.mdsql.bussiness.service.ProcesoService;
import com.mdsql.ui.PantallaSeleccionHistorico;
import com.mdsql.ui.model.SeleccionHistoricoTableModel;
import com.mdsql.ui.utils.ListenerSupport;
import com.mdsql.ui.utils.MDSQLUIHelper;
import com.mdsql.utils.Constants;
import com.mdsql.utils.MDSQLAppHelper;
import com.mdval.exceptions.ServiceException;
import com.mdval.ui.utils.OnLoadListener;
import com.mdval.ui.utils.observer.Observable;
import com.mdval.ui.utils.observer.Observer;
import com.mdval.utils.AppGlobalSingleton;

public class PantallaSeleccionHistoricoListener extends ListenerSupport implements ActionListener, OnLoadListener, Observer {

	private PantallaSeleccionHistorico pantallaSeleccionHistorico;

	public PantallaSeleccionHistoricoListener(PantallaSeleccionHistorico pantallaSeleccionHistorico) {
		super();
		this.pantallaSeleccionHistorico = pantallaSeleccionHistorico;
	}
	
	public void addObservador(Observer o) {
		this.addObserver(o);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton jButton = (JButton) e.getSource();

		if (Constants.PANTALLA_SELECCION_HISTORICA_BTN_ADD.equals(jButton.getActionCommand())) {
			addToHistorico();
		}

		if (Constants.PANTALLA_SELECCION_HISTORICA_BTN_GENERAR.equals(jButton.getActionCommand())) {
			generarHistorico();
		}

		if (Constants.PANTALLA_SELECCION_HISTORICA_BTN_CANCELAR.equals(jButton.getActionCommand())) {
			cancelar();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void onLoad() {
		try {
			ProcesoService procesoService = (ProcesoService) getService(Constants.PROCESO_SERVICE);

			String codigoProyecto = (String) pantallaSeleccionHistorico.getParams().get("codigoProyecto");
			List<TextoLinea> lineas = (List<TextoLinea>) pantallaSeleccionHistorico.getParams().get("script");
			List<SeleccionHistorico> seleccion = procesoService.seleccionarHistorico(codigoProyecto, lineas);

			populateModelSeleccion(seleccion);

			if (checkAllConfigured(
					(SeleccionHistoricoTableModel) pantallaSeleccionHistorico.getTblHistorico().getModel())) {
				pantallaSeleccionHistorico.getBtnAddHistorico().setEnabled(Boolean.FALSE);
			}
		} catch (ServiceException e) {
			Map<String, Object> params = MDSQLUIHelper.buildError(e);
			MDSQLUIHelper.showPopup(pantallaSeleccionHistorico.getFrameParent(), Constants.CMD_ERROR, params);
		}
	}

	/**
	 * 
	 */
	private void addToHistorico() {
		try {
			ProcesoService procesoService = (ProcesoService) getService(Constants.PROCESO_SERVICE);

			Session session = (Session) MDSQLAppHelper.getGlobalProperty(Constants.SESSION);
	        String codigoUsuario = session.getCodUsr();
			String codigoProyecto = (String) pantallaSeleccionHistorico.getParams().get("codigoProyecto");
			String codigoPeticion = (String) pantallaSeleccionHistorico.getParams().get("codigoPeticion");
			List<SeleccionHistorico> listaObjetos = ((SeleccionHistoricoTableModel) pantallaSeleccionHistorico
					.getTblHistorico().getModel()).getData();

			procesoService.altaHistorico(listaObjetos, codigoProyecto, codigoPeticion, codigoUsuario);
		} catch (Exception e) {
			Map<String, Object> params = MDSQLUIHelper.buildError(e);
			MDSQLUIHelper.showPopup(pantallaSeleccionHistorico.getFrameParent(), Constants.CMD_ERROR, params);
		}
	}

	private void generarHistorico() {
		int dialogResult = JOptionPane.showConfirmDialog(pantallaSeleccionHistorico.getFrameParent(),
				"¿Desea continuar con el procesado?", "Atención", JOptionPane.YES_NO_OPTION);

		if (dialogResult == JOptionPane.YES_OPTION) {
			pantallaSeleccionHistorico.getReturnParams().put("procesado", Boolean.TRUE);
		} else {
			pantallaSeleccionHistorico.getReturnParams().put("procesado", Boolean.FALSE);
		}

		List<SeleccionHistorico> list = ((SeleccionHistoricoTableModel) pantallaSeleccionHistorico.getTblHistorico().getModel()).getData();
		pantallaSeleccionHistorico.getReturnParams().put("objetosHistorico", list);
		
		updateObservers(Constants.PANTALLA_SELECCION_HISTORICA_BTN_GENERAR);
		pantallaSeleccionHistorico.dispose();
	}

	private void cancelar() {
		pantallaSeleccionHistorico.getReturnParams().put("procesado", Boolean.FALSE);
		pantallaSeleccionHistorico.dispose();
	}

	/**
	 * @param avisos
	 */
	private void populateModelSeleccion(List<SeleccionHistorico> seleccion) {
		// Obtiene el modelo y lo actualiza
		SeleccionHistoricoTableModel tableModel = (SeleccionHistoricoTableModel) pantallaSeleccionHistorico
				.getTblHistorico().getModel();
		tableModel.setData(seleccion);
	}

	/**
	 * @param model
	 * @return
	 */
	private boolean checkAllConfigured(SeleccionHistoricoTableModel model) {
		for (SeleccionHistorico sel : model.getData()) {
			if (!sel.getConfigurado()) {
				return false;
			}
		}

		return true;
	}

	@Override
	public void update(Observable o, Object cmd) {
		// TODO Auto-generated method stub
		
	}
}
