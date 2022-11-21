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
import javax.swing.LayoutStyle;

import com.mdsql.ui.listener.PantallaVerErroresScriptListener;
import com.mdsql.ui.model.VerErroresScriptTableModel;
import com.mdsql.ui.model.VerParchesScriptTableModel;
import com.mdsql.ui.model.cabeceras.Cabecera;
import com.mdsql.ui.utils.MDSQLUIHelper;
import com.mdsql.utils.Constants;
import com.mdval.ui.utils.DialogSupport;
import com.mdval.ui.utils.FrameSupport;
import com.mdval.ui.utils.TableSupport;

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
    private TableSupport tblErroresScript;
    private TableSupport tblParches;
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
    	jScrollPane1 = new JScrollPane();
        tblErroresScript = new TableSupport(Boolean.FALSE);
        jScrollPane2 = new JScrollPane();
        tblParches = new TableSupport(Boolean.FALSE);
        jLabel1 = new JLabel();
        btnCancelar = new JButton();

        jScrollPane1.setViewportView(tblErroresScript);

        jScrollPane2.setViewportView(tblParches);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnCancelar))
                            .addComponent(jScrollPane2, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1015, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, GroupLayout.Alignment.LEADING))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCancelar)
                .addContainerGap())
        );
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
	
		cabecera = MDSQLUIHelper.createCabeceraTabla(Constants.VER_PARCHES_TABLA_CABECERA);
		tblParches.setModel(new VerParchesScriptTableModel(cabecera.getColumnIdentifiers(), cabecera.getColumnClasses()));
    }	
    
    @Override
	protected void initialState() {}

	@Override
	protected void setupLiterals() {
		setTitle("Ver Errores Script");
		
		jLabel1.setText("Parches asociados");
		btnCancelar.setText("CANCELAR");
	}
}
