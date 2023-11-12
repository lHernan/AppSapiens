package com.mdsql.bussiness.service;

import com.mdsql.bussiness.entities.Entorno;
import com.mdval.exceptions.ServiceException;

import java.util.List;

/**
 * @author hcarreno
 */
public interface EntornoService {


    List<Entorno> consultarEntornos(String nomBBDD, String nomEsquema, String claveEncriptacion, String mcaHabilitado) throws ServiceException;

    void guardarEntorno(String nomBBDD, String nomEsquema, String claveEncriptacion, String password, String mcaHabilitado, String comentario, String codUsr) throws ServiceException;
}
