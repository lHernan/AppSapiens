package com.mdval.bussiness.entities;

import java.math.BigDecimal;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class CampoGlosario {

    private String nombreColumna;
    private String tipoDato;
    private BigDecimal numeroLongitud;
    private BigDecimal numeroDecimal;
    private BigDecimal codigoGlosario;
    private String mcaExcepcion;
    private String txtComentario;
    private String txtExcepcion;
    private String codigoUsuario;
    private Date fechaActualizacion;
}
