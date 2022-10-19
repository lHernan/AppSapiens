package com.mdsql.ui.utils.creators;

import java.util.Map;

import com.mdsql.ui.PantallaEjecutarScripts;
import com.mdsql.ui.PantallaResumenProcesado;
import com.mdsql.ui.PantallaSeleccionHistorico;
import com.mdsql.ui.PantallaSeleccionModelos;
import com.mdsql.utils.Constants;
import com.mdval.ui.utils.FrameSupport;

/**
 * Factory method para gestionar la creación centralizada de cuadros emergentes
 * de la aplicación. Se le pasa al constructor la ventana padre y la cadena de la
 * opción del menú principal que activa al emergente solicitado.
 * 
 * @author federico
 *
 */
public class FrameCreator extends Creator {
	
	private String option;
	
	private FrameSupport frameParent;
	
	private Boolean modal;
	
	public FrameCreator(String option, Boolean modal) {
		this.modal = Boolean.TRUE;
		this.option = option;
	}
	
	public FrameCreator(FrameSupport frameParent, String option, Boolean modal) {
		this.modal = modal;
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
		FrameSupport frame = null;
		
		if (Constants.CMD_EJECUTAR_SCRIPT.equals(option)) {
			frame = new PantallaEjecutarScripts(frameParent, modal);
		}
		
		if (Constants.CMD_SEARCH_MODEL.equals(option)) {
			frame = new PantallaSeleccionModelos(frameParent, modal, params);
		}
		
		if (Constants.CMD_SELECCION_HISTORICO.equals(option)) {
			frame = new PantallaSeleccionHistorico(frameParent, modal, params);
		}
		
		if (Constants.CMD_RESUMEN_PROCESADO.equals(option)) {
			frame = new PantallaResumenProcesado(frameParent, modal, params);
		}
		
		return frame;
	}
}
