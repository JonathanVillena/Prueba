
package com.pe.desarollaprueba.dao.jdbc.impl;

import com.pe.desarollaprueba.dao.SedeDao;
import com.pe.desarollaprueba.dao.entity.Sede;
import com.pe.desarollaprueba.dao.jdbc.base.BaseJdbcDao;
import com.pe.desarollaprueba.util.SystemException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JonathaN
 */
public class SedeJdbcDao extends BaseJdbcDao implements SedeDao{
    
    private static final  SedeJdbcDao SEDE_JDBC_DAO;
    
    static {
        SEDE_JDBC_DAO = new SedeJdbcDao();
    }
    
    private SedeJdbcDao(){
        
    }
  
    public static SedeJdbcDao obtenerInstancia(){
        return SEDE_JDBC_DAO;
    }

    public void insertar(Sede e) throws SystemException {
      
        try {
            cn = obtenerConexion();
            StringBuilder sb = new StringBuilder();
            sb.append("INSERT INTO sede(Nombre, Distrito, Direccion, Aforo, Telefono) VALUES(?, ?, ?, ?, ?)");
            pr = cn.prepareStatement(sb.toString(), 
                    PreparedStatement.RETURN_GENERATED_KEYS);
            
            pr.setString(1, e.getNombre().trim().toUpperCase());
            pr.setString(2, e.getDistrito().trim().toUpperCase());
            pr.setString(3, e.getDireccion().trim().toUpperCase());
            pr.setString(4, e.getAforo());
            pr.setString(5, e.getTelefono());
            
            pr.executeUpdate();
            //Obtener las claves autogeneradas
            rs = pr.getGeneratedKeys();
            rs.next();
            e.setIdSede(rs.getInt(1));
            
            
            
            
        } catch (Exception ex) {
            throw new SystemException(ex);
        } finally{
            cerrar(cn, pr, rs);
        }
        

    }

    public void actualizar(Sede e) throws SystemException {
    
         try {
            cn = obtenerConexion();
            StringBuilder sb;
            sb = new StringBuilder();
            sb.append("UPDATE sede SET Nombre=?, Distrito=?, Direccion=?, Aforo=?, Telefono=? WHERE idSede=?");
            
            pr = cn.prepareStatement(sb.toString());
            pr.setString(1, e.getNombre().trim().toUpperCase());
            pr.setString(2, e.getDistrito().trim().toUpperCase());
            pr.setString(3, e.getDireccion().trim().toUpperCase());
            pr.setString(4, e.getAforo());
            pr.setString(5, e.getTelefono());
            pr.setString(6, Integer.toString(e.getIdSede()));
                      
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
            sb.append("DELETE FROM sede WHERE idSede=?");
            
            pr = cn.prepareStatement(sb.toString());
            pr.setString(1, id.toString());
            
            pr.executeUpdate();
            
        } catch (Exception ex) {
            throw new SystemException(ex);
        }finally{
            cerrar(cn, pr, rs);
        }    
         
    }

 
@Override
    public Sede obtener(Integer id) throws SystemException {
        Sede c = new Sede();
        try{
            cn = obtenerConexion();
            StringBuilder sb = new StringBuilder();
            sb.append("SELECT * FROM sede WHERE idSede =?");
            
            pr = cn.prepareStatement(sb.toString());
            pr.setInt(1, id);
            rs = pr.executeQuery();
            
            rs.next();
            c.setIdSede(rs.getInt("idSede"));
            c.setNombre(rs.getString("Nombre"));                 
            c.setDistrito(rs.getString("Distrito"));
            c.setDireccion(rs.getString("Direccion"));
            c.setAforo(rs.getString("Aforo"));
            c.setTelefono(rs.getString("Telefono"));
           
                
        } catch (Exception e) {
            throw new SystemException(e);
        }finally{
            cerrar(cn, pr, rs);
        }
        
        return c;
    }
@Override
    public List<Sede> listar() throws SystemException {
                 List<Sede> listaSede = new ArrayList<Sede>();
        try {
            cn = obtenerConexion();
            StringBuilder sb = new StringBuilder();
            
            sb.append("SELECT * FROM sede ");
            pr = cn.prepareStatement(sb.toString());
            rs = pr.executeQuery();
            while(rs.next()){
                Sede c = new Sede();
                c.setIdSede(rs.getInt("idSede"));
                c.setNombre(rs.getString("Nombre"));                 
                c.setDistrito(rs.getString("Distrito"));
                c.setDireccion(rs.getString("Direccion"));
                c.setTelefono(rs.getString("Telefono"));
                c.setAforo(rs.getString("Aforo"));
                
                
               listaSede.add(c);
             }
            
           
        } catch (Exception e) {
            throw new SystemException(e);
        }finally{
            cerrar(cn, pr, rs);
        }
        return listaSede;
    }

    }

    
    


