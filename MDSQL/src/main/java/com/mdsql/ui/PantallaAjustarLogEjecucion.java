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
import javax.swing.LayoutStyle;
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
   		jLabel1 = new JLabel();
        jScrollPane1 = new JScrollPane();
        tblAjustarLog = new TableSupport(Boolean.FALSE);
        jLabel2 = new JLabel();
        txtComentario = new JTextField();
        btnEliminar = new JButton();
        btnCancelar = new JButton();
        
        jScrollPane1.setViewportView(tblAjustarLog);
        
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(39, 39, 39)
                        .addComponent(txtComentario))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 12, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addGap(20, 20, 20))
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEliminar, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
                .addGap(346, 346, 346))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtComentario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
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
   	protected void initialState() {
    	Boolean consulta = (Boolean) this.getParams().get("consulta");
    	
    	if (consulta) {
    		txtComentario.setEnabled(Boolean.FALSE);
    		btnEliminar.setEnabled(Boolean.FALSE);
    	}
    }

   	@Override
   	protected void setupLiterals() {
   		jLabel1.setText("Si alguna de las sentencias ejecutadas correctamente se han eliminado del script procesado una vez ejecutado, se pueden eliminar del cuadre de objetos desde esta pantalla");
   		jLabel2.setText("Comentario");
        btnEliminar.setText("Eliminar");
        btnCancelar.setText("CANCELAR");
   	}   
}
