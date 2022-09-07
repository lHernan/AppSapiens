package com.mdsql.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;

import com.mdsql.bussiness.entities.InputSeleccionarProcesados;
import com.mdsql.bussiness.entities.Norma;
import com.mdsql.bussiness.entities.Proceso;
import com.mdsql.bussiness.service.NormaService;
import com.mdsql.bussiness.service.ProcesoService;
import com.mdsql.ui.model.DefinicionNormasTableModel;
import com.mdsql.ui.normasnomenclatura.FrmDefinicionNormas;
import com.mdsql.ui.utils.ListenerSupport;
import com.mdsql.utils.Constants;

public class FrmDefinicionNormasListener extends ListenerSupport implements ActionListener, Observer {

	private FrmDefinicionNormas frmDefinicionNormas;

	public FrmDefinicionNormasListener(FrmDefinicionNormas frmDefinicionNormas) {
		super();
		this.frmDefinicionNormas = frmDefinicionNormas;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton jButton = (JButton) e.getSource();
		
		if (Constants.FRM_DEFINICION_NORMAS_BTN_BUSCAR.equals(jButton.getActionCommand())) {
			eventBtnBuscar();
		}

		if (Constants.FRM_DEFINICION_NORMAS_BTN_ALTA.equals(jButton.getActionCommand())) {
			eventBtnAlta();
		}

		if (Constants.FRM_DEFINICION_NORMAS_BTN_MODIFICACION.equals(jButton.getActionCommand())) {
			evntBtnModificacion();
		}
	}

	/**
	 * 
	 */
	private void eventBtnBuscar() {
		String cadenaBuscar = frmDefinicionNormas.getTxtNorma().getText();
		List<Norma> normas = buscar(cadenaBuscar);
		populateModel(normas);
	}

	/**
	 * 
	 */
	private void eventBtnAlta() {
		showPopup(frmDefinicionNormas, Constants.CMD_ALTA_NORMAS);
	}

	/**
	 * 
	 */
	private void evntBtnModificacion() {
		Map<String, Object> params = new HashMap<>();
		params.put(Constants.FRM_DEFINICION_NORMAS_SELECCIONADA, frmDefinicionNormas.getSeleccionada());
		
		showPopup(frmDefinicionNormas, Constants.CMD_MODIFICACION_NORMAS, params);
	}
	
	/**
	 * Busca glosarios por descripcion glosario
	 * 
	 * @param termino descripcion glosario a buscar
	 * @return lista de glosarios que cumple con el termino buscado
	 */
	private List<Norma> buscar(String termino) {

		//TODO eliminar ejemplo llamado a nuevo servicio
		ProcesoService procesoService = (ProcesoService) getService("procesoService");
		//mockear datos de entrada si es necesario o rellenarlos directamente desde los inputs de las pantallas
		InputSeleccionarProcesados mockInputExample = InputSeleccionarProcesados
				.builder()
				.pCodigoPeticion("codigoPeticion")
				.pCodigoUsuarioPeticion("codigoSubProyecto")
				.pCodigoUsuarioPeticion("usuario")
				.pFechaInicio(new Date())
				.pFechaFin(new Date())
				.pCodigoUsuario("codigousuario")
				.pCodigoproyecto("pCodigoproyecto")
				.pCodigoSubProyecto("pCodigoSubProyecto")
				.pDescripcionEstadoProceso("pDescripcionEstadoProceso")
				.pUltimas(new BigDecimal("0.00"))
				.build();
		//List<Proceso> procesos = procesoService.seleccionarProcesados(mockInputExample); //llamada real

		//mock datos de salida ejemplo:
		List<Proceso> procesosListMock = new ArrayList<>();
		Proceso procesoMock1 = Proceso.builder()
				.idProceso(new BigDecimal("1"))
				.codigoPeticion("codigo1")
				.codigoUsrPeticion("user1")
				.fechaInicio(new Date())
				.codigoUsr("codigousr1")
				.codigoEstadoProceso(new BigDecimal("1"))
				.descripcionEstadoProceso("descripcion 1")
				.mcaInicial("mca inicial 1")
				.txtDescripcion("descripcion 1")
				.txtObservacionEntrega("observacion 1")
				.mcaErrores("mca error 1 ")
				.build();
		Proceso procesoMock2 = Proceso.builder()
				.idProceso(new BigDecimal("2"))
				.codigoPeticion("codigo2")
				.codigoUsrPeticion("user2")
				.fechaInicio(new Date())
				.codigoUsr("codigousr2")
				.codigoEstadoProceso(new BigDecimal("2"))
				.descripcionEstadoProceso("descripcion 2")
				.mcaInicial("mca inicial 2")
				.txtDescripcion("descripcion 2")
				.txtObservacionEntrega("observacion 2")
				.mcaErrores("mca error 2")
				.build();
		procesosListMock.add(procesoMock1);
		procesosListMock.add(procesoMock2);

		NormaService normaService = (NormaService) getService(Constants.NORMA_SERVICE);
		List<Norma> normas = normaService.consultaNormas(termino);
		return normas;
	}
	
	/**
	 * Vuelca la lista de glosarios encontrados en la tabla
	 * 
	 * @return
	 */
	private void populateModel(List<Norma> normas) {
		// Obtiene el modelo y lo actualiza
		DefinicionNormasTableModel tableModel = (DefinicionNormasTableModel) frmDefinicionNormas
				.getTblNormas().getModel();
		tableModel.setData(normas);
		
		// Como se ha regenerado el contenido de la tabla y se ha perdido la selección,
		// deshabilitar el botón de selección para la próxima.
		frmDefinicionNormas.getBtnModificacion().setEnabled(Boolean.FALSE);
	}
	
	/**
	 *
	 */
	@Override
	public void update(Observable o, Object arg) {
		eventBtnBuscar();
	}
}
