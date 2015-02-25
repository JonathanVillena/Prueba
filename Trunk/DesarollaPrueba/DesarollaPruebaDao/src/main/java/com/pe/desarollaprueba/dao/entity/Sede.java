/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.desarollaprueba.dao.entity;

import java.util.Set;

/**
 *
 * @author JonathaN
 */
public class Sede {
         private int idSede;
     private String nombre;
     private String distrito;
     private String direccion;
     private String aforo;
     private String telefono;
     
     
    public Sede() {
    }

	
    public Sede(int idSede) {
        this.idSede = idSede;
    }
    public Sede(int idSede, String nombre, String distrito, String direccion, String aforo, String telefono) {
       this.idSede = idSede;
       this.nombre = nombre;
       this.distrito = distrito;
       this.direccion = direccion;
       this.aforo = aforo;
       this.telefono = telefono;
     
    }
   
    public int getIdSede() {
        return this.idSede;
    }
    
    public void setIdSede(int idSede) {
        this.idSede = idSede;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDistrito() {
        return this.distrito;
    }
    
    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }
    public String getDireccion() {
        return this.direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getAforo() {
        return this.aforo;
    }
    
    public void setAforo(String aforo) {
        this.aforo = aforo;
    }
    public String getTelefono() {
        return this.telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
 


    
}
