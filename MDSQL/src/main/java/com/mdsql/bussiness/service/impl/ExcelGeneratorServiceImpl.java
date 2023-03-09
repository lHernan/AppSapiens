package com.mdsql.bussiness.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Service;

import com.mdsql.bussiness.entities.InformeCambios;
import com.mdsql.bussiness.service.ExcelGeneratorService;
import com.mdsql.utils.MDSQLConstants;
import com.mdval.utils.LogWrapper;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

/**
 * @author hcarreno
 */
@Service(MDSQLConstants.EXCEL_GENERATOR_SERVICE)
@Slf4j
public class ExcelGeneratorServiceImpl extends ServiceSupport implements ExcelGeneratorService {

	private static final String FORMATO_MENSAJE_ARCHIVO = "Archivo: %s";

	@Override
	@SneakyThrows
	public void generarExcelHistoricoCambios(List<InformeCambios> listaCambios, String path, String codigoProyecto,
			String fechaDesde, String fechaHasta) {

		InputStream inputStream = getClass().getResourceAsStream(MDSQLConstants.LISTADO_HISTORICO_CAMBIOS_TEMPLATE_LOCATION);
		Workbook workbook = new HSSFWorkbook(inputStream);
		Sheet sheet = workbook.getSheet("Hoja1");

		setupCabeceraInforme(sheet);

		int rownum = 2; // row to start writting
		for (InformeCambios informe : listaCambios) {
			Row row = sheet.createRow(rownum++);
			createRowInforme(informe, row);
		}

		String format = "%s_Cambios_desde__hasta_%s.xls";
		String fileName = String.format(format, codigoProyecto, fechaHasta);
		LogWrapper.debug(log, FORMATO_MENSAJE_ARCHIVO, fileName);
		FileOutputStream outputStream = new FileOutputStream(path + File.separator + fileName);
		workbook.write(outputStream);
		workbook.close();
		outputStream.flush();
		outputStream.close();

	}

	@SneakyThrows
	private void setupCabeceraInforme(Sheet sheet) {
		Row headerRow = sheet.getRow(1);
		
		Cell cell_01 = headerRow.getCell(0);
		cell_01.setCellValue("Petición");
		
		Cell cell_02 = headerRow.getCell(1);
		cell_02.setCellValue("Proceso");
		
		Cell cell_03 = headerRow.getCell(2);
		cell_03.setCellValue("Objeto padre");
		
		Cell cell_04 = headerRow.getCell(3);
		cell_04.setCellValue("Tipo");
		
		Cell cell_05 = headerRow.getCell(4);
		cell_05.setCellValue("Acción");
		
		Cell cell_06 = headerRow.getCell(5);
		cell_06.setCellValue("Objeto");
		
		Cell cell_07 = headerRow.getCell(6);
		cell_07.setCellValue("Objeto destino");
		
		Cell cell_08 = headerRow.getCell(7);
		cell_08.setCellValue("Tipo");
		
		Cell cell_09 = headerRow.getCell(8);
		cell_09.setCellValue("Acción");
		
		Cell cell_10 = headerRow.getCell(9);
		cell_10.setCellValue("Longitud");
		
		Cell cell_11 = headerRow.getCell(10);
		cell_11.setCellValue("Decimal");
		
		Cell cell_12 = headerRow.getCell(11);
		cell_12.setCellValue("Estado proceso");
		
		Cell cell_13 = headerRow.getCell(12);
		cell_13.setCellValue("Fecha");
		
		Cell cell_14 = headerRow.getCell(13);
		cell_14.setCellValue("Subproyecto");
		
		Cell cell_15 = headerRow.getCell(14);
		cell_15.setCellValue("Usr petición");
		
		Cell cell_16 = headerRow.getCell(15);
		cell_16.setCellValue("Usr");
		
		Cell cell_17 = headerRow.getCell(16);
		cell_17.setCellValue("Estado script");
		
		Cell cell_18 = headerRow.getCell(17);
		cell_18.setCellValue("Nombre script");
	}

	/**
	 * @param campoGlosario
	 * @param row
	 */
	@SneakyThrows
	private void createRowInforme(InformeCambios informe, Row row) // creating cells for each row
	{
		Cell cell = row.createCell(0);
		cell.setCellValue(informe.getCodigoPeticion());

		cell = row.createCell(1);
		cell.setCellValue(informe.getIdProceso().toString());

		cell = row.createCell(2);
		cell.setCellValue(informe.getNombreObjetoPadre());

		cell = row.createCell(3);
		cell.setCellValue(informe.getTipoObjetoPadre());

		cell = row.createCell(4);
		cell.setCellValue(informe.getTipoAccionPadre());

		cell = row.createCell(5);
		cell.setCellValue(informe.getNombreObjeto());

		cell = row.createCell(6);
		cell.setCellValue(informe.getNombreObjetoDestino());

		cell = row.createCell(7);
		cell.setCellValue(informe.getTipoObjeto());

		cell = row.createCell(8);
		cell.setCellValue(informe.getTipoAccion());
		
		cell = row.createCell(9);
		cell.setCellValue(informe.getNumeroLongitud().toString());
		
		cell = row.createCell(10);
		cell.setCellValue(informe.getNumeroDecimal().toString());
		
		cell = row.createCell(11);
		cell.setCellValue(informe.getDescripcionEstadoProceso());
		
		cell = row.createCell(12);
		cell.setCellValue(dateFormatter.dateToString(informe.getFechaProceso()));
		
		cell = row.createCell(13);
		cell.setCellValue(informe.getCodigoSubProyecto());
		
		cell = row.createCell(14);
		cell.setCellValue(informe.getCodigoUsuarioPeticion());
		
		cell = row.createCell(15);
		cell.setCellValue(informe.getCodigoUsuario());
		
		cell = row.createCell(16);
		cell.setCellValue(informe.getDescripcionEstadoScript());
		
		cell = row.createCell(17);
		cell.setCellValue(informe.getNombreScript());
	}
}
