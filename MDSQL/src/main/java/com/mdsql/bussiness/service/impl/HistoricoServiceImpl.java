package com.mdsql.bussiness.service.impl;

import java.math.BigDecimal;
import java.sql.Array;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mdsql.bussiness.entities.HistoricoProceso;
import com.mdsql.bussiness.entities.InputConsutaHistoricoProceso;
import com.mdsql.bussiness.entities.OutputConsultaHistoricoProceso;
import com.mdsql.bussiness.service.HistoricoService;
import com.mdsql.utils.MDSQLConstants;
import com.mdval.exceptions.ServiceException;
import com.mdval.utils.LogWrapper;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

/**
 * @author hcarreno
 */
@Service(MDSQLConstants.HISTORICO_SERVICE)
@Slf4j
public class HistoricoServiceImpl extends ServiceSupport implements HistoricoService {

    @Autowired
    private DataSource dataSource;


    @Override
    @SneakyThrows(ServiceException.class)
    public OutputConsultaHistoricoProceso consultarHistoricoProceso(InputConsutaHistoricoProceso inputConsutaHistoricoProceso) {
        String runSP = createCall("p_con_historico_objeto", MDSQLConstants.CALL_14_ARGS);

        try (Connection conn = dataSource.getConnection();
             CallableStatement callableStatement = conn.prepareCall(runSP)) {

            String typeHisProc = createCallType(MDSQLConstants.T_T_HIS_PROC);
            String typeError = createCallTypeError();

            logProcedure(runSP, inputConsutaHistoricoProceso.getCodigoProyecto(), inputConsutaHistoricoProceso.getNombreObjetoPadre(), inputConsutaHistoricoProceso.getCodigoTipoObjeto(), inputConsutaHistoricoProceso.getCodigoOperacion()
                    , inputConsutaHistoricoProceso.getNombreObjeto(), inputConsutaHistoricoProceso.getCodigoTipoObjeto(), inputConsutaHistoricoProceso.getCodigoOperacion(), inputConsutaHistoricoProceso.getFechaDesde()
                    , inputConsutaHistoricoProceso.getFechaHasta(), inputConsutaHistoricoProceso.getCodigoEstadoProceso(), inputConsutaHistoricoProceso.getCodigoEstadoScript());

            callableStatement.setString(1, inputConsutaHistoricoProceso.getCodigoProyecto());
            callableStatement.setString(2, inputConsutaHistoricoProceso.getNombreObjetoPadre());
            callableStatement.setBigDecimal(3, inputConsutaHistoricoProceso.getCodigoTipoObjeto());
            callableStatement.setBigDecimal(4, inputConsutaHistoricoProceso.getCodigoOperacion());
            callableStatement.setString(5, inputConsutaHistoricoProceso.getNombreObjeto());
            callableStatement.setBigDecimal(6, inputConsutaHistoricoProceso.getCodigoTipoObjeto());
            callableStatement.setBigDecimal(7, inputConsutaHistoricoProceso.getCodigoOperacion());
            
            Date fechaDesde = inputConsutaHistoricoProceso.getFechaDesde();
            if (!Objects.isNull(fechaDesde)) {
            	callableStatement.setDate(8, new java.sql.Date(fechaDesde.getTime()));
            }
            else {
            	callableStatement.setDate(8, null);
            }
            
            Date fechaHasta = inputConsutaHistoricoProceso.getFechaHasta();
            if (!Objects.isNull(fechaHasta)) {
            	callableStatement.setDate(9, new java.sql.Date(fechaHasta.getTime()));
            }
            else {
            	callableStatement.setDate(9, null);
            }
            
            callableStatement.setBigDecimal(10, inputConsutaHistoricoProceso.getCodigoEstadoProceso());
            callableStatement.setBigDecimal(11, inputConsutaHistoricoProceso.getCodigoEstadoScript());
            callableStatement.registerOutParameter(12, Types.ARRAY, typeHisProc);
            callableStatement.registerOutParameter(13, Types.INTEGER);
            callableStatement.registerOutParameter(14, Types.ARRAY, typeError);

            callableStatement.execute();

            Integer result = callableStatement.getInt(13);

            if (result == 0) {
                throw buildException(callableStatement.getArray(14));
            }
            
            OutputConsultaHistoricoProceso outputConsultaHistoricoProceso = new OutputConsultaHistoricoProceso();
            outputConsultaHistoricoProceso.setResult(result);
			
			// Hay avisos
			if (result == 2) {
				outputConsultaHistoricoProceso.setServiceException(buildException(callableStatement.getArray(14)));
			}

            List<HistoricoProceso> historicoProcesos = new ArrayList<>();
            Array arrayHistoricoProceso = callableStatement.getArray(12);

            if (arrayHistoricoProceso != null) {
                Object[] rows = (Object[]) arrayHistoricoProceso.getArray();
                for (Object row : rows) {
                    Object[] cols = ((oracle.jdbc.OracleStruct) row).getAttributes();
                    HistoricoProceso historicoProceso = HistoricoProceso.builder()
                            .codigoPeticion((String) cols[0])
                            .descripcionEstadoProceso((String) cols[1])
                            .fechaProceso((java.util.Date) cols[2])
                            .codigoSubProyecto((String) cols[3])
                            .codigoUsuarioPeticion((String) cols[4])
                            .codigoUsuario((String) cols[5])
                            .tipoAccion((String) cols[6])
                            .tipoAccionPadre((String) cols[7])
                            .nombreScript((String) cols[8])
                            .descripcionEstadoScript((String) cols[9])
                            .idProceso((BigDecimal) cols[10])
                            .numeroOrden((BigDecimal) cols[11])
                            .build();
                    historicoProcesos.add(historicoProceso);
                }
                
                outputConsultaHistoricoProceso.setHistoricoProcesos(historicoProcesos);
            }
            return outputConsultaHistoricoProceso;
        } catch (SQLException e) {
            LogWrapper.error(log, "[HistoricoService.consultarHistoricoProceso] Error:  %s", e.getMessage());
            throw new ServiceException(e);
        }
    }
}
