<%-- 
    Document   : listarTutor
    Created on : 02/12/2013, 06:17:25 PM
    Author     : ABEL-LP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar Tutor</title>
        <script type="text/javascript" src="js/Tutor.js"></script>
        <script type="text/javascript" src="js/ajax.googleapis.com_ajax_libs_jquery_1.10.2_jquery.min.js"></script>
        <script type="text/javascript" src="js/code.jquery.com_jquery-1.9.1.min.js"></script>
        <script type="text/javascript" src="js/jquery.bassistance.de_validate_additional-methods.js"></script>
        <script type="text/javascript" src="js/jquery.bassistance.de_validate_jquery.validate.js"></script>


        <!-- Jqgrid-->
        <link rel="stylesheet" href="jqgrid/css/style.css"/>
        <link rel="stylesheet" href="jqgrid/css/redmond/jquery-ui.css"/>
        <link rel="stylesheet" href="jqgrid/css/redmond/jquery.ui.theme.css"/>
        <link rel="stylesheet" href="jqgrid/css/jqgrid/ui.jqgrid.css"/>

        <script src="jqgrid/js/jquery.min.js" type="text/javascript"></script>
        <script src="jqgrid/js/grid.locale-en.js" type="text/javascript"></script>
        <script src="jqgrid/js/jquery.jqGrid.min.js" type="text/javascript"></script>
        <script src="jqgrid/js/jquery-ui.min.js"></script>
    </head>
    <body>
        <h2>Lista de Tutores</h2>
        <div class="contenido">
            <input type="button" value="listar" onclick="listarTutor()"/>
            
            <input type="datetime-local"/>
            <table border="black" cellspacing="0px">
                <thead>
                    <tr>
                        <td>Id</td>
                        <td>Nombres</td>
                        <td>Dni</td>
                        <td>Direccion</td>
                        <td>Estado</td>
                    </tr>
                </thead>
                <tbody id="tbody">

                </tbody>
            </table>
        </div>
        <fieldset><legend>Lista Tutor</legend>
            <input type="button" value="jajaj" onclick="listarTutorGrid()"/>
            <center>
                <div>                
                    <table id="listGrid"></table> 
                    <div id="pagerGrid"></div>
                </div>     
            </center>
        </fieldset>
        <fieldset><legend>Detalle Tutor</legend>
             <label><strong>NOMBRE ALMUNO</strong></label>
             <input type="button" value="Listar" onclick="getData()"/>
            <div>
                
            Invoice Header 
            <table id="list2"></table> 
            <div id="pager2"></div> 
            <br />
            Invoice Detail 
            <table id="list10_d"></table>
            <div id="pager10_d"></div>
            </div>

        </fieldset>
        <div>
            <form id="ActualizarTutorFor" method="GET" action="SListarTutor">
                <table>
                    <tr>
                        <td>Nombres :</td>
                        <td><input id="txtNombreT1" name="txtNombreT1" type="text"/></td>
                    </tr>
                    <tr>
                        <td>Apellido Paterno:</td>
                        <td><input id="txtApellidoP1" name="txtApellidoP1" type="text"/></td>
                    </tr>
                    <tr>
                        <td>Apellido Materno:</td>
                        <td><input id="txtApellidoM1" name="txtApellidoM1" type="text"/></td>
                    </tr>
                    <tr>
                        <td>Dni :</td>
                        <td><input id="txtDni1" name="txtDni1" type="text"/></td>
                    </tr>
                    <tr>
                        <td>Direccion :</td>
                        <td><input id="txtDireccion1" name="txtDireccion1" type="text"/></td>
                    </tr>
                    <tr>
                        <td>Telefono / cell :</td>
                        <td><input id="txtTelefono1" name="txtTelefono1" type="text"/></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="button" value="Registrar" onclick="ActualizarTutor()"/></td>
                    </tr>
                </table>                
            </form>
        </div>


    </body>
</html>
