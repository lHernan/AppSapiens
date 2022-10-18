package com.mdsql.bussiness.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.mdval.exceptions.ServiceException;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author federico
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OutputProcesa implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3938170200951884495L;
	
	private BigDecimal idProceso;
	private Date pFechaProceso;
	private BigDecimal pCodigoEstadoProceso;
	private String pDescripcionEstadoProceso;
    
    // Para los warnings
    private ServiceException serviceException;

}
