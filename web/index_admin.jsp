<%-- 
<%-- 
    Document   : Formulario_Domicilios
    Created on : 16/02/2021, 10:38:53 PM
    Author     : Trabajos
--%>
<%
    HttpSession obj=request.getSession();
    String ua=(String) obj.getAttribute("usuario");
    String ced=(String) obj.getAttribute("cedula");
    String nom_cli=(String) obj.getAttribute("nombre_cli");
%>
<%@page import="Modelos.Mod_Domicilios"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Constructor.Con_Domicilios"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
    <link rel="stylesheet" href="css/styles_header.css">
    <link rel="stylesheet" href="css/Style_index.css">
    
    <!--Font-->
    
    <link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Orbitron:wght@500&display=swap" rel="stylesheet">
    

    <!--CSS-->
    <link rel="stylesheet" href="css/fonts.css">

    <!--ICONO-->
    <link rel="icon" href="img/alianza_1.png">
    
    
    <title>Soy admin :v</title>
  </head>
  <body>
      
      
    

    <!-- Option 1: Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>
    
       <!-- inicio de la cabecera-->
        <header>
            <div class="spinner"></div>
		<!--<div class="wrapper">-->
			
			
			<!--<nav>
				<a href="Formulario_Comprador.jsp">Formulario Comprador</a>
				<a href="Formulario_Domicilios.jsp">Formulario Domicilios</a>
				<a href="Formulario_FActuras.jsp">Formulario Facturas</a>
				<a href="Formulario_empleados.jsp">Formulario empleados</a>
                                <a href="Formulario_usuarios.jsp">Formulario usuarios</a>
                                <a href="formulario_Productos.jsp">Gestion productos</a>
                                <a href="formulario_clientes.jsp">Gestion Clientes</a>
			</nav>-->
                            
        
             <!--</div>-->
                <nav class="navbar navbar-expand-lg fixed-top navbar-light bg" style="background: #DEB916">
                    <div class="logo">Supermercado la Alianza                       
                            <img src="img/shopping-cart-2020929_640.png " class="" >
                            </div>
                    <div class="container-fluid"> 
                            
                        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
                            <span class="navbar-toggler-icon"></span>
                          </button>
                        <div class="collapse navbar-collapse" id="navbarNavDropdown">
                          <ul class="navbar-nav">
                              <li class="nav-item">
                              <a class="nav-link active" aria-current="page" href="#">Inicio</a>
                            </li>
                              <li class="nav-item dropdown">
                              <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                  Formularios
                                  
<!--                       <button type="button" class="btn btn-lg btn-primary" disabled>Formulario Activo</button>
<button type="button" class="btn btn-secondary btn-lg" disabled>Formulario Inactivo</button>

<button type="button" class="btn btn-primary" data-bs-toggle="button" autocomplete="off">Toggle button</button>
<button type="button" class="btn btn-primary active" data-bs-toggle="button" autocomplete="off" aria-pressed="true">Active toggle button</button>
<button type="button" class="btn btn-primary" disabled data-bs-toggle="button" autocomplete="off">Disabled toggle button</button>
    -->                              
                                  
                              </a>
                              <ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                                  <li><a class="dropdown-item nav-link " href="formulario_clientes.jsp">Formularios Clientes</a></li>
                                <li><a class="dropdown-item nav-link" href="formulario_Productos.jsp">Formularios Productos</a></li>
                                <li><a class="dropdown-item nav-link active" href="Formulario_Domicilios.jsp">Formularios Domicilios</a></li>
                                <li><a class="dropdown-item nav-link" href="Formulario_usuarios.jsp">Formularios Usuarios</a></li>
                                <li><a class="dropdown-item nav-link" href="Formulario_FActuras.jsp">Formularios Facturas</a></li>
                                <li><a class="dropdown-item nav-link" href="Formulario_Comprador.jsp">Formularios Compras</a></li>
                                <li><a class="dropdown-item nav-link" href="Carrito.jsp">Carrito de Compras</a></li>
                              </ul>
                            </li>                                               
                            <li class="nav-item">
                              <a class="nav-link active" aria-current="page" href="#">Inicio</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link " href="Formularios de gestion.jsp">Volver</a>
                            </li>
                            <li class="nav-item">
                              <a class="nav-link" href="login.jsp">Iniciar Sesion</a>
                            </li>
                            
                          </ul>
                        </div>
        
            </nav>
       
	</header>
       <!--Contenedor principal que mostrara imagen de bienvenida-->
       
       <div class="conteiner-sm">
            
           <div class="row">
               
               <div class="contenedor">

                   <!--CAROUSEL-->
                   <div id="carouselExampleControls" class="carousel slide" data-bs-ride="carousel">
  <div class="carousel-inner">
    <div class="carousel-item active">
        <img src="img/snack.jpg" class="img-fluid img-principal" alt="...">
    </div>
    <div class="carousel-item">
        <img src="img/supermercado_paginaprincipal.jpg" class="img-fluid img-principal" alt="...">
    </div>
    <div class="carousel-item">
        <img src="img/lefrute.jpg" class="img-fluid img-principal" alt="...">
    </div>
  </div>
  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleControls"  data-bs-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Previous</span>
  </button>
  <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleControls"  data-bs-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Next</span>
  </button>
</div>
           <!--END CAROUSEL-->    
           
                       
                   <div class="centrado">BIENVENIDO A LA PAGINA DE SUPERMERCADOS LA ALIANZA
                   
                       <section>Con los últimos acontecimientos a nivel mundial se ha podido contemplar los problemas que el mundo tiene que afrontar tomando como ejemplo el distanciamiento social, adicional a esto abordamos un problema que consiste en la falta de disponibilidad de los muchos usuarios para adquirir sus productos de la canasta familiar entre otros productos necesarios para la vida cotidiana.
                       </section>
                       
                       
                   
                   </div>
                   

            </div>
               
           </div>
           
       
            <!--Contenedor de la pagina despues de la imagen. Almacenara toda la informacion correspondiente-->
            <div class="container-md">
            <section>
                <div class="container-md">
                    <div class="container " style="transform: translateX(20%)">
<!--                            <h1>Los mejores productos de calidad</h1>
                        </div>
                    <div class="row">
                        

                    <div class="col-10"><p>
                       El supermercado la Alianza cuenta  con un sistema de domicilio eficaz el cual consiste en un paso a paso desde el cual el cliente solicita su pedido mediante vía telefónica cuya relación uno a muchos le permite al cliente adquirir gran cantidad de productos , los empleados toman nota del pedido y los datos del cliente como la dirección, el  nombre del usuario, el apellido y su edad en una libreta  junto con los productos solicitados donde la relación muchos a muchos hace que el empleado pueda organizar la información y los datos del pedido de manera eficaz q e inmediatamente se le informa al encargado del domicilio acerca del pedido y se le brindan los datos del cliente para su respectiva entrega donde la relación muchos a uno toma lugar al momento de entregar los productos del cliente confirmando los datos descritos por el cliente y se analiza la calidad de estos y si cumple las condiciones pactadas se finaliza el  proceso o de lo contrario se repite el proceso para cumplir con las condiciones estipuladas.

                    </p>
                    </div>
                    
                    </div>
                </div>
    -->            
    
    <a  class="showcase">

            <h2>Los mejores productos de calidad</h2>
            <article>El supermercado la Alianza cuenta  con un sistema de domicilio eficaz el cual consiste en un paso a paso desde el cual el cliente solicita su pedido mediante vía telefónica cuya relación uno a muchos le permite al cliente adquirir gran cantidad de productos , los empleados toman nota del pedido y los datos del cliente como la dirección, el  nombre del usuario, el apellido y su edad en una libreta  junto con los productos solicitados donde la relación muchos a muchos hace que el empleado pueda organizar la información y los datos del pedido de manera eficaz q e inmediatamente se le informa al encargado del domicilio acerca del pedido y se le brindan los datos del cliente para su respectiva entrega donde la relación muchos a uno toma lugar al momento de entregar los productos del cliente confirmando los datos descritos por el cliente y se analiza la calidad de estos y si cumple las condiciones pactadas se finaliza el  proceso o de lo contrario se repite el proceso para cumplir con las condiciones estipuladas.
            </article>
            <a href="#" class="btn">Read More <i class="fas fa-angle-double-right"></i></a>


        </a>

            </section>    
                    </div>
                    
                </div>
                
            </div>
       </div>
       
       

<div class="progress">
  <div class="progress-bar progress-bar-striped progress-bar-animated bg-danger" role="progressbar" style="width: 100%" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100">Generando factura PDF</div>
</div>

            <section class="social">

                <p>¿TIENES DUDAS?

                    <div class="links">

                <a href="#">

                    <i class="fab fa-facebook-f"></i>

                </a>

                <a href="#">

                    <i class="fab fa-whatsapp"></i>

                </a>

                <a href="#">

                    <i class="fab fa-youtube"></i>

                </a>


                    </div>

                </p>

            </section>



   
    <div class="footer-links">

        <div class="footer-container">
            <ul>
                <li>
                    <a href="#">
                        <h1></h1>
                    </a>
                </li>
                <li>

                    <!-- Button trigger modal -->
<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#staticBackdrop">
  ¿Donde se ubica el supermercado La Alianza?
</button>

<!-- Modal -->
<div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="staticBackdropLabel">Estimado usuario:</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="close"></button>
      </div>
      <div class="modal-body">
          <div class="progress">
  <div class="progress-bar progress-bar-striped progress-bar-animated bg-danger" role="progressbar" style="width: 100%" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100">Generando factura PDF</div>
</div>
        Tambien llamado "Autoservicio La Alianza" nuestra sucursal principal se ubica actualmente en Cl. 19 Este, Madrid, Cundinamarca...
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
        
        
      </div>
    </div>
  </div>
</div>
<!--Fin Modal-->
<!-- Button trigger modal -->
<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
  ¿A que se dedica precisamente el supermercado La Alianza?
</button>

<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
     
    <div class="modal-content">
        
      <div class="modal-header">
          
        <h5 class="modal-title" id="exampleModalLabel">Estimado usuario:</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
                  <div class="progress">
  <div class="progress-bar progress-bar-striped progress-bar-animated bg-danger" role="progressbar" style="width: 100%" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100">Generando factura PDF</div>
</div>
          El supermercado La Alianza dispone de un comercio al por menor en establecimientos no especializados con surtido compuesto principalmente por alimentos bebidas o tabaco.
      </div>
        
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>

      </div>
    </div>
  </div>
</div>

<!--Fin Modal-->

                </li>
  


            </ul>

            <ul>
                <li>
                    <a href="#">
                        <h1></h1>
                    </a>
                </li>
                <li>

<!-- Button trigger modal -->
<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#staticBackdrop">
  ¿Como me puedo comunicar con el supermercado?
</button>

<!-- Modal -->
<div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="staticBackdropLabel">Modal title</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
                          <div class="progress">
  <div class="progress-bar progress-bar-striped progress-bar-animated bg-danger" role="progressbar" style="width: 100%" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100">Generando factura PDF</div>
</div>
          El supermercado La Alianza dispone de un comercio al por menor en establecimientos no especializados con surtido compuesto principalmente por alimentos bebidas o tabaco.
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Understood</button>
      </div>
    </div>
  </div>
</div>
<!-- Button trigger modal -->
<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
  ¿Hasta donde realiza domicilios el supermercado La Alianza?
</button>

<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
     
    <div class="modal-content">
        
      <div class="modal-header">
          
        <h5 class="modal-title" id="exampleModalLabel">Estimado usuario:</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
                  <div class="progress">
  <div class="progress-bar progress-bar-striped progress-bar-animated bg-danger" role="progressbar" style="width: 100%" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100">Generando factura PDF</div>
</div>
          El supermercado La Alianza dispone de un comercio al por menor en establecimientos no especializados con surtido compuesto principalmente por alimentos bebidas o tabaco.
      </div>
        
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>

      </div>
    </div>
  </div>
</div>

<!--Fin Modal-->

                </li>
  


            </ul>
            
                        <ul>
                <li>
                    <a href="#">
                        <h1></h1>
                    </a>
                </li>
                <li>

                    <!-- Button trigger modal -->
<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#staticBackdrop">
  ¿Donde se ubica el supermercado La Alianzassssssssssss?
</button>

<!-- Modal -->
<div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="staticBackdropLabel">Estimado usuario:</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="close"></button>
      </div>
      <div class="modal-body">
          <div class="progress">
  <div class="progress-bar progress-bar-striped progress-bar-animated bg-danger" role="progressbar" style="width: 100%" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100">Generando factura PDF</div>
</div>
        Tambien llamado "Autoservicio La Alianza" nuestra sucursal principal se ubica actualmente en Cl. 19 Este, Madrid, Cundinamarca...
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
        
        
      </div>
    </div>
  </div>
</div>
<!--Fin Modal-->
<!-- Button trigger modal -->
<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
  ¿A que se dedica precisamente el supermercado La Alianzassssssssssss?
</button>

<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
     
    <div class="modal-content">
        
      <div class="modal-header">
          
        <h5 class="modal-title" id="exampleModalLabel">Estimado usuario:</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
                  <div class="progress">
  <div class="progress-bar progress-bar-striped progress-bar-animated bg-danger" role="progressbar" style="width: 100%" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100">Generando factura PDF</div>
</div>
          El supermercado La Alianza dispone de un comercio al por menor en establecimientos no especializados con surtido compuesto principalmente por alimentos bebidas o tabaco.
      </div>
        
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>

      </div>
    </div>
  </div>
</div>

<!--Fin Modal-->

                </li>
  


            </ul>
            
                        <ul>
                <li>
                    <a href="#">
                        <h1></h1>
                    </a>
                </li>
                <li>

                    <!-- Button trigger modal -->
<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#staticBackdrop">
  ¿Donde se ubica el supermercado La Alianzazzzzzzzzzzzzz?
</button>

<!-- Modal -->
<div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="staticBackdropLabel">Estimado usuario:</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="close"></button>
      </div>
      <div class="modal-body">
          <div class="progress">
  <div class="progress-bar progress-bar-striped progress-bar-animated bg-danger" role="progressbar" style="width: 100%" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100">Generando factura PDF</div>
</div>
        Tambien llamado "Autoservicio La Alianza" nuestra sucursal principal se ubica actualmente en Cl. 19 Este, Madrid, Cundinamarca...
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
        
        
      </div>
    </div>
  </div>
</div>
<!--Fin Modal-->
<!-- Button trigger modal -->
<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
  ¿A que se dedica precisamente el supermercado La Alianzazzzzzzzzzzzz?
</button>

<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
     
    <div class="modal-content">
        
      <div class="modal-header">
          
        <h5 class="modal-title" id="exampleModalLabel">Estimado usuario:</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
                  <div class="progress">
  <div class="progress-bar progress-bar-striped progress-bar-animated bg-danger" role="progressbar" style="width: 100%" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100">Generando factura PDF</div>
</div>
          El supermercado La Alianza dispone de un comercio al por menor en establecimientos no especializados con surtido compuesto principalmente por alimentos bebidas o tabaco.
      </div>
        
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>

      </div>
    </div>
  </div>
</div>

<!--Fin Modal-->

                </li>
  


            </ul>

        </div>

    </div>

    <footer class="footer">

        <h3>Yopi`s Company Copyright &copy;</h3>
        
        

    </footer>


    </div>
       
                    <!--SCROLLREVEAL-->
<script src="https://unpkg.com/scrollreveal"></script>
   
<!--CUSTOM JS-->
    <script src="main.js"></script>

                    
  </body>
</html>

