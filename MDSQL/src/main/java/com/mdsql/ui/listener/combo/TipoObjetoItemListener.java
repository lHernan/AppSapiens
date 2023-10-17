package com.mdsql.ui.listener.combo;

import com.mdsql.bussiness.entities.BBDD;
import com.mdsql.ui.utils.ListenerSupport;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Objects;

public abstract class TipoObjetoItemListener extends ListenerSupport implements ItemListener {

	public TipoObjetoItemListener() {
		super();
	}
	
	@Override
    public void itemStateChanged(ItemEvent event) {
       if (event.getStateChange() == ItemEvent.SELECTED) {
          Object item = event.getItem();
          
          if (!Objects.isNull(item)) {
        	  String tipoObjeto = (String) item;
        	  processItem(tipoObjeto);
          }
       }
    }  
	
	public abstract void processItem(String item);
}