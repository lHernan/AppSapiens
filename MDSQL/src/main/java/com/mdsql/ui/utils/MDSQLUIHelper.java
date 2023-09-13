package com.mdsql.ui.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.swing.JFileChooser;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.apache.commons.collections.CollectionUtils;

import com.mdsql.bussiness.entities.Script;
import com.mdsql.bussiness.entities.TextoLinea;
import com.mdsql.ui.model.ScriptsTableModel;
import com.mdsql.ui.utils.creators.CabeceraTablaCreator;
import com.mdsql.ui.utils.creators.Creator;
import com.mdsql.ui.utils.creators.DialogCreator;
import com.mdsql.ui.utils.creators.FrameCreator;
import com.mdsql.utils.LiteralesSingleton;
import com.mdsql.utils.MDSQLConstants;
import com.mdval.exceptions.ServiceException;
import com.mdval.ui.model.cabeceras.Cabecera;
import com.mdval.ui.utils.DialogSupport;
import com.mdval.ui.utils.FrameSupport;
import com.mdval.ui.utils.UIHelper;
import com.mdval.utils.Constants;
import com.mdval.utils.LogWrapper;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
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
			ServiceException serviceException = (ServiceException) e;
			if (!Objects.isNull(serviceException.getType()) && serviceException.getType().equals(2)) {
				params.put(MDSQLConstants.TYPE, MDSQLConstants.CMD_WARN);
				params.put(Constants.SERVICE_ERROR, e);
			}
			else {
				params.put(MDSQLConstants.TYPE, MDSQLConstants.CMD_ERROR);
				params.put(Constants.SERVICE_ERROR, e);
			}
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
	
	@SneakyThrows
	public static List<TextoLinea> toTextoLineas(File file, Charset inCharset) {
		List<TextoLinea> lineas = new ArrayList<>();
		
		try (InputStreamReader in = new InputStreamReader(new FileInputStream(file), inCharset);
				BufferedReader br = new BufferedReader(in)) {
			String line;
			while ((line = br.readLine()) != null) {
				TextoLinea linea = new TextoLinea();
				linea.setValor(line);
				
				lineas.add(linea);
			}
			
			return lineas;
		} catch (IOException e) {
			throw e;
		}
	}
	
	/**
	 * @param model
	 * @return
	 */
	public static Boolean isAnySelected(ScriptsTableModel model) {
		for (int i = 0; i < model.getRowCount(); i++) {
			Script scr = model.getSelectedRow(i);
			if (scr.getSelected()) {
				return Boolean.TRUE;
			}
		}
		
		return Boolean.FALSE;
	}
	
	/**
	 * @return
	 */
	public static JFileChooser getJFileChooser(String rutaInicial) throws IOException {
		LiteralesSingleton literales = LiteralesSingleton.getInstance();
		
		JFileChooser chooser = new JFileChooser();
		chooser.setDialogTitle(literales.getLiteral("panelPrincipal.tituloChooser"));
		chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		chooser.setCurrentDirectory(new File(rutaInicial));
		chooser.setAcceptAllFileFilterUsed(false);
		
		return chooser;
	}
	
	/**
	 * @param rutaInicial
	 * @param textField
	 * @param file
	 * @param frameParent
	 */
	public static File abrirScript(String rutaInicial, JTextField textField, FrameSupport frameParent) {
		try {
			JFileChooser chooser = MDSQLUIHelper.getJFileChooser(rutaInicial);
			if (chooser.showOpenDialog(frameParent) == JFileChooser.APPROVE_OPTION) {
				File file = chooser.getSelectedFile();
				String rutaArchivo = file.getAbsolutePath();
				LogWrapper.debug(log, "Archivo seleccionado: %s", rutaArchivo);
				textField.setText(rutaArchivo);
				
				return file;
			}
			
			return null;
		} catch (IOException e) {
			Map<String, Object> params = buildError(e);
			showPopup(frameParent, Constants.CMD_ERROR, params);
			return null;
		}	
	}

	/**
	 * @param warnings
	 * @return
	 */
	public static Map<String, Object> buildWarnings(List<Object[]> warnings) {
		Map<String, Object> params = new HashMap<>();

		params.put(Constants.WARN, warnings);
		params.put(MDSQLConstants.TYPE, MDSQLConstants.CMD_WARN);
		
		return params;
	}
	
	/**
	 * @param warnings
	 * @param frameSupport
	 */
	public static void showWarningsIfExists(List<Object[]> warnings, FrameSupport frameSupport) {
		if (CollectionUtils.isNotEmpty(warnings)) {
			Map<String, Object> params = MDSQLUIHelper.buildWarnings(warnings);
			MDSQLUIHelper.showPopup(frameSupport, MDSQLConstants.CMD_WARN, params);
		}
	}
	
	/**
	 * @param field
	 * @param value
	 * @param limit
	 */
	public static void resetText(JTextField field, String value) {
		field.setHorizontalAlignment(JTextField.LEFT);
		
//		if (value.length() > limit) {
//			String textToShow = value.substring(0, limit).concat("...");
//			field.setText(textToShow);
//			field.setToolTipText(value);
//		}
//		else {
			field.setText(value);
			field.setCaretPosition(0);
//		}
	}
}
