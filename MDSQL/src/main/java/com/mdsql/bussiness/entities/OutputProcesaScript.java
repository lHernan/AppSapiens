package com.mdsql.bussiness.entities;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author hcarreno
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OutputProcesaScript extends OutputProcesa {

    /**
	 * 
	 */
	private static final long serialVersionUID = -1098930944566895366L;
	private List<Script> listaScripts;

}
