/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mdsql.ui.modelos;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionListener;

import com.mdsql.bussiness.entities.Modelo;
import com.mdsql.ui.listener.PantallaSeleccionModelosListener;
import com.mdsql.ui.listener.tables.PantallaSeleccionModelosTableListener;
import com.mdsql.ui.model.SeleccionModelosTableModel;
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
    
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JScrollPane jScrollPane2;
    
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

	private JLabel lblTitulo;
	
	public PantallaSeleccionModelos(FrameSupport parent, Boolean modal) {
        super(parent, modal);
    }
    
    public PantallaSeleccionModelos(FrameSupport parent, Boolean modal, Map<String, Object> params) {
        super(parent, modal, params);
    }

    @Override
	protected void setupComponents() {

    	jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        jLabel5 = new JLabel();
        txtCodModelo = new JTextField();
        txtNombreModelo = new JTextField();
        txtCodSubmodelo = new JTextField();
        btnBuscar = new JButton();
        jScrollPane2 = new JScrollPane();
        tblModelos = new JTable();
        btnSeleccionar = new JButton();
        lblTitulo = new JLabel();
        
        setPreferredSize(new Dimension(1418, 586));

        jScrollPane2.setViewportView(tblModelos);

        panelLogo.setPreferredSize(new Dimension(286, 63));

        GroupLayout panelLogoLayout = new GroupLayout(panelLogo);
        panelLogo.setLayout(panelLogoLayout);
        panelLogoLayout.setHorizontalGroup(
            panelLogoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 286, Short.MAX_VALUE)
        );
        panelLogoLayout.setVerticalGroup(
            panelLogoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 63, Short.MAX_VALUE)
        );

        lblTitulo.setFont(new Font("Dialog", 1, 18)); // NOI18N

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(panelLogo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblTitulo))
                            .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCodModelo, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNombreModelo, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCodSubmodelo, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBuscar)
                        .addGap(410, 410, 410))
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnSeleccionar, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTitulo, GroupLayout.Alignment.LEADING)
                    .addComponent(panelLogo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombreModelo, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(txtCodModelo, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtCodSubmodelo, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnSeleccionar)
                .addContainerGap())
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
		Cabecera cabecera = MDSQLUIHelper.createCabeceraTabla(Constants.DLG_SELECCION_MODELOS_TABLA_CABECERA);
		tblModelos.setModel(new SeleccionModelosTableModel(cabecera.getColumnIdentifiers(), cabecera.getColumnClasses()));
	}

	@Override
	protected void initialState() {
		btnSeleccionar.setEnabled(Boolean.FALSE);		
	}

	@Override
	protected void setupLiterals() {
		setTitle("Definición de modelos");
		
		lblTitulo.setText("Modelos");
		jLabel3.setText("Cod. modelo");
		jLabel4.setText("Nombre modelo");
		jLabel5.setText("Cod. submodelo");
        btnBuscar.setText("BUSCAR");
        btnSeleccionar.setText("SELECCIONAR");
	}
}
