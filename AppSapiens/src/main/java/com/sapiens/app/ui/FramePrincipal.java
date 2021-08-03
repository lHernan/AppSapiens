/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sapiens.app.ui;

import com.sapiens.app.ui.menu.MainMenuBar;
import com.sapiens.app.ui.validacionscripts.PanelPrincipal;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

/**
 *
 * @author federico
 */
public class FramePrincipal extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = -6813614532398369392L;
	// Variables declaration - do not modify//GEN-BEGIN:variables
    private JMenuBar menuBar;
    private JPanel panelPrincipal;
    // End of variables declaration//GEN-END:variables

    /**
     * Creates new form FramePrincipal
     */
    public FramePrincipal() {
        initComponents();
        this.setExtendedState( this.getExtendedState()|JFrame.MAXIMIZED_BOTH );
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrincipal = new PanelPrincipal();
        menuBar = new MainMenuBar();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().add(panelPrincipal, BorderLayout.CENTER);
        setJMenuBar(menuBar);

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        EventQueue.invokeLater(() -> {
            new FramePrincipal().setVisible(true);
        });
    }
}
