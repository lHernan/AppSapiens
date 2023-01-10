package com.mdsql.utils;

import java.io.IOException;
import java.io.InputStream;
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
	 * @param is
	 * @return
	 * @throws IOException
	 */
	public static Charset detectCharset(InputStream is) throws IOException{
		return Charset.forName(new TikaEncodingDetector().guessEncoding(is));
	}
}
