/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mdsql.ui;

import java.util.Map;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

import com.mdsql.bussiness.entities.Modelo;
import com.mdsql.ui.listener.PantallaHistoricoCambiosListener;
import com.mdsql.ui.model.EstadoProcesadoComboBoxModel;
import com.mdsql.ui.model.EstadoScriptComboBoxModel;
import com.mdsql.ui.model.HistoricoObjetoTableModel;
import com.mdsql.ui.model.OperacionComboBoxModel;
import com.mdsql.ui.model.TipoObjetoComboBoxModel;
import com.mdsql.ui.renderer.EstadoProcesadoRenderer;
import com.mdsql.ui.renderer.EstadoScriptRenderer;
import com.mdsql.ui.utils.MDSQLUIHelper;
import com.mdsql.utils.MDSQLConstants;
import com.mdsql.utils.MDSQLConstants.EstadosProcesado;
import com.mdsql.utils.MDSQLConstants.EstadosScript;
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
public class PantallaHistoricoCambios extends DialogSupport {

    private static final long serialVersionUID = 1L;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton btnBuscar;
    private JButton btnBuscarModelo;
    private JButton btnCancelar;
    private JButton btnInforme;
    private JButton btnResumen;
    private JButton btnVerDetalle;
    
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
    
    @Getter
    private TableSupport tblHistoricoObjetos;
    
    @Getter
    private JTextField txtDesde;
    
    @Getter
    private JTextField txtHasta;
    
    @Getter
    private JTextField txtObjeto;
    
    @Getter
    private JTextField txtObjetoPadre;
    
    @Getter
	private JComboBox<String> cmbTipoObjeto;

    @Getter
	private JComboBox<String> cmbOperacion;

    @Getter
	private JComboBox<EstadosScript> cmbEstadoScript;

    @Getter
	private JComboBox<String> cmbTipoObjetoPadre;

    @Getter
	private JComboBox<String> cmbOperacionPadre;

    @Getter
	private JComboBox<EstadosProcesado> cmbEstadoProcesado;
    // End of variables declaration//GEN-END:variables
    
    @Getter
    private JTextField txtModelo;
    
    @Getter
    @Setter
    private Modelo modeloSeleccionado;

    public PantallaHistoricoCambios(FrameSupport parent, Boolean modal) {
		super(parent, modal);
	}

	public PantallaHistoricoCambios(FrameSupport parent, Boolean modal, Map<String, Object> params) {
		super(parent, modal, params);
	}

	@Override
	protected void setupComponents() {
		jLabel1 = new JLabel();
        txtModelo = new JTextField();
        btnBuscarModelo = new JButton();
        jLabel2 = new JLabel();
        txtObjeto = new JTextField();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        cmbTipoObjeto = new JComboBox<>();
        cmbOperacion = new JComboBox<>();
        jLabel5 = new JLabel();
        cmbEstadoScript = new JComboBox<>();
        jLabel6 = new JLabel();
        jLabel7 = new JLabel();
        cmbTipoObjetoPadre = new JComboBox<>();
        jLabel8 = new JLabel();
        cmbOperacionPadre = new JComboBox<>();
        jLabel9 = new JLabel();
        cmbEstadoProcesado = new JComboBox<>();
        jLabel10 = new JLabel();
        jLabel11 = new JLabel();
        btnBuscar = new JButton();
        jScrollPane1 = new JScrollPane();
        tblHistoricoObjetos = new TableSupport();
        btnInforme = new JButton();
        btnVerDetalle = new JButton();
        btnResumen = new JButton();
        btnCancelar = new JButton();
        txtObjetoPadre = new JTextField();
        txtDesde = new JTextField();
        txtHasta = new JTextField();

        setBounds(1032, 604);
        
        jScrollPane1.setViewportView(tblHistoricoObjetos);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnInforme, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnVerDetalle, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnResumen)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(btnBuscar, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(22, 22, 22)
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel2))
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(cmbOperacion, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(cmbTipoObjeto, GroupLayout.Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                        .addComponent(txtModelo, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(btnBuscarModelo, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)))
                                                .addGap(26, 26, 26)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jLabel7)
                                                    .addComponent(jLabel8)))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(txtObjeto, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel6))))
                                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(jLabel5)))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbOperacionPadre, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(cmbTipoObjetoPadre, GroupLayout.Alignment.LEADING, 0, 195, Short.MAX_VALUE)
                                        .addComponent(cmbEstadoScript, GroupLayout.Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(txtObjetoPadre, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE))))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtHasta, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10, GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel9, GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbEstadoProcesado, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDesde, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(txtModelo, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnBuscarModelo))
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5)
                                .addComponent(cmbEstadoScript, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbEstadoProcesado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel6)
                            .addComponent(txtObjeto, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtObjetoPadre, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(cmbTipoObjeto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3))
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(cmbTipoObjetoPadre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7)))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(cmbOperacion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4))
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(cmbOperacionPadre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel8))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txtDesde, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(txtHasta, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBuscar)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInforme)
                    .addComponent(btnVerDetalle)
                    .addComponent(btnResumen)
                    .addComponent(btnCancelar))
                .addContainerGap())
        );
	}

	@Override
	protected void initEvents() {
		PantallaHistoricoCambiosListener actionListener = new PantallaHistoricoCambiosListener(this);
		
		btnBuscarModelo.setActionCommand(MDSQLConstants.PANTALLA_HISTORICO_CAMBIOS_BUSCAR_MODELO);
		btnCancelar.setActionCommand(MDSQLConstants.PANTALLA_HISTORICO_CAMBIOS_CANCELAR);
		btnBuscar.setActionCommand(MDSQLConstants.PANTALLA_HISTORICO_CAMBIOS_BUSCAR);
		
		btnBuscarModelo.addActionListener(actionListener);
		btnCancelar.addActionListener(actionListener);
		btnBuscar.addActionListener(actionListener);
	}

	@Override
	protected void setupLiterals() {
		jLabel1.setText(literales.getLiteral("PantallaHistoricoCambios.label1"));
		jLabel2.setText(literales.getLiteral("PantallaHistoricoCambios.label2"));
		jLabel3.setText(literales.getLiteral("PantallaHistoricoCambios.label3"));
		jLabel4.setText(literales.getLiteral("PantallaHistoricoCambios.label4"));
		jLabel5.setText(literales.getLiteral("PantallaHistoricoCambios.label5"));
		jLabel6.setText(literales.getLiteral("PantallaHistoricoCambios.label6"));
		jLabel7.setText(literales.getLiteral("PantallaHistoricoCambios.label7"));
		jLabel8.setText(literales.getLiteral("PantallaHistoricoCambios.label8"));
		jLabel9.setText(literales.getLiteral("PantallaHistoricoCambios.label9"));
		jLabel10.setText(literales.getLiteral("PantallaHistoricoCambios.label10"));
		jLabel11.setText(literales.getLiteral("PantallaHistoricoCambios.label11"));
		
		btnBuscarModelo.setIcon(new ImageIcon(getClass().getResource("/loupe.png")));
		btnBuscar.setText(literales.getLiteral("PantallaHistoricoCambios.buscar"));
		btnInforme.setText(literales.getLiteral("PantallaHistoricoCambios.informe"));
		btnVerDetalle.setText(literales.getLiteral("PantallaHistoricoCambios.verDetalle"));
		btnResumen.setText(literales.getLiteral("PantallaHistoricoCambios.resumen"));
		btnCancelar.setText(literales.getLiteral("PantallaHistoricoCambios.cancelar")); 
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void initModels() {
		cmbTipoObjeto.setModel(new TipoObjetoComboBoxModel());
        cmbOperacion.setModel(new OperacionComboBoxModel());
        cmbEstadoScript.setModel(new EstadoScriptComboBoxModel());
        cmbTipoObjetoPadre.setModel(new TipoObjetoComboBoxModel());
        cmbOperacionPadre.setModel(new OperacionComboBoxModel());
        cmbEstadoProcesado.setModel(new EstadoProcesadoComboBoxModel());
        
        cmbEstadoScript.setRenderer(new EstadoScriptRenderer());
        cmbEstadoProcesado.setRenderer(new EstadoProcesadoRenderer());
		
        Cabecera cabecera = MDSQLUIHelper.createCabeceraTabla(MDSQLConstants.DLG_HISTORICO_CAMBIOS_TABLA_CABECERA);
        tblHistoricoObjetos.initModel(new HistoricoObjetoTableModel(cabecera));
	}

	@Override
	protected void initialState() {
		btnResumen.setEnabled(Boolean.FALSE);
		btnVerDetalle.setEnabled(Boolean.FALSE);
	}

    
}
