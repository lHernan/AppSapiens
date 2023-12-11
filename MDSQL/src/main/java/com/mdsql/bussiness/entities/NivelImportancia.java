package com.mdsql.bussiness.entities;

import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@ToString
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

    @Override
    public boolean equals(Object obj) {
        if(obj == null) {
            return false;
        }

        return ((NivelImportancia) obj).getCodigoNivelAviso().equals(getCodigoNivelAviso());
    }
}
