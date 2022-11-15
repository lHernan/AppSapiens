package com.mdsql.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import com.mdsql.bussiness.entities.Proceso;
import com.mdsql.bussiness.entities.Script;
import com.mdsql.bussiness.entities.Session;
import com.mdsql.bussiness.service.ProcesoService;
import com.mdsql.ui.DlgRechazar;
import com.mdsql.ui.utils.ListenerSupport;
import com.mdsql.ui.utils.MDSQLUIHelper;
import com.mdsql.utils.ConfigurationSingleton;
import com.mdsql.utils.Constants;
import com.mdsql.utils.MDSQLAppHelper;
import com.mdval.exceptions.ServiceException;
import com.mdval.ui.utils.UIHelper;
import com.mdval.utils.LogWrapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
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

			// Borrar los scripts lanza y renombrar los logs
			borrarScriptsLanza(proceso);
			rechazarLogs(proceso);

			dlgRechazar.getReturnParams().put("proceso", proceso);
			dlgRechazar.dispose();

		} catch (ServiceException e) {
			Map<String, Object> errParams = MDSQLUIHelper.buildError(e);
			MDSQLUIHelper.showPopup(dlgRechazar.getFrameParent(), Constants.CMD_ERROR, errParams);
		}
	}

	/**
	 * @param proceso
	 */
	private void borrarScriptsLanza(Proceso proceso) {

		List<Script> scripts = proceso.getScripts();
		String ruta = proceso.getRutaTrabajo();

		if (CollectionUtils.isNotEmpty(scripts)) {
			for (Script script : scripts) {
				String lanzaFile = StringUtils.EMPTY;

				try {
					lanzaFile = ruta.concat(script.getNombreScriptLanza());
					Files.delete(Paths.get(lanzaFile));
				} catch (IOException e) {
					LogWrapper.warn(log, "No existe el fichero %s", lanzaFile);
				}
			}
		}
	}

	/**
	 * @param proceso
	 */
	private void rechazarLogs(Proceso proceso) {
		try {
			String sufijoRechazo = ConfigurationSingleton.getInstance().getConfig("SufijoRechazoProcesado");
			List<Script> scripts = proceso.getScripts();
			String ruta = proceso.getRutaTrabajo();

			if (CollectionUtils.isNotEmpty(scripts)) {
				for (Script script : scripts) {
					String nombreFileLog = script.getNombreScriptLog();
					String logFile = ruta.concat(nombreFileLog);
					File file = new File(logFile);

					String name = nombreFileLog.substring(0, nombreFileLog.lastIndexOf('.'));
					String extension = getExtensionByStringHandling(nombreFileLog).get();
					String rechazado = name.concat("_" + sufijoRechazo);
					String fileNameRechazado = rechazado + "." + extension;
					File newFile = new File(ruta.concat(fileNameRechazado));
					file.renameTo(newFile);
				}
			}

		} catch (IOException e) {
			LogWrapper.warn(log, "¡¡¡SufijoRechazoProcesado!!!");
		}
	}

	/**
	 * @param filename
	 * @return
	 */
	private Optional<String> getExtensionByStringHandling(String filename) {
		return Optional.ofNullable(filename).filter(f -> f.contains("."))
				.map(f -> f.substring(filename.lastIndexOf(".") + 1));
	}
}
