package com.mdsql.bussiness.service;

import com.mdsql.bussiness.entities.Grant;
import com.mdsql.bussiness.entities.Modelo;
import com.mdsql.bussiness.entities.Propietario;
import com.mdsql.bussiness.entities.TipoObjeto;

import java.util.List;

/**
 * @author hcarreno
 */
public interface PropietarioService {

    List<Propietario> consultarPropietariosSinonimo(Modelo modelo);

    List<Grant> consultarReceptoresModelo(Modelo modelo);
}
