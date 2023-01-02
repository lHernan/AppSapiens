/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mdsql.ui;

import java.util.Map;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableModel;

import com.mdsql.ui.listener.PantallaConsultaPeticionesListener;
import com.mdsql.ui.model.ConsultaPeticionesTableModel;
import com.mdsql.ui.utils.MDSQLUIHelper;
import com.mdsql.utils.Constants;
import com.mdval.ui.model.cabeceras.Cabecera;
import com.mdval.ui.utils.DialogSupport;
import com.mdval.ui.utils.FrameSupport;

import lombok.Getter;

/**
 *
 * @author USUARIO1
 */
public class PantallaConsultaPeticiones extends DialogSupport {

    private static final long serialVersionUID = 1L;
	
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton btnBuscar;
    private JButton btnCancelar;
    private JButton btnCargar;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JScrollPane jScrollPane1;
    
    @Getter
    private JTable tblPericiones;
    
    private JTextField txtDesde;
    private JTextField txtEstado;
    private JTextField txtHasta;
    private JTextField txtModelo;
    private JTextField txtPeticion;
    private JTextField txtSolicitada;
    private JTextField txtSubmodelo;
    private JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
    
    private PantallaConsultaPeticionesListener pantallaConsultaPeticionesListener;
    
    public PantallaConsultaPeticiones(FrameSupport parent, Boolean modal) {
        super(parent, modal);
    }
    
    public PantallaConsultaPeticiones(FrameSupport parent, Boolean modal, Map<String, Object> params) {
        super(parent, modal, params);
    }
    
    @Override
   	protected void setupComponents() {
    	jLabel1 = new javax.swing.JLabel();
        txtModelo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtSubmodelo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtPeticion = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtSolicitada = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtEstado = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtDesde = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtHasta = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPericiones = new javax.swing.JTable();
        btnCargar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        
        setBounds(1072, 404);
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1048, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtPeticion, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtSubmodelo, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtSolicitada, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCargar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtSolicitada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtSubmodelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txtHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtPeticion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBuscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCargar)
                    .addComponent(btnCancelar))
                .addContainerGap())
        );
    }
    
    @Override
   	protected void initEvents() {
    	pantallaConsultaPeticionesListener = new PantallaConsultaPeticionesListener(this);
    	
    	btnBuscar.setActionCommand(Constants.PANTALLA_CONSULTA_PETICIONES_BUSCAR);
    	btnCargar.setActionCommand(Constants.PANTALLA_CONSULTA_PETICIONES_CARGAR_PROCESADO);
    	btnCancelar.setActionCommand(Constants.PANTALLA_CONSULTA_PETICIONES_CANCELAR);
    	
    	btnBuscar.addActionListener(pantallaConsultaPeticionesListener);
    	btnCargar.addActionListener(pantallaConsultaPeticionesListener);
    	btnCancelar.addActionListener(pantallaConsultaPeticionesListener);
    	
    	this.addOnLoadListener(pantallaConsultaPeticionesListener);
    }
    
    @Override
   	protected void initModels() {
    	Cabecera cabecera = MDSQLUIHelper.createCabeceraTabla(Constants.DLG_CONSULTA_PETICIONES_TABLA_CABECERA);
    	TableModel consultaPeticionesTableModel = new ConsultaPeticionesTableModel(cabecera.getColumnIdentifiers(), cabecera.getColumnClasses());
    	
    	tblPericiones.setModel(consultaPeticionesTableModel);
    }
      
    @Override
    protected void initialState() {}

    @Override
    protected void setupLiterals() {
    	jLabel1.setText(literales.getLiteral("PantallaConsultaPeticiones.label1"));
        jLabel2.setText(literales.getLiteral("PantallaConsultaPeticiones.label2"));
        jLabel3.setText(literales.getLiteral("PantallaConsultaPeticiones.label3"));
        jLabel4.setText(literales.getLiteral("PantallaConsultaPeticiones.label4"));
        jLabel5.setText(literales.getLiteral("PantallaConsultaPeticiones.label5"));
        jLabel6.setText(literales.getLiteral("PantallaConsultaPeticiones.label6"));
        jLabel7.setText(literales.getLiteral("PantallaConsultaPeticiones.label7"));
        jLabel8.setText(literales.getLiteral("PantallaConsultaPeticiones.label8"));
        btnBuscar.setText(literales.getLiteral("PantallaConsultaPeticiones.buscar"));
        btnCargar.setText(literales.getLiteral("PantallaConsultaPeticiones.cargarProcesado"));
        btnCancelar.setText(literales.getLiteral("PantallaConsultaPeticiones.cancelar"));
    }
}
