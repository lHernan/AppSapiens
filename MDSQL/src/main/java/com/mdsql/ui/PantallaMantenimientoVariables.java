/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mdsql.ui;

import java.util.Map;

import com.mdsql.ui.listener.PantallaMantenimientoVariablesListener;
import com.mdsql.utils.MDSQLConstants;
import com.mdval.ui.utils.DialogSupport;
import com.mdval.ui.utils.FrameSupport;

import lombok.Getter;

/**
 *
 * @author federico
 */
public class PantallaMantenimientoVariables extends DialogSupport {

	 	private static final long serialVersionUID = 1L;
	 
	 	// Variables declaration - do not modify//GEN-BEGIN:variables
	    private javax.swing.JLabel jLabel10;
	    private javax.swing.JLabel jLabel11;
	    private javax.swing.JLabel jLabel12;
	    private javax.swing.JLabel jLabel13;
	    private javax.swing.JLabel jLabel14;
	    private javax.swing.JLabel jLabel15;
	    private javax.swing.JLabel jLabel16;
	    private javax.swing.JLabel jLabel17;
	    private javax.swing.JLabel jLabel3;
	    private javax.swing.JLabel jLabel4;
	    private javax.swing.JLabel jLabel5;
	    private javax.swing.JLabel jLabel6;
	    private javax.swing.JLabel jLabel7;
	    private javax.swing.JLabel jLabel8;
	    private javax.swing.JLabel jLabel9;
	    private javax.swing.JScrollPane jScrollPane1;
	    
	    @Getter
	    private javax.swing.JTable tblMantenimientoHistorico;
	    
	    @Getter
	    private javax.swing.JTextField txtBBDD;
	    
	    @Getter
	    private javax.swing.JTextField txtCodigoVariable;
	    
	    @Getter
	    private javax.swing.JTextField txtComentario;
	    
	    @Getter
	    private javax.swing.JTextField txtFechaAlta;
	    
	    @Getter
	    private javax.swing.JTextField txtFechaModificacion;
	    
	    @Getter
	    private javax.swing.JTextField txtModeloProyecto;
	    
	    @Getter
	    private javax.swing.JTextField txtModeloProyecto1;
	    
	    @Getter
	    private javax.swing.JTextField txtPeticion;
	    
	    @Getter
	    private javax.swing.JTextField txtUsuarioAlta;
	    
	    @Getter
	    private javax.swing.JTextField txtUsuarioModificacion;
	    
	    @Getter
	    private javax.swing.JTextField txtValorVariable;
	    
	    @Getter
	    private javax.swing.JTextField txtValorVariable1;
	    
	    @Getter
	    private javax.swing.JButton btnBuscarModelo;
	    
	    @Getter
	    private javax.swing.JButton btnCancelar;
	    
	    @Getter
	    private javax.swing.JButton btnGuardar;
	    
	    @Getter
	    private javax.swing.JCheckBox chkHabilitada;
	    
	    @Getter
	    private javax.swing.JCheckBox chkUsoPermisos;
	    
	    @Getter
	    private javax.swing.JComboBox<String> cmbEntorno;
	    
	    @Getter
	    private javax.swing.JComboBox<String> cmbTipoVariable;
	    
	    @Getter
	    private javax.swing.JComboBox<String> cmbUsoInterno;
	    // End of variables declaration//GEN-END:variables

	    public PantallaMantenimientoVariables(FrameSupport parent, Boolean modal) {
			 super(parent, modal);
		 }

		 public PantallaMantenimientoVariables(FrameSupport parent, Boolean modal, Map<String, Object> params) {
			super(parent, modal, params);
		 }
	 
		 @Override
		 protected void setupComponents() {
			 	jLabel3 = new javax.swing.JLabel();
		        txtModeloProyecto = new javax.swing.JTextField();
		        btnCancelar = new javax.swing.JButton();
		        jLabel14 = new javax.swing.JLabel();
		        jLabel15 = new javax.swing.JLabel();
		        cmbTipoVariable = new javax.swing.JComboBox<>();
		        btnBuscarModelo = new javax.swing.JButton();
		        btnGuardar = new javax.swing.JButton();
		        jScrollPane1 = new javax.swing.JScrollPane();
		        tblMantenimientoHistorico = new javax.swing.JTable();
		        jLabel4 = new javax.swing.JLabel();
		        txtCodigoVariable = new javax.swing.JTextField();
		        chkHabilitada = new javax.swing.JCheckBox();
		        txtModeloProyecto1 = new javax.swing.JTextField();
		        jLabel10 = new javax.swing.JLabel();
		        txtPeticion = new javax.swing.JTextField();
		        jLabel16 = new javax.swing.JLabel();
		        cmbEntorno = new javax.swing.JComboBox<>();
		        jLabel5 = new javax.swing.JLabel();
		        txtValorVariable = new javax.swing.JTextField();
		        jLabel6 = new javax.swing.JLabel();
		        txtValorVariable1 = new javax.swing.JTextField();
		        jLabel7 = new javax.swing.JLabel();
		        txtBBDD = new javax.swing.JTextField();
		        chkUsoPermisos = new javax.swing.JCheckBox();
		        jLabel17 = new javax.swing.JLabel();
		        cmbUsoInterno = new javax.swing.JComboBox<>();
		        jLabel8 = new javax.swing.JLabel();
		        txtUsuarioAlta = new javax.swing.JTextField();
		        jLabel9 = new javax.swing.JLabel();
		        txtFechaAlta = new javax.swing.JTextField();
		        jLabel11 = new javax.swing.JLabel();
		        txtUsuarioModificacion = new javax.swing.JTextField();
		        jLabel12 = new javax.swing.JLabel();
		        txtFechaModificacion = new javax.swing.JTextField();
		        jLabel13 = new javax.swing.JLabel();
		        txtComentario = new javax.swing.JTextField();
		        
		        setBounds(1366, 768);
		        
		        jScrollPane1.setViewportView(tblMantenimientoHistorico);
		        
		        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		        getContentPane().setLayout(layout);
		        layout.setHorizontalGroup(
		            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		            .addGroup(layout.createSequentialGroup()
		                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		                    .addGroup(layout.createSequentialGroup()
		                        .addGap(91, 91, 91)
		                        .addComponent(jLabel14))
		                    .addGroup(layout.createSequentialGroup()
		                        .addGap(566, 566, 566)
		                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
		                .addGap(0, 919, Short.MAX_VALUE))
		            .addGroup(layout.createSequentialGroup()
		                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		                    .addGroup(layout.createSequentialGroup()
		                        .addGap(58, 58, 58)
		                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
		                            .addComponent(txtCodigoVariable, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
		                            .addGroup(layout.createSequentialGroup()
		                                .addComponent(jLabel16)
		                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
		                                .addComponent(cmbEntorno, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
		                            .addGroup(layout.createSequentialGroup()
		                                .addComponent(jLabel15)
		                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
		                                .addComponent(cmbTipoVariable, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
		                            .addGroup(layout.createSequentialGroup()
		                                .addComponent(jLabel10)
		                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
		                                .addComponent(txtPeticion, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)))
		                        .addGap(29, 29, 29)
		                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
		                            .addGroup(layout.createSequentialGroup()
		                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		                                    .addComponent(chkHabilitada)
		                                    .addComponent(chkUsoPermisos))
		                                .addGap(204, 204, 204))
		                            .addGroup(layout.createSequentialGroup()
		                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		                                    .addGroup(layout.createSequentialGroup()
		                                        .addGap(10, 10, 10)
		                                        .addComponent(jLabel5))
		                                    .addComponent(jLabel6))
		                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
		                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		                                    .addComponent(txtValorVariable1, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
		                                    .addComponent(txtValorVariable, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)))
		                            .addGroup(layout.createSequentialGroup()
		                                .addComponent(jLabel7)
		                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
		                                .addComponent(txtBBDD, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE))))
		                    .addGroup(layout.createSequentialGroup()
		                        .addGap(583, 583, 583)
		                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
		                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
		                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
		                    .addGroup(layout.createSequentialGroup()
		                        .addGap(24, 24, 24)
		                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
		                            .addComponent(jLabel3)
		                            .addComponent(jLabel4))
		                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
		                        .addComponent(txtModeloProyecto1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
		                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
		                        .addComponent(btnBuscarModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
		                        .addGap(18, 18, 18)
		                        .addComponent(txtModeloProyecto))
		                    .addGroup(layout.createSequentialGroup()
		                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
		                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1245, javax.swing.GroupLayout.PREFERRED_SIZE)
		                            .addGroup(layout.createSequentialGroup()
		                                .addComponent(jLabel13)
		                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
		                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
		                                    .addGroup(layout.createSequentialGroup()
		                                        .addComponent(jLabel17)
		                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
		                                        .addComponent(cmbUsoInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
		                                    .addGroup(layout.createSequentialGroup()
		                                        .addComponent(jLabel8)
		                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
		                                        .addComponent(txtUsuarioAlta, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE))
		                                    .addGroup(layout.createSequentialGroup()
		                                        .addComponent(jLabel9)
		                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
		                                        .addComponent(txtFechaAlta, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE))
		                                    .addGroup(layout.createSequentialGroup()
		                                        .addComponent(jLabel11)
		                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
		                                        .addComponent(txtUsuarioModificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE))
		                                    .addGroup(layout.createSequentialGroup()
		                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
		                                            .addGroup(layout.createSequentialGroup()
		                                                .addComponent(jLabel12)
		                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
		                                            .addGroup(layout.createSequentialGroup()
		                                                .addComponent(txtComentario, javax.swing.GroupLayout.PREFERRED_SIZE, 719, javax.swing.GroupLayout.PREFERRED_SIZE)
		                                                .addGap(171, 171, 171)))
		                                        .addComponent(txtFechaModificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
		                .addGap(298, 298, 298))
		        );
		        layout.setVerticalGroup(
		            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		            .addGroup(layout.createSequentialGroup()
		                .addGap(22, 22, 22)
		                .addComponent(jLabel14)
		                .addGap(18, 18, 18)
		                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		                    .addComponent(btnBuscarModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
		                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
		                        .addComponent(jLabel3)
		                        .addComponent(txtModeloProyecto1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
		                    .addComponent(txtModeloProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
		                .addGap(30, 30, 30)
		                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		                    .addGroup(layout.createSequentialGroup()
		                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		                            .addGroup(layout.createSequentialGroup()
		                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
		                                    .addComponent(jLabel4)
		                                    .addComponent(txtCodigoVariable, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
		                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
		                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
		                                    .addComponent(jLabel10)
		                                    .addComponent(txtPeticion, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
		                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
		                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
		                                    .addComponent(cmbTipoVariable, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
		                                    .addComponent(jLabel15))
		                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
		                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
		                                    .addComponent(cmbEntorno, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
		                                    .addComponent(jLabel16)))
		                            .addGroup(layout.createSequentialGroup()
		                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		                                    .addGroup(layout.createSequentialGroup()
		                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
		                                            .addComponent(jLabel5)
		                                            .addComponent(txtValorVariable, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
		                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
		                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
		                                            .addComponent(txtValorVariable1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
		                                            .addComponent(jLabel6)))
		                                    .addGroup(layout.createSequentialGroup()
		                                        .addGap(78, 78, 78)
		                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
		                                            .addComponent(txtBBDD, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
		                                            .addComponent(jLabel7))
		                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
		                                        .addComponent(chkHabilitada)))
		                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
		                                .addComponent(chkUsoPermisos)))
		                        .addGap(9, 9, 9)
		                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
		                            .addComponent(jLabel13)
		                            .addComponent(txtComentario, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
		                    .addGroup(layout.createSequentialGroup()
		                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
		                            .addComponent(cmbUsoInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
		                            .addComponent(jLabel17))
		                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
		                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
		                            .addComponent(jLabel8)
		                            .addComponent(txtUsuarioAlta, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
		                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
		                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
		                            .addComponent(jLabel9)
		                            .addComponent(txtFechaAlta, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
		                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
		                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
		                            .addComponent(jLabel11)
		                            .addComponent(txtUsuarioModificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
		                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
		                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
		                            .addComponent(jLabel12)
		                            .addComponent(txtFechaModificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))))
		                .addGap(18, 18, 18)
		                .addComponent(btnGuardar)
		                .addGap(26, 26, 26)
		                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
		                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
		                .addComponent(btnCancelar)
		                .addGap(23, 23, 23))
		        );
		 }
	 
		 @Override
		 protected void initEvents() {
			 PantallaMantenimientoVariablesListener actioListener = new PantallaMantenimientoVariablesListener(this);
			 
			 btnGuardar.setActionCommand(MDSQLConstants.PANTALLA_MANTENIMIENTO_VARIABLES_GUARDAR);
			 btnCancelar.setActionCommand(MDSQLConstants.PANTALLA_MANTENIMIENTO_VARIABLES_CANCELAR);
			 
			 btnGuardar.addActionListener(actioListener);
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
			 setTitle(literales.getLiteral("PantallaMantenimientoVariables.title"));

			 jLabel3.setText(literales.getLiteral("PantallaMantenimientoVariables.label3"));
			 btnCancelar.setText(literales.getLiteral("PantallaMantenimientoVariables.btnCancelar"));
			 jLabel15.setText(literales.getLiteral("PantallaMantenimientoVariables.jLabel15"));
			 btnGuardar.setText(literales.getLiteral("PantallaMantenimientoVariables.btnGuardar"));
			 jLabel4.setText(literales.getLiteral("PantallaMantenimientoVariables.label4"));
			 chkHabilitada.setText(literales.getLiteral("PantallaMantenimientoVariables.chkHabilitada"));
			 jLabel10.setText(literales.getLiteral("PantallaMantenimientoVariables.label10"));
			 jLabel16.setText(literales.getLiteral("PantallaMantenimientoVariables.jLabel16"));
			 jLabel5.setText(literales.getLiteral("PantallaMantenimientoVariables.jLabel5"));
			 jLabel6.setText(literales.getLiteral("PantallaMantenimientoVariables.jLabel6"));
			 jLabel7.setText(literales.getLiteral("PantallaMantenimientoVariables.jLabel7"));
			 chkUsoPermisos.setText(literales.getLiteral("PantallaMantenimientoVariables.chkUsoPermisos"));
			 jLabel17.setText(literales.getLiteral("PantallaMantenimientoVariables.jLabel17"));
			 jLabel8.setText(literales.getLiteral("PantallaMantenimientoVariables.jLabel8"));
			 jLabel9.setText(literales.getLiteral("PantallaMantenimientoVariables.jLabel9"));
			 jLabel11.setText(literales.getLiteral("PantallaMantenimientoVariables.jLabel11"));
			 jLabel12.setText(literales.getLiteral("PantallaMantenimientoVariables.jLabel12"));
		 }
	 
		 /**
			 * 
			 */
		public void enableButtons(Boolean val) {
			btnGuardar.setEnabled(val);
			btnCancelar.setEnabled(val);
		}
}
