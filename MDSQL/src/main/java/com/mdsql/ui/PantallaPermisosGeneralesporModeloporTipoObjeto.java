/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mdsql.ui;

import java.util.ArrayList;
import java.util.Map;

import javax.swing.JButton;

import com.mdsql.bussiness.entities.Grant;
import com.mdsql.bussiness.entities.Modelo;
import com.mdsql.bussiness.entities.Propietario;
import com.mdsql.ui.listener.PantallaPermisosGeneralesporModeloporTipoObjetoListener;
import com.mdsql.ui.listener.combo.PermisosGeneralesPermisoSinonimoItemListener;
import com.mdsql.ui.listener.combo.PermisosGeneralesTipoObjetoItemListener;
import com.mdsql.ui.model.*;
import com.mdsql.ui.renderer.NivelAvisosTableCellRenderer;
import com.mdsql.ui.utils.MDSQLUIHelper;
import com.mdsql.utils.MDSQLConstants;
import com.mdval.ui.model.cabeceras.Cabecera;
import com.mdval.ui.utils.DialogSupport;
import com.mdval.ui.utils.FrameSupport;

import com.mdval.ui.utils.TableSupport;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author federico
 */
public class PantallaPermisosGeneralesporModeloporTipoObjeto extends DialogSupport {

	 private static final long serialVersionUID = 1L;
	
	 // Variables declaration - do not modify//GEN-BEGIN:variables
	 private javax.swing.JLabel jLabel1;
	 private javax.swing.JLabel jLabel11;
	 private javax.swing.JLabel jLabel12;
	 private javax.swing.JLabel jLabel14;
	 private javax.swing.JLabel jLabel15;
	 private javax.swing.JLabel jLabel16;
	 private javax.swing.JLabel jLabel17;
	 private javax.swing.JLabel jLabel18;
	 private javax.swing.JLabel jLabel19;
	 private javax.swing.JLabel jLabel2;
	 private javax.swing.JLabel jLabel20;
	 private javax.swing.JLabel jLabel21;
	 private javax.swing.JLabel jLabel22;
	 private javax.swing.JLabel jLabel23;
	 private javax.swing.JLabel jLabel24;
	 private javax.swing.JLabel jLabel25;
	 private javax.swing.JLabel jLabel27;
	 private javax.swing.JLabel jLabel3;
	 private javax.swing.JLabel jLabel6;
	 private javax.swing.JScrollPane jScrollPane2;
	 private javax.swing.JScrollPane jScrollPane3;
	 
	 @Getter
	 private TableSupport tblPermisos;
	 
	 @Getter
	 private TableSupport tblSinonimos;
	 
	 @Getter
	 private javax.swing.JTextField txtFechaAlta;
	 
	 @Getter
	 private javax.swing.JTextField txtFechaModificacion;
	 
	 @Getter
	 private javax.swing.JTextField txtFuncionNombre;
	 
	 @Getter
	 private javax.swing.JTextField txtModelo1;
	 
	 @Getter
	 private javax.swing.JTextField txtModeloProyecto;
	 
	 @Getter
	 private javax.swing.JTextField txtPeticion;
	 
	 @Getter
	 private javax.swing.JTextField txtUsuarioAlta;
	 
	 @Getter
	 private javax.swing.JTextField txtUsuarioModificacion;
	 
	 @Getter
	 private javax.swing.JButton btnCancelar;
	 
	 @Getter
	 private javax.swing.JButton btnGuardar;
	 
	 @Getter
	 private javax.swing.JButton btnInforme;
	 
	 @Getter
	 private javax.swing.JCheckBox chkHabilitado;
	 
	 @Getter
	 private javax.swing.JComboBox<String> cmbEntorno;
	 
	 @Getter
	 private javax.swing.JComboBox<String> cmbIncluirPDC;
	 
	 @Getter
	 private javax.swing.JComboBox<String> cmbPermiso;
	 
	 @Getter
	 private javax.swing.JComboBox<String> cmbPermisoSinonimo;
	 
	 @Getter
	 private javax.swing.JComboBox<Propietario> cmbPropietarioSinonimo;
	 
	 @Getter
	 private javax.swing.JComboBox<Grant> cmbReceptorPermiso;
	 
	 @Getter
	 private javax.swing.JComboBox<String> cmbTipoObjeto;
	 
	 @Getter
	 private javax.swing.JComboBox<String> cmbWithGrantOpcion;
	 //End of variables declaration//GEN-END:variables

	@Getter
	@Setter
	private Modelo modelo;
	
	 public PantallaPermisosGeneralesporModeloporTipoObjeto(FrameSupport parent, Boolean modal) {
		 super(parent, modal);
	 }

	 public PantallaPermisosGeneralesporModeloporTipoObjeto(FrameSupport parent, Boolean modal, Map<String, Object> params) {
		super(parent, modal, params);
	 }
	 
	 @Override
	 protected void setupComponents() {
		 jLabel1 = new javax.swing.JLabel();
	     jLabel2 = new javax.swing.JLabel();
	     jLabel3 = new javax.swing.JLabel();
	     jLabel6 = new javax.swing.JLabel();
	     txtModeloProyecto = new javax.swing.JTextField();
	     cmbPermisoSinonimo = new javax.swing.JComboBox<>();
	     txtPeticion = new javax.swing.JTextField();
	     cmbEntorno = new javax.swing.JComboBox<>();
	     btnGuardar = new javax.swing.JButton();
	     jLabel11 = new javax.swing.JLabel();
	     jScrollPane2 = new javax.swing.JScrollPane();
	     tblPermisos = new TableSupport();
	     jLabel12 = new javax.swing.JLabel();
	     jScrollPane3 = new javax.swing.JScrollPane();
	     tblSinonimos = new TableSupport();
	     btnInforme = new javax.swing.JButton();
	     btnCancelar = new javax.swing.JButton();
	     jLabel14 = new javax.swing.JLabel();
	     txtModelo1 = new javax.swing.JTextField();
	     jLabel15 = new javax.swing.JLabel();
	     cmbTipoObjeto = new javax.swing.JComboBox<>();
	     jLabel16 = new javax.swing.JLabel();
	     cmbPermiso = new javax.swing.JComboBox<>();
	     jLabel17 = new javax.swing.JLabel();
	     cmbIncluirPDC = new javax.swing.JComboBox<>();
	     jLabel18 = new javax.swing.JLabel();
	     txtFuncionNombre = new javax.swing.JTextField();
	     jLabel19 = new javax.swing.JLabel();
		 cmbReceptorPermiso = new javax.swing.JComboBox<>();
	     jLabel20 = new javax.swing.JLabel();
	     cmbWithGrantOpcion = new javax.swing.JComboBox<>();
	     jLabel21 = new javax.swing.JLabel();
	     chkHabilitado = new javax.swing.JCheckBox();
	     jLabel22 = new javax.swing.JLabel();
	     txtUsuarioAlta = new javax.swing.JTextField();
	     jLabel23 = new javax.swing.JLabel();
	     txtFechaAlta = new javax.swing.JTextField();
	     jLabel24 = new javax.swing.JLabel();
	     txtUsuarioModificacion = new javax.swing.JTextField();
	     jLabel25 = new javax.swing.JLabel();
	     txtFechaModificacion = new javax.swing.JTextField();
	     jLabel27 = new javax.swing.JLabel();
	     cmbPropietarioSinonimo = new javax.swing.JComboBox<>();
	     
	     setBounds(1366, 768);
	     
	     jScrollPane2.setViewportView(tblPermisos);
	     
	     jScrollPane3.setViewportView(tblSinonimos);
	     
	     javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
	        getContentPane().setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addGap(25, 25, 25)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                            .addGroup(layout.createSequentialGroup()
	                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
	                                    .addGroup(layout.createSequentialGroup()
	                                        .addGap(107, 107, 107)
	                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                                            .addComponent(txtPeticion)
	                                            .addComponent(cmbPermisoSinonimo, 0, 301, Short.MAX_VALUE)))
	                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
	                                        .addComponent(jLabel6)
	                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                                        .addComponent(cmbEntorno, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE))
	                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
	                                        .addComponent(jLabel15)
	                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                                        .addComponent(cmbTipoObjeto, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
	                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
	                                        .addComponent(jLabel16)
	                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                                        .addComponent(cmbPermiso, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
	                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
	                                    .addGroup(layout.createSequentialGroup()
	                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
	                                            .addComponent(jLabel18)
	                                            .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.LEADING))
	                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                                        .addComponent(txtFuncionNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
	                                    .addComponent(cmbPropietarioSinonimo, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                    .addGroup(layout.createSequentialGroup()
	                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
	                                            .addComponent(jLabel27)
	                                            .addComponent(jLabel19)
	                                            .addComponent(jLabel21))
	                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                                            .addComponent(cmbReceptorPermiso, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                            .addComponent(cmbIncluirPDC, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                            .addComponent(chkHabilitado)))
	                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
	                                        .addGap(55, 55, 55)
	                                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))))
	                            .addComponent(jLabel14)
	                            .addGroup(layout.createSequentialGroup()
	                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
	                                    .addComponent(jLabel2)
	                                    .addComponent(jLabel1)
	                                    .addComponent(jLabel3))
	                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                                .addComponent(txtModelo1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                                .addComponent(txtModeloProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, 1022, javax.swing.GroupLayout.PREFERRED_SIZE)))
	                        .addGap(40, 40, 40))
	                    .addGroup(layout.createSequentialGroup()
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
	                            .addGroup(layout.createSequentialGroup()
	                                .addComponent(jLabel25)
	                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                                .addComponent(txtFechaModificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
	                            .addGroup(layout.createSequentialGroup()
	                                .addComponent(jLabel24)
	                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                                .addComponent(txtUsuarioModificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
	                            .addGroup(layout.createSequentialGroup()
	                                .addComponent(jLabel23)
	                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                                .addComponent(txtFechaAlta, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
	                            .addGroup(layout.createSequentialGroup()
	                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                                    .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.TRAILING)
	                                    .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING))
	                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
	                                    .addComponent(cmbWithGrantOpcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                    .addComponent(txtUsuarioAlta, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
	                            .addGroup(layout.createSequentialGroup()
	                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                                    .addComponent(jLabel11)
	                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1321, Short.MAX_VALUE)
	                                    .addComponent(jLabel12)
	                                    .addComponent(jScrollPane3))
	                                .addGap(19, 19, 19)))
	                        .addGap(20, 20, 20))))
	            .addGroup(layout.createSequentialGroup()
	                .addGap(538, 538, 538)
	                .addComponent(btnInforme, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addGap(0, 0, Short.MAX_VALUE))
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
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addGroup(layout.createSequentialGroup()
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                            .addGroup(layout.createSequentialGroup()
	                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                                    .addComponent(cmbPermisoSinonimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                    .addComponent(jLabel2)
	                                    .addComponent(jLabel17))
	                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                                    .addComponent(txtPeticion, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                    .addComponent(jLabel3)
	                                    .addComponent(txtFuncionNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                    .addComponent(jLabel18))
	                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
	                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                                        .addComponent(cmbTipoObjeto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                                            .addComponent(cmbReceptorPermiso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                            .addComponent(jLabel19)))
	                                    .addGroup(layout.createSequentialGroup()
	                                        .addComponent(jLabel15)
	                                        .addGap(4, 4, 4)))
	                                .addGap(12, 12, 12)
	                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                                    .addComponent(cmbPermiso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                    .addComponent(jLabel16)
	                                    .addComponent(jLabel27)
	                                    .addComponent(cmbIncluirPDC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
	                            .addComponent(cmbPropietarioSinonimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                                .addComponent(cmbEntorno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                .addComponent(jLabel6))
	                            .addComponent(jLabel21)
	                            .addComponent(chkHabilitado))
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                        .addComponent(btnGuardar))
	                    .addGroup(layout.createSequentialGroup()
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                            .addComponent(cmbWithGrantOpcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                            .addComponent(jLabel20))
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                            .addComponent(jLabel22)
	                            .addComponent(txtUsuarioAlta, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
	                        .addGap(10, 10, 10)
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                            .addComponent(jLabel23)
	                            .addComponent(txtFechaAlta, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
	                        .addGap(10, 10, 10)
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                            .addComponent(jLabel24)
	                            .addComponent(txtUsuarioModificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                            .addComponent(jLabel25)
	                            .addComponent(txtFechaModificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))))
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addComponent(jLabel11)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                .addComponent(jLabel12)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
	                .addGap(32, 32, 32)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(btnCancelar)
	                    .addComponent(btnInforme))
	                .addGap(37, 37, 37))
	        );

		 
	 }
	 
	 @Override
	 protected void initEvents() {
		 PantallaPermisosGeneralesporModeloporTipoObjetoListener actionListener = new PantallaPermisosGeneralesporModeloporTipoObjetoListener(this);
		 PermisosGeneralesTipoObjetoItemListener cmbTipoObjetoListener = new PermisosGeneralesTipoObjetoItemListener(this);
		 PermisosGeneralesPermisoSinonimoItemListener cmbPermisoSinonimoListener = new PermisosGeneralesPermisoSinonimoItemListener(this);

		 btnGuardar.setActionCommand(MDSQLConstants.PANTALLA_PERMISOS_GENERALES_POR_MODELO_POR_TIPO_OBJETO_GUARDAR);
		 btnInforme.setActionCommand(MDSQLConstants.PANTALLA_PERMISOS_GENERALES_POR_MODELO_POR_TIPO_OBJETO_INFORME);
		 btnCancelar.setActionCommand(MDSQLConstants.PANTALLA_PERMISOS_GENERALES_POR_MODELO_POR_TIPO_OBJETO_CANCELAR);
		 
		 btnGuardar.addActionListener(actionListener);
		 btnInforme.addActionListener(actionListener);
		 btnCancelar.addActionListener(actionListener);

		 cmbTipoObjeto.addItemListener(cmbTipoObjetoListener);
		 cmbPermisoSinonimo.addItemListener(cmbPermisoSinonimoListener);

		 this.addOnLoadListener(actionListener);
	 }
	 
	 @SuppressWarnings("unchecked")
	 @Override
	 protected void initModels() {
		 SiNoComboBoxModel siNoComboBoxModel = new SiNoComboBoxModel();
		 PermisoSinonimoComboBoxModel permisoSinonimoComboBoxModel = new PermisoSinonimoComboBoxModel();
		 VigenteHistoricoComboBoxModel vigenteHistoricoComboBoxModel = new VigenteHistoricoComboBoxModel();

		 cmbWithGrantOpcion.setModel(siNoComboBoxModel);
		 cmbPermisoSinonimo.setModel(permisoSinonimoComboBoxModel);
		 cmbIncluirPDC.setModel(siNoComboBoxModel);
		 cmbEntorno.setModel(vigenteHistoricoComboBoxModel);

		 Cabecera cabeceraPermisos = MDSQLUIHelper.createCabeceraTabla(MDSQLConstants.PERMISOS_GENERALES_TABLA_CABECERA);
		 tblPermisos.initModel(
				 new ProcesarScriptNotaTableModel(cabeceraPermisos));

		 Cabecera cabeceraSinonimos = MDSQLUIHelper
				 .createCabeceraTabla(MDSQLConstants.SINONIMOS_GENERALES_TABLA_CABECERA);
		 tblSinonimos.initModel(new ProcesarScriptUltimasPeticionesTableModel(cabeceraSinonimos));
	 }
	 
	 @Override
	 protected void initialState() {
		 txtModeloProyecto.setEditable(Boolean.FALSE);
		 txtModelo1.setEditable(Boolean.FALSE);
		 txtUsuarioAlta.setEditable(Boolean.FALSE);
		 txtFechaAlta.setEditable(Boolean.FALSE);
		 txtUsuarioModificacion.setEditable(Boolean.FALSE);
		 txtFechaModificacion.setEditable(Boolean.FALSE);
		 cmbPermisoSinonimo.setSelectedItem(null);
	 }
	 
	 @Override
	 protected void setupLiterals() {
		 setTitle(literales.getLiteral("PantallaPermisosGeneralesporModeloporTipoObjeto.title"));

		 jLabel1.setText(literales.getLiteral("PantallaPermisosGeneralesporModeloporTipoObjeto.label1"));
		 jLabel2.setText(literales.getLiteral("PantallaPermisosGeneralesporModeloporTipoObjeto.label2"));
		 jLabel3.setText(literales.getLiteral("PantallaPermisosGeneralesporModeloporTipoObjeto.label3"));
		 jLabel6.setText(literales.getLiteral("PantallaPermisosGeneralesporModeloporTipoObjeto.label6"));
		 btnGuardar.setText(literales.getLiteral("PantallaPermisosGeneralesporModeloporTipoObjeto.guardar"));
		 jLabel11.setText(literales.getLiteral("PantallaPermisosGeneralesporModeloporTipoObjeto.label11"));
		 jLabel12.setText(literales.getLiteral("PantallaPermisosGeneralesporModeloporTipoObjeto.label12"));
		 btnInforme.setText(literales.getLiteral("PantallaPermisosGeneralesporModeloporTipoObjeto.informe"));
		 btnCancelar.setText(literales.getLiteral("PantallaPermisosGeneralesporModeloporTipoObjeto.cancelar"));
		 jLabel15.setText(literales.getLiteral("PantallaPermisosGeneralesporModeloporTipoObjeto.label15"));
		 jLabel16.setText(literales.getLiteral("PantallaPermisosGeneralesporModeloporTipoObjeto.label16"));
		 jLabel17.setText(literales.getLiteral("PantallaPermisosGeneralesporModeloporTipoObjeto.label17"));
		 jLabel18.setText(literales.getLiteral("PantallaPermisosGeneralesporModeloporTipoObjeto.label18"));
		 jLabel19.setText(literales.getLiteral("PantallaPermisosGeneralesporModeloporTipoObjeto.label19"));
		 jLabel20.setText(literales.getLiteral("PantallaPermisosGeneralesporModeloporTipoObjeto.label20"));
		 jLabel21.setText(literales.getLiteral("PantallaPermisosGeneralesporModeloporTipoObjeto.label21"));
		 jLabel22.setText(literales.getLiteral("PantallaPermisosGeneralesporModeloporTipoObjeto.label22"));
		 jLabel23.setText(literales.getLiteral("PantallaPermisosGeneralesporModeloporTipoObjeto.label23"));
		 jLabel24.setText(literales.getLiteral("PantallaPermisosGeneralesporModeloporTipoObjeto.label24"));
		 jLabel25.setText(literales.getLiteral("PantallaPermisosGeneralesporModeloporTipoObjeto.label25"));
		 jLabel27.setText(literales.getLiteral("PantallaPermisosGeneralesporModeloporTipoObjeto.label27"));
	 
	 }
	 
	 /**
		 * 
		 */
	public void enableButtons(Boolean val) {
		btnGuardar.setEnabled(val);
		btnInforme.setEnabled(val);
		btnCancelar.setEnabled(val);
	}
}
