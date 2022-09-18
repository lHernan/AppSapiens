/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mdsql.ui;

import java.io.IOException;
import java.util.Map;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

import com.mdsql.ui.listener.PantallaBuscadorFicherosListener;
import com.mdsql.ui.utils.MDSQLUIHelper;
import com.mdsql.utils.ConfigurationSingleton;
import com.mdsql.utils.Constants;
import com.mdval.ui.utils.DialogSupport;
import com.mdval.ui.utils.FrameSupport;

import lombok.Getter;

/**
 *
 * @author USUARIO1
 */
public class PantallaBuscadorFicheros extends DialogSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6174427890699657674L;
	
	// Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton btnAceptar;
    private JButton btnCancelar;
    private JLabel jLabel1;
    
    @Getter
    private JTextField txtRuta;
    // End of variables declaration//GEN-END:variables
    
    @Getter
    private PantallaBuscadorFicherosListener pantallaBuscadorFicherosListener;
    
    public PantallaBuscadorFicheros(FrameSupport parent, Boolean modal) {
        super(parent, modal);
    }
    
    public PantallaBuscadorFicheros(FrameSupport parent, Boolean modal, Map<String, Object> params) {
        super(parent, modal, params);
    }

	@Override
	protected void setupComponents() {
		jLabel1 = new JLabel();
        txtRuta = new JTextField();
        btnAceptar = new JButton();
        btnCancelar = new JButton();

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel1)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtRuta, GroupLayout.PREFERRED_SIZE, 496, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(183, 183, 183)
                        .addComponent(btnAceptar)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtRuta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar)
                    .addComponent(btnCancelar))
                .addContainerGap(30, Short.MAX_VALUE))
        );
	}

	@Override
	protected void initEvents() {
		pantallaBuscadorFicherosListener = new PantallaBuscadorFicherosListener(this);
		
		btnAceptar.setActionCommand(Constants.PANTALLA_BUSCADOR_FICHEROS_BTN_ACEPTAR);
		btnCancelar.setActionCommand(Constants.PANTALLA_BUSCADOR_FICHEROS_BTN_CANCELAR);
		
		btnAceptar.addActionListener(pantallaBuscadorFicherosListener);
		btnCancelar.addActionListener(pantallaBuscadorFicherosListener);
	}

	@Override
	protected void initModels() {}

	@Override
	protected void initialState() {
		try {
			ConfigurationSingleton configuration = ConfigurationSingleton.getInstance();
			String rutaInicial = configuration.getConfig("RutaDefectoScripts");
			txtRuta.setText(rutaInicial);
		} catch (IOException e) {
			Map<String, Object> params = MDSQLUIHelper.buildError(e);
			MDSQLUIHelper.showPopup(this.getFrameParent(), Constants.CMD_ERROR, params);
		}
	}

	@Override
	protected void setupLiterals() {
		this.setTitle("Cargar script");
		
		jLabel1.setText("Ruta");
        btnAceptar.setText("ACEPTAR");
        btnCancelar.setText("CANCELAR");
	}
}
