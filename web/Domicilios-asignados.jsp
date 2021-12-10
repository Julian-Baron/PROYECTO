<%-- 
    Document   : Domicilios-asignados
    Created on : 17/04/2021, 10:48:05 AM
    Author     : Personal
--%>
<%@page import="Modelos.Mod_misCompras"%>
<%@page import="Constructor.Con_Facturas"%>
<%@page import="javax.swing.JOptionPane"%>
<%@page import="Modelos.Mod_Domicilios"%>
<%@page import="Constructor.Con_Domicilios"%>
<%@page import="java.util.ArrayList"%>
<%
    HttpSession obj=request.getSession();
    String ua=(String) obj.getAttribute("usuario");
    String ced=(String) obj.getAttribute("cedulaa");
    String nom_cli=(String) obj.getAttribute("nombre_cli");
    String rol=(String) obj.getAttribute("rol");
    
    
    
    
    Con_Domicilios con=new Con_Domicilios();
    Con_Domicilios can=new Con_Domicilios(ced, "");
    Mod_Domicilios mod=new Mod_Domicilios();
    
ArrayList<Con_Facturas> dat=new ArrayList <>();
    Con_Facturas conn=new Con_Facturas(0, "", ced);
    Con_Facturas now=new Con_Facturas();
    Mod_misCompras modd=new Mod_misCompras();
    dat=modd.consultarFactura();
    
    
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
                              </ul>
                            </div>
        
            </nav>
       
	</header>
        
        
        <div>
            
            <div class="container-xl" id="container-first">
                <div class="row">
                    <h1>TUS DOMICILIOS ASIGNADOS</h1>
                    <div id="section-tabla">
                        <table class="table table-light table-hover">
                            <thead>
                                <tr>
                                    <th>Cod_domicilio</th>
                                    <th>fecha_pedido</th>
                                    <th>Cedula</th>
                                    <th>Id_factura</th>
                                    <th>Acciones</th>
                                </tr>
                            </thead>
                            <%
                                ArrayList<Con_Domicilios> data=new ArrayList<>();   
                                data=mod.Consultar_DomiciliosAsignados(can);
                                for (int i = 0; i < data.size(); i++) {
                                    con=data.get(i);
                                                                
                            %>    
                            <tbody>
                                
                                <tr>
                                    <td><%=con.getCod_domicilio()%></td>
                                    <td><%=con.getFechaPedido()%></td>
                                    <td><%=con.getId_compra()%></td>
                                    <td><%=con.getCedula()%></td>
                                    <td><a class="btn" href="DetallesdeVentaFacturaEmpleado.jsp?id=<%=con.getCedula()%>">Ver detalles de compra    <svg xmlns="http://www.w3.org/2000/svg" width="20" height="16" fill="currentColor" class="bi bi-eye" viewBox="0 0 16 16">
                                              <path d="M16 8s-3-5.5-8-5.5S0 8 0 8s3 5.5 8 5.5S16 8 16 8zM1.173 8a13.133 13.133 0 0 1 1.66-2.043C4.12 4.668 5.88 3.5 8 3.5c2.12 0 3.879 1.168 5.168 2.457A13.133 13.133 0 0 1 14.828 8c-.058.087-.122.183-.195.288-.335.48-.83 1.12-1.465 1.755C11.879 11.332 10.119 12.5 8 12.5c-2.12 0-3.879-1.168-5.168-2.457A13.134 13.134 0 0 1 1.172 8z"/>
                                              <path d="M8 5.5a2.5 2.5 0 1 0 0 5 2.5 2.5 0 0 0 0-5zM4.5 8a3.5 3.5 0 1 1 7 0 3.5 3.5 0 0 1-7 0z"/>
                                            </svg></a></td>
                                </tr>
                            </tbody>
                            <%
                                    
                                    }
                            
                            %>
                        </table>
                    </div>
                </div>
            </div>
            
        </div>
        
        
        
    </body>
</html>
