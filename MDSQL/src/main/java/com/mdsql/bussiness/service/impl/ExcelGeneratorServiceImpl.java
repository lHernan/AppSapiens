package com.mdsql.bussiness.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import com.mdsql.bussiness.entities.Historico;
import com.mdsql.utils.DateFormatter;
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

	private static final String FORMATO_ARCHIVO_HISTORICO_CAMBIOS = "%s_Cambios_desde_hasta_%s.xls";

	private static final String FORMATO_ARCHIVO_HISTORICO = "%s_SufijoExcelObjHistorico_%s.xls";

	private DateFormatter dateInformeFormatter;

	public ExcelGeneratorServiceImpl() {
		dateInformeFormatter = new DateFormatter(MDSQLConstants.INFORME_DATE_FORMAT);
	}

	@Override
	@SneakyThrows
	public void generarExcelHistoricoCambios(List<InformeCambios> listaCambios, String path, String codigoProyecto,
			String fechaDesde, String fechaHasta) {
		
		String fileName = String.format(FORMATO_ARCHIVO_HISTORICO_CAMBIOS, codigoProyecto, fechaHasta);
		log.info("Archivo: {}", fileName);

		try (InputStream inputStream = getClass().getResourceAsStream(MDSQLConstants.LISTADO_HISTORICO_CAMBIOS_TEMPLATE_LOCATION);
				FileOutputStream outputStream = new FileOutputStream(path + File.separator + fileName);
				Workbook workbook = new HSSFWorkbook(inputStream)) {
		
			Sheet sheet = workbook.getSheet("Hoja1");

			setupCabeceraInformeHistoricoCambios(sheet);

			int rowNum = 1; // row to start writting
			for (InformeCambios informe : listaCambios) {
				createRowInformeHistoricoCambios(sheet, informe, rowNum);
				rowNum += 1;
			}
	
			workbook.write(outputStream);
		}
	}

	@Override
	@SneakyThrows
	public void generarExcelHistorico(List<Historico> lista, String path, String codigoProyecto, Date date) {
		String sDate = dateInformeFormatter.dateToString(date);

		String fileName = String.format(FORMATO_ARCHIVO_HISTORICO, codigoProyecto, sDate);
		log.info("Archivo: {}", fileName);

		try (InputStream inputStream = getClass().getResourceAsStream(MDSQLConstants.LISTADO_HISTORICO_TEMPLATE_LOCATION);
			 FileOutputStream outputStream = new FileOutputStream(path + File.separator + fileName);
			 Workbook workbook = new HSSFWorkbook(inputStream)) {

			Sheet sheet = workbook.getSheet("Hoja1");

			setupCabeceraInformeHistorico(sheet);

			int rowNum = 1; // row to start writting
			for (Historico historico : lista) {
				createRowInformeHistorico(sheet, historico, rowNum);
				rowNum += 1;
			}

			workbook.write(outputStream);
		}
	}

	private void setupCabeceraInformeHistorico(Sheet sheet) {
		Row row = sheet.getRow(0);

		printCell(row, 0, "Nombre Objeto");
		printCell(row, 1, "Historificado");
		printCell(row, 2, "Tipo Objeto");
		printCell(row, 3, "Petición");
		printCell(row, 4, "Fecha");
		printCell(row, 5, "Usuario");
	}

	private void createRowInformeHistorico(Sheet sheet, Historico historico, int rowNum) {
		Row row = sheet.createRow(rowNum);

		printCell(row, 0, historico.getNombreObjeto());
		printCell(row, 1, historico.getHistorificado());
		printCell(row, 2, historico.getTipoObjeto());
		printCell(row, 3, historico.getPeticion());

		String sDate = dateInformeFormatter.dateToString(historico.getFecha());
		printCell(row, 4, sDate);
		printCell(row, 5, historico.getCodigoUsuario());
	}

	@SneakyThrows
	private void setupCabeceraInformeHistoricoCambios(Sheet sheet) {
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
	 * @param rowNum
	 */
	@SneakyThrows
	private void createRowInformeHistoricoCambios(Sheet sheet, InformeCambios informe, Integer rowNum) {
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
		printCell(row, i, (Objects.isNull(value)) ? BigDecimal.ZERO.toString() : value.toString());
	}
	
	private void printCell(Row row, Integer i, String value) {
		writeCell(row, i, (StringUtils.isNotBlank(value)) ? value : StringUtils.EMPTY);
	}
	
	private void writeCell(Row row, Integer i, String val) {
		Cell cell = row.createCell(i);
		cell.setCellValue(val);
	}
}
