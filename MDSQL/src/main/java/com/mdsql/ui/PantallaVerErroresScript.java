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

import com.mdsql.ui.listener.PantallaVerErroresScriptListener;
import com.mdsql.ui.model.SeleccionHistoricoTableModel;
import com.mdsql.ui.model.cabeceras.Cabecera;
import com.mdsql.ui.utils.MDSQLUIHelper;
import com.mdsql.utils.Constants;
import com.mdval.ui.utils.FrameSupport;

/**
 *
 * @author USUARIO1
 */
public class PantallaVerErroresScript extends FrameSupport {

    private static final long serialVersionUID = 1L;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton btnCancelar;
    private JLabel jLabel1;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JTable tblErroresScript;
    private JTable tblParches;
    // End of variables declaration//GEN-END:variables

    private PantallaVerErroresScriptListener pantallaVerErroresScriptListener;
    
    public PantallaVerErroresScript(FrameSupport parent, Boolean modal) {
        super(parent, modal);
    }
    
    public PantallaVerErroresScript(FrameSupport parent, Boolean modal, Map<String, Object> params) {
        super(parent, modal, params);
    }
    
    @Override
   	protected void setupComponents() {
    	jScrollPane1 = new javax.swing.JScrollPane();
        tblErroresScript = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblParches = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        
        GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addComponent(jScrollPane1))
                        .addGap(14, 14, 14))))
            .addGroup(layout.createSequentialGroup()
                .addGap(478, 478, 478)
                .addComponent(btnCancelar)
                .addGap(0, 465, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCancelar)
                .addContainerGap(7, Short.MAX_VALUE))
        );
    }
    
    @Override
	protected void initEvents() {
		pantallaVerErroresScriptListener = new PantallaVerErroresScriptListener(this);
		
		btnCancelar.setActionCommand(Constants.PANTALLA_VER_ERRORES_SCRIPT_BTN_CANCELAR);

		btnCancelar.addActionListener(pantallaVerErroresScriptListener);
		
		this.addOnLoadListener(pantallaVerErroresScriptListener);
	}
    
    @Override
	protected void initModels() {
		Cabecera cabecera = MDSQLUIHelper.createCabeceraTabla(Constants.VER_ERRORES_TABLA_CABECERA);
		tblErroresScript.setModel(new SeleccionHistoricoTableModel(cabecera.getColumnIdentifiers(), cabecera.getColumnClasses()));
	}	
    
    @Override
	protected void initialState() {}

	@Override
	protected void setupLiterals() {
		setTitle("Ver Errores Script");
		
		jLabel1.setText("Parches asociados");
		btnCancelar.setText("CANCELAR");
	}

	@Override
	protected void initMenuBar() {}
}
