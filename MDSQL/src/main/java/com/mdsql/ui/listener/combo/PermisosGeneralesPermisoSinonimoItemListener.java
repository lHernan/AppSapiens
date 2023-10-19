package com.mdsql.ui.listener.combo;

import com.mdsql.bussiness.service.PermisosService;
import com.mdsql.ui.PantallaPermisosGeneralesporModeloporTipoObjeto;
import com.mdsql.ui.model.PermisoComboBoxModel;
import com.mdsql.ui.utils.MDSQLUIHelper;
import com.mdsql.utils.MDSQLConstants;
import com.mdval.exceptions.ServiceException;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Map;

public class PermisosGeneralesPermisoSinonimoItemListener extends PermisoSinonimoItemListener {

	private PantallaPermisosGeneralesporModeloporTipoObjeto pantallaPermisosGeneralesporModeloporTipoObjeto;

	public PermisosGeneralesPermisoSinonimoItemListener(PantallaPermisosGeneralesporModeloporTipoObjeto pantallaPermisosGeneralesporModeloporTipoObjeto) {
		super();
		this.pantallaPermisosGeneralesporModeloporTipoObjeto = pantallaPermisosGeneralesporModeloporTipoObjeto;
	}

	@Override
	public void processItem(String item) {
		if ("Permiso".equals(item)) {
			pantallaPermisosGeneralesporModeloporTipoObjeto.getCmbPropietarioSinonimo().setSelectedItem(null);
			pantallaPermisosGeneralesporModeloporTipoObjeto.getCmbPropietarioSinonimo().setEnabled(Boolean.FALSE);
			pantallaPermisosGeneralesporModeloporTipoObjeto.getTxtFuncionNombre().setText(StringUtils.EMPTY);
			pantallaPermisosGeneralesporModeloporTipoObjeto.getTxtFuncionNombre().setEnabled(Boolean.FALSE);

			pantallaPermisosGeneralesporModeloporTipoObjeto.getCmbWithGrantOpcion().setEnabled(Boolean.TRUE);
			pantallaPermisosGeneralesporModeloporTipoObjeto.getCmbPermiso().setEnabled(Boolean.TRUE);
		}

		if (("Sinónimo").equals(item)) {
			pantallaPermisosGeneralesporModeloporTipoObjeto.getCmbWithGrantOpcion().setSelectedItem(null);
			pantallaPermisosGeneralesporModeloporTipoObjeto.getCmbWithGrantOpcion().setEnabled(Boolean.FALSE);
			pantallaPermisosGeneralesporModeloporTipoObjeto.getCmbPermiso().setSelectedItem(null);
			pantallaPermisosGeneralesporModeloporTipoObjeto.getCmbPermiso().setEnabled(Boolean.FALSE);

			pantallaPermisosGeneralesporModeloporTipoObjeto.getCmbPropietarioSinonimo().setEnabled(Boolean.TRUE);
			pantallaPermisosGeneralesporModeloporTipoObjeto.getTxtFuncionNombre().setEnabled(Boolean.TRUE);
		}
	}

}
