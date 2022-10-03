package com.mdsql.bussiness.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author hcarreno
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class OutputDescartarScript implements Serializable {

    private List<Script> listaParches;
    private List<ScriptOld> listaScriptOld;
    private List<Script> listaScriptNew;
    private BigDecimal codigoEstadoProceso;
    private String descripcionEstadoProceso;

}
