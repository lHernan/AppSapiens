package com.mdsql.bussiness.service;

import com.mdsql.bussiness.entities.BBDD;

import java.util.List;

/**
 * @author hcarreno
 */
public interface BBDDService {

    List<BBDD> consultaBBDDModelo(String codigoProyecto);

    String consultaPasswordBBDD(String nombreBBDD, String nombreEsquema, String txtClaveEncriptada);

}
