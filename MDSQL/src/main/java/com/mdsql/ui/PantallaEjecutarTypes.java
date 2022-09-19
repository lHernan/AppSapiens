/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mdsql.ui;

import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.mdsql.ui.listener.PantallaEjecutarTypesActionListener;
import com.mdsql.ui.model.DefinicionTypesTableModel;
import com.mdsql.ui.model.cabeceras.Cabecera;
import com.mdsql.ui.utils.MDSQLUIHelper;
import com.mdsql.utils.Constants;
import com.mdval.ui.utils.FrameSupport;

import lombok.Getter;
/**
 *
 * @author USUARIO1
 */
public class PantallaEjecutarTypes extends FrameSupport {
	
	 /**
	  * 
	  */
    private static final long serialVersionUID = 1L;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton btnRechazar;
    private JButton btnVerCuadres;
    private JButton btnVerErrores;
    private JButton btnAceptar;
    private JButton btnCancelar;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JScrollPane jScrollPane1;
    private JTable tblTypes;
    @Getter
    private JTextField jTextField1;

    @Getter
    private JTextField jTextField2;

    @Getter
    private JTextField jTextField3;

    @Getter
    private JTextField jTextField4;

    @Getter
    private JTextField jTextField5;

    @Getter
    private JTextField jTextField6;

    @Getter
    private JTextField jTextField7;
    // End of variables declaration//GEN-END:variables
    
    public PantallaEjecutarTypes(FrameSupport parent) {
    	super(parent);
    }
    
    public PantallaEjecutarTypes(FrameSupport parent, Map<String, Object> params) {
    	super(parent, params);
    }
    
    public void setupComponents() {
        
    	 jLabel1 = new javax.swing.JLabel();
         jTextField1 = new javax.swing.JTextField();
         jLabel2 = new javax.swing.JLabel();
         jTextField2 = new javax.swing.JTextField();
         jLabel3 = new javax.swing.JLabel();
         jTextField3 = new javax.swing.JTextField();
         jLabel4 = new javax.swing.JLabel();
         jTextField4 = new javax.swing.JTextField();
         jLabel5 = new javax.swing.JLabel();
         jTextField5 = new javax.swing.JTextField();
         jLabel6 = new javax.swing.JLabel();
         jTextField6 = new javax.swing.JTextField();
         jLabel7 = new javax.swing.JLabel();
         jTextField7 = new javax.swing.JTextField();
         btnRechazar = new javax.swing.JButton();
         btnVerCuadres = new javax.swing.JButton();
         btnVerErrores = new javax.swing.JButton();
         jScrollPane1 = new javax.swing.JScrollPane();
         tblTypes = new javax.swing.JTable();
         btnAceptar = new javax.swing.JButton();
         btnCancelar = new javax.swing.JButton();

         jScrollPane1.setViewportView(tblTypes);
         
         GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
         getContentPane().setLayout(layout);
         layout.setHorizontalGroup(
             layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
             .addGroup(layout.createSequentialGroup()
                 .addGap(43, 43, 43)
                 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                     .addGroup(layout.createSequentialGroup()
                         .addComponent(jLabel7)
                         .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                         .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                     .addGroup(layout.createSequentialGroup()
                         .addComponent(jLabel6)
                         .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                         .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                     .addGroup(layout.createSequentialGroup()
                         .addComponent(jLabel5)
                         .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                         .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                     .addGroup(layout.createSequentialGroup()
                         .addComponent(jLabel4)
                         .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                         .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                     .addGroup(layout.createSequentialGroup()
                         .addComponent(jLabel3)
                         .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                         .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                     .addGroup(layout.createSequentialGroup()
                         .addComponent(jLabel2)
                         .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                         .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                     .addGroup(layout.createSequentialGroup()
                         .addComponent(jLabel1)
                         .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                         .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                     .addGroup(layout.createSequentialGroup()
                         .addComponent(btnRechazar)
                         .addGap(18, 18, 18)
                         .addComponent(btnVerCuadres)
                         .addGap(18, 18, 18)
                         .addComponent(btnVerErrores)))
                 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                 .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 594, javax.swing.GroupLayout.PREFERRED_SIZE)
                 .addGap(17, 17, 17))
             .addGroup(layout.createSequentialGroup()
                 .addGap(439, 439, 439)
                 .addComponent(btnAceptar)
                 .addGap(18, 18, 18)
                 .addComponent(btnCancelar)
                 .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
         );
         layout.setVerticalGroup(
             layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
             .addGroup(layout.createSequentialGroup()
                 .addGap(29, 29, 29)
                 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(layout.createSequentialGroup()
                         .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                             .addComponent(jLabel1)
                             .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                         .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                         .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                             .addComponent(jLabel2)
                             .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                         .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                         .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                             .addComponent(jLabel3)
                             .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                         .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                         .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                             .addComponent(jLabel4)
                             .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                         .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                         .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                             .addComponent(jLabel5)
                             .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                         .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                         .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                             .addComponent(jLabel6)
                             .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                         .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                         .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                             .addComponent(jLabel7)
                             .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                         .addGap(18, 18, 18)
                         .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                             .addComponent(btnRechazar)
                             .addComponent(btnVerCuadres)
                             .addComponent(btnVerErrores)))
                     .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                 .addGap(18, 18, 18)
                 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                     .addComponent(btnAceptar)
                     .addComponent(btnCancelar))
                 .addContainerGap(19, Short.MAX_VALUE))
         );
    }

    @Override
    private void initEvents() {      
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
    	tblTypes.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null}
                },
                new String [] {
                    "Orden", "Estado", "Fecha", "Ejecución", "TYS", "TYB", "PDC", "Objeto Type"
                }
            ));
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
