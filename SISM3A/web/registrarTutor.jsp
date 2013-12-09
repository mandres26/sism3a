<%-- 
    Document   : registrarTutor
    Created on : 21/11/2013, 10:27:41 AM
    Author     : ABEL-LP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrar Tutor</title>
        <script type="text/javascript" src="js/Tutor.js"></script>
        <script type="text/javascript" src="js/ajax.googleapis.com_ajax_libs_jquery_1.10.2_jquery.min.js"></script>
        <script type="text/javascript" src="js/code.jquery.com_jquery-1.9.1.min.js"></script>
        <script type="text/javascript" src="js/jquery.bassistance.de_validate_additional-methods.js"></script>
        <script type="text/javascript" src="js/jquery.bassistance.de_validate_jquery.validate.js"></script>

        <script type="text/javascript" src="jquery.alerts-1.1/jquery.alerts.js"></script>  
        <link  rel="stylesheet" type="text/css" href="jquery.alerts-1.1/jquery.alerts.css" />
        

    </head>
    <body>
        <div class="contenido">
            <h2>REGISTRAR TUTOR</h2>
            <form id="registrarTutorForm" method="POST" action="SRegistrarTutor">
                <table>
                    <tr>
                        <td>Nombres :</td>
                        <td><input id="txtNombreT" name="txtNombreT" type="text"/></td>
                    </tr>
                    <tr>
                        <td>Apellido Paterno:</td>
                        <td><input id="txtApellidoP" name="txtApellidoP" type="text"/></td>
                    </tr>
                    <tr>
                        <td>Apellido Materno:</td>
                        <td><input id="txtApellidoM" name="txtApellidoM" type="text"/></td>
                    </tr>
                    <tr>
                        <td>Dni :</td>
                        <td><input id="txtDni" name="txtDni" type="text"/></td>
                    </tr>
                    <tr>
                        <td>Direccion :</td>
                        <td><input id="txtDireccion" name="txtDireccion" type="text"/></td>
                    </tr>
                    <tr>
                        <td>Telefono / cell :</td>
                        <td><input id="txtTelefono" name="txtTelefono" type="text"/></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="button" value="Registrar" onclick="RegistrarTutor()"/></td>
                    </tr>
                </table>                
            </form>
        </div>
    </body>
</html>
