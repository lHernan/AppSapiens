/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sapiens.app.ui.normasnomenclatura;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

import com.sapiens.app.ui.utils.FrameSupport;

/**
 *
 * @author federico
 */
public class FrmDefinicionElementos extends FrameSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -443536491351988729L;

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private JButton btnAlta;
	private JButton btnBuscar;
	private JButton btnModificacion;
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JScrollPane jScrollPane1;
	private JTable tblNormas;
	private JTextField txtNorma;
	// End of variables declaration//GEN-END:variables

	/**
	 * Creates new form DlgDefinicionNormas
	 */
	public FrmDefinicionElementos() {
		super();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	protected void initComponents() {

		jLabel1 = new JLabel();
		txtNorma = new JTextField();
		jLabel2 = new JLabel();
		btnBuscar = new JButton();
		jScrollPane1 = new JScrollPane();
		tblNormas = new JTable();
		btnAlta = new JButton();
		btnModificacion = new JButton();

		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		panelLogo.setPreferredSize(new Dimension(286, 63));

		GroupLayout panelLogoLayout = new GroupLayout(panelLogo);
		panelLogo.setLayout(panelLogoLayout);
		panelLogoLayout.setHorizontalGroup(
				panelLogoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 286, Short.MAX_VALUE));
		panelLogoLayout.setVerticalGroup(
				panelLogoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 63, Short.MAX_VALUE));

		jLabel1.setFont(new Font("Dialog", 1, 18)); // NOI18N
		jLabel1.setText("Definición de Elementos");

		txtNorma.setPreferredSize(new Dimension(64, 27));

		jLabel2.setText("Elemento:");

		btnBuscar.setText("BUSCAR");

		tblNormas.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null }, { null, null, null, null }, { null, null, null, null },
						{ null, null, null, null } },
				new String[] { "COD_ELEMENTO", "DES_ELEMENTO", "COD_USR", "FEC_ACTU" }) {
			Class[] types = new Class[] { java.lang.Integer.class, java.lang.String.class, java.lang.String.class,
					java.lang.Object.class };
			boolean[] canEdit = new boolean[] { false, false, false, false };

			public Class getColumnClass(int columnIndex) {
				return types[columnIndex];
			}

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		jScrollPane1.setViewportView(tblNormas);

		btnAlta.setText("ALTA");
		btnAlta.setPreferredSize(new Dimension(130, 27));

		btnModificacion.setText("MODIFICACION");

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(jScrollPane1)
								.addGroup(layout.createSequentialGroup()
										.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
												.addGroup(layout.createSequentialGroup()
														.addComponent(panelLogo, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
														.addComponent(jLabel1))
												.addGroup(layout.createSequentialGroup().addGap(25, 25, 25)
														.addComponent(jLabel2)
														.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
														.addComponent(txtNorma, GroupLayout.PREFERRED_SIZE, 280,
																GroupLayout.PREFERRED_SIZE)))
										.addGap(0, 140, Short.MAX_VALUE))
								.addGroup(GroupLayout.Alignment.TRAILING,
										layout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE)
												.addComponent(btnAlta, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(btnModificacion)))
						.addContainerGap())
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup().addContainerGap(565, Short.MAX_VALUE)
								.addComponent(btnBuscar, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
								.addContainerGap())));
		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addContainerGap()
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(panelLogo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(jLabel1))
				.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(jLabel2).addComponent(
						txtNorma, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE).addGap(45, 45, 45))
				.addGroup(GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup().addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(btnAlta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(btnModificacion))
								.addContainerGap())
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup().addGap(81, 81, 81).addComponent(btnBuscar)
								.addContainerGap(428, Short.MAX_VALUE))));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	@Override
	protected void initEvents() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void initialState() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void setupLiterals() {
		// TODO Auto-generated method stub
		
	}
}
