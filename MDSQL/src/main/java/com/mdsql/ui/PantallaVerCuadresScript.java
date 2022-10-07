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

import com.mdsql.ui.listener.PantallaVerCuadresScriptListener;
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
public class PantallaVerCuadresScript extends FrameSupport {

    private static final long serialVersionUID = 1L;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton btnCancelar;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JTable tblOperaciones;
    private JTable tblObjetos;
    // End of variables declaration//GEN-END:variables
    
    private PantallaVerCuadresScriptListener pantallaVerCuadresScriptListener;
    
    public PantallaVerCuadresScript(FrameSupport parent, Boolean modal) {
        super(parent, modal);
    }
    
    public PantallaVerCuadresScript(FrameSupport parent, Boolean modal, Map<String, Object> params) {
        super(parent, modal, params);
    }
    
    @Override
   	protected void setupComponents() {
    	jScrollPane1 = new javax.swing.JScrollPane();
        tblOperaciones = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblObjetos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        
        GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 595, Short.MAX_VALUE)
                    .addComponent(jLabel2))
                .addGap(25, 25, 25))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancelar)
                .addGap(469, 469, 469))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(26, 26, 26)
                .addComponent(btnCancelar)
                .addGap(28, 28, 28))
        );

    }
    
    @Override
   	protected void initEvents() {
   		pantallaVerCuadresScriptListener = new PantallaVerCuadresScriptListener(this);
   		
   		btnCancelar.setActionCommand(Constants.PANTALLA_VER_CUADRES_SCRIPT_BTN_CANCELAR);

   		btnCancelar.addActionListener(pantallaVerCuadresScriptListener);
   		
   		this.addOnLoadListener(pantallaVerCuadresScriptListener);
   	}
    
    @Override
	protected void initModels() {
		Cabecera cabecera = MDSQLUIHelper.createCabeceraTabla(Constants.VER_CUADRES_TABLA_CABECERA);
		tblOperaciones.setModel(new SeleccionHistoricoTableModel(cabecera.getColumnIdentifiers(), cabecera.getColumnClasses()));
	}	
    
    @Override
	protected void initialState() {}

	@Override
	protected void setupLiterals() {
		setTitle("Ver Descuadres Script");
		
		jLabel1.setText("Operaciones");
		jLabel2.setText("Objetos");
        btnCancelar.setText("CANCELAR");
	}

	@Override
	protected void initMenuBar() {}    
}
