package com.mdsql.ui.utils.collections;

import org.apache.commons.collections.Closure;

import com.mdsql.bussiness.entities.Script;

public class ScriptSelectedClosure implements Closure {

	@Override
	public void execute(Object input) {
		Script script = (Script) input;
		
		if (!"Ejecutado".equals(script.getDescripcionEstadoScript())) {
			script.setSelected(Boolean.TRUE);
		}
	}

}
