/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mdsql.ui;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JMenuBar;
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

import com.mdsql.ui.menu.MainMenuBar;
import com.mdsql.ui.utils.FrameSupport;

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
    private JButton jButton2;
    private JButton jButton3;
    private JButton jButton4;
    private JButton jButton5;
    private JButton jButton6;
    private JButton jButton7;
    private JButton jButton8;
    private JButton jButton9;
    private JInternalFrame jInternalFrame1;
    private JInternalFrame jInternalFrame10;
    private JInternalFrame jInternalFrame2;
    private JInternalFrame jInternalFrame3;
    private JInternalFrame jInternalFrame4;
    private JInternalFrame jInternalFrame5;
    private JInternalFrame jInternalFrame6;
    private JInternalFrame jInternalFrame7;
    private JInternalFrame jInternalFrame8;
    private JInternalFrame jInternalFrame9;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JToolBar.Separator jSeparator1;
    private JToolBar.Separator jSeparator2;
    private JToolBar.Separator jSeparator3;
    private JToolBar.Separator jSeparator4;
    private JSplitPane jSplitPane1;
    private JTabbedPane jTabbedPane1;
    private JTable jTable1;
    private JTextArea jTextArea1;
    private JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
	
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
        jButton2 = new JButton();
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
        jInternalFrame1 = new JInternalFrame();
        jScrollPane1 = new JScrollPane();
        jTextArea1 = new JTextArea();
        jPanel1 = new JPanel();
        jTabbedPane1 = new JTabbedPane();
        jPanel2 = new JPanel();
        jInternalFrame2 = new JInternalFrame();
        jInternalFrame3 = new JInternalFrame();
        jInternalFrame4 = new JInternalFrame();
        jInternalFrame5 = new JInternalFrame();
        jPanel3 = new JPanel();
        jPanel4 = new JPanel();
        jInternalFrame6 = new JInternalFrame();
        jScrollPane2 = new JScrollPane();
        jTable1 = new JTable();
        jInternalFrame7 = new JInternalFrame();
        jInternalFrame8 = new JInternalFrame();
        jInternalFrame9 = new JInternalFrame();
        jInternalFrame10 = new JInternalFrame();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        JMenuBar barraMenu = new MainMenuBar();
        setJMenuBar(barraMenu);

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

        jButton2.setIcon(new ImageIcon(getClass().getResource("/checked.png"))); // NOI18N
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(SwingConstants.BOTTOM);
        jToolBar1.add(jButton2);
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

        jInternalFrame1.setVisible(true);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jInternalFrame1.getContentPane().add(jScrollPane1, BorderLayout.CENTER);

        jSplitPane1.setLeftComponent(jInternalFrame1);

        jPanel1.setLayout(new BoxLayout(jPanel1, BoxLayout.LINE_AXIS));

        jPanel2.setLayout(new GridLayout(2, 2));

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

        jPanel2.add(jInternalFrame2);

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

        jPanel2.add(jInternalFrame3);

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

        jPanel2.add(jInternalFrame4);

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

        jPanel2.add(jInternalFrame5);

        jTabbedPane1.addTab("Vigente", jPanel2);

        GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 1064, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 630, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Histórico", jPanel3);

        jPanel4.setLayout(new GridLayout(3, 2));

        jInternalFrame6.setVisible(true);

        jScrollPane2.setViewportView(jTable1);

        jInternalFrame6.getContentPane().add(jScrollPane2, BorderLayout.CENTER);

        jPanel4.add(jInternalFrame6);

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

        jPanel4.add(jInternalFrame7);

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

        jPanel4.add(jInternalFrame8);

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

        jPanel4.add(jInternalFrame9);

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

        jPanel4.add(jInternalFrame10);

        jTabbedPane1.addTab("Types", jPanel4);

        jPanel1.add(jTabbedPane1);

        jSplitPane1.setRightComponent(jPanel1);

        getContentPane().add(jSplitPane1, BorderLayout.CENTER);
        
    }// </editor-fold>//GEN-END:initComponents

	@Override
	protected void initEvents() {
		// TODO Auto-generated method stub
		
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
