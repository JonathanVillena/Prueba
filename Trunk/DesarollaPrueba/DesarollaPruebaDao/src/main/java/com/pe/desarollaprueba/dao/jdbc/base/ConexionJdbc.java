
package com.pe.desarollaprueba.dao.jdbc.base;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class ConexionJdbc {
    protected Connection cn = null;
    protected CallableStatement cl = null;
    protected PreparedStatement pr = null;
    protected ResultSet rs = null;
    
    
    protected Connection obtenerConexion() throws Exception{
        
                   
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/pruebas";
            String usuario = "root";
            String clave = "root";
            return DriverManager.getConnection(url, usuario, clave);
        

    }
    
    protected void cerrar(Connection cn, PreparedStatement pr){
        try {
            pr.close();
            cn.close();
        } catch (Exception e) {
            
            
        }
    }
    
    protected void cerrar(Connection cn, PreparedStatement pr, 
            ResultSet rs) {
        try {
            rs.close();
            pr.close();
            cn.close();
        } catch (Exception e) {
            
        }
    }
    
}





    