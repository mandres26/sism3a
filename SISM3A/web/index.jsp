<%-- 
    Document   : index
    Created on : 17/11/2013, 02:14:51 PM
    Author     : ABEL-LP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<!-- paulirish.com/2008/conditional-stylesheets-vs-css-hacks-answer-neither/ -->
<!--[if lt IE 7]> <html class="no-js ie6 oldie" lang="en"> <![endif]-->
<!--[if IE 7]>    <html class="no-js ie7 oldie" lang="en"> <![endif]-->
<!--[if IE 8]>    <html class="no-js ie8 oldie" lang="en"> <![endif]-->
<!--[if gt IE 8]><!--> 
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8"> 
        <title>untitled</title>
        <link rel="stylesheet" href="css/styleMenu.css" type="text/css" />
        <!--[if lt IE 8]>
                <script src ="http://ie7-js.googlecode.com/svn/version/2.1(beta2)/IE8.js"></script>
        <![endif]-->	
        <script src="js/jquery.efects.core.js" type="text/javascript"></script>
        <script type="text/javascript" src="js/scriptsMenu.js"></script>
        <script type="text/javascript" src="js/funcionesGenerales.js"></script>
    </head>
    <body>
        <div style="text-align: center;border: 1px solid #20911e;width: 650px; height:55px ; margin:0 auto 0 auto;">
            <center>
                <ul id="nav">
                    <li><a href="#" onclick=""  title="Inicio">Inicio</a></li>
                    <li><a href="#" onclick="ref('jsp');"  title="Matricula">Matricula</a>
                        <ul>
                            <li><a href="#">About Us</a></li>
                            <li><a href="#">About Them</a></li>
                            <li><a href="#">About You</a>
                                <ul>
                                    <li><a href="#">More About Us</a></li>
                                    <li><a href="#">More About Them</a></li>
                                    <li><a href="#">More About You</a></li>						
                                </ul>
                            </li>						
                        </ul>
                    </li>
                    <li><a href="#">Ciclo Academico</a></li>
                    <li><a href="#">Salon</a>
                        <ul>
                            <li><a href="#">International</a></li>
                            <li><a href="#">Corporate</a>
                                <ul>
                                    <li><a href="#">International</a></li>
                                    <li><a href="#">Corporate</a></li>
                                    <li><a href="#">American Offices</a></li>
                                </ul>
                            </li>
                            <li><a href="#">American Offices</a></li>						
                        </ul>
                    </li>	
                    <li><a href="#" onclick="ref('registrarTutor.jsp');"  title="Tutores">Tutores</a>
                        <ul>
                            <li><a href="#" onclick="ref('registrarTutor.jsp');"  title="Tutores">Nuevo Tutor</a></li>
                            <li><a href="#">Listar Tutor</a></li>
                            <li><a href="#">Modificar Tutor</a></li>						
                        </ul>
                    </li>
                </ul>
            </center>  
        </div>
        <div id="cuerpo">
            <center>
                <iframe id="frame" frameborder="1px solid black" src="" width="800" height="520">

                </iframe>
            </center>
        </div>
    </body>
</html>	
