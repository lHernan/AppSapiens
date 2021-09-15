package com.mdval.ui.utils;

import java.util.List;

import javax.swing.JTable;

import org.apache.commons.collections.CollectionUtils;

import com.mdval.ui.model.cabeceras.Cabecera;

/**
 * @author federico
 *
 */
public class TableSupport extends JTable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2528825112240587759L;
	
	public TableSupport() {
		super();
	}

	/**
	 * @param isAutoresized
	 */
	public TableSupport(Boolean isAutoresized) {
		super();
		
		if (!isAutoresized) {
			setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		}
	}
	
	/**
	 * @param cabecera
	 */
	public void setColumnWidths(Cabecera cabecera) {
		List<Integer> widths = cabecera.getColumnSizes();
		
		if (CollectionUtils.isNotEmpty(widths)) {
	        for (int i = 0; i < widths.size(); i++) {
	            if (i < columnModel.getColumnCount()) {
	                columnModel.getColumn(i).setPreferredWidth(widths.get(i));
	            }
	            else break;
	        }
		}
    }
}
