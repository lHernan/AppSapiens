package com.mdsql.bussiness.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class ObjetoHis implements Serializable {

    private String nombreObjeto;
    private String tipoObjeto;
    private String descripcionTipoObjeto;
    private String mcaHis;

}
