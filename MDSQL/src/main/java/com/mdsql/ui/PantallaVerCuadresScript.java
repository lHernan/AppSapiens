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

import com.mdsql.ui.listener.PantallaVerCuadresScriptListener;
import com.mdsql.ui.model.CuadresObjetosTableModel;
import com.mdsql.ui.model.CuadresOperacionesTableModel;
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
        
        setBounds(1400, 400);

        jScrollPane1.setViewportView(tblOperaciones);
        jScrollPane2.setViewportView(tblObjetos);
        
        GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCancelar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 521, Short.MAX_VALUE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 736, Short.MAX_VALUE)
                            .addComponent(jLabel2))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
		tblOperaciones.initModel(new CuadresOperacionesTableModel(cabecera));
		
		cabecera = MDSQLUIHelper.createCabeceraTabla(Constants.VER_CUADRES_OBJETOS_TABLA_CABECERA);
		tblObjetos.initModel(new CuadresObjetosTableModel(cabecera));
	}	
    
    @Override
	protected void initialState() {}

	@Override
	protected void setupLiterals() {
		setTitle(literales.getLiteral("PantallaVerCuadresScipt.titulo"));
		
		jLabel1.setText(literales.getLiteral("PantallaVerCuadresScipt.label1"));
		jLabel2.setText(literales.getLiteral("PantallaVerCuadresScipt.label2"));
        btnCancelar.setText(literales.getLiteral("PantallaVerCuadresScipt.cancelar"));
	}
}
