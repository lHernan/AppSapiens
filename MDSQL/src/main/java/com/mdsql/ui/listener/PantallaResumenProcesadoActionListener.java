package com.mdsql.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.swing.JButton;

import org.apache.commons.collections.CollectionUtils;

import com.mdsql.bussiness.entities.InputSeleccionarProcesados;
import com.mdsql.bussiness.entities.OutputConsultaProcesado;
import com.mdsql.bussiness.entities.ScriptEjecutado;
import com.mdsql.bussiness.service.ProcesoService;
import com.mdsql.exceptions.ServiceException;
import com.mdsql.ui.PantallaResumenProcesado;
import com.mdsql.ui.model.ResumenProcesadoScriptsTableModel;
import com.mdsql.ui.model.SeleccionModelosTableModel;
import com.mdsql.ui.utils.ListenerSupport;
import com.mdsql.ui.utils.MDSQLUIHelper;
import com.mdsql.utils.Constants;
import com.mdval.ui.utils.OnLoadListener;

/**
 * @author federico
 *
 */
public class PantallaResumenProcesadoActionListener extends ListenerSupport implements ActionListener, OnLoadListener {

	private PantallaResumenProcesado pantallaResumenProcesado;

	/**
	 * @param framePrincipal
	 */
	public PantallaResumenProcesadoActionListener(PantallaResumenProcesado pantallaResumenProcesado) {
		this.pantallaResumenProcesado = pantallaResumenProcesado;
	}

	/**
	 *
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton jButton = (JButton) e.getSource();

	}

	@Override
	public void onLoad() {
		try {
			ProcesoService procesoService = (ProcesoService) getService(Constants.PROCESO_SERVICE);
			
			/**
			 * TODO - Preguntar de dónde sale el id del proceso cuando viene de la pantalla
			 * procesar script
			 */
			BigDecimal idProceso = new BigDecimal(1L);
			OutputConsultaProcesado outputConsultaProcesado = procesoService.consultaProcesado(idProceso);

			if (!Objects.isNull(outputConsultaProcesado)) {
				populateScripts(outputConsultaProcesado.getListaScriptsEjecutados());
			}
		} catch (ServiceException e) {
			Map<String, Object> errParams = MDSQLUIHelper.buildError(e);
			MDSQLUIHelper.showPopup(pantallaResumenProcesado.getFrameParent(), Constants.CMD_ERROR, errParams);
		}
	}

	/**
	 * @param listaScriptsEjecutados
	 */
	private void populateScripts(List<ScriptEjecutado> listaScriptsEjecutados) {
		// Obtiene el modelo y lo actualiza
		ResumenProcesadoScriptsTableModel tableModel = (ResumenProcesadoScriptsTableModel) pantallaResumenProcesado.getTblScripts()
				.getModel();
		tableModel.setData(listaScriptsEjecutados);
	}
}
