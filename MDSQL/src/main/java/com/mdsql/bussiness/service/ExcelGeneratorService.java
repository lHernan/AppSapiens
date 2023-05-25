package com.mdsql.bussiness.service;

import java.util.List;

import com.mdsql.bussiness.entities.InformeCambios;

/**
 * @author hcarreno
 */
public interface ExcelGeneratorService {

	void generarExcelHistoricoCambios(List<InformeCambios> listaCambios, String path, String codigoProyecto,
			String fechaDesde, String fechaHasta);

}
