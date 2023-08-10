package com.mdsql.bussiness.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
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

		int rownum = 1; // row to start writting
		for (InformeCambios informe : listaCambios) {
			Row row = sheet.createRow(rownum++);
			createRowInforme(informe, row);
		}

		String format = "%s_Cambios_desde_hasta_%s.xls";
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
		Row headerRow = sheet.getRow(0);
		
		Cell cell_01 = headerRow.createCell(0);
		cell_01.setCellValue("Petición");
		
		Cell cell_02 = headerRow.createCell(1);
		cell_02.setCellValue("Proceso");
		
		Cell cell_03 = headerRow.createCell(2);
		cell_03.setCellValue("Objeto padre");
		
		Cell cell_04 = headerRow.createCell(3);
		cell_04.setCellValue("Tipo");
		
		Cell cell_05 = headerRow.createCell(4);
		cell_05.setCellValue("Acción");
		
		Cell cell_06 = headerRow.createCell(5);
		cell_06.setCellValue("Objeto");
		
		Cell cell_07 = headerRow.createCell(6);
		cell_07.setCellValue("Objeto destino");
		
		Cell cell_08 = headerRow.createCell(7);
		cell_08.setCellValue("Tipo");
		
		Cell cell_09 = headerRow.createCell(8);
		cell_09.setCellValue("Acción");
		
		Cell cell_10 = headerRow.createCell(9);
		cell_10.setCellValue("Longitud");
		
		Cell cell_11 = headerRow.createCell(10);
		cell_11.setCellValue("Decimal");
		
		Cell cell_12 = headerRow.createCell(11);
		cell_12.setCellValue("Estado proceso");
		
		Cell cell_13 = headerRow.createCell(12);
		cell_13.setCellValue("Fecha");
		
		Cell cell_14 = headerRow.createCell(13);
		cell_14.setCellValue("Subproyecto");
		
		Cell cell_15 = headerRow.createCell(14);
		cell_15.setCellValue("Usr petición");
		
		Cell cell_16 = headerRow.createCell(15);
		cell_16.setCellValue("Usr");
		
		Cell cell_17 = headerRow.createCell(16);
		cell_17.setCellValue("Estado script");
		
		Cell cell_18 = headerRow.createCell(17);
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
		printCell(cell, informe.getCodigoPeticion());

		cell = row.createCell(1);
		printCell(cell, informe.getIdProceso());

		cell = row.createCell(2);
		printCell(cell, informe.getNombreObjetoPadre());

		cell = row.createCell(3);
		printCell(cell, informe.getTipoObjetoPadre());

		cell = row.createCell(4);
		printCell(cell, informe.getTipoAccionPadre());

		cell = row.createCell(5);
		printCell(cell, informe.getNombreObjeto());

		cell = row.createCell(6);
		printCell(cell, informe.getNombreObjetoDestino());
		
		cell = row.createCell(7);
		printCell(cell, informe.getTipoObjeto());

		cell = row.createCell(8);
		printCell(cell, informe.getTipoAccion());
		
		cell = row.createCell(9);
		printCell(cell, informe.getNumeroLongitud());
		
		cell = row.createCell(10);
		printCell(cell, informe.getNumeroDecimal());
		
		cell = row.createCell(11);
		printCell(cell, informe.getDescripcionEstadoProceso());
		
		cell = row.createCell(12);
		printCell(cell, dateFormatter.dateToString(informe.getFechaProceso()));
		
		cell = row.createCell(13);
		printCell(cell, informe.getCodigoSubProyecto());
		
		cell = row.createCell(14);
		printCell(cell, informe.getCodigoUsuarioPeticion());
		
		cell = row.createCell(15);
		printCell(cell, informe.getCodigoUsuario());
		
		cell = row.createCell(16);
		printCell(cell, informe.getDescripcionEstadoScript());
		
		cell = row.createCell(17);
		printCell(cell, informe.getNombreScript());
	}
	
	private void printCell(Cell cell, String value) {
		if(StringUtils.isNotBlank(value)) {
			cell.setCellValue(value);
		} else {
			cell.setCellValue(StringUtils.EMPTY);
		}
	}
	
	private void printCell(Cell cell, BigDecimal value) {
		if(Objects.isNull(value)) {
			cell.setCellValue("0");
		} else {
			cell.setCellValue(value.toString());
		}
	}
}
