/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mdsql.ui.modelos;

import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionListener;

import com.mdsql.bussiness.entities.Modelo;
import com.mdsql.ui.listener.PantallaSeleccionModelosListener;
import com.mdsql.ui.listener.tables.PantallaSeleccionModelosTableListener;
import com.mdsql.ui.model.DefinicionModelosTableModel;
import com.mdsql.ui.model.cabeceras.Cabecera;
import com.mdsql.ui.utils.MDSQLUIHelper;
import com.mdsql.utils.Constants;
import com.mdval.ui.utils.DialogSupport;
import com.mdval.ui.utils.FrameSupport;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author USUARIO1
 */
public class PantallaSeleccionModelos extends DialogSupport {
	
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 8063673324639880723L;
	
	// Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton btnBuscar;
    
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JScrollPane jScrollPane1;
    private JPanel panelLogo;
    
    @Getter
    private JTextField txtCodModelo;
    
    @Getter
    private JTextField txtNombreModelo;
    
    @Getter
    private JTextField txtCodSubmodelo;
    
    @Getter
    private JTable tblModelos;
    
    @Getter
    private JButton btnSeleccionar;
    
    @Getter
    @Setter
    private Modelo seleccionado;
    // End of variables declaration//GEN-END:variables
	
	public PantallaSeleccionModelos(FrameSupport parent, Boolean modal) {
        super(parent, modal);
    }
    
    public PantallaSeleccionModelos(FrameSupport parent, Boolean modal, Map<String, Object> params) {
        super(parent, modal, params);
    }

    @Override
	protected void setupComponents() {

        panelLogo = new JPanel();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        jLabel5 = new JLabel();
        btnBuscar = new JButton();
        txtCodModelo = new JTextField();
        txtNombreModelo = new JTextField();
        txtCodSubmodelo = new JTextField();
        jScrollPane1 = new JScrollPane();
        tblModelos = new JTable();
        btnSeleccionar = new JButton();
        
        GroupLayout panelLogoLayout = new GroupLayout(panelLogo);
        panelLogo.setLayout(panelLogoLayout);
        panelLogoLayout.setHorizontalGroup(
            panelLogoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panelLogoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(88, Short.MAX_VALUE))
        );
        panelLogoLayout.setVerticalGroup(
            panelLogoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panelLogoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(tblModelos);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(btnSeleccionar)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 1128, GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(panelLogo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel2))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtNombreModelo, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel4)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtCodModelo, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel5)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtCodSubmodelo, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnBuscar, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panelLogo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel2)))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtNombreModelo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtCodModelo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtCodSubmodelo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnBuscar)))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 419, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSeleccionar)
                .addContainerGap(14, Short.MAX_VALUE))
        );
    }
    
	@Override
	protected void initEvents() {
		ActionListener actionListener = new PantallaSeleccionModelosListener(this);
		ListSelectionListener listSelectionListener = new PantallaSeleccionModelosTableListener(this);
		
		btnBuscar.setActionCommand(Constants.PANTALLA_SELECCION_MODELOS_BTN_BUSCAR);
		btnSeleccionar.setActionCommand(Constants.PANTALLA_SELECCION_MODELOS_BTN_SELECCIONAR);
		
		btnBuscar.addActionListener(actionListener);
		btnSeleccionar.addActionListener(actionListener);
		
		ListSelectionModel rowSM = tblModelos.getSelectionModel();
		rowSM.addListSelectionListener(listSelectionListener);
	}

	@Override
	protected void initModels() {
		Cabecera cabecera = MDSQLUIHelper.createCabeceraTabla(Constants.FRM_DEFINICION_MODELOS_TABLA_CABECERA);
		tblModelos.setModel(new DefinicionModelosTableModel(cabecera.getColumnIdentifiers(), cabecera.getColumnClasses()));
	}

	@Override
	protected void initialState() {
		btnSeleccionar.setEnabled(Boolean.FALSE);		
	}

	@Override
	protected void setupLiterals() {
		jLabel1.setText("Logotipo");
		jLabel2.setText("Modelos");
        jLabel3.setText("Cod. Modelo:");
        jLabel4.setText("Nombre Modelo:");
        jLabel5.setText("Cod. Submodelo:");
        btnBuscar.setText("BUSCAR");
        btnSeleccionar.setText("SELECCIONAR");
	}
}
