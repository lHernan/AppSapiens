/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mdsql.ui;

import java.awt.Dimension;
import java.util.Map;
import java.util.Objects;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

import com.mdsql.ui.listener.PantallaResumenProcesadoActionListener;
import com.mdsql.ui.model.ResumenProcesadoObjetosTableModel;
import com.mdsql.ui.model.ResumenProcesadoOperacionesTableModel;
import com.mdsql.ui.model.ResumenProcesadoScriptsTableModel;
import com.mdsql.ui.model.cabeceras.Cabecera;
import com.mdsql.ui.utils.MDSQLUIHelper;
import com.mdsql.utils.Constants;
import com.mdval.ui.utils.FrameSupport;
import com.mdval.ui.utils.TableSupport;

import lombok.Getter;

/**
 *
 * @author federico
 */
public class PantallaResumenProcesado extends FrameSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7845375531319490239L;
	// Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton btnCancelar;
    private JButton btnDetalleScript;
    private JButton btnEntregar;
    private JButton btnVerErrores;
    private JButton btnVerLog;
    private JLabel jLabel1;
    private JLabel jLabel10;
    private JLabel jLabel11;
    private JLabel jLabel12;
    private JLabel jLabel13;
    private JLabel jLabel14;
    private JLabel jLabel15;
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
    private JScrollPane jScrollPane3;
    private JScrollPane jScrollPane4;
    
    @Getter
    private JTextField txtBBDD;
    
    @Getter
    private JTextField txtBBDDHistorico;
    
    @Getter
    private JTextArea txtComentarios;
    
    @Getter
    private JTextField txtEsquema;
    
    @Getter
    private JTextField txtEsquemaHistorico;
    
    @Getter
    private JTextField txtEstado;
    
    @Getter
    private JTextField txtFecha;
    
    @Getter
    private JTextField txtModelo;
    
    @Getter
    private JTextField txtPeticion;
    
    @Getter
    private JTextField txtRuta;
    
    @Getter
    private JTextField txtSolicitadaPor;
    
    @Getter
    private JTextField txtSubmodelo;
    
    @Getter
    private JTextField txtUsuario;
    
    @Getter
    private TableSupport tblObjetos;
    
    @Getter
    private TableSupport tblOperaciones;
    
    @Getter
    private TableSupport tblScripts;
    // End of variables declaration//GEN-END:variables
		
	/**
	 * @param params
	 */
	public PantallaResumenProcesado(FrameSupport parent, Boolean modal) {
		super(parent, modal);
	}

	/**
	 * Creates new form
	 */
	public PantallaResumenProcesado(FrameSupport parent, Boolean modal, Map<String, Object> params) {
		super(parent, modal, params);
	}

	@Override
	protected void setupComponents() {
		jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        jLabel7 = new JLabel();
        jLabel8 = new JLabel();
        jLabel9 = new JLabel();
        txtModelo = new JTextField();
        txtPeticion = new JTextField();
        txtSolicitadaPor = new JTextField();
        txtFecha = new JTextField();
        txtEsquemaHistorico = new JTextField();
        jScrollPane2 = new JScrollPane();
        tblScripts = new TableSupport(Boolean.FALSE);
        btnVerLog = new JButton();
        btnCancelar = new JButton();
        txtSubmodelo = new JTextField();
        jLabel13 = new JLabel();
        txtUsuario = new JTextField();
        txtBBDD = new JTextField();
        jLabel14 = new JLabel();
        btnVerErrores = new JButton();
        btnDetalleScript = new JButton();
        btnEntregar = new JButton();
        txtEsquema = new JTextField();
        jLabel5 = new JLabel();
        txtBBDDHistorico = new JTextField();
        txtEstado = new JTextField();
        txtRuta = new JTextField();
        jLabel6 = new JLabel();
        jLabel10 = new JLabel();
        jLabel15 = new JLabel();
        jScrollPane1 = new JScrollPane();
        txtComentarios = new JTextArea();
        jLabel11 = new JLabel();
        jScrollPane3 = new JScrollPane();
        tblOperaciones = new TableSupport(Boolean.FALSE);
        jScrollPane4 = new JScrollPane();
        tblObjetos = new TableSupport(Boolean.FALSE);
        jLabel12 = new JLabel();
        
        setMinimumSize(new Dimension(1522, 990));

        jScrollPane2.setViewportView(tblScripts);

        txtComentarios.setColumns(20);
        txtComentarios.setRows(5);
        jScrollPane1.setViewportView(txtComentarios);

        jScrollPane3.setViewportView(tblOperaciones);

        jScrollPane4.setViewportView(tblObjetos);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel15)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2, GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel3, GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel13, GroupLayout.Alignment.TRAILING)))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtPeticion, GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                                    .addComponent(txtModelo)
                                    .addComponent(txtSubmodelo)
                                    .addComponent(txtUsuario))
                                .addGap(50, 50, 50)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel5))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtFecha, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel10)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtRuta, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtEsquema, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel6)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtEstado, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(txtBBDD, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel9)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtEsquemaHistorico, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(txtSolicitadaPor, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE)
                                        .addGap(66, 66, 66)
                                        .addComponent(jLabel7)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtBBDDHistorico, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 959, GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(jScrollPane3, GroupLayout.PREFERRED_SIZE, 380, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane4)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addComponent(jScrollPane2)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnVerLog, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnVerErrores, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnDetalleScript, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnEntregar, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(txtModelo, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(txtSolicitadaPor, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtBBDDHistorico, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSubmodelo, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtBBDD, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEsquemaHistorico, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPeticion, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtEsquema, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(txtEstado, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(txtUsuario, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel13))
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(txtFecha, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5))
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(txtRuta, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10)))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4)
                    .addComponent(jScrollPane3))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnEntregar)
                    .addComponent(btnDetalleScript)
                    .addComponent(btnVerErrores)
                    .addComponent(btnVerLog))
                .addContainerGap())
        );
	}

	@Override
	protected void initEvents() {
		PantallaResumenProcesadoActionListener actionListener = new PantallaResumenProcesadoActionListener(this);
		
		this.addOnLoadListener(actionListener);
	}

	@Override
	protected void initModels() {
		Cabecera cabeceraScripts = MDSQLUIHelper.createCabeceraTabla(Constants.RESUMEN_PROCESADO_SCRIPTS_TABLA_CABECERA);
		tblScripts.setModel(
				new ResumenProcesadoScriptsTableModel(cabeceraScripts.getColumnIdentifiers(), cabeceraScripts.getColumnClasses()));
		
		Cabecera cabeceraOperaciones = MDSQLUIHelper.createCabeceraTabla(Constants.RESUMEN_PROCESADO_OPERACIONES_TABLA_CABECERA);
		tblOperaciones.setModel(
				new ResumenProcesadoOperacionesTableModel(cabeceraOperaciones.getColumnIdentifiers(), cabeceraOperaciones.getColumnClasses()));
		
		Cabecera cabeceraObjetos = MDSQLUIHelper.createCabeceraTabla(Constants.RESUMEN_PROCESADO_OBJETOS_TABLA_CABECERA);
		tblObjetos.setModel(
				new ResumenProcesadoObjetosTableModel(cabeceraObjetos.getColumnIdentifiers(), cabeceraObjetos.getColumnClasses()));
	}

	@Override
	protected void initialState() {
		Boolean entregar = (Boolean) params.get("entregar");
		if (!Objects.isNull(entregar) && entregar.equals(Boolean.FALSE)) {
			btnEntregar.setEnabled(Boolean.FALSE);
		}
		
		txtModelo.setEnabled(Boolean.FALSE);
        txtPeticion.setEnabled(Boolean.FALSE);
        txtSolicitadaPor.setEnabled(Boolean.FALSE);
        txtFecha.setEnabled(Boolean.FALSE);
        txtEsquemaHistorico.setEnabled(Boolean.FALSE);
        txtSubmodelo.setEnabled(Boolean.FALSE);
        txtUsuario.setEnabled(Boolean.FALSE);
        txtBBDD.setEnabled(Boolean.FALSE);
        txtEsquema.setEnabled(Boolean.FALSE);
        txtBBDDHistorico.setEnabled(Boolean.FALSE);
        txtEstado.setEnabled(Boolean.FALSE);
        txtRuta.setEnabled(Boolean.FALSE);
	}

	@Override
	protected void setupLiterals() {
		setTitle("Resumen ejecución");
		
		jLabel1.setText("Modelo o proyecto");
        jLabel2.setText("Submodelo");
        jLabel3.setText("Petición");
        jLabel4.setText("Solicitada por");
        jLabel7.setText("BBDD histórico");
        jLabel8.setText("BBDD");
        jLabel9.setText("Esquema histórico");
        btnVerLog.setText("Ver log");
        btnCancelar.setText("CANCELAR");
        jLabel13.setText("Usuario");
        jLabel14.setText("Esquema");
        btnVerErrores.setText("Ver errores");
        btnDetalleScript.setText("Detalle script");
        btnEntregar.setText("Entregar");
        jLabel5.setText("Fecha");
        jLabel6.setText("Estado");
        jLabel10.setText("Ruta");
        jLabel15.setText("Comentarios");
        jLabel11.setText("Operaciones");
        jLabel12.setText("Objetos");
	}

	@Override
	protected void initMenuBar() {}
}
