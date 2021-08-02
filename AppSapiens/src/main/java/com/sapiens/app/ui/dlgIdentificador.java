/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sapiens.app.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;

import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author federico
 */
@Slf4j
public class dlgIdentificador extends JDialog {

    /**
	 * 
	 */
	private static final long serialVersionUID = -8834696671228315839L;
	// Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton btnAceptar;
    private JLabel lblIdentificador;
    private JPanel panelBotones;
    private JPanel panelLabel;
    private JPanel panelPrincipal;
    private JPanel panelTxtField;
    private JTextField txtIdentificador;
    // End of variables declaration//GEN-END:variables

    /**
     * Creates new form dlgIdentificador
     * @param parent
     * @param modal
     */
    public dlgIdentificador(JFrame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrincipal = new JPanel();
        panelLabel = new JPanel();
        lblIdentificador = new JLabel();
        panelTxtField = new JPanel();
        txtIdentificador = new JTextField();
        panelBotones = new JPanel();
        btnAceptar = new JButton();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new FlowLayout());

        panelPrincipal.setLayout(new GridLayout(3, 0, 1, 5));

        lblIdentificador.setText("IDENTIFICADOR DEL USUARIO");
        panelLabel.add(lblIdentificador);

        panelPrincipal.add(panelLabel);

        panelTxtField.setLayout(new BorderLayout(5, 5));
        panelTxtField.add(txtIdentificador, BorderLayout.CENTER);

        panelPrincipal.add(panelTxtField);

        panelBotones.setLayout(new BorderLayout(5, 5));

        btnAceptar.setText("Aceptar");
        panelBotones.add(btnAceptar, BorderLayout.LINE_END);

        panelPrincipal.add(panelBotones);

        getContentPane().add(panelPrincipal);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
    	try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException ex) {
            log.error("ERROR:", ex);
        } 
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            dlgIdentificador dialog = new dlgIdentificador(new JFrame(), true);
            dialog.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }
}
