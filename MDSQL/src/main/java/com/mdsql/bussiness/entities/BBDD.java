package com.mdsql.bussiness.entities;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private String password;

}
