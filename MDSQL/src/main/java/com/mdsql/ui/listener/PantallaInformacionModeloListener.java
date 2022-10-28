package com.mdsql.ui.listener;

import java.util.List;
import java.util.Map;

import com.mdsql.bussiness.entities.Aviso;
import com.mdsql.bussiness.service.AvisoService;
import com.mdsql.ui.PantallaInformacionModelo;
import com.mdsql.ui.utils.ListenerSupport;
import com.mdsql.ui.utils.MDSQLUIHelper;
import com.mdsql.utils.Constants;
import com.mdval.exceptions.ServiceException;
import com.mdval.ui.utils.OnLoadListener;

public class PantallaInformacionModeloListener extends ListenerSupport implements OnLoadListener {

	private PantallaInformacionModelo pantallaInformacionModelo;
	
	public PantallaInformacionModeloListener(PantallaInformacionModelo pantallaInformacionModelo) {
		super();
		this.pantallaInformacionModelo = pantallaInformacionModelo;
	}

	@Override
	public void onLoad() {
		try {
			AvisoService avisoService = (AvisoService) getService(Constants.AVISO_SERVICE);
			
			String codigoProyecto = (String) pantallaInformacionModelo.getParams().get("codigoProyecto");
			
			List<Aviso> consultaAvisosModelo = avisoService.consultaAvisosModelo(codigoProyecto);
			
		} catch (ServiceException e) {
			Map<String, Object> params = MDSQLUIHelper.buildError(e);
			MDSQLUIHelper.showPopup(pantallaInformacionModelo.getFrameParent(), Constants.CMD_ERROR, params);
		}
	}
}
