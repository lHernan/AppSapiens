/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mdsql.ui;

import java.util.Map;

import com.mdsql.ui.listener.PantallaMantenimientoHistoricoListener;
import com.mdsql.ui.listener.PantallaPermisosGeneralesporModeloporTipoObjetoListener;
import com.mdsql.utils.MDSQLConstants;
import com.mdval.ui.utils.DialogSupport;
import com.mdval.ui.utils.FrameSupport;

import lombok.Getter;

/**
 *
 * @author federico
 */
public class PantallaMantenimientoHistorico extends DialogSupport {

	private static final long serialVersionUID = 1L;
	
	// Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    
    @Getter
    private javax.swing.JTable tblMantenimientoHistorico;
    
    @Getter
    private javax.swing.JTextField txtPeticion;
    
    @Getter
    private javax.swing.JButton btnAlta;
    
    @Getter
    private javax.swing.JButton btnBaja;
    
    @Getter
    private javax.swing.JButton btnBuscar;
    
    @Getter
    private javax.swing.JButton btnBuscarModelo;
    
    @Getter
    private javax.swing.JButton btnCancelar;
    
    @Getter
    private javax.swing.JButton btnInforme;
    
    @Getter
    private javax.swing.JComboBox<String> cmbTipoObjeto;
    // End of variables declaration//GEN-END:variables
	
    public PantallaMantenimientoHistorico(FrameSupport parent, Boolean modal) {
		 super(parent, modal);
	 }

	 public PantallaMantenimientoHistorico(FrameSupport parent, Boolean modal, Map<String, Object> params) {
		super(parent, modal, params);
	 }
	 
	 @Override
	 protected void setupComponents() {
		 	jLabel3 = new javax.swing.JLabel();
	        txtPeticion = new javax.swing.JTextField();
	        btnInforme = new javax.swing.JButton();
	        btnCancelar = new javax.swing.JButton();
	        jLabel14 = new javax.swing.JLabel();
	        jLabel15 = new javax.swing.JLabel();
	        cmbTipoObjeto = new javax.swing.JComboBox<>();
	        btnBuscarModelo = new javax.swing.JButton();
	        btnBuscar = new javax.swing.JButton();
	        btnAlta = new javax.swing.JButton();
	        btnBaja = new javax.swing.JButton();
	        jScrollPane1 = new javax.swing.JScrollPane();
	        tblMantenimientoHistorico = new javax.swing.JTable();
	        
	        setBounds(1366, 768);
	        
	        jScrollPane1.setViewportView(tblMantenimientoHistorico);
	        
	        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
	        getContentPane().setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addGroup(layout.createSequentialGroup()
	                        .addGap(153, 153, 153)
	                        .addComponent(jLabel3)
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                        .addComponent(txtPeticion, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                        .addComponent(btnBuscarModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addGap(73, 73, 73)
	                        .addComponent(jLabel15)
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                        .addComponent(cmbTipoObjeto, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
	                    .addGroup(layout.createSequentialGroup()
	                        .addGap(585, 585, 585)
	                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
	                    .addGroup(layout.createSequentialGroup()
	                        .addGap(397, 397, 397)
	                        .addComponent(btnAlta, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                        .addComponent(btnBaja, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                        .addComponent(btnInforme, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
	                    .addGroup(layout.createSequentialGroup()
	                        .addGap(37, 37, 37)
	                        .addComponent(jLabel14))
	                    .addGroup(layout.createSequentialGroup()
	                        .addGap(86, 86, 86)
	                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1199, Short.MAX_VALUE)))
	                .addGap(100, 100, 100))
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addGap(22, 22, 22)
	                .addComponent(jLabel14)
	                .addGap(14, 14, 14)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
	                    .addComponent(cmbTipoObjeto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addGroup(layout.createSequentialGroup()
	                        .addComponent(jLabel15)
	                        .addGap(4, 4, 4))
	                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                        .addComponent(txtPeticion, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addComponent(jLabel3)
	                        .addComponent(btnBuscarModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
	                .addGap(32, 32, 32)
	                .addComponent(btnBuscar)
	                .addGap(18, 18, 18)
	                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
	                .addGap(35, 35, 35)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(btnInforme)
	                    .addComponent(btnCancelar)
	                    .addComponent(btnAlta)
	                    .addComponent(btnBaja))
	                .addGap(45, 45, 45))
	        );

	 }
	
	 @Override
	 protected void initEvents() {
		 PantallaMantenimientoHistoricoListener actioListener = new PantallaMantenimientoHistoricoListener(this);
		 
		 btnBuscarModelo.setActionCommand(MDSQLConstants.PANTALLA_MANTENIMIENTO_HISTORICO_BUSCAR_MODELO);
		 btnBuscar.setActionCommand(MDSQLConstants.PANTALLA_MANTENIMIENTO_HISTORICO_BUSCAR);
		 btnAlta.setActionCommand(MDSQLConstants.PANTALLA_MANTENIMIENTO_HISTORICO_ALTA);
		 btnBaja.setActionCommand(MDSQLConstants.PANTALLA_MANTENIMIENTO_HISTORICO_BAJA);
		 btnInforme.setActionCommand(MDSQLConstants.PANTALLA_MANTENIMIENTO_HISTORICO_INFORME);
		 btnCancelar.setActionCommand(MDSQLConstants.PANTALLA_MANTENIMIENTO_HISTORICO_CANCELAR);
		 
		 btnBuscarModelo.addActionListener(actioListener);
		 btnBuscar.addActionListener(actioListener);
		 btnAlta.addActionListener(actioListener);
		 btnBaja.addActionListener(actioListener);
		 btnInforme.addActionListener(actioListener);
		 btnCancelar.addActionListener(actioListener);
	 }
	
	 @SuppressWarnings("unchecked")
	 @Override
	 protected void initModels() {
		 
	 }
	 
	 @Override
	 protected void initialState() {
		 
	 }
	 
	 @Override
	 protected void setupLiterals() {
		 setTitle(literales.getLiteral("PantallaMantenimientoHistorico.titulo"));

		 jLabel3.setText(literales.getLiteral("PantallaMantenimientoHistorico.titulo.jLabel3"));
		 btnInforme.setText(literales.getLiteral("PantallaMantenimientoHistorico.titulo.btnInforme"));
		 btnCancelar.setText(literales.getLiteral("PantallaMantenimientoHistorico.titulo.btnCancelar"));
		 jLabel15.setText(literales.getLiteral("PantallaMantenimientoHistorico.titulo.jLabel15"));
		 btnBuscar.setText(literales.getLiteral("PantallaMantenimientoHistorico.titulo.btnBuscar"));
		 btnAlta.setText(literales.getLiteral("PantallaMantenimientoHistorico.titulo.btnAlta"));
		 btnBaja.setText(literales.getLiteral("PantallaMantenimientoHistorico.titulo.btnBaja"));
	 }
	
	 /**
		 * 
		 */
	public void enableButtons(Boolean val) {
		btnBuscarModelo.setEnabled(val);
		btnBuscar.setEnabled(val);
		btnAlta.setEnabled(val);
		btnBaja.setEnabled(val);
		btnInforme.setEnabled(val);
		btnCancelar.setEnabled(val);
	}
}