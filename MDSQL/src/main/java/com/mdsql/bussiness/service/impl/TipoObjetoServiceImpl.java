package com.mdsql.bussiness.service.impl;

import com.mdsql.bussiness.service.TipoObjetoService;
import com.mdsql.utils.MDSQLConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service(MDSQLConstants.TIPO_OBJETO_SERVICE)
@Slf4j
public class TipoObjetoServiceImpl implements TipoObjetoService {
    @Override
    public List<String> consultarTiposObjeto() {
        return Collections.emptyList();
    }
}
