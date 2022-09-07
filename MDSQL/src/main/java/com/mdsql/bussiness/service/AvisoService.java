package com.mdsql.bussiness.service;

import com.mdsql.bussiness.entities.Aviso;

import java.util.List;

/**
 * @author hcarreno
 */
public interface AvisoService {


    List<Aviso> consultaAvisosModelo(String codigoProyecto);

}
