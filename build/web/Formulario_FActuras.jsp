<%-- 
    Document   : Formulario_FActuras
    Created on : 16/02/2021, 11:00:39 PM
    Author     : Trabajos
--%>
<%
    HttpSession obj=request.getSession();
    String ua=(String) obj.getAttribute("usuario");
    String ced=(String) obj.getAttribute("cedula");
    String nom_cli=(String) obj.getAttribute("nombre_cli");
%>
<%@page import="Modelos.Mod_Facturas"%>
<%@page import="Constructor.Con_Facturas"%>
<%@page import="java.util.ArrayList"%>
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
       
    <!-- Contenedor formulario-->
    <div class="container  mt-0" id="container-first"style="color: #333333">
            <h1>Formulario para la Gestion de facturas</h1>
            <div class="row">
                <div id="section" >
                    <form action="Formulario_FActuras.jsp" method="Post" name="formDatosPersonales">

                        <div class="mb-4">
                            <label  class="form-label">Consultar Factura por numero de factura</label>
                            <input type="number" name="Codigo Factura" class="form-control"  aria-describedby="emailHelp">
                            <div  class="form-text"></div>
                            <input type="submit" name="FacturaEn" class="btn btn-primary" value="Ingresar">
                        </div>
                        

                        <div class="mb-4">
                            <label  class="form-label">Consultar Factura por cedula del cliente</label>
                            <input type="text" name="Codigo_pro" class="form-control"  aria-describedby="emailHelp">
                            <div  class="form-text"></div>
                            <input type="submit" name="PorCedula" class="btn btn-primary" value="Ingresar">
                        </div>

                        

                        <div class="mb-4">
                            <label  class="form-label">Consultar Factura  por fecha de accion</label>
                            <input type="date" name="Cantidad re" class="form-control"  aria-describedby="emailHelp">
                            <div  class="form-text"></div>
                            <input type="submit" name="PorFecha" class="btn btn-primary" value="Ingresar">
                        </div>

                        <!--
                        <div class="mb-3">
                        <label for="exampleInputEmail1" class="form-label">Id_compra</label>
                        <input type="text" name="Cedula" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
                        <div id="emailHelp" class="form-text"></div>
                        </div>

                        <div class="col-auto">

                        
                        </br>
                        <div class="mb-3">
                        <label for="exampleInputEmail1" class="form-label">Cod_domicilio</label>
                        <input type="text" name="Cedula" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
                        <div id="emailHelp" class="form-text"></div>
                        </div>

                        <div class="col-auto">
                                              
                        -->
                        

                        
                        <!--<button type="submit" class="btn btn-primary">Modificar</button>
                        <button type="submit" class="btn btn-primary">Eliminar</button>-->

                        <!--<input type="submit" name="enviar" value="enviar datos"/>
                        <input type="submit" name="modificar" value="Modificar datos"/>
                        <input type="submit" name="eliminar" value="eliminar datos"/>-->
                        <!--<input type="submit" name="eliminar" class="btn btn-primary" value="Eliminar">
                        <input type="submit" name="modificar" class="btn btn-secondary" value="Modificar">    
                        <input type="submit" name="enviar" class="btn btn-warning" value="Insertar">-->
                    </form>
                    
                    
                    <div id="section-tabla">
                        <table class="table table-success table-striped table-light">
                           <thead>
                             <tr>
                                 <th>Id_factura</th>
                                 <th>Fecha_fac</th>
                                 <th>Cedula</th>
                                 <th>Id_compra</th>
                                 <th>status</th>
                                 <th>tpken</th>
                                 
                             </tr>     
                         </thead>
                            <%

                                ArrayList<Con_Facturas> datosu=new ArrayList<>();

                                Modelos.Mod_Facturas mu=new Mod_Facturas();
                                datosu=mu.consultar_factura();
                                Con_Facturas  u=new Con_Facturas();

                                for(int i=0; i<datosu.size(); i++){

                                u=datosu.get(i);


                            %>
                            <tbody>
                            <form method="post" action="Sv_pdf">
                                        <tr>
                                            <td><%=u.getId_factura()%></td>
                                            <td><%=u.getFecha_fac()%></td>
                                            <td><%=u.getStatus()%></td>
                                            <td><%=u.getTotal()%></td>
                                            <td><%=u.getCedula()%></td>
                                            <td><input name="token" value="<%=u.getToken()%>" hidden=""></td>
                                            <td><input type="submit" name="btnpdf" class="btn btn-primary" value="Generar Factura"></td>
                                            <td><input type="submit" name="eliminar" class="btn btn-warning" value="Eliminar Factura"></td>
                                        </tr>
                            </form>
                                     </tbody>
                                     <%
                                         }
                                         %>
                        </table>
                        

                    </div>
                </div>        
            </div>
        <section>
            <br>
            <br>
            <br>
            <h1 class="" style="color: #333333">Tabla Generada por consultas</h1>
        <table class="table">
            <thead>
                <tr>
                    <th>id_factura</th>
                    <th>Fecha_Fac</th>
                    <th>status</th>
                    <th>token</th>
                    <th>total</th>
                    <th>Cedula</th>
                </tr>
            </thead>
                            
            <%
                if(request.getParameter("FacturaEn")!=null) {
                int a;
                a=Integer.parseInt(request.getParameter("Codigo Factura"));
                ArrayList<Con_Facturas> data=new ArrayList<>();
                String b=null,c=null;
                
                
                Con_Facturas con=new Con_Facturas("", a);
                Modelos.Mod_Facturas md=new Mod_Facturas();
                Con_Facturas cu=new Con_Facturas();
                
                data=md.consultar_facturaXnumeroFac(con);
                                                 
                
                for (int i = 0; i <data.size(); i++) {
                        cu=data.get(i);
                       
                    
                            
                        
                    %>   
                    <tbody>
                        <tr>
                            <td><%=cu.getId_factura()%></td>
                            <td><%=cu.getFecha_fac()%></td>
                            <td><%=cu.getStatus()%></td>
                            <td><%=cu.getToken()%></td>
                            <td><%=cu.getTotal()%></td>
                            <td><%=cu.getCedula()%></td>
                        </tr>
                    </tbody>
                    <%
                        
                    }
                    response.sendRedirect("Formulario_FActuras.jsp");
                }
                    
                    
            
                else if(request.getParameter("PorCedula")!=null) {
                String c;int a=0;
                c=request.getParameter("Cedula");
                ArrayList<Con_Facturas> data=new ArrayList<>();
                String b=null;
                
                
                Con_Facturas con=new Con_Facturas(0, "", c);
                Modelos.Mod_Facturas md=new Mod_Facturas();
                Con_Facturas cu=new Con_Facturas();
                
                data=md.consultar_facturaXCedula(con);
                
                for (int i = 0; i <data.size(); i++) {
                        cu=data.get(i);
                       
                    
                            
                        
                    %>   
                    <tbody>
                        <tr>
                            <td><%=cu.getId_factura()%></td>
                            <td><%=cu.getFecha_fac()%></td>
                            <td><%=cu.getStatus()%></td>
                            <td><%=cu.getToken()%></td>
                            <td><%=cu.getTotal()%></td>
                            <td><%=cu.getCedula()%></td>
                        </tr>
                    </tbody>
                    <%
                        
                    }
                }
                else if(request.getParameter("PorFecha")!=null) {
                String b;int a=0;
                b=request.getParameter("Fecha");
                ArrayList<Con_Facturas> data=new ArrayList<>();
                String c=null;
                
                
                Con_Facturas con=new Con_Facturas(0, b,"");
                Modelos.Mod_Facturas md=new Mod_Facturas();
                Con_Facturas cu=new Con_Facturas();
                
                data=md.consultar_facturaXfechaFac(con);
                
                for (int i = 0; i <data.size(); i++) {
                        cu=data.get(i);
                       
                    
                            
                        
                    %>   
                    <tbody>
                        <tr>
                            <td><%=cu.getId_factura()%></td>
                            <td><%=cu.getFecha_fac()%></td>
                            <td><%=cu.getStatus()%></td>
                            <td><%=cu.getToken()%></td>
                            <td><%=cu.getTotal()%></td>
                            <td><%=cu.getCedula()%></td>
                        </tr>
                    </tbody>
                    <%
                        
                    }
                }
                    %>
                
                
                
               
                
               
        </table>
        
    </section>                
    </div>

<!--<form action="" target="" method="get" name="formDatosPersonales">

	<label for="nombre">Consultar Factura por numero de factura</label>
	<input type="number" name="Codigo Factura" id="nombre" placeholder="id"/>
        <input type="submit" name="FacturaEn" value="enviar datos"/>
        
        
	<label for="apellidos">Consultar Factura por cedula del cliente</label>
	<input type="text" name="Cedula" id="apellidos" placeholder="codigo"/>
        <input type="submit" name="PorCedula" value="enviar datos"/>
        
	<label for="email" />Consultar factura por fecha de accion</label>
	<input type="text" name="Fecha" id="email" placeholder="disponible"/>
        <input type="submit" name="PorFecha" value="enviar datos"/>

	
</form>-->
    
    
    
    
</body>
</html>
