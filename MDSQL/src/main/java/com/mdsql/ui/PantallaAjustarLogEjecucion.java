/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mdsql.ui;

import java.awt.Dimension;
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
        
        Dimension dimension = new Dimension(950, 400);
        setPreferredSize(dimension);
        setMinimunSize(dimension);
        setResizable(Boolean.TRUE);
        
        jScrollPane1.setViewportView(tblAjustarLog);
        
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEliminar, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(39, 39, 39)
                                .addComponent(txtComentario))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 23, Short.MAX_VALUE))
                            .addComponent(jScrollPane1))))
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtComentario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliminar)
                    .addComponent(btnCancelar))
                .addGap(15, 15, 15))
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
   		setTitle(literales.getLiteral("PantallaAjustarLogEjecucion.titulo"));
   		
   		jLabel1.setText(literales.getLiteral("PantallaAjustarLogEjecucion.label1"));
   		jLabel2.setText(literales.getLiteral("PantallaAjustarLogEjecucion.label2"));
        btnEliminar.setText(literales.getLiteral("PantallaAjustarLogEjecucion.eliminar"));
        btnCancelar.setText(literales.getLiteral("PantallaAjustarLogEjecucion.cancelar"));
   	}   
}
