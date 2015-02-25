/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.desarollaprueba.Web.util;

import com.pe.desarollaprueba.service.base.BaseService;
import com.pe.desarollaprueba.util.SystemUtil;
import com.pe.desarollaprueba.service.impl.AlumnoServiceImpl;
import com.pe.desarollaprueba.service.impl.SedeServiceImpl;
import java.text.MessageFormat;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author JonathaN
 */
public class WebUtil {
    
    
   private WebUtil(){
        
    }
   
   
 public static void mensajeError(String codigo, String mensaje) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, codigo, mensaje));
    }

    public static void mensajeInformacion(String codigo, String mensaje) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, codigo, mensaje));
    }
    
    public static void mensajeAdvertencia(String codigo, String mensaje) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, codigo, mensaje));
    }
    
public static String controlarError(Exception excepcion){
        StringBuilder sb = new StringBuilder();
        String idError = SystemUtil.convertirDate(new Date(), "ddMMyyyyhhmmss");
        sb.append(MessageFormat.format("Código de error: {0} \n", idError));
        sb.append(MessageFormat.format("Mensaje del error: {0} \n", 
                excepcion.getMessage()));
        return sb.toString();
    } 
   
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
