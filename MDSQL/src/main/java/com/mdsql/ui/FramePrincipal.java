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
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowListener;
import java.io.File;

import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.JToolBar.Separator;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.undo.UndoManager;

import org.apache.commons.lang3.StringUtils;

import com.mdsql.ui.listener.EditorEventHandler;
import com.mdsql.ui.listener.FramePrincipalActionListener;
import com.mdsql.ui.listener.FramePrincipalWindowListener;
import com.mdsql.ui.menu.MainMenuBar;
import com.mdsql.ui.model.FramePrincipalTypesTableModel;
import com.mdsql.ui.utils.MDSQLUIHelper;
import com.mdsql.utils.Constants;
import com.mdsql.utils.Constants.Procesado;
import com.mdval.ui.model.cabeceras.Cabecera;
import com.mdval.ui.utils.FrameSupport;
import com.mdval.ui.utils.TableSupport;

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
	private JInternalFrame jInternalFrame6;
	private JInternalFrame jInternalFrame7;
	private JInternalFrame jInternalFrame8;
	private JInternalFrame jInternalFrame9;
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
	private Boolean hasChanged = Boolean.FALSE; // el estado del documento actual, no modificado por defecto

	@Getter
	private UndoManager undoManager; // instancia de UndoManager (administrador de edición)

	@Getter
	private EditorEventHandler editorEventHandler;

	@Getter
	@Setter
	private File currentFile;

	private JToolBar jToolBar2;

	private JButton btnUndo;

	private JButton btnRedo;

	private Separator jSeparator3;

	private JButton btnCopy;

	private JButton btnCut;

	private JButton btnPaste;

	@Getter
	private JInternalFrame ifrmSQLModificado;

	private JScrollPane jScrollPane3;

	@Getter
	private JTextArea txtSQLModificado;

	@Getter
	private JInternalFrame ifrmPDC;

	private JScrollPane jScrollPane4;

	@Getter
	private JTextArea txtPDC;

	@Getter
	private JInternalFrame ifrmLanzaSQLModificado;

	private JScrollPane jScrollPane5;

	@Getter
	private JTextArea txtLanzaSQLModificado;

	@Getter
	private JInternalFrame ifrmLanzaPDC;

	private JScrollPane jScrollPane6;

	@Getter
	private JTextArea txtLanzaPDC;

	@Getter
	private JInternalFrame ifrmSQLH;

	private JScrollPane jScrollPane7;

	@Getter
	private JTextArea txtSQLH;

	@Getter
	private JInternalFrame ifrmPDCH;

	private JScrollPane jScrollPane8;

	@Getter
	private JTextArea txtPDCH;

	@Getter
	private JInternalFrame ifrmLanzaSQLH;

	private JScrollPane jScrollPane9;

	@Getter
	private JTextArea txtLanzaSQLH;

	@Getter
	private JInternalFrame ifrmLanzaPDCH;

	private JScrollPane jScrollPane10;

	@Getter
	private JTextArea txtLanzaPDCH;
	
	@Getter
	private TableSupport jTable1;

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
        jToolBar2 = new JToolBar();
        btnUndo = new JButton();
        btnRedo = new JButton();
        jSeparator3 = new JToolBar.Separator();
        btnCopy = new JButton();
        btnCut = new JButton();
        btnPaste = new JButton();
        jPanel1 = new JPanel();
        tabPanel = new JTabbedPane();
        panelVigente = new JPanel();
        ifrmSQLModificado = new JInternalFrame();
        jScrollPane3 = new JScrollPane();
        txtSQLModificado = new JTextArea();
        ifrmPDC = new JInternalFrame();
        jScrollPane4 = new JScrollPane();
        txtPDC = new JTextArea();
        ifrmLanzaSQLModificado = new JInternalFrame();
        jScrollPane5 = new JScrollPane();
        txtLanzaSQLModificado = new JTextArea();
        ifrmLanzaPDC = new JInternalFrame();
        jScrollPane6 = new JScrollPane();
        txtLanzaPDC = new JTextArea();
        panelHistorico = new JPanel();
        ifrmSQLH = new JInternalFrame();
        jScrollPane7 = new JScrollPane();
        txtSQLH = new JTextArea();
        ifrmPDCH = new JInternalFrame();
        jScrollPane8 = new JScrollPane();
        txtPDCH = new JTextArea();
        ifrmLanzaSQLH = new JInternalFrame();
        jScrollPane9 = new JScrollPane();
        txtLanzaSQLH = new JTextArea();
        ifrmLanzaPDCH = new JInternalFrame();
        jScrollPane10 = new JScrollPane();
        txtLanzaPDCH = new JTextArea();
        panelTypes = new JPanel();
        jInternalFrame6 = new JInternalFrame();
        jScrollPane2 = new JScrollPane();
        jTable1 = new TableSupport();
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
        btnLimpiarScripts.setToolTipText("Limpiar scripts");
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

        jToolBar2.setFloatable(false);
        jToolBar2.setRollover(true);

        btnUndo.setIcon(new ImageIcon(getClass().getResource("/undo.png"))); // NOI18N
        btnUndo.setToolTipText("Deshacer");
        btnUndo.setFocusable(false);
        btnUndo.setHorizontalTextPosition(SwingConstants.CENTER);
        btnUndo.setVerticalTextPosition(SwingConstants.BOTTOM);
        jToolBar2.add(btnUndo);

        btnRedo.setIcon(new ImageIcon(getClass().getResource("/redo.png"))); // NOI18N
        btnRedo.setToolTipText("Rehacer");
        btnRedo.setFocusable(false);
        btnRedo.setHorizontalTextPosition(SwingConstants.CENTER);
        btnRedo.setVerticalTextPosition(SwingConstants.BOTTOM);
        jToolBar2.add(btnRedo);
        jToolBar2.add(jSeparator3);

        btnCopy.setIcon(new ImageIcon(getClass().getResource("/copy.png"))); // NOI18N
        btnCopy.setToolTipText("Copiar");
        btnCopy.setFocusable(false);
        btnCopy.setHorizontalTextPosition(SwingConstants.CENTER);
        btnCopy.setVerticalTextPosition(SwingConstants.BOTTOM);
        jToolBar2.add(btnCopy);

        btnCut.setIcon(new ImageIcon(getClass().getResource("/cut.png"))); // NOI18N
        btnCut.setToolTipText("Cortar");
        btnCut.setFocusable(false);
        btnCut.setHorizontalTextPosition(SwingConstants.CENTER);
        btnCut.setVerticalTextPosition(SwingConstants.BOTTOM);
        jToolBar2.add(btnCut);

        btnPaste.setIcon(new ImageIcon(getClass().getResource("/paste.png"))); // NOI18N
        btnPaste.setToolTipText("Pegar");
        btnPaste.setFocusable(false);
        btnPaste.setHorizontalTextPosition(SwingConstants.CENTER);
        btnPaste.setVerticalTextPosition(SwingConstants.BOTTOM);
        jToolBar2.add(btnPaste);

        frmSQLScript.getContentPane().add(jToolBar2, BorderLayout.PAGE_START);

        jSplitPane1.setLeftComponent(frmSQLScript);

        jPanel1.setLayout(new BoxLayout(jPanel1, BoxLayout.LINE_AXIS));

        panelVigente.setLayout(new GridLayout(2, 2));

        ifrmSQLModificado.setVisible(true);

        txtSQLModificado.setEditable(false);
        txtSQLModificado.setColumns(20);
        txtSQLModificado.setRows(5);
        jScrollPane3.setViewportView(txtSQLModificado);

        ifrmSQLModificado.getContentPane().add(jScrollPane3, BorderLayout.CENTER);

        panelVigente.add(ifrmSQLModificado);

        ifrmPDC.setVisible(true);

        txtPDC.setEditable(false);
        txtPDC.setColumns(20);
        txtPDC.setRows(5);
        jScrollPane4.setViewportView(txtPDC);

        ifrmPDC.getContentPane().add(jScrollPane4, BorderLayout.CENTER);

        panelVigente.add(ifrmPDC);

        ifrmLanzaSQLModificado.setVisible(true);

        txtLanzaSQLModificado.setEditable(false);
        txtLanzaSQLModificado.setColumns(20);
        txtLanzaSQLModificado.setRows(5);
        jScrollPane5.setViewportView(txtLanzaSQLModificado);

        ifrmLanzaSQLModificado.getContentPane().add(jScrollPane5, BorderLayout.CENTER);

        panelVigente.add(ifrmLanzaSQLModificado);

        ifrmLanzaPDC.setVisible(true);

        txtLanzaPDC.setEditable(false);
        txtLanzaPDC.setColumns(20);
        txtLanzaPDC.setRows(5);
        jScrollPane6.setViewportView(txtLanzaPDC);

        ifrmLanzaPDC.getContentPane().add(jScrollPane6, BorderLayout.CENTER);

        panelVigente.add(ifrmLanzaPDC);

        tabPanel.addTab("Vigente", panelVigente);

        panelHistorico.setLayout(new GridLayout(2, 2));

        ifrmSQLH.setVisible(true);

        txtSQLH.setEditable(false);
        txtSQLH.setColumns(20);
        txtSQLH.setRows(5);
        jScrollPane7.setViewportView(txtSQLH);

        ifrmSQLH.getContentPane().add(jScrollPane7, BorderLayout.CENTER);

        panelHistorico.add(ifrmSQLH);

        ifrmPDCH.setVisible(true);

        txtPDCH.setEditable(false);
        txtPDCH.setColumns(20);
        txtPDCH.setRows(5);
        jScrollPane8.setViewportView(txtPDCH);

        ifrmPDCH.getContentPane().add(jScrollPane8, BorderLayout.CENTER);

        panelHistorico.add(ifrmPDCH);

        ifrmLanzaSQLH.setVisible(true);

        txtLanzaSQLH.setEditable(false);
        txtLanzaSQLH.setColumns(20);
        txtLanzaSQLH.setRows(5);
        jScrollPane9.setViewportView(txtLanzaSQLH);

        ifrmLanzaSQLH.getContentPane().add(jScrollPane9, BorderLayout.CENTER);

        panelHistorico.add(ifrmLanzaSQLH);

        ifrmLanzaPDCH.setVisible(true);

        txtLanzaPDCH.setEditable(false);
        txtLanzaPDCH.setColumns(20);
        txtLanzaPDCH.setRows(5);
        jScrollPane10.setViewportView(txtLanzaPDCH);

        ifrmLanzaPDCH.getContentPane().add(jScrollPane10, BorderLayout.CENTER);

        panelHistorico.add(ifrmLanzaPDCH);

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
		menuBar = new MainMenuBar(this);
	}

	@Override
	protected void initEvents() {
		FramePrincipalActionListener actionListener = new FramePrincipalActionListener(this);
		WindowListener windowListener = new FramePrincipalWindowListener(this);
		editorEventHandler = new EditorEventHandler(this);
		
		addWindowListener(windowListener);
		addOnLoadListener(actionListener);

		btnLoadScript.setActionCommand(Constants.FRAME_PRINCIPAL_LOAD_SCRIPT);
		btnCargarScriptObjetos.setActionCommand(Constants.FRAME_PRINCIPAL_CARGAR_SCRIPT_OBJETOS);
		btnProcesarScript.setActionCommand(Constants.FRAME_PRINCIPAL_PROCESAR_SCRIPT);
		btnSave.setActionCommand(Constants.FRAME_PRINCIPAL_SAVE);
		btnExecute.setActionCommand(Constants.FRAME_PRINCIPAL_EXECUTE);
		btnEntregarProcesado.setActionCommand(Constants.FRAME_PRINCIPAL_ENTREGAR_PROCESADO);
		btnLimpiarScripts.setActionCommand(Constants.FRAME_PRINCIPAL_LIMPIAR_SCRIPT);
		btnProcesadoEnCurso.setActionCommand(Constants.FRAME_PRINCIPAL_PROCESADO_CURSO);
		btnRefrescarFichero.setActionCommand(Constants.FRAME_PRINCIPAL_REFRESCAR_FICHERO);
		btnInformacionModelo.setActionCommand(Constants.FRAME_PRINCIPAL_INFORMACION_MODELO);

		btnUndo.setActionCommand(Constants.FRAME_PRINCIPAL_BTN_UNDO);
		btnRedo.setActionCommand(Constants.FRAME_PRINCIPAL_BTN_REDO);
		btnCut.setActionCommand(Constants.FRAME_PRINCIPAL_BTN_CUT);
		btnCopy.setActionCommand(Constants.FRAME_PRINCIPAL_BTN_COPY);
		btnPaste.setActionCommand(Constants.FRAME_PRINCIPAL_BTN_PASTE);

		btnLoadScript.addActionListener(actionListener);
		btnCargarScriptObjetos.addActionListener(actionListener);
		btnProcesarScript.addActionListener(actionListener);
		btnSave.addActionListener(actionListener);
		btnExecute.addActionListener(actionListener);
		btnEntregarProcesado.addActionListener(actionListener);
		btnLimpiarScripts.addActionListener(actionListener);
		btnUndo.addActionListener(actionListener);
		btnRedo.addActionListener(actionListener);
		btnCut.addActionListener(actionListener);
		btnCopy.addActionListener(actionListener);
		btnPaste.addActionListener(actionListener);
		btnProcesadoEnCurso.addActionListener(actionListener);
		btnRefrescarFichero.addActionListener(actionListener);
		btnInformacionModelo.addActionListener(actionListener);

		// Manejador de eventos del editor
		txtSQLCode.getDocument().addUndoableEditListener(editorEventHandler);

		// remueve las posibles combinaciones de teclas asociadas por defecto con el
		// JTextArea
		txtSQLCode.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK), "none"); // remueve
																											// CTRL + X
																											// ("Cortar")
		txtSQLCode.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK), "none"); // remueve
																											// CTRL + C
																											// ("Copiar")
		txtSQLCode.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK), "none"); // remueve
																											// CTRL + V
																											// ("Pegar")
	}

	@Override
	protected void initModels() {
		Cabecera cabecera = MDSQLUIHelper.createCabeceraTabla(Constants.FRAME_PRINCIPAL_TYPES_TABLA_CABECERA);
		jTable1.initModel(new FramePrincipalTypesTableModel(cabecera));
	}

	@Override
	protected void initialState() {
		undoManager = new UndoManager(); // construye una instancia de UndoManager
		undoManager.setLimit(50); // le asigna un límite al buffer de ediciones

		disableEditionButtons();
		
		txtSQLCode.setEditable(Boolean.FALSE);
		txtSQLCode.setEnabled(Boolean.FALSE);
	}

	@Override
	protected void setupLiterals() {
		setTitle("MDSQL");

		btnUndo.setToolTipText("Deshacer");
		btnRedo.setToolTipText("Rehacer");
		btnCopy.setToolTipText("Copiar");
		btnCut.setToolTipText("Cortar");
		btnPaste.setToolTipText("Pegar");
	}

	/**
	 * Actualiza el estado de las opciones "Deshacer" y "Rehacer".
	 */
	public void updateEditionControls() {
		// averigua si se pueden deshacer los cambios en el documento actual
		boolean canUndo = undoManager.canUndo();
		// averigua si se pueden rehacer los cambios en el documento actual
		boolean canRedo = undoManager.canRedo();

		// activa o desactiva las opciones en la barra de herramientas
		btnUndo.setEnabled(canUndo);
		btnRedo.setEnabled(canRedo);
	}
	
	public void resetFrames() {
		ifrmSQLModificado.setTitle(StringUtils.EMPTY);
		ifrmPDC.setTitle(StringUtils.EMPTY);
		ifrmLanzaSQLModificado.setTitle(StringUtils.EMPTY);
		ifrmLanzaPDC.setTitle(StringUtils.EMPTY);
		ifrmSQLH.setTitle(StringUtils.EMPTY);
		ifrmLanzaSQLH.setTitle(StringUtils.EMPTY);
		ifrmPDCH.setTitle(StringUtils.EMPTY);
		ifrmLanzaPDCH.setTitle(StringUtils.EMPTY);
		
		txtSQLModificado.setText(StringUtils.EMPTY);
		txtPDC.setText(StringUtils.EMPTY);
		txtLanzaSQLModificado.setText(StringUtils.EMPTY);
		txtLanzaPDC.setText(StringUtils.EMPTY);
		txtSQLH.setText(StringUtils.EMPTY);
		txtLanzaSQLH.setText(StringUtils.EMPTY);
		txtPDCH.setText(StringUtils.EMPTY);
		txtLanzaPDCH.setText(StringUtils.EMPTY);
	}

	/**
	 * 
	 */
	public void disableTabs() {
		this.getTabPanel().setEnabledAt(0, Boolean.FALSE);
		this.getTabPanel().setEnabledAt(1, Boolean.FALSE);
		this.getTabPanel().setEnabledAt(2, Boolean.FALSE);
	}

	/**
	 * 
	 */
	public void disableEditionButtons() {
		btnUndo.setEnabled(Boolean.FALSE);
		btnRedo.setEnabled(Boolean.FALSE);
	}
}
