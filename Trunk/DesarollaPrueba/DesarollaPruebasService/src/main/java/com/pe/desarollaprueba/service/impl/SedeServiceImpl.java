/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.desarollaprueba.service.impl;

import com.pe.desarollaprueba.dao.SedeDao;
import com.pe.desarollaprueba.dao.entity.Sede;
import com.pe.desarollaprueba.service.util.ServiceUtil;
import com.pe.desarollaprueba.service.SedeService;
import com.pe.desarollaprueba.util.SystemException;
import java.util.List;

/**
 *
 * @author JonathaN
 */
public class SedeServiceImpl implements SedeService{
    
        //Inicio Singleton
    private final static SedeServiceImpl SEDE_SERVICE_IMPL;
    private SedeDao sedeDao;
    
    static{
        SEDE_SERVICE_IMPL = new SedeServiceImpl();
    }
    
    private SedeServiceImpl(){
        //Estoy que obtengo del dao ya sea por JDBC o HIBERNATE
        sedeDao = (SedeDao)ServiceUtil.obtenerDao("Sede");
    }
    
    public static SedeServiceImpl obtenerInstancia(){
        return SEDE_SERVICE_IMPL;
    }
    //Fin Singleton

    /**
     *
     * @param e
     * @throws SystemException
     */
 

    @Override
    public void actualizar(Sede e) throws SystemException {

        sedeDao.actualizar(e);
    }

    @Override
    public void eliminar(Integer id) throws SystemException {
        
        sedeDao.eliminar(id);
    }

    @Override
    public Sede obtener(Integer id) throws SystemException {
        return sedeDao.obtener(id);
    }

    @Override
    public List<Sede> listar() throws SystemException {
        return sedeDao.listar();
     }

    @Override
    public void insertar(Sede e) throws SystemException {
        sedeDao.insertar(e); 
    }
    
}
