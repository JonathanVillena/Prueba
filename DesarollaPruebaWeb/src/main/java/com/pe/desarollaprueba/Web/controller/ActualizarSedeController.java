package com.pe.desarollaprueba.Web.controller;

import com.pe.desarollaprueba.Web.util.WebUtil;
import com.pe.desarollaprueba.dao.entity.Sede;
import com.pe.desarollaprueba.service.SedeService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author JonathaN
 */
@WebServlet(name = "ActualizarSedeController", urlPatterns ={"/ActualizarSedeController"} )
public class ActualizarSedeController extends HttpServlet {


	private final static String MENSAJE_ACTUALIZAR = "Se actualizo correctamente la sede";
	private final static String MENSAJE_ERROR = "Ocurrio un error: ";
  
    final private SedeService sedeService;
    
    public ActualizarSedeController(){
        sedeService=(SedeService)WebUtil.obtenerService("Sede");
    }

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {   
                               
                            
             String nombre=request.getParameter("txtNombreSede");        
             String distrito=request.getParameter("txtDistritoSede");
             String direccion=request.getParameter("txtDireccionSede");
             String telefono=request.getParameter("txtTelefonoSede");
             String aforo=request.getParameter("txtAforoSede");
             String id=request.getParameter("id");


             
                Sede sede= new Sede();
                
                
           
                sede.setNombre(nombre);
                sede.setDireccion(direccion);
                sede.setTelefono(telefono);                
                sede.setDistrito(distrito);
                sede.setAforo(aforo);
                sede.setIdSede(Integer.parseInt(id));
                
                
                                
                sedeService.actualizar(sede);
                
              
response.sendRedirect(request.getContextPath()+"/ListarSedes.jsp?mensaje="+MENSAJE_ACTUALIZAR);                
            } catch(Exception ex)
               {
                   response.sendRedirect(request.getContextPath()+"/ActualizarSede.jsp?mensaje="+MENSAJE_ERROR+ex.getMessage()); 
                   
               }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
