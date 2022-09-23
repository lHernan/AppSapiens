package com.mdsql.bussiness.service.impl;

import java.sql.Array;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mdsql.bussiness.entities.Modelo;
import com.mdsql.bussiness.entities.SubProyecto;
import com.mdsql.bussiness.service.ModeloService;
import com.mdsql.exceptions.ServiceException;
import com.mdsql.utils.Constants;
import com.mdval.utils.LogWrapper;

import lombok.extern.slf4j.Slf4j;


/**
 * @author hcarreno
 */
@Service(Constants.MODELO_SERVICE)
@Slf4j
public class ModeloServiceImpl extends ServiceSupport implements ModeloService {

	@Autowired
	private DataSource dataSource;

	@Override
	public List<Modelo> consultaModelos(String codigoProyecto, String nombreModelo,
			String codigoSubProyecto) throws ServiceException {
		String runSP = createCall("p_con_modelos", Constants.CALL_06_ARGS);

		try (Connection conn = dataSource.getConnection();
			 CallableStatement callableStatement = conn.prepareCall(runSP)) {

			String typeModelo = createCallType(Constants.T_T_MODELO);
			String typeError = createCallTypeError();

			logProcedure(runSP, codigoProyecto, nombreModelo, codigoSubProyecto);

			callableStatement.setString(1, codigoProyecto);
			callableStatement.setString(2, nombreModelo);
			callableStatement.setString(3, codigoSubProyecto);
			callableStatement.registerOutParameter(4, Types.ARRAY, typeModelo);
			callableStatement.registerOutParameter(5, Types.INTEGER);
			callableStatement.registerOutParameter(6, Types.ARRAY, typeError);

			callableStatement.execute();

			Integer result = callableStatement.getInt(5);

			if (result == 0) {
				throw buildException(callableStatement.getArray(6));
			}

			List<Modelo> modelos = new ArrayList<>();
			Array arrayModelos = callableStatement.getArray(4);
			
			if (arrayModelos != null) {
				Object[] rows = (Object[]) arrayModelos.getArray();
				for (Object row : rows) {
					Object[] cols = ((oracle.jdbc.OracleStruct) row).getAttributes();

					Modelo modelo = Modelo.builder()
							.codigoProyecto((String) cols[0])
							.nombreModelo((String) cols[1])
							.nombreEsquema((String) cols[2])
							.nombreBbdd((String) cols[3])
							.nombreCarpetaAdj((String) cols[4])
							.codigoCapaUsrown((String) cols[5])
							.mcaVariables((String) cols[6])
							.mcaGrantAll((String) cols[7])
							.mcaGrantPublic((String) cols[8])
							.mcaInh((String) cols[9])
							.observaciones((String) cols[10])
							.mcaHis((String) cols[11])
							.entregaPDC((String) cols[12])
							.build();
					
					// Lista de subproyectos
					fillSubproyectos(modelo, cols);
					
					modelos.add(modelo);
				}
			}

			return modelos;
		} catch (Exception e) {
			LogWrapper.error(log, "[ModeloService.consultaModelos] Error: %s", e.getMessage());
			throw new ServiceException(e);
		}
	}

	/**
	 * @param modelo
	 * @param arraySubProyectos
	 * @throws SQLException
	 */
	private void fillSubproyectos(Modelo modelo, Object[] cols) throws SQLException {
		try {
			Array arraySubProyectos = (Array) cols[13];
			if (!Objects.isNull(arraySubProyectos)) {
				List<SubProyecto> subProyectos = new ArrayList<>();
				Object[] subs = (Object[]) arraySubProyectos.getArray();
				for (Object sub : subs) {
					Object[] sub_cols = ((oracle.jdbc.OracleStruct) sub).getAttributes();
	
					SubProyecto subProyecto = SubProyecto.builder()
							.codigoSubProyecto((String) sub_cols[0])
							.descripcionSubProyecto((String) sub_cols[1])
							.build();
					subProyectos.add(subProyecto);
				}
				
				modelo.setSubproyectos(subProyectos);
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			LogWrapper.error(log, "[ModeloService.fillSubproyectos] Error: %s", e.getMessage());
		}
	}
}
