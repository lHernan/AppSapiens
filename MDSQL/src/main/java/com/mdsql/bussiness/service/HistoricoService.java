package com.mdsql.bussiness.service;

import com.mdsql.bussiness.entities.ObjetoHis;
import com.mdsql.bussiness.entities.Objetos;
import com.mdsql.bussiness.entities.TextoLinea;

import java.util.List;

/**
 * @author hcarreno
 */
public interface HistoricoService {

    /**
     * @param listaObjetos
     * @param codigoProyecto
     * @param codigoPeticion
     * @param codigoUsuario
     * @return
     */
    void altaHistorico(List<Objetos> listaObjetos, String codigoProyecto, String codigoPeticion, String codigoUsuario);

    /**
     * @param lineasScript
     * @param codigoProyecto
     * @return objetoHisList
     */
    List<ObjetoHis> seleccionarHistorico(List<TextoLinea> lineasScript, String codigoProyecto);
}
