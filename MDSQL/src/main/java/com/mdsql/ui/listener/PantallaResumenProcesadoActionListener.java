package com.mdsql.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import org.apache.commons.collections.CollectionUtils;

import com.mdsql.bussiness.entities.OutputConsultaEntrega;
import com.mdsql.bussiness.entities.OutputConsultaProcesado;
import com.mdsql.bussiness.entities.Proceso;
import com.mdsql.bussiness.entities.Script;
import com.mdsql.bussiness.entities.ScriptEjecutado;
import com.mdsql.bussiness.entities.ScriptType;
import com.mdsql.bussiness.entities.Session;
import com.mdsql.bussiness.entities.Type;
import com.mdsql.bussiness.service.EntregaService;
import com.mdsql.bussiness.service.ProcesoService;
import com.mdsql.ui.PantallaResumenProcesado;
import com.mdsql.ui.model.ResumenProcesadoScriptsTableModel;
import com.mdsql.ui.utils.ListenerSupport;
import com.mdsql.ui.utils.MDSQLUIHelper;
import com.mdsql.utils.ConfigurationSingleton;
import com.mdsql.utils.MDSQLAppHelper;
import com.mdsql.utils.MDSQLConstants;
import com.mdval.exceptions.ServiceException;
import com.mdval.ui.utils.OnLoadListener;
import com.mdval.ui.utils.UIHelper;

import lombok.extern.slf4j.Slf4j;
import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.exception.ZipException;

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

		if (MDSQLConstants.PANTALLA_RESUMEN_PROCESADO_ENTREGAR.equals(jButton.getActionCommand())) {
			evtEntregar();
		}

		if (MDSQLConstants.PANTALLA_RESUMEN_PROCESADO_CANCELAR.equals(jButton.getActionCommand())) {
			pantallaResumenProcesado.dispose();
		}
	}

	/**
	 * 
	 */
	private void evtEntregar() {
		try {
			Session session = (Session) MDSQLAppHelper.getGlobalProperty(MDSQLConstants.SESSION);
			Proceso proceso = session.getProceso();

			Integer response = UIHelper.showConfirm("¿Desea entregar el procesado?", "Entregar");

			if (response == JOptionPane.YES_OPTION) {
				EntregaService entregaService = (EntregaService) getService(MDSQLConstants.ENTREGA_SERVICE);

				OutputConsultaEntrega outputConsultaEntrega = entregaService
						.consultaRutaEntrega(proceso.getModelo().getCodigoProyecto(), proceso.getIdProceso());
				
				// Entregar petición antes de hacer los ficheros, para controlar el comentario
				String txtComentario = pantallaResumenProcesado.getTxtComentarios().getText();
				String codUsr = session.getCodUsr();

				String estado = entregaService.entregarPeticion(proceso.getIdProceso(), codUsr, txtComentario);

				// Esto es cuando se procesan scripts SQL
				if (CollectionUtils.isNotEmpty(proceso.getScripts())) {
					createZipVigente(proceso, outputConsultaEntrega);
					copyZipVigente(outputConsultaEntrega);
					copyFilesVigente(proceso.getScripts());
	
					if (tieneScriptsHistoricos(proceso.getScripts())) {
						createZipHistorico(proceso, outputConsultaEntrega);
						copyZipHistorico(outputConsultaEntrega);
						copyFilesHistorico(proceso.getScripts());
					}
				}
				
				// Esto es cuando se procesan scripts type
				if (CollectionUtils.isNotEmpty(proceso.getTypes())) {
					createZipType(proceso, outputConsultaEntrega);
					copyZipVigente(outputConsultaEntrega);
					copyFiles(proceso.getTypes());
				}

				proceso.setDescripcionEstadoProceso(estado);
				pantallaResumenProcesado.getReturnParams().put("cmd", MDSQLConstants.CMD_ENTREGAR_SCRIPT);
				pantallaResumenProcesado.getReturnParams().put("estado", estado);

				pantallaResumenProcesado.dispose();
			}
		} catch (ServiceException | IOException e) {
			Map<String, Object> errParams = MDSQLUIHelper.buildError(e);
			MDSQLUIHelper.showPopup(pantallaResumenProcesado.getFrameParent(), MDSQLConstants.CMD_ERROR, errParams);
		}
	}

	@Override
	public void onLoad() {
		try {
			ProcesoService procesoService = (ProcesoService) getService(MDSQLConstants.PROCESO_SERVICE);

			BigDecimal idProceso = (BigDecimal) pantallaResumenProcesado.getParams().get("idProceso");
			OutputConsultaProcesado outputConsultaProcesado = procesoService.consultaProcesado(idProceso);

			if (!Objects.isNull(outputConsultaProcesado)) {
				populateProceso(outputConsultaProcesado);
				populateScripts(outputConsultaProcesado.getListaScriptsEjecutados());
			}
		} catch (ServiceException e) {
			Map<String, Object> errParams = MDSQLUIHelper.buildError(e);
			MDSQLUIHelper.showPopup(pantallaResumenProcesado.getFrameParent(), MDSQLConstants.CMD_ERROR, errParams);
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
		pantallaResumenProcesado.getTxtComentarios().setText(outputConsultaProcesado.getTxtComentario());
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

	/**
	 * @param proceso
	 * @param outputConsultaEntrega
	 */
	private void createZipVigente(Proceso proceso, OutputConsultaEntrega outputConsultaEntrega) throws IOException {
		createZip(proceso, outputConsultaEntrega.getTxtRutaEntrega(), outputConsultaEntrega.getNombreFicheroVigente(),
				Arrays.asList(new String[] { "SQL", "PDC" }));
	}
	
	private void createZipType(Proceso proceso, OutputConsultaEntrega outputConsultaEntrega) throws IOException {
		createZip(proceso, outputConsultaEntrega.getTxtRutaEntrega(), outputConsultaEntrega.getNombreFicheroType(),
				null);
	}

	/**
	 * @param proceso
	 * @param outputConsultaEntrega
	 */
	private void createZipHistorico(Proceso proceso, OutputConsultaEntrega outputConsultaEntrega) throws IOException {
		createZip(proceso, outputConsultaEntrega.getTxtRutaEntrega(), outputConsultaEntrega.getNombreFicheroHistorico(),
				Arrays.asList(new String[] { "SQLH", "PDCH" }));
	}

	/**
	 * @param proceso
	 * @param rutaEntrega
	 * @param nombreFichero
	 * @param scriptTypes
	 * @throws IOException
	 */
	private void createZip(Proceso proceso, String rutaEntrega, String nombreFichero, List<String> scriptTypes)
			throws IOException {
		Session session = (Session) MDSQLAppHelper.getGlobalProperty(MDSQLConstants.SESSION);

		String zipFileName = rutaEntrega + File.separator + nombreFichero;
		log.info("Zip file name: {}", zipFileName);

		try (ZipFile zipFile = new ZipFile(zipFileName)) {
			if (CollectionUtils.isNotEmpty(proceso.getScripts())) {
				addScriptsSQL(proceso, scriptTypes, session, zipFile);
			}
			
			if (CollectionUtils.isNotEmpty(proceso.getTypes())) {
				addScriptsTypes(proceso, session, zipFile);
			}
		}
	}

	/**
	 * @param proceso
	 * @param scriptTypes
	 * @param session
	 * @param zipFile
	 * @throws ZipException
	 */
	private void addScriptsSQL(Proceso proceso, List<String> scriptTypes, Session session, ZipFile zipFile)
			throws ZipException {
		for (Script script : proceso.getScripts()) {
			if (scriptTypes.contains(script.getTipoScript())) {
				zipFile.addFile(new File(session.getSelectedRoute() + File.separator + script.getNombreScript()));
			}
		}
	}
	
	/**
	 * @param proceso
	 * @param session
	 * @param zipFile
	 * @throws ZipException
	 */
	private void addScriptsTypes(Proceso proceso, Session session, ZipFile zipFile)
			throws ZipException {
		for (Type type : proceso.getTypes()) {
			for (ScriptType scriptType : type.getScriptType()) {
				zipFile.addFile(new File(session.getSelectedRoute() + File.separator + scriptType.getNombreScript()));
			}
		}
	}

	/**
	 * @param scripts
	 * @return
	 */
	private boolean tieneScriptsHistoricos(List<Script> scripts) {
		List<String> scriptTypes = Arrays.asList(new String[] { "SQLH", "PDCH" });
		
		for (Script script : scripts) {
			if (scriptTypes.contains(script.getTipoScript())) {
				return true;
			}
		}

		return false;
	}

	/**
	 * @param outputConsultaEntrega
	 */
	private void copyZipVigente(OutputConsultaEntrega outputConsultaEntrega) throws IOException {
		copyZip(outputConsultaEntrega.getTxtRutaEntrega(), outputConsultaEntrega.getNombreFicheroVigente());
	}
	
	/**
	 * @param outputConsultaEntrega
	 */
	private void copyZipHistorico(OutputConsultaEntrega outputConsultaEntrega) throws IOException {
		copyZip(outputConsultaEntrega.getTxtRutaEntrega(), outputConsultaEntrega.getNombreFicheroHistorico());
	}
	
	/**
	 * @param rutaEntrega
	 * @param nombreZip
	 * @throws IOException
	 */
	private void copyZip(String rutaEntrega, String nombreZip) throws IOException {
		Session session = (Session) MDSQLAppHelper.getGlobalProperty(MDSQLConstants.SESSION);
		String carpetaEntregados = (String) ConfigurationSingleton.getInstance().getConfig("CarpetaEntregaFicheros");
		String rutaEntregados = session.getSelectedRoute() + File.separator + carpetaEntregados;
		log.info("Ruta entregados: {}", rutaEntregados);

		String zipFile = rutaEntrega + File.separator + nombreZip;
		copyFile(zipFile, rutaEntregados + File.separator + nombreZip);
	}

	/**
	 * @param scripts
	 */
	private void copyFilesVigente(List<Script> scripts) throws IOException {
		copyFiles(scripts, Arrays.asList(new String[] { "SQL", "PDC" }));
	}
	
	/**
	 * @param scripts
	 */
	private void copyFilesHistorico(List<Script> scripts) throws IOException {
		copyFiles(scripts, Arrays.asList(new String[] { "SQLH", "PDCH" }));
	}
	
	/**
	 * @param scripts
	 */
	private void copyFiles(List<Script> scripts, List<String> scriptTypes) throws IOException {
		Session session = (Session) MDSQLAppHelper.getGlobalProperty(MDSQLConstants.SESSION);
		String carpetaEntregados = (String) ConfigurationSingleton.getInstance().getConfig("CarpetaEntregaFicheros");
		String rutaEntregados = session.getSelectedRoute() + File.separator + carpetaEntregados;

		for (Script script : scripts) {
			if (scriptTypes.contains(script.getTipoScript())) {
				String rutaScript = session.getSelectedRoute() + File.separator + script.getNombreScript();
				copyFile(rutaScript, rutaEntregados + File.separator + script.getNombreScript());
			}
		}
	}
	
	/**
	 * @param scripts
	 */
	private void copyFiles(List<Type> types) throws IOException {
		Session session = (Session) MDSQLAppHelper.getGlobalProperty(MDSQLConstants.SESSION);
		String carpetaEntregados = (String) ConfigurationSingleton.getInstance().getConfig("CarpetaEntregaFicheros");
		String rutaEntregados = session.getSelectedRoute() + File.separator + carpetaEntregados;

		for (Type type : types) {
			for (ScriptType scriptType : type.getScriptType()) {
				String rutaScript = session.getSelectedRoute() + File.separator + scriptType.getNombreScript();
				copyFile(rutaScript, rutaEntregados + File.separator + scriptType.getNombreScript());
			}
		}
	}

	/**
	 * @param sourcePath
	 * @param targetPath
	 * @return
	 */
	private boolean copyFile(String sourcePath, String targetPath) {
		boolean fileCopied = true;

		try {
			Files.copy(Paths.get(sourcePath), Paths.get(targetPath), StandardCopyOption.REPLACE_EXISTING);
		} catch (Exception e) {
			fileCopied = false;
			log.error(e.getMessage());
		}

		return fileCopied;
	}
}
