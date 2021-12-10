<%-- 
    Document   : DetallesdeVentaFactura
    Created on : 11/04/2021, 05:36:11 PM
    Author     : Personal
--%>

<%@page import="Modelos.Mod_Facturas"%>
<%@page import="javax.swing.JOptionPane"%>
<%@page import="Constructor.Con_compraDetalles"%>
<%@page import="Modelos.Mod_misCompras"%>
<%@page import="Constructor.Con_Facturas"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    HttpSession obj=request.getSession();
    
    
    String ua=(String) obj.getAttribute("usuario");
    String ced=(String) obj.getAttribute("cedulaa");
    String nom_cli=(String) obj.getAttribute("nombre_cli");
    String rol=(String) obj.getAttribute("rol");
    int id=Integer.parseInt(request.getParameter("id"));
    
    
    
    if(ua==null){
        response.sendRedirect("index.jsp");
    }
        ArrayList<Con_Facturas> da=new ArrayList<>();
        Con_Facturas flag=new Con_Facturas("", id);
        Con_Facturas flog=new Con_Facturas();
        Mod_Facturas mid=new Mod_Facturas();
        da=mid.consultar_facturaToken(flag);
        
        String help="";
               
        for (int i = 0; i < da.size(); i++) {
                flog=da.get(i);
                
                help=flog.getToken();
                
            }       
        ArrayList<Con_compraDetalles> dat=new ArrayList (); 
        String token;   
        token=request.getParameter("token");
        Con_compraDetalles a=new Con_compraDetalles();
        Con_compraDetalles con=new Con_compraDetalles(0, help);
        Mod_misCompras now=new Mod_misCompras();
        dat=now.consultarCompra(con);
        
%>
<%
    
    

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

        <!--Font-->

        <link rel="preconnect" href="https://fonts.gstatic.com">

        <link href="https://fonts.googleapis.com/css2?family=Orbitron:wght@500&display=swap" rel="stylesheet">



        <!--CSS-->
        <link rel="stylesheet" href="css/fonts.css">

        <!--ICONO-->
        <link rel="icon" href="img/alianza_1.png">

        <!--PEGAJOSO-->

        <meta http-equiv="X-UA-Compatible" content="IE=edge">


        <title>DetalleVentaFactura</title>
    </head>
    <body>
        
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
                <nav class="navbar navbar-expand-lg fixed-top navbar-light bg" style="background: #DEB916" >
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
                                        </svg> Registrar usuario</a>
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
                                         <li><a class="dropdown-item nav-link" href="datos_actualizar.jsp">Actualizar datos</a></li>
                                            <li><a class="dropdown-item nav-link" href="compras_generadas.jsp">Ver compras generadas</a></li>
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
        
        
        
        <div class="container-xxl" id="container-first">
            <div class="row">
                <table class="table table-hover table-dark">
                    <thead>
                        <tr>
                            <th>Nombre</th>
                            <th>Cantidad</th>
                            <th>Subtotal</th>
                            <th>Total</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            
                            
                        for (int i = 0; i < dat.size(); i++) {
                                a=dat.get(i);
                                %>
                                <tr>
                                    <td><%=a.getNombre()%></td>
                                    <td><%=a.getCantidad()%></td>
                                    <td><%=a.getSubtotal()%></td>
                                    <td><%=a.getTotal()%></td>
                                </tr>
                                <%
                            }
                        %>
                            
                        
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>
