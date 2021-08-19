package com.sapiens.mdval.ui.utils.dialog;

import java.util.Map;

import javax.swing.JFrame;

import com.sapiens.mdval.ui.DlgIdentificador;
import com.sapiens.mdval.ui.glosarios.DlgBajaGlosarioCampos;
import com.sapiens.mdval.ui.utils.DialogSupport;
import com.sapiens.mdval.utils.Constants;

/**
 * Factory method para gestionar la creación centralizada de cuadros emergentes
 * de la aplicación. Se le pasa al constructor la ventana padre y la cadena de la
 * opción del menú principal que activa al emergente solicitado.
 * 
 * @author federico
 *
 */
public class DialogCreator extends Creator {
	
	private String menuOption;
	
	private JFrame frameParent;
	
	private Boolean modal;
	
	public DialogCreator(JFrame frameParent, String menuOption) {
		this.modal = Boolean.TRUE;
		this.menuOption = menuOption;
		this.frameParent = frameParent;
	}

	/**
	 *
	 */
	@Override
	public Object factoryMethod(Map<String, Object> params) {
		DialogSupport dialog = null;
		
		if (Constants.CMD_INICIAR_APP.equals(menuOption)) {
			dialog = new DlgIdentificador(frameParent, modal);
		}
		
		if (Constants.CMD_BAJA_GLOSARIO_CAMPOS.equals(menuOption)) {
			dialog = new DlgBajaGlosarioCampos(frameParent, modal, params);
		}
		
		return dialog;
	}

}
