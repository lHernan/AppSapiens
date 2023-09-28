/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mdsql.ui;

import java.awt.event.ActionListener;
import java.util.Map;

import com.mdsql.ui.listener.PantallaDetallePermisosPorObjetoListener;
import com.mdsql.utils.MDSQLConstants;
import com.mdval.ui.utils.DialogSupport;
import com.mdval.ui.utils.FrameSupport;

import lombok.Getter;

/**
 *
 * @author federico
 */
public class PantallaDetallePermisosPorObjeto extends DialogSupport {

	private static final long serialVersionUID = 1L;
	
	// Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    
    @Getter
    private javax.swing.JTable tblPermisos;
    
    @Getter
    private javax.swing.JTable tblUltimasPeticiones;
    
    @Getter
    private javax.swing.JTextField txtFuncionNombre;
    
    @Getter
    private javax.swing.JTextField txtModelo1;
    
    @Getter
    private javax.swing.JTextField txtModeloProyecto;
    
    @Getter
    private javax.swing.JTextField txtNombreObjeto;
    
    @Getter
    private javax.swing.JTextField txtPropietarioSinonimo;
    
    @Getter
    private javax.swing.JTextField txtReceptorPermisos;
    
    @Getter
    private javax.swing.JButton btnAlta;
    
    @Getter
    private javax.swing.JButton btnCancelar;
    
    @Getter
    private javax.swing.JButton btnGuardar;
    
    @Getter
    private javax.swing.JButton btnModificacion;
    
    @Getter
    private javax.swing.JButton btnInforme;
    
    @Getter
    private javax.swing.JComboBox<String> cmbEntorno;
    
    @Getter
    private javax.swing.JComboBox<String> cmbIncluirPDC;
    
    @Getter
    private javax.swing.JComboBox<String> cmbIncluirPDC1;
    
    @Getter
    private javax.swing.JComboBox<String> cmbPermiso;
    
    @Getter
    private javax.swing.JComboBox<String> cmbPermisoSinonimo;
    
    @Getter
    private javax.swing.JComboBox<String> cmbWithGrantOpcion;
    
    @Getter
    private javax.swing.JCheckBox jCheckBox1;
    // End of variables declaration//GEN-END:variables

    public PantallaDetallePermisosPorObjeto(FrameSupport parent, Boolean modal) {
		 super(parent, modal);
	 }

	 public PantallaDetallePermisosPorObjeto(FrameSupport parent, Boolean modal, Map<String, Object> params) {
		super(parent, modal, params);
	 }
    
	 @Override
	 protected void setupComponents() {
		 jLabel1 = new javax.swing.JLabel();
	     jLabel2 = new javax.swing.JLabel();
	     jLabel6 = new javax.swing.JLabel();
	     txtModeloProyecto = new javax.swing.JTextField();
	     cmbPermisoSinonimo = new javax.swing.JComboBox<>();
	     cmbEntorno = new javax.swing.JComboBox<>();
	     btnGuardar = new javax.swing.JButton();
	     jLabel11 = new javax.swing.JLabel();
	     jScrollPane2 = new javax.swing.JScrollPane();
	     tblPermisos = new javax.swing.JTable();
	     jLabel12 = new javax.swing.JLabel();
	     jScrollPane3 = new javax.swing.JScrollPane();
	     tblUltimasPeticiones = new javax.swing.JTable();
	     btnInforme = new javax.swing.JButton();
	     btnCancelar = new javax.swing.JButton();
	     jLabel14 = new javax.swing.JLabel();
	     txtModelo1 = new javax.swing.JTextField();
	     jLabel16 = new javax.swing.JLabel();
	     cmbPermiso = new javax.swing.JComboBox<>();
	     jLabel20 = new javax.swing.JLabel();
	     cmbWithGrantOpcion = new javax.swing.JComboBox<>();
	     jLabel4 = new javax.swing.JLabel();
	     txtNombreObjeto = new javax.swing.JTextField();
	     txtPropietarioSinonimo = new javax.swing.JTextField();
	     jLabel3 = new javax.swing.JLabel();
	     txtFuncionNombre = new javax.swing.JTextField();
	     jLabel5 = new javax.swing.JLabel();
	     txtReceptorPermisos = new javax.swing.JTextField();
	     jLabel7 = new javax.swing.JLabel();
	     jLabel17 = new javax.swing.JLabel();
	     cmbIncluirPDC = new javax.swing.JComboBox<>();
	     jLabel18 = new javax.swing.JLabel();
	     cmbIncluirPDC1 = new javax.swing.JComboBox<>();
	     jLabel8 = new javax.swing.JLabel();
	     jCheckBox1 = new javax.swing.JCheckBox();
	     btnModificacion = new javax.swing.JButton();
	     btnAlta = new javax.swing.JButton();
	     
	     setBounds(1366, 768);
	     
	     jScrollPane2.setViewportView(tblPermisos);
	     
	     jScrollPane3.setViewportView(tblUltimasPeticiones);
	     
	     javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
	        getContentPane().setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addGap(25, 25, 25)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addGroup(layout.createSequentialGroup()
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                            .addComponent(jLabel11)
	                            .addComponent(jScrollPane2)
	                            .addComponent(jLabel12)
	                            .addComponent(jScrollPane3))
	                        .addGap(39, 39, 39))
	                    .addGroup(layout.createSequentialGroup()
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                            .addComponent(jLabel14)
	                            .addGroup(layout.createSequentialGroup()
	                                .addComponent(jLabel1)
	                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                                .addComponent(txtModelo1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                                .addComponent(txtModeloProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, 1022, javax.swing.GroupLayout.PREFERRED_SIZE))
	                            .addGroup(layout.createSequentialGroup()
	                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
	                                    .addGroup(layout.createSequentialGroup()
	                                        .addGap(18, 18, 18)
	                                        .addComponent(jLabel4)
	                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                                        .addComponent(txtNombreObjeto))
	                                    .addGroup(layout.createSequentialGroup()
	                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
	                                            .addGroup(layout.createSequentialGroup()
	                                                .addComponent(jLabel7)
	                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                                                .addComponent(txtReceptorPermisos, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
	                                            .addGroup(layout.createSequentialGroup()
	                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
	                                                    .addGroup(layout.createSequentialGroup()
	                                                        .addComponent(jLabel6)
	                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                                                        .addComponent(cmbEntorno, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE))
	                                                    .addGroup(layout.createSequentialGroup()
	                                                        .addComponent(jLabel2)
	                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                                                        .addComponent(cmbPermisoSinonimo, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
	                                                .addGap(18, 18, 18)
	                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
	                                                    .addComponent(jLabel3)
	                                                    .addComponent(jLabel5))
	                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                                                    .addComponent(txtPropietarioSinonimo, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                                    .addComponent(txtFuncionNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))))
	                                        .addGap(6, 6, 6)))
	                                .addGap(34, 34, 34)
	                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                                    .addGroup(layout.createSequentialGroup()
	                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
	                                            .addComponent(jLabel18)
	                                            .addComponent(jLabel17)
	                                            .addComponent(jLabel16))
	                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
	                                            .addComponent(cmbIncluirPDC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                            .addComponent(cmbIncluirPDC1, 0, 300, Short.MAX_VALUE)
	                                            .addComponent(cmbPermiso, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
	                                    .addGroup(layout.createSequentialGroup()
	                                        .addGap(19, 19, 19)
	                                        .addComponent(jLabel8)
	                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                                        .addComponent(jCheckBox1))))
	                            .addGroup(layout.createSequentialGroup()
	                                .addGap(423, 423, 423)
	                                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
	                        .addContainerGap(40, Short.MAX_VALUE))))
	            .addGroup(layout.createSequentialGroup()
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addGroup(layout.createSequentialGroup()
	                        .addContainerGap()
	                        .addComponent(jLabel20)
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                        .addComponent(cmbWithGrantOpcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                    .addGroup(layout.createSequentialGroup()
	                        .addGap(380, 380, 380)
	                        .addComponent(btnAlta, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                        .addComponent(btnModificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                        .addComponent(btnInforme, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
	                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addGap(10, 10, 10)
	                .addComponent(jLabel14)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(txtModeloProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(txtModelo1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(jLabel1))
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(txtNombreObjeto, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(jLabel4)
	                    .addComponent(cmbIncluirPDC1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(jLabel18))
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(cmbPermisoSinonimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(txtPropietarioSinonimo, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(jLabel3)
	                    .addComponent(jLabel2)
	                    .addComponent(cmbIncluirPDC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(jLabel17))
	                .addGap(6, 6, 6)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(cmbEntorno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(jLabel6)
	                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                        .addComponent(txtFuncionNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addComponent(jLabel5)
	                        .addComponent(cmbPermiso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addComponent(jLabel16)))
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(cmbWithGrantOpcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(jLabel20)
	                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                        .addComponent(txtReceptorPermisos, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addComponent(jLabel7)
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                            .addComponent(jLabel8)
	                            .addComponent(jCheckBox1))))
	                .addGap(38, 38, 38)
	                .addComponent(btnGuardar)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addComponent(jLabel11)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addGap(18, 18, 18)
	                .addComponent(jLabel12)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
	                .addGap(33, 33, 33)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(btnCancelar)
	                    .addComponent(btnInforme)
	                    .addComponent(btnModificacion)
	                    .addComponent(btnAlta))
	                .addGap(36, 36, 36))
	        ); 
	 }
    
	 @Override
	 protected void initEvents() {
		 PantallaDetallePermisosPorObjetoListener actioListener = new PantallaDetallePermisosPorObjetoListener(this);
		 
		 btnGuardar.setActionCommand(MDSQLConstants.PANTALLA_DETALLE_PERMISOS_POR_OBJETO_GUARDAR);
		 btnAlta.setActionCommand(MDSQLConstants.PANTALLA_DETALLE_PERMISOS_POR_OBJETO_ALTA);
		 btnModificacion.setActionCommand(MDSQLConstants.PANTALLA_DETALLE_PERMISOS_POR_OBJETO_MODIFICACION);
		 btnInforme.setActionCommand(MDSQLConstants.PANTALLA_DETALLE_PERMISOS_POR_OBJETO_INFORME);
		 btnCancelar.setActionCommand(MDSQLConstants.PANTALLA_DETALLE_PERMISOS_POR_OBJETO_CANCELAR);
		 
		 btnGuardar.addActionListener(actioListener);
		 btnAlta.addActionListener(actioListener);
		 btnModificacion.addActionListener(actioListener);
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
		 setTitle(literales.getLiteral("PantallaDetallePermisosPorObjeto.title"));

		 jLabel1.setText(literales.getLiteral("PantallaDetallePermisosPorObjeto.label1"));
		 jLabel2.setText(literales.getLiteral("PantallaDetallePermisosPorObjeto.label2"));
		 jLabel6.setText(literales.getLiteral("PantallaDetallePermisosPorObjeto.label6"));
		 btnGuardar.setText(literales.getLiteral("PantallaDetallePermisosPorObjeto.guardar"));
		 jLabel11.setText(literales.getLiteral("PantallaDetallePermisosPorObjeto.label11"));
		 jLabel12.setText(literales.getLiteral("PantallaDetallePermisosPorObjeto.label12"));
		 btnInforme.setText(literales.getLiteral("PantallaDetallePermisosPorObjeto.informe"));
		 btnCancelar.setText(literales.getLiteral("PantallaDetallePermisosPorObjeto.cancelar"));
		 jLabel16.setText(literales.getLiteral("PantallaDetallePermisosPorObjeto.label16"));
		 jLabel20.setText(literales.getLiteral("PantallaDetallePermisosPorObjeto.label20"));
		 jLabel4.setText(literales.getLiteral("PantallaDetallePermisosPorObjeto.label4"));
		 jLabel3.setText(literales.getLiteral("PantallaDetallePermisosPorObjeto.label3"));
		 jLabel5.setText(literales.getLiteral("PantallaDetallePermisosPorObjeto.label5"));
		 jLabel7.setText(literales.getLiteral("PantallaDetallePermisosPorObjeto.label7"));
		 jLabel17.setText(literales.getLiteral("PantallaDetallePermisosPorObjeto.label17"));
		 jLabel18.setText(literales.getLiteral("PantallaDetallePermisosPorObjeto.label18"));
		 jLabel8.setText(literales.getLiteral("PantallaDetallePermisosPorObjeto.label8"));
		 btnModificacion.setText(literales.getLiteral("PantallaDetallePermisosPorObjeto.modificacion"));
		 btnAlta.setText(literales.getLiteral("PantallaDetallePermisosPorObjeto.alta"));
	 }
    
	 /**
		 * 
		 */
	public void enableButtons(Boolean val) {
		btnGuardar.setEnabled(val);
		btnAlta.setEnabled(val);
		btnModificacion.setEnabled(val);
		btnInforme.setEnabled(val);
		btnCancelar.setEnabled(val);
	}
}
