package com.mdsql.ui.utils.collections;

import java.util.List;

import org.apache.commons.collections.Closure;

import com.mdsql.bussiness.entities.OutputRegistraEjecucion;
import com.mdsql.bussiness.entities.Script;

/**
 * @author federico
 *
 */
public class UpdateScriptsClosure implements Closure {
	
	private List<OutputRegistraEjecucion> ejecuciones;
	
	/**
	 * @param ejecuciones
	 */
	public UpdateScriptsClosure(List<OutputRegistraEjecucion> ejecuciones) {
		this.ejecuciones = ejecuciones;
	}

	@Override
	public void execute(Object input) {
		Script script = (Script) input;

		for (OutputRegistraEjecucion ej : ejecuciones) {
			if (script.getNumeroOrden().equals(ej.getNumOrden())) {
				script.setCodigoEstadoScript(ej.getCodigoEstadoScript());
				script.setDescripcionEstadoScript(ej.getDescripcionEstadoScript());
				script.setFecha(ej.getFechaEjecucion());
				script.setOperaciones(ej.getTxtCuadreOperacion());
				script.setObjetos(ej.getTxtCuadreObj());
				
				if ("Ejecutado".equals(ej.getDescripcionEstadoScript())) {
					script.setSelected(Boolean.FALSE);
				}
			}
		}
	}

}
