package com.mdsql.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;

import org.apache.commons.collections.Closure;
import org.apache.commons.collections.CollectionUtils;

import com.mdsql.bussiness.entities.BBDD;
import com.mdsql.bussiness.entities.Proceso;
import com.mdsql.bussiness.entities.Script;
import com.mdsql.bussiness.entities.TextoLinea;
import com.mdsql.bussiness.service.ScriptService;
import com.mdsql.ui.PantallaEjecutarScripts;
import com.mdsql.ui.model.BBDDComboBoxModel;
import com.mdsql.ui.model.ScriptsTableModel;
import com.mdsql.ui.utils.ListenerSupport;
import com.mdsql.utils.Constants;
import com.mdsql.utils.collections.ScriptPredicate;
import com.mdval.ui.utils.OnLoadListener;
import com.mdval.ui.utils.observer.Observer;

public class PantallaEjecutarScriptsListener extends ListenerSupport implements ActionListener, OnLoadListener {

	private PantallaEjecutarScripts pantallaEjecutarScripts;

	public PantallaEjecutarScriptsListener(PantallaEjecutarScripts pantallaEjecutarScripts) {
		super();
		this.pantallaEjecutarScripts = pantallaEjecutarScripts;
	}

	public void addObservador(Observer o) {
		this.addObserver(o);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton jButton = (JButton) e.getSource();

		if (Constants.PANTALLA_EJECUTAR_SCRIPTS_BTN_RECHAZAR.equals(jButton.getActionCommand())) {
			eventBtnRechazar();
		}

		if (Constants.PANTALLA_EJECUTAR_SCRIPTS_BTN_VER_LOG.equals(jButton.getActionCommand())) {
			eventBtnVerLog();
		}

		if (Constants.PANTALLA_EJECUTAR_SCRIPTS_BTN_DETALLE_SCRIPT.equals(jButton.getActionCommand())) {
			eventBtnDetalleScript();
		}

		if (Constants.PANTALLA_EJECUTAR_SCRIPTS_BTN_DESCARTAR.equals(jButton.getActionCommand())) {
			eventBtnDescartar();
		}

		if (Constants.PANTALLA_EJECUTAR_SCRIPTS_BTN_REPARAR.equals(jButton.getActionCommand())) {
			eventBtnReparar();
		}

		if (Constants.PANTALLA_EJECUTAR_SCRIPTS_BTN_VER_CUADROS.equals(jButton.getActionCommand())) {
			eventBtnVerCuadros();
		}

		if (Constants.PANTALLA_EJECUTAR_SCRIPTS_BTN_VER_ERRORES.equals(jButton.getActionCommand())) {
			eventBtnVerErrores();
		}

		if (Constants.PANTALLA_EJECUTAR_SCRIPTS_BTN_EXCEPCION.equals(jButton.getActionCommand())) {
			eventBtnExcepcion();
		}

		if (Constants.PANTALLA_EJECUTAR_SCRIPTS_BTN_ACEPTAR.equals(jButton.getActionCommand())) {
			eventBtnAceptar();
		}

		if (Constants.PANTALLA_EJECUTAR_SCRIPTS_BTN_CANCELAR.equals(jButton.getActionCommand())) {
			eventBtnCancelar();
		}
	}

	private void eventBtnRechazar() {

	}

	private void eventBtnVerLog() {

	}

	private void eventBtnDetalleScript() {

	}

	private void eventBtnDescartar() {

	}

	private void eventBtnReparar() {

	}

	private void eventBtnVerCuadros() {

	}

	private void eventBtnVerErrores() {

	}

	private void eventBtnExcepcion() {

	}

	private void eventBtnAceptar() {
		// TODO aqui, obtener lista vigente, historico y bbdd por el momento mockeados
		ScriptService scriptService = (ScriptService) getService(Constants.SCRIPT_SERVICE);
		TextoLinea textoLinea = TextoLinea.builder().valor("CREATE TABLE &&USROWN..CLIENTES2(").build();
		TextoLinea textoLinea2 = TextoLinea.builder().valor("COD_CLIENTE VARCHAR2(10) NOT NULL,").build();
		TextoLinea textoLinea3 = TextoLinea.builder().valor("TXT_NOMBRE VARCHAR2(50) NOT NULL,").build();
		TextoLinea textoLinea4 = TextoLinea.builder().valor("TXT_APELLIDO1 VARCHAR2(50) NOT NULL,").build();
		TextoLinea textoLinea5 = TextoLinea.builder().valor("TXT_APELLIDO2 VARCHAR2(50),").build();
		TextoLinea textoLinea6 = TextoLinea.builder().valor("COD_DOCUM VARCHAR2(10) NOT NULL").build();
		TextoLinea textoLinea7 = TextoLinea.builder().valor(");").build();
		TextoLinea textoLinea8 = TextoLinea.builder()
				.valor("COMMENT ON TABLE &&USROWN..CLIENTES2 IS 'TABLA DE CLIENTES2';").build();
		TextoLinea textoLinea9 = TextoLinea.builder()
				.valor("COMMENT ON COLUMN &&USROWN..CLIENTES2.COD_CLIENTE IS 'CODIGO DE CLIENTE';").build();
		TextoLinea textoLinea10 = TextoLinea.builder()
				.valor("COMMENT ON COLUMN &&USROWN..CLIENTES2.TXT_NOMBRE IS 'NOMBRE DEL CLIENTE';").build();
		TextoLinea textoLinea11 = TextoLinea.builder()
				.valor("COMMENT ON COLUMN &&USROWN..CLIENTES2.TXT_APELLIDO1 IS 'APELLIDO 1';").build();
		TextoLinea textoLinea12 = TextoLinea.builder()
				.valor("COMMENT ON COLUMN &&USROWN..CLIENTES2.TXT_APELLIDO2 IS 'APELLIDO 2';").build();
		TextoLinea textoLinea13 = TextoLinea.builder()
				.valor("COMMENT ON COLUMN &&USROWN..CLIENTES2.COD_DOCUM IS 'DOCUMENTO DE IDENTIDAD';\n").build();
		TextoLinea textoLinea14 = TextoLinea.builder()
				.valor("CREATE UNIQUE INDEX &&USROWN..PK_CLIENTES2 ON &&USROWN..CLIENTES2").build();
		TextoLinea textoLinea15 = TextoLinea.builder().valor("       (COD_CLIENTE ASC);\n").build();
		TextoLinea textoLinea16 = TextoLinea.builder().valor("ALTER TABLE &&USROWN..CLIENTES2").build();
		TextoLinea textoLinea17 = TextoLinea.builder().valor("      ADD CONSTRAINT PK_CLIENTES2").build();
		TextoLinea textoLinea18 = TextoLinea.builder().valor("      PRIMARY KEY(COD_CLIENTE)").build();
		TextoLinea textoLinea19 = TextoLinea.builder().valor("      USING INDEX &&USROWN..PK_CLIENTES2;\n").build();
		TextoLinea textoLinea20 = TextoLinea.builder()
				.valor("CREATE UNIQUE INDEX &&USROWN..AK_CLIENTES2 ON &&USROWN..CLIENTES2").build();
		TextoLinea textoLinea21 = TextoLinea.builder().valor("       (COD_DOCUM ASC);").build();

		List<TextoLinea> textoLineas = new ArrayList<>();
		textoLineas.add(textoLinea);
		textoLineas.add(textoLinea2);
		textoLineas.add(textoLinea3);
		textoLineas.add(textoLinea4);
		textoLineas.add(textoLinea5);
		textoLineas.add(textoLinea6);
		textoLineas.add(textoLinea7);
		textoLineas.add(textoLinea8);
		textoLineas.add(textoLinea9);
		textoLineas.add(textoLinea10);
		textoLineas.add(textoLinea11);
		textoLineas.add(textoLinea12);
		textoLineas.add(textoLinea13);
		textoLineas.add(textoLinea14);
		textoLineas.add(textoLinea15);
		textoLineas.add(textoLinea16);
		textoLineas.add(textoLinea17);
		textoLineas.add(textoLinea18);
		textoLineas.add(textoLinea19);
		textoLineas.add(textoLinea20);
		textoLineas.add(textoLinea21);
		Script script1 = Script.builder().tipoScript("SQL").lineasScript(textoLineas)
				.nombreScript("20220922_10_00_VARIABLES_DD_RF0123456_SD0123456.sql")
				.codigoEstadoScript(new BigDecimal("1")).descripcionEstadoScript("test")
				.numeroOrden(new BigDecimal("1"))
				.nombreScriptLanza("Lanza_20220922_10_00_VARIABLES_DD_RF0123456_SD0123456.sql")
				.txtScriptLanza("SET DEFINE ON\n" + "SET VERIFY\tON\n" + "SET ECHO OFF\n"
						+ "SPOOL \"C:\\Users\\herna\\Documents\\sapiens\\pruebaServicio\\20220922_10_00_VARIABLES_DD_RF0123456_SD0123456_sqlplus.log\"\n"
						+ "DEFINE USROWN=vigente\n"
						+ "@\"c:\\pruebaLOG\\20220922_Con_variables\\20220922_10_00_VARIABLES_DD_RF0123456_SD0123456.sql\"\n"
						+ "PROMPT -- BORRAMOS LA TABLA\n" + "DROP TABLE CLIENTES2;\n" + "SPOOL OFF\n" + "exit")
				.nombreScriptLog("20220922_10_00_VARIABLES_DD_RF0123456_SD0123456_sqlplus.log").build();

		List<Script> vigente = new ArrayList<>();
		vigente.add(script1);
		List<Script> historico = new ArrayList<>();
		BBDD bbdd = BBDD.builder().nombreBBDD("oracle21").nombreEsquema("vigente").nombreBBDDHis("oracle21")
				.nombreEsquemaHis("historico").build();
		scriptService.executeScripts(bbdd, vigente, historico);

	}

	private void eventBtnCancelar() {
		pantallaEjecutarScripts.dispose();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void onLoad() {
		Proceso proceso = (Proceso) pantallaEjecutarScripts.getParams().get("proceso");

		List<BBDD> bbdds = proceso.getBbdds();
		if (CollectionUtils.isNotEmpty(bbdds)) {
			BBDDComboBoxModel modelBBDD = new BBDDComboBoxModel(bbdds);
			pantallaEjecutarScripts.getCmbBBDD().setModel(modelBBDD);
		}

		List<Script> scripts = proceso.getScripts();

		// Actualiza las tablas
		String[] filtroVigentes = { "SQL", "PDC" };
		List<Script> vigentes = new ArrayList<Script>(
				CollectionUtils.select(scripts, new ScriptPredicate(filtroVigentes)));
		// En principio estarán todos seleccionados
		CollectionUtils.forAllDo(vigentes, new Closure() {

			@Override
			public void execute(Object input) {
				Script script = (Script) input;
				script.setSelected(Boolean.TRUE);
			}

		});

		ScriptsTableModel tableModelVigente = (ScriptsTableModel) pantallaEjecutarScripts.getTblVigente().getModel();
		tableModelVigente.setData(vigentes);

		String[] filtroHistorico = { "SQLH", "PDCH" };
		List<Script> historicos = new ArrayList<Script>(
				CollectionUtils.select(scripts, new ScriptPredicate(filtroHistorico)));
		// En principio estarán todos seleccionados
		CollectionUtils.forAllDo(historicos, new Closure() {

			@Override
			public void execute(Object input) {
				Script script = (Script) input;
				script.setSelected(Boolean.TRUE);
			}

		});

		ScriptsTableModel tableModelHistorico = (ScriptsTableModel) pantallaEjecutarScripts.getTblHistorico()
				.getModel();
		tableModelHistorico.setData(historicos);
	}
}
