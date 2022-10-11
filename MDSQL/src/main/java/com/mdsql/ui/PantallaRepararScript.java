/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mdsql.ui;

import java.util.Map;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.mdsql.ui.listener.PantallaRepararScriptListener;
import com.mdsql.utils.Constants;

/**
 *
 * @author USUARIO1
 */
public class PantallaRepararScript extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton btnAbrirScriptReprocesar;
    private JButton btnAbrirScriptReparar;
    private JButton btnAceptar;
    private JButton btnCancelar;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JRadioButton jRadioButton1;
    private JRadioButton jRadioButton2;
    private JRadioButton jRadioButton3;
    private JRadioButton jRadioButton4;
    private JScrollPane jScrollPane1;
    private JTextArea jTextArea1;
    private JTextField txtRutaReprocesar;
    private JTextField txtRutaReparacion;
    // End of variables declaration//GEN-END:variables
    
    private PantallaRepararScriptListener pantallaRepararScriptListener;
    
    public PantallaRepararScript(FrameSupport parent, Boolean modal) {
        super(parent, modal);
    }
    
    public PantallaRepararScript(FrameSupport parent, Boolean modal, Map<String, Object> params) {
        super(parent, modal, params);
    }
    
    @Override
   	protected void setupComponents() {
    	jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        btnAbrirScriptReprocesar = new javax.swing.JButton();
        txtRutaReprocesar = new javax.swing.JTextField();
        jRadioButton2 = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        btnAbrirScriptReparar = new javax.swing.JButton();
        txtRutaReparacion = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        
        GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jRadioButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAbrirScriptReprocesar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtRutaReprocesar, javax.swing.GroupLayout.PREFERRED_SIZE, 611, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jRadioButton2))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton1)
                    .addComponent(btnAbrirScriptReprocesar)
                    .addComponent(txtRutaReprocesar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jRadioButton2)
                .addContainerGap(19, Short.MAX_VALUE))
        );
    }
    
    @Override
   	protected void initEvents() {
    	pantallaRepararScriptListener = new PantallaRepararScriptListener(this);
    	
    	btnAceptar.setActionCommand(Constants.PANTALLA_REPARAR_SCRIPT_BTN_ACEPTAR);
    	btnCancelar.setActionCommand(Constants.PANTALLA_REPARAR_SCRIPT_BTN_CANCELAR);
    	
    	btnAceptar.addActionListener(pantallaRepararScriptListener);
    	btnCancelar.addActionListener(pantallaRepararScriptListener);
    	
    	this.addOnLoadListener(pantallaRepararScriptListener);
    }
    
    @Override
	protected void initModels() {
    	
    }
    
    @Override
   	protected void initialState() {}

   	@Override
   	protected void setupLiterals() {
   		setTitle("Reparar Script");
   		
   		jLabel1.setText("NombreScript.sql");
        jLabel2.setText("Reprocasar Script");
        jLabel3.setText("Se debe espacificar si la reparacion implica reprocesar el script.");
        jLabel4.setText("En tal caso, se volverá a leer el fichero y enviar la información a la lógica de negocio para que reprocese los scripts, generando de nuevo los scripts resultantes.");
        jLabel5.setText("Los scripts con estado Ejecutado, no se cambiaran en su estado.");
        jRadioButton1.setText("Si, se debe reprocesar el script");
        btnAbrirScriptReprocesar.setText("jbutton1");
        jRadioButton2.setText("No, no debe reprocesar el script");
        jRadioButton3.setText("Ejecutar script procesado");
        jRadioButton4.setText("Ejecutar script reparación");
        btnAbrirScriptReparar.setText("jbutton1");
        jLabel6.setText("Script Reparación");
        jLabel7.setText("Comentario");
        btnAceptar.setText("ACEPTAR");
        btnCancelar.setText("CANCELAR");
   	}
}
