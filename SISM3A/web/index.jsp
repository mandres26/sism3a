<%-- 
    Document   : index
    Created on : 17/11/2013, 02:14:51 PM
    Author     : ABEL-LP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>Index</title>


        <link rel="stylesheet" type="text/css" href="css/pro_dropdown_3.css" />
        <script type="text/javascript" src="jqgrid/script/jquery-1.7.2.min.js"/>
        <script src="js/stuHover.js" type="text/javascript"></script>
        <script src="js/admPage.js" type="text/javascript"></script>
        <script src="js/Salon/jsSalon.js" type="text/javascript"></script>
        <script src="js/Matricula/jsMatricula.js" type="text/javascript"></script>


    </head>

    <body onload="inicioContenido()" >
        <span class="preload1"></span>
        <span class="preload2"></span>
        <div id="cabecera">
            <ul id="nav">
                <li class="top"><a href="#nogo1" class="top_link"><span>Home</span></a></li>
                <li class="top"><a href="#nogo2" id="products" class="top_link"><span class="down">Adm Salon</span></a>
                    <ul class="sub">
                        <li><b>Cameras</b></li>
                        <li><a href="#nogo3" class="fly">Cameras</a>
                            <ul>
                                <li><a href="#"  >Nikon</a></li>
                                <li><a href="Salon.jsp">Salon</a></li>
                                <li><a href="#nogo6">Pentax</a></li>
                            </ul>
                        </li>
                        <li><a href="#nogo7" class="fly">Lenses</a>
                            <ul>
                                <li><a href="#nogo8">Wide Angle</a></li>
                                <li><a href="#nogo9">Standard</a></li>
                                <li><a href="#nogo15">Mirror</a></li>
                                <li><a href="#nogo10">Telephoto</a></li>
                                <li><b>Zoom</b></li>
                                <li><a href="#nogo12">35mm to 125mm</a></li>
                                <li><a href="#nogo13">50mm to 250mm</a></li>
                                <li><a href="#nogo14">125mm to 500mm</a></li>

                                <li><b>Non standard</b></li>
                                <li><a href="#nogo17">Bayonet mount</a></li>
                                <li><a href="#nogo18">Screw mount</a></li>
                            </ul>
                        </li>

                    </ul>
                </li>
                <li class="top"><a href="#nogo22" id="services" class="top_link"><span class="down">Adm. Matriculas</span></a>
                    <ul class="sub">

                        <li onclick="mostrarContenido()"><a href= "#">Matriculas</a></li>
                        <li><a href="#nogo24">dasdsa</a></li>
                        <li><a href="#nogo25">Retouching</a></li>
                        <li><a href="#nogo26">Archiving</a></li>
                    </ul>
                </li>
                <li class="top"><a href="#nogo27" id="contacts" class="top_link"><span class="down">Contacts</span></a>
                    <ul class="sub">
                        <li><a href="#nogo28">Support</a></li>
                        <li><a href="#nogo29" class="fly">Sales</a>
                            <ul>
                                <li><b>European</b></li>
                                <li><a href="#nogo34" class="fly">British</a>
                                    <ul>
                                        <li><b>City</b></li>
                                        <li><a href="#nogo35">London</a></li>
                                        <li><a href="#nogo36">Liverpool</a></li>
                                        <li><a href="#nogo37">Glasgow</a></li>
                                        <li><a href="#nogo38" class="fly">Bristol</a>
                                            <ul>
                                                <li><b>District</b></li>
                                                <li><a href="#nogo39">Redland</a></li>
                                                <li><a href="#nogo40">Hanham</a></li>
                                                <li><a href="#nogo41">Eastville</a></li>
                                            </ul>
                                        </li>
                                        <li><a href="#nogo42">Cardiff</a></li>
                                        <li><a href="#nogo43">Belfast</a></li>
                                    </ul>
                                </li>
                                <li><a href="#nogo44">French</a></li>
                                <li><a href="#nogo45">German</a></li>
                                <li><a href="#nogo46">Spanish</a></li>
                                <li><b>Worldwide</b></li>
                                <li><a href="#nogo30">USA</a></li>
                                <li><a href="#nogo31">Canadian</a></li>
                                <li><a href="#nogo32">South American</a></li>
                                <li><a href="#nogo47">Australian</a></li>
                                <li><a href="#nogo48">Asian</a></li>
                            </ul>
                        </li>
                        <li><a href="#nogo49">Buying</a></li>
                        <li><a href="#nogo50">Photographers</a></li>
                        <li><a href="#nogo51">Stockist</a></li>
                        <li><a href="#nogo52">General</a></li>
                    </ul>
                </li>
                <li class="top"><a href="#nogo53" id="shop" class="top_link"><span class="down">Shop</span></a>
                    <ul class="sub">
                        <li><a href="#nogo54">Online</a></li>
                        <li><a href="#nogo55">Catalogue</a></li>
                        <li><a href="#nogo56">Mail Order</a></li>
                    </ul>
                </li>
                <li class="top"><a href="#nogo57" id="privacy" class="top_link"><span>Privacy Policy</span></a></li>
            </ul>
        </div>

    </body>
</html>