<%-- 
    Document   : Carrito
    Created on : 23/03/2021, 01:03:13 PM
    Author     : Personal
--%>

<%@page import="javax.swing.JOptionPane"%>
<%@page import="Constructor.Con_productos"%>
<%@page import="controllers.ControladorProducto"%>
<%@page import="Constructor.Articulo"%>
<%@page import="Constructor.Con_carrito"%>
<%@page import="java.util.ArrayList"%>
<%
    HttpSession sesion = request.getSession(true);
    String ua = (String) sesion.getAttribute("usuario");
    String ced = (String) sesion.getAttribute("cedula");
    String nom_cli = (String) sesion.getAttribute("nombre_cli");
    String rol = (String) sesion.getAttribute("rol");
%>            
<%
    String as = sesion.getId();
    ArrayList<Articulo> articulos = sesion.getAttribute("carrito") == null ? null : (ArrayList) sesion.getAttribute("carrito");

    if (ua == null) {
        response.sendRedirect("login.jsp");
    }
%>
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
        <link rel="stylesheet" href="css/Style_index.css">
        <link rel="preconnect" href="https://fonts.gstatic.com">

        <link href="https://fonts.googleapis.com/css2?family=Orbitron:wght@500&display=swap" rel="stylesheet">



        <!--ICONO-->
        <link rel="icon" href="img/alianza_1.png">


        <!--CSS-->
        <link rel="stylesheet" href="css/fonts.css">

        <title>Productos</title>
    </head>
    <body>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>
        <script src="js/jquery-3.6.0.min.js"></script>
        <script src="js/Carr.js"></script>
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
                            </li> <li class="nav-item">
                                <a class="nav-link fas fa-cart-plus"  aria-current="page" href="Productos_td.jsp">Seguir comprando<label></label></a>
                            </li>

                            <li class="nav-item">
                                <a class="nav-link " href="Carrito.jsp">Ver carrito</a>
                            </li>                          
                            <%
                                if (ua == null) {%>
                            <li class="nav-item">
                                <a class="nav-link" href="login.jsp">Iniciar Sesion</a>
                            </li>
                            <%}
                                if (rol != null && rol.equalsIgnoreCase("empleado")) {%>
                            <div class="collapse navbar-collapse" id="navbarNavDropdown">
                                <ul class="navbar-nav">
                                    <li class="nav-item dropdown">
                                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-file-earmark-medical" viewBox="0 0 16 16">
                                            <path d="M7.5 5.5a.5.5 0 0 0-1 0v.634l-.549-.317a.5.5 0 1 0-.5.866L6 7l-.549.317a.5.5 0 1 0 .5.866l.549-.317V8.5a.5.5 0 1 0 1 0v-.634l.549.317a.5.5 0 1 0 .5-.866L8 7l.549-.317a.5.5 0 1 0-.5-.866l-.549.317V5.5zm-2 4.5a.5.5 0 0 0 0 1h5a.5.5 0 0 0 0-1h-5zm0 2a.5.5 0 0 0 0 1h5a.5.5 0 0 0 0-1h-5z"/>
                                            <path d="M14 14V4.5L9.5 0H4a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h8a2 2 0 0 0 2-2zM9.5 3A1.5 1.5 0 0 0 11 4.5h2V14a1 1 0 0 1-1 1H4a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1h5.5v2z"/>
                                            </svg>Formularios
                                        </a>
                                        <ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                                            <li><a class="dropdown-item nav-link" href="Formularios de gestion.jsp">Formularios de Gestion</a></li>
                                        </ul>
                                    </li>                                               
                                    <li class="nav-item">
                                        <a class="nav-link active" aria-current="page" href="Formulario_Comprador.jsp"></a>
                                    </li>

                                </ul>
                            </div>
                    </div>
                    <%}
                                if (ua != null) {%>
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
                                    <li><a class="dropdown-item nav-link" href="datos_actualizar.jsp">Actualizar datos</a></li>
                                    <li><a class="dropdown-item nav-link" href="Mis_compras.jsp">Ver compras generadas</a></li>
                                    <li><form action="cerrar_sesion" method="post"><button name="terminar" class="btn btn-primary">Cerrar sesion</button></form></li>
                                </ul>
                            </li>                                               
                            <li class="nav-item">
                                <a class="nav-link active" aria-current="page" href="Formulario_Comprador.jsp"></a>
                            </li>

                        </ul>
                    </div>
                    <%}
                    %>


                    </ul>
                </div>
                </div>

            </nav>

        </header>

        <section>
            <div class="container mt-4" style="color: #2f3640">
                <div class="fs-2" style="margin-top:250px; " >Compras generadas</div>
                <div class="row">
                    <div class="col-xl-8">
                        <table border="1" class="table table-hover table-light table table-striped" style=background:#ff9933" id="shop-table" >
                            <thead>

                                <tr>                
                                    <th>Nombre</th>
                                    <th>Descripcion</th>
                                    <th>Precio</th>
                                    <th>Cantidad</th>
                                    <th>Total</th>
                                </tr>

                            </thead>
                            <tbody>
                                <%
                                    controllers.ControladorProducto cp = new ControladorProducto();
                                    double total = 0;
                                    if (articulos != null) {
                                        for (Articulo a : articulos) {
                                            Con_productos producto = cp.getproducto(a.getIdProducto());
                                            total += a.getCantidad() * producto.getPrecio();

                                %>

                                <tr>
                                    <td><%=producto.getNombre_pro()%></td>
                                    <td><%=producto.getDescripcion()%></td>
                                    <td>$ <%=producto.getPrecio()%></td>
                                    <td><%=a.getCantidad()%></td>
                                    <td>$ <%=Math.round(producto.getPrecio() * a.getCantidad() * 100.0 / 100.0)%></td>
                                    <td>
                                        <span id="idarticulo" style="display:none;"><%=producto.getCod_pro()%></span>
                                        <a class="" id="deleteitem"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash-fill" viewBox="0 0 16 16">
                                            <path d="M2.5 1a1 1 0 0 0-1 1v1a1 1 0 0 0 1 1H3v9a2 2 0 0 0 2 2h6a2 2 0 0 0 2-2V4h.5a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1H10a1 1 0 0 0-1-1H7a1 1 0 0 0-1 1H2.5zm3 4a.5.5 0 0 1 .5.5v7a.5.5 0 0 1-1 0v-7a.5.5 0 0 1 .5-.5zM8 5a.5.5 0 0 1 .5.5v7a.5.5 0 0 1-1 0v-7A.5.5 0 0 1 8 5zm3 .5v7a.5.5 0 0 1-1 0v-7a.5.5 0 0 1 1 0z"/>
                                            </svg></i></a>
                                    </td>
                                </tr>
                                <%
                                        }
                                    }


                                %>
                            </tbody>
                        </table>
                        <% if (articulos == null) {%>
                        <span>No hay articulos en el carro</span>
                        <%}%>
                    </div>


                    <div class="col-sm-4" style="background: #ffff00">
                        <div class="card mt-2" style="background:#ffcc33" >
                            <div class="card-header">
                                <div class="fs-2" >Compras generadas</div>
                            </div>
                        </div>
                        <div class="card-body" style="color: #2f3640">
                            <label>Subtotal:</label>
                            <span type="text" id="txt-subtotal" readonly="" class="form-control"><%=Math.round(total * 100.0 / 100.0)%></span>
                            <label>Total Pagar:</label>
                            <span type="text" id="txt-total" readonly="" class="form-control"><%=Math.round(total * 100.0 / 100.0)%></span>
                        </div>
                        <form action="generar_compra" method="POST" name="Generar">
                            <input hidden="" value="<%=as%>" name="token">
                            <input hidden="" value="<%=Math.round(total * 100.0 / 100.0)%>" name="total">
                            <div class="card-footer" style="">
                                <button class="btn btn-info btn-block" name="compra" style="background:#ffcc33">Generar compra</button>                    
                            </div>
                        </form>
                    </div>

                </div>
                <a href="javascript:window.history.go(-2)">Seguir Comprando</a> 

            </div>

        </section>


    </body>
</html>
