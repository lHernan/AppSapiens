/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sapiens.app.ui.glosarios;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Map;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;

import com.sapiens.app.ui.listener.DlgBajaGlosarioCamposListener;
import com.sapiens.app.utils.Constants;
import com.sapiens.app.utils.LiteralesSingleton;

import lombok.Getter;
import lombok.extern.log4j.Log4j;

/**
 *
 * @author federico
 */
@Log4j
public class DlgBajaGlosarioCampos extends JDialog {

    /**
	 * 
	 */
	private static final long serialVersionUID = 7642984919355315851L;
	
	// Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton btnAceptar;
    private JButton btnCancelar;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JScrollPane jScrollPane1;
    
    @Getter
    private JTextArea txtComentario;
    
    @Getter
    private JTextField txtRF;
    
    @Getter
    private JTextField txtSD;
    // End of variables declaration//GEN-END:variables
    
    @Getter
    private JFrame frameParent;
    
    private Map<String, Object> params;
    
	/**
     * Creates new form DlgBajaGlosario
     */
    public DlgBajaGlosarioCampos(JFrame parent, boolean modal) {
        super(parent, modal);
        this.frameParent = parent;
        
        initialize();
    }
    
    public DlgBajaGlosarioCampos(JFrame parent, boolean modal, Map<String, Object> params) {
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

        jLabel1 = new JLabel();
        txtRF = new JTextField();
        jLabel2 = new JLabel();
        txtSD = new JTextField();
        jLabel3 = new JLabel();
        jScrollPane1 = new JScrollPane();
        txtComentario = new JTextArea();
        btnAceptar = new JButton();
        btnAceptar.setName(Constants.DLG_BAJA_GLOSARIO_BTN_ACEPTAR);
        btnCancelar = new JButton();
        btnCancelar.setName(Constants.DLG_BAJA_GLOSARIO_BTN_CANCELAR);

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        txtRF.setPreferredSize(new Dimension(64, 27));

        txtSD.setPreferredSize(new Dimension(64, 27));

        txtComentario.setColumns(20);
        txtComentario.setRows(5);
        jScrollPane1.setViewportView(txtComentario);

        btnAceptar.setIcon(new ImageIcon(getClass().getResource("/checked.png"))); // NOI18N

        btnCancelar.setIcon(new ImageIcon(getClass().getResource("/close.png"))); // NOI18N

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtRF, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(jLabel2)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSD, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 442, GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAceptar)
                                .addGap(18, 18, 18)
                                .addComponent(btnCancelar)))))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtRF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtSD, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar)
                    .addComponent(btnCancelar))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    /**
     * @throws IOException
     */
    private void initLiterals() throws IOException {
		LiteralesSingleton literales = LiteralesSingleton.getInstance();
		
		jLabel1.setText(literales.getLiteral("dlgBajaGlosario.rf"));
		jLabel2.setText(literales.getLiteral("dlgBajaGlosario.sd"));
		jLabel3.setText(literales.getLiteral("dlgBajaGlosario.comentario"));
		btnAceptar.setText(literales.getLiteral("dlgBajaGlosario.aceptar"));
		btnCancelar.setText(literales.getLiteral("dlgBajaGlosario.cancelar"));
	}
	
	/**
	 * 
	 */
	private void initEvents() {
		ActionListener actionListener = new DlgBajaGlosarioCamposListener(this);
		
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
