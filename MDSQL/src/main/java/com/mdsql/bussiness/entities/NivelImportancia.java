package com.mdsql.bussiness.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class NivelImportancia implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 3697494311301739263L;

    private BigDecimal codigoNivelAviso;
    private String descripcionNivelAviso;
}
