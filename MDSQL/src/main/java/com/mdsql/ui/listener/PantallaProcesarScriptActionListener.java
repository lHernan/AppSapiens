package com.mdsql.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Objects;

import javax.swing.JButton;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import com.mdsql.bussiness.entities.Modelo;
import com.mdsql.bussiness.entities.SubProyecto;
import com.mdsql.ui.PantallaProcesarScript;
import com.mdsql.ui.model.SubProyectoComboBoxModel;
import com.mdsql.ui.utils.ListenerSupport;
import com.mdsql.ui.utils.MDSQLUIHelper;
import com.mdsql.utils.Constants;
import com.mdval.ui.utils.DialogSupport;
import com.mdval.utils.AppHelper;

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

		if (Constants.PANTALLA_PROCESADO_SCRIPT_LIMPIAR.equals(jButton.getActionCommand())) {
			eventBtnLimpiar();
		}
	}

	/**
	 * 
	 */
	private void eventBtnLimpiar() {
		pantallaProcesarScript.getTxtModelo().setText(StringUtils.EMPTY);
		pantallaProcesarScript.getTxtEsquema().setText(StringUtils.EMPTY);
		pantallaProcesarScript.getTxtBBDDHistorico().setText(StringUtils.EMPTY);
		pantallaProcesarScript.getTxtEsquemaHistorico().setText(StringUtils.EMPTY);
		pantallaProcesarScript.getChkGenerarHistorico().setSelected(Boolean.FALSE);
		
		pantallaProcesarScript.getBtnLimpiar().setEnabled(Boolean.FALSE);
	}

	/**
	 * 
	 */
	private void eventBtnProcesar() {
		DialogSupport dialog = MDSQLUIHelper.createDialog(pantallaProcesarScript.getFrameParent(),
				Constants.CMD_SELECCION_HISTORICO);
		MDSQLUIHelper.show(dialog);
	}

	/**
	 * 
	 */
	private void eventBtnSearchModel() {
		DialogSupport dialog = MDSQLUIHelper.createDialog(pantallaProcesarScript.getFrameParent(),
				Constants.CMD_SEARCH_MODEL);
		MDSQLUIHelper.show(dialog);

		Modelo seleccionado = (Modelo) dialog.getReturnParams().get("seleccionado");
		if (!Objects.isNull(seleccionado)) {
			pantallaProcesarScript.getTxtModelo().setText(seleccionado.getCodigoProyecto());
			pantallaProcesarScript.getTxtEsquema().setText(seleccionado.getNombreEsquema());
			pantallaProcesarScript.getTxtBBDDHistorico().setText(seleccionado.getNombreBbdd());
			pantallaProcesarScript.getTxtEsquemaHistorico().setText(seleccionado.getNombreEsquema());
			pantallaProcesarScript.getChkGenerarHistorico()
					.setSelected(AppHelper.normalizeCheckValue(seleccionado.getMcaHis()));
			
			List<SubProyecto> subProyectos = seleccionado.getSubproyectos();
			if (CollectionUtils.isNotEmpty(subProyectos)) {
				SubProyectoComboBoxModel modelSubProyectos = new SubProyectoComboBoxModel(subProyectos);
				pantallaProcesarScript.getCmbSubmodelo().setModel(modelSubProyectos);
				
				if (subProyectos.size() == 1) {
					pantallaProcesarScript.getCmbSubmodelo().setSelectedItem(subProyectos.get(0));
				}
			}

			pantallaProcesarScript.getBtnLimpiar().setEnabled(Boolean.TRUE);
		}
	}
}
