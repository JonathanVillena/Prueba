package com.pe.desarollaprueba.test;

import com.pe.desarollaprueba.dao.entity.Alumno;
import com.pe.desarollaprueba.dao.entity.Sede;
import com.pe.desarollaprueba.service.AlumnoService;

import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static com.pe.desarollaprueba.test.obtener.obtenerService;

public class AlumnoTest {
    
    private static List<Alumno> lstAlumnos = new ArrayList<Alumno>();
    private final AlumnoService alumnoService=(AlumnoService)obtenerService("Alumno");
    private static Alumno alumno;
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
        System.out.println("ID: " + alumno.getIdAlumno());
        System.out.println("Codigo: " + alumno.getCodAlumno());
        System.out.println("Nombre: " + alumno.getNombre());
        System.out.println("Apellido: " + alumno.getApellido());
        System.out.println("Direccion: " + alumno.getDireccion());
        System.out.println("Dni: " + alumno.getDni());
        System.out.println("Telefono: " + alumno.getTelefono());
        System.out.println("Celular: " + alumno.getCelular());
        System.out.println("Edad: " + alumno.getEdad());
        System.out.println("Sexo: " + alumno.getSexo());
        System.out.println("IdSede: " + alumno.getSede().getIdSede());
        
    }
    
    @Test
    public void insertar(){
        try {
            alumno = new Alumno();
            sede = new Sede();
            sede.setIdSede(2);
            
            alumno.setNombre("Alumno TestNG");
            alumno.setCodAlumno("176235");
            alumno.setApellido("AlumnoTest");
            alumno.setDni("738352733");
            alumno.setEdad(23);
            alumno.setDireccion("Av. 23111");
            alumno.setTelefono("6262739");
            alumno.setCelular("769496221");
            alumno.setSexo("Masculino");
            alumno.setSede(sede);
            alumnoService.insertar(alumno);
            Assert.assertTrue(true);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Error: " + e.getMessage());
        }
    }
    
    @Test(dependsOnMethods = ("insertar"))
    public void Listar(){
        try {
            lstAlumnos = alumnoService.listar();
            Assert.assertTrue(!(lstAlumnos.isEmpty()));
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Error: " + e.getMessage());
        }
    }
    
    @Test(dependsOnMethods = ("insertar"))
    public void actualizar(){
        try {
            alumno = new Alumno();
            alumno = new Alumno();
            sede = new Sede();
            sede.setIdSede(2);
            
            lstAlumnos = alumnoService.listar();
            int id = lstAlumnos.get(0).getIdAlumno();
            alumno.setIdAlumno(id);
            
            alumno.setNombre("Alumno TestNG Actualizado");
            alumno.setCodAlumno("176235");
            alumno.setApellido("AlumnoTest");
            alumno.setDni("738352733");
            alumno.setEdad(23);
            alumno.setDireccion("Av. 23111");
            alumno.setTelefono("6262739");
            alumno.setCelular("769496221");
            alumno.setSexo("Masculino");
            alumno.setSede(sede);
            alumnoService.actualizar(alumno);
            Assert.assertTrue(true);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Error: " + e.getMessage());
        }
    }
    
    @Test(dependsOnMethods = ("insertar"))
    public void eliminar(){
        try {
            
            lstAlumnos = alumnoService.listar();
            int id = lstAlumnos.get(0).getIdAlumno();
            
            alumnoService.eliminar(id);
            Assert.assertTrue(true);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Error: " + e.getMessage());
        }
    }
    
    @Test(timeOut = 1000 )
    public void tiempo(){
        try {
            
            alumno = new Alumno();
            sede = new Sede();
            sede.setIdSede(2);
            
            alumno.setNombre("Alumno TestNG");
            alumno.setCodAlumno("176235");
            alumno.setApellido("AlumnoTest");
            alumno.setDni("738352733");
            alumno.setEdad(23);
            alumno.setDireccion("Av. 23111");
            alumno.setTelefono("6262739");
            alumno.setCelular("769496221");
            alumno.setSexo("Masculino");
            alumno.setSede(sede);
            alumnoService.insertar(alumno);
            Assert.assertTrue(true);
            
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Error: " + e.getMessage());
        }
    }
    
    
}