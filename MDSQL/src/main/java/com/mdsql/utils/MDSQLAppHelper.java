package com.mdsql.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;

import org.apache.any23.encoding.TikaEncodingDetector;

import com.mdval.utils.AppGlobalSingleton;
import com.mdval.utils.AppHelper;

/**
 * @author federico
 *
 */
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
		Charset charset = null;
		try (InputStream is = new FileInputStream(file)) {
			charset = Charset.forName(new TikaEncodingDetector().guessEncoding(is));
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
	public static void writeToFile(String content, File file, Charset inCharset, Charset outCharset) throws IOException {
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
}
