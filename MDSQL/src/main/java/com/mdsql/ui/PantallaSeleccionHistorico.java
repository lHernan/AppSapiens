/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mdsql.ui;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.table.DefaultTableModel;

import org.apache.commons.lang3.StringUtils;

import com.mdsql.ui.listener.PantallaSeleccionHistoricoListener;
import com.mdsql.utils.Constants;
import com.mdval.ui.utils.DialogSupport;
import com.mdval.ui.utils.FrameSupport;

import lombok.Getter;

/**
 *
 * @author USUARIO1
 */
public class PantallaSeleccionHistorico extends DialogSupport {

    /**
	 * 
	 */
	private static final long serialVersionUID = 4469486461122163193L;
	
	// Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton btnCancelar;
    private JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
    
    @Getter
	private JTable tblHistorico;

    @Getter
	private JButton btnAddHistorico;

    @Getter
	private JButton btnGenerarHistorico;
    
    public PantallaSeleccionHistorico(FrameSupport parent, Boolean modal) {
        super(parent, modal);
    }
    
    public PantallaSeleccionHistorico(FrameSupport parent, Boolean modal, Map<String, Object> params) {
        super(parent, modal, params);
    }

    @Override
	protected void setupComponents() {

    	jScrollPane1 = new JScrollPane();
        tblHistorico = new JTable();
        btnAddHistorico = new JButton();
        btnGenerarHistorico = new JButton();
        btnCancelar = new JButton();
        
        setPreferredSize(new Dimension(1418, 586));
        setResizable(Boolean.TRUE);

        jScrollPane1.setViewportView(tblHistorico);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 1151, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAddHistorico)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnGenerarHistorico, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddHistorico)
                    .addComponent(btnGenerarHistorico)
                    .addComponent(btnCancelar))
                .addContainerGap())
        );
    }

	@Override
	protected void initEvents() {
		ActionListener actionListener = new PantallaSeleccionHistoricoListener(this);
		
		btnAddHistorico.setActionCommand(Constants.PANTALLA_SELECCION_HISTORICA_BTN_AÑADIR);
		btnGenerarHistorico.setActionCommand(Constants.PANTALLA_SELECCION_HISTORICA_BTN_GENERAR);
		btnCancelar.setActionCommand(Constants.PANTALLA_SELECCION_HISTORICA_BTN_CANCELAR);
		
		btnAddHistorico.addActionListener(actionListener);
		btnGenerarHistorico.addActionListener(actionListener);
		btnCancelar.addActionListener(actionListener);
	}

	@Override
	protected void initModels() {
//		Cabecera cabecera = MDSQLUIHelper.createCabeceraTabla(Constants.DLG_SELECCION_MODELOS_TABLA_CABECERA);
//		tblHistoricos.setModel(new DefinicionSeleccionTableModel(cabecera.getColumnIdentifiers(), cabecera.getColumnClasses()));}
	
		tblHistorico.setModel(new DefaultTableModel(
	            new Object [][] {
	                {null, null, null, null, null},
	                {null, null, null, null, null},
	                {null, null, null, null, null},
	                {null, null, null, null, null}
	            },
	            new String [] {
	                "Configurado", "Objeto", "Tipo", "Histórico", "Vigente"
	            }
	        ) {
	            Class[] types = new Class [] {
	                java.lang.Boolean.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class, java.lang.Boolean.class
	            };

	            public Class getColumnClass(int columnIndex) {
	                return types [columnIndex];
	            }
	        });
	}	
		
	@Override
	protected void initialState() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void setupLiterals() {
		setTitle(StringUtils.EMPTY);
		
		btnAddHistorico.setText("Añadir a histórico");
		btnGenerarHistorico.setText("Generar histórico");
		btnCancelar.setText("CANCELAR");
	}
}
