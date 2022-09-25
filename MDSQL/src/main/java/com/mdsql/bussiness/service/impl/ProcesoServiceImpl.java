package com.mdsql.bussiness.service.impl;

import java.math.BigDecimal;
import java.sql.Array;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Struct;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mdsql.bussiness.entities.InputSeleccionarProcesados;
import com.mdsql.bussiness.entities.Proceso;
import com.mdsql.bussiness.entities.SeleccionHistorico;
import com.mdsql.bussiness.service.ProcesoService;
import com.mdsql.exceptions.ServiceException;
import com.mdsql.utils.Constants;
import com.mdval.utils.AppHelper;
import com.mdval.utils.LogWrapper;

import lombok.extern.slf4j.Slf4j;
import oracle.jdbc.internal.OracleConnection;

/**
 * @author hcarreno
 */
@Service(Constants.PROCESO_SERVICE)
@Slf4j
public class ProcesoServiceImpl extends ServiceSupport implements ProcesoService {

	@Autowired
	private DataSource dataSource;

	@Override
	public List<Proceso> seleccionarProcesados(InputSeleccionarProcesados inputSeleccionarProcesados)
			throws ServiceException {
		String runSP = createCall("p_sel_procesados", Constants.CALL_12_ARGS);

		try (Connection conn = dataSource.getConnection();
				CallableStatement callableStatement = conn.prepareCall(runSP)) {

			String typeProceso = createCallType(Constants.T_T_PROCESO);
			String typeError = createCallTypeError();

			logProcedure(runSP, inputSeleccionarProcesados.getPCodigoPeticion(),
					inputSeleccionarProcesados.getPCodigoUsuarioPeticion(),
					inputSeleccionarProcesados.getPFechaInicio(), inputSeleccionarProcesados.getPFechaFin(),
					inputSeleccionarProcesados.getPCodigoUsuario(), inputSeleccionarProcesados.getPCodigoproyecto(),
					inputSeleccionarProcesados.getPCodigoSubProyecto(),
					inputSeleccionarProcesados.getPDescripcionEstadoProceso(),
					inputSeleccionarProcesados.getPUltimas());

			callableStatement.setString(1, inputSeleccionarProcesados.getPCodigoPeticion());
			callableStatement.setString(2, inputSeleccionarProcesados.getPCodigoUsuarioPeticion());
			callableStatement.setDate(3, (java.sql.Date) inputSeleccionarProcesados.getPFechaInicio());
			callableStatement.setDate(4, (java.sql.Date) inputSeleccionarProcesados.getPFechaFin());
			callableStatement.setString(5, inputSeleccionarProcesados.getPCodigoUsuario());
			callableStatement.setString(6, inputSeleccionarProcesados.getPCodigoproyecto());
			callableStatement.setString(7, inputSeleccionarProcesados.getPCodigoSubProyecto());
			callableStatement.setString(8, inputSeleccionarProcesados.getPDescripcionEstadoProceso());
			callableStatement.setBigDecimal(9, inputSeleccionarProcesados.getPUltimas());
			callableStatement.registerOutParameter(10, Types.ARRAY, typeProceso);
			callableStatement.registerOutParameter(11, Types.INTEGER);
			callableStatement.registerOutParameter(12, Types.ARRAY, typeError);

			callableStatement.execute();

			Integer result = callableStatement.getInt(11);

			if (result == 0) {
				throw buildException(callableStatement.getArray(12));
			}

			List<Proceso> procesos = new ArrayList<>();
			Array arrayProcesos = callableStatement.getArray(10);

			if (arrayProcesos != null) {
				Object[] rows = (Object[]) arrayProcesos.getArray();
				for (Object row : rows) {
					Object[] cols = ((oracle.jdbc.OracleStruct) row).getAttributes();

					Proceso proceso = Proceso.builder().idProceso((BigDecimal) cols[0]).codigoPeticion((String) cols[1])
							.codigoUsrPeticion((String) cols[2]).fechaInicio((Date) cols[3]).codigoUsr((String) cols[4])
							.codigoEstadoProceso((BigDecimal) cols[5]).descripcionEstadoProceso((String) cols[6])
							.mcaInicial((String) cols[7]).txtDescripcion((String) cols[8])
							.txtObservacionEntrega((String) cols[9]).mcaErrores((String) cols[10]).build();

					procesos.add(proceso);
				}
			}

			return procesos;
		} catch (SQLException e) {
			LogWrapper.error(log, "[ProcesoService.seleccionarProcesados] Error:  %s", e.getMessage());
			throw new ServiceException(e);
		}
	}

	@Override
	public List<SeleccionHistorico> seleccionarHistorico(String codProyecto, List<String> lineas)
			throws ServiceException {
		String runSP = createCall("p_sel_historico", Constants.CALL_05_ARGS);

		try (Connection conn = dataSource.getConnection();
				CallableStatement callableStatement = conn.prepareCall(runSP)) {

			String typeHistorico = createCallType(Constants.T_T_OBJ_HIS);
			String trLinea = createCallType(Constants.T_R_LINEA);
			String tableLinea = createCallType(Constants.T_T_LINEA);
			String typeError = createCallTypeError();
			
			if (CollectionUtils.isEmpty(lineas)) {
				throw new ServiceException("Falta el script a procesar", null);
			}

			// El script se manda manda línea a línea
			Struct[] struct = new Struct[lineas.size()];

			int arrayIndex = 0;
			for (String linea : lineas) {
				struct[arrayIndex++] = conn.createStruct(trLinea, new Object[] { linea });
			}

			Array arrayLineas = ((OracleConnection) conn).createOracleArray(tableLinea, struct);

			logProcedure(runSP, lineas, codProyecto);

			callableStatement.setArray(1, arrayLineas);
			callableStatement.setString(2, codProyecto);
			callableStatement.registerOutParameter(3, Types.ARRAY, typeHistorico);
			callableStatement.registerOutParameter(4, Types.INTEGER);
			callableStatement.registerOutParameter(5, Types.ARRAY, typeError);

			callableStatement.execute();

			Integer result = callableStatement.getInt(4);

			if (result == 0) {
				throw buildException(callableStatement.getArray(5));
			}

			List<SeleccionHistorico> seleccion = new ArrayList<>();
			Array arraySeleccion = callableStatement.getArray(3);

			if (arraySeleccion != null) {
				Object[] rows = (Object[]) arraySeleccion.getArray();
				for (Object row : rows) {
					Object[] cols = ((oracle.jdbc.OracleStruct) row).getAttributes();

					SeleccionHistorico seleccionHistorico = new SeleccionHistorico();
					
					seleccionHistorico.setConfigurado(Boolean.TRUE);
					seleccionHistorico.setObjeto((String) cols[0]);
					seleccionHistorico.setTipo((String) cols[1]);
					seleccionHistorico.setVigente(AppHelper.normalizeCheckValue((String) cols[2]));
					seleccionHistorico.setHistorico(AppHelper.normalizeCheckValue((String) cols[3]));

					seleccion.add(seleccionHistorico);
				}
			}

			return seleccion;
		} catch (SQLException e) {
			LogWrapper.error(log, "[ProcesoService.seleccionarHistorico] Error:  %s", e.getMessage());
			throw new ServiceException(e);
		}
	}

	@Override
	public void altaHistorico(List<SeleccionHistorico> listaObjetos, String codigoProyecto, String codigoPeticion,
			String codigoUsuario) throws ServiceException {
		String runSP = createCall("p_alta_historico", Constants.CALL_06_ARGS);

        try (Connection conn = dataSource.getConnection();
             CallableStatement callableStatement = conn.prepareCall(runSP)) {

            String tableObjetos = createCallType(Constants.T_T_OBJETOS);
            String recordObjetos = createCallType(Constants.T_R_OBJETOS);

            String typeError = createCallTypeError();

            logProcedure(runSP, listaObjetos, codigoProyecto, codigoPeticion, codigoUsuario);

            Struct[] structObjetos = new Struct[listaObjetos.size()];

            int arrayIndexLinea = 0;
            for (SeleccionHistorico data : listaObjetos) {
                structObjetos[arrayIndexLinea++] = conn.createStruct(recordObjetos,
                        new Object[]{data.getTipo(), data.getObjeto()});
            }

            Array arrayObjetos = ((OracleConnection) conn).createOracleArray(tableObjetos, structObjetos);

            callableStatement.setArray(1, arrayObjetos);
            callableStatement.setString(2, codigoProyecto);
            callableStatement.setString(3, codigoPeticion);
            callableStatement.setString(4, codigoUsuario);
            callableStatement.registerOutParameter(5, Types.INTEGER);
            callableStatement.registerOutParameter(6, Types.ARRAY, typeError);

            callableStatement.execute();

            Integer result = callableStatement.getInt(5);

            if (result == 0) {
                throw buildException(callableStatement.getArray(6));
            }
        } catch (SQLException e) {
            LogWrapper.error(log, "[ProcesoService.altaHistorico] Error: %s", e.getMessage());
            throw new ServiceException(e);
        }
		
	}
}
