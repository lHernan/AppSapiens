package com.mdsql.ui.utils;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JDialog;
import javax.swing.JFrame;

import com.mdsql.ui.model.cabeceras.Cabecera;
import com.mdsql.ui.utils.creators.CabeceraTablaCreator;
import com.mdsql.ui.utils.creators.Creator;
import com.mdsql.ui.utils.creators.DialogCreator;
import com.mdsql.ui.utils.creators.FrameCreator;
import com.mdval.exceptions.ServiceException;
import com.mdval.ui.utils.FrameSupport;
import com.mdval.ui.utils.UIHelper;
import com.mdval.utils.Constants;

public class MDSQLUIHelper extends UIHelper {
	
	/**
	 * @param item
	 * @return
	 */
	public static JDialog createDialog(FrameSupport frameParent, String item) {
		Creator dialogCreator = new DialogCreator(frameParent, item);
		return (JDialog) dialogCreator.factoryMethod(null);
	}
	
	/**
	 * @param frameParent
	 * @param item
	 * @param params
	 * @return
	 */
	public static JDialog createDialog(FrameSupport frameParent, String item, Map<String, Object> params) {
		Creator dialogCreator = new DialogCreator(frameParent, item);
		return (JDialog) dialogCreator.factoryMethod(params);
	}
	
	/**
	 * @param item
	 * @return
	 */
	public static JFrame createFrame(String item) {
		Creator frameCreator = new FrameCreator(item);
		return (JFrame) frameCreator.factoryMethod(null);
	}
	
	/**
	 * @param item
	 * @return
	 */
	public static JFrame createFrame(FrameSupport parent, String item) {
		Creator frameCreator = new FrameCreator(parent, item);
		return (JFrame) frameCreator.factoryMethod(null);
	}
	
	/**
	 * @param item
	 * @param params
	 * @return
	 */
	public static JFrame createFrame(String item, Map<String, Object> params) {
		Creator frameCreator = new FrameCreator(item);
		return (JFrame) frameCreator.factoryMethod(params);
	}
	
	/**
	 * @param parent
	 * @param item
	 * @param params
	 * @return
	 */
	public static JFrame createFrame(FrameSupport parent, String item, Map<String, Object> params) {
		Creator frameCreator = new FrameCreator(parent, item);
		return (JFrame) frameCreator.factoryMethod(params);
	}
	
	/**
	 * @param item
	 * @return
	 */
	public static Cabecera createCabeceraTabla(String item) {
		Creator cabeceraTablaCreator = new CabeceraTablaCreator(item);
		return (Cabecera) cabeceraTablaCreator.factoryMethod();
	}
	
	/**
	 * @param frame
	 * @param cmd
	 * @param params
	 */
	public static void showPopup(FrameSupport frame, String cmd, Map<String, Object> params) {
		JDialog dialog = createDialog(frame, cmd, params);
		UIHelper.show(dialog);
	}
	
	/**
	 * @param e
	 * @return
	 */
	public static Map<String, Object> buildError(Exception e) {
		Map<String, Object> params = new HashMap<>();

		if (e instanceof ServiceException) {
			params.put(Constants.SERVICE_ERROR, e);
		} else {
			params.put(Constants.ERROR, e);
		}
		return params;
	}
}
