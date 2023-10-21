package com.mdsql.bussiness.service.impl;

import com.mdsql.bussiness.entities.Entorno;
import com.mdsql.bussiness.service.EntornoService;
import com.mdsql.utils.MDSQLConstants;
import com.mdval.exceptions.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service(MDSQLConstants.ENTORNO_SERVICE)
@Slf4j
public class EntornoServiceImpl implements EntornoService {
    @Override
    public List<Entorno> consultarEntornos(String nomBBDD, String nomEsquema, String claveEncriptacion, String mcaHabilitado) throws ServiceException {
        return Collections.emptyList();
    }

    @Override
    public void guardarEntorno(String nomBBDD, String nomEsquema, String claveEncriptacion, String password, String mcaHabilitado, String comentario, String codUsr) throws ServiceException {

    }
}
