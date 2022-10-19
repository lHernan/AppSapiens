package com.mdsql.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import com.mdsql.bussiness.entities.Aviso;
import com.mdsql.bussiness.entities.BBDD;
import com.mdsql.bussiness.entities.InputProcesaScript;
import com.mdsql.bussiness.entities.InputProcesaType;
import com.mdsql.bussiness.entities.InputSeleccionarProcesados;
import com.mdsql.bussiness.entities.Modelo;
import com.mdsql.bussiness.entities.OutputProcesa;
import com.mdsql.bussiness.entities.OutputProcesaScript;
import com.mdsql.bussiness.entities.OutputProcesaType;
import com.mdsql.bussiness.entities.Proceso;
import com.mdsql.bussiness.entities.Script;
import com.mdsql.bussiness.entities.SeleccionHistorico;
import com.mdsql.bussiness.entities.SubProyecto;
import com.mdsql.bussiness.entities.TextoLinea;
import com.mdsql.bussiness.entities.Type;
import com.mdsql.bussiness.service.AvisoService;
import com.mdsql.bussiness.service.BBDDService;
import com.mdsql.bussiness.service.ProcesoService;
import com.mdsql.bussiness.service.ScriptService;
import com.mdsql.bussiness.service.TypeService;
import com.mdsql.ui.PantallaProcesarScript;
import com.mdsql.ui.PantallaResumenProcesado;
import com.mdsql.ui.PantallaSeleccionHistorico;
import com.mdsql.ui.PantallaSeleccionModelos;
import com.mdsql.ui.model.BBDDComboBoxModel;
import com.mdsql.ui.model.ProcesarScriptNotaTableModel;
import com.mdsql.ui.model.ProcesarScriptUltimasPeticionesTableModel;
import com.mdsql.ui.model.SubProyectoComboBoxModel;
import com.mdsql.ui.utils.ListenerSupport;
import com.mdsql.ui.utils.MDSQLUIHelper;
import com.mdsql.utils.AppHelper;
import com.mdsql.utils.Constants;
import com.mdsql.utils.Constants.Procesado;
import com.mdval.exceptions.ServiceException;
import com.mdval.ui.utils.observer.Observable;
import com.mdval.ui.utils.observer.Observer;

/**
 * @author federico
 *
 */
public class PantallaProcesarScriptActionListener extends ListenerSupport implements ActionListener, Observer {

	private PantallaProcesarScript pantallaProcesarScript;
	
	private PantallaSeleccionModelos pantallaSeleccionModelos;
	
	private PantallaSeleccionHistorico pantallaSeleccionHistorico;

	/**
	 * @param framePrincipal
	 */
	public PantallaProcesarScriptActionListener(PantallaProcesarScript pantallaProcesarScript) {
		this.pantallaProcesarScript = pantallaProcesarScript;
	}
	
	public void addObservador(Observer o) {
		this.addObserver(o);
	}

	/**
	 *
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton jButton = (JButton) e.getSource();

		if (Constants.PANTALLA_PROCESADO_SCRIPT_SEARCH_MODEL.equals(jButton.getActionCommand())) {
			eventBtnSearchModel();
		}

		if (Constants.PANTALLA_PROCESADO_SCRIPT_CANCELAR.equals(jButton.getActionCommand())) {
			pantallaProcesarScript.dispose();
		}

		if (Constants.PANTALLA_PROCESADO_SCRIPT_PROCESAR.equals(jButton.getActionCommand())) {
			eventBtnProcesar();
		}

		if (Constants.PANTALLA_PROCESADO_SCRIPT_LIMPIAR.equals(jButton.getActionCommand())) {
			eventBtnLimpiar();
		}
		
		if (Constants.PANTALLA_PROCESADO_SCRIPT_VER_PROCESADO.equals(jButton.getActionCommand())) {
			eventBtnVerProcesado();
		}
	}

	private void eventBtnVerProcesado() {
		Map<String, Object> params = new HashMap<>();
		
		Proceso seleccionado = pantallaProcesarScript.getProcesoSeleccionado();
		
		params.put("idProceso", seleccionado.getIdProceso());
		params.put("entregar", Boolean.FALSE);
		
		PantallaResumenProcesado pantallaResumenProcesado = (PantallaResumenProcesado) MDSQLUIHelper.createFrame(pantallaProcesarScript.getFrameParent(),
				Constants.CMD_RESUMEN_PROCESADO, Boolean.FALSE, params);
		MDSQLUIHelper.show(pantallaResumenProcesado);
	}

	/**
	 * 
	 */
	private void eventBtnLimpiar() {
		pantallaProcesarScript.getTxtModelo().setText(StringUtils.EMPTY);
		pantallaProcesarScript.getTxtEsquema().setText(StringUtils.EMPTY);
		pantallaProcesarScript.getChkGenerarHistorico().setSelected(Boolean.FALSE);
		pantallaProcesarScript.getChkGenerarHistorico().setEnabled(Boolean.FALSE);
		pantallaProcesarScript.getTxtEsquema().setText(StringUtils.EMPTY);
		pantallaProcesarScript.getTxtBBDDHistorico().setText(StringUtils.EMPTY);
		pantallaProcesarScript.getTxtEsquemaHistorico().setText(StringUtils.EMPTY);
		pantallaProcesarScript.getTxtDescripcion().setText(StringUtils.EMPTY);
		pantallaProcesarScript.getTxtSolicitadaPor().setText(StringUtils.EMPTY);
		pantallaProcesarScript.getTxtPeticion().setText(StringUtils.EMPTY);
		pantallaProcesarScript.getTxtDemanda().setText(StringUtils.EMPTY);

		((ProcesarScriptNotaTableModel) pantallaProcesarScript.getTblNotas().getModel()).clearData();
		((ProcesarScriptUltimasPeticionesTableModel) pantallaProcesarScript.getTblUltimasPeticiones().getModel())
				.clearData();
		
		// Clear comboboxes
		DefaultComboBoxModel<BBDD> bbddModel = new DefaultComboBoxModel<BBDD>();
		pantallaProcesarScript.getCmbBBDD().setModel(bbddModel);
		
		DefaultComboBoxModel<SubProyecto> subproyectoModel = new DefaultComboBoxModel<SubProyecto>();
		pantallaProcesarScript.getCmbSubmodelo().setModel(subproyectoModel);

		pantallaProcesarScript.getBtnLimpiar().setEnabled(Boolean.FALSE);
		pantallaProcesarScript.getBtnVerProcesado().setEnabled(Boolean.FALSE);
		
		pantallaProcesarScript.setModeloSeleccionado(null);
	}

	/**
	 * 
	 */
	private void eventBtnProcesar() {
		Modelo seleccionado = pantallaProcesarScript.getModeloSeleccionado();
		
		if (!Objects.isNull(seleccionado)) {
			// El modelo tiene histórico
			if (Constants.S.equals(seleccionado.getMcaHis())) {
				Map<String, Object> params = new HashMap<>();
				params.put("codigoProyecto", seleccionado.getCodigoProyecto());
				params.put("script", pantallaProcesarScript.getParams().get("script"));
				
				pantallaSeleccionHistorico = (PantallaSeleccionHistorico) MDSQLUIHelper.createFrame(pantallaProcesarScript.getFrameParent(),
						Constants.CMD_SELECCION_HISTORICO, Boolean.FALSE, params);
				MDSQLUIHelper.show(pantallaSeleccionHistorico);
				
				pantallaSeleccionHistorico.getPantallaSeleccionHistoricoListener().addObservador(this);
			}
			else {
				Procesado procesado = pantallaProcesarScript.getProcesado();
				
				if (Procesado.TYPE.equals(procesado)) {
					procesarType();
				}
				
				if (Procesado.SCRIPT.equals(procesado)) {
					procesarScript(null);
				}
			}
		}
	}

	/**
	 * 
	 */
	private void eventBtnSearchModel() {
		Map<String, Object> params = new HashMap<>();
		
		String codigoProyecto = pantallaProcesarScript.getTxtModelo().getText();
		
		if (StringUtils.isNotBlank(codigoProyecto)) {
			params.put("codigoProyecto", codigoProyecto);
		}
		
		pantallaSeleccionModelos = (PantallaSeleccionModelos) MDSQLUIHelper.createFrame(pantallaProcesarScript.getFrameParent(),
				Constants.CMD_SEARCH_MODEL, Boolean.FALSE, params);
		MDSQLUIHelper.show(pantallaSeleccionModelos);
		
		pantallaSeleccionModelos.getPantallaSeleccionModelosListener().addObservador(this);
	}

	/**
	 * @param seleccionado
	 */
	private void procesarModelo() throws ServiceException {
		Modelo seleccionado = pantallaProcesarScript.getModeloSeleccionado();
		pantallaProcesarScript.getTxtModelo().setText(seleccionado.getCodigoProyecto());
		pantallaProcesarScript.getTxtEsquema().setText(seleccionado.getNombreEsquema());

		fillSubModelos(seleccionado);

		fillUltimasPeticiones(seleccionado);

		fillAvisos(seleccionado);

		SubProyecto subproyecto = pantallaProcesarScript.getSubproyectoSeleccionado();
		if (!Objects.isNull(subproyecto)) {
			fillBBDD(seleccionado, subproyecto);
		}
		
		fillChkHistorico(seleccionado);

		pantallaProcesarScript.getBtnLimpiar().setEnabled(Boolean.TRUE);
	}

	/**
	 * @param seleccionado
	 */
	private void fillSubModelos(Modelo seleccionado) {
		List<SubProyecto> subProyectos = seleccionado.getSubproyectos();
		if (CollectionUtils.isNotEmpty(subProyectos)) {
			SubProyectoComboBoxModel modelSubProyectos = new SubProyectoComboBoxModel(subProyectos);
			pantallaProcesarScript.getCmbSubmodelo().setModel(modelSubProyectos);

			// Si el modelo solo tiene un solo submodelo, se seleccionará directamente en el
			// combo.
			if (subProyectos.size() == 1) {
				pantallaProcesarScript.setSubproyectoSeleccionado(subProyectos.get(0));
				pantallaProcesarScript.getCmbSubmodelo().setSelectedItem(subProyectos.get(0));
			}
		}
	}

	/**
	 * @param seleccionado
	 */
	private void fillUltimasPeticiones(Modelo seleccionado) throws ServiceException {
		// Limpiar la tabla de peticiones
		((ProcesarScriptUltimasPeticionesTableModel) pantallaProcesarScript.getTblUltimasPeticiones().getModel())
				.clearData();
		
		// Hacer la consulta
		InputSeleccionarProcesados inputSeleccionarProcesados = new InputSeleccionarProcesados();

		inputSeleccionarProcesados.setPCodigoproyecto(seleccionado.getCodigoProyecto());
		inputSeleccionarProcesados.setPUltimas(new BigDecimal(1));

		ProcesoService procesoService = (ProcesoService) getService(Constants.PROCESO_SERVICE);
		List<Proceso> peticiones = procesoService.seleccionarProcesados(inputSeleccionarProcesados);

		if (CollectionUtils.isNotEmpty(peticiones)) {
			populateModelUltimasPeticiones(peticiones);
		}
	}

	/**
	 * @param seleccionado
	 */
	private void fillAvisos(Modelo seleccionado) throws ServiceException {
		// Limpiar la tabla de avisos
		((ProcesarScriptNotaTableModel) pantallaProcesarScript.getTblNotas().getModel()).clearData();
		
		// Hacer la consulta
		AvisoService avisoService = (AvisoService) getService(Constants.AVISO_SERVICE);
		List<Aviso> avisos = avisoService.consultaAvisosModelo(seleccionado.getCodigoProyecto());

		if (CollectionUtils.isNotEmpty(avisos)) {
			populateModelAvisos(avisos);
		}
	}

	/**
	 * @param seleccionado
	 */
	private void fillBBDD(Modelo modelo, SubProyecto subproyecto) throws ServiceException {
		BBDDService bbddService = (BBDDService) getService(Constants.BBDD_SERVICE);

		String codigoProyecto = modelo.getCodigoProyecto();
		String codigoSubproyecto = !Objects.isNull(subproyecto)
				? subproyecto.getCodigoSubProyecto()
				: null;

		List<BBDD> bbdds = bbddService.consultaBBDDModelo(codigoProyecto, codigoSubproyecto);
		if (CollectionUtils.isNotEmpty(bbdds)) {
			BBDDComboBoxModel modelBBDD = new BBDDComboBoxModel(bbdds);
			pantallaProcesarScript.getCmbBBDD().setModel(modelBBDD);
		}
		
		// Pone la base de datos por defecto
		String baseDatos = modelo.getNombreBbdd();
		if (StringUtils.isNotBlank(baseDatos)) {
			BBDDComboBoxModel modelBBDD = (BBDDComboBoxModel) pantallaProcesarScript.getCmbBBDD().getModel();
			for (int i = 0; i < modelBBDD.getSize(); i++) {
				BBDD bbdd = modelBBDD.getElementAt(i);
				if (bbdd.getNombreBBDD().equals(baseDatos)) {
					pantallaProcesarScript.getCmbBBDD().setSelectedItem(bbdd);
				}
			}
		}
	}

	/**
	 * @param seleccionado
	 */
	private void fillChkHistorico(Modelo seleccionado) {
		// En caso de no tener histórico el check de Generar histórico estará desmarcado
		// y deshabilitado.
		String tieneHistorico = seleccionado.getMcaHis();
		if (Constants.N.equals(tieneHistorico)) {
			pantallaProcesarScript.getChkGenerarHistorico().setSelected(Boolean.FALSE);
			pantallaProcesarScript.getChkGenerarHistorico().setEnabled(Boolean.FALSE);
		} else {
			pantallaProcesarScript.getChkGenerarHistorico().setSelected(Boolean.TRUE);
			pantallaProcesarScript.getChkGenerarHistorico().setEnabled(Boolean.FALSE);
		}
	}

	/**)
	 * @param avisos
	 */
	private void populateModelAvisos(List<Aviso> avisos) {
		// Obtiene el modelo y lo actualiza
		ProcesarScriptNotaTableModel tableModel = (ProcesarScriptNotaTableModel) pantallaProcesarScript.getTblNotas()
				.getModel();
		tableModel.setData(avisos);
	}

	/**
	 * @param peticiones
	 */
	private void populateModelUltimasPeticiones(List<Proceso> peticiones) {
		// Obtiene el modelo y lo actualiza
		ProcesarScriptUltimasPeticionesTableModel tableModel = (ProcesarScriptUltimasPeticionesTableModel) pantallaProcesarScript
				.getTblUltimasPeticiones().getModel();
		tableModel.setData(peticiones);
	}
	
	/**
	 * @param objetosHistorico
	 */
	private void procesarScript(List<SeleccionHistorico> objetosHistorico) {
		try {
			String usuario = (String) AppHelper.getGlobalProperty(Constants.COD_USR);
			ScriptService scriptService = (ScriptService) getService(Constants.SCRIPT_SERVICE);
			
			Modelo seleccionado = pantallaProcesarScript.getModeloSeleccionado();
			if (!Objects.isNull(seleccionado)) {
				SubProyecto subProyecto = pantallaProcesarScript.getSubproyectoSeleccionado();
			
				InputProcesaScript inputProcesaScript = new InputProcesaScript();
				List<TextoLinea> lineasScript = pantallaProcesarScript.getScript();
				inputProcesaScript.setLineasScript(lineasScript);
				inputProcesaScript.setPCodigoProyecto(seleccionado.getCodigoProyecto());
				inputProcesaScript.setPCodigoSubProyecto(subProyecto.getCodigoSubProyecto());
				inputProcesaScript.setPCodigoPeticion(pantallaProcesarScript.getTxtPeticion().getText());
				inputProcesaScript.setPCodigoDemanda(pantallaProcesarScript.getTxtDemanda().getText());
				inputProcesaScript.setPMcaReprocesa(Constants.N);
				inputProcesaScript.setPCodigoUsr(usuario);
				inputProcesaScript.setPCodigoUsrPeticion(pantallaProcesarScript.getTxtSolicitadaPor().getText());
				inputProcesaScript.setPMcaHIS(AppHelper.normalizeValueToCheck(pantallaProcesarScript.getChkGenerarHistorico().isSelected()));
				
				BBDD selectedBBDD = (BBDD) pantallaProcesarScript.getCmbBBDD().getSelectedItem();
				inputProcesaScript.setPNombreBBDD(selectedBBDD.getNombreBBDD());
				inputProcesaScript.setPNombreEsquema(selectedBBDD.getNombreEsquema());
				inputProcesaScript.setPNombreBBDDHIS(selectedBBDD.getNombreBBDDHis());
				inputProcesaScript.setPNombreEsquemaHis(selectedBBDD.getNombreEsquemaHis());
				inputProcesaScript.setPTxtDescripcion(pantallaProcesarScript.getTxtDescripcion().getText());
				
				if (objetosHistorico != null) {
					inputProcesaScript.setListaObjetoHis(objetosHistorico);
				}
				
				File file = (File) pantallaProcesarScript.getParams().get("file");
				inputProcesaScript.setPNombreFichaEntrada(file.getName());
				
				String parentPath = file.getAbsoluteFile().getParent();
				inputProcesaScript.setPTxtRutaEntrada(parentPath);
				
				OutputProcesaScript outputProcesaScript = scriptService.procesarScript(inputProcesaScript);
				
				Proceso proceso = generateProceso(usuario, outputProcesaScript);
				proceso.setModelo(seleccionado);
				proceso.setSubproyecto(subProyecto);
				proceso.setBbdd(selectedBBDD);
				
				pantallaProcesarScript.getReturnParams().put("proceso", proceso);
				
				List<Script> listaScripts = outputProcesaScript.getListaScripts();
				
				if (CollectionUtils.isNotEmpty(listaScripts)) {
					Map<String, Script> scripts = new HashMap<>();
				
					for (Script script : listaScripts) {
						scripts.put(script.getTipoScript(), script);
					}
					
					pantallaProcesarScript.getReturnParams().put("scripts", scripts);
				}
				
				updateObservers(Constants.PANTALLA_PROCESADO_SCRIPT_PROCESAR);
				
				pantallaProcesarScript.dispose();
			}
		} catch (ServiceException e) {
			Map<String, Object> errParams = MDSQLUIHelper.buildError(e);
			MDSQLUIHelper.showPopup(pantallaProcesarScript.getFrameParent(), Constants.CMD_ERROR, errParams);
		}
	}
	
	/**
	 * 
	 */
	private void procesarType() {
		try {
			String usuario = (String) AppHelper.getGlobalProperty(Constants.COD_USR);
			TypeService typeService = (TypeService) getService(Constants.TYPE_SERVICE);
			
			Modelo seleccionado = pantallaProcesarScript.getModeloSeleccionado();
			SubProyecto subProyecto = pantallaProcesarScript.getSubproyectoSeleccionado();
		
			InputProcesaType inputProcesaType = new InputProcesaType();
			List<TextoLinea> lineasScript = pantallaProcesarScript.getScript();
			inputProcesaType.setLineasScript(lineasScript);
			inputProcesaType.setPCodigoProyecto(seleccionado.getCodigoProyecto());
			inputProcesaType.setPCodigoSubProyecto(subProyecto.getCodigoSubProyecto());
			inputProcesaType.setPCodigoPeticion(pantallaProcesarScript.getTxtPeticion().getText());
			inputProcesaType.setPCodigoDemanda(pantallaProcesarScript.getTxtDemanda().getText());
			inputProcesaType.setPCodigoUsr(usuario);
			inputProcesaType.setPCodigoUsrPeticion(pantallaProcesarScript.getTxtSolicitadaPor().getText());
			
			BBDD selectedBBDD = (BBDD) pantallaProcesarScript.getCmbBBDD().getSelectedItem();
			inputProcesaType.setPNombreBBDD(selectedBBDD.getNombreBBDD());
			inputProcesaType.setPNombreEsquema(selectedBBDD.getNombreEsquema());
			inputProcesaType.setPTxtDescripcion(pantallaProcesarScript.getTxtDescripcion().getText());
			
			File file = (File) pantallaProcesarScript.getParams().get("file");
			inputProcesaType.setPNombreFichaEntrada(file.getName());
			
			String parentPath = file.getAbsoluteFile().getParent();
			inputProcesaType.setPTxtRutaEntrada(parentPath);
			
			OutputProcesaType outputProcesaType = typeService.procesarType(inputProcesaType);
			
			Proceso proceso = generateProceso(usuario, outputProcesaType);
			proceso.setModelo(seleccionado);
			proceso.setSubproyecto(subProyecto);
			proceso.setBbdd(selectedBBDD);
			
			pantallaProcesarScript.getReturnParams().put("proceso", proceso);
			
			List<Type> listaTypes = outputProcesaType.getListaType();
			
			if (CollectionUtils.isNotEmpty(listaTypes)) {
				pantallaProcesarScript.getReturnParams().put("types", listaTypes);
			}
			
			updateObservers(Constants.PANTALLA_PROCESADO_SCRIPT_PROCESAR);
			
			pantallaProcesarScript.dispose();
		} catch (ServiceException e) {
			Map<String, Object> errParams = MDSQLUIHelper.buildError(e);
			MDSQLUIHelper.showPopup(pantallaProcesarScript.getFrameParent(), Constants.CMD_ERROR, errParams);
		}
	}

	/**
	 * @param usuario
	 * @param outputProcesa
	 * @return
	 */
	private Proceso generateProceso(String usuario, OutputProcesa outputProcesa) {
		Proceso proceso = new Proceso();
		proceso.setIdProceso(outputProcesa.getIdProceso());
		proceso.setCodigoEstadoProceso(outputProcesa.getPCodigoEstadoProceso());
		proceso.setDescripcionEstadoProceso(outputProcesa.getPDescripcionEstadoProceso());
		
		proceso.setCodigoPeticion(pantallaProcesarScript.getTxtPeticion().getText());
		proceso.setCodigoDemanda(pantallaProcesarScript.getTxtDemanda().getText());
		proceso.setCodigoUsr(usuario);
		proceso.setCodigoUsrPeticion(pantallaProcesarScript.getTxtSolicitadaPor().getText());
		proceso.setTxtDescripcion(pantallaProcesarScript.getTxtDescripcion().getText());
		return proceso;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void update(Observable o, Object cmd) {
		String command = (String) cmd;
		if (Constants.PANTALLA_SELECCION_MODELOS_BTN_SELECCIONAR.equals(command)) {
			establecerModelo();
		}
		
		if (Constants.PANTALLA_SELECCION_HISTORICA_BTN_GENERAR.equals(command)) {
			Boolean continuarProcesado = (Boolean) pantallaSeleccionHistorico.getReturnParams().get("procesado");
			List<SeleccionHistorico> objetosHistorico = (List<SeleccionHistorico>) pantallaSeleccionHistorico.getReturnParams().get("objetosHistorico");
			if (continuarProcesado) {
				procesarScript(objetosHistorico);
			}
			else {
				JOptionPane.showMessageDialog(pantallaProcesarScript.getFrameParent(), "Operación cancelada");
			}
		}
	}

	/**
	 * 
	 */
	private void establecerModelo() {
		try {
			Modelo seleccionado = pantallaSeleccionModelos.getSeleccionado();
			if (!Objects.isNull(seleccionado)) {
				pantallaProcesarScript.setModeloSeleccionado(seleccionado);
				procesarModelo();
			}
		} catch (ServiceException e) {
			Map<String, Object> errParams = MDSQLUIHelper.buildError(e);
			MDSQLUIHelper.showPopup(pantallaProcesarScript.getFrameParent(), Constants.CMD_ERROR, errParams);
		}
	}
}
