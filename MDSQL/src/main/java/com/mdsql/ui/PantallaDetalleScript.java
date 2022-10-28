/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mdsql.ui;

import java.util.Map;

import javax.swing.GroupLayout;

import com.mdsql.ui.listener.PantallaDetalleScriptListener;

/**
 *
 * @author USUARIO1
 */
public class PantallaDetalleScript extends DialogSupport {

    private static final long serialVersionUID = 1L;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblDetalle;
    // End of variables declaration//GEN-END:variables
    
    private PantallaDetalleScriptListener pantallaDetalleScriptListener;
    
    public PantallaDetalleScript(FrameSupport parent, Boolean modal) {
        super(parent, modal);
    }
    
    public PantallaDetalleScript(FrameSupport parent, Boolean modal, Map<String, Object> params) {
        super(parent, modal, params);
    }
    
    @Override
   	protected void setupComponents() {
    	jScrollPane1 = new javax.swing.JScrollPane();
        tblDetalle = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        
        GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jScrollPane1)
                .addGap(22, 22, 22))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(468, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(442, 442, 442))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap(12, Short.MAX_VALUE))
        );

    }
    
    @Override
   	protected void initEvents() {
    	
    }
    
    @Override
	protected void initModels() {
    	
    }
    
    @Override
   	protected void initialState() {}

   	@Override
   	protected void setupLiterals() {
   		jButton1.setText("CANCELAR");
   	}
   	
   	@Override
	protected void initMenuBar() {}
       
}
