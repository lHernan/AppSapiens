/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mdsql.ui;

import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

import com.mdsql.ui.listener.PantallaProcesarScriptActionListener;
import com.mdsql.ui.model.ProcesarScriptNotaTableModel;
import com.mdsql.ui.model.ProcesarScriptUltimasPeticionesTableModel;
import com.mdsql.ui.model.cabeceras.Cabecera;
import com.mdsql.ui.utils.MDSQLUIHelper;
import com.mdsql.utils.Constants;
import com.mdval.ui.utils.DialogSupport;
import com.mdval.ui.utils.FrameSupport;

import lombok.Getter;

/**
 *
 * @author federico
 */
public class PantallaProcesarScript extends DialogSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7845375531319490239L;
	// Variables declaration - do not modify//GEN-BEGIN:variables
	private JButton btnCancelar;
	private JButton btnLimpiar;
	private JButton btnProcesar;
	private JButton btnVerProcesado;
	private JCheckBox chkGenerarHistorico;
	private JComboBox<String> cmbBBDD;
	private JComboBox<String> cmbSubmodelo;
	private JButton jButton1;
	private JLabel jLabel1;
	private JLabel jLabel10;
	private JLabel jLabel11;
	private JLabel jLabel12;
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
	private JTextField txtBBDDHistorico;
	private JTextArea txtDescripcion;
	private JTextField txtEsquema;
	private JTextField txtEsquemaHistorico;
	private JTextField txtPeticion;
	private JTextField txtSolicitadaPor;

	@Getter
	private JTextField txtModelo;
	private JTable tblNotas;
	// End of variables declaration//GEN-END:variables
	private JTable tblUltimasPeticiones;

	/**
	 * @param params
	 */
	public PantallaProcesarScript(FrameSupport parent, Boolean modal) {
		super(parent, modal);
	}

	/**
	 * Creates new form
	 */
	public PantallaProcesarScript(FrameSupport parent, Boolean modal, Map<String, Object> params) {
		super(parent, modal, params);
	}

	@Override
	protected void setupComponents() {
		jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        jLabel5 = new JLabel();
        jLabel6 = new JLabel();
        jLabel7 = new JLabel();
        jLabel8 = new JLabel();
        jLabel9 = new JLabel();
        jLabel10 = new JLabel();
        txtModelo = new JTextField();
        cmbSubmodelo = new JComboBox<>();
        txtPeticion = new JTextField();
        txtSolicitadaPor = new JTextField();
        txtEsquema = new JTextField();
        cmbBBDD = new JComboBox<>();
        chkGenerarHistorico = new JCheckBox();
        txtBBDDHistorico = new JTextField();
        txtEsquemaHistorico = new JTextField();
        jScrollPane1 = new JScrollPane();
        txtDescripcion = new JTextArea();
        btnLimpiar = new JButton();
        jButton1 = new JButton();
        jLabel11 = new JLabel();
        jScrollPane2 = new JScrollPane();
        tblNotas = new JTable();
        jLabel12 = new JLabel();
        jScrollPane3 = new JScrollPane();
        tblUltimasPeticiones = new JTable();
        btnVerProcesado = new JButton();
        btnProcesar = new JButton();
        btnCancelar = new JButton();

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        jScrollPane1.setViewportView(txtDescripcion);

        jButton1.setIcon(new ImageIcon(getClass().getResource("/loupe.png"))); // NOI18N

        jScrollPane2.setViewportView(tblNotas);

        jScrollPane3.setViewportView(tblUltimasPeticiones);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(192, 192, 192)
                                .addComponent(btnLimpiar))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(13, 13, 13)
                                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel6)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel1)
                                                    .addComponent(jLabel2, GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jLabel3, GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jLabel4, GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jLabel5, GroupLayout.Alignment.TRAILING))))
                                        .addComponent(jLabel9, GroupLayout.Alignment.TRAILING))
                                    .addComponent(jLabel7, GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8, GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel10, GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cmbSubmodelo, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cmbBBDD, 0, 214, Short.MAX_VALUE)
                                    .addComponent(chkGenerarHistorico)
                                    .addComponent(txtPeticion)
                                    .addComponent(txtSolicitadaPor)
                                    .addComponent(txtEsquema)
                                    .addComponent(txtBBDDHistorico)
                                    .addComponent(txtEsquemaHistorico)
                                    .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtModelo, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, GroupLayout.DEFAULT_SIZE, 1031, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel12))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane3)))
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnVerProcesado)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnProcesar, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(txtModelo, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1))
                    .addComponent(jLabel11))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(cmbSubmodelo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPeticion, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSolicitadaPor, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtEsquema, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbBBDD, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(chkGenerarHistorico)
                            .addComponent(jLabel7))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(txtBBDDHistorico, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEsquemaHistorico, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnLimpiar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 333, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel12)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnProcesar)
                    .addComponent(btnVerProcesado))
                .addContainerGap())
        );
	}

	@Override
	protected void initEvents() {
		ActionListener actionListener = new PantallaProcesarScriptActionListener(this);

		jButton1.setActionCommand(Constants.PANTALLA_PROCESADO_SCRIPT_SEARCH_MODEL);
		btnCancelar.setActionCommand(Constants.PANTALLA_PROCESADO_SCRIPT_CANCELAR);
		btnProcesar.setActionCommand(Constants.PANTALLA_PROCESADO_SCRIPT_PROCESAR);

		jButton1.addActionListener(actionListener);
		btnCancelar.addActionListener(actionListener);
		btnProcesar.addActionListener(actionListener);
	}

	@Override
	protected void initModels() {
		cmbSubmodelo.setModel(new DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

		cmbBBDD.setModel(new DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

		Cabecera cabeceraNotas = MDSQLUIHelper.createCabeceraTabla(Constants.PROCESAR_SCRIPT_NOTAS_TABLA_CABECERA);
		tblNotas.setModel(
				new ProcesarScriptNotaTableModel(cabeceraNotas.getColumnIdentifiers(), cabeceraNotas.getColumnClasses()));

		Cabecera cabeceraUltimasPeticiones = MDSQLUIHelper
				.createCabeceraTabla(Constants.PROCESAR_SCRIPT_ULTIMAS_PETICIONES_TABLA_CABECERA);
		tblUltimasPeticiones.setModel(new ProcesarScriptUltimasPeticionesTableModel(cabeceraUltimasPeticiones.getColumnIdentifiers(),
				cabeceraUltimasPeticiones.getColumnClasses()));
	}

	@Override
	protected void initialState() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void setupLiterals() {
		jLabel1.setText("Modelo o proyecto");
		jLabel2.setText("Submodelo");
		jLabel3.setText("Petición");
		jLabel4.setText("Solicitada por");
		jLabel5.setText("Esquema");
		jLabel6.setText("BBDD");
		jLabel7.setText("Generar histórico");
		jLabel8.setText("BBDD histórico");
		jLabel9.setText("Esquema histórico");
		jLabel10.setText("Descripción");
		btnLimpiar.setText("Limpiar");
		jLabel11.setText("Notas / avisos");
		jLabel12.setText("Últimas peticiones");
		btnVerProcesado.setText("Ver procesado");
		btnProcesar.setText("Procesar");
		btnCancelar.setText("Cancelar");
	}
}
