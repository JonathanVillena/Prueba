package com.pe.desarollaprueba.dao.jdbc.impl;

import com.pe.desarollaprueba.dao.AlumnoDao;
import com.pe.desarollaprueba.dao.entity.Alumno;
import com.pe.desarollaprueba.dao.jdbc.base.BaseJdbcDao;
import com.pe.desarollaprueba.util.SystemException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JonathaN
 */
public class AlumnoJdbcDao extends  BaseJdbcDao implements AlumnoDao {
    
   private static final  AlumnoJdbcDao ALUMNO_JDBC_DAO;
    
    static {
        ALUMNO_JDBC_DAO = new AlumnoJdbcDao();
    }
    private AlumnoJdbcDao(){
        
    }
    public static AlumnoJdbcDao obtenerInstancia(){
        return ALUMNO_JDBC_DAO;
    }
    
    public void insertar(Alumno e) throws SystemException {
        
        try {
            cn = obtenerConexion();
            StringBuilder sb = new StringBuilder();
            sb.append("INSERT INTO alumno(CodAlumno, Nombre, Apellido, Direccion, Dni, Telefono, Celular, Edad, Sexo, idSede) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            pr = cn.prepareStatement(sb.toString(), 
                    PreparedStatement.RETURN_GENERATED_KEYS);
            
            pr.setString(1, e.getCodAlumno() );
            pr.setString(2, e.getNombre().trim().toUpperCase());
            pr.setString(3, e.getApellido().trim().toUpperCase());
            pr.setString(4, e.getDireccion().trim().toUpperCase());
            pr.setString(5, e.getDni());
            pr.setString(6, e.getTelefono());
            pr.setString(7, e.getCelular());
            pr.setInt(8, e.getEdad());
            pr.setString(9, e.getSexo());
            pr.setInt(10, e.getSede().getIdSede() );
            
            pr.executeUpdate();
            //Obtener las claves autogeneradas
            rs = pr.getGeneratedKeys();
            rs.next();
            e.setIdAlumno(rs.getInt(1));
            
            
            
            
        } catch (Exception ex) {
            throw new SystemException(ex);
        } finally{
            cerrar(cn, pr, rs);
        }
        

    }

    public void actualizar(Alumno e) throws SystemException {

        try {
            cn = obtenerConexion();
            StringBuilder sb;
            sb = new StringBuilder();
            sb.append("UPDATE alumno SET CodAlumno=?, Nombre=?, Apellido=?, Direccion=?, Dni=?, Telefono=?, Celular=?, Edad=?, Sexo=?, idSede=? WHERE idAlumno=?");
            
            pr = cn.prepareStatement(sb.toString());
            pr.setString(1, e.getCodAlumno() );
            pr.setString(2, e.getNombre().trim().toUpperCase());
            pr.setString(3, e.getApellido().trim().toUpperCase());
            pr.setString(4, e.getDireccion().trim().toUpperCase());
            pr.setString(5, e.getDni());
            pr.setString(6, e.getTelefono());
            pr.setString(7, e.getCelular());
            pr.setString(8, e.getEdad().toString());
            pr.setString(9, e.getSexo());
            pr.setString(10, Integer.toString(e.getSede().getIdSede()) );
            pr.setInt(11, e.getIdAlumno());
                      
            pr.executeUpdate();
            
        } catch (Exception ex) {
            throw new SystemException(ex);
        }finally{
            cerrar(cn, pr, rs);
        }        
    }

    public void eliminar(Integer id) throws SystemException {
        
        try {
            cn = obtenerConexion();
            StringBuilder sb;
            sb = new StringBuilder();
            sb.append("DELETE FROM alumno WHERE idAlumno=?");
            
            pr = cn.prepareStatement(sb.toString());
            pr.setString(1, id.toString());
            
            pr.executeUpdate();
            
        } catch (Exception ex) {
            throw new SystemException(ex);
        }finally{
            cerrar(cn, pr, rs);
        }        
        
    }

    public Alumno obtener(Integer id) throws SystemException {
        
        Alumno c = new Alumno();
        try{
            cn = obtenerConexion();
            StringBuilder sb = new StringBuilder();
            sb.append("SELECT * FROM alumno WHERE idAlumno =? ");
            
            pr = cn.prepareStatement(sb.toString());
            pr.setInt(1, id);
            rs = pr.executeQuery();
            
            rs.next();
            c.setIdAlumno(rs.getInt("idAlumno")); 
            c.setNombre(rs.getString("Nombre"));
            c.setApellido(rs.getString("Apellido"));
            c.setDireccion(rs.getString("Direccion"));
            c.setDni(rs.getString("Dni"));
            c.setTelefono(rs.getString("Telefono"));
            c.setCelular(rs.getString("Celular"));
            c.setEdad(rs.getInt("Edad"));
            c.setSexo(rs.getString("Sexo"));
            c.setCodAlumno(rs.getString("CodAlumno"));
            
        }catch (Exception e){
            throw new SystemException(e);
        }finally{
            cerrar(cn, pr, rs);
        }
        return c;
    }
    
@Override
    public List<Alumno> listar() throws SystemException {
        List<Alumno> listaAlumnos = new ArrayList<Alumno>();
        try {
            cn = obtenerConexion();
            StringBuilder sb;
            sb = new StringBuilder();
            sb.append("SELECT * FROM alumno ORDER BY Apellido");
            pr = cn.prepareStatement(sb.toString());
            rs = pr.executeQuery();
            while(rs.next()){
                Alumno c = new Alumno();
                c.setIdAlumno(rs.getInt("idAlumno"));
                c.setNombre(rs.getString("Nombre"));
                c.setApellido(rs.getString("Apellido"));
                c.setDireccion(rs.getString("Direccion"));
                c.setDni(rs.getString("Dni"));
                c.setTelefono(rs.getString("Telefono"));
                c.setCelular(rs.getString("Celular"));
                c.setEdad(rs.getInt("Edad"));
                c.setSexo(rs.getString("Sexo"));
                c.setCodAlumno(rs.getString("CodAlumno"));  
             
                listaAlumnos.add(c);
            }
        } catch (Exception e) {
            throw new SystemException(e);
        }finally{
            cerrar(cn, pr, rs);
        }
        return listaAlumnos;
    
    }
    
    
}
