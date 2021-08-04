/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sapiens.app.ui.validacionscripts;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author federico
 */
@Slf4j
public class PanelPrincipal extends JPanel {

    /**
	 * 
	 */
	private static final long serialVersionUID = 3533639441146450519L;
	
	// Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton btnLimpiarTodo;
    private JButton btnLimpiarValidacion;
    private JButton btnLoadScript;
    private JButton btnValidar;
    private JButton btnSearch;
    private JComboBox<String> jComboBox1;
    private JLabel jLabel1;
    private JLabel jLabel10;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private JPanel jPanel1;
    private JPanel jPanel10;
    private JPanel jPanel11;
    private JPanel jPanel12;
    private JPanel jPanel13;
    private JPanel jPanel14;
    private JPanel jPanel15;
    private JPanel jPanel16;
    private JPanel jPanel17;
    private JPanel jPanel18;
    private JPanel jPanel19;
    private JPanel jPanel2;
    private JPanel jPanel20;
    private JPanel jPanel21;
    private JPanel jPanel22;
    private JPanel jPanel23;
    private JPanel jPanel24;
    private JPanel jPanel25;
    private JPanel jPanel26;
    private JPanel jPanel27;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JPanel jPanel5;
    private JPanel jPanel6;
    private JPanel jPanel7;
    private JPanel jPanel8;
    private JPanel jPanel9;
    private JScrollPane jScrollPane1;
    private JTabbedPane jTabbedPane1;
    private JTextArea jTextArea1;
    private JTextField jTextField1;
    private JTextField jTextField2;
    private JTextField jTextField3;
    private JTextField jTextField4;
    private JTextField jTextField5;
    private JTextField jTextField6;
    private JTextField jTextField7;
    private JTextField jTextField8;
    private JPanel panelBotones;
    private JPanel panelCabecera;
    private JPanel panelContenido;
    private JPanel panelLogotipo;
    private JPanel panelOpciones;
    private JPanel panelResultado;
    // End of variables declaration//GEN-END:variables
    
	/**
     * Creates new form PanelPrincipal
     */
    public PanelPrincipal() {
        initComponents();
        initEvents();
    }

	/**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        GridBagConstraints gridBagConstraints;

        panelCabecera = new JPanel();
        panelLogotipo = new PanelLogotipo("logotipo.png");
        jLabel1 = new JLabel();
        panelContenido = new JPanel();
        panelOpciones = new JPanel();
        jPanel9 = new JPanel();
        jPanel13 = new JPanel();
        jLabel5 = new JLabel();
        jPanel14 = new JPanel();
        jTextField2 = new JTextField();
        jPanel15 = new JPanel();
        btnSearch = new JButton();
        jPanel16 = new JPanel();
        jLabel6 = new JLabel();
        jPanel17 = new JPanel();
        jTextField3 = new JTextField();
        jPanel18 = new JPanel();
        jTextField4 = new JTextField();
        jPanel2 = new JPanel();
        jPanel19 = new JPanel();
        jLabel7 = new JLabel();
        jPanel20 = new JPanel();
        jComboBox1 = new JComboBox<>();
        jPanel21 = new JPanel();
        jLabel8 = new JLabel();
        jPanel22 = new JPanel();
        jTextField5 = new JTextField();
        jPanel23 = new JPanel();
        jTextField6 = new JTextField();
        jPanel3 = new JPanel();
        jLabel9 = new JLabel();
        jTextField7 = new JTextField();
        jLabel10 = new JLabel();
        jTextField8 = new JTextField();
        jPanel4 = new JPanel();
        jPanel12 = new JPanel();
        jLabel4 = new JLabel();
        jPanel10 = new JPanel();
        jTextField1 = new JTextField();
        jPanel11 = new JPanel();
        btnLoadScript = new JButton();
        jPanel5 = new JPanel();
        jPanel6 = new JPanel();
        jLabel3 = new JLabel();
        jPanel7 = new JPanel();
        jScrollPane1 = new JScrollPane();
        jTextArea1 = new JTextArea();
        jPanel8 = new JPanel();
        btnValidar = new JButton();
        panelResultado = new JPanel();
        jTabbedPane1 = new JTabbedPane();
        jPanel1 = new JPanel();
        jPanel24 = new JPanel();
        jPanel25 = new JPanel();
        jPanel26 = new JPanel();
        jPanel27 = new JPanel();
        jLabel2 = new JLabel();
        panelBotones = new JPanel();
        btnLimpiarValidacion = new JButton();
        btnLimpiarTodo = new JButton();

        setLayout(new BorderLayout());

        panelCabecera.setLayout(new FlowLayout(FlowLayout.LEFT, 15, 15));

        panelLogotipo.setPreferredSize(new Dimension(286, 63));

        GroupLayout panelLogotipoLayout = new GroupLayout(panelLogotipo);
        panelLogotipo.setLayout(panelLogotipoLayout);
        panelLogotipoLayout.setHorizontalGroup(
            panelLogotipoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 286, Short.MAX_VALUE)
        );
        panelLogotipoLayout.setVerticalGroup(
            panelLogotipoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 63, Short.MAX_VALUE)
        );

        panelCabecera.add(panelLogotipo);

        jLabel1.setFont(new Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("Validador de scripts");
        panelCabecera.add(jLabel1);

        add(panelCabecera, BorderLayout.PAGE_START);

        panelContenido.setLayout(new BoxLayout(panelContenido, BoxLayout.PAGE_AXIS));

        panelOpciones.setLayout(new GridBagLayout());

        jPanel9.setLayout(new GridBagLayout());

        jLabel5.setText("Módulo o Proyecto");
        jPanel13.add(jLabel5);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        jPanel9.add(jPanel13, gridBagConstraints);

        jPanel14.setLayout(new BorderLayout());
        jPanel14.add(jTextField2, BorderLayout.CENTER);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.weightx = 80.0;
        jPanel9.add(jPanel14, gridBagConstraints);

        btnSearch.setIcon(new ImageIcon(getClass().getResource("/loupe.png"))); // NOI18N
        jPanel15.add(btnSearch);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = GridBagConstraints.VERTICAL;
        jPanel9.add(jPanel15, gridBagConstraints);

        jPanel16.setLayout(new FlowLayout(FlowLayout.RIGHT));

        jLabel6.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel6.setText("Glosario");
        jPanel16.add(jLabel6);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        jPanel9.add(jPanel16, gridBagConstraints);

        jPanel17.setLayout(new BorderLayout());

        jTextField3.setPreferredSize(new Dimension(45, 21));
        jPanel17.add(jTextField3, BorderLayout.CENTER);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        jPanel9.add(jPanel17, gridBagConstraints);

        jPanel18.setLayout(new BorderLayout());
        jPanel18.add(jTextField4, BorderLayout.CENTER);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.weightx = 60.0;
        jPanel9.add(jPanel18, gridBagConstraints);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.weightx = 80.0;
        panelOpciones.add(jPanel9, gridBagConstraints);

        jPanel2.setLayout(new GridBagLayout());

        jLabel7.setText("Submodelo");
        jPanel19.add(jLabel7);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        jPanel2.add(jPanel19, gridBagConstraints);

        jPanel20.setPreferredSize(new Dimension(150, 26));
        jPanel20.setLayout(new BorderLayout());

        jComboBox1.setModel(new DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.setMinimumSize(new Dimension(150, 26));
        jComboBox1.setPreferredSize(new Dimension(150, 26));
        jPanel20.add(jComboBox1, BorderLayout.CENTER);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 60.0;
        jPanel2.add(jPanel20, gridBagConstraints);

        jLabel8.setText("Norma");
        jPanel21.add(jLabel8);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        jPanel2.add(jPanel21, gridBagConstraints);

        jPanel22.setLayout(new BorderLayout());

        jTextField5.setPreferredSize(new Dimension(45, 21));
        jPanel22.add(jTextField5, BorderLayout.CENTER);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        jPanel2.add(jPanel22, gridBagConstraints);

        jPanel23.setLayout(new BorderLayout());
        jPanel23.add(jTextField6, BorderLayout.CENTER);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        jPanel2.add(jPanel23, gridBagConstraints);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.weightx = 50.0;
        panelOpciones.add(jPanel2, gridBagConstraints);

        jLabel9.setText("IM");
        jLabel9.setHorizontalTextPosition(SwingConstants.RIGHT);
        jPanel3.add(jLabel9);

        jTextField7.setPreferredSize(new Dimension(100, 21));
        jPanel3.add(jTextField7);

        jLabel10.setText("SD");
        jLabel10.setHorizontalTextPosition(SwingConstants.RIGHT);
        jPanel3.add(jLabel10);

        jTextField8.setPreferredSize(new Dimension(100, 21));
        jPanel3.add(jTextField8);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = GridBagConstraints.VERTICAL;
        gridBagConstraints.ipadx = 50;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.weightx = 33.0;
        panelOpciones.add(jPanel3, gridBagConstraints);

        jPanel4.setLayout(new BorderLayout());

        jLabel4.setText("Archivo con el script");
        jPanel12.add(jLabel4);

        jPanel4.add(jPanel12, BorderLayout.WEST);

        jPanel10.setLayout(new BorderLayout());
        jPanel10.add(jTextField1, BorderLayout.PAGE_START);

        jPanel4.add(jPanel10, BorderLayout.CENTER);

        btnLoadScript.setIcon(new ImageIcon(getClass().getResource("/folder.png"))); // NOI18N
        btnLoadScript.setPreferredSize(new Dimension(32, 32));
        jPanel11.add(btnLoadScript);

        jPanel4.add(jPanel11, BorderLayout.EAST);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        panelOpciones.add(jPanel4, gridBagConstraints);

        jPanel5.setLayout(new GridBagLayout());

        jLabel3.setText("Script");
        jPanel6.add(jLabel3);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 3.0;
        jPanel5.add(jPanel6, gridBagConstraints);

        jPanel7.setLayout(new BorderLayout());

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jPanel7.add(jScrollPane1, BorderLayout.CENTER);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 60.0;
        jPanel5.add(jPanel7, gridBagConstraints);

        btnValidar.setText("Validar");
        btnValidar.setHorizontalAlignment(SwingConstants.LEFT);
        btnValidar.setPreferredSize(new Dimension(77, 20));
        jPanel8.add(btnValidar);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = GridBagConstraints.PAGE_END;
        gridBagConstraints.weightx = 1.0;
        jPanel5.add(jPanel8, gridBagConstraints);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 99.0;
        panelOpciones.add(jPanel5, gridBagConstraints);

        panelContenido.add(panelOpciones);

        panelResultado.setLayout(new BorderLayout());

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 1015, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 374, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Elementos a Validar", jPanel1);

        GroupLayout jPanel24Layout = new GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 1015, Short.MAX_VALUE)
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 374, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Elementos Correctos", jPanel24);

        GroupLayout jPanel25Layout = new GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 1015, Short.MAX_VALUE)
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 374, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Elementos que No Están en Glosario", jPanel25);

        GroupLayout jPanel26Layout = new GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 1015, Short.MAX_VALUE)
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 374, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Elementos con Errores", jPanel26);

        GroupLayout jPanel27Layout = new GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 1015, Short.MAX_VALUE)
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 374, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Excepciones", jPanel27);

        panelResultado.add(jTabbedPane1, BorderLayout.CENTER);

        jLabel2.setText("Resultado validación");
        panelResultado.add(jLabel2, BorderLayout.PAGE_START);

        panelContenido.add(panelResultado);

        add(panelContenido, BorderLayout.CENTER);

        panelBotones.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 10));

        btnLimpiarValidacion.setText("Limpiar validación");
        panelBotones.add(btnLimpiarValidacion);

        btnLimpiarTodo.setText("Limpiar todo");
        btnLimpiarTodo.setPreferredSize(new Dimension(146, 27));
        panelBotones.add(btnLimpiarTodo);

        add(panelBotones, BorderLayout.PAGE_END);
    }// </editor-fold>//GEN-END:initComponents
    
    /**
     * 
     */
    private void initEvents() {
        btnLimpiarTodo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                eventBtnLimpiarTodo(evt);
            }
        });

        btnLimpiarValidacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                eventBtnLimpiarValidacion(evt);
            }
        });

        btnLoadScript.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                eventBtnLoadScript(evt);
            }
        });

        btnValidar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                eventBtnValidar(evt);
            }
        });

        btnSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                eventBtnSearch(evt);
            }
        });

        jComboBox1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                JComboBox comboBox = (JComboBox) event.getSource();

                Object selected = comboBox.getSelectedItem();
                if(selected.toString().equals("Item 1"))
                    System.out.println("Click en el primer elemento");
                else if(selected.toString().equals("Item 2"))
                    System.out.println("Click en el segundo elemento");
            }
        });

        jTabbedPane1.addChangeListener(new ChangeListener() {

            public void stateChanged(ChangeEvent e) {
                System.out.println("Click en la tab numero: "+jTabbedPane1.getSelectedIndex());
                switch(jTabbedPane1.getSelectedIndex()){
                    case 0 :
                        eventTabElementosValidar();
                        break;
                    case 1 :
                        eventTabElementosCorrectos();
                        break;
                    case 2 :
                        eventTabElementosNoGlosario();
                        break;
                    case 3 :
                        eventTabElementosErrores();
                        break;
                    case 4 :
                        eventTabExcepciones();
                        break;
                }
            }
        });
	}

    private void eventBtnLimpiarTodo(java.awt.event.MouseEvent evt) {
        System.out.println("Click boton limpiar todo");
        jTextArea1.setText(null);
        jTextField1.setText(null);
        jTextField2.setText(null);
        jTextField3.setText(null);
        jTextField4.setText(null);
        jTextField5.setText(null);
        jTextField6.setText(null);
        jTextField7.setText(null);
        jTextField8.setText(null);
        jComboBox1.setModel(new DefaultComboBoxModel<>());
    }

    private void eventBtnLimpiarValidacion(java.awt.event.MouseEvent evt) {
        System.out.println("Click boton limpiar validacion");
    }

    private void eventBtnLoadScript(java.awt.event.MouseEvent evt) {
        System.out.println("Click boton cargar script");
    }

    private void eventBtnValidar(java.awt.event.MouseEvent evt) {
        System.out.println("Click boton validar");
    }

    private void eventBtnSearch(java.awt.event.MouseEvent evt) {
        System.out.println("Click boton buscar");
    }

    private void eventTabElementosValidar(){
        System.out.println("Click en la tab elementos a validar ");
    }

    private void eventTabElementosCorrectos(){
        System.out.println("Click en la tab elementos correctos ");
    }

    private void eventTabElementosNoGlosario(){
        System.out.println("Click en la tab elementos que no estan en el glosario ");
    }

    private void eventTabElementosErrores(){
        System.out.println("Click en la tab elementos con errores ");
    }

    private void eventTabExcepciones(){
        System.out.println("Click en la tab excepciones ");
    }
}
