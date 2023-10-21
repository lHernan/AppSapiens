package com.mdsql.bussiness.service;

import java.util.Date;
import java.util.List;

import com.mdsql.bussiness.entities.Historico;
import com.mdsql.bussiness.entities.InformeCambios;

/**
 * @author hcarreno
 */
public interface ExcelGeneratorService {

	void generarExcelHistoricoCambios(List<InformeCambios> listaCambios, String path, String codigoProyecto,
			String fechaDesde, String fechaHasta);

    void generarExcelHistorico(List<Historico> lista, String path, String codigoProyecto, Date date);
}
