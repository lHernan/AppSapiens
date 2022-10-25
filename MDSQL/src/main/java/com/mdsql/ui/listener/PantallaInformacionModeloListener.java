package com.mdsql.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

import com.mdsql.bussiness.entities.Aviso;
import com.mdsql.bussiness.service.AvisoService;
import com.mdsql.ui.PantallaInformacionModelo;
import com.mdsql.ui.utils.ListenerSupport;
import com.mdsql.ui.utils.MDSQLUIHelper;
import com.mdsql.utils.Constants;

public class PantallaInformacionModeloListener extends ListenerSupport implements ActionListener, OnLoadListener, Observer {

	private PantallaInformacionModelo pantallaInformacionModelo;
	
	public PantallaInformacionModeloListener(PantallaInformacionModelo pantallaInformacionModelo) {
		super();
		this.pantallaInformacionModelo = pantallaInformacionModelo;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Observable o, Object cmd) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onLoad() {
		try {
			AvisoService avisoService = (AvisoService) getService(Constants.AVISO_SERVICE);
			
			String codigoProyecto;
			
			List<Aviso> consultaAvisosModelo = avisoService.consultaAvisosModelo(codigoProyecto);
			
		}catch (ServiceException e) {
			Map<String, Object> params = MDSQLUIHelper.buildError(e);
			MDSQLUIHelper.showPopup(pantallaInformacionModelo.getFrameParent(), Constants.CMD_ERROR, params);
		}
	}
}
