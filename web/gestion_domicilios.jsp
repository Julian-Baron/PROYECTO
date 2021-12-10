<%-- 
    Document   : Mis_compras
    Created on : 6/04/2021, 08:00:57 PM
    Author     : Personal
--%>
<%@page import="javax.swing.JOptionPane"%>
<%@page import="Modelos.Mod_misCompras"%>
<%@page import="Constructor.Con_Facturas"%>
<%@page import="java.util.ArrayList"%>
<%
    HttpSession obj=request.getSession();
     
    String ua=(String) obj.getAttribute("usuario");
    String ced=(String) obj.getAttribute("cedulaa");
    String nom_cli=(String) obj.getAttribute("nombre_cli");
    String rol=(String) obj.getAttribute("rol");

    if(ua==null){
        response.sendRedirect("login.jsp");
    }
    
    ArrayList<Con_Facturas> dat=new ArrayList <>();
    Con_Facturas con=new Con_Facturas(0, "", ced);
    Con_Facturas now=new Con_Facturas();
    Mod_misCompras mod=new Mod_misCompras();
    dat=mod.consultarFactura();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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

        <!--Font-->

        <link rel="preconnect" href="https://fonts.gstatic.com">

        <link href="https://fonts.googleapis.com/css2?family=Orbitron:wght@500&display=swap" rel="stylesheet">



        <!--CSS-->
        <link rel="stylesheet" href="css/fonts.css">

        <!--ICONO-->
        <link rel="icon" href="img/alianza_1.png">

        <!--PEGAJOSO-->

        <meta http-equiv="X-UA-Compatible" content="IE=edge">

        <title>Gestion Domiciliios</title>
    </head>
    <body>
        <!-- Option 1: Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>
    
       <!-- inicio de la cabecera-->
        <header>
            
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
                <nav class="navbar navbar-expand-lg fixed-top navbar-light bg justify-content-end"  style="background: #DEB916" >
                    <div class="logo">Supermercado la Alianza                       
                        <img src="img/shopping-cart-2020929_640.png " class="" >
                        </div>
                    <div class="container-fluid"> 
                            
                        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
                            <span class="navbar-toggler-icon"></span>
                          </button>
                        <div class="collapse navbar-collapse" id="navbarNavDropdown">
                            
                          <ul class="navbar-nav nav justify-content-end">
                              <li class="nav-item">
                               
                              <a class="nav-link active" aria-current="page" href="index.jsp"><svg xmlns="http://www.w3.org/2000/svg" width="29" height="29" fill="currentColor" class="bi bi-house-door" viewBox="0 0 16 16">
                                  <path d="M8.354 1.146a.5.5 0 0 0-.708 0l-6 6A.5.5 0 0 0 1.5 7.5v7a.5.5 0 0 0 .5.5h4.5a.5.5 0 0 0 .5-.5v-4h2v4a.5.5 0 0 0 .5.5H14a.5.5 0 0 0 .5-.5v-7a.5.5 0 0 0-.146-.354L13 5.793V2.5a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5v1.293L8.354 1.146zM2.5 14V7.707l5.5-5.5 5.5 5.5V14H10v-4a.5.5 0 0 0-.5-.5h-3a.5.5 0 0 0-.5.5v4H2.5z"/>
                                </svg> Inicio</a>
                            </li>
                            <li class="nav-item">
                              <a class="nav-link active" aria-current="page" href="Productos_td.jsp"><svg xmlns="http://www.w3.org/2000/svg" width="29" height="29" fill="currentColor" class="bi bi-bag" viewBox="0 0 16 16">
                                    <path d="M8 1a2.5 2.5 0 0 1 2.5 2.5V4h-5v-.5A2.5 2.5 0 0 1 8 1zm3.5 3v-.5a3.5 3.5 0 1 0-7 0V4H1v10a2 2 0 0 0 2 2h10a2 2 0 0 0 2-2V4h-3.5zM2 5h12v9a1 1 0 0 1-1 1H3a1 1 0 0 1-1-1V5z"/>
                                </svg> Productos</a>
                            </li>
                       <% 
                               if(ua==null){%>
                                <li class="nav-item">
                                    <a class="nav-link" href="login.jsp">
                                        <svg xmlns="http://www.w3.org/2000/svg" width="30   " height="30" fill="currentColor" class="bi bi-person-square" viewBox="0 0 16 16">
                                      <path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z"/>
                                      <path d="M2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2zm12 1a1 1 0 0 1 1 1v12a1 1 0 0 1-1 1v-1c0-1-1-4-6-4s-6 3-6 4v1a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1h12z"/>
                                    </svg>Iniciar Sesion</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="login.jsp">
                                        <svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" fill="currentColor" class="bi bi-person-plus" viewBox="0 0 16 16">
                                          <path d="M6 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6zm2-3a2 2 0 1 1-4 0 2 2 0 0 1 4 0zm4 8c0 1-1 1-1 1H1s-1 0-1-1 1-4 6-4 6 3 6 4zm-1-.004c-.001-.246-.154-.986-.832-1.664C9.516 10.68 8.289 10 6 10c-2.29 0-3.516.68-4.168 1.332-.678.678-.83 1.418-.832 1.664h10z"/>
                                          <path fill-rule="evenodd" d="M13.5 5a.5.5 0 0 1 .5.5V7h1.5a.5.5 0 0 1 0 1H14v1.5a.5.5 0 0 1-1 0V8h-1.5a.5.5 0 0 1 0-1H13V5.5a.5.5 0 0 1 .5-.5z"/>
                                        </svg>Registrar usuario</a>
                                </li>
                            <%}
                            if(rol!=null&&rol.equalsIgnoreCase("empleado")){%>
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
                            <%}
                            if(ua!=null)
                            {%>
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
  
                                        <li><form action="cerrar_sesion" method="post"><input type="submit" name="terminar">Cerrar sesion</button></form></li>
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
        
            </nav>
       
	</header>
        
        <div class="container-xl" id="container-first">
            <div class="row">
                <div id="section-tabla">
                    <table class="table table-primary table-hover">
                       <thead>
                            <tr>
                                <th>Id_factura</th>
                                <th>Fecha_fac</th>
                                <th>Cedula</th>
                                <th>status</th>
                                <th>Acciones</th>
                            </tr>     
                        </thead>
                        
                        <tbody>
                            <form method="POST" action="verCompra" name="Detalles ventas">
                               <%
                                    for (int i = 0; i < dat.size(); i++) {
                                       now=dat.get(i);
                                       
                                       String a=now.getStatus();
                                %>
                                <tr>                                                                  
                                            <td><%=now.getId_factura()%></td>
                                            <td><%=now.getFecha_fac()%></td>
                                            <td><%=now.getCedula()%></td>
                                            <td><%=now.getStatus()%></td>
                                           
                                            <td><input type="text" name="token" value="<%=now.getToken()%>" hidden=""></td>
                                            <input type="number" value="<%=now.getId_factura()%>" name="id" hidden="">
                                            <input type="number" value="<%=now.getCedula()%>" name="cedula" hidden="">
                                            
                                            <%
                                            if(!a.equalsIgnoreCase("CANCELADO")){
                                            %>
                                            <td><a class="btn" href="DetallesdeVentaFactura.jsp?token=<%=now.getToken()%>">Ver detalles de compra    <svg xmlns="http://www.w3.org/2000/svg" width="20" height="16" fill="currentColor" class="bi bi-eye" viewBox="0 0 16 16">
                                              <path d="M16 8s-3-5.5-8-5.5S0 8 0 8s3 5.5 8 5.5S16 8 16 8zM1.173 8a13.133 13.133 0 0 1 1.66-2.043C4.12 4.668 5.88 3.5 8 3.5c2.12 0 3.879 1.168 5.168 2.457A13.133 13.133 0 0 1 14.828 8c-.058.087-.122.183-.195.288-.335.48-.83 1.12-1.465 1.755C11.879 11.332 10.119 12.5 8 12.5c-2.12 0-3.879-1.168-5.168-2.457A13.134 13.134 0 0 1 1.172 8z"/>
                                              <path d="M8 5.5a2.5 2.5 0 1 0 0 5 2.5 2.5 0 0 0 0-5zM4.5 8a3.5 3.5 0 1 1 7 0 3.5 3.5 0 0 1-7 0z"/>
                                            </svg></a>
                                            
                                            <a class="btn" href="detalles_clientes.jsp?cedula=<%=now.getCedula()%>">Ver detalles de cliente    
                                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-people" viewBox="0 0 16 16">
                                                  <path d="M15 14s1 0 1-1-1-4-5-4-5 3-5 4 1 1 1 1h8zm-7.978-1A.261.261 0 0 1 7 12.996c.001-.264.167-1.03.76-1.72C8.312 10.629 9.282 10 11 10c1.717 0 2.687.63 3.24 1.276.593.69.758 1.457.76 1.72l-.008.002a.274.274 0 0 1-.014.002H7.022zM11 7a2 2 0 1 0 0-4 2 2 0 0 0 0 4zm3-2a3 3 0 1 1-6 0 3 3 0 0 1 6 0zM6.936 9.28a5.88 5.88 0 0 0-1.23-.247A7.35 7.35 0 0 0 5 9c-4 0-5 3-5 4 0 .667.333 1 1 1h4.216A2.238 2.238 0 0 1 5 13c0-1.01.377-2.042 1.09-2.904.243-.294.526-.569.846-.816zM4.92 10A5.493 5.493 0 0 0 4 13H1c0-.26.164-1.03.76-1.724.545-.636 1.492-1.256 3.16-1.275zM1.5 5.5a3 3 0 1 1 6 0 3 3 0 0 1-6 0zm3-2a2 2 0 1 0 0 4 2 2 0 0 0 0-4z"/>
                                                </svg>
                                                    
                                                </a>
                                            
                                            <button type="submit" class="btn" name="btncan" value="">Cancelar Pedido <svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-x" viewBox="0 0 16 16">
                                              <path d="M4.646 4.646a.5.5 0 0 1 .708 0L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 0 1 0-.708z"/>
                                            </svg></button>
                                            <%
                                                if(a.equalsIgnoreCase("PENDIENTE")){
                                            %>    
                                                <a class="btn" href="verEmpleado.jsp?factura=<%=now.getId_factura()%>">Generar Domicilio <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-check-circle" viewBox="0 0 16 16">
                                                <path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0  0 0 16z"/>
                                                <path d="M10.97 4.97a.235.235 0 0 0-.02.022L7.477 9.417 5.384 7.323a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-1.071-1.05z"/>
                                                </svg></a></td>
                                                <%
                                                }
                                                %>
                                            
                                                
                                            
                                
                                <%}else{%>
                                <td><span>FACTURA CANCELADA</span></td>
                                <td><button type="submit" class="btn" name="btneli" value="">Eliminar Factura <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-check-circle" viewBox="0 0 16 16">
                                                <path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0  0 0 16z"/>
                                                <path d="M10.97 4.97a.235.235 0 0 0-.02.022L7.477 9.417 5.384 7.323a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-1.071-1.05z"/>
                                                </svg></button></td>
                                <%
                                   } 
                                   }
                                %>
                                </tr>
                            </form>
                        </tbody>
                        
                    </table>
                
                    
                
            
                </div>
            </div>
        </div>
                            
                            
    </body>
</html>
