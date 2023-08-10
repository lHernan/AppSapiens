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
	 * @param informe
	 * @param row
	 */
	@SneakyThrows
	private void createRowInforme(InformeCambios informe, Row row) {
		printCell(row, 0, informe.getCodigoPeticion());
		printCell(row, 1, informe.getIdProceso());
		printCell(row, 2, informe.getNombreObjetoPadre());
		printCell(row, 3, informe.getTipoObjetoPadre());
		printCell(row, 4, informe.getTipoAccionPadre());
		printCell(row, 5, informe.getNombreObjeto());
		printCell(row, 6, informe.getNombreObjetoDestino());
		printCell(row, 7, informe.getTipoObjeto());
		printCell(row, 8, informe.getTipoAccion());
		printCell(row, 9, informe.getNumeroLongitud());
		printCell(row, 10, informe.getNumeroDecimal());
		printCell(row, 11, informe.getDescripcionEstadoProceso());
		printCell(row, 12, dateFormatter.dateToString(informe.getFechaProceso()));
		printCell(row, 13, informe.getCodigoSubProyecto());
		printCell(row, 14, informe.getCodigoUsuarioPeticion());
		printCell(row, 15, informe.getCodigoUsuario());
		printCell(row, 16, informe.getDescripcionEstadoScript());
		printCell(row, 17, informe.getNombreScript());
	}
	
	private void printCell(Row row, Integer i, String value) {
		Cell cell = row.createCell(i);
		String val = (StringUtils.isNotBlank(value)) ? value : StringUtils.EMPTY;  
		cell.setCellValue(val);
	}
	
	private void printCell(Row row, Integer i, BigDecimal value) {
		Cell cell = row.createCell(i);
		String val = (Objects.isNull(value)) ? "0" : value.toString();
		cell.setCellValue(val);
	}
}
