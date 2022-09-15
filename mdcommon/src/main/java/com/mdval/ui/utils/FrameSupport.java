package com.mdval.ui.utils;


import java.awt.Dimension;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.swing.JFrame;
import javax.swing.JMenuBar;

import org.apache.commons.collections.CollectionUtils;

import com.mdval.ui.PanelLogotipo;
import com.mdval.utils.LiteralesSingleton;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * @author federico
 *
 */
@Slf4j
public abstract class FrameSupport extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -637526827846474731L;
	
	@Getter
	protected PanelLogotipo panelLogo;
	
	protected JMenuBar menuBar;
	
	@Getter
	protected Map<String, Object> params;
	
	protected LiteralesSingleton literales;
	
	private List<OnLoadListener> onLoadListeners;
	
	@Getter
	private FrameSupport frameParent;

	/**
	 * 
	 */
	public FrameSupport() {
		initialize();
	}
	
	/**
	 * 
	 */
	public FrameSupport(FrameSupport parent) {
		this.frameParent = parent;
		initialize();
	}
	
	/**
	 * 
	 */
	public FrameSupport(FrameSupport parent, Map<String, Object> params) {
		this.frameParent = parent;
		this.params = params;
		initialize();
	}
	
	/**
	 * 
	 */
	public FrameSupport(Map<String, Object> params) {
		this.params = params;
		initialize();
	}
	
	/**
     * Proceso de inicialización
     */
    private void initialize() {
		try {
			onLoadListeners = new ArrayList<>();
			
			panelLogo = new PanelLogotipo("logotipo.png");
			panelLogo.setPreferredSize(new Dimension(286, 63));
			
			initComponents();
			initMenuBar();
			
			if (!Objects.isNull(menuBar)) {
				this.setJMenuBar(menuBar);
			}
			
			initLiterals();
			initEvents();
			
			initModels();
			
			if (CollectionUtils.isNotEmpty(onLoadListeners)) {
				for (OnLoadListener l : onLoadListeners) {
					l.onLoad();
				}
			}
			
			initialState();
		} catch (IOException e) {
			log.warn("ERROR:", e);
		}
	}
	
	/**
	 * Encapsula la creación de componentes
	 */
	private void initComponents() {
		setupComponents();
		
		pack();
	}
	
	/**
	 * Añade al cuadro un listener de carga inicial
	 * 
	 * @param l
	 */
	protected void addOnLoadListener(OnLoadListener l) {
    	this.onLoadListeners.add(l);
    }
	
	/**
	 * Instala los componentes internos de este frame
	 */
	protected abstract void setupComponents();
	
	/**
	 * Instala la barra de menú. Se puyede implementar vacío
	 */
	protected abstract void initMenuBar();
	
	/**
	 * Instala los eventos a los componentes que los necesiten
	 */
	protected abstract void initEvents();
	
	/**
	 * Inicia los modelos de combos, tablas, etc
	 */
	protected abstract void initModels();
	
	/**
	 * Estado inicial: los valores iniciales de los componentes que lo requieran
	 */
	protected abstract void initialState();
	
	/**
	 * Literales de los componentes
	 */
	protected abstract void setupLiterals();
	
	/**
	 * Encapsula la creación de los literales
	 * @throws IOException
	 */
	private void initLiterals() throws IOException {
		literales = LiteralesSingleton.getInstance();
		
		setupLiterals();
	}
}
