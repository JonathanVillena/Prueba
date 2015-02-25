package com.pe.desarollaprueba.Web.controller;

import com.pe.desarollaprueba.Web.util.WebUtil;
import com.pe.desarollaprueba.service.AlumnoService;
import com.pe.desarollaprueba.service.SedeService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "EliminarController", urlPatterns ={"/EliminarController"} )
public class EliminarController extends HttpServlet {

    
    	private final static String Mensaje_Eliminar = "Se elimino correctamente ";
	private final static String MENSAJE_ERROR = "Ocurrio un error: ";
  
    final private SedeService sedeService;
    final private AlumnoService alumnoService;
    
    public EliminarController(){
        sedeService=(SedeService)WebUtil.obtenerService("Sede");
        alumnoService=(AlumnoService)WebUtil.obtenerService("Alumno");
    }
      protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          
          try{
              
              String TipoElimnar=request.getParameter("Tipo");
            int id= Integer.parseInt(request.getParameter("txtID"));
            
            
            if(TipoElimnar.compareTo("Sede")==0)
            {
                sedeService.eliminar(id);
                response.sendRedirect(request.getContextPath()+"/ListarSedes.jsp?mensaje="+Mensaje_Eliminar); 
                
            }else if(TipoElimnar.compareTo("Alumno")==0)
            {
                alumnoService.eliminar(id);
                response.sendRedirect(request.getContextPath()+"/Index.jsp?mensaje="+Mensaje_Eliminar); 
            }
           

          }catch(Exception e){
                   response.sendRedirect(request.getContextPath()+"/Index.jsp?mensaje="+MENSAJE_ERROR+e.getMessage()); 
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
