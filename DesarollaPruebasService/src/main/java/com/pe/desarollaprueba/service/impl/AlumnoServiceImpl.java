/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.desarollaprueba.service.impl;

import com.pe.desarollaprueba.dao.AlumnoDao;
import com.pe.desarollaprueba.dao.SedeDao;
import com.pe.desarollaprueba.dao.entity.Alumno;
import com.pe.desarollaprueba.service.AlumnoService;
import com.pe.desarollaprueba.service.util.ServiceUtil;
import com.pe.desarollaprueba.util.SystemException;
import java.util.List;

/**
 *
 * @author JonathaN
 */
public class AlumnoServiceImpl implements AlumnoService{
     //Inicio Singleton
    private final static AlumnoServiceImpl ALUMNO_SERVICE_IMPL;
    private AlumnoDao alumnoDao;
    
    static{
        ALUMNO_SERVICE_IMPL = new AlumnoServiceImpl();
    }
    
    private AlumnoServiceImpl(){
        //Estoy que obtengo del dao ya sea por JDBC o HIBERNATE
        alumnoDao = (AlumnoDao)ServiceUtil.obtenerDao("Alumno");
    }
    
    public static AlumnoServiceImpl obtenerInstancia(){
        return ALUMNO_SERVICE_IMPL;
    }
    //Fin Singleton

    @Override
    public void insertar(Alumno e) throws SystemException {

         alumnoDao.insertar(e);
        
    }

    @Override
    public void actualizar(Alumno e) throws SystemException {

        alumnoDao.actualizar(e);
    }

    @Override
    public void eliminar(Integer id) throws SystemException {

        alumnoDao.eliminar(id);
    }

    @Override
    public Alumno obtener(Integer id) throws SystemException {
       return alumnoDao.obtener(id); 
    }

    @Override
    public List<Alumno> listar() throws SystemException {
     return alumnoDao.listar();
    }
    
}
