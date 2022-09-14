package com.mdsql.ui.utils.creators;

import java.util.Map;

import com.mdsql.ui.DlgIdentificador;
import com.mdsql.ui.PantallaBuscadorFicheros;
import com.mdsql.utils.Constants;
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
	
		if (Constants.CMD_INICIAR_APP.equals(option)) {
			dialog = new DlgIdentificador(frameParent, modal);
		}
		
		if (Constants.CMD_LOAD_SCRIPT.equals(option)) {
			dialog = new PantallaBuscadorFicheros(frameParent, modal);
		}
		
		return dialog;
	}
}
