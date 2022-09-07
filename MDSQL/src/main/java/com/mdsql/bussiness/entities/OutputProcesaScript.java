package com.mdsql.bussiness.entities;

import com.mdsql.exceptions.ServiceException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author hcarreno
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class OutputProcesaScript implements Serializable {

	private BigDecimal idProceso;
	private Date pFechaProceso;
	private BigDecimal pCodigoEstadoProceso;
	private String pDescripcionEstadoProceso;
    private List<Script> listaScripts;
    
    // Para los warnings
    private ServiceException serviceException;

}
