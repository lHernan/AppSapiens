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
public class BBDD implements Serializable {

    private String nombreBBDD;
    private String nombreEsquema;
    private String nombreBBDDHis;
    private String nombreEsquemaHis;
    private String mcaDefecto;

}
