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

import com.mdsql.ui.listener.PantallaVerErroresScriptListener;
import com.mdsql.ui.model.VerErroresScriptTableModel;
import com.mdsql.ui.model.VerParchesScriptTableModel;
import com.mdsql.ui.utils.MDSQLUIHelper;
import com.mdsql.utils.Constants;
import com.mdval.ui.model.cabeceras.Cabecera;
import com.mdval.ui.utils.DialogSupport;
import com.mdval.ui.utils.FrameSupport;
import com.mdval.ui.utils.TableSupport;

import lombok.Getter;

/**
 *
 * @author USUARIO1
 */
public class PantallaVerErroresScript extends DialogSupport {

	private static final long serialVersionUID = 1L;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton btnCancelar;
    private JLabel jLabel1;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    
    @Getter
    private TableSupport tblErroresScript;
    
    @Getter
    private TableSupport tblParches;
    // End of variables declaration//GEN-END:variables

    public PantallaVerErroresScript(FrameSupport parent, Boolean modal) {
        super(parent, modal);
    }
    
    public PantallaVerErroresScript(FrameSupport parent, Boolean modal, Map<String, Object> params) {
        super(parent, modal, params);
    }
    
    @Override
   	protected void setupComponents() {
    	jScrollPane1 = new JScrollPane();
        tblErroresScript = new TableSupport(Boolean.FALSE);
        jScrollPane2 = new JScrollPane();
        tblParches = new TableSupport(Boolean.FALSE);
        jLabel1 = new JLabel();
        btnCancelar = new JButton();
    	
        setBounds(1700, 600);
        
        jScrollPane1.setViewportView(tblErroresScript);
        if (tblErroresScript.getColumnModel().getColumnCount() > 0) {
            tblErroresScript.getColumnModel().getColumn(0).setPreferredWidth(100);
            tblErroresScript.getColumnModel().getColumn(1).setPreferredWidth(120);
            tblErroresScript.getColumnModel().getColumn(2).setPreferredWidth(100);
            tblErroresScript.getColumnModel().getColumn(3).setPreferredWidth(120);
            tblErroresScript.getColumnModel().getColumn(4).setPreferredWidth(120);
            tblErroresScript.getColumnModel().getColumn(5).setPreferredWidth(350);
            tblErroresScript.getColumnModel().getColumn(6).setPreferredWidth(800);
        }
        jScrollPane2.setViewportView(tblParches);
        if (tblParches.getColumnModel().getColumnCount() > 0) {
            tblParches.getColumnModel().getColumn(0).setPreferredWidth(100);
            tblParches.getColumnModel().getColumn(1).setPreferredWidth(120);
            tblParches.getColumnModel().getColumn(2).setPreferredWidth(120);
            tblParches.getColumnModel().getColumn(3).setPreferredWidth(120);
            tblParches.getColumnModel().getColumn(4).setPreferredWidth(120);
            tblParches.getColumnModel().getColumn(5).setPreferredWidth(120);
            tblParches.getColumnModel().getColumn(6).setPreferredWidth(350);
            tblParches.getColumnModel().getColumn(7).setPreferredWidth(500);
        }
        
        GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCancelar))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1279, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCancelar)
                .addContainerGap())
        );

        pack();
    }
	
    @Override
	protected void initEvents() {
		PantallaVerErroresScriptListener actionListener = new PantallaVerErroresScriptListener(this);
		
		btnCancelar.setActionCommand(Constants.PANTALLA_VER_ERRORES_SCRIPT_BTN_CANCELAR);

		btnCancelar.addActionListener(actionListener);
		
		this.addOnLoadListener(actionListener);
	}
    
    @Override
	protected void initModels() {
		Cabecera cabecera = MDSQLUIHelper.createCabeceraTabla(Constants.VER_ERRORES_TABLA_CABECERA);
		tblErroresScript.setModel(new VerErroresScriptTableModel(cabecera.getColumnIdentifiers(), cabecera.getColumnClasses()));
		tblErroresScript.setColumnWidths(cabecera);
	
		cabecera = MDSQLUIHelper.createCabeceraTabla(Constants.VER_PARCHES_TABLA_CABECERA);
		tblParches.setModel(new VerParchesScriptTableModel(cabecera.getColumnIdentifiers(), cabecera.getColumnClasses()));
		tblParches.setColumnWidths(cabecera);
    }	
    
    @Override
	protected void initialState() {}

	@Override
	protected void setupLiterals() {
		setTitle(literales.getLiteral("PantallaVerErroresScipt.titulo"));
		
		jLabel1.setText(literales.getLiteral("PantallaVerErroresScipt.label1"));
		btnCancelar.setText(literales.getLiteral("PantallaVerErroresScipt.cancelar"));
	}
}
