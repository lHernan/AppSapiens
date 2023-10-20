/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mdsql.ui;

import java.util.Map;

import com.mdsql.ui.listener.PantallaMantenimientoEntornosListener;
import com.mdsql.ui.model.EntornoTableModel;
import com.mdsql.ui.model.HistoricoTableModel;
import com.mdsql.ui.utils.MDSQLUIHelper;
import com.mdsql.utils.MDSQLConstants;
import com.mdval.ui.model.cabeceras.Cabecera;
import com.mdval.ui.utils.DialogSupport;
import com.mdval.ui.utils.FrameSupport;

import com.mdval.ui.utils.TableSupport;
import lombok.Getter;

/**
 *
 * @author federico
 */
public class PantallaMantenimientoEntornos extends DialogSupport {
	
	private static final long serialVersionUID = 1L;
	
	// Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    
    @Getter
    private TableSupport tblMantenimientoEntornos;
    
    @Getter
    private javax.swing.JTextField txtBBDD;
    
    @Getter
    private javax.swing.JTextField txtComentario;
    
    @Getter
    private javax.swing.JTextField txtEsquema;
    
    @Getter
    private javax.swing.JTextField txtPassword;
    
    @Getter
    private javax.swing.JButton btnBuscar;
    
    @Getter
    private javax.swing.JButton btnCancelar;
    
    @Getter
    private javax.swing.JButton btnGrabar;
    
    @Getter
    private javax.swing.JCheckBox chkHabilitada;
    // End of variables declaration//GEN-END:variables
	
    public PantallaMantenimientoEntornos(FrameSupport parent, Boolean modal) {
		 super(parent, modal);
	 }

	 public PantallaMantenimientoEntornos(FrameSupport parent, Boolean modal, Map<String, Object> params) {
		super(parent, modal, params);
	 }
	
	 @Override
	 protected void setupComponents() {
		 	jLabel3 = new javax.swing.JLabel();
	        txtBBDD = new javax.swing.JTextField();
	        btnGrabar = new javax.swing.JButton();
	        btnCancelar = new javax.swing.JButton();
	        jLabel14 = new javax.swing.JLabel();
	        btnBuscar = new javax.swing.JButton();
	        jScrollPane1 = new javax.swing.JScrollPane();
	        tblMantenimientoEntornos = new TableSupport();
	        jLabel4 = new javax.swing.JLabel();
	        txtEsquema = new javax.swing.JTextField();
	        jLabel5 = new javax.swing.JLabel();
	        txtPassword = new javax.swing.JTextField();
	        chkHabilitada = new javax.swing.JCheckBox();
	        jLabel6 = new javax.swing.JLabel();
	        txtComentario = new javax.swing.JTextField();
	        
	        setBounds(1366, 768);
	        
	        jScrollPane1.setViewportView(tblMantenimientoEntornos);
	        
	        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
	        getContentPane().setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addGroup(layout.createSequentialGroup()
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                            .addGroup(layout.createSequentialGroup()
	                                .addGap(37, 37, 37)
	                                .addComponent(jLabel14))
	                            .addGroup(layout.createSequentialGroup()
	                                .addGap(436, 436, 436)
	                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
	                                    .addGroup(layout.createSequentialGroup()
	                                        .addComponent(jLabel4)
	                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                                        .addComponent(txtEsquema, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
	                                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))))
	                        .addGap(0, 0, Short.MAX_VALUE))
	                    .addGroup(layout.createSequentialGroup()
	                        .addGap(86, 86, 86)
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                            .addGroup(layout.createSequentialGroup()
	                                .addComponent(jLabel3)
	                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                                .addComponent(txtBBDD, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                                .addComponent(jLabel5)
	                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                .addGap(87, 87, 87)
	                                .addComponent(chkHabilitada))
	                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1199, Short.MAX_VALUE)))
	                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
	                        .addContainerGap()
	                        .addComponent(jLabel6)
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                        .addComponent(txtComentario, javax.swing.GroupLayout.PREFERRED_SIZE, 1163, javax.swing.GroupLayout.PREFERRED_SIZE)))
	                .addGap(100, 100, 100))
	            .addGroup(layout.createSequentialGroup()
	                .addGap(560, 560, 560)
	                .addComponent(btnGrabar, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addGap(22, 22, 22)
	                .addComponent(jLabel14)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(txtBBDD, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(jLabel3)
	                    .addComponent(txtEsquema, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(jLabel4)
	                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(jLabel5)
	                    .addComponent(chkHabilitada))
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(txtComentario, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(jLabel6))
	                .addGap(9, 9, 9)
	                .addComponent(btnBuscar)
	                .addGap(18, 18, 18)
	                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 452, Short.MAX_VALUE)
	                .addGap(37, 37, 37)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(btnGrabar)
	                    .addComponent(btnCancelar))
	                .addGap(43, 43, 43))
	        );
	 }
	
	 @Override
	 protected void initEvents() {
		 PantallaMantenimientoEntornosListener actioListener = new PantallaMantenimientoEntornosListener(this);
		 
		 btnBuscar.setActionCommand(MDSQLConstants.PANTALLA_MANTENIMIENTO_ENTORNOS_BUSCAR);
		 btnGrabar.setActionCommand(MDSQLConstants.PANTALLA_MANTENIMIENTO_ENTORNOS_GRABAR);
		 btnCancelar.setActionCommand(MDSQLConstants.PANTALLA_MANTENIMIENTO_ENTORNOS_CANCELAR);
		 
		 btnBuscar.addActionListener(actioListener);
		 btnGrabar.addActionListener(actioListener);
		 btnCancelar.addActionListener(actioListener);
	 }
	 
	 @SuppressWarnings("unchecked")
	 @Override
	 protected void initModels() {
		 Cabecera cabecera = MDSQLUIHelper.createCabeceraTabla(MDSQLConstants.MNTO_ENTORNOS_TABLA_CABECERA);
		 tblMantenimientoEntornos.initModel(
				 new EntornoTableModel(cabecera));
	 }
	 
	 @Override
	 protected void initialState() {
		 
	 }
	 
	 @Override
	 protected void setupLiterals() {
		 setTitle(literales.getLiteral("PantallaMantenimientoEntornos.titulo"));

		 jLabel3.setText(literales.getLiteral("PantallaMantenimientoEntornos.jLabel3"));
		 btnGrabar.setText(literales.getLiteral("PantallaMantenimientoEntornos.btnGrabar"));
		 btnCancelar.setText(literales.getLiteral("PantallaMantenimientoEntornos.btnCancelar"));
		 btnBuscar.setText(literales.getLiteral("PantallaMantenimientoEntornos.btnBuscar"));
		 jLabel4.setText(literales.getLiteral("PantallaMantenimientoEntornos.jLabel4"));
		 jLabel5.setText(literales.getLiteral("PantallaMantenimientoEntornos.jLabel5"));
		 chkHabilitada.setText(literales.getLiteral("PantallaMantenimientoEntornos.chkHabilitada"));
		 jLabel6.setText(literales.getLiteral("PantallaMantenimientoEntornos.jLabel6"));
	 
	 }
	 
	 /**
		 * 
		 */
	public void enableButtons(Boolean val) {
		btnBuscar.setEnabled(val);
		btnGrabar.setEnabled(val);
		btnCancelar.setEnabled(val);
	}
}
