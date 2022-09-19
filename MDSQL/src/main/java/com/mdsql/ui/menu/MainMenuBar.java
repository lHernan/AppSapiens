/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mdsql.ui.menu;

import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import com.mdsql.ui.listener.MenuListener;
import com.mdsql.ui.utils.MenuSupport;
import com.mdsql.utils.Constants;

/**
 *
 * @author federico
 */
public class MainMenuBar extends MenuSupport {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = -519829056044806094L;

    private JMenu mnuPermisos;
    private JMenu mnuVariables;
    private JMenu mnuEntornos;
    private JMenu mnuNotasModelos;
    private JMenu mnuConsultaHistoricoCambios;
    private JMenu mnuScriptInicial;
    private JMenu mnuMantenimientoHistorico;
    
    private JMenuItem mnuPermisosGenerales;
    private JMenu mnuPermisosPersonalizados;
    private JMenuItem mnuConsultaPermisos;
	private JMenuItem mnuMantenimientoPermisos;
	private JMenuItem mnuGenerarPermisos;
    
    private JMenuItem mnuMantenimientoEntornosPruebas;
    private JMenuItem mnuEjecucionScriptInicial;
    private JMenuItem mnuConfiguracionEntornosPrueba;
    
    public MainMenuBar() {
        super();
    }

	/**
	 *
	 */
	protected void initComponents() {
        mnuPermisos = new JMenu();
        
        mnuPermisosGenerales = new JMenuItem();
        mnuPermisosGenerales.setActionCommand(Constants.MNU_PERMISOS_GENERALES); // NOI18N
        mnuPermisos.add(mnuPermisosGenerales);
      
        mnuPermisosPersonalizados = new JMenu();
        mnuConsultaPermisos = new JMenuItem();
        mnuConsultaPermisos.setActionCommand(Constants.MNU_CONSULTA_PERMISOS); // NOI18N
        mnuPermisosPersonalizados.add(mnuConsultaPermisos);
        
        mnuMantenimientoPermisos = new JMenuItem();
        mnuMantenimientoPermisos.setActionCommand(Constants.MNU_MANTENIMIENTO_PERMISOS); // NOI18N
        mnuPermisosPersonalizados.add(mnuMantenimientoPermisos);
        
        mnuGenerarPermisos = new JMenuItem();
        mnuGenerarPermisos.setActionCommand(Constants.MNU_GENERAR_PERMISOS); // NOI18N
        mnuPermisosPersonalizados.add(mnuGenerarPermisos);
        
        mnuPermisos.add(mnuPermisosPersonalizados);
        
        mnuEntornos = new JMenu();
        mnuEntornos.setActionCommand(Constants.MNU_ENTORNOS); // NOI18N
        
        mnuVariables = new JMenu();
        mnuVariables.setActionCommand(Constants.MNU_VARIABLES); // NOI18N
        
        mnuNotasModelos = new JMenu();
        mnuNotasModelos.setActionCommand(Constants.MNU_NOTAS_MODELOS); // NOI18N
        
        mnuConsultaHistoricoCambios = new JMenu();
        mnuConsultaHistoricoCambios.setActionCommand(Constants.MNU_CONSULTA_HISTORICO_CAMBIOS); // NOI18N
        
        mnuScriptInicial = new JMenu();
        mnuMantenimientoEntornosPruebas = new JMenuItem();
        mnuMantenimientoEntornosPruebas.setActionCommand(Constants.MNU_MANTENIMIENTO_ENTORNOS_PRUEBAS); // NOI18N
        mnuScriptInicial.add(mnuMantenimientoEntornosPruebas);
        
        mnuEjecucionScriptInicial = new JMenuItem();
        mnuEjecucionScriptInicial.setActionCommand(Constants.MNU_EJECUCION_SCRIPT_INICIAL); // NOI18N
        mnuScriptInicial.add(mnuEjecucionScriptInicial);
        
        mnuConfiguracionEntornosPrueba = new JMenuItem();
        mnuConfiguracionEntornosPrueba.setActionCommand(Constants.MNU_CONFIGURACION_ENTORNOS_PRUEBA); // NOI18N
        mnuScriptInicial.add(mnuConfiguracionEntornosPrueba);
        
        mnuMantenimientoHistorico = new JMenu();
        mnuMantenimientoHistorico.setActionCommand(Constants.MNU_MANTENIMIENTO_HISTORICO); // NOI18N

        add(mnuPermisos);
        add(mnuEntornos);
        add(mnuVariables);
        add(mnuNotasModelos);
        add(mnuConsultaHistoricoCambios);
        add(mnuScriptInicial);
        add(mnuMantenimientoHistorico);
    }
	
	/**
	 *
	 */
	protected void setupLiterals() {
		mnuPermisos.setText(literales.getLiteral("menu.permisos"));
		mnuPermisosGenerales.setText(literales.getLiteral("menu.permisos.generales"));
		mnuPermisosPersonalizados.setText(literales.getLiteral("menu.permisos.personalizados"));
		mnuConsultaPermisos.setText(literales.getLiteral("menu.permisos.personalizados.consulta"));
		mnuMantenimientoPermisos.setText(literales.getLiteral("menu.permisos.personalizados.mantenimiento"));
		mnuGenerarPermisos.setText(literales.getLiteral("menu.permisos.personalizados.generar"));
        mnuEntornos.setText(literales.getLiteral("menu.entornos"));
        mnuVariables.setText(literales.getLiteral("menu.variables"));
        mnuNotasModelos.setText(literales.getLiteral("menu.notasModelos"));
        mnuConsultaHistoricoCambios.setText(literales.getLiteral("menu.consultaHistorico"));
        mnuScriptInicial.setText(literales.getLiteral("menu.scriptInicial"));
        mnuMantenimientoEntornosPruebas.setText(literales.getLiteral("menu.scriptInicial.mantenimientoEntornos"));
        mnuEjecucionScriptInicial.setText(literales.getLiteral("menu.scriptInicial.ejecucionScript"));
        mnuConfiguracionEntornosPrueba.setText(literales.getLiteral("menu.scriptInicial.configuracionEntornos"));
        mnuMantenimientoHistorico.setText(literales.getLiteral("menu.mantenimientoHistorico"));
	}
	
	/**
	 *
	 */
	protected void initEvents() {
		ActionListener actionListener = new MenuListener();
		
		mnuPermisosGenerales.addActionListener(actionListener);
		
		mnuConsultaPermisos.addActionListener(actionListener);
		mnuMantenimientoPermisos.addActionListener(actionListener);
		mnuGenerarPermisos.addActionListener(actionListener);
        
		mnuEntornos.addActionListener(actionListener);
        mnuVariables.addActionListener(actionListener);
        mnuNotasModelos.addActionListener(actionListener);
        mnuConsultaHistoricoCambios.addActionListener(actionListener);
        
        mnuMantenimientoEntornosPruebas.addActionListener(actionListener);
        mnuEjecucionScriptInicial.addActionListener(actionListener);
        mnuConfiguracionEntornosPrueba.addActionListener(actionListener);
        
        mnuMantenimientoHistorico.addActionListener(actionListener);
	}
}
