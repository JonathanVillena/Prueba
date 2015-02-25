package com.pe.desarollaprueba.test;

import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.Selenium;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SedeRcTest {
    
    private Selenium selenium;
    
   @BeforeClass
   public void inicioClase(){
       selenium= new DefaultSelenium("localhost",4444,"firefox","http://localhost:8080/");
       selenium.start();
   }
   
   @Test
   public void insertarSede(){
       selenium.open("/DesarollaPruebaWeb/CrearSede.jsp");
       selenium.waitForPageToLoad("3000"); 
       selenium.type("txtNombreSede", "NomAlumnoRC");
       selenium.type("txtDistritoSede", "ApellidoRC");
       selenium.type("txtDireccionSede", "DireccionRC");
       selenium.type("txtAforoSede", "45678911");
       selenium.type("txtTelefonoSede", "7623736");
       selenium.click("btnCrearSede");
       selenium.waitForPageToLoad("3000"); 
   }
   
   @Test
   public void lsitarSede(){
       selenium.open("/DesarrollaPruebaWeb/ListarSedes.jsp");
       selenium.waitForPageToLoad("3000");
   }
   
   @AfterClass
   public void finClase(){
       selenium.stop();
   }
   
    
}

