<%-- 
    Document   : Formularios de gestion
    Created on : 7/03/2021, 03:34:17 PM
    Author     : Personal
--%>
<%
    HttpSession obj=request.getSession();
    String ua=(String) obj.getAttribute("usuario");
    String ced=(String) obj.getAttribute("cedula");
    String nom_cli=(String) obj.getAttribute("nombre_cli");
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
  <body>
    

    <!-- Optional JavaScript; choose one of the two! -->

    <!-- Option 1: Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>

    <!-- Option 2: Separate Popper and Bootstrap JS -->
    <!--
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.6.0/dist/umd/popper.min.js" integrity="sha384-KsvD1yqQ1/1+IA7gi3P0tyJcT3vR+NdBTt13hSJ2lnve8agRGXTTyNaBYmCR/Nwi" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.min.js" integrity="sha384-nsg8ua9HAw1y0W1btsyWgBklPnCUAFLuTMS2G72MMONqmOymq585AcH49TLBQObG" crossorigin="anonymous"></script>
    -->
       <!-- inicio de la cabecera-->
       <header id="container-first">        
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
                                <a class="nav-link active" aria-current="page" href="FormulariosdegestiondeAdministrador.jsp">Formularios de Gestion</a>
                            </li>                                             
                            <li class="nav-item">
                              <a class="nav-link active" aria-current="page" href="Formulario_Comprador.jsp"></a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link " href="Formularios de gestion.jsp">Volver</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="login.jsp">Cerrar Sesion</a>
                            </li>
                            
                          </ul>
                        </div>
        
            </nav>
       
	</header>
       
    <div class="container-xl px-4" id="container-first">
        <div class="row text-center align-self-center ">   
            <div class="card" style="width: 20rem; margin: 20px; padding: 0px">
                <img src="img/avatar-2155431_640.png" class="card-img-top" alt="..." style="height: 240px">
                <div class="card-body">
                    <a href="formulario_clientes.jsp" style="text-decoration: none"><h5 class="card-title">Formularios clientes</h5></a>
                  <p class="card-text">Gestion de clientes que se han registradro.</p>
                  <a href="formulario_clientes.jsp" class="btn btn-primary">Dirijirse...</a>
                </div>
            </div>
            <div class="card" style="width: 20rem; margin: 20px; padding: 0px">
                <img src="img/avatar-2155431_640.png" class="card-img-top" alt="..." style="height: 240px">
                <div class="card-body">
                    <a href="formulario_clientes.jsp" style="text-decoration: none"><h5 class="card-title">Formularios Empleados</h5></a>
                  <p class="card-text">Gestion de Empleados que se han registradro.</p>
                  <a href="Formulario_empleados.jsp" class="btn btn-primary">Dirijirse...</a>
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
            <div class="card" style="width: 20rem; margin: 20px;">
                <img src="img/usuarios.png" class="card-img-top" alt="..." >
                <div class="card-body">
                    <a href="Formulario_usuarios.jsp" style="text-decoration: none"><h5 class="card-title">Formularios gestion de Usuarios</h5></a>
                  <p class="card-text">Gestion de usuarios que se han registradro.</p>
                  <a href="Formulario_usuarios.jsp" class="btn btn-primary">Dirijirse...</a>
                </div>
            </div>
            <!--<div class="card" style="width: 18rem; margin: 40px;">
                <img src="..." class="card-img-top" alt="..." >
                <div class="card-body">
                    <a href="" style="text-decoration: none"><h5 class="card-title">Formularios gestion de Usuarios</h5></a>
                  <p class="card-text">Gestion de empleados que se han registradro.</p>
                  <a href="#" class="btn btn-primary">Dirijirse...</a>
                </div>
            </div>-->
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
            
            <div class="card" style="width: 20rem; margin: 20px;">
                <img src="img/supermarket-shelf-1094817_1920.png" class="card-img-top" alt="..." >
                <div class="card-body">
                    <a href="formulario_Productos.jsp" style="text-decoration: none"><h5 class="card-title">Tus Domicilios</h5></a>
                  <p class="card-text">Gestion de Domicilios que se han registradro.</p>
                  <a href="gestion_domicilios.jsp" class="btn btn-primary">Dirijirse...</a>
                </div>
            </div>
        </div>
    </div>
    </body>
</html>
