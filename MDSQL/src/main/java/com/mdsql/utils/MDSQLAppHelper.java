package com.mdsql.utils;

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
}
