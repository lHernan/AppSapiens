package com.mdsql.ui.utils.creators;

import java.util.Map;

import com.mdsql.ui.model.cabeceras.Cabecera;
import com.mdsql.ui.model.cabeceras.TablaModelosCabecera;
import com.mdsql.ui.model.cabeceras.TablaNotasCabecera;
import com.mdsql.ui.model.cabeceras.TablaResumenProcesadoScriptsCabecera;
import com.mdsql.ui.model.cabeceras.TablaSeleccionHistoricoCabecera;
import com.mdsql.ui.model.cabeceras.TablaUltimasPeticionesCabecera;
import com.mdsql.utils.Constants;

/**
 * Factory method para gestionar la creación centralizada de la cabecera de 
 * títulos de las tablas.
 * 
 * @author federico
 *
 */
public class CabeceraTablaCreator extends Creator {
	
	private String item;
	
	public CabeceraTablaCreator(String item) {
		this.item = item;
	}
	
	@Override
	public Object factoryMethod() {
		Cabecera cabecera = null;
		
		if (Constants.DLG_SELECCION_MODELOS_TABLA_CABECERA.equals(item)) {
			cabecera = new TablaModelosCabecera();
		}
		
		if (Constants.PROCESAR_SCRIPT_NOTAS_TABLA_CABECERA.equals(item)) {
			cabecera = new TablaNotasCabecera();
		}
		
		if (Constants.PROCESAR_SCRIPT_ULTIMAS_PETICIONES_TABLA_CABECERA.equals(item)) {
			cabecera = new TablaUltimasPeticionesCabecera();
		}
		
		if (Constants.SELECCION_HISTORICO_TABLA_CABECERA.equals(item)) {
			cabecera = new TablaSeleccionHistoricoCabecera();
		}
		
		if (Constants.RESUMEN_PROCESADO_SCRIPTS_TABLA_CABECERA.equals(item)) {
			cabecera = new TablaResumenProcesadoScriptsCabecera();
		}
		
		return cabecera;
	}

	/**
	 *
	 */
	@Override
	public Object factoryMethod(Map<String, Object> params) {
		return null;
	}
}
