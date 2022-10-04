package com.mdsql.bussiness.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class OutputErroresScript implements Serializable {

    private List<ErrorScript> listaErroresScript;
    private List<ScriptParche> listaScriptParche;

}
