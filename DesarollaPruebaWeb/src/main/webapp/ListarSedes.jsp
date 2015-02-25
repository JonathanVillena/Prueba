<%@page import="com.pe.desarollaprueba.Web.util.WebUtil"%>
<%@page import="com.pe.desarollaprueba.service.SedeService"%>
<%@page import="com.pe.desarollaprueba.service.AlumnoService"%>
<%@page import="com.pe.desarollaprueba.dao.AlumnoDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.pe.desarollaprueba.dao.entity.Sede"%>
<%@page import="com.pe.desarollaprueba.dao.entity.Alumno"%>
<%
   Alumno alum= new Alumno();
   Sede sede= new Sede();
   
   SedeService SedeSer=(SedeService)WebUtil.obtenerService("Sede");
   
   List<Sede>  listSede=new ArrayList<Sede>();   
  
   try {   
   listSede=SedeSer.listar();
  } catch(Exception ex)
  {
     out.println(ex.getMessage());
  }
  
    
  String mensaje = request.getParameter("mensaje");
%>
<%-- 
    Document   : Index
    Created on : 12/02/2015, 01:06:26 PM
    Author     : JonathaN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="css/main.css">
    </head>
    <body>
        <div class="wrapper">
            <header>         

            <div class="row logoheader effect7">
        
              <div class="container">
                    <div class="col-xs-12 col-sm-8 col-md-6 col-lg-6">
                      <div class="col-xs-12 hidden-xs col-sm-3 col-md-3 col-lg-3">
                        <img src="img/upc.png" width="100px" alt="Image">
                      </div>
                      <div class="col-xs-12 col-sm-9 col-md-9 col-lg-9 ">
                        <h1><b>Pruebas De Software</b></h1>
                      </div>
                    </div>
                    <div class="hidden-xs hidden-sm col-md-3 col-lg-3">
                      
                    </div>
                    <div class="col-xs-12 col-sm-4 col-md-3 col-lg-3">
                       <div class="col-xs-5 hidden-xs col-sm-6 col-md-6 col-lg-6">
                          
                       </div>
                       <div class="col-xs-12 col-sm-6 col-md-6 col-lg-6 marginSession">
                         <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 text-center">
                          
                         </div>
                       
                       </div>
                    </div>
              </div>
        
            </div>
            <div class="row">
              <div class="">
                <nav class="navbar navbar-default effect7">
                    <div class="container">
                        <div class="navbar-header">
                            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                            </button>
        
                            <a href="#" class="navbar-brand visible-xs " style="float:right;color:white;">Menu</a>
                        </div>
                        <div class="collapse navbar-collapse navbar-ex1-collapse text-center">
                            <ul class="nav navbar-nav" style="float:none;">
                                 <li class="col-sm-2  col-md-2 col-lg-2 hovermenu"></li>                               
                                <li class="col-sm-3  col-md-3 col-lg-3 hovermenu"><a href="Index.jsp" class="menu-estil"><div class="text-center FuenteMenu">Lista De Almunos </div></a></li>
                               <li class="col-sm-3 col-md-3 col-lg-3 hovermenu"><a href="ListarSedes.jsp" class="menu-estil"><div class="text-center FuenteMenu">Lista De Sedes</div></a></li>
                               <li class="col-sm-3 col-md-3 col-lg-3 hovermenu"><a href="" class="menu-estil"><div class="text-center FuenteMenu">Salir</div></a></li>

                                <li class="col-sm-1 col-md-1 col-lg-1 hovermenu"></li>
        
                             </ul>
                          
                        </div>
                      </div>
               </nav>
             </div>
            </div>
        </header>


            <div class="container">
                
                 
        <div class="col-xs-11 col-sm-11 col-md-12 col-lg-12">
        
          <div id="page-wrapper">
            <div class="row">
               <div class="col-lg-12">
                 <h1 class="page-header">Lista de Sedes</h1>
                </div>
            </div>                            
          </div>
                            
                   <%  if(mensaje!=null) {%>
                     <div class="alert alert-success"> <%= mensaje  %></div> 
                     <%  }%>  
     
          <form method="POST" action="EliminarController?Tipo=Sede" id="Form_Elim"  name="Form_Elim"> 
            <table id="example" class="display" cellspacing="0" width="100%">
        <thead>
          <th> </th>
            <th>Nombre</th>
            <th>Distrito</th>
            <th>Direccion </th>
            <th>Telefono</th>
            <th>Aforo</th>
            <td> </td>
            <td> </td>

    
        </thead>
        <tbody>
            <% for (Sede Se : listSede) {%>

                
                <td ><%= Se.getIdSede()%></td>
                <td><%= Se.getNombre()%></td>
                <td><%= Se.getDistrito()%></td>
                <td><%= Se.getDireccion()%></td>
                <td><%= Se.getTelefono()%></td>
                <td><%= Se.getAforo()%></td>
                <td> <button type="button" class="btn btn-default "  aria-expanded="false" onClick="location.href='ActualizarSede.jsp?id=<%= Se.getIdSede() %>'"> 
                        Actualizar  
                </td>
                 <td> <a class ="eliminar"  >
                        <img src="img/delete.png" alt="" onclick="Eliminar()"  /> 
                                            </a>  </td>
            <input type="hidden" name="txtID" id="txtID" value="<%= Se.getIdSede() %>">
            </tr>
            <% }%>
        </tbody>
      
      

      </table>
        </form>  
                                                       
    
        </div>



      </div>
        
        </div>
    </body>
    
    
           <div class="well well-lg"> 

          <div class="collapse navbar-collapse navbar-ex1-collapse text-center">

           <!-- Single button -->
                      <div class="btn-group">
                        <button type="button" class="btn btn-default "  aria-expanded="false" onClick="location.href='CrearSede.html'">  Crear Sede  </button>
                        <button type="button" class="btn btn-default "  aria-expanded="false">Eliminar Sede </button>
                         
                        
                      </div>
        </div>
       </div>
        
        
        <footer>
            <div class="text-center">
                 <p><div class="text-center">2015-00 @ Todos los derechos reservados</div></p>
            </div>
        </footer>
    
    
</html>


<script type="text/javascript">
function Eliminar () {


   document.Form_Elim.action='EliminarController?Tipo=Sede';
    document.Form_Elim.submit();
    
}
</script>


