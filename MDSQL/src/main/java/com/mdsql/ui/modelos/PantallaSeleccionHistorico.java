/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mdsql.ui.modelos;

import java.awt.Cursor;
import java.util.Map;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.ListSelectionModel;

import com.mdsql.ui.listener.PantallaSeleccionHistoricoListener;
import com.mdsql.ui.model.DefinicionSeleccionTableModel;
import com.mdsql.ui.model.cabeceras.Cabecera;
import com.mdsql.ui.utils.MDSQLUIHelper;
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
    private JButton btnAñadir;
    private JButton btnGenerar;
    private JButton btnCancelar;
    private JScrollPane jScrollPane1;
    private JTable tblHistoricos;
    // End of variables declaration//GEN-END:variables
    
    @Getter
    private PantallaSeleccionHistoricoListener pantallaSeleccionHistoricoListener;
    
    public PantallaSeleccionHistorico(FrameSupport parent, Boolean modal) {
        super(parent, modal);
    }
    
    public PantallaSeleccionHistorico(FrameSupport parent, Boolean modal, Map<String, Object> params) {
        super(parent, modal, params);
    }

    @Override
	protected void setupComponents() {

        jScrollPane1 = new JScrollPane();
        tblHistoricos = new JTable();
        btnAñadir = new JButton();
        btnGenerar = new JButton();
        btnCancelar = new JButton();

        
        tblHistoricos.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        tblHistoricos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tblHistoricos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tblHistoricos);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(194, 194, 194)
                .addComponent(btnAñadir)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnGenerar)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCancelar)
                .addContainerGap(194, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 311, GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAñadir)
                    .addComponent(btnGenerar)
                    .addComponent(btnCancelar))
                .addGap(43, 43, 43))
        );
    }

	@Override
	protected void initEvents() {
		pantallaSeleccionHistoricoListener = new PantallaSeleccionHistoricoListener(this);
		
		btnAñadir.setActionCommand(Constants.PANTALLA_SELECCION_HISTORICA_BTN_AÑADIR);
		btnGenerar.setActionCommand(Constants.PANTALLA_SELECCION_HISTORICA_BTN_GENERAR);
		btnCancelar.setActionCommand(Constants.PANTALLA_SELECCION_HISTORICA_BTN_CANCELAR);
		
		btnAñadir.addActionListener(pantallaSeleccionHistoricoListener);
		btnGenerar.addActionListener(pantallaSeleccionHistoricoListener);
		btnCancelar.addActionListener(pantallaSeleccionHistoricoListener);
	}

	@Override
	protected void initModels() {
		Cabecera cabecera = MDSQLUIHelper.createCabeceraTabla(Constants.FRM_DEFINICION_MODELOS_TABLA_CABECERA);
		tblHistoricos.setModel(new DefinicionSeleccionTableModel(cabecera.getColumnIdentifiers(), cabecera.getColumnClasses()));}

	@Override
	protected void initialState() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void setupLiterals() {
		btnAñadir.setText("Añadir a Histórico");
		btnGenerar.setText("Generar Histórico");
		btnCancelar.setText("CANCELAR");
	}
}
