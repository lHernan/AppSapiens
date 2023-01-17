package com.mdsql.ui.utils.creators;

import java.util.Map;

import com.mdsql.ui.model.cabeceras.TablaAjustarLogEjecucionCabecera;
import com.mdsql.ui.model.cabeceras.TablaConsultaPeticionesCabecera;
import com.mdsql.ui.model.cabeceras.TablaCuadresObjetosCabecera;
import com.mdsql.ui.model.cabeceras.TablaCuadresOperacionesCabecera;
import com.mdsql.ui.model.cabeceras.TablaDetalleScriptCabecera;
import com.mdsql.ui.model.cabeceras.TablaEjecutarTypesCabecera;
import com.mdsql.ui.model.cabeceras.TablaErroresCabecera;
import com.mdsql.ui.model.cabeceras.TablaInformacionModeloCabecera;
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
import com.mdsql.utils.MDSQLConstants;
import com.mdval.ui.model.cabeceras.Cabecera;

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
		
		if (MDSQLConstants.DLG_SELECCION_MODELOS_TABLA_CABECERA.equals(item)) {
			cabecera = new TablaModelosCabecera();
		}
		
		if (MDSQLConstants.PROCESAR_SCRIPT_NOTAS_TABLA_CABECERA.equals(item)) {
			cabecera = new TablaNotasCabecera();
		}
		
		if (MDSQLConstants.PROCESAR_SCRIPT_ULTIMAS_PETICIONES_TABLA_CABECERA.equals(item)) {
			cabecera = new TablaUltimasPeticionesCabecera();
		}
		
		if (MDSQLConstants.SELECCION_HISTORICO_TABLA_CABECERA.equals(item)) {
			cabecera = new TablaSeleccionHistoricoCabecera();
		}
		
		if (MDSQLConstants.RESUMEN_PROCESADO_SCRIPTS_TABLA_CABECERA.equals(item)) {
			cabecera = new TablaResumenProcesadoScriptsCabecera();
		}
		
		if (MDSQLConstants.RESUMEN_PROCESADO_OBJETOS_TABLA_CABECERA.equals(item)) {
			cabecera = new TablaResumenProcesadoObjetosCabecera();
		}
		
		if (MDSQLConstants.RESUMEN_PROCESADO_OPERACIONES_TABLA_CABECERA.equals(item)) {
			cabecera = new TablaResumenProcesadoOperacionesCabecera();
		}
		
		if (MDSQLConstants.FRAME_PRINCIPAL_TYPES_TABLA_CABECERA.equals(item)) {
			cabecera = new TablaTypesCabecera();
		}
		
		if (MDSQLConstants.SCRIPTS_TABLA_CABECERA.equals(item)) {
			cabecera = new TablaScriptsCabecera();
		}
		
		if (MDSQLConstants.TYPES_TABLA_CABECERA.equals(item)) {
			cabecera = new TablaEjecutarTypesCabecera();
		}
		
		if (MDSQLConstants.VER_ERRORES_TABLA_CABECERA.equals(item)) {
			cabecera = new TablaErroresCabecera();
		}
		
		if (MDSQLConstants.VER_PARCHES_TABLA_CABECERA.equals(item)) {
			cabecera = new TablaParchesCabecera();
		}
		
		if (MDSQLConstants.VER_CUADRES_OPERACIONES_TABLA_CABECERA.equals(item)) {
			cabecera = new TablaCuadresOperacionesCabecera();
		}
		
		if (MDSQLConstants.VER_CUADRES_OBJETOS_TABLA_CABECERA.equals(item)) {
			cabecera = new TablaCuadresObjetosCabecera();
		}
		
		if (MDSQLConstants.DLG_DETALLE_SCRIPT_TABLA_CABECERA.equals(item)) {
			cabecera = new TablaDetalleScriptCabecera();
		}
		
		if (MDSQLConstants.DLG_CONSULTA_PETICIONES_TABLA_CABECERA.equals(item)) {
			cabecera = new TablaConsultaPeticionesCabecera();
		}
		
		if (MDSQLConstants.DLG_INFORMACION_MODELO_TABLA_CABECERA.equals(item)) {
			cabecera = new TablaInformacionModeloCabecera();
		}
		
		if (MDSQLConstants.DLG_AJUSTAR_LOG_EJECUCION_TABLA_CABECERA.equals(item)) {
			cabecera = new TablaAjustarLogEjecucionCabecera();
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
