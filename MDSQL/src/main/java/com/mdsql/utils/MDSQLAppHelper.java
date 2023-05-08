package com.mdsql.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextArea;

import org.apache.any23.encoding.TikaEncodingDetector;
import org.apache.commons.lang3.StringUtils;

import com.mdsql.bussiness.entities.TextoLinea;
import com.mdval.utils.AppGlobalSingleton;
import com.mdval.utils.AppHelper;
import com.mdval.utils.LogWrapper;

import lombok.extern.slf4j.Slf4j;

/**
 * @author federico
 *
 */
@Slf4j
public class MDSQLAppHelper extends AppHelper {

	/**
	 * @param key
	 * @return
	 */
	public static Object getGlobalProperty(String key) {
		return AppGlobalSingleton.getInstance().getProperty(key);
	}

	/**
	 * @param key
	 * @param value
	 */
	public static void setGlobalProperty(String key, Object value) {
		AppGlobalSingleton.getInstance().setProperty(key, value);
	}

	/**
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public static Charset detectCharsetFromFile(File file) throws IOException {
		try (InputStream is = new FileInputStream(file)) {
			Charset charset = Charset.forName(new TikaEncodingDetector().guessEncoding(is));
			return charset;
		} catch (IOException e) {
			throw e;
		}
	}

	/**
	 * @param content
	 * @param file
	 * @throws IOException
	 */
	public static void writeToFile(String content, File file) throws IOException {
		StringBuffer strBuffer = new StringBuffer(content);
		try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), MDSQLConstants.CP_1252))) {
			writer.write(strBuffer.toString());
			writer.flush();
		} 
	}

	/**
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public static String writeFileToString(File file) throws IOException {
		StringBuffer strBuffer = new StringBuffer(StringUtils.EMPTY);

		try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), MDSQLConstants.CP_1252))) {
			// reader = new BufferedReader(new FileReader(csvFile));
			String line = StringUtils.EMPTY;

			while ((line = reader.readLine()) != null) {
				strBuffer.append(line + MDSQLConstants.CR);

			}
			
			return strBuffer.toString();
		}
	}
	
	public static List<TextoLinea> writeFileToLines(File file) throws IOException {
		List<TextoLinea> linesList = new ArrayList<>();

		try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), MDSQLConstants.CP_1252))) {
			// reader = new BufferedReader(new FileReader(csvFile));
			String line = StringUtils.EMPTY;

			while ((line = reader.readLine()) != null) {
				TextoLinea textoLinea = TextoLinea.builder().valor(line).build();
				linesList.add(textoLinea);
			}
			
			return linesList;
		}
	}

	/**
	 * @param fileName
	 */
	public static void createEmptyFile(String fileName) {
		try {
			File file = new File(fileName);
			file.createNewFile();

			LogWrapper.debug(log, "Fichero creado: %s", fileName);
		} catch (Exception e) {
		}
	}

	/**
	 * @param lineas
	 * @param txtScript
	 */
	public static void dumpContentToText(List<TextoLinea> lineas, JTextArea txtScript) {
		StringBuffer strBuffer = new StringBuffer(StringUtils.EMPTY);

		for (TextoLinea linea : lineas) {
			strBuffer.append(linea.getValor());
			strBuffer.append(MDSQLConstants.CR);
		}
		
		txtScript.append(strBuffer.toString());
	}

	/**
	 * @param file
	 * @param txtScript
	 */
	public static void dumpContentToText(File file, JTextArea txtScript) throws IOException {
		// Detecta el juego de caracteres del archivo y lo guarda para su posterior uso
		Charset charset = MDSQLAppHelper.detectCharsetFromFile(file);
		LogWrapper.debug(log, "Juego de caracteres: %s", charset.toString());

		String content = writeFileToString(file);
		txtScript.append(content);
	}

	/**
	 * @param file
	 * @param txtScript
	 */
	public static void dumpTextToFile(JTextArea txtScript, File file) throws IOException {
		String content = txtScript.getText();

		writeToFile(content, file);
	}
}
