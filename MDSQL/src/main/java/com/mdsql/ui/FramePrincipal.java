/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mdsql.ui;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

import com.mdsql.ui.listener.FramePrincipalActionListener;
import com.mdsql.ui.menu.MainMenuBar;
import com.mdsql.utils.Constants;
import com.mdsql.utils.Constants.Procesado;
import com.mdval.ui.utils.FrameSupport;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author federico
 */
public class FramePrincipal extends FrameSupport {

    /**
	 * 
	 */
	private static final long serialVersionUID = 543072851506727342L;
	
	// Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton btnLoadScript;
    private JButton btnInformacionModelo;
    private JButton btnCargarScriptObjetos;
    private JButton btnProcesarScript;
    private JButton btnSave;
	private JButton btnExecute;
	private JButton btnEntregarProcesado;
	private JButton btnLimpiarScripts;
	private JButton btnLimpiarSesion;
	private JButton btnProcesadoEnCurso;
	private JButton btnRefrescarFichero;
    
    private JInternalFrame jInternalFrame10;
    private JInternalFrame jInternalFrame2;
    private JInternalFrame jInternalFrame3;
    private JInternalFrame jInternalFrame4;
    private JInternalFrame jInternalFrame5;
    private JInternalFrame jInternalFrame6;
    private JInternalFrame jInternalFrame7;
    private JInternalFrame jInternalFrame8;
    private JInternalFrame jInternalFrame9;
    private JInternalFrame jInternalFrame11;
    private JInternalFrame jInternalFrame12;
    private JInternalFrame jInternalFrame14;
    private JInternalFrame jInternalFrame13;
    private JPanel jPanel1;
    private JPanel panelVigente;
    private JPanel panelHistorico;
    private JPanel panelTypes;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JToolBar.Separator jSeparator1;
    private JToolBar.Separator jSeparator2;
    private JToolBar.Separator jSeparator4;
    private JSplitPane jSplitPane1;
    private JTable jTable1;
    private JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
	
    @Getter
    private JInternalFrame frmSQLScript;
    
    @Getter
    private JTextArea txtSQLCode;

    @Getter
	private JTabbedPane tabPanel;
    
    @Getter
    @Setter
    private Procesado procesado;
    
    @Getter
    @Setter
    private List<String> lineasScript;
    
	/**
     * Creates new form Principal
     */
    public FramePrincipal() {
        super();
    }

    @Override
	protected void setupComponents() {

    	jToolBar1 = new JToolBar();
        btnLoadScript = new JButton();
        jSeparator1 = new JToolBar.Separator();
        btnCargarScriptObjetos = new JButton();
        jSeparator2 = new JToolBar.Separator();
        btnProcesarScript = new JButton();
        btnSave = new JButton();
        btnExecute = new JButton();
        btnEntregarProcesado = new JButton();
        btnLimpiarScripts = new JButton();
        btnLimpiarSesion = new JButton();
        jSeparator4 = new JToolBar.Separator();
        btnProcesadoEnCurso = new JButton();
        btnRefrescarFichero = new JButton();
        btnInformacionModelo = new JButton();
        jSplitPane1 = new JSplitPane();
        frmSQLScript = new JInternalFrame();
        jScrollPane1 = new JScrollPane();
        txtSQLCode = new JTextArea();
        jPanel1 = new JPanel();
        tabPanel = new JTabbedPane();
        panelVigente = new JPanel();
        jInternalFrame2 = new JInternalFrame();
        jInternalFrame3 = new JInternalFrame();
        jInternalFrame4 = new JInternalFrame();
        jInternalFrame5 = new JInternalFrame();
        panelHistorico = new JPanel();
        jInternalFrame11 = new JInternalFrame();
        jInternalFrame12 = new JInternalFrame();
        jInternalFrame13 = new JInternalFrame();
        jInternalFrame14 = new JInternalFrame();
        panelTypes = new JPanel();
        jInternalFrame6 = new JInternalFrame();
        jScrollPane2 = new JScrollPane();
        jTable1 = new JTable();
        jInternalFrame7 = new JInternalFrame();
        jInternalFrame8 = new JInternalFrame();
        jInternalFrame9 = new JInternalFrame();
        jInternalFrame10 = new JInternalFrame();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jToolBar1.setRollover(true);
        jToolBar1.setMargin(new Insets(3, 3, 3, 3));

        btnLoadScript.setIcon(new ImageIcon(getClass().getResource("/script.png"))); // NOI18N
        btnLoadScript.setToolTipText("Cargar script");
        btnLoadScript.setFocusable(false);
        btnLoadScript.setHorizontalTextPosition(SwingConstants.CENTER);
        btnLoadScript.setMaximumSize(new Dimension(60, 60));
        btnLoadScript.setMinimumSize(new Dimension(60, 60));
        btnLoadScript.setPreferredSize(new Dimension(60, 60));
        btnLoadScript.setVerticalTextPosition(SwingConstants.BOTTOM);
        jToolBar1.add(btnLoadScript);
        jToolBar1.add(jSeparator1);

        btnCargarScriptObjetos.setIcon(new ImageIcon(getClass().getResource("/folder.png"))); // NOI18N
        btnCargarScriptObjetos.setText("TYPE");
        btnCargarScriptObjetos.setToolTipText("Cargar script Objetos");
        btnCargarScriptObjetos.setFocusable(false);
        btnCargarScriptObjetos.setHorizontalTextPosition(SwingConstants.CENTER);
        btnCargarScriptObjetos.setMaximumSize(new Dimension(60, 60));
        btnCargarScriptObjetos.setMinimumSize(new Dimension(60, 60));
        btnCargarScriptObjetos.setPreferredSize(new Dimension(60, 60));
        btnCargarScriptObjetos.setVerticalTextPosition(SwingConstants.BOTTOM);
        jToolBar1.add(btnCargarScriptObjetos);
        jToolBar1.add(jSeparator2);

        btnProcesarScript.setIcon(new ImageIcon(getClass().getResource("/play.png"))); // NOI18N
        btnProcesarScript.setToolTipText("Procesar script");
        btnProcesarScript.setFocusable(false);
        btnProcesarScript.setHorizontalTextPosition(SwingConstants.CENTER);
        btnProcesarScript.setMaximumSize(new Dimension(60, 60));
        btnProcesarScript.setMinimumSize(new Dimension(60, 60));
        btnProcesarScript.setPreferredSize(new Dimension(60, 60));
        btnProcesarScript.setVerticalTextPosition(SwingConstants.BOTTOM);
        jToolBar1.add(btnProcesarScript);

        btnSave.setIcon(new ImageIcon(getClass().getResource("/floppy-disk.png"))); // NOI18N
        btnSave.setToolTipText("Guardar archivo");
        btnSave.setFocusable(false);
        btnSave.setHorizontalTextPosition(SwingConstants.CENTER);
        btnSave.setMaximumSize(new Dimension(60, 60));
        btnSave.setMinimumSize(new Dimension(60, 60));
        btnSave.setPreferredSize(new Dimension(60, 60));
        btnSave.setVerticalTextPosition(SwingConstants.BOTTOM);
        jToolBar1.add(btnSave);

        btnExecute.setIcon(new ImageIcon(getClass().getResource("/checking.png"))); // NOI18N
        btnExecute.setToolTipText("Ejecutar script");
        btnExecute.setFocusable(false);
        btnExecute.setHorizontalTextPosition(SwingConstants.CENTER);
        btnExecute.setMaximumSize(new Dimension(60, 60));
        btnExecute.setMinimumSize(new Dimension(60, 60));
        btnExecute.setPreferredSize(new Dimension(60, 60));
        btnExecute.setVerticalTextPosition(SwingConstants.BOTTOM);
        jToolBar1.add(btnExecute);

        btnEntregarProcesado.setIcon(new ImageIcon(getClass().getResource("/execution.png"))); // NOI18N
        btnEntregarProcesado.setToolTipText("Entregar procesado");
        btnEntregarProcesado.setFocusable(false);
        btnEntregarProcesado.setHorizontalTextPosition(SwingConstants.CENTER);
        btnEntregarProcesado.setMaximumSize(new Dimension(60, 60));
        btnEntregarProcesado.setMinimumSize(new Dimension(60, 60));
        btnEntregarProcesado.setPreferredSize(new Dimension(60, 60));
        btnEntregarProcesado.setVerticalTextPosition(SwingConstants.BOTTOM);
        jToolBar1.add(btnEntregarProcesado);

        btnLimpiarScripts.setIcon(new ImageIcon(getClass().getResource("/clean.png"))); // NOI18N
        btnLimpiarScripts.setToolTipText("Limpar scripts");
        btnLimpiarScripts.setFocusable(false);
        btnLimpiarScripts.setHorizontalTextPosition(SwingConstants.CENTER);
        btnLimpiarScripts.setMaximumSize(new Dimension(60, 60));
        btnLimpiarScripts.setMinimumSize(new Dimension(60, 60));
        btnLimpiarScripts.setPreferredSize(new Dimension(60, 60));
        btnLimpiarScripts.setVerticalTextPosition(SwingConstants.BOTTOM);
        jToolBar1.add(btnLimpiarScripts);

        btnLimpiarSesion.setIcon(new ImageIcon(getClass().getResource("/trash.png"))); // NOI18N
        btnLimpiarSesion.setToolTipText("Limpiar sesión");
        btnLimpiarSesion.setFocusable(false);
        btnLimpiarSesion.setHorizontalTextPosition(SwingConstants.CENTER);
        btnLimpiarSesion.setMaximumSize(new Dimension(60, 60));
        btnLimpiarSesion.setMinimumSize(new Dimension(60, 60));
        btnLimpiarSesion.setPreferredSize(new Dimension(60, 60));
        btnLimpiarSesion.setVerticalTextPosition(SwingConstants.BOTTOM);
        jToolBar1.add(btnLimpiarSesion);
        jToolBar1.add(jSeparator4);

        btnProcesadoEnCurso.setIcon(new ImageIcon(getClass().getResource("/info.png"))); // NOI18N
        btnProcesadoEnCurso.setToolTipText("Procesado en curso");
        btnProcesadoEnCurso.setFocusable(false);
        btnProcesadoEnCurso.setHorizontalTextPosition(SwingConstants.CENTER);
        btnProcesadoEnCurso.setMaximumSize(new Dimension(60, 60));
        btnProcesadoEnCurso.setMinimumSize(new Dimension(60, 60));
        btnProcesadoEnCurso.setPreferredSize(new Dimension(60, 60));
        btnProcesadoEnCurso.setVerticalTextPosition(SwingConstants.BOTTOM);
        jToolBar1.add(btnProcesadoEnCurso);

        btnRefrescarFichero.setIcon(new ImageIcon(getClass().getResource("/file.png"))); // NOI18N
        btnRefrescarFichero.setToolTipText("Refrescar fichero");
        btnRefrescarFichero.setFocusable(false);
        btnRefrescarFichero.setHorizontalTextPosition(SwingConstants.CENTER);
        btnRefrescarFichero.setMaximumSize(new Dimension(60, 60));
        btnRefrescarFichero.setMinimumSize(new Dimension(60, 60));
        btnRefrescarFichero.setPreferredSize(new Dimension(60, 60));
        btnRefrescarFichero.setVerticalTextPosition(SwingConstants.BOTTOM);
        jToolBar1.add(btnRefrescarFichero);

        btnInformacionModelo.setIcon(new ImageIcon(getClass().getResource("/information.png"))); // NOI18N
        btnInformacionModelo.setToolTipText("Información del modelo");
        btnInformacionModelo.setFocusable(false);
        btnInformacionModelo.setHorizontalTextPosition(SwingConstants.CENTER);
        btnInformacionModelo.setMaximumSize(new Dimension(60, 60));
        btnInformacionModelo.setMinimumSize(new Dimension(60, 60));
        btnInformacionModelo.setPreferredSize(new Dimension(60, 60));
        btnInformacionModelo.setVerticalTextPosition(SwingConstants.BOTTOM);
        jToolBar1.add(btnInformacionModelo);

        getContentPane().add(jToolBar1, BorderLayout.PAGE_START);

        frmSQLScript.setVisible(true);

        txtSQLCode.setColumns(20);
        txtSQLCode.setRows(5);
        jScrollPane1.setViewportView(txtSQLCode);

        frmSQLScript.getContentPane().add(jScrollPane1, BorderLayout.CENTER);

        jSplitPane1.setLeftComponent(frmSQLScript);

        jPanel1.setLayout(new BoxLayout(jPanel1, BoxLayout.LINE_AXIS));

        panelVigente.setLayout(new GridLayout(2, 2));

        jInternalFrame2.setVisible(true);

        GroupLayout jInternalFrame2Layout = new GroupLayout(jInternalFrame2.getContentPane());
        jInternalFrame2.getContentPane().setLayout(jInternalFrame2Layout);
        jInternalFrame2Layout.setHorizontalGroup(
            jInternalFrame2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 522, Short.MAX_VALUE)
        );
        jInternalFrame2Layout.setVerticalGroup(
            jInternalFrame2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 266, Short.MAX_VALUE)
        );

        panelVigente.add(jInternalFrame2);

        jInternalFrame3.setVisible(true);

        GroupLayout jInternalFrame3Layout = new GroupLayout(jInternalFrame3.getContentPane());
        jInternalFrame3.getContentPane().setLayout(jInternalFrame3Layout);
        jInternalFrame3Layout.setHorizontalGroup(
            jInternalFrame3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 522, Short.MAX_VALUE)
        );
        jInternalFrame3Layout.setVerticalGroup(
            jInternalFrame3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 266, Short.MAX_VALUE)
        );

        panelVigente.add(jInternalFrame3);

        jInternalFrame4.setVisible(true);

        GroupLayout jInternalFrame4Layout = new GroupLayout(jInternalFrame4.getContentPane());
        jInternalFrame4.getContentPane().setLayout(jInternalFrame4Layout);
        jInternalFrame4Layout.setHorizontalGroup(
            jInternalFrame4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 522, Short.MAX_VALUE)
        );
        jInternalFrame4Layout.setVerticalGroup(
            jInternalFrame4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 266, Short.MAX_VALUE)
        );

        panelVigente.add(jInternalFrame4);

        jInternalFrame5.setVisible(true);

        GroupLayout jInternalFrame5Layout = new GroupLayout(jInternalFrame5.getContentPane());
        jInternalFrame5.getContentPane().setLayout(jInternalFrame5Layout);
        jInternalFrame5Layout.setHorizontalGroup(
            jInternalFrame5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 522, Short.MAX_VALUE)
        );
        jInternalFrame5Layout.setVerticalGroup(
            jInternalFrame5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 266, Short.MAX_VALUE)
        );

        panelVigente.add(jInternalFrame5);

        tabPanel.addTab("Vigente", panelVigente);

        panelHistorico.setLayout(new GridLayout(2, 2));

        jInternalFrame11.setVisible(true);

        GroupLayout jInternalFrame11Layout = new GroupLayout(jInternalFrame11.getContentPane());
        jInternalFrame11.getContentPane().setLayout(jInternalFrame11Layout);
        jInternalFrame11Layout.setHorizontalGroup(
            jInternalFrame11Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame11Layout.setVerticalGroup(
            jInternalFrame11Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        panelHistorico.add(jInternalFrame11);

        jInternalFrame12.setVisible(true);

        GroupLayout jInternalFrame12Layout = new GroupLayout(jInternalFrame12.getContentPane());
        jInternalFrame12.getContentPane().setLayout(jInternalFrame12Layout);
        jInternalFrame12Layout.setHorizontalGroup(
            jInternalFrame12Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame12Layout.setVerticalGroup(
            jInternalFrame12Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        panelHistorico.add(jInternalFrame12);

        jInternalFrame13.setVisible(true);

        GroupLayout jInternalFrame13Layout = new GroupLayout(jInternalFrame13.getContentPane());
        jInternalFrame13.getContentPane().setLayout(jInternalFrame13Layout);
        jInternalFrame13Layout.setHorizontalGroup(
            jInternalFrame13Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame13Layout.setVerticalGroup(
            jInternalFrame13Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        panelHistorico.add(jInternalFrame13);

        jInternalFrame14.setVisible(true);

        GroupLayout jInternalFrame14Layout = new GroupLayout(jInternalFrame14.getContentPane());
        jInternalFrame14.getContentPane().setLayout(jInternalFrame14Layout);
        jInternalFrame14Layout.setHorizontalGroup(
            jInternalFrame14Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame14Layout.setVerticalGroup(
            jInternalFrame14Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        panelHistorico.add(jInternalFrame14);

        tabPanel.addTab("Histórico", panelHistorico);

        panelTypes.setLayout(new GridLayout(3, 2));

        jInternalFrame6.setVisible(true);

        jScrollPane2.setViewportView(jTable1);

        jInternalFrame6.getContentPane().add(jScrollPane2, BorderLayout.CENTER);

        panelTypes.add(jInternalFrame6);

        jInternalFrame7.setVisible(true);

        GroupLayout jInternalFrame7Layout = new GroupLayout(jInternalFrame7.getContentPane());
        jInternalFrame7.getContentPane().setLayout(jInternalFrame7Layout);
        jInternalFrame7Layout.setHorizontalGroup(
            jInternalFrame7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame7Layout.setVerticalGroup(
            jInternalFrame7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        panelTypes.add(jInternalFrame7);

        jInternalFrame8.setVisible(true);

        GroupLayout jInternalFrame8Layout = new GroupLayout(jInternalFrame8.getContentPane());
        jInternalFrame8.getContentPane().setLayout(jInternalFrame8Layout);
        jInternalFrame8Layout.setHorizontalGroup(
            jInternalFrame8Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame8Layout.setVerticalGroup(
            jInternalFrame8Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        panelTypes.add(jInternalFrame8);

        jInternalFrame9.setVisible(true);

        GroupLayout jInternalFrame9Layout = new GroupLayout(jInternalFrame9.getContentPane());
        jInternalFrame9.getContentPane().setLayout(jInternalFrame9Layout);
        jInternalFrame9Layout.setHorizontalGroup(
            jInternalFrame9Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame9Layout.setVerticalGroup(
            jInternalFrame9Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        panelTypes.add(jInternalFrame9);

        jInternalFrame10.setVisible(true);

        GroupLayout jInternalFrame10Layout = new GroupLayout(jInternalFrame10.getContentPane());
        jInternalFrame10.getContentPane().setLayout(jInternalFrame10Layout);
        jInternalFrame10Layout.setHorizontalGroup(
            jInternalFrame10Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame10Layout.setVerticalGroup(
            jInternalFrame10Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        panelTypes.add(jInternalFrame10);

        tabPanel.addTab("Types", panelTypes);

        jPanel1.add(tabPanel);

        jSplitPane1.setRightComponent(jPanel1);

        getContentPane().add(jSplitPane1, BorderLayout.CENTER);
        
    }
    
    @Override
    protected void initMenuBar() {
        menuBar = new MainMenuBar();   
    }

	@Override
	protected void initEvents() {
		ActionListener actionListener = new FramePrincipalActionListener(this);
		
		btnLoadScript.setActionCommand(Constants.FRAME_PRINCIPAL_LOAD_SCRIPT);
		btnCargarScriptObjetos.setActionCommand(Constants.FRAME_PRINCIPAL_CARGAR_SCRIPT_OBJETOS);
		btnProcesarScript.setActionCommand(Constants.FRAME_PRINCIPAL_PROCESAR_SCRIPT);
		btnSave.setActionCommand(Constants.FRAME_PRINCIPAL_SAVE);
		btnExecute.setActionCommand(Constants.FRAME_PRINCIPAL_EXECUTE);
		btnEntregarProcesado.setActionCommand(Constants.FRAME_PRINCIPAL_ENTREGAR_PROCESADO);
		
		btnLoadScript.addActionListener(actionListener);
		btnCargarScriptObjetos.addActionListener(actionListener);
		btnProcesarScript.addActionListener(actionListener);
		btnSave.addActionListener(actionListener);
		btnExecute.addActionListener(actionListener);
		btnEntregarProcesado.addActionListener(actionListener);
	}

	@Override
	protected void initModels() {
		jTable1.setModel(new DefaultTableModel(
	            new Object [][] {
	                {null, null},
	                {null, null},
	                {null, null},
	                {null, null},
	                {null, null},
	                {null, null},
	                {null, null},
	                {null, null},
	                {null, null},
	                {null, null}
	            },
	            new String [] {
	                "Orden", "Objeto"
	            }
	        ) {
	            Class[] types = new Class [] {
	                java.lang.Integer.class, java.lang.String.class
	            };

	            public Class getColumnClass(int columnIndex) {
	                return types [columnIndex];
	            }
	        });
	}

	@Override
	protected void initialState() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void setupLiterals() {
		setTitle("MDSQL");
		
	}
}
