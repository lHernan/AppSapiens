/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mdsql.ui;

import java.awt.Dimension;
import java.awt.Font;
import java.util.Map;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionListener;

import org.apache.commons.lang3.StringUtils;

import com.mdsql.bussiness.entities.Modelo;
import com.mdsql.ui.listener.PantallaSeleccionModelosListener;
import com.mdsql.ui.listener.tables.PantallaSeleccionModelosTableListener;
import com.mdsql.ui.model.SeleccionModelosTableModel;
import com.mdsql.ui.utils.MDSQLUIHelper;
import com.mdsql.utils.Constants;
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
    
    @Getter
    private JScrollPane jScrollPane2;
    
    @Getter
    private JTextField txtCodModelo;
    
    @Getter
    private JTextField txtNombreModelo;
    
    @Getter
    private JTextField txtCodSubmodelo;
    
    @Getter
    private TableSupport tblModelos;
    
    @Getter
    private JButton btnSeleccionar;
    
    @Getter
    @Setter
    private Modelo seleccionado;
    // End of variables declaration//GEN-END:variable
	
    private JLabel lblTitulo;
	
	@Getter
	private PantallaSeleccionModelosListener pantallaSeleccionModelosListener; 
	
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
           tblModelos = new TableSupport(Boolean.FALSE);
           btnSeleccionar = new JButton();
           lblTitulo = new JLabel();
           
           Dimension dimension = new Dimension(1350, 500);
           setPreferredSize(dimension);
           setMinimunSize(dimension);
           setResizable(Boolean.TRUE);
           
           jScrollPane2.setViewportView(tblModelos);
           
           GroupLayout panelLogoLayout = new javax.swing.GroupLayout(panelLogo);
           panelLogo.setLayout(panelLogoLayout);
           panelLogoLayout.setHorizontalGroup(
               panelLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGap(0, 286, Short.MAX_VALUE)
           );
           panelLogoLayout.setVerticalGroup(
               panelLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGap(0, 63, Short.MAX_VALUE)
           );

           lblTitulo.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
           
           GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
           getContentPane().setLayout(layout);
           layout.setHorizontalGroup(
               layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(layout.createSequentialGroup()
                   .addContainerGap()
                   .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                       .addGroup(layout.createSequentialGroup()
                           .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                               .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                   .addComponent(panelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                   .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                   .addComponent(lblTitulo))
                               .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                   .addComponent(jLabel3)
                                   .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                   .addComponent(txtCodModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                   .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                   .addComponent(jLabel4)
                                   .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                   .addComponent(txtNombreModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)))
                           .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                           .addComponent(jLabel5)
                           .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                           .addComponent(txtCodSubmodelo, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                           .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                           .addComponent(btnBuscar)
                           .addGap(410, 410, 410))
                       .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                           .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                               .addComponent(jScrollPane2)
                               .addGroup(layout.createSequentialGroup()
                                   .addGap(0, 0, Short.MAX_VALUE)
                                   .addComponent(btnSeleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                           .addContainerGap())))
           );
           layout.setVerticalGroup(
               layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(layout.createSequentialGroup()
                   .addContainerGap()
                   .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                       .addComponent(lblTitulo, javax.swing.GroupLayout.Alignment.LEADING)
                       .addComponent(panelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                   .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                   .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                       .addComponent(txtNombreModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                       .addComponent(jLabel4)
                       .addComponent(jLabel3)
                       .addComponent(txtCodModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                       .addComponent(jLabel5)
                       .addComponent(txtCodSubmodelo, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                       .addComponent(btnBuscar))
                   .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                   .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
                   .addGap(18, 18, 18)
                   .addComponent(btnSeleccionar)
                   .addContainerGap())
           );
           
    }
    
    @Override
	protected void initEvents() {
		pantallaSeleccionModelosListener = new PantallaSeleccionModelosListener(this);
		ListSelectionListener listSelectionListener = new PantallaSeleccionModelosTableListener(this);
		
		btnBuscar.setActionCommand(Constants.PANTALLA_SELECCION_MODELOS_BTN_BUSCAR);
		btnSeleccionar.setActionCommand(Constants.PANTALLA_SELECCION_MODELOS_BTN_SELECCIONAR);
		
		btnBuscar.addActionListener(pantallaSeleccionModelosListener);
		btnSeleccionar.addActionListener(pantallaSeleccionModelosListener);
		
		this.addOnLoadListener(pantallaSeleccionModelosListener);
		
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
		String codigoProyecto = (String) params.get("codigoProyecto");
		if (StringUtils.isNotBlank(codigoProyecto)) {
			txtCodModelo.setText(codigoProyecto);
		}
		
		btnSeleccionar.setEnabled(Boolean.FALSE);		
	}

	@Override
	protected void setupLiterals() {
		setTitle(literales.getLiteral("PantallaSeleccionModelos.titulo"));
		
		lblTitulo.setText(literales.getLiteral("PantallaSeleccionModelos.lblTitulo"));
		jLabel3.setText(literales.getLiteral("PantallaSeleccionModelos.label3"));
		jLabel4.setText(literales.getLiteral("PantallaSeleccionModelos.label4"));
		jLabel5.setText(literales.getLiteral("PantallaSeleccionModelos.label5"));
        btnBuscar.setText(literales.getLiteral("PantallaSeleccionModelos.buscar"));
        btnSeleccionar.setText(literales.getLiteral("PantallaSeleccionModelos.seleccionar"));
	}
    
}
