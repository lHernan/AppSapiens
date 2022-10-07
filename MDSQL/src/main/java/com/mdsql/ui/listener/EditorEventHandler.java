package com.mdsql.ui.listener;

import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;

import com.mdsql.ui.FramePrincipal;

/**
 * Clase interna que extiende e implementa las clases e interfaces necesarias
 * para atender y manejar los eventos sobre la GUI principal del editor.
 */
public class EditorEventHandler implements UndoableEditListener {

	private FramePrincipal framePrincipal;
	
	public EditorEventHandler(FramePrincipal framePrincipal) {
		super();
		this.framePrincipal = framePrincipal;
	}

	@Override
	public void undoableEditHappened(UndoableEditEvent e) {
		/**
		 * el cambio realizado en el área de edición se guarda en el buffer del
		 * administrador de edición
		 */
		framePrincipal.getUndoManager().addEdit(e.getEdit());
		//updateControls(); // actualiza el estado de las opciones "Deshacer" y "Rehacer"

		framePrincipal.setHasChanged(Boolean.TRUE);
	}
}
