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

import com.mdsql.ui.listener.PantallaVerCuadresScriptListener;
import com.mdsql.ui.model.CuadresObjetosTableModel;
import com.mdsql.ui.model.CuadresOperacionesTableModel;
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
public class PantallaVerCuadresScript extends DialogSupport {

    private static final long serialVersionUID = 1L;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton btnCancelar;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    
    @Getter
    private TableSupport tblOperaciones;
    
    @Getter
    private TableSupport tblObjetos;
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
    	jScrollPane1 = new JScrollPane();
        tblOperaciones = new TableSupport(Boolean.FALSE);
        jScrollPane2 = new JScrollPane();
        tblObjetos = new TableSupport(Boolean.FALSE);
        jLabel1 = new JLabel();
        btnCancelar = new JButton();
        jLabel2 = new JLabel();

        jScrollPane1.setViewportView(tblOperaciones);
        jScrollPane2.setViewportView(tblObjetos);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCancelar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, GroupLayout.DEFAULT_SIZE, 603, Short.MAX_VALUE)
                            .addComponent(jLabel2))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCancelar)
                .addContainerGap())
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
		Cabecera cabecera = MDSQLUIHelper.createCabeceraTabla(Constants.VER_CUADRES_OPERACIONES_TABLA_CABECERA);
		tblOperaciones.setModel(new CuadresOperacionesTableModel(cabecera.getColumnIdentifiers(), cabecera.getColumnClasses()));
		
		cabecera = MDSQLUIHelper.createCabeceraTabla(Constants.VER_CUADRES_OBJETOS_TABLA_CABECERA);
		tblObjetos.setModel(new CuadresObjetosTableModel(cabecera.getColumnIdentifiers(), cabecera.getColumnClasses()));
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
}
