/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mdsql.ui;

/**
 *
 * @author federico
 */
public class FramePrincipal extends javax.swing.JFrame {

    /**
     * Creates new form Principal
     */
    public FramePrincipal() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        btnLoadScript = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btnCargarScriptObjetos = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        btnProcesarScript = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnExecute = new javax.swing.JButton();
        btnEntregarProcesado = new javax.swing.JButton();
        btnLimpiarScripts = new javax.swing.JButton();
        btnLimpiarSesion = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        btnProcesadoEnCurso = new javax.swing.JButton();
        btnRefrescarFichero = new javax.swing.JButton();
        btnInformacionModelo = new javax.swing.JButton();
        jSplitPane1 = new javax.swing.JSplitPane();
        frmSQLScript = new javax.swing.JInternalFrame();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtSQLCode = new javax.swing.JTextArea();
        jToolBar2 = new javax.swing.JToolBar();
        btnUndo = new javax.swing.JButton();
        btnRedo = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        btnCopy = new javax.swing.JButton();
        btnCut = new javax.swing.JButton();
        btnPaste = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        tabPanel = new javax.swing.JTabbedPane();
        panelVigente = new javax.swing.JPanel();
        ifrmSQLModificado = new javax.swing.JInternalFrame();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtSQLModificado = new javax.swing.JTextArea();
        ifrmPDC = new javax.swing.JInternalFrame();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtPDC = new javax.swing.JTextArea();
        ifrmLanzaSQLModificado = new javax.swing.JInternalFrame();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtLanzaSQLModificado = new javax.swing.JTextArea();
        ifrmLanzaPDC = new javax.swing.JInternalFrame();
        jScrollPane6 = new javax.swing.JScrollPane();
        txtLanzaPDC = new javax.swing.JTextArea();
        panelHistorico = new javax.swing.JPanel();
        jInternalFrame11 = new javax.swing.JInternalFrame();
        jInternalFrame12 = new javax.swing.JInternalFrame();
        jInternalFrame13 = new javax.swing.JInternalFrame();
        jInternalFrame14 = new javax.swing.JInternalFrame();
        panelTypes = new javax.swing.JPanel();
        jInternalFrame6 = new javax.swing.JInternalFrame();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jInternalFrame7 = new javax.swing.JInternalFrame();
        jInternalFrame8 = new javax.swing.JInternalFrame();
        jInternalFrame9 = new javax.swing.JInternalFrame();
        jInternalFrame10 = new javax.swing.JInternalFrame();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jToolBar1.setRollover(true);
        jToolBar1.setMargin(new java.awt.Insets(3, 3, 3, 3));

        btnLoadScript.setIcon(new javax.swing.ImageIcon(getClass().getResource("/script.png"))); // NOI18N
        btnLoadScript.setToolTipText("Cargar script");
        btnLoadScript.setFocusable(false);
        btnLoadScript.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLoadScript.setMaximumSize(new java.awt.Dimension(60, 60));
        btnLoadScript.setMinimumSize(new java.awt.Dimension(60, 60));
        btnLoadScript.setPreferredSize(new java.awt.Dimension(60, 60));
        btnLoadScript.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnLoadScript);
        jToolBar1.add(jSeparator1);

        btnCargarScriptObjetos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/folder.png"))); // NOI18N
        btnCargarScriptObjetos.setText("TYPE");
        btnCargarScriptObjetos.setToolTipText("Cargar script Objetos");
        btnCargarScriptObjetos.setFocusable(false);
        btnCargarScriptObjetos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCargarScriptObjetos.setMaximumSize(new java.awt.Dimension(60, 60));
        btnCargarScriptObjetos.setMinimumSize(new java.awt.Dimension(60, 60));
        btnCargarScriptObjetos.setPreferredSize(new java.awt.Dimension(60, 60));
        btnCargarScriptObjetos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnCargarScriptObjetos);
        jToolBar1.add(jSeparator2);

        btnProcesarScript.setIcon(new javax.swing.ImageIcon(getClass().getResource("/play.png"))); // NOI18N
        btnProcesarScript.setToolTipText("Procesar script");
        btnProcesarScript.setFocusable(false);
        btnProcesarScript.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnProcesarScript.setMaximumSize(new java.awt.Dimension(60, 60));
        btnProcesarScript.setMinimumSize(new java.awt.Dimension(60, 60));
        btnProcesarScript.setPreferredSize(new java.awt.Dimension(60, 60));
        btnProcesarScript.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnProcesarScript);

        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/floppy-disk.png"))); // NOI18N
        btnSave.setToolTipText("Guardar archivo");
        btnSave.setFocusable(false);
        btnSave.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSave.setMaximumSize(new java.awt.Dimension(60, 60));
        btnSave.setMinimumSize(new java.awt.Dimension(60, 60));
        btnSave.setPreferredSize(new java.awt.Dimension(60, 60));
        btnSave.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnSave);

        btnExecute.setIcon(new javax.swing.ImageIcon(getClass().getResource("/checking.png"))); // NOI18N
        btnExecute.setToolTipText("Ejecutar script");
        btnExecute.setFocusable(false);
        btnExecute.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnExecute.setMaximumSize(new java.awt.Dimension(60, 60));
        btnExecute.setMinimumSize(new java.awt.Dimension(60, 60));
        btnExecute.setPreferredSize(new java.awt.Dimension(60, 60));
        btnExecute.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnExecute);

        btnEntregarProcesado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/execution.png"))); // NOI18N
        btnEntregarProcesado.setToolTipText("Entregar procesado");
        btnEntregarProcesado.setFocusable(false);
        btnEntregarProcesado.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEntregarProcesado.setMaximumSize(new java.awt.Dimension(60, 60));
        btnEntregarProcesado.setMinimumSize(new java.awt.Dimension(60, 60));
        btnEntregarProcesado.setPreferredSize(new java.awt.Dimension(60, 60));
        btnEntregarProcesado.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnEntregarProcesado);

        btnLimpiarScripts.setIcon(new javax.swing.ImageIcon(getClass().getResource("/clean.png"))); // NOI18N
        btnLimpiarScripts.setToolTipText("Limpar scripts");
        btnLimpiarScripts.setFocusable(false);
        btnLimpiarScripts.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLimpiarScripts.setMaximumSize(new java.awt.Dimension(60, 60));
        btnLimpiarScripts.setMinimumSize(new java.awt.Dimension(60, 60));
        btnLimpiarScripts.setPreferredSize(new java.awt.Dimension(60, 60));
        btnLimpiarScripts.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnLimpiarScripts);

        btnLimpiarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/trash.png"))); // NOI18N
        btnLimpiarSesion.setToolTipText("Limpiar sesión");
        btnLimpiarSesion.setFocusable(false);
        btnLimpiarSesion.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLimpiarSesion.setMaximumSize(new java.awt.Dimension(60, 60));
        btnLimpiarSesion.setMinimumSize(new java.awt.Dimension(60, 60));
        btnLimpiarSesion.setPreferredSize(new java.awt.Dimension(60, 60));
        btnLimpiarSesion.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnLimpiarSesion);
        jToolBar1.add(jSeparator4);

        btnProcesadoEnCurso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/info.png"))); // NOI18N
        btnProcesadoEnCurso.setToolTipText("Procesado en curso");
        btnProcesadoEnCurso.setFocusable(false);
        btnProcesadoEnCurso.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnProcesadoEnCurso.setMaximumSize(new java.awt.Dimension(60, 60));
        btnProcesadoEnCurso.setMinimumSize(new java.awt.Dimension(60, 60));
        btnProcesadoEnCurso.setPreferredSize(new java.awt.Dimension(60, 60));
        btnProcesadoEnCurso.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnProcesadoEnCurso);

        btnRefrescarFichero.setIcon(new javax.swing.ImageIcon(getClass().getResource("/file.png"))); // NOI18N
        btnRefrescarFichero.setToolTipText("Refrescar fichero");
        btnRefrescarFichero.setFocusable(false);
        btnRefrescarFichero.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRefrescarFichero.setMaximumSize(new java.awt.Dimension(60, 60));
        btnRefrescarFichero.setMinimumSize(new java.awt.Dimension(60, 60));
        btnRefrescarFichero.setPreferredSize(new java.awt.Dimension(60, 60));
        btnRefrescarFichero.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnRefrescarFichero);

        btnInformacionModelo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/information.png"))); // NOI18N
        btnInformacionModelo.setToolTipText("Información del modelo");
        btnInformacionModelo.setFocusable(false);
        btnInformacionModelo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnInformacionModelo.setMaximumSize(new java.awt.Dimension(60, 60));
        btnInformacionModelo.setMinimumSize(new java.awt.Dimension(60, 60));
        btnInformacionModelo.setPreferredSize(new java.awt.Dimension(60, 60));
        btnInformacionModelo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnInformacionModelo);

        getContentPane().add(jToolBar1, java.awt.BorderLayout.PAGE_START);

        frmSQLScript.setVisible(true);

        txtSQLCode.setColumns(20);
        txtSQLCode.setRows(5);
        jScrollPane1.setViewportView(txtSQLCode);

        frmSQLScript.getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jToolBar2.setFloatable(false);
        jToolBar2.setRollover(true);

        btnUndo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/undo.png"))); // NOI18N
        btnUndo.setToolTipText("Deshacer");
        btnUndo.setFocusable(false);
        btnUndo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnUndo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar2.add(btnUndo);

        btnRedo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/redo.png"))); // NOI18N
        btnRedo.setToolTipText("Rehacer");
        btnRedo.setFocusable(false);
        btnRedo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRedo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar2.add(btnRedo);
        jToolBar2.add(jSeparator3);

        btnCopy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/copy.png"))); // NOI18N
        btnCopy.setToolTipText("Copiar");
        btnCopy.setFocusable(false);
        btnCopy.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCopy.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar2.add(btnCopy);

        btnCut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cut.png"))); // NOI18N
        btnCut.setToolTipText("Cortar");
        btnCut.setFocusable(false);
        btnCut.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCut.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar2.add(btnCut);

        btnPaste.setIcon(new javax.swing.ImageIcon(getClass().getResource("/paste.png"))); // NOI18N
        btnPaste.setToolTipText("Pegar");
        btnPaste.setFocusable(false);
        btnPaste.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPaste.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar2.add(btnPaste);

        frmSQLScript.getContentPane().add(jToolBar2, java.awt.BorderLayout.PAGE_START);

        jSplitPane1.setLeftComponent(frmSQLScript);

        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));

        panelVigente.setLayout(new java.awt.GridLayout(2, 2));

        ifrmSQLModificado.setVisible(true);

        txtSQLModificado.setEditable(false);
        txtSQLModificado.setColumns(20);
        txtSQLModificado.setRows(5);
        jScrollPane3.setViewportView(txtSQLModificado);

        ifrmSQLModificado.getContentPane().add(jScrollPane3, java.awt.BorderLayout.CENTER);

        panelVigente.add(ifrmSQLModificado);

        ifrmPDC.setVisible(true);

        txtPDC.setEditable(false);
        txtPDC.setColumns(20);
        txtPDC.setRows(5);
        jScrollPane4.setViewportView(txtPDC);

        ifrmPDC.getContentPane().add(jScrollPane4, java.awt.BorderLayout.CENTER);

        panelVigente.add(ifrmPDC);

        ifrmLanzaSQLModificado.setVisible(true);

        txtLanzaSQLModificado.setEditable(false);
        txtLanzaSQLModificado.setColumns(20);
        txtLanzaSQLModificado.setRows(5);
        jScrollPane5.setViewportView(txtLanzaSQLModificado);

        ifrmLanzaSQLModificado.getContentPane().add(jScrollPane5, java.awt.BorderLayout.CENTER);

        panelVigente.add(ifrmLanzaSQLModificado);

        ifrmLanzaPDC.setVisible(true);

        txtLanzaPDC.setEditable(false);
        txtLanzaPDC.setColumns(20);
        txtLanzaPDC.setRows(5);
        jScrollPane6.setViewportView(txtLanzaPDC);

        ifrmLanzaPDC.getContentPane().add(jScrollPane6, java.awt.BorderLayout.CENTER);

        panelVigente.add(ifrmLanzaPDC);

        tabPanel.addTab("Vigente", panelVigente);

        panelHistorico.setLayout(new java.awt.GridLayout(2, 2));

        jInternalFrame11.setVisible(true);

        javax.swing.GroupLayout jInternalFrame11Layout = new javax.swing.GroupLayout(jInternalFrame11.getContentPane());
        jInternalFrame11.getContentPane().setLayout(jInternalFrame11Layout);
        jInternalFrame11Layout.setHorizontalGroup(
            jInternalFrame11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame11Layout.setVerticalGroup(
            jInternalFrame11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        panelHistorico.add(jInternalFrame11);

        jInternalFrame12.setVisible(true);

        javax.swing.GroupLayout jInternalFrame12Layout = new javax.swing.GroupLayout(jInternalFrame12.getContentPane());
        jInternalFrame12.getContentPane().setLayout(jInternalFrame12Layout);
        jInternalFrame12Layout.setHorizontalGroup(
            jInternalFrame12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame12Layout.setVerticalGroup(
            jInternalFrame12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        panelHistorico.add(jInternalFrame12);

        jInternalFrame13.setVisible(true);

        javax.swing.GroupLayout jInternalFrame13Layout = new javax.swing.GroupLayout(jInternalFrame13.getContentPane());
        jInternalFrame13.getContentPane().setLayout(jInternalFrame13Layout);
        jInternalFrame13Layout.setHorizontalGroup(
            jInternalFrame13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame13Layout.setVerticalGroup(
            jInternalFrame13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        panelHistorico.add(jInternalFrame13);

        jInternalFrame14.setVisible(true);

        javax.swing.GroupLayout jInternalFrame14Layout = new javax.swing.GroupLayout(jInternalFrame14.getContentPane());
        jInternalFrame14.getContentPane().setLayout(jInternalFrame14Layout);
        jInternalFrame14Layout.setHorizontalGroup(
            jInternalFrame14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame14Layout.setVerticalGroup(
            jInternalFrame14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        panelHistorico.add(jInternalFrame14);

        tabPanel.addTab("Histórico", panelHistorico);

        panelTypes.setLayout(new java.awt.GridLayout(3, 2));

        jInternalFrame6.setVisible(true);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable1);

        jInternalFrame6.getContentPane().add(jScrollPane2, java.awt.BorderLayout.CENTER);

        panelTypes.add(jInternalFrame6);

        jInternalFrame7.setVisible(true);

        javax.swing.GroupLayout jInternalFrame7Layout = new javax.swing.GroupLayout(jInternalFrame7.getContentPane());
        jInternalFrame7.getContentPane().setLayout(jInternalFrame7Layout);
        jInternalFrame7Layout.setHorizontalGroup(
            jInternalFrame7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame7Layout.setVerticalGroup(
            jInternalFrame7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        panelTypes.add(jInternalFrame7);

        jInternalFrame8.setVisible(true);

        javax.swing.GroupLayout jInternalFrame8Layout = new javax.swing.GroupLayout(jInternalFrame8.getContentPane());
        jInternalFrame8.getContentPane().setLayout(jInternalFrame8Layout);
        jInternalFrame8Layout.setHorizontalGroup(
            jInternalFrame8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame8Layout.setVerticalGroup(
            jInternalFrame8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        panelTypes.add(jInternalFrame8);

        jInternalFrame9.setVisible(true);

        javax.swing.GroupLayout jInternalFrame9Layout = new javax.swing.GroupLayout(jInternalFrame9.getContentPane());
        jInternalFrame9.getContentPane().setLayout(jInternalFrame9Layout);
        jInternalFrame9Layout.setHorizontalGroup(
            jInternalFrame9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame9Layout.setVerticalGroup(
            jInternalFrame9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        panelTypes.add(jInternalFrame9);

        jInternalFrame10.setVisible(true);

        javax.swing.GroupLayout jInternalFrame10Layout = new javax.swing.GroupLayout(jInternalFrame10.getContentPane());
        jInternalFrame10.getContentPane().setLayout(jInternalFrame10Layout);
        jInternalFrame10Layout.setHorizontalGroup(
            jInternalFrame10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame10Layout.setVerticalGroup(
            jInternalFrame10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        panelTypes.add(jInternalFrame10);

        tabPanel.addTab("Types", panelTypes);

        jPanel1.add(tabPanel);

        jSplitPane1.setRightComponent(jPanel1);

        getContentPane().add(jSplitPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FramePrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCargarScriptObjetos;
    private javax.swing.JButton btnCopy;
    private javax.swing.JButton btnCut;
    private javax.swing.JButton btnEntregarProcesado;
    private javax.swing.JButton btnExecute;
    private javax.swing.JButton btnInformacionModelo;
    private javax.swing.JButton btnLimpiarScripts;
    private javax.swing.JButton btnLimpiarSesion;
    private javax.swing.JButton btnLoadScript;
    private javax.swing.JButton btnPaste;
    private javax.swing.JButton btnProcesadoEnCurso;
    private javax.swing.JButton btnProcesarScript;
    private javax.swing.JButton btnRedo;
    private javax.swing.JButton btnRefrescarFichero;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUndo;
    private javax.swing.JInternalFrame frmSQLScript;
    private javax.swing.JInternalFrame ifrmLanzaPDC;
    private javax.swing.JInternalFrame ifrmLanzaSQLModificado;
    private javax.swing.JInternalFrame ifrmPDC;
    private javax.swing.JInternalFrame ifrmSQLModificado;
    private javax.swing.JInternalFrame jInternalFrame10;
    private javax.swing.JInternalFrame jInternalFrame11;
    private javax.swing.JInternalFrame jInternalFrame12;
    private javax.swing.JInternalFrame jInternalFrame13;
    private javax.swing.JInternalFrame jInternalFrame14;
    private javax.swing.JInternalFrame jInternalFrame6;
    private javax.swing.JInternalFrame jInternalFrame7;
    private javax.swing.JInternalFrame jInternalFrame8;
    private javax.swing.JInternalFrame jInternalFrame9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JPanel panelHistorico;
    private javax.swing.JPanel panelTypes;
    private javax.swing.JPanel panelVigente;
    private javax.swing.JTabbedPane tabPanel;
    private javax.swing.JTextArea txtLanzaPDC;
    private javax.swing.JTextArea txtLanzaSQLModificado;
    private javax.swing.JTextArea txtPDC;
    private javax.swing.JTextArea txtSQLCode;
    private javax.swing.JTextArea txtSQLModificado;
    // End of variables declaration//GEN-END:variables
}
