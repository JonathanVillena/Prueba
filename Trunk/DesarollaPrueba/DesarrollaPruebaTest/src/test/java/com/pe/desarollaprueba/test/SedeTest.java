package com.pe.desarollaprueba.test;


import com.pe.desarollaprueba.dao.entity.Sede;
import com.pe.desarollaprueba.service.SedeService;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.pe.desarollaprueba.test.obtener;
import static com.pe.desarollaprueba.test.obtener.obtenerService;

public class SedeTest {
    
     
    private static List<Sede> lstSede = new ArrayList<Sede>();
    private final SedeService sedeService=(SedeService)obtenerService("Sede");
    private static Sede sede;
    
    @BeforeClass
    public void inicioClase(){
        System.out.println("Inicio Clase");
    }
    
    @AfterClass
    public void finClase(){
        System.out.println("Fin Clase");
    }
    
    @BeforeMethod
    public void inicioMetodo(){
        System.out.println("Inicio Metodo");
    }
    
    @AfterMethod
    public void finMetodo(){
        System.out.println("Inicio Metodo");
        System.out.println("ID: " + sede.getIdSede());
        System.out.println("Nombre: " + sede.getNombre());
        System.out.println("Direccion: " + sede.getDireccion());
        System.out.println("Distrito: " + sede.getDistrito());
        System.out.println("Telefono: " + sede.getTelefono());
        System.out.println("Aforo: " + sede.getAforo());
        
    }
    
    @Test
    public void insertar(){
        try {
            sede = new Sede();
            sede.setNombre("Sede TestNG");
            sede.setDireccion("Av. 2325");
            sede.setDistrito("Lima");
            sede.setTelefono("5382649");
            sede.setAforo("1324");
            sedeService.insertar(sede);
            Assert.assertTrue(true);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Error: " + e.getMessage());
        }
    }
    
    @Test(dependsOnMethods = ("insertar"))
    public void Listar(){
        try {
            lstSede = sedeService.listar();
            Assert.assertTrue(!(lstSede.isEmpty()));
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Error: " + e.getMessage());
        }
    }
    
    @Test(dependsOnMethods = ("insertar"))
    public void actualizar(){
        try {
            sede = new Sede();
            sede.setNombre("Sede TestNG Actualizada");
            sede.setDireccion("Av. 2325");
            sede.setDistrito("Lima");
            sede.setTelefono("5382649");
            sede.setAforo("1324");
            sedeService.actualizar(sede);
            Assert.assertTrue(true);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Error: " + e.getMessage());
        }
    }
    

    
    @Test(timeOut = 1000 )
    public void tiempo(){
        try {
            sede = new Sede();
            sede.setNombre("Sede TestNG");
            sede.setDireccion("Av. 2325");
            sede.setDistrito("Lima");
            sede.setTelefono("5382649");
            sede.setAforo("1324");
            sedeService.insertar(sede);
            Assert.assertTrue(true);
            
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Error: " + e.getMessage());
        }
    }
    
    
    
}
