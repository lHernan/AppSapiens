package com.mdsql.ui.utils.creators;

import java.util.Map;

import com.mdsql.ui.model.cabeceras.Cabecera;
import com.mdsql.ui.model.cabeceras.TablaCuadresObjetosCabecera;
import com.mdsql.ui.model.cabeceras.TablaCuadresOperacionesCabecera;
import com.mdsql.ui.model.cabeceras.TablaErroresCabecera;
import com.mdsql.ui.model.cabeceras.TablaModelosCabecera;
import com.mdsql.ui.model.cabeceras.TablaNotasCabecera;
import com.mdsql.ui.model.cabeceras.TablaParchesCabecera;
import com.mdsql.ui.model.cabeceras.TablaResumenProcesadoObjetosCabecera;
import com.mdsql.ui.model.cabeceras.TablaResumenProcesadoOperacionesCabecera;
import com.mdsql.ui.model.cabeceras.TablaResumenProcesadoScriptsCabecera;
import com.mdsql.ui.model.cabeceras.TablaScriptsCabecera;
import com.mdsql.ui.model.cabeceras.TablaSeleccionHistoricoCabecera;
import com.mdsql.ui.model.cabeceras.TablaTypesCabecera;
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
		
		if (Constants.RESUMEN_PROCESADO_OBJETOS_TABLA_CABECERA.equals(item)) {
			cabecera = new TablaResumenProcesadoObjetosCabecera();
		}
		
		if (Constants.RESUMEN_PROCESADO_OPERACIONES_TABLA_CABECERA.equals(item)) {
			cabecera = new TablaResumenProcesadoOperacionesCabecera();
		}
		
		if (Constants.FRAME_PRINCIPAL_TYPES_TABLA_CABECERA.equals(item)) {
			cabecera = new TablaTypesCabecera();
		}
		
		if (Constants.SCRIPTS_TABLA_CABECERA.equals(item)) {
			cabecera = new TablaScriptsCabecera();
		}
		
		if (Constants.VER_ERRORES_TABLA_CABECERA.equals(item)) {
			cabecera = new TablaErroresCabecera();
		}
		
		if (Constants.VER_PARCHES_TABLA_CABECERA.equals(item)) {
			cabecera = new TablaParchesCabecera();
		}
		
		if (Constants.VER_CUADRES_OPERACIONES_TABLA_CABECERA.equals(item)) {
			cabecera = new TablaCuadresOperacionesCabecera();
		}
		
		if (Constants.VER_CUADRES_OBJETOS_TABLA_CABECERA.equals(item)) {
			cabecera = new TablaCuadresObjetosCabecera();
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
