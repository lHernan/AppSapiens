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

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

/**
 * @author hcarreno
 */
@Service(MDSQLConstants.EXCEL_GENERATOR_SERVICE)
@Slf4j
public class ExcelGeneratorServiceImpl extends ServiceSupport implements ExcelGeneratorService {

	private static final String FORMATO_ARCHIVO = "%s_Cambios_desde_hasta_%s.xls";

	@Override
	@SneakyThrows
	public void generarExcelHistoricoCambios(List<InformeCambios> listaCambios, String path, String codigoProyecto,
			String fechaDesde, String fechaHasta) {
		
		String fileName = String.format(FORMATO_ARCHIVO, codigoProyecto, fechaHasta);
		log.info("Archivo: {}", fileName);

		try (InputStream inputStream = getClass().getResourceAsStream(MDSQLConstants.LISTADO_HISTORICO_CAMBIOS_TEMPLATE_LOCATION);
				FileOutputStream outputStream = new FileOutputStream(path + File.separator + fileName);
				Workbook workbook = new HSSFWorkbook(inputStream)) {
		
			Sheet sheet = workbook.getSheet("Hoja1");

			setupCabeceraInforme(sheet);

			int rowNum = 1; // row to start writting
			for (InformeCambios informe : listaCambios) {
				createRowInforme(sheet, informe, rowNum);
				rowNum += 1;
			}
	
			workbook.write(outputStream);
		}
	}

	@SneakyThrows
	private void setupCabeceraInforme(Sheet sheet) {
		Row row = sheet.getRow(0);
		
		printCell(row, 0, "Petición");
		printCell(row, 1, "Proceso");
		printCell(row, 2, "Objeto padre");
		printCell(row, 3, "Tipo");
		printCell(row, 4, "Acción");
		printCell(row, 5, "Objeto");
		printCell(row, 6, "Objeto destino");
		printCell(row, 7, "Tipo");
		printCell(row, 8, "Acción");
		printCell(row, 9, "Longitud");
		printCell(row, 10, "Decimal");
		printCell(row, 11, "Estado proceso");
		printCell(row, 12, "Fecha");
		printCell(row, 13, "Subproyecto");
		printCell(row, 14, "Usr petición");
		printCell(row, 15, "Usr");
		printCell(row, 16, "Estado script");
		printCell(row, 17, "Nombre script");
	}

	/**
	 * @param informe
	 * @param row
	 */
	@SneakyThrows
	private void createRowInforme(Sheet sheet, InformeCambios informe, Integer rowNum) {
		Row row = sheet.createRow(rowNum);
		
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
	
	private void printCell(Row row, Integer i, BigDecimal value) {
		printCell(row, i, (Objects.isNull(value)) ? "0" : value.toString());
	}
	
	private void printCell(Row row, Integer i, String value) {
		writeCell(row, i, (StringUtils.isNotBlank(value)) ? value : StringUtils.EMPTY);
	}
	
	private void writeCell(Row row, Integer i, String val) {
		Cell cell = row.createCell(i);
		cell.setCellValue(val);
	}
}
