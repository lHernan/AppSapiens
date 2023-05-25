/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mdsql.ui;

import java.awt.event.ItemListener;
import java.util.Map;
import java.util.Objects;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

import com.mdsql.bussiness.entities.BBDD;
import com.mdsql.bussiness.entities.Proceso;
import com.mdsql.bussiness.entities.Script;
import com.mdsql.ui.listener.PantallaEjecutarScriptsListener;
import com.mdsql.ui.listener.combo.EjecutarScriptBBDDItemListener;
import com.mdsql.ui.listener.tables.HistoricoScriptsTableListener;
import com.mdsql.ui.listener.tables.HistoricoScriptsTableModelListener;
import com.mdsql.ui.listener.tables.VigenteScriptsTableListener;
import com.mdsql.ui.listener.tables.VigenteScriptsTableModelListener;
import com.mdsql.ui.model.BBDDComboBoxModel;
import com.mdsql.ui.model.ScriptsTableModel;
import com.mdsql.ui.renderer.BBDDRenderer;
import com.mdsql.ui.renderer.ScriptTableCellRenderer;
import com.mdsql.ui.utils.MDSQLUIHelper;
import com.mdsql.utils.MDSQLConstants;
import com.mdval.ui.model.cabeceras.Cabecera;
import com.mdval.ui.utils.DialogSupport;
import com.mdval.ui.utils.FrameSupport;
import com.mdval.ui.utils.TableSupport;

import lombok.Getter;
import lombok.Setter;

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
	
	@Getter
	private JButton btnVerLog;
	
	@Getter
	private JButton btnDetalleScript;
	
	@Getter
	private JButton btnDescartar;
	
	@Getter
	private JButton btnReparar;
	
	@Getter
	private JButton btnVerErrores;
	
	@Getter
	private JButton btnExcepcion;
	
	@Getter
	private JButton btnAceptar;
	
	private JButton btnCancelar;

	private JLabel jLabel1;
	private JLabel jLabel11;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JLabel jLabel7;
	private JLabel jLabel8;
	private JLabel jLabel9;
	private JScrollPane jScrollPane2;

	@Getter
	private JTextField txtSubmodelo;

	@Getter
	private JTextField txtSolicitar;

	@Getter
	private JTextField txtEsquema;

	@Getter
	private JTextField txtBBDDHistorico;

	@Getter
	private JTextField txtEsquemaHistorico;
	// End of variables declaration//GEN-END:variables

	@Getter
	private JTextField txtEstadoEjecucion;

	@Getter
	private JTextField txtSolicitadaPor;

	@Getter
	private JComboBox<BBDD> cmbBBDD;

	@Getter
	private TableSupport tblVigente;
	
	@Getter
	private TableSupport tblHistorico;
	
	private JLabel jLabel12;

	private JScrollPane jScrollPane3;

	@Getter
	private JTextField txtModelo;

	private JLabel jLabel13;

	private JLabel jLabel14;

	@Getter
	private JButton btnVerCuadres;

	@Getter
	private JTextField txtDemanda;

	private JLabel jLabel5;

	@Getter
	private JTextField txtPeticion;
	
	@Getter
	@Setter
	private Script seleccionado;
	
	@Getter
	@Setter
	private Proceso proceso;

	public PantallaEjecutarScripts(FrameSupport parent, Boolean modal) {
		super(parent, modal);
	}

	public PantallaEjecutarScripts(FrameSupport parent, Boolean modal, Map<String, Object> params) {
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
        txtEstadoEjecucion = new JTextField();
        txtSubmodelo = new JTextField();
        txtSolicitadaPor = new JTextField();
        txtBBDDHistorico = new JTextField();
        cmbBBDD = new JComboBox<>();
        txtEsquemaHistorico = new JTextField();
        btnRechazar = new JButton();
        jLabel11 = new JLabel();
        jScrollPane2 = new JScrollPane();
        tblVigente = new TableSupport();
        jLabel12 = new JLabel();
        jScrollPane3 = new JScrollPane();
        tblHistorico = new TableSupport();
        btnAceptar = new JButton();
        btnCancelar = new JButton();
        txtModelo = new JTextField();
        jLabel13 = new JLabel();
        txtPeticion = new JTextField();
        txtEsquema = new JTextField();
        jLabel14 = new JLabel();
        btnVerLog = new JButton();
        btnDetalleScript = new JButton();
        btnDescartar = new JButton();
        btnReparar = new JButton();
        btnVerCuadres = new JButton();
        btnVerErrores = new JButton();
        btnExcepcion = new JButton();
        txtDemanda = new JTextField();
        jLabel5 = new JLabel();
        
        setBounds(1543, 876);

        jLabel1.setHorizontalAlignment(SwingConstants.RIGHT);
        
        jScrollPane2.setViewportView(tblVigente);

        jScrollPane3.setViewportView(tblHistorico);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(13, 13, 13)
                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel3, GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel13, GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addComponent(jLabel9, GroupLayout.Alignment.TRAILING))
                            .addComponent(jLabel7, GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8, GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel14, GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbBBDD, 0, 214, Short.MAX_VALUE)
                            .addComponent(txtSubmodelo)
                            .addComponent(txtSolicitadaPor)
                            .addComponent(txtBBDDHistorico)
                            .addComponent(txtEsquemaHistorico)
                            .addComponent(txtEstadoEjecucion)
                            .addComponent(txtModelo)
                            .addComponent(txtPeticion)
                            .addComponent(txtEsquema)
                            .addComponent(txtDemanda))
                        .addGap(39, 39, 39))
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnRechazar, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
                        .addGap(98, 98, 98)))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3, GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11, GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12, GroupLayout.Alignment.LEADING)
                            .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(btnVerLog, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnDetalleScript, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnDescartar, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnReparar, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnVerCuadres, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnVerErrores, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnExcepcion, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE))
                            .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(331, 331, 331)
                                .addComponent(btnAceptar, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(txtEstadoEjecucion, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1))
                    .addComponent(jLabel11))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel12))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(txtModelo, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSubmodelo, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPeticion, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSolicitadaPor, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEsquema, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbBBDD, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(txtBBDDHistorico, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEsquemaHistorico, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDemanda, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRechazar)))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVerLog)
                    .addComponent(btnDetalleScript)
                    .addComponent(btnDescartar)
                    .addComponent(btnReparar)
                    .addComponent(btnVerCuadres)
                    .addComponent(btnVerErrores)
                    .addComponent(btnExcepcion))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnAceptar))
                .addContainerGap())
        );
	}

	@Override
	protected void initEvents() {
		PantallaEjecutarScriptsListener actionListener = new PantallaEjecutarScriptsListener(this);
		VigenteScriptsTableListener vigenteSelectionListener = new VigenteScriptsTableListener(this);
		HistoricoScriptsTableListener historicoSelectionListener = new HistoricoScriptsTableListener(this);
		ItemListener bbddItemListener = new EjecutarScriptBBDDItemListener(this);
		
		btnRechazar.setActionCommand(MDSQLConstants.PANTALLA_EJECUTAR_SCRIPTS_BTN_RECHAZAR);
		btnVerLog.setActionCommand(MDSQLConstants.PANTALLA_EJECUTAR_SCRIPTS_BTN_VER_LOG);
		btnDetalleScript.setActionCommand(MDSQLConstants.PANTALLA_EJECUTAR_SCRIPTS_BTN_DETALLE_SCRIPT);
		btnDescartar.setActionCommand(MDSQLConstants.PANTALLA_EJECUTAR_SCRIPTS_BTN_DESCARTAR);
		btnReparar.setActionCommand(MDSQLConstants.PANTALLA_EJECUTAR_SCRIPTS_BTN_REPARAR);
		btnVerCuadres.setActionCommand(MDSQLConstants.PANTALLA_EJECUTAR_SCRIPTS_BTN_VER_CUADRES);
		btnVerErrores.setActionCommand(MDSQLConstants.PANTALLA_EJECUTAR_SCRIPTS_BTN_VER_ERRORES);
		btnExcepcion.setActionCommand(MDSQLConstants.PANTALLA_EJECUTAR_SCRIPTS_BTN_EXCEPCION);
		btnAceptar.setActionCommand(MDSQLConstants.PANTALLA_EJECUTAR_SCRIPTS_BTN_ACEPTAR);
		btnCancelar.setActionCommand(MDSQLConstants.PANTALLA_EJECUTAR_SCRIPTS_BTN_CANCELAR);

		btnRechazar.addActionListener(actionListener);
		btnVerLog.addActionListener(actionListener);
		btnDetalleScript.addActionListener(actionListener);
		btnDescartar.addActionListener(actionListener);
		btnReparar.addActionListener(actionListener);
		btnVerCuadres.addActionListener(actionListener);
		btnVerErrores.addActionListener(actionListener);
		btnExcepcion.addActionListener(actionListener);
		btnAceptar.addActionListener(actionListener);
		btnCancelar.addActionListener(actionListener);
		
		ListSelectionModel vigenteRowSM = tblVigente.getSelectionModel();
		vigenteRowSM.addListSelectionListener(vigenteSelectionListener);
		
		ListSelectionModel historicoRowSM = tblHistorico.getSelectionModel();
		historicoRowSM.addListSelectionListener(historicoSelectionListener);
		
		cmbBBDD.addItemListener(bbddItemListener);
		this.addOnLoadListener(actionListener);
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void initModels() {
		BBDDComboBoxModel bbddModel = new BBDDComboBoxModel();
		cmbBBDD.setModel(bbddModel);
		cmbBBDD.setRenderer(new BBDDRenderer());
		
		Cabecera cabecera = MDSQLUIHelper.createCabeceraTabla(MDSQLConstants.SCRIPTS_TABLA_CABECERA);
		
		// Hay que escuchar por cambios en el modelo, ya que se van a marcar / desmarcar los checks
		tblVigente.initModel(new ScriptsTableModel(cabecera));
		tblVigente.getModel().addTableModelListener(new VigenteScriptsTableModelListener(this));
		tblHistorico.initModel(new ScriptsTableModel(cabecera));
		tblHistorico.getModel().addTableModelListener(new HistoricoScriptsTableModelListener(this));
		
		tblVigente.setDefaultRenderer(String.class, new ScriptTableCellRenderer());
		tblHistorico.setDefaultRenderer(String.class, new ScriptTableCellRenderer());
	}

	@Override
	protected void initialState() {
		txtEstadoEjecucion.setEditable(Boolean.FALSE);
		txtModelo.setEditable(Boolean.FALSE);
		txtSubmodelo.setEditable(Boolean.FALSE);
		txtPeticion.setEditable(Boolean.FALSE);
		txtSolicitadaPor.setEditable(Boolean.FALSE);
		txtEsquema.setEditable(Boolean.FALSE);
		txtBBDDHistorico.setEditable(Boolean.FALSE);
		txtEsquemaHistorico.setEditable(Boolean.FALSE);
		txtDemanda.setEditable(Boolean.FALSE);
		
		enableButtons(Boolean.FALSE);
		
		if (!Objects.isNull(proceso)) {
			txtEstadoEjecucion.setText(proceso.getDescripcionEstadoProceso());
			txtModelo.setText(proceso.getModelo().getCodigoProyecto());
			txtSubmodelo.setText(proceso.getSubproyecto().getDescripcionSubProyecto());
			txtPeticion.setText(proceso.getCodigoPeticion());
			txtSolicitadaPor.setText(proceso.getCodigoUsrPeticion());
			txtEsquema.setText(proceso.getBbdd().getNombreEsquema());
			cmbBBDD.setSelectedItem(proceso.getBbdd());
			txtBBDDHistorico.setText(proceso.getBbdd().getNombreBBDDHis());
			txtEsquemaHistorico.setText(proceso.getBbdd().getNombreEsquemaHis());
			txtDemanda.setText(proceso.getCodigoDemanda());
		}
	}

	@Override
	protected void setupLiterals() {
		setTitle(literales.getLiteral("PantallaEjecutarScripts.title"));

		jLabel1.setText(literales.getLiteral("PantallaEjecutarScripts.label1"));
		jLabel2.setText(literales.getLiteral("PantallaEjecutarScripts.label2"));
		jLabel3.setText(literales.getLiteral("PantallaEjecutarScripts.label3"));
		jLabel4.setText(literales.getLiteral("PantallaEjecutarScripts.label4"));
		jLabel5.setText(literales.getLiteral("PantallaEjecutarScripts.label5"));
		jLabel7.setText(literales.getLiteral("PantallaEjecutarScripts.label7"));
		jLabel8.setText(literales.getLiteral("PantallaEjecutarScripts.label8"));
		jLabel9.setText(literales.getLiteral("PantallaEjecutarScripts.label9"));
		btnRechazar.setText(literales.getLiteral("PantallaEjecutarScripts.rechazar"));
		jLabel11.setText(literales.getLiteral("PantallaEjecutarScripts.label11"));
		jLabel12.setText(literales.getLiteral("PantallaEjecutarScripts.label12"));
		jLabel13.setText(literales.getLiteral("PantallaEjecutarScripts.label13"));
		jLabel14.setText(literales.getLiteral("PantallaEjecutarScripts.label14"));	
		btnVerLog.setText(literales.getLiteral("PantallaEjecutarScripts.verLog"));
		btnDetalleScript.setText(literales.getLiteral("PantallaEjecutarScripts.detalleScript"));
		btnDescartar.setText(literales.getLiteral("PantallaEjecutarScripts.descartar"));
		btnReparar.setText(literales.getLiteral("PantallaEjecutarScripts.reparar"));
		btnVerCuadres.setText(literales.getLiteral("PantallaEjecutarScripts.verCuadres"));
		btnVerErrores.setText(literales.getLiteral("PantallaEjecutarScripts.verErrores"));
		btnExcepcion.setText(literales.getLiteral("PantallaEjecutarScripts.excepcion"));
		btnAceptar.setText(literales.getLiteral("PantallaEjecutarScripts.aceptar"));
		btnCancelar.setText(literales.getLiteral("PantallaEjecutarScripts.cancelar"));
	}
	
	/**
	 * 
	 */
	public void enableButtons(Boolean val) {
		btnVerLog.setEnabled(val);
		btnDetalleScript.setEnabled(val);
		btnDescartar.setEnabled(val);
		btnReparar.setEnabled(val);
		btnVerErrores.setEnabled(val);
		btnVerCuadres.setEnabled(val);
		btnExcepcion.setEnabled(val);
	}
}
