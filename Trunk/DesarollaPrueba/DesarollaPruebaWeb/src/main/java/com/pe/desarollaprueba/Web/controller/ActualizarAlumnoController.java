package com.pe.desarollaprueba.Web.controller;

import com.pe.desarollaprueba.Web.util.WebUtil;
import com.pe.desarollaprueba.dao.entity.Alumno;
import com.pe.desarollaprueba.dao.entity.Sede;
import com.pe.desarollaprueba.service.AlumnoService;
import com.pe.desarollaprueba.service.SedeService;
import com.pe.desarollaprueba.util.SystemException;
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
@WebServlet(name = "ActualizarAlumnoController", urlPatterns = {"/ActualizarAlumnoController"})
public class ActualizarAlumnoController extends HttpServlet {
    
        final private AlumnoService alumnoService; 
    final private SedeService sedeService;
    
    public ActualizarAlumnoController(){
        alumnoService=(AlumnoService)WebUtil.obtenerService("Alumno");
        sedeService=(SedeService)WebUtil.obtenerService("Sede");
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

	private final static String MENSAJE_ACTUALIZAR = "Se actualizo correctamente el Alumno";
	private final static String MENSAJE_ERROR = "Ocurrio un error: ";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        
                               
                try {   
                               
             String dni=request.getParameter("txtDni");
             String codigo=request.getParameter("txtCodigo");
             String nombre=request.getParameter("txtNombre");        
             String apellido=request.getParameter("txtApellido");
             String direccion=request.getParameter("txtDireccion");
             String telefono=request.getParameter("txtTelefono");
             String celular=request.getParameter("txtCelular");
             String edad=request.getParameter("txtEdad");
             String sexo=request.getParameter("Sexocbx");
             String sedecbx=request.getParameter("sedecbx");
             String id=request.getParameter("id");
             
                Alumno alum= new Alumno();
                Sede sedetmp=new Sede();
                
                alum.setIdAlumno(Integer.parseInt(id));
                alum.setDni(dni);
                alum.setNombre(nombre);
                alum.setApellido(apellido);
                alum.setDireccion(direccion);
                alum.setTelefono(telefono);
                alum.setCelular(celular);
                alum.setCodAlumno(codigo);
                alum.setEdad(Integer.parseInt(edad));
                alum.setSexo(sexo);
                int idsede=Integer.parseInt(sedecbx);
                
                sedetmp=sedeService.obtener(idsede);
                
                alum.setSede(sedetmp);
                
                
                
                                
                alumnoService.actualizar(alum);
                
		

               response.sendRedirect(request.getContextPath()+"/Index.jsp?mensaje="+MENSAJE_ACTUALIZAR); 
               } catch(NumberFormatException | SystemException | IOException ex)
               {
                                      
               response.sendRedirect(request.getContextPath()+"/ActualizarAlumno.jsp?mensaje="+MENSAJE_ERROR+ex.getMessage()); 

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
