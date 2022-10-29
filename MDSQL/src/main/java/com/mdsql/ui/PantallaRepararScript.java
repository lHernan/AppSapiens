/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mdsql.ui;

import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

import com.mdsql.bussiness.entities.Script;
import com.mdsql.ui.listener.PantallaRepararScriptListener;
import com.mdsql.utils.Constants;
import com.mdval.ui.utils.DialogSupport;
import com.mdval.ui.utils.FrameSupport;

/**
 *
 * @author USUARIO1
 */
public class PantallaRepararScript extends DialogSupport {

    private static final long serialVersionUID = 1L;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
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
    // End of variables declaration//GEN-END:variables
    
    private PantallaRepararScriptListener pantallaRepararScriptListener;

	private JButton btnAbrirFichero;

	private JTextField txtScript;

	private JButton btnAbrirFicheroReparacion;

	private JTextField txtScriptReparacion;
    
    public PantallaRepararScript(FrameSupport parent, Boolean modal) {
        super(parent, modal);
    }
    
    public PantallaRepararScript(FrameSupport parent, Boolean modal, Map<String, Object> params) {
        super(parent, modal, params);
    }
    
    @Override
   	protected void setupComponents() {
    	jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jPanel1 = new JPanel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        jLabel5 = new JLabel();
        jRadioButton1 = new JRadioButton();
        btnAbrirFichero = new JButton();
        txtScript = new JTextField();
        jRadioButton2 = new JRadioButton();
        jPanel2 = new JPanel();
        jRadioButton3 = new JRadioButton();
        jRadioButton4 = new JRadioButton();
        btnAbrirFicheroReparacion = new JButton();
        txtScriptReparacion = new JTextField();
        jLabel6 = new JLabel();
        jLabel7 = new JLabel();
        jScrollPane1 = new JScrollPane();
        jTextArea1 = new JTextArea();
        btnAceptar = new JButton();
        btnCancelar = new JButton();

        jPanel1.setBorder(BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnAbrirFichero.setIcon(new ImageIcon(getClass().getResource("/folder-open.png"))); // NOI18N
        
        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jRadioButton1)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAbrirFichero)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtScript, GroupLayout.PREFERRED_SIZE, 611, GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jRadioButton2))
                .addContainerGap(65, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton1)
                    .addComponent(btnAbrirFichero)
                    .addComponent(txtScript, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton2)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnAbrirFicheroReparacion.setIcon(new ImageIcon(getClass().getResource("/folder-open.png"))); // NOI18N
        
        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButton3)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jRadioButton4)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAbrirFicheroReparacion)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtScriptReparacion, GroupLayout.PREFERRED_SIZE, 633, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jRadioButton3)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(txtScriptReparacion)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(btnAbrirFicheroReparacion)
                            .addComponent(jRadioButton4))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);
        
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1))
                    .addComponent(jPanel2, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel2))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(494, 494, 494))
            .addGroup(layout.createSequentialGroup()
                .addGap(344, 344, 344)
                .addComponent(btnAceptar, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar)
                    .addComponent(btnCancelar))
                .addContainerGap())
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
   		
   		Script script = (Script) getParams().get("script");
   		
   		jLabel1.setText(script.getNombreScript());
        jLabel2.setText("Reprocesar Script");
        jLabel3.setText("Se debe espacificar si la reparacion implica reprocesar el script.");
        jLabel4.setText("En tal caso, se volverá a leer el fichero y enviar la información a la lógica de negocio para que reprocese los scripts, generando de nuevo los scripts resultantes.");
        jLabel5.setText("Los scripts con estado Ejecutado, no se cambiaran en su estado.");
        jRadioButton1.setText("Si, se debe reprocesar el script");
        jRadioButton2.setText("No, no debe reprocesar el script");
        jRadioButton3.setText("Ejecutar script procesado");
        jRadioButton4.setText("Ejecutar script reparación");
        jLabel6.setText("Script Reparación");
        jLabel7.setText("Comentario");
        btnAceptar.setText("ACEPTAR");
        btnCancelar.setText("CANCELAR");
   	}
}
