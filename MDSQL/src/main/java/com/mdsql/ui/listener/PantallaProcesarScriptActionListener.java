package com.mdsql.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

import javax.swing.JButton;

import com.mdsql.bussiness.entities.Modelo;
import com.mdsql.ui.PantallaProcesarScript;
import com.mdsql.ui.utils.ListenerSupport;
import com.mdsql.ui.utils.MDSQLUIHelper;
import com.mdsql.utils.Constants;
import com.mdval.ui.utils.DialogSupport;

/**
 * @author federico
 *
 */
public class PantallaProcesarScriptActionListener extends ListenerSupport implements ActionListener {
	
	private PantallaProcesarScript pantallaProcesarScript;

	/**
	 * @param framePrincipal
	 */
	public PantallaProcesarScriptActionListener(PantallaProcesarScript pantallaProcesarScript) {
		this.pantallaProcesarScript = pantallaProcesarScript;
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
	}

	/**
	 * 
	 */
	private void eventBtnProcesar() {
		DialogSupport dialog = MDSQLUIHelper.createDialog(pantallaProcesarScript.getFrameParent(), Constants.CMD_SELECCION_HISTORICO);
		MDSQLUIHelper.show(dialog);
	}

	/**
	 * 
	 */
	private void eventBtnSearchModel() {
		DialogSupport dialog = MDSQLUIHelper.createDialog(pantallaProcesarScript.getFrameParent(), Constants.CMD_SEARCH_MODEL);
		MDSQLUIHelper.show(dialog);
		
		Modelo seleccionado = (Modelo) dialog.getReturnParams().get("seleccionado");
		if (!Objects.isNull(seleccionado)) {
			pantallaProcesarScript.getTxtModelo().setText(seleccionado.getCodigoProyecto());
		}
	}
}
