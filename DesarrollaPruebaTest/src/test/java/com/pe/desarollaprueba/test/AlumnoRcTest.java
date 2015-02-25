package com.pe.desarollaprueba.test;

import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.Selenium;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AlumnoRcTest {
    
    private Selenium selenium;
    
   @BeforeClass
   public void inicioClase(){
       selenium= new DefaultSelenium("localhost",4444,"firefox","http://localhost:8080/");
       selenium.start();
   }
   
   @Test
   public void insertarAlumno(){
       selenium.open("/DesarollaPruebaWeb/CrearAlumno.jsp");
       selenium.type("txtNombre", "NomAlumnoRC");
       selenium.type("txtApellido", "ApellidoRC");
       selenium.type("txtDireccion", "DireccionRC");
       selenium.type("txtDni", "45678911");
       selenium.type("txtTelefono", "7623736");
       selenium.type("txtCelular", "273642983");
       selenium.type("txtEdad", "23");
       selenium.click("btnCrearAlumno");
       selenium.waitForPageToLoad("3000");   
   }
   
   @Test
   public void lsitarAlumnos(){
       selenium.open("/DesarrollaPruebaWeb/Index.jsp");
       selenium.waitForPageToLoad("3000"); 
   }
   
   @AfterClass
   public void finClase(){
       selenium.stop();
   }
   
    
}
