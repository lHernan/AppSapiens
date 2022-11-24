package com.mdsql.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;

import org.hibernate.service.spi.ServiceException;

import com.mdsql.bussiness.entities.LogEjecucion;
import com.mdsql.bussiness.entities.Proceso;
import com.mdsql.bussiness.entities.Script;
import com.mdsql.bussiness.service.LogService;
import com.mdsql.ui.PantallaAjustarLogEjecucion;
import com.mdsql.ui.model.AjustarLogEjecucionTableModel;
import com.mdsql.ui.utils.ListenerSupport;
import com.mdsql.ui.utils.MDSQLUIHelper;
import com.mdsql.utils.Constants;
import com.mdval.ui.utils.OnLoadListener;

public class PantallaAjustarLogEjecucionListener extends ListenerSupport implements ActionListener, OnLoadListener {

	private PantallaAjustarLogEjecucion pantallaAjustarLogEjecucion;

	public PantallaAjustarLogEjecucionListener(PantallaAjustarLogEjecucion pantallaAjustarLogEjecucion) {
		super();
		this.pantallaAjustarLogEjecucion = pantallaAjustarLogEjecucion;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton jButton = (JButton) e.getSource();

		if (Constants.PANTALLA_AJUSTAR_LOG_EJECUCION_ELIMINAR.equals(jButton.getActionCommand())) {
			eliminar();
		}
		if (Constants.PANTALLA_AJUSTAR_LOG_EJECUCION_CANCELAR.equals(jButton.getActionCommand())) {
			pantallaAjustarLogEjecucion.dispose();
		}

	}

	private void eliminar() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onLoad() {
		try {
			LogService logService = (LogService) getService(Constants.LOG_SERVICE);

			Script script = (Script) pantallaAjustarLogEjecucion.getParams().get("script");
			Proceso proceso = (Proceso) pantallaAjustarLogEjecucion.getParams().get("proceso");

			BigDecimal idProceso = proceso.getIdProceso();
			BigDecimal numeroOrden = script.getNumeroOrden();

			List<LogEjecucion> logEjecucion = logService.logEjecucion(idProceso, numeroOrden);
			
			AjustarLogEjecucionTableModel tableModel = (AjustarLogEjecucionTableModel) pantallaAjustarLogEjecucion.getTblAjustarLog().getModel();
			tableModel.setData(logEjecucion);
			
		} catch (ServiceException e) {
			Map<String, Object> params = MDSQLUIHelper.buildError(e);
			MDSQLUIHelper.showPopup(pantallaAjustarLogEjecucion.getFrameParent(), Constants.CMD_ERROR, params);
		}
	}

}
