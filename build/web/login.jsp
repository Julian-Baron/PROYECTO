<%-- 
    Document   : login
    Created on : 2/03/2021, 07:27:02 PM
    Author     : Personal
--%>
<%@page import="java.math.BigInteger"%>
<%@page import="java.security.MessageDigest"%>
<%
    HttpSession obj = request.getSession();
    String ua = (String) obj.getAttribute("usuario");
    String ced = (String) obj.getAttribute("cedula");
    String nom_cli = (String) obj.getAttribute("nombre_cli");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script src="js/jquery-3.5.1.min.js"></script>
        <script src="js/doc.js"></script>

        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
        <link rel="stylesheet" href="css/styles_header.css">
        <link rel="stylesheet" href="css/Style_index.css">

        <!--FONT AWESOME-->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css">

        <link rel="stylesheet" href="css/js.css">
        <link rel="stylesheet" href="css/tbl.css">
        <link rel="stylesheet" href="css/log.css">  
        <!--Font-->

        <link rel="preconnect" href="https://fonts.gstatic.com">

        <link href="https://fonts.googleapis.com/css2?family=Orbitron:wght@500&display=swap" rel="stylesheet">


        <!--CSS-->
        <link rel="stylesheet" href="css/fonts.css">

        <!--ICONO-->
        <link rel="icon" href="img/alianza_1.png">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>¡Bienvenido al supermercado La Alianza!</title>
    </head>
    <body style="background-image:  url('img/login_fondo.jpg')">




        <header class="header">
            <nav><div id><a href="index.jsp"id="log"></a></div></nav>
            <div id="menu_s" class="menu"></div>
            <div id="contmenu" class="contmenu">
                <div id="logo"></div>
            </div>






            <!--<div><img  class="logoooo" src="imagenes/" alt="img"></div>
     <h1 id="til">Bienvenido</h1>*/-->
        </header>


        <div id="formularios1"> 
            <form  id="for1" action="Sv_login" method="POST">            
                <legend class="">INGRESA TUS DATOS</legend>
                <input class="doc" type="text" name="usu" placeholder="USUARIO">
                <input class="doc" type="password" name="pas" placeholder="CONTRASEÑA">
                <input class="doc" id="" type="submit" name="btnlog" value="Aceptar">
            </form>
        </div>




        <footer>
            <legend id="PiedePagina">
                <ul id="abajo">
                    <div class="as">SUPERMERCADO LA ALIANZA. TODOS LOS DERECHOS RESERVADOS©</div>  

                    <section>
                        <nav id=menu_aba>    
                            <div> <a class="asad" href="#"><img class="log" src="img/face.png" alt="facebook"></a></div>
                            <div> <a class="asad" href="#"><img class="log" src="img/instagram.png" alt="instagram"></a></div>
                            <div> <a class="asad" href="#"><img class="log" src="img/twitter.png" alt="twitter"></a></div>
                        </nav>
                    </section>
                </ul>
            </legend>



        </footer>

    </body>
</html>





</body>
</html>
<%!

%>