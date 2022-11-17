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
import javax.swing.table.TableModel;

import com.mdsql.ui.listener.PantallaDetalleScriptListener;
import com.mdsql.ui.model.DetalleScriptTableModel;
import com.mdsql.ui.model.cabeceras.Cabecera;
import com.mdsql.ui.utils.MDSQLUIHelper;
import com.mdsql.utils.Constants;
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
    private JButton jButton1;
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
        jButton1 = new JButton();
        
        jScrollPane1.setViewportView(tblDetalle);
        
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jScrollPane1)
                .addGap(22, 22, 22))
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(468, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(442, 442, 442))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap(12, Short.MAX_VALUE))
        );

    }
    
    @Override
   	protected void initEvents() {
    	PantallaDetalleScriptListener actionListener = new PantallaDetalleScriptListener(this);
		
		jButton1.setActionCommand(Constants.PANTALLA_DETALLE_SCRIPT_CANCELAR);

		jButton1.addActionListener(actionListener);
		
		this.addOnLoadListener(actionListener);
    }
    
    @Override
	protected void initModels() {
    	Cabecera cabecera = MDSQLUIHelper.createCabeceraTabla(Constants.DLG_DETALLE_SCRIPT_TABLA_CABECERA);
    	TableModel detalleScriptTableModel = new DetalleScriptTableModel(cabecera.getColumnIdentifiers(), cabecera.getColumnClasses());
    
    	tblDetalle.setModel(detalleScriptTableModel);
    }
    
    @Override
   	protected void initialState() {}

   	@Override
   	protected void setupLiterals() {
   		jButton1.setText("CANCELAR");
   	}
       
}
