package com.mdsql.bussiness.service;

import com.mdsql.bussiness.entities.HistoricoProceso;
import com.mdsql.bussiness.entities.InputConsutaHistoricoProceso;

import java.util.List;

/**
 * @author hcarreno
 */
public interface HistoricoService {

    /**
     * @param inputConsutaHistoricoProceso
     * @return HistoricoProcesoList
     */
    List<HistoricoProceso> consultarHistoricoProceso(InputConsutaHistoricoProceso inputConsutaHistoricoProceso);

}
