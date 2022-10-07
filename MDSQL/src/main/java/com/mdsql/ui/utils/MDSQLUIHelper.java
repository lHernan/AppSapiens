package com.mdsql.ui.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JTextArea;

import com.mdsql.bussiness.entities.TextoLinea;
import com.mdsql.ui.model.cabeceras.Cabecera;
import com.mdsql.ui.utils.creators.CabeceraTablaCreator;
import com.mdsql.ui.utils.creators.Creator;
import com.mdsql.ui.utils.creators.DialogCreator;
import com.mdsql.ui.utils.creators.FrameCreator;
import com.mdval.exceptions.ServiceException;
import com.mdval.ui.utils.DialogSupport;
import com.mdval.ui.utils.FrameSupport;
import com.mdval.ui.utils.UIHelper;
import com.mdval.utils.Constants;

public class MDSQLUIHelper extends UIHelper {
	
	/**
	 * @param item
	 * @return
	 */
	public static DialogSupport createDialog(FrameSupport frameParent, String item) {
		Creator dialogCreator = new DialogCreator(frameParent, item);
		return (DialogSupport) dialogCreator.factoryMethod(null);
	}
	
	/**
	 * @param frameParent
	 * @param item
	 * @param params
	 * @return
	 */
	public static DialogSupport createDialog(FrameSupport frameParent, String item, Map<String, Object> params) {
		Creator dialogCreator = new DialogCreator(frameParent, item);
		return (DialogSupport) dialogCreator.factoryMethod(params);
	}
	
	/**
	 * @param item
	 * @return
	 */
	public static FrameSupport createFrame(String item, Boolean modal) {
		Creator frameCreator = new FrameCreator(item, modal);
		return (FrameSupport) frameCreator.factoryMethod(null);
	}
	
	/**
	 * @param item
	 * @return
	 */
	public static FrameSupport createFrame(FrameSupport parent, String item, Boolean modal) {
		Creator frameCreator = new FrameCreator(parent, item, modal);
		return (FrameSupport) frameCreator.factoryMethod(null);
	}
	
	/**
	 * @param item
	 * @param params
	 * @return
	 */
	public static FrameSupport createFrame(String item, Boolean modal, Map<String, Object> params) {
		Creator frameCreator = new FrameCreator(item, modal);
		return (FrameSupport) frameCreator.factoryMethod(params);
	}
	
	/**
	 * @param parent
	 * @param item
	 * @param params
	 * @return
	 */
	public static FrameSupport createFrame(FrameSupport parent, String item, Boolean modal, Map<String, Object> params) {
		Creator frameCreator = new FrameCreator(parent, item, modal);
		return (FrameSupport) frameCreator.factoryMethod(params);
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
		DialogSupport dialog = createDialog(frame, cmd, params);
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
	
	/**
	 * @param script
	 * @return
	 */
	public static List<TextoLinea> toTextoLineas(JTextArea txtArea) {
		List<TextoLinea> lineas = new ArrayList<>();
		
		for (String line : txtArea.getText().split("\\n")) {
			TextoLinea linea = new TextoLinea();
			linea.setValor(line);
			
			lineas.add(linea);
		}
		
		return lineas;
	}
}
