/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.desarollaprueba.dao.entity;

/**
 *
 * @author JonathaN
 */
public class Alumno {
      private Integer idAlumno;
     private Sede sede;
     private String codAlumno;
     private String nombre;
     private String apellido;
     private String direccion;
     private String dni;
     private String telefono;
     private String celular;
     private Integer edad;
     private String sexo;
     
     

     public Alumno() {
    }

	
    public Alumno(Sede sede) {
        this.sede = sede;
    }
    public Alumno(Sede sede, String codAlumno, String nombre, String apellido, String direccion, String dni, String telefono, String celular, Integer edad, String sexo) {
       this.sede = sede;
       this.codAlumno = codAlumno;
       this.nombre = nombre;
       this.apellido = apellido;
       this.direccion = direccion;
       this.dni = dni;
       this.telefono = telefono;
       this.celular = celular;
       this.edad = edad;
       this.sexo = sexo;
    }
   
    public Integer getIdAlumno() {
        return this.idAlumno;
    }
    
    public void setIdAlumno(Integer idAlumno) {
        this.idAlumno = idAlumno;
    }
    public Sede getSede() {
        return this.sede;
    }
    
    public void setSede(Sede sede) {
        this.sede = sede;
    }
    public String getCodAlumno() {
        return this.codAlumno;
    }
    
    public void setCodAlumno(String codAlumno) {
        this.codAlumno = codAlumno;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return this.apellido;
    }
    
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getDireccion() {
        return this.direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getDni() {
        return this.dni;
    }
    
    public void setDni(String dni) {
        this.dni = dni;
    }
    public String getTelefono() {
        return this.telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getCelular() {
        return this.celular;
    }
    
    public void setCelular(String celular) {
        this.celular = celular;
    }
    public Integer getEdad() {
        return this.edad;
    }
    
    public void setEdad(Integer edad) {
        this.edad = edad;
    }
    public String getSexo() {
        return this.sexo;
    }
    
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    
}
