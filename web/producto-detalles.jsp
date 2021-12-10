<%-- 
    Document   : producto-detalles
    Created on : 23/03/2021, 08:36:22 PM
    Author     : Personal
--%>

<%@page import="javax.swing.JOptionPane"%>
<%@page import="Constructor.Con_productos"%>
<%@page import="controllers.ControladorProducto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
        String id=request.getParameter("id");
        Con_productos producto=new ControladorProducto().getproducto(id);        
%>
<%
    HttpSession obj=request.getSession();
    String ua=(String) obj.getAttribute("usuario");
    String ced=(String) obj.getAttribute("cedula");
    String nom_cli=(String) obj.getAttribute("nombre_cli");
%>
<!DOCTYPE html>
<html>
    <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
    <link rel="stylesheet" href="css/styles_header.css">
    <link rel="stylesheet" href="css/Style_index.css">

    <link rel="stylesheet" href="css/fonts.css">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Orbitron:wght@500&display=swap" rel="stylesheet">

    
    <!--ICONO-->
    <link rel="icon" href="img/alianza_1.png">
    
    <title>Productos</title>
  </head>
    <body font-family="'Arvo', serif;">
        
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>
        
        <header>
		<!-- cabecera de la pagina-->
                <nav class="navbar navbar-expand-lg fixed-top navbar-light bg" style="background: #ffff00">
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

                                <a class="nav-link active" aria-current="page" href="index.jsp">Inicio</a>

                            </li>
                            <li class="nav-item">
                                <a class="nav-link " href="Formularios de gestion.jsp">Volver</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link " href="Carrito.jsp"><img class="bi bi-cart" src="img/cart.svg"></i>Ver carrito</a>
                            </li>
                            <li class="nav-item">

                                <a class="nav-link" href="login.jsp">Cerrar Sesion</a>

                            </li>
                            
                          </ul>
                        </div>
                    
        
            </nav>
       
	</header>
        
       
        <div class="container-xl" id="container-first">
            <div class="row text-center">
                <div class="col-xl-7">
                    <img src="<%=producto.getImg()%>" width="320px">
                </div>

                <div class="col-sm-3">

                    <div class="card" style="color: black">

                        <form action="agregarproducto" method="post">
                            <div class="card-header"><%=producto.getNombre_pro()%></div>
                            <div class="card-body"><b>Precio</b>  $<%=producto.getPrecio()%>.00</div>
                            <div class="card-body"><label><b>Descripcion  :</b></label></div>
                            <div class="card-body"><label><%=producto.getDescripcion()%></label></div>
                            <input type="text" value="<%=producto.getCod_pro()%>" name="id" hidden="">
                            <div class="card-footer"><label>Cantidad <input type="number" value="1" id="" class="fw-bold text-center" name="cantidad"></label></div>
                            <button class="btn btn-warning  m-2">Añadir a carrito</button>
                        </form>          
                    </div>
                </div>     
                
        </div>
        
    </body>
</html>
