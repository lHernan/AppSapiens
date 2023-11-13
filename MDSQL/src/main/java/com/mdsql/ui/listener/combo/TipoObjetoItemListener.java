package com.mdsql.ui.listener.combo;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import com.mdsql.ui.utils.ListenerSupport;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class TipoObjetoItemListener extends ListenerSupport implements ItemListener {

	public TipoObjetoItemListener() {
		super();
	}
	
	@Override
    public void itemStateChanged(ItemEvent event) {
		if (event.getStateChange() == ItemEvent.SELECTED) {
			Object item = event.getItem();
			
			log.info("Selected: {}", item);
          
			String tipoObjeto = (String) item;
			processItem(tipoObjeto);
		}
		
		if (event.getStateChange() == ItemEvent.DESELECTED) {
			processDeselected();
		}
    }  
	
	public abstract void processItem(String item);
	
	public abstract void processDeselected();
}