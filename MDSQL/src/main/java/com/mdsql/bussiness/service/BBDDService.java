package com.mdsql.bussiness.service;

import java.util.List;

import com.mdsql.bussiness.entities.BBDD;

/**
 * @author hcarreno
 */
public interface BBDDService {

    List<BBDD> consultaBBDDModelo(String codigoProyecto);

    String consultaPasswordBBDD(String nombreBBDD, String nombreEsquema, String txtClaveEncriptada);

}
