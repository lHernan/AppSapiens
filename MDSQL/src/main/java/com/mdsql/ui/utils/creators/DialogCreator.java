package com.mdsql.ui.utils.creators;

import java.util.Map;

import com.mdsql.ui.DlgErrores;
import com.mdsql.ui.DlgExcepcion;
import com.mdsql.ui.DlgRechazar;
import com.mdsql.ui.PantallaAjustarLogEjecucion;
import com.mdsql.ui.PantallaBuscadorFicheros;
import com.mdsql.ui.PantallaConsultaPeticiones;
import com.mdsql.ui.PantallaDescartarScript;
import com.mdsql.ui.PantallaDetalleScript;
import com.mdsql.ui.PantallaEjecutarScripts;
import com.mdsql.ui.PantallaEjecutarTypes;
import com.mdsql.ui.PantallaHistoricoCambios;
import com.mdsql.ui.PantallaInformacionModelo;
import com.mdsql.ui.PantallaProcesadoEnCurso;
import com.mdsql.ui.PantallaProcesarScript;
import com.mdsql.ui.PantallaRepararScript;
import com.mdsql.ui.PantallaResumenProcesado;
import com.mdsql.ui.PantallaSeleccionHistorico;
import com.mdsql.ui.PantallaSeleccionModelos;
import com.mdsql.ui.PantallaVerCuadresScript;
import com.mdsql.ui.PantallaVerErroresScript;
import com.mdsql.utils.MDSQLConstants;
import com.mdval.ui.utils.DialogSupport;
import com.mdval.ui.utils.FrameSupport;

/**
 * Factory method para gestionar la creación centralizada de cuadros emergentes
 * de la aplicación. Se le pasa al constructor la ventana padre y la cadena de la
 * opción del menú principal que activa al emergente solicitado.
 * 
 * @author federico
 *
 */
public class DialogCreator extends Creator {
	
	private String option;
	
	private FrameSupport frameParent;
	
	private Boolean modal;
	
	public DialogCreator(FrameSupport frameParent, String option) {
		this.modal = Boolean.TRUE;
		this.option = option;
		this.frameParent = frameParent;
	}
	
	/**
	 *
	 */
	@Override
	public Object factoryMethod() {
		return null;
	}

	/**
	 *
	 */
	@Override
	public Object factoryMethod(Map<String, Object> params) {
		DialogSupport dialog = null;
		
		if (MDSQLConstants.CMD_LOAD_SCRIPT.equals(option)) {
			dialog = new PantallaBuscadorFicheros(frameParent, modal);
		}
		
		if (MDSQLConstants.CMD_ERROR.equals(option)) {
			dialog = new DlgErrores(frameParent, modal, params);
		}
		
		if (MDSQLConstants.CMD_PROCESADO_EN_CURSO.equals(option)) {
			dialog = new PantallaProcesadoEnCurso(frameParent, modal, params);
		}
		
		if (MDSQLConstants.CMD_PROCESAR_SCRIPT.equals(option)) {
			dialog = new PantallaProcesarScript(frameParent, modal, params);
		}
		
		if (MDSQLConstants.CMD_SEARCH_MODEL.equals(option)) {
			dialog = new PantallaSeleccionModelos(frameParent, modal, params);
		}
		
		if (MDSQLConstants.CMD_SELECCION_HISTORICO.equals(option)) {
			dialog = new PantallaSeleccionHistorico(frameParent, modal, params);
		}
		
		if (MDSQLConstants.CMD_EJECUTAR_SCRIPT.equals(option)) {
			dialog = new PantallaEjecutarScripts(frameParent, modal, params);
		}
		
		if (MDSQLConstants.CMD_RESUMEN_PROCESADO.equals(option)) {
			dialog = new PantallaResumenProcesado(frameParent, modal, params);
		}
		
		if (MDSQLConstants.CMD_VER_ERRORES_SCRIPT.equals(option)) {
			dialog = new PantallaVerErroresScript(frameParent, modal, params);
		}
		
		if (MDSQLConstants.CMD_DETALLE_SCRIPT.equals(option)) {
			dialog = new PantallaDetalleScript(frameParent, modal, params);
		}
		
		if (MDSQLConstants.CMD_VER_CUADRES_SCRIPT.equals(option)) {
			dialog = new PantallaVerCuadresScript(frameParent, modal, params);
		}
		
		if (MDSQLConstants.CMD_REPARAR_SCRIPT.equals(option)) {
			dialog = new PantallaRepararScript(frameParent, modal, params);
		}
		
		if (MDSQLConstants.CMD_DESCARTAR_SCRIPT.equals(option)) {
			dialog = new PantallaDescartarScript(frameParent, modal, params);
		}
		
		if (MDSQLConstants.CMD_EXCEPCION_SCRIPT.equals(option)) {
			dialog = new DlgExcepcion(frameParent, modal, params);
		}
		
		if (MDSQLConstants.CMD_RECHAZAR_PROCESADO.equals(option)) {
			dialog = new DlgRechazar(frameParent, modal, params);
		}
		
		if (MDSQLConstants.CMD_EJECUTAR_TYPE.equals(option)) {
			dialog = new PantallaEjecutarTypes(frameParent, modal, params);
		}
		
		if (MDSQLConstants.CMD_AJUSTAR_LOG_EJECUCION.equals(option)) {
			dialog = new PantallaAjustarLogEjecucion(frameParent, modal, params);
		}
		
		if (MDSQLConstants.CMD_INFORMACION_MODELO.equals(option)) {
			dialog = new PantallaInformacionModelo(frameParent, modal, params);
		}
		
		if (MDSQLConstants.MNU_CONSULTA_HISTORICO_CAMBIOS.equals(option)) {
			dialog = new PantallaHistoricoCambios(frameParent, modal, params);
		}
		
		if (MDSQLConstants.MNU_CONSULTA_PETICIONES.equals(option)) {
			dialog = new PantallaConsultaPeticiones(frameParent, modal, params);
		}
		
		return dialog;
	}
}
