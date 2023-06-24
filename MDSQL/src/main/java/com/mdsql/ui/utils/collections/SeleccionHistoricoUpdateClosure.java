package com.mdsql.ui.utils.collections;

import java.util.List;

import org.apache.commons.collections.Closure;

import com.mdsql.bussiness.entities.SeleccionHistorico;

/**
 * @author federico
 *
 */
public class SeleccionHistoricoUpdateClosure implements Closure {
	
	private List<SeleccionHistorico> seleccionados;

	public SeleccionHistoricoUpdateClosure(List<SeleccionHistorico> seleccionados) {
		this.seleccionados = seleccionados;
	}

	@Override
	public void execute(Object input) {
		SeleccionHistorico seleccionHistorico = (SeleccionHistorico) input;
		
		// Si está en la lista de seleccionados, marcarlo como configurado
		for (SeleccionHistorico seleccion : seleccionados) {
			if (seleccionHistorico.equals(seleccion)) {
				seleccionHistorico.setConfigurado(Boolean.TRUE);
			}
		}
	}

}
