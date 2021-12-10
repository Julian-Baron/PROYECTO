<%-- 
    Document   : detalles_clientes
    Created on : 11/04/2021, 11:00:45 PM
    Author     : Personal
--%>

<%@page import="javax.swing.JOptionPane"%>
<%@page import="Modelos.Mod_Clientes"%>
<%@page import="Constructor.Con_clientes"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession obj=request.getSession();
    
                        
    String ua=(String) obj.getAttribute("usuario");
    String ced=(String) obj.getAttribute("cedulaa");
    String nom_cli=(String) obj.getAttribute("nombre_cli");
    String rol=(String) obj.getAttribute("rol");
    
    
    
    if(ua==null){
        response.sendRedirect("index.jsp");
    }
    
        ArrayList<Con_clientes> dat=new ArrayList<>(); 
        String cedula;   
        cedula=request.getParameter("cedula");
        Con_clientes a=new Con_clientes();
        Con_clientes con=new Con_clientes(cedula);
        Mod_Clientes now=new Mod_Clientes();
        dat=now.consultar_clientesCed(con);
        

        
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
    <body class="justify-content-center" style="display: flex;" id="container-first">
        <div class="">
            <div class="row">
                <div class="card mb-4 card text-center" style="max-width: 600px;">
                  <div class="row">
                    <div class="col-md-4">
                        <img src="img/usuarios.png" width="200px" alt="imagen">
                    </div>
                    <div class="col-md-8">
                      <div class="card-body">
                          <%
                              for (int i = 0; i < dat.size(); i++) {
                                  a=dat.get(i); 
                       %><p class="card-title">Nombre del cliente</p>
                            <p class="card-text"><%=a.getNombre()%>  <%=a.getApellido()%> </p>
                          <p class="card-title">Cedula</p>
                          <p class="card-text"><%=a.getCedula()%></p>
                          <p class="card-title">Telefono</p>
                          <p class="card-text"><%=a.getTelefono()%></p>
                          <p class="card-title">Direccion</p>
                          <p class="card-text"><small class="text-muted"><%=a.getDireccion()%></small></p>
                          <p class="card-text"><small class="text-muted"><%=a.getCorreo()%></small></p>
                          <%
}%>     
                      </div>
                    </div>
                  </div>
                </div>
            </div>
                      
          <div class="col">
              <a href="javascript:window.history.go(-1)" class="form-control">Volver</a> 
          </div>
      
        </div>
      
    </body>
</html>
