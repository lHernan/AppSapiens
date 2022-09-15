/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mdsql.ui;

import java.util.Map;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

import com.mdsql.ui.model.DefinicionModelosTableModel;
import com.mdsql.ui.model.cabeceras.Cabecera;
import com.mdsql.ui.utils.MDSQLUIHelper;
import com.mdsql.utils.Constants;
import com.mdval.ui.utils.DialogSupport;
import com.mdval.ui.utils.FrameSupport;

import lombok.Getter;

/**
 *
 * @author USUARIO1
 */
public class PantallaEjecutarScripts extends DialogSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3475243773559272110L;
	
	// Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton btnRechazar;
    private JButton btnVerLog;
    private JButton btnDetalleScript;
    private JButton btnDescartar;
    private JButton btnReparar;
    private JButton btnVerCuadros;
    private JButton btnVerErrores;
    private JButton btnExcepcion;
    private JButton btnAceptar;
    private JButton btnCancelar;
    
    private JLabel jLabel1;
    private JLabel jLabel10;
    private JLabel jLabel11;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JTable tblVigente;
    private JTable tblHistorico;
    
    @Getter
    private JComboBox<String> jComboBox1;
    
    @Getter
    private JTextField txtEstadoEjec;
    
    @Getter
    private JTextField txtModeloProyecto;
    
    @Getter
    private JTextField txtSubmodelo;
    
    @Getter
    private JTextField txtSD;
    
    @Getter
    private JTextField txtSolicitar;
    
    @Getter
    private JTextField txtEsquema;
    
    @Getter
    private JTextField txtBBDDHistorico;
    
    @Getter
    private JTextField txtEsquemaHistorico;
    // End of variables declaration//GEN-END:variables
    
    public PantallaEjecutarScripts(FrameSupport parent, Boolean modal) {
        super(parent, modal);
    }
    
    public PantallaEjecutarScripts(FrameSupport parent, Boolean modal, Map<String, Object> params) {
        super(parent, modal, params);
    }

    @Override
	protected void setupComponents() {

        jLabel1 = new JLabel();
        txtEstadoEjec = new JTextField();
        jLabel2 = new JLabel();
        txtModeloProyecto = new JTextField();
        jLabel3 = new JLabel();
        txtSubmodelo = new JTextField();
        jLabel4 = new JLabel();
        txtSD = new JTextField();
        jLabel5 = new JLabel();
        txtSolicitar = new JTextField();
        jLabel6 = new JLabel();
        txtEsquema = new JTextField();
        jLabel7 = new JLabel();
        jLabel8 = new JLabel();
        txtBBDDHistorico = new JTextField();
        jComboBox1 = new JComboBox<>();
        jLabel9 = new JLabel();
        txtEsquemaHistorico = new JTextField();
        jLabel10 = new JLabel();
        jScrollPane1 = new JScrollPane();
        tblVigente = new JTable();
        jScrollPane2 = new JScrollPane();
        tblHistorico = new JTable();
        jLabel11 = new JLabel();
        btnRechazar = new JButton();
        btnVerLog = new JButton();
        btnDetalleScript = new JButton();
        btnDescartar = new JButton();
        btnReparar = new JButton();
        btnVerCuadros = new JButton();
        btnVerErrores = new JButton();
        btnExcepcion = new JButton();
        btnAceptar = new JButton();
        btnCancelar = new JButton();

        jScrollPane1.setViewportView(tblVigente);
        jScrollPane2.setViewportView(tblHistorico);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtBBDDHistorico, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtEsquema, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSolicitar, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSD, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtSubmodelo, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtModeloProyecto, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtEstadoEjec, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(btnRechazar)
                            .addComponent(txtEsquemaHistorico, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE))))
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnVerLog)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDetalleScript)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDescartar)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnReparar)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnVerCuadros)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnVerErrores)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExcepcion))
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane1))
                .addContainerGap(12, Short.MAX_VALUE))
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAceptar)
                .addGap(18, 18, 18)
                .addComponent(btnCancelar)
                .addGap(202, 202, 202))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtEstadoEjec, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtModeloProyecto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtSubmodelo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtSD, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtSolicitar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtEsquema, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtBBDDHistorico, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtEsquemaHistorico, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addComponent(btnRechazar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVerLog)
                    .addComponent(btnDetalleScript)
                    .addComponent(btnDescartar)
                    .addComponent(btnReparar)
                    .addComponent(btnVerCuadros)
                    .addComponent(btnVerErrores)
                    .addComponent(btnExcepcion))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar)
                    .addComponent(btnCancelar))
                .addContainerGap(29, Short.MAX_VALUE))
        );
    }

	@Override
	protected void initEvents() {
		// TODO Auto-generated method stub
		 btnRechazar.setActionCommand(Constants.PANTALLA_EJECUTAR_SCRIPTS_BTN_RECHAZAR);
		 btnVerLog.setActionCommand(Constants.PANTALLA_EJECUTAR_SCRIPTS_BTN_VER_LOG);
		 btnDetalleScript.setActionCommand(Constants.PANTALLA_EJECUTAR_SCRIPTS_BTN_DETALLE_SCRIPT);
		 btnDescartar.setActionCommand(Constants.PANTALLA_EJECUTAR_SCRIPTS_BTN_DESCARTAR);
		 btnReparar.setActionCommand(Constants.PANTALLA_EJECUTAR_SCRIPTS_BTN_REPARAR);
		 btnVerCuadros.setActionCommand(Constants.PANTALLA_EJECUTAR_SCRIPTS_BTN_VER_CUADROS);
		 btnVerErrores.setActionCommand(Constants.PANTALLA_EJECUTAR_SCRIPTS_BTN_VER_ERRORES);
		 btnExcepcion.setActionCommand(Constants.PANTALLA_EJECUTAR_SCRIPTS_BTN_EXCEPCION);
		 btnAceptar.setActionCommand(Constants.PANTALLA_EJECUTAR_SCRIPTS_BTN_ACEPTAR);
		 btnCancelar.setActionCommand(Constants.PANTALLA_EJECUTAR_SCRIPTS_BTN_CANCELAR);
	}

	@Override
	protected void initModels() {
		jComboBox1.setModel(new DefaultComboBoxModel<>(new String[] { "", "Item 2", "Item 3", "Item 4" }));

		Cabecera cabecera = MDSQLUIHelper.createCabeceraTabla(Constants.FRM_DEFINICION_SCRIPTS_TABLA_CABECERA);
		//tblHistorico.setModel(new DefinicionModelosTableModel(cabecera.getColumnIdentifiers(), cabecera.getColumnClasses()));
		//tblVigente.setModel(new DefinicionModelosTableModel(cabecera.getColumnIdentifiers(), cabecera.getColumnClasses()));
		
		
	}

	@Override
	protected void initialState() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void setupLiterals() {
		jLabel1.setText("Estado ejecucion");
		jLabel2.setText("Modelo o proyecto");
        jLabel3.setText("Submodelo");
        jLabel4.setText("SD");
        jLabel5.setText("Solicitar por");
        jLabel6.setText("Esquema");
        jLabel7.setText("BBDD");
        jLabel8.setText("BBDD historico");
        jLabel11.setText("Histórico");
        btnRechazar.setText("Rechazar");
        btnVerLog.setText("Ver Log");
        btnDetalleScript.setText("Detalle Script");
        btnDescartar.setText("Descartar");
        btnReparar.setText("Reparar");
        btnVerCuadros.setText("Ver cuadros");
        btnVerErrores.setText("Ver Errores");
        btnExcepcion.setText("Excepcion");
        btnAceptar.setText("ACEPTAR");
        btnCancelar.setText("CANCELAR");
        jLabel9.setText("Esquema historico");
        jLabel10.setText("Vigente");
	}
}
