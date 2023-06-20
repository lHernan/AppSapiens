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
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionListener;

import com.mdsql.bussiness.entities.Proceso;
import com.mdsql.ui.listener.PantallaConsultaPeticionesListener;
import com.mdsql.ui.listener.tables.PantallaConsultaPeticionesTableListener;
import com.mdsql.ui.model.ConsultaPeticionesTableModel;
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
 * @author USUARIO1
 */
public class PantallaConsultaPeticiones extends DialogSupport {

    private static final long serialVersionUID = 1L;
	
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton btnBuscar;
    private JButton btnCancelar;
    
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
    private JButton btnCargar;
    
    @Getter
    private TableSupport tblPeticiones;
    
    @Getter
    private JTextField txtDesde;
    
    @Getter
    private JTextField txtEstado;
    
    @Getter
    private JTextField txtHasta;
    
    @Getter
    private JTextField txtModelo;
    
    @Getter
    private JTextField txtPeticion;
    
    @Getter
    private JTextField txtSolicitada;
    
    @Getter
    private JTextField txtSubmodelo;
    
    @Getter
    private JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
    
    @Getter
    @Setter
    private Proceso seleccionado;
    
    private PantallaConsultaPeticionesListener pantallaConsultaPeticionesListener;
    
    public PantallaConsultaPeticiones(FrameSupport parent, Boolean modal) {
        super(parent, modal);
    }
    
    public PantallaConsultaPeticiones(FrameSupport parent, Boolean modal, Map<String, Object> params) {
        super(parent, modal, params);
    }
    
    @Override
   	protected void setupComponents() {
    	jLabel1 = new JLabel();
        txtModelo = new JTextField();
        jLabel2 = new JLabel();
        txtSubmodelo = new JTextField();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        jLabel5 = new JLabel();
        jLabel6 = new JLabel();
        jLabel7 = new JLabel();
        jLabel8 = new JLabel();
        btnBuscar = new JButton();
        jScrollPane1 = new JScrollPane();
        tblPeticiones = new TableSupport();
        btnCargar = new JButton();
        btnCancelar = new JButton();
        txtPeticion = new JTextField();
        txtSolicitada = new JTextField();
        txtEstado = new JTextField();
        txtUsuario = new JTextField();
        txtDesde = new JTextField();
        txtHasta = new JTextField();
        
        setBounds(1540, 569);

        jScrollPane1.setViewportView(tblPeticiones);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtModelo, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtPeticion, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtSubmodelo, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)))
                                .addGap(51, 51, 51)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel6))
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                            .addComponent(txtEstado, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtSolicitada, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtUsuario, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnBuscar, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE))
                                        .addGap(51, 51, 51)
                                        .addComponent(jLabel7)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtDesde, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtHasta, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)))
                                .addGap(517, 517, 517))
                            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnCargar)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDesde, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(txtHasta, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(txtModelo, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(txtSolicitada, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtEstado, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtUsuario, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtPeticion, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtSubmodelo, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))))
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscar)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCargar)
                    .addComponent(btnCancelar))
                .addGap(18, 18, 18))
        );
    }
    
    @Override
   	protected void initEvents() {
    	pantallaConsultaPeticionesListener = new PantallaConsultaPeticionesListener(this);
    	ListSelectionListener listSelectionListener = new PantallaConsultaPeticionesTableListener(this);
    	
    	btnBuscar.setActionCommand(MDSQLConstants.PANTALLA_CONSULTA_PETICIONES_BUSCAR);
    	btnCargar.setActionCommand(MDSQLConstants.PANTALLA_CONSULTA_PETICIONES_CARGAR_PROCESADO);
    	btnCancelar.setActionCommand(MDSQLConstants.PANTALLA_CONSULTA_PETICIONES_CANCELAR);
    	
    	btnBuscar.addActionListener(pantallaConsultaPeticionesListener);
    	btnCargar.addActionListener(pantallaConsultaPeticionesListener);
    	btnCancelar.addActionListener(pantallaConsultaPeticionesListener);
    	
    	ListSelectionModel rowSM = tblPeticiones.getSelectionModel();
   		rowSM.addListSelectionListener(listSelectionListener);
    }
    
    @Override
   	protected void initModels() {
    	Cabecera cabecera = MDSQLUIHelper.createCabeceraTabla(MDSQLConstants.DLG_CONSULTA_PETICIONES_TABLA_CABECERA);
    	tblPeticiones.initModel(new ConsultaPeticionesTableModel(cabecera));
    }
      
    @Override
    protected void initialState() {
    	btnCargar.setEnabled(Boolean.FALSE);
    }

    @Override
    protected void setupLiterals() {
    	setTitle(literales.getLiteral("PantallaConsultaPeticiones.title"));
    	
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
