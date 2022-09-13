package com.mdsql.ui.utils.creators;

import java.util.Map;

import com.mdval.ui.utils.FrameSupport;

/**
 * Factory method para gestionar la creación centralizada de cuadros emergentes
 * de la aplicación. Se le pasa al constructor la cadena de la
 * opción del menú principal que activa al emergente solicitado.
 * 
 * @author federico
 *
 */
public class FrameCreator extends Creator {
	
	private String option;
	
	private FrameSupport parent;
	
	public FrameCreator(String option) {
		this.option = option;
	}
	
	public FrameCreator(FrameSupport parent, String option) {
		this.parent = parent;
		this.option = option;
	}

	/**
	 *
	 */
	@Override
	public Object factoryMethod() {
		return null;
	}
	
	/**
	 *
	 */
	@Override
	public Object factoryMethod(Map<String, Object> params) {
		FrameSupport frame = null;
		
		
		
		return frame;
	}
}
