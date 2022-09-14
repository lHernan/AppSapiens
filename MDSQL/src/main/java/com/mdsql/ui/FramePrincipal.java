/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mdsql.ui;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

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
import com.mdval.ui.utils.FrameSupport;

import lombok.Getter;

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
    private JButton jButton10;
    private JButton btnCargarScriptObjetos;
    private JButton jButton3;
    private JButton jButton4;
    private JButton jButton5;
    private JButton jButton6;
    private JButton jButton7;
    private JButton jButton8;
    private JButton jButton9;
    
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
    private JToolBar.Separator jSeparator3;
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
        jButton3 = new JButton();
        jButton4 = new JButton();
        jButton5 = new JButton();
        jButton6 = new JButton();
        jButton7 = new JButton();
        jButton8 = new JButton();
        jSeparator3 = new JToolBar.Separator();
        jButton9 = new JButton();
        jSeparator4 = new JToolBar.Separator();
        jButton10 = new JButton();
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

        btnLoadScript.setIcon(new ImageIcon(getClass().getResource("/script.png"))); // NOI18N
        btnLoadScript.setFocusable(false);
        btnLoadScript.setHorizontalTextPosition(SwingConstants.CENTER);
        btnLoadScript.setMaximumSize(new Dimension(36, 36));
        btnLoadScript.setMinimumSize(new Dimension(36, 36));
        btnLoadScript.setPreferredSize(new Dimension(36, 36));
        btnLoadScript.setVerticalTextPosition(SwingConstants.BOTTOM);
        jToolBar1.add(btnLoadScript);
        jToolBar1.add(jSeparator1);

        btnCargarScriptObjetos.setText("TYPE");
        btnCargarScriptObjetos.setFocusable(false);
        btnCargarScriptObjetos.setHorizontalTextPosition(SwingConstants.CENTER);
        btnCargarScriptObjetos.setVerticalTextPosition(SwingConstants.BOTTOM);
        jToolBar1.add(btnCargarScriptObjetos);
        jToolBar1.add(jSeparator2);

        jButton3.setIcon(new ImageIcon(getClass().getResource("/checked.png"))); // NOI18N
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(SwingConstants.BOTTOM);
        jToolBar1.add(jButton3);

        jButton4.setIcon(new ImageIcon(getClass().getResource("/checked.png"))); // NOI18N
        jButton4.setFocusable(false);
        jButton4.setHorizontalTextPosition(SwingConstants.CENTER);
        jButton4.setVerticalTextPosition(SwingConstants.BOTTOM);
        jToolBar1.add(jButton4);

        jButton5.setIcon(new ImageIcon(getClass().getResource("/checked.png"))); // NOI18N
        jButton5.setFocusable(false);
        jButton5.setHorizontalTextPosition(SwingConstants.CENTER);
        jButton5.setVerticalTextPosition(SwingConstants.BOTTOM);
        jToolBar1.add(jButton5);

        jButton6.setIcon(new ImageIcon(getClass().getResource("/checked.png"))); // NOI18N
        jButton6.setFocusable(false);
        jButton6.setHorizontalTextPosition(SwingConstants.CENTER);
        jButton6.setVerticalTextPosition(SwingConstants.BOTTOM);
        jToolBar1.add(jButton6);

        jButton7.setIcon(new ImageIcon(getClass().getResource("/checked.png"))); // NOI18N
        jButton7.setFocusable(false);
        jButton7.setHorizontalTextPosition(SwingConstants.CENTER);
        jButton7.setVerticalTextPosition(SwingConstants.BOTTOM);
        jToolBar1.add(jButton7);

        jButton8.setIcon(new ImageIcon(getClass().getResource("/checked.png"))); // NOI18N
        jButton8.setFocusable(false);
        jButton8.setHorizontalTextPosition(SwingConstants.CENTER);
        jButton8.setVerticalTextPosition(SwingConstants.BOTTOM);
        jToolBar1.add(jButton8);
        jToolBar1.add(jSeparator3);

        jButton9.setIcon(new ImageIcon(getClass().getResource("/checked.png"))); // NOI18N
        jButton9.setFocusable(false);
        jButton9.setHorizontalTextPosition(SwingConstants.CENTER);
        jButton9.setVerticalTextPosition(SwingConstants.BOTTOM);
        jToolBar1.add(jButton9);
        jToolBar1.add(jSeparator4);

        jButton10.setIcon(new ImageIcon(getClass().getResource("/checked.png"))); // NOI18N
        jButton10.setFocusable(false);
        jButton10.setHorizontalTextPosition(SwingConstants.CENTER);
        jButton10.setVerticalTextPosition(SwingConstants.BOTTOM);
        jToolBar1.add(jButton10);

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
            .addGap(0, 281, Short.MAX_VALUE)
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
            .addGap(0, 281, Short.MAX_VALUE)
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
            .addGap(0, 281, Short.MAX_VALUE)
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
            .addGap(0, 281, Short.MAX_VALUE)
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
        
        menuBar = new MainMenuBar();
        
    }// </editor-fold>//GEN-END:initComponents

	@Override
	protected void initEvents() {
		ActionListener actionListener = new FramePrincipalActionListener(this);
		
		btnLoadScript.setActionCommand(Constants.FRAME_PRINCIPAL_LOAD_SCRIPT);
		btnCargarScriptObjetos.setActionCommand(Constants.FRAME_PRINCIPAL_CARGAR_SCRIPT_OBJETOS);
		
		btnLoadScript.addActionListener(actionListener);
		btnCargarScriptObjetos.addActionListener(actionListener);
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
		// TODO Auto-generated method stub
		
	}
}
