package com.mdsql.bussiness.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author hcarreno
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class OutputReparaScript implements Serializable {

    private String nombreScriptRepara;
    private List<TextoLinea> scriptRepara;
    private String nombreScriptLanza;
    private List<TextoLinea> scriptLanza;
    private String nombreLogRepara;
    private List<ScriptOld> listaScriptOld;
    private List<Script> listaScript;

}
