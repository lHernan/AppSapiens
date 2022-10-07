/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mdsql.ui;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.table.DefaultTableModel;

import com.mdsql.ui.listener.PantallaEjecutarTypesActionListener;
import com.mdsql.utils.Constants;
import com.mdval.ui.utils.DialogSupport;
import com.mdval.ui.utils.FrameSupport;
/**
 *
 * @author USUARIO1
 */

import lombok.Getter;

public class PantallaEjecutarTypes extends DialogSupport {
	
	 /**
	  * 
	  */
    private static final long serialVersionUID = 1L;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JScrollPane jScrollPane1;

    @Getter
	private JTextField txtEstadoEjecucion;

    @Getter
	private JTextField txtModelo;

    @Getter
	private JTable tblTypes;

    @Getter
	private JTextField txtSubmodelo;

    @Getter
	private JTextField txtSD;

    @Getter
	private JTextField txtSolicitadaPor;

    @Getter
	private JTextField txtEsquema;

    @Getter
	private JTextField txtBBDD;
    
    @Getter
    private JButton btnRechazar;
    
    @Getter
    private JButton btnVerCuadres;
    
    @Getter
    private JButton btnVerErrores;
    
    @Getter
    private JButton btnAceptar;
    
    @Getter
    private JButton btnCancelar;
    
    // End of variables declaration//GEN-END:variables
    
    public PantallaEjecutarTypes(FrameSupport parent, Boolean modal) {
    	super(parent, modal);
    }
    
    public PantallaEjecutarTypes(FrameSupport parent, Boolean modal, Map<String, Object> params) {
    	super(parent, modal, params);
    }
    
    public void setupComponents() {
        
    	jLabel1 = new JLabel();
        txtEstadoEjecucion = new JTextField();
        jLabel2 = new JLabel();
        txtModelo = new JTextField();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        jLabel5 = new JLabel();
        jLabel6 = new JLabel();
        jLabel7 = new JLabel();
        btnRechazar = new JButton();
        btnVerCuadres = new JButton();
        btnVerErrores = new JButton();
        jScrollPane1 = new JScrollPane();
        tblTypes = new JTable();
        btnAceptar = new JButton();
        btnCancelar = new JButton();
        txtSubmodelo = new JTextField();
        txtSD = new JTextField();
        txtSolicitadaPor = new JTextField();
        txtEsquema = new JTextField();
        txtBBDD = new JTextField();
        
        setPreferredSize(new Dimension(1297, 758));
        setResizable(Boolean.TRUE);
        
        jScrollPane1.setViewportView(tblTypes);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtModelo, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtEstadoEjecucion, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSubmodelo, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSD, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSolicitadaPor, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtEsquema, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtBBDD, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnRechazar)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnVerCuadres)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnVerErrores)))
                        .addGap(39, 39, 39)
                        .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 632, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAceptar)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancelar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(txtEstadoEjecucion, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(txtModelo, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSubmodelo, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSD, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSolicitadaPor, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEsquema, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(txtBBDD, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(btnVerErrores)
                            .addComponent(btnVerCuadres)
                            .addComponent(btnRechazar))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 456, Short.MAX_VALUE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar)
                    .addComponent(btnCancelar))
                .addContainerGap())
        );
    }

    @Override
    protected void initEvents() {      
    	ActionListener actionListener = new PantallaEjecutarTypesActionListener(this);
    	
    	btnRechazar.setActionCommand(Constants.PANTALLA_EJECUTAR_TYPES_BTN_RECHAZAR);
    	btnVerCuadres.setActionCommand(Constants.PANTALLA_EJECUTAR_TYPES_BTN_VER_CUADRES);
    	btnVerErrores.setActionCommand(Constants.PANTALLA_EJECUTAR_TYPES_BTN_VER_ERRORES);
    	btnAceptar.setActionCommand(Constants.PANTALLA_EJECUTAR_TYPES_BTN_ACEPTAR);
    	btnCancelar.setActionCommand(Constants.PANTALLA_EJECUTAR_TYPES_BTN_CANCELAR);
    	
    	btnRechazar.addActionListener(actionListener);
    	btnVerCuadres.addActionListener(actionListener);
    	btnVerErrores.addActionListener(actionListener);
    	btnAceptar.addActionListener(actionListener);
    	btnCancelar.addActionListener(actionListener);
    }
    
    @Override
    protected void initModels() {
    	tblTypes.setModel(new DefaultTableModel(
                new Object [][] {
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null}
                },
                new String [] {
                    "Orden", "Estado", "Fecha", "Ejecución", "TYS", "TYB", "PDC", "Objeto Type"
                }
            ) {
                Class[] types = new Class [] {
                    java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
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
    	jLabel1.setText("Estado de ejecución");
        jLabel2.setText("Modelo o proyecto");
        jLabel3.setText("Submodelo");
        jLabel4.setText("SD");
        jLabel5.setText("Solicitada por");
        jLabel6.setText("Esquema");
        jLabel7.setText("BBDD");
        btnRechazar.setText("Rechazar");
        btnVerCuadres.setText("Ver cuadres");
        btnVerErrores.setText("Ver Errores");
        btnAceptar.setText("ACEPTAR");
        btnCancelar.setText("CANCELAR");
    }
    
}
