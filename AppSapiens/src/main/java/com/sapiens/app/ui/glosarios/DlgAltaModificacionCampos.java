/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sapiens.app.ui.glosarios;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Map;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import com.sapiens.app.ui.PanelLogotipo;
import com.sapiens.app.ui.listener.DlgAltaModificacionCamposListener;
import com.sapiens.app.utils.Constants;
import com.sapiens.app.utils.LiteralesSingleton;

import lombok.Getter;
import lombok.extern.log4j.Log4j;

/**
 *
 * @author federico
 */
@Log4j
public class DlgAltaModificacionCampos extends JDialog {

    /**
	 * 
	 */
	private static final long serialVersionUID = 4170711147258972713L;
	
	// Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton btnAceptar;
    private JButton btnCancelar;
    
    @Getter
    private JComboBox<String> cmbExcepcion;
    
    @Getter
    private JComboBox<String> cmbTipoDato;
    
    private JLabel jLabel1;
    private JLabel jLabel10;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private PanelLogotipo panelLogo;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    
    @Getter
    private JTextField txtDecimales;
    
    @Getter
    private JTextArea txtDescripcionExcepcion;
    
    @Getter
    private JTextField txtModificacion;
    
    @Getter
    private JTextField txtNombre;
    
    @Getter
    private JTextArea txtObservaciones;
    
    @Getter
    private JTextField txtTamanio;
    
    @Getter
    private JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
    
    @Getter
    private JFrame frameParent;
    
    private Map<String, Object> params;
	
	/**
     * Creates new form DlgAltaModificacionCampos
     */
    public DlgAltaModificacionCampos(JFrame parent, boolean modal) {
        super(parent, modal);
        this.frameParent = parent;
        
        initialize();
    }
    
    /**
     * Creates new form DlgAltaModificacionCampos
     */
    public DlgAltaModificacionCampos(JFrame parent, boolean modal, Map<String, Object> params) {
        super(parent, modal);
        this.frameParent = parent;
        this.params = params;
        
        initialize();
    }
    
    /**
     * 
     */
    private void initialize() {
		try {
			initComponents();
			initLiterals();
			initEvents();
			
			initialState();
		} catch (IOException e) {
			log.warn("ERROR:", e);
		}
	}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new JPanel();
        panelLogo = new PanelLogotipo("logotipo.png");
        jLabel1 = new JLabel();
        jPanel2 = new JPanel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        jLabel5 = new JLabel();
        jLabel6 = new JLabel();
        jLabel7 = new JLabel();
        jLabel8 = new JLabel();
        txtNombre = new JTextField();
        cmbTipoDato = new JComboBox<>();
        txtTamanio = new JTextField();
        txtDecimales = new JTextField();
        cmbExcepcion = new JComboBox<>();
        jScrollPane1 = new JScrollPane();
        txtDescripcionExcepcion = new JTextArea();
        jScrollPane2 = new JScrollPane();
        txtObservaciones = new JTextArea();
        jLabel9 = new JLabel();
        jLabel10 = new JLabel();
        txtUsuario = new JTextField();
        txtModificacion = new JTextField();
        jPanel3 = new JPanel();
        btnAceptar = new JButton();
        btnAceptar.setName(Constants.DLG_ALTA_MODIFICACION_CAMPOS_BTN_ACEPTAR);
        btnCancelar = new JButton();
        btnCancelar.setName(Constants.DLG_ALTA_MODIFICACION_CAMPOS_BTN_CANCELAR);

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        panelLogo.setPreferredSize(new Dimension(286, 63));

        GroupLayout jPanel4Layout = new GroupLayout(panelLogo);
        panelLogo.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 286, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 63, Short.MAX_VALUE)
        );

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelLogo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addContainerGap(222, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(panelLogo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, BorderLayout.PAGE_START);

        jLabel2.setHorizontalAlignment(SwingConstants.RIGHT);

        jLabel3.setHorizontalAlignment(SwingConstants.RIGHT);

        jLabel4.setHorizontalAlignment(SwingConstants.RIGHT);

        jLabel5.setHorizontalAlignment(SwingConstants.RIGHT);

        jLabel7.setHorizontalAlignment(SwingConstants.RIGHT);

        jLabel8.setHorizontalAlignment(SwingConstants.RIGHT);

        txtNombre.setPreferredSize(new Dimension(64, 27));

        cmbTipoDato.setModel(new DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtTamanio.setPreferredSize(new Dimension(64, 27));

        txtDecimales.setPreferredSize(new Dimension(64, 27));

        cmbExcepcion.setModel(new DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtDescripcionExcepcion.setColumns(20);
        txtDescripcionExcepcion.setRows(5);
        jScrollPane1.setViewportView(txtDescripcionExcepcion);

        txtObservaciones.setColumns(20);
        txtObservaciones.setRows(5);
        jScrollPane2.setViewportView(txtObservaciones);

        jLabel9.setHorizontalAlignment(SwingConstants.RIGHT);

        txtUsuario.setPreferredSize(new Dimension(64, 27));

        txtModificacion.setPreferredSize(new Dimension(64, 27));

        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombre, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbTipoDato, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(248, 248, 248))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel9, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtUsuario, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(jLabel10)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtModificacion, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel7, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel8, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addGroup(GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(txtTamanio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addGap(42, 42, 42)
                                        .addComponent(jLabel5)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtDecimales, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addGap(54, 54, 54)
                                        .addComponent(jLabel6)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cmbExcepcion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(GroupLayout.Alignment.LEADING, jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 535, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jScrollPane1, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 535, GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap(27, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cmbTipoDato, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(txtTamanio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDecimales, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbExcepcion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(txtModificacion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(51, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, BorderLayout.CENTER);

        btnAceptar.setPreferredSize(new Dimension(98, 27));

        GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(493, Short.MAX_VALUE)
                .addComponent(btnAceptar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelar)
                .addGap(24, 24, 24))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    /**
     * @throws IOException
     */
    private void initLiterals() throws IOException {
		LiteralesSingleton literales = LiteralesSingleton.getInstance();
		
		setTitle(literales.getLiteral("dlgAltaModificacionCampos.titulo"));
		jLabel1.setText(literales.getLiteral("dlgAltaModificacionCampos.titulo"));
		jLabel2.setText(literales.getLiteral("dlgAltaModificacionCampos.nombre"));
		jLabel3.setText(literales.getLiteral("dlgAltaModificacionCampos.tipoDato"));
		jLabel4.setText(literales.getLiteral("dlgAltaModificacionCampos.tam"));
		jLabel5.setText(literales.getLiteral("dlgAltaModificacionCampos.decimales"));
        jLabel6.setText(literales.getLiteral("dlgAltaModificacionCampos.esExcepcion"));
        jLabel7.setText(literales.getLiteral("dlgAltaModificacionCampos.descripcionExcepcion"));
        jLabel8.setText(literales.getLiteral("dlgAltaModificacionCampos.observaciones"));
        jLabel9.setText(literales.getLiteral("dlgAltaModificacionCampos.usuario"));
        jLabel10.setText(literales.getLiteral("dlgAltaModificacionCampos.modificacion"));
        btnAceptar.setText(literales.getLiteral("dlgAltaModificacionCampos.aceptar"));
        btnCancelar.setText(literales.getLiteral("dlgAltaModificacionCampos.cancelar"));
	}
	
	/**
	 * 
	 */
	private void initEvents() {
		ActionListener actionListener = new DlgAltaModificacionCamposListener(this);
		
		btnAceptar.addActionListener(actionListener);
		btnCancelar.addActionListener(actionListener);
	}
	
	/**
	 * 
	 */
	private void initialState() {
		// TODO Auto-generated method stub
		
	}
}
