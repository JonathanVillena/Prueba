<%-- 
    Document   : CrearSede
    Created on : 16/02/2015, 12:37:58 PM
    Author     : JonathaN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
<%
     
    String mensaje = request.getParameter("mensaje");

%>    
    
    
    
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title></title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">


        
        <link rel="stylesheet" href="css/normalize.css">
        <link rel="stylesheet" href="css/main.css">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/alertify.core.css">
        <link rel="stylesheet" href="css/alertify.default.css">
                <link rel="stylesheet" href="css/jquery.dataTables.css">
        <link rel="stylesheet" type="text/css" href="css/fancybox/jquery.fancybox.css?v=2.1.5" media="screen" />

        <script src="js/vendor/jquery.min.js"></script>
        <script src="js/plugins.js"></script>
        <script src="js/main.js"></script>
        <script src="js/vendor/modernizr-2.6.2.min.js"></script>        
        <script src="js/bootstrap.min.js"></script>
        <script src="js/alertify.js"></script>
        <script src="js/jquery.dataTables.js"></script>
        <script type="text/javascript" src="css/fancybox/jquery.fancybox.js?v=2.1.5"></script>
<script>
function alerta(){
        //un alert
        alertify.alert("<b>Archivo Subido</b>", function () {
          //aqui introducimos lo que haremos tras cerrar la alerta.
          //por ejemplo -->  location.href = 'http://www.google.es/';  <-- Redireccionamos a GOOGLE.
          location.href='AgregaDato.html';
        });
      }
      
</script>
<script>
function alerta_eli(){
        //un alert
        alertify.alert("<b>Archivo Eliminado</b>", function () {
          //aqui introducimos lo que haremos tras cerrar la alerta.
          //por ejemplo -->  location.href = 'http://www.google.es/';  <-- Redireccionamos a GOOGLE.
          location.href='EliminaDato.html';
        });
      }
</script>
<script>
$(document).ready(function() {
  $('#example').dataTable();
} );


  </script>


    </head>
    <style type="text/css">
  
  .marginEtiqueta{
    margin-bottom: 50px;
    border-color: 1px;
                }
  .marginSession{
    margin-top: 20px;
  }
</style>
    <body>
        <!--[if lt IE 7]>
            <p class="browsehappy">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
        <![endif]-->

        <!-- Add your site or application content here -->
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
                
                 
        <div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
        
          <div id="page-wrapper">
            <div class="row">
               <div class="col-lg-12">
                 <h1 class="page-header">Crear Sede</h1>
                </div>
            </div>                            
          </div>
        
                  
            
     <form action="SedeController" method="POST">
        <div class="form-group">
          <label for="exampleInputName2">Nombre</label>
          <input type="text" class="form-control" name="txtNombreSede" placeholder="Jane Doe"required  maxlength="40">
        </div>
        <div class="form-group">
          <label for="exampleInputEmail2">Distrito</label>
          <input type="text" class="form-control" name="txtDistritoSede" placeholder="jane.doe@example.com" required  maxlength="30">
        </div>
        <div class="form-group">
          <label for="exampleInputEmail2">Direccion</label>
          <input type="text" class="form-control" name="txtDireccionSede"  placeholder="jane.doe@example.com" required  maxlength="50">
        </div>
        <div class="form-group">
          <label for="exampleInputEmail2">Aforo</label>
          <input type="text" class="form-control" name="txtAforoSede" placeholder="jane.doe@example.com" maxlength="5">
        </div>
                <div class="form-group">
                      <label for="exampleInputEmail2">Telefono</label>
                      <input type="text" class="form-control" name="txtTelefonoSede" placeholder="11" required  maxlength="30">
                </div>
           <button  class="btn btn-default " name="btnCrearSede">   <b>Crear Sede </b></a></button>
      </form>
       <%  if(mensaje!=null) {%>
        <div class="alert alert-success"> <%= mensaje  %></div> 
       <%  }%> 
       
            
            
            
       


       </div>

     </div>
     <div> .</div>
     <div> .</div>
         

    </div><!--fin de wrapper-->
        <footer>
            <div class="text-center">
                 <p><div class="text-center">2015-00 @ Todos los derechos reservados</div></p>
            </div>
        </footer>

    </body>
    <script  type="text/javascript">

     $(document).ready(function(){

        $("#btncerrar").click(function(){
          window.location.href="index.html";

        });

     });
    </script>
</html>



