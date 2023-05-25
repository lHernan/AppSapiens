package com.mdsql.bussiness.service;

import java.util.List;

import com.mdsql.bussiness.entities.HistoricoProceso;
import com.mdsql.bussiness.entities.InputConsutaHistoricoProceso;
import com.mdval.exceptions.ServiceException;

/**
 * @author hcarreno
 */
public interface HistoricoService {

    /**
     * @param inputConsutaHistoricoProceso
     * @return HistoricoProcesoList
     */
    List<HistoricoProceso> consultarHistoricoProceso(InputConsutaHistoricoProceso inputConsutaHistoricoProceso) throws ServiceException;

}
