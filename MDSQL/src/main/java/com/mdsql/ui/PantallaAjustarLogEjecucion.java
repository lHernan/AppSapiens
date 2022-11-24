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
import javax.swing.JTextField;
import javax.swing.table.TableModel;

import com.mdsql.ui.listener.PantallaAjustarLogEjecucionListener;
import com.mdsql.ui.model.AjustarLogEjecucionTableModel;
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
public class PantallaAjustarLogEjecucion extends DialogSupport {

    private static final long serialVersionUID = 1L;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton btnCancelar;
    private JButton btnEliminar;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JScrollPane jScrollPane1;
    
    @Getter
    private TableSupport tblAjustarLog;
    
    private JTextField txtComentario;
    // End of variables declaration//GEN-END:variables
    
   	public PantallaAjustarLogEjecucion(FrameSupport parent, Boolean modal) {
   		super(parent, modal);
   	}

   	public PantallaAjustarLogEjecucion(FrameSupport parent, Boolean modal, Map<String, Object> params) {
   		super(parent, modal, params);
   	}
    
   	@Override
	protected void setupComponents() {
   		jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAjustarLog = new TableSupport(Boolean.FALSE);
        jLabel2 = new javax.swing.JLabel();
        txtComentario = new javax.swing.JTextField();
        btnEliminar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        
        GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(39, 39, 39)
                        .addComponent(txtComentario))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 12, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addGap(20, 20, 20))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(346, 346, 346))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtComentario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliminar)
                    .addComponent(btnCancelar))
                .addContainerGap(14, Short.MAX_VALUE))
        );
   	}
    
   	@Override
   	protected void initEvents() {
   		PantallaAjustarLogEjecucionListener pantallaAjustarLogEjecucionListener = new PantallaAjustarLogEjecucionListener(this);
   	
   		btnEliminar.setActionCommand(Constants.PANTALLA_AJUSTAR_LOG_EJECUCION_ELIMINAR);
   		btnCancelar.setActionCommand(Constants.PANTALLA_AJUSTAR_LOG_EJECUCION_CANCELAR);
   		
   		btnEliminar.addActionListener(pantallaAjustarLogEjecucionListener);
   		btnCancelar.addActionListener(pantallaAjustarLogEjecucionListener);
   		
   		this.addOnLoadListener(pantallaAjustarLogEjecucionListener);
    }
    
    @Override
	protected void initModels() {
    	Cabecera cabecera = MDSQLUIHelper.createCabeceraTabla(Constants.DLG_AJUSTAR_LOG_EJECUCION_TABLA_CABECERA);
    	TableModel ajustarLogEjecucion = new AjustarLogEjecucionTableModel(cabecera.getColumnIdentifiers(), cabecera.getColumnClasses());
    	
    	tblAjustarLog.setModel(ajustarLogEjecucion);
    }
    
    @Override
   	protected void initialState() {}

   	@Override
   	protected void setupLiterals() {
   		jLabel1.setText("Si alguna de las sentencias ejecutadas correctamente se han eliminado del script procesado una vez ejecutado, se pueden eliminar del cuadre de objetos desde esta pantalla");
   		jLabel2.setText("Comentario");
        btnEliminar.setText("Eliminar");
        btnCancelar.setText("CANCELAR");
   	}   
}
