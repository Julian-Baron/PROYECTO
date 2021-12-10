<%-- 
    Document   : verEmpleado
    Created on : 12/04/2021, 07:05:13 AM
    Author     : Personal
--%>

<%@page import="javax.swing.JOptionPane"%>
<%@page import="Modelos.Mod_empleados"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Constructor.Con_empleados"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession obj=request.getSession();
     
    String ua=(String) obj.getAttribute("usuario");
    String ced=(String) obj.getAttribute("cedulaa");
    String nom_cli=(String) obj.getAttribute("nombre_cli");
    String rol=(String) obj.getAttribute("rol");

    if(ua==null){
        response.sendRedirect("login.jsp");
    }
    String empleado=request.getParameter("empleado");
    
    int factura=Integer.parseInt(request.getParameter("factura"));
    
    JOptionPane.showMessageDialog(null, factura);
    ArrayList<Con_empleados> dat=new ArrayList <>();
    Con_empleados con=new Con_empleados(empleado);
    Con_empleados now=new Con_empleados();
    Mod_empleados mod=new Mod_empleados();
    dat=mod.consultar_empleados();
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

        <title>Gestion Domiciliios</title>
    </head>
    <body class="justify-content-center " style="display: flex;" id="container-first">
        <div class="" style="background: #ffffff;color: #262626;padding: 15px;border-radius: 15px">
                <div class="row">    
                    <div class="col"> <h1>Seleccione el empleado</h1></div>
                    <div class="">

                          <form method="POST" action="" name="">
                        <select type="text" class="" placeholder="empleado" aria-label="empleado" name="empleado" value="" required="">
                        <% 
                            for (int i = 0; i < dat.size(); i++) {
                            now=dat.get(i);

                        %>
                               
                        <option><%=now.getCedula()%></option>
                                 
                            <%
                        }
                        %>
                        </select>
                        <div class="">

                            <input class="form-group" name="btnver" type="submit" value="Ver datos del empleado">

                        </div>
                         </form>
                    </div>
                </div>
                <form action="datosEmpleadoDomicilio" method="POST" >
                <% 
                ArrayList<Con_empleados> flag=new ArrayList<>();
                flag=mod.consultar_empleadosCed(con);
                for (int i = 0; i < flag.size(); i++) {
                        now=flag.get(i);
                %>
                    <div class="row g-3 align-items-center">
                      <div class="col-auto">
                        <label for="inputPassword6" class="col-form-label">Nombre</label>
                      </div>
                      <div class="col-auto">
                          <span id="passwordHelpInline" class="form-text">
                              <%=now.getNombre_emp()%> <%=now.getApellido_emp()%> 
                          </span>
                          
                      </div>
                        <div class="col-auto">
                        <label for="inputPassword6" class="col-form-label">Telefono</label>
                        </div>
                            
                        <div class="col-auto">
                        <span id="passwordHelpInline" class="form-text">
                            <%=now.getTelefono_emp()%>
                        </span>
                        </div>
                        
                        <div class="col-auto">
                        <label for="inputPassword6" class="col-form-label">Cedula</label>
                        </div>

                        <div class="col-auto">
                        <span id="passwordHelpInline" class="form-text">
                        <%=now.getCedula()%>
                        </span>
                        </div>
                        
                        <div class="col-auto">
                        <label for="inputPassword6" class="col-form-label">Codigo_Empleado</label>
                        </div>
                        <div class="col-auto">
                            <span id="passwordHelpInline" class="form-text">
                                <%=now.getCod_emp()%>
                            </span>
                        </div>
                            
                        <div class="col-auto">
                            <input type="text" name="factura" value="<%=factura%>" hidden="">
                            <input type="text" name="cedulaaa" value="<%=now.getCedula()%>" hidden="">
                            <button type="submit" name="btnact" value="" class="btn btn-primary">Generar Domicilio</button>
                        </div>    
                    </div>
                </form>            
                <%
                    }
                %>
                
        </div>        
    </body>
</html>
