package com.mdsql.ui.listener.combo;

import com.mdsql.bussiness.entities.BBDD;
import com.mdsql.bussiness.service.PermisosService;
import com.mdsql.ui.PantallaPermisosGeneralesporModeloporTipoObjeto;
import com.mdsql.ui.PantallaProcesarScript;
import com.mdsql.ui.model.PermisoComboBoxModel;
import com.mdsql.ui.utils.MDSQLUIHelper;
import com.mdsql.utils.MDSQLConstants;
import com.mdval.exceptions.ServiceException;

import java.util.List;
import java.util.Map;

public class PermisosGeneralesTipoObjetoItemListener extends TipoObjetoItemListener {

	private PantallaPermisosGeneralesporModeloporTipoObjeto pantallaPermisosGeneralesporModeloporTipoObjeto;

	public PermisosGeneralesTipoObjetoItemListener(PantallaPermisosGeneralesporModeloporTipoObjeto pantallaPermisosGeneralesporModeloporTipoObjeto) {
		super();
		this.pantallaPermisosGeneralesporModeloporTipoObjeto = pantallaPermisosGeneralesporModeloporTipoObjeto;
	}

	@Override
	public void processItem(String item) {
		try {
			PermisosService permisosService = (PermisosService) getService(MDSQLConstants.PERMISOS_SERVICE);

			List<String> permisos = permisosService.consultarPermisosPorTipoObjeto(item);

			PermisoComboBoxModel permisoComboBoxModel = new PermisoComboBoxModel(permisos);
			pantallaPermisosGeneralesporModeloporTipoObjeto.getCmbPermiso().setModel(permisoComboBoxModel);
		} catch (ServiceException e) {
			Map<String, Object> errParams = MDSQLUIHelper.buildError(e);
			MDSQLUIHelper.showPopup(pantallaPermisosGeneralesporModeloporTipoObjeto.getFrameParent(), MDSQLConstants.CMD_ERROR, errParams);
		}
	}

}
