<%-- 
    Document   : Formulario_Domicilios
    Created on : 16/02/2021, 10:38:53 PM
    Author     : Trabajos
--%>
<%@page import="javax.swing.JOptionPane"%>
<%
    HttpSession obj = request.getSession();
    String ua = (String) obj.getAttribute("usuario");
    String ced = (String) obj.getAttribute("cedula");
    String nom_cli = (String) obj.getAttribute("nombre_cli");
    String rol = (String) obj.getAttribute("rol");
%>
<%@page import="Modelos.Mod_Domicilios"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Constructor.Con_Domicilios"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
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


        <title>Inicio</title>
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
            <nav class="navbar navbar-expand-lg fixed-top navbar-light bg" style="background: #ffff00" >
                <div class="logo">Supermercado la Alianza                       
                    <img src="img/shopping-cart-2020929_640.png " class="" >
                </div>
                <div class="container-fluid "> 

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
                           if (ua == null) {%>
                            <li class="nav-item">
                                <a class="nav-link" href="login.jsp">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="30   " height="30" fill="currentColor" class="bi bi-person-square" viewBox="0 0 16 16">
                                    <path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z"/>
                                    <path d="M2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2zm12 1a1 1 0 0 1 1 1v12a1 1 0 0 1-1 1v-1c0-1-1-4-6-4s-6 3-6 4v1a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1h12z"/>
                                    </svg> Iniciar Sesion</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="registrar.jsp">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" fill="currentColor" class="bi bi-person-plus" viewBox="0 0 16 16">
                                    <path d="M6 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6zm2-3a2 2 0 1 1-4 0 2 2 0 0 1 4 0zm4 8c0 1-1 1-1 1H1s-1 0-1-1 1-4 6-4 6 3 6 4zm-1-.004c-.001-.246-.154-.986-.832-1.664C9.516 10.68 8.289 10 6 10c-2.29 0-3.516.68-4.168 1.332-.678.678-.83 1.418-.832 1.664h10z"/>
                                    <path fill-rule="evenodd" d="M13.5 5a.5.5 0 0 1 .5.5V7h1.5a.5.5 0 0 1 0 1H14v1.5a.5.5 0 0 1-1 0V8h-1.5a.5.5 0 0 1 0-1H13V5.5a.5.5 0 0 1 .5-.5z"/>
                                    </svg> Registrar usuario</a>
                            </li>
                    </div>
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

            </nav>

        </header>
        <!--Contenedor principal que mostrara imagen de bienvenida-->

        <div class="conteiner-sm">

            <div class="row">

                <div class="contenedor">

                    <!--CAROUSEL-->
                    <div id="carouselExampleControls" class="carousel slide" data-bs-ride="carousel">
                        <div class="carousel-inner">
                            <div class="carousel-item active">
                                <img src="img/snack.jpg" class="img-fluid img-principal" alt="...">
                            </div>
                            <div class="carousel-item">
                                <img src="img/supermercado_paginaprincipal.jpg" class="img-fluid img-principal" alt="...">
                            </div>
                            <div class="carousel-item">
                                <img src="img/lefrute.jpg" class="img-fluid img-principal" alt="...">
                            </div>
                        </div>
                        <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleControls"  data-bs-slide="prev">
                            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                            <span class="visually-hidden">Previous</span>
                        </button>
                        <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleControls"  data-bs-slide="next">
                            <span class="carousel-control-next-icon" aria-hidden="true"></span>
                            <span class="visually-hidden">Next</span>
                        </button>
                    </div>
                    <!--END CAROUSEL-->    


                    <div class="centrado"><h1><b>BIENVENIDO A LA PAGINA DE SUPERMERCADOS LA ALIANZA</b></h1>

                        <section>Con los últimos acontecimientos a nivel mundial se ha podido contemplar los problemas que el mundo tiene que afrontar tomando como ejemplo el distanciamiento social, adicional a esto abordamos un problema que consiste en la falta de disponibilidad de los muchos usuarios para adquirir sus productos de la canasta familiar entre otros productos necesarios para la vida cotidiana.
                        </section>



                    </div>


                </div>

            </div>


            <!--Contenedor de la pagina despues de la imagen. Almacenara toda la informacion correspondiente-->
            <div class="container-md">
                <section>
                    <div class="container-md">
                        <div class="container " style="transform: translateX(20%)">
                            <!--                            <h1>Los mejores productos de calidad</h1>
                                                    </div>
                                                <div class="row">
                                                    
                            
                                                <div class="col-10"><p>
                                                   El supermercado la Alianza cuenta  con un sistema de domicilio eficaz el cual consiste en un paso a paso desde el cual el cliente solicita su pedido mediante vía telefónica cuya relación uno a muchos le permite al cliente adquirir gran cantidad de productos , los empleados toman nota del pedido y los datos del cliente como la dirección, el  nombre del usuario, el apellido y su edad en una libreta  junto con los productos solicitados donde la relación muchos a muchos hace que el empleado pueda organizar la información y los datos del pedido de manera eficaz q e inmediatamente se le informa al encargado del domicilio acerca del pedido y se le brindan los datos del cliente para su respectiva entrega donde la relación muchos a uno toma lugar al momento de entregar los productos del cliente confirmando los datos descritos por el cliente y se analiza la calidad de estos y si cumple las condiciones pactadas se finaliza el  proceso o de lo contrario se repite el proceso para cumplir con las condiciones estipuladas.
                            
                                                </p>
                                                </div>
                                                
                                                </div>
                                            </div>
                            -->            


                            </li>

                            </section>    
                        </div>

                    </div>

            </div>
        </div>

        <div  class="container-xl text-justify" style="color: black">

            <h2>Los mejores productos de calidad</h2>
            <article>El supermercado la Alianza cuenta  con un sistema de domicilio eficaz el cual consiste en un paso a paso desde el cual el cliente solicita su pedido mediante vía telefónica cuya relación uno a muchos le permite al cliente adquirir gran cantidad de productos , los empleados toman nota del pedido y los datos del cliente como la dirección, el  nombre del usuario, el apellido y su edad en una libreta  junto con los productos solicitados donde la relación muchos a muchos hace que el empleado pueda organizar la información y los datos del pedido de manera eficaz q e inmediatamente se le informa al encargado del domicilio acerca del pedido y se le brindan los datos del cliente para su respectiva entrega donde la relación muchos a uno toma lugar al momento de entregar los productos del cliente confirmando los datos descritos por el cliente y se analiza la calidad de estos y si cumple las condiciones pactadas se finaliza el  proceso o de lo contrario se repite el proceso para cumplir con las condiciones estipuladas.
            </article>


        </div>



        <section class="social">

            <p>

                <!-- Button trigger modal -->
                <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#staticBackdrop">
                    GRACIAS POR PREFERIRNOS
                </button>

                <!-- Modal -->
            <div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="staticBackdropLabel" style="color: black">Estimado usuario:</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body" style="color: black">
                            Agradecemos su confianza al elejir nuestro supermercado.<div class=""></div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>

                        </div>
                    </div>
                </div>
            </div>


            <div class="links">

                <a href="#">

                    <i class="fab fa-facebook-f"></i>

                </a>

                <a href="#">

                    <i class="fab fa-whatsapp"></i>

                </a>

                <a href="#">

                    <i class="fab fa-youtube"></i>

                </a>


            </div>

        </p>

    </section>




    <div class="footer-links">

        <div class="footer-container">
            <ul>
                <li>
                    <a href="#">
                        <h1></h1>
                    </a>
                </li>
                <li>


                    </div>

                    </div>

                    <footer class="footer">

                        <h3>Supermercado La Alianza Copyright &copy;</h3>
                        <h3>SI DESEA MAS AYUDA PUEDE LLAMAR AL Nº 3212929415  y pedir asesoria</h3>


                    </footer>


                    </div>

                    <!--SCROLLREVEAL-->
                    <script src="https://unpkg.com/scrollreveal"></script>

                    <!--CUSTOM JS-->
                    <script src="main.js"></script>


                    </body>
                    </html>
