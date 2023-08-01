package com.mdsql.bussiness.service;

import com.mdsql.bussiness.entities.InputConsutaHistoricoProceso;
import com.mdsql.bussiness.entities.OutputConsultaHistoricoProceso;
import com.mdval.exceptions.ServiceException;

/**
 * @author hcarreno
 */
public interface HistoricoService {

    /**
     * @param inputConsutaHistoricoProceso
     * @return HistoricoProcesoList
     */
	OutputConsultaHistoricoProceso consultarHistoricoProceso(InputConsutaHistoricoProceso inputConsutaHistoricoProceso) throws ServiceException;

}
