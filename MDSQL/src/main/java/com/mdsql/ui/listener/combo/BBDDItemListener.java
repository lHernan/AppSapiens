package com.mdsql.ui.listener.combo;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Objects;

import com.mdsql.bussiness.entities.BBDD;
import com.mdsql.ui.PantallaProcesarScript;
import com.mdsql.ui.utils.ListenerSupport;

public class BBDDItemListener extends ListenerSupport implements ItemListener {
	
	private PantallaProcesarScript pantallaProcesarScript;

	public BBDDItemListener(PantallaProcesarScript pantallaProcesarScript) {
		super();
		this.pantallaProcesarScript = pantallaProcesarScript;
	}
	
	@Override
    public void itemStateChanged(ItemEvent event) {
       if (event.getStateChange() == ItemEvent.SELECTED) {
          Object item = event.getItem();
          
          if (!Objects.isNull(item)) {
        	  BBDD bbdd = (BBDD) item;
        	  pantallaProcesarScript.getTxtEsquema().setText(bbdd.getNombreEsquema());
        	  pantallaProcesarScript.getTxtBBDDHistorico().setText(bbdd.getNombreBBDDHis());
        	  pantallaProcesarScript.getTxtEsquemaHistorico().setText(bbdd.getNombreEsquemaHis());
          }
       }
    }   
}