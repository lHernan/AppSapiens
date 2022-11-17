package com.mdsql.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import com.mdsql.bussiness.entities.OutputConsultaEntrega;
import com.mdsql.bussiness.entities.OutputConsultaProcesado;
import com.mdsql.bussiness.entities.Proceso;
import com.mdsql.bussiness.entities.ScriptEjecutado;
import com.mdsql.bussiness.entities.Session;
import com.mdsql.bussiness.service.EntregaService;
import com.mdsql.bussiness.service.ProcesoService;
import com.mdsql.ui.PantallaResumenProcesado;
import com.mdsql.ui.model.ResumenProcesadoScriptsTableModel;
import com.mdsql.ui.utils.ListenerSupport;
import com.mdsql.ui.utils.MDSQLUIHelper;
import com.mdsql.utils.Constants;
import com.mdsql.utils.MDSQLAppHelper;
import com.mdval.exceptions.ServiceException;
import com.mdval.ui.utils.OnLoadListener;
import com.mdval.ui.utils.UIHelper;

import lombok.extern.slf4j.Slf4j;

/**
 * @author federico
 *
 */
@Slf4j
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

		if (Constants.PANTALLA_RESUMEN_PROCESADO_ENTREGAR.equals(jButton.getActionCommand())) {
			evtEntregar();
		}

		if (Constants.PANTALLA_RESUMEN_PROCESADO_CANCELAR.equals(jButton.getActionCommand())) {
			pantallaResumenProcesado.dispose();
		}
	}

	/**
	 * 
	 */
	private void evtEntregar() {
		Session session = (Session) MDSQLAppHelper.getGlobalProperty(Constants.SESSION);
		Proceso proceso = session.getProceso();

		Integer response = UIHelper.showConfirm("¿Desea entregar el procesado?", "Entregar");

		if (response == JOptionPane.YES_OPTION) {
			EntregaService entregaService = (EntregaService) getService(Constants.ENTREGA_SERVICE);

			OutputConsultaEntrega outputConsultaEntrega = entregaService
					.consultaRutaEntrega(proceso.getModelo().getCodigoProyecto(), proceso.getIdProceso());
			
			log.info("{}", outputConsultaEntrega.toString());
		}
	}

	@Override
	public void onLoad() {
		try {
			ProcesoService procesoService = (ProcesoService) getService(Constants.PROCESO_SERVICE);

			BigDecimal idProceso = (BigDecimal) pantallaResumenProcesado.getParams().get("idProceso");
			OutputConsultaProcesado outputConsultaProcesado = procesoService.consultaProcesado(idProceso);

			if (!Objects.isNull(outputConsultaProcesado)) {
				populateProceso(outputConsultaProcesado);
				populateScripts(outputConsultaProcesado.getListaScriptsEjecutados());
			}
		} catch (ServiceException e) {
			Map<String, Object> errParams = MDSQLUIHelper.buildError(e);
			MDSQLUIHelper.showPopup(pantallaResumenProcesado.getFrameParent(), Constants.CMD_ERROR, errParams);
		}
	}

	/**
	 * @param outputConsultaProcesado
	 */
	private void populateProceso(OutputConsultaProcesado outputConsultaProcesado) {
		pantallaResumenProcesado.getTxtModelo().setText(outputConsultaProcesado.getNombreModelo());
		pantallaResumenProcesado.getTxtSubmodelo().setText(outputConsultaProcesado.getDescripcionSubProyecto());
		pantallaResumenProcesado.getTxtBBDD().setText(outputConsultaProcesado.getNombreBBDD());
		pantallaResumenProcesado.getTxtEsquema().setText(outputConsultaProcesado.getNombreEsquema());
		pantallaResumenProcesado.getTxtBBDDHistorico().setText(outputConsultaProcesado.getNombreBBDDHistorico());
		pantallaResumenProcesado.getTxtEsquemaHistorico().setText(outputConsultaProcesado.getNombreesquemaHistorico());
		pantallaResumenProcesado.getTxtPeticion().setText(outputConsultaProcesado.getCodigoPeticion());
		pantallaResumenProcesado.getTxtUsuario().setText(outputConsultaProcesado.getCodigoUsuario());
		pantallaResumenProcesado.getTxtSolicitadaPor().setText(outputConsultaProcesado.getCodigoUsrPeticion());
		pantallaResumenProcesado.getTxtFecha().setText(outputConsultaProcesado.getFechaProceso().toString());
		pantallaResumenProcesado.getTxtEstado().setText(outputConsultaProcesado.getDescripcionEstadoProceso());
		pantallaResumenProcesado.getTxtRuta().setText(outputConsultaProcesado.getTxtRutaEntrada());
	}

	/**
	 * @param listaScriptsEjecutados
	 */
	private void populateScripts(List<ScriptEjecutado> listaScriptsEjecutados) {
		// Obtiene el modelo y lo actualiza
		ResumenProcesadoScriptsTableModel tableModel = (ResumenProcesadoScriptsTableModel) pantallaResumenProcesado
				.getTblScripts().getModel();
		tableModel.setData(listaScriptsEjecutados);
	}
}
