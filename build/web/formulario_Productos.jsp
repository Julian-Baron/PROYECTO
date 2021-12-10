<%-- 
    Document   : formulario_Productos
    Created on : 16/02/2021, 07:11:30 PM
    Author     : Trabajos
--%>
<%
    HttpSession obj=request.getSession();
    String ua=(String) obj.getAttribute("usuario");
    String ced=(String) obj.getAttribute("cedula");
    String nom_cli=(String) obj.getAttribute("nombre_cli");
%>
<%@page import="javax.swing.JOptionPane"%>
<%@page import="Modelos.Modelo_Productos"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Constructor.Con_productos"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
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
                              <li class="nav-item dropdown">
                              <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                  Formularios
                              </a>
                              <ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                                <li><a class="dropdown-item nav-link" href="Formulario_usuarios.jsp">Formularios Usuarios</a></li>
                                <li><a class="dropdown-item nav-link" href="Formulario_FActuras.jsp">Formularios Facturas</a></li>
                                <li><a class="dropdown-item nav-link" href="Formulario_Comprador.jsp">Formularios Compras</a></li>
                              </ul>
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
       
    <!-- Contenedor formulario-->
       <div class="container "id="container-first">
            <h1>Formulario para la Gestion de Productos</h1>
            <div class="row">
                <div id="section">
                <form action="Sv_productos" method="Post" name="formDatosPersonales" enctype="multipart/form-data">
                    
                <div class="mb-3">
                    <label  class="form-label">Codigo de producto</label>
                    <input type="text" name="Codigo_pro" class="form-control"  aria-describedby="emailHelp">
                    <div  class="form-text"></div>
                </div>
                    
                <!--<label for="nombre">Cod_producto</label>
                <input type="text" name="Codigo_pro" id="nombre" placeholder="Nombre del producto"/>
                -->
                <div class="mb-3">
                    <label  class="form-label">Nombre</label>
                    <input type="text" name="nombre" class="form-control"  aria-describedby="emailHelp">
                    <div  class="form-text"></div>
                </div>
                
                <!--<label for="nombre">Nombre</label>
                <input type="text" name="nombre" id="nombre" placeholder="Nombre del producto"/>
                -->
                <div class="mb-3">
                    <label  class="form-label">Marca del producto</label>
                    <input type="text" name="Marca" class="form-control"  aria-describedby="emailHelp">
                    <div  class="form-text"></div>
                </div>
                
                <!--<label for="apellidos">Marca del Producto</label>
                <input type="text" name="Marca" id="apellidos" placeholder="Marca del producto"/>
                -->
                <div class="mb-3">
                    <label  class="form-label">Cantidad disponible</label>
                    <input type="text" name="Precio" class="form-control"  aria-describedby="emailHelp">
                    <div class="form-text"></div>
                </div>
                <!--
                <label for="email" />Cantidad disponible</label>
                <input type="text" name="Cantidad" id="email" placeholder="disponible" required />
                -->
                <div class="mb-3">
                    <label  class="form-label">Precio del producto</label>
                    <input type="number" name="Cantidad" class="form-control"  aria-describedby="emailHelp">
                    <div  class="form-text"></div>
                </div>
                <!--
                <label for="Precio_pro">Precio del producto</label>
                <input type ="text" name="Precio" id="asunto" placeholder="Precio pro"/>
                -->
                <div class="mb-3">
                    <label  class="form-label">Descripcion del producto</label>
                    <input type="text" name="Descripcion" class="form-control"  aria-describedby="emailHelp">
                    <div  class="form-text"></div>
                </div>
                
                <div class="form-group mb-3">
                    <label  class="form-label">Seleccionar la imagen del producto</label> 
                    <input type="file" name="imga" class="form-control " id="exampleFormControlFile1">
                </div>
                <!--
                <label for="asunto">Descripcion del producto</label>
                <input type ="text" name="Descripcion" id="asunto" placeholder="Descripcion"/>

                <input type="submit" name="enviar" value="enviar datos"/>
                <input type="submit" name="modificar" value="enviar datos"/>
                <input type="submit" name="eliminar" value="enviar datos"/>-->
                <input type="submit" name="eliminar" class="btn btn-primary" value="Eliminar">
                <input type="submit" name="modificar" class="btn btn-secondary" value="Modificar">    
                <input type="submit" name="enviar" class="btn btn-warning" value="Insertar">
                </form>
            
            
            <div id="section-tabla">
                
                <table class="table table-success table-striped table-light">

                   <thead>
                     <tr>

                         <th>Codigo_Producto</th>
                         <th>Nombre</th>
                         <th>Marca del producto</th>
                         <th>Cantidad disponible</th>
                         <th>Precio</th>
                         <th>Descripcion</th>
                         <th>Imagen</th>
                     </tr>     
                 </thead>
                    <%
         
                        ArrayList<Con_productos> datosu=new ArrayList<>();
                        
                        Modelos.Modelo_Productos mu=new Modelo_Productos();
                        datosu=mu.consultarusuarios();
                        Con_productos  u=new Con_productos();
                        
                        for(int i=0; i<datosu.size(); i++){

                        u=datosu.get(i);


                    %>
                    <tbody>

                                <tr>
                                    <td><%=u.getCod_pro()%></td>
                                    <td><%=u.getNombre_pro()%></td>
                                    <td><%=u.getMarca()%></td>
                                    <td><%=u.getDisponibles()%></td>
                                    <td><%=u.getPrecio()%></td>
                                    <td><%=u.getDescripcion()%></td>
                                    <td><img src="<%=u.getImg()%>" width="50px"height="50px"></td>
                                </tr>
                             </tbody>
                             <%
                                 }
                                 %>
                </table>
                
                
            </div>
        </div>
        </div>
        
    </body>
</html>
