package com.mdsql.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URI;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import com.mdsql.bussiness.entities.OutputConsultaEntrega;
import com.mdsql.bussiness.entities.OutputConsultaProcesado;
import com.mdsql.bussiness.entities.Proceso;
import com.mdsql.bussiness.entities.Script;
import com.mdsql.bussiness.entities.ScriptEjecutado;
import com.mdsql.bussiness.entities.Session;
import com.mdsql.bussiness.service.EntregaService;
import com.mdsql.bussiness.service.ProcesoService;
import com.mdsql.ui.PantallaResumenProcesado;
import com.mdsql.ui.model.ResumenProcesadoScriptsTableModel;
import com.mdsql.ui.utils.ListenerSupport;
import com.mdsql.ui.utils.MDSQLUIHelper;
import com.mdsql.utils.ConfigurationSingleton;
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
		try {
			Session session = (Session) MDSQLAppHelper.getGlobalProperty(Constants.SESSION);
			Proceso proceso = session.getProceso();

			Integer response = UIHelper.showConfirm("¿Desea entregar el procesado?", "Entregar");

			if (response == JOptionPane.YES_OPTION) {
				EntregaService entregaService = (EntregaService) getService(Constants.ENTREGA_SERVICE);

				OutputConsultaEntrega outputConsultaEntrega = entregaService
						.consultaRutaEntrega(proceso.getModelo().getCodigoProyecto(), proceso.getIdProceso());

				createZipVigente(proceso, outputConsultaEntrega);
				moveZipVigente(outputConsultaEntrega);
				moveFilesVigente(proceso.getScripts());
				
				if (tieneScriptsHistoricos(proceso.getScripts())) {
					createZipHistorico(proceso, outputConsultaEntrega);
					moveZipHistorico(outputConsultaEntrega);
					moveFilesHistorico(proceso.getScripts());
				}
				
				// Entregar petición
				String txtComentario = pantallaResumenProcesado.getTxtComentarios().getText();
				String codUsr = session.getCodUsr();
				
				String estado = entregaService.entregarPeticion(proceso.getIdProceso(), codUsr, txtComentario);
				proceso.setDescripcionEstadoProceso(estado);
				pantallaResumenProcesado.getReturnParams().put("cmd", Constants.CMD_ENTREGAR_SCRIPT);
				pantallaResumenProcesado.getReturnParams().put("estado", estado);
				
				pantallaResumenProcesado.dispose();
			}
		} catch (IOException e) {
			Map<String, Object> errParams = MDSQLUIHelper.buildError(e);
			MDSQLUIHelper.showPopup(pantallaResumenProcesado.getFrameParent(), Constants.CMD_ERROR, errParams);
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

	/**
	 * @param proceso
	 * @param outputConsultaEntrega
	 */
	private void createZipVigente(Proceso proceso, OutputConsultaEntrega outputConsultaEntrega) throws IOException {
		Map<String, String> env = new HashMap<>();
		// Create the zip file if it doesn't exist
		env.put("create", "true");
		
		Session session = (Session) MDSQLAppHelper.getGlobalProperty(Constants.SESSION);
		
		String stringUri = "jar:file:" + outputConsultaEntrega.getTxtRutaEntrega() + "\\"
				+ outputConsultaEntrega.getNombreFicheroVigente();
		URI uri = URI.create(stringUri);
		
		try (FileSystem zipfs = FileSystems.newFileSystem(uri, env)) {
			for (Script script : proceso.getScripts()) {
				if ("SQL".equals(script.getTipoScript()) || "PDC".equals(script.getTipoScript())) {
					Path externalTxtFile = Paths.get(session.getSelectedRoute() + "\\" + script.getNombreScript());
				    Path pathInZipfile = zipfs.getPath(script.getNombreScript());          
				    // Copy a file into the zip file
				    Files.copy(externalTxtFile, pathInZipfile, StandardCopyOption.REPLACE_EXISTING); 
				}
			}
		}
	}

	/**
	 * @param proceso
	 * @param outputConsultaEntrega
	 */
	private void createZipHistorico(Proceso proceso, OutputConsultaEntrega outputConsultaEntrega) throws IOException {
		Map<String, String> env = new HashMap<>();
		// Create the zip file if it doesn't exist
		env.put("create", "true");
		
		Session session = (Session) MDSQLAppHelper.getGlobalProperty(Constants.SESSION);
		
		String stringUri = "jar:file:" + outputConsultaEntrega.getTxtRutaEntrega() + "\\"
				+ outputConsultaEntrega.getNombreFicheroHistorico();
		URI uri = URI.create(stringUri);
		
		try (FileSystem zipfs = FileSystems.newFileSystem(uri, env)) {
			for (Script script : proceso.getScripts()) {
				if ("SQLH".equals(script.getTipoScript()) || "PDCH".equals(script.getTipoScript())) {
					Path externalTxtFile = Paths.get(session.getSelectedRoute() + "\\" + script.getNombreScript());
				    Path pathInZipfile = zipfs.getPath(script.getNombreScript());          
				    // Copy a file into the zip file
				    Files.copy(externalTxtFile, pathInZipfile, StandardCopyOption.REPLACE_EXISTING); 
				}
			}
		}
	}
	
	/**
	 * @param scripts
	 * @return
	 */
	private boolean tieneScriptsHistoricos(List<Script> scripts) {
		for (Script script : scripts) {
			if ("SQLH".equals(script.getTipoScript()) || "PDCH".equals(script.getTipoScript())) {
				return true; 
			}
		}
		
		return false;
	}
	
	/**
	 * @param outputConsultaEntrega
	 */
	private void moveZipVigente(OutputConsultaEntrega outputConsultaEntrega) throws IOException {
		Session session = (Session) MDSQLAppHelper.getGlobalProperty(Constants.SESSION);
		String carpetaEntregados = (String) ConfigurationSingleton.getInstance().getConfig("CarpetaEntregaFicheros");
		String rutaEntregados = session.getSelectedRoute() + "\\" + carpetaEntregados;
		
		String zipFile = outputConsultaEntrega.getTxtRutaEntrega() + "\\"
				+ outputConsultaEntrega.getNombreFicheroVigente();
		moveFile(zipFile, rutaEntregados + "\\" + outputConsultaEntrega.getNombreFicheroVigente());
	}
	
	/**
	 * @param scripts
	 */
	private void moveFilesVigente(List<Script> scripts) throws IOException {
		Session session = (Session) MDSQLAppHelper.getGlobalProperty(Constants.SESSION);
		String carpetaEntregados = (String) ConfigurationSingleton.getInstance().getConfig("CarpetaEntregaFicheros");
		String rutaEntregados = session.getSelectedRoute() + "\\" + carpetaEntregados;
		
		for (Script script : scripts) {
			if ("SQL".equals(script.getTipoScript()) || "PDC".equals(script.getTipoScript())) {
				String rutaScript = session.getSelectedRoute() + "\\" + script.getNombreScript();
				moveFile(rutaScript, rutaEntregados + "\\" + script.getNombreScript());
			}
		}
	}
	
	/**
	 * @param outputConsultaEntrega
	 */
	private void moveZipHistorico(OutputConsultaEntrega outputConsultaEntrega) throws IOException {
		Session session = (Session) MDSQLAppHelper.getGlobalProperty(Constants.SESSION);
		String carpetaEntregados = (String) ConfigurationSingleton.getInstance().getConfig("CarpetaEntregaFicheros");
		String rutaEntregados = session.getSelectedRoute() + "\\" + carpetaEntregados;
		
		String zipFile = outputConsultaEntrega.getTxtRutaEntrega() + "\\"
				+ outputConsultaEntrega.getNombreFicheroHistorico();
		moveFile(zipFile, rutaEntregados + "\\" + outputConsultaEntrega.getNombreFicheroHistorico());
	}
	
	/**
	 * @param scripts
	 */
	private void moveFilesHistorico(List<Script> scripts) throws IOException {
		Session session = (Session) MDSQLAppHelper.getGlobalProperty(Constants.SESSION);
		String carpetaEntregados = (String) ConfigurationSingleton.getInstance().getConfig("CarpetaEntregaFicheros");
		String rutaEntregados = session.getSelectedRoute() + "\\" + carpetaEntregados;
		
		for (Script script : scripts) {
			if ("SQLH".equals(script.getTipoScript()) || "PDCH".equals(script.getTipoScript())) {
				String rutaScript = session.getSelectedRoute() + "\\" + script.getNombreScript();
				moveFile(rutaScript, rutaEntregados + "\\" + script.getNombreScript());
			}
		}
	}
	
	/**
	 * @param sourcePath
	 * @param targetPath
	 * @return
	 */
	private boolean moveFile(String sourcePath, String targetPath) {
	    boolean fileMoved = true;

	    try {
	        Files.move(Paths.get(sourcePath), Paths.get(targetPath), StandardCopyOption.REPLACE_EXISTING);
	    } catch (Exception e) {
	        fileMoved = false;
	        log.error(e.getMessage());
	    }

	    return fileMoved;
	}
}
