package com.mdsql.bussiness.service;

import java.math.BigDecimal;
import java.util.List;

import com.mdsql.bussiness.entities.InputEliminaLog;
import com.mdsql.bussiness.entities.LogEjecucion;

/**
 * @author hcarreno
 */
public interface LogService {

    /**
     * @param idProceso
     * @param numeroOrden
     * @return LogEjecucionList
     */
    List<LogEjecucion> logEjecucion(BigDecimal idProceso, BigDecimal numeroOrden);

    /**
     * @param inputEliminaLog
     */
    void eliminaLog(InputEliminaLog inputEliminaLog);

}
