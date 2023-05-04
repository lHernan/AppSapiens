package com.mdsql.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.List;

import javax.swing.JTextArea;

import org.apache.any23.encoding.TikaEncodingDetector;

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
	 * @param inCharset
	 * @param outCharset
	 * @throws IOException
	 */
	public static void writeToFile(String content, File file, Charset inCharset, Charset outCharset)
			throws IOException {
		try (InputStreamReader in = new InputStreamReader(new ByteArrayInputStream(content.getBytes()), inCharset);
				OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(file), outCharset)) {
			int c = in.read();

			while (c != -1) {
				out.write(c);
				c = in.read();
			}
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
//		try (InputStreamReader in = new InputStreamReader(new ByteArrayInputStream(content.getBytes()));
//				OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(file))) {
//			int c = in.read();
//
//			while (c != -1) {
//				out.write(c);
//				c = in.read();
//			}
//		} catch (IOException e) {
//			throw e;
//		}
		StringBuffer strBuffer = new StringBuffer(content);
		try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "Cp1252"))) {
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
		StringBuffer strBuffer = new StringBuffer("");

		try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "Cp1252"))) {
			// reader = new BufferedReader(new FileReader(csvFile));
			String line = "";

			while ((line = reader.readLine()) != null) {
				strBuffer.append(line + ";" + "\r\n");

			}
			
			return strBuffer.toString();
		}
	}

	/**
	 * @param file
	 * @param inCharset
	 * @param outCharset
	 * @return
	 * @throws IOException
	 */
	public static String writeFileToString(File file, Charset inCharset, Charset outCharset) throws IOException {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		
		try (InputStreamReader in = new InputStreamReader(new FileInputStream(file), inCharset);
				OutputStreamWriter out = new OutputStreamWriter(bos, outCharset)) {
			int c = in.read();

			while (c != -1) {
				out.write(c);
				c = in.read();
			}
		} catch (IOException e) {
			throw e;
		}
		
		byte[] bytes = bos.toByteArray();
		return new String(bytes);
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
		StringBuffer strBuffer = new StringBuffer("");

		for (TextoLinea linea : lineas) {
			strBuffer.append(linea.getValor());
			strBuffer.append("\r\n");
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

//		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
//			String line = reader.readLine();
//
//			while (line != null) {
//				txtScript.append(line);
//				txtScript.append("\n");
//				line = reader.readLine();
//			}
//		}
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
