<%-- 
    Document   : crearSalon
    Created on : 09/12/2013, 05:28:19 PM
    Author     : ABEL-LP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Crear Salon</title>
        <script type="text/javascript" src="js/salon.js"></script>
        
        <script type="text/javascript" src="js/ajax.googleapis.com_ajax_libs_jquery_1.10.2_jquery.min.js"></script>
        <script type="text/javascript" src="js/code.jquery.com_jquery-1.9.1.min.js"></script>
        <script type="text/javascript" src="js/jquery.bassistance.de_validate_additional-methods.js"></script>
        <script type="text/javascript" src="js/jquery.bassistance.de_validate_jquery.validate.js"></script>
    </head>
    <body>
        <div class="contenido">
            <center>
                <table>
                    <tr>
                        <td>nombre Salon :</td>
                        <td><input id="txtNombreSalon" name="txtNombreSalon" type="text"/></td>

                    </tr>
                    <tr>
                        <td>Capacidad Max:</td>
                        <td><input id="txtApellidoP" name="txtApellidoP" type="text"/></td>
                    </tr>
                    <tr>
                        <td>Tutor a Cargo:</td>
                        <td>
                            <select id="listTutor">
                                <option>-seleccione un tutor</option>
                            </select>
                        </td>
                    </tr>
                    <input type="button" value="Hola" onclick="listarTutorSalon()"/>
                </table> 
            </center>
        </div>
    </body>
</html>
