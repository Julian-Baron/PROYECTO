<%-- 
    Document   : Formularios de gestion
    Created on : 7/03/2021, 03:34:17 PM
    Author     : Personal
--%>
<%@page import="javax.swing.JOptionPane"%>
<%
    HttpSession obj=request.getSession();
    String ua=(String) obj.getAttribute("usuario");
    String ced=(String) obj.getAttribute("cedulaa");
    String nom_cli=(String) obj.getAttribute("nombre_cli");
    String rol=(String) obj.getAttribute("rol");
    
    if(ua==null){
        response.sendRedirect("login.jsp");
    }
    
    
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
    <link rel="stylesheet" href="css/styles_header.css">
    
       <!--Font-->
    
    <link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Orbitron:wght@500&display=swap" rel="stylesheet">
    

    <!--CSS-->
    <link rel="stylesheet" href="css/fonts.css">


    <!--ICONO-->
    <link rel="icon" href="img/alianza_1.png">
    
    <title>Formularios de Gestion Clientes</title>
  </head>
  <body class="mr-0 row" style="display: flex;">
    

    <!-- Optional JavaScript; choose one of the two! -->

    <!-- Option 1: Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>

    <!-- Option 2: Separate Popper and Bootstrap JS -->
    <!--
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.6.0/dist/umd/popper.min.js" integrity="sha384-KsvD1yqQ1/1+IA7gi3P0tyJcT3vR+NdBTt13hSJ2lnve8agRGXTTyNaBYmCR/Nwi" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.min.js" integrity="sha384-nsg8ua9HAw1y0W1btsyWgBklPnCUAFLuTMS2G72MMONqmOymq585AcH49TLBQObG" crossorigin="anonymous"></script>
    -->
       <!-- inicio de la cabecera-->
       <header id="container">        
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
                    <div class="container"> 
                       
                        <a class="navbar-brand" href="index.jsp">Inicio</a>
                        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
                            <span class="navbar-toggler-icon"></span>
                        </button>
                        <div class="collapse navbar-collapse" id="navbarNavDropdown">
                            <ul class="navbar-nav">                             
                                <li class="nav-item">
                                  <a class="nav-link active" aria-current="page" href="Formulario_Comprador.jsp"></a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link " href="Formularios de gestion.jsp">Volver</a>
                                </li>
                              
                            </ul>
                        </div>
                            <div class="collapse navbar-collapse" id="navbarNavDropdown">
                                        <ul class="navbar-nav">
                                          <li class="nav-item dropdown">
                                          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                              <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-person-square m-2" viewBox="0 0 16 16">
                                                  <path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z"/>
                                                  <path d="M2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2zm12 1a1 1 0 0 1 1 1v12a1 1 0 0 1-1 1v-1c0-1-1-4-6-4s-6 3-6 4v1a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1h12z"/>
                                              </svg>Bienvenido <%=ua%>
                                          </a>
                                          <ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">

                                            <li><form action="cerrar_sesion" method="post"><button name="terminar" class="btn btn-primary">Cerrar sesion</button></form></li>
                                          </ul>
                                        </li>                                               
                                        <li class="nav-item">
                                          <a class="nav-link active" aria-current="page" href="Formulario_Comprador.jsp"></a>
                                        </li>

                                      </ul>
                                    </div> 
                            </div>
        
            </nav>
       
	</header>
       
    <div class="container-xl" id="container-first">
        <div class="row text-center  justify-content-center">   
            <div class="card" style="width: 20rem; margin: 20px; padding: 0px">
                <img src="img/avatar-2155431_640.png" class="card-img-top" alt="..." style="height: 240px">
                <div class="card-body">
                    <a href="formulario_clientes.jsp" style="text-decoration: none"><h5 class="card-title">Formularios clientes</h5></a>
                  <p class="card-text">Gestion de clientes que se han registradro.</p>
                  <a href="formulario_clientes.jsp" class="btn btn-primary">Dirijirse...</a>
                </div>
            </div>
            <div class="card" style="width: 20rem; margin: 20px;">
                <img src="img/home-304190_1280.png" class="card-img-top" alt="..." >
                <div class="card-body">
                    <a href="Formulario_Domicilios.jsp" style="text-decoration: none"><h5 class="card-title">Formularios Domicilios</h5></a>
                  <p class="card-text">Gestion de domicilios que se han registradro.</p>
                  <a href="Formulario_Domicilios.jsp" class="btn btn-primary">Dirijirse...</a>
                </div>
            </div>
            
            <div class="card" style="width: 20rem; margin: 20px;">
                <img src="img/store-4156934_1280.png" class="card-img-top" alt="..." style="height: 240px;">
                <div class="card-body">
                    <a href="Formulario_Comprador.jsp" style="text-decoration: none"><h5 class="card-title">Formularios gestion de compras</h5></a>
                  <p class="card-text">Gestion de compras que se han registradro.</p>
                  <a href="Formulario_Comprador.jsp" class="btn btn-primary">Dirijirse...</a>
                </div>
            </div>
            <% 
                if(rol.equalsIgnoreCase("administrador")){
                    %>
                    
                    <div class="card" style="width: 20rem; margin: 20px; padding: 0px">
                        <img src="img/avatar-2155431_640.png" class="card-img-top" alt="..." style="height: 240px">
                        <div class="card-body">
                            <a href="formulario_clientes.jsp" style="text-decoration: none"><h5 class="card-title">Formularios Empleados</h5></a>
                          <p class="card-text">Gestion de empleados que se han registradro.</p>
                          <a href="Formulario_empleados.jsp" class="btn btn-primary">Dirijirse...</a>
                        </div>
                    </div>
                    
                    <div class="card" style="width: 20rem; margin: 20px;">
                        <img src="img/usuarios.png" class="card-img-top" alt="..." >
                            <div class="card-body">
                                <a href="Formulario_usuarios.jsp" style="text-decoration: none"><h5 class="card-title">Formularios gestion de Usuarios</h5></a>
                                <p class="card-text">Gestion de usuarios que se han registradro.</p>
                                <a href="Formulario_usuarios.jsp" class="btn btn-primary">Dirijirse...</a>
                            </div>
                    </div>

                    <%
                }
                %>
            
            <div class="card" style="width: 20rem; margin: 20px;">
                <img src="img/Facturas.jpg" class="card-img-top" alt="..." style="height: 293px">
                <div class="card-body">
                    <a href="Formulario_FActuras.jsp" style="text-decoration: none"><h5 class="card-title">Formularios gestion de Facturas</h5></a>
                  <p class="card-text">Gestion de Facturas que se han registradro.</p>
                  <a href="Formulario_FActuras.jsp" class="btn btn-primary">Dirijirse...</a>
                </div>
            </div>  
            <div class="card" style="width: 20rem; margin: 20px;">
                <img src="img/supermarket-shelf-1094817_1920.png" class="card-img-top" alt="..." >
                <div class="card-body">
                    <a href="formulario_Productos.jsp" style="text-decoration: none"><h5 class="card-title">Formularios gestion de Productos</h5></a>
                  <p class="card-text">Gestion de Productos que se han registradro.</p>
                  <a href="formulario_Productos.jsp" class="btn btn-primary">Dirijirse...</a>
                </div>
            </div>
            <%
                
            %>
            <div class="card" style="width: 20rem; margin: 20px;">
                <img src="img/supermarket-shelf-1094817_1920.png" class="card-img-top" alt="..." >
                <div class="card-body">
                    <a href="formulario_Productos.jsp" style="text-decoration: none"><h5 class="card-title">Facturas y compras realizadas para la gestion de Domicilios</h5></a>
                  <p class="card-text">Gestion de Domicilios que se han registradro.</p>
                  <a href="gestion_domicilios.jsp" class="btn btn-primary">Dirijirse...</a>
                </div>
            </div>
            
            
            <div class="card" style="width: 20rem; margin: 20px;">
                <img src="img/shopping-cart-2020929_640.png" class="card-img-top" alt="..." >
                <div class="card-body">
                    <a href="formulario_Productos.jsp" style="text-decoration: none"><h5 class="card-title">Domicilios asignados</h5></a>
                  <p class="card-text">Gestion de Domicilios que se han registradro.</p>
                  <a href="Domicilios-asignados.jsp" class="btn btn-primary">Dirijirse...</a>
                </div>
            </div>
            
        </div>
    </div>
    </body>
</html>
