/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mdsql.ui;

import java.util.Map;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle;

import com.mdsql.ui.listener.PantallaDetalleScriptListener;
import com.mdsql.ui.model.DetalleScriptTableModel;
import com.mdsql.ui.utils.MDSQLUIHelper;
import com.mdsql.utils.MDSQLConstants;
import com.mdval.ui.model.cabeceras.Cabecera;
import com.mdval.ui.utils.DialogSupport;
import com.mdval.ui.utils.FrameSupport;
import com.mdval.ui.utils.TableSupport;

import lombok.Getter;

/**
 *
 * @author USUARIO1
 */
public class PantallaDetalleScript extends DialogSupport {

    private static final long serialVersionUID = 1L;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton btnCancelar;
    private JScrollPane jScrollPane1;
    
    @Getter
    private TableSupport tblDetalle;
    // End of variables declaration//GEN-END:variables
    
    public PantallaDetalleScript(FrameSupport parent, Boolean modal) {
        super(parent, modal);
    }
    
    public PantallaDetalleScript(FrameSupport parent, Boolean modal, Map<String, Object> params) {
        super(parent, modal, params);
    }
    
    @Override
   	protected void setupComponents() {
    	jScrollPane1 = new JScrollPane();
        tblDetalle = new TableSupport(Boolean.FALSE);
        btnCancelar = new JButton();

        jScrollPane1.setViewportView(tblDetalle);
        if (tblDetalle.getColumnModel().getColumnCount() > 0) {
            tblDetalle.getColumnModel().getColumn(0).setPreferredWidth(80);
            tblDetalle.getColumnModel().getColumn(1).setPreferredWidth(200);
            tblDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
            tblDetalle.getColumnModel().getColumn(3).setPreferredWidth(60);
            tblDetalle.getColumnModel().getColumn(4).setPreferredWidth(200);
            tblDetalle.getColumnModel().getColumn(5).setPreferredWidth(100);
            tblDetalle.getColumnModel().getColumn(6).setPreferredWidth(100);
            tblDetalle.getColumnModel().getColumn(7).setPreferredWidth(60);
            tblDetalle.getColumnModel().getColumn(8).setPreferredWidth(60);
            tblDetalle.getColumnModel().getColumn(9).setPreferredWidth(60);
        }

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancelar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 976, Short.MAX_VALUE)))
                .addGap(16, 16, 16))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCancelar)
                .addGap(16, 16, 16))
        );

    }
    
    @Override
   	protected void initEvents() {
    	PantallaDetalleScriptListener actionListener = new PantallaDetalleScriptListener(this);
		
    	btnCancelar.setActionCommand(MDSQLConstants.PANTALLA_DETALLE_SCRIPT_CANCELAR);

    	btnCancelar.addActionListener(actionListener);
		
		this.addOnLoadListener(actionListener);
    }
    
    @Override
	protected void initModels() {
    	Cabecera cabecera = MDSQLUIHelper.createCabeceraTabla(MDSQLConstants.DLG_DETALLE_SCRIPT_TABLA_CABECERA);
    	tblDetalle.setModel(new DetalleScriptTableModel(cabecera));
    }
    
    @Override
   	protected void initialState() {}

   	@Override
   	protected void setupLiterals() {
   		setTitle(literales.getLiteral("PantallaDetalleScript.title"));
   		
   		btnCancelar.setText(literales.getLiteral("PantallaDetalleScript.cancelar"));
   	}
       
}
