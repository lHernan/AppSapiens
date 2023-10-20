package com.mdsql.bussiness.service;

import com.mdsql.bussiness.entities.Historico;
import com.mdsql.bussiness.entities.InputConsutaHistoricoProceso;
import com.mdsql.bussiness.entities.OutputConsultaHistoricoProceso;
import com.mdval.exceptions.ServiceException;

import java.util.List;

/**
 * @author hcarreno
 */
public interface HistoricoService {

    /**
     * @param inputConsutaHistoricoProceso
     * @return HistoricoProcesoList
     */
	OutputConsultaHistoricoProceso consultarHistoricoProceso(InputConsutaHistoricoProceso inputConsutaHistoricoProceso) throws ServiceException;

    List<Historico> consultarHistorico(String codigoProyecto, String tipoObjeto) throws ServiceException;
}
