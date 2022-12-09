/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mdsql.ui;

import java.util.Map;

import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.table.TableModel;

import com.mdsql.ui.listener.PantallaInformacionModeloListener;
import com.mdsql.ui.model.InformacionModeloTableModel;
import com.mdsql.ui.utils.MDSQLUIHelper;
import com.mdsql.utils.Constants;
import com.mdval.ui.model.cabeceras.Cabecera;
import com.mdval.ui.utils.DialogSupport;
import com.mdval.ui.utils.FrameSupport;

import lombok.Getter;

/**
 *
 * @author USUARIO1
 */
public class PantallaInformacionModelo extends DialogSupport {

    private static final long serialVersionUID = 1L;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JLabel jLabel1;
    private JScrollPane jScrollPane1;
    
    @Getter
    private JTable tblInformacion;
    
    private JTextField txtModelo;
    // End of variables declaration//GEN-END:variables
    
    public PantallaInformacionModelo(FrameSupport parent, Boolean modal) {
        super(parent, modal);
    }
    
    public PantallaInformacionModelo(FrameSupport parent, Boolean modal, Map<String, Object> params) {
        super(parent, modal, params);
    }
    
    @Override
   	protected void setupComponents() {
    	jLabel1 = new JLabel();
        txtModelo = new JTextField();
        jScrollPane1 = new JScrollPane();
        tblInformacion = new JTable();
        
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel1)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtModelo, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 857, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtModelo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 324, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

    }
    
    @Override
   	protected void initEvents() {
    	PantallaInformacionModeloListener pantallaInformacionModeloListener = new PantallaInformacionModeloListener(this);
    	addOnLoadListener(pantallaInformacionModeloListener);
    }
    
    @Override
	protected void initModels() {
    	Cabecera cabecera = MDSQLUIHelper.createCabeceraTabla(Constants.DLG_INFORMACION_MODELO_TABLA_CABECERA);
    	TableModel informacionModeloTableModel = new InformacionModeloTableModel(cabecera.getColumnIdentifiers(), cabecera.getColumnClasses());
    	
    	tblInformacion.setModel(informacionModeloTableModel);
    }
    
    @Override
   	protected void initialState() {}

   	@Override
   	protected void setupLiterals() {
   		jLabel1.setText("Modelo o proyecto");
   	}    
}
