package com.mdsql.bussiness.service.impl;

import com.mdsql.bussiness.entities.Grant;
import com.mdsql.bussiness.entities.Modelo;
import com.mdsql.bussiness.entities.Propietario;
import com.mdsql.bussiness.service.ProcesoService;
import com.mdsql.bussiness.service.PropietarioService;
import com.mdsql.utils.MDSQLConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service(MDSQLConstants.PROPIETARIO_SERVICE)
@Slf4j
public class PropietarioServiceImpl implements PropietarioService {
    @Override
    public List<Propietario> consultarPropietariosSinonimo(Modelo modelo) {
        return Collections.emptyList();
    }

    @Override
    public List<Grant> consultarReceptoresModelo(Modelo modelo) {
        return Collections.emptyList();
    }
}
