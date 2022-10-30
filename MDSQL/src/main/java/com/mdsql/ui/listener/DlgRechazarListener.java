package com.mdsql.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import com.mdsql.bussiness.entities.Proceso;
import com.mdsql.bussiness.entities.Session;
import com.mdsql.bussiness.service.ProcesoService;
import com.mdsql.ui.DlgRechazar;
import com.mdsql.ui.utils.ListenerSupport;
import com.mdsql.ui.utils.MDSQLUIHelper;
import com.mdsql.utils.Constants;
import com.mdsql.utils.MDSQLAppHelper;
import com.mdval.exceptions.ServiceException;
import com.mdval.ui.utils.UIHelper;

public class DlgRechazarListener extends ListenerSupport implements ActionListener {
	
	private DlgRechazar dlgRechazar;
	
	public DlgRechazarListener(DlgRechazar dlgRechazar) {
		super();
		this.dlgRechazar = dlgRechazar;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton jButton = (JButton) e.getSource();
		
		if (Constants.DLG_RECHAZAR_BTN_ACEPTAR.equals(jButton.getActionCommand())) {
			Integer response = UIHelper.showConfirm("Al rechazar el procesado en curso,\n"
					+ "se desecharán los scripts actuales, incluidos aquellos \n que se han ejecutado sin errores, "
					+ "¿desea continuar?", "Rechazar");

			if (response == JOptionPane.YES_OPTION) {
				rechazarProceso();
			}
		}

		if (Constants.DLG_RECHAZAR_BTN_CANCELAR.equals(jButton.getActionCommand())) {
			dlgRechazar.dispose();
		}
	}

	private void rechazarProceso() {
		try {
			ProcesoService procesoService = (ProcesoService) getService(Constants.PROCESO_SERVICE);
			Session session = (Session) MDSQLAppHelper.getGlobalProperty(Constants.SESSION);
			
			Proceso proceso = (Proceso) dlgRechazar.getParams().get("proceso");
			String txtMotivoRechazo = dlgRechazar.getTxtMotivoRechazo().getText();
			procesoService.rechazarProcesado(proceso.getIdProceso(), txtMotivoRechazo, session.getCodUsr());
			
			proceso.setDescripcionEstadoProceso("Rechazado");
			dlgRechazar.getReturnParams().put("proceso", proceso);
			dlgRechazar.dispose();
			
		} catch (ServiceException e) {
			Map<String, Object> errParams = MDSQLUIHelper.buildError(e);
			MDSQLUIHelper.showPopup(dlgRechazar.getFrameParent(), Constants.CMD_ERROR, errParams);
		}
	}
}
