package com.mdsql.bussiness.entities;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class OutputErroresScript implements Serializable {

    private List<ErrorScript> listaErroresScript;
    private List<ScriptParche> listaScriptParche;

}
