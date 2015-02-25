/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.desarollaprueba.service.util;

/**
 *
 * @author JonathaN
 */

import com.pe.desarollaprueba.util.SystemUtil;
import com.pe.desarollaprueba.dao.jdbc.impl.AlumnoJdbcDao;
import com.pe.desarollaprueba.dao.jdbc.impl.SedeJdbcDao;
import com.pe.desarollaprueba.dao.jdbc.base.EntityDao;


public class ServiceUtil {
  
    private static final String ALUMNO = "Alumno";
    private static final String SEDE = "Sede";

    
    private ServiceUtil(){
        
    }
    
        public static EntityDao obtenerDao(String tabla){
        EntityDao entityDao = null;
       
                
        if(tabla.equalsIgnoreCase(ALUMNO)){
            
                    entityDao = AlumnoJdbcDao.obtenerInstancia();
                    
            }
        else if(tabla.equalsIgnoreCase(SEDE)){
           
                    entityDao = SedeJdbcDao.obtenerInstancia();
                    
            }
        
        
        return entityDao;
    }
    
}
