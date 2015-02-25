package com.pe.desarollaprueba.test;

import com.pe.desarollaprueba.service.base.BaseService;
import com.pe.desarollaprueba.service.impl.AlumnoServiceImpl;
import com.pe.desarollaprueba.service.impl.SedeServiceImpl;

/**
 *
 * @author JonathaN
 */
public class obtener {
    
       public static BaseService obtenerService(String clase){
        BaseService baseService = null;
        if(clase.equalsIgnoreCase("Alumno")){
            baseService = AlumnoServiceImpl.obtenerInstancia();
        }else if(clase.equalsIgnoreCase("Sede")){
            baseService = SedeServiceImpl.obtenerInstancia();
        }
        return baseService;
    }
}
