<%-- 
    Document   : crearSecretario
    Created on : 09/12/2013, 02:51:44 PM
    Author     : ABEL-LP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrar Secretario</title>
        <script src="js/secretario.js" type="text/javascript"></script>
        <script type="text/javascript" src="js/ajax.googleapis.com_ajax_libs_jquery_1.10.2_jquery.min.js"></script>
        <script type="text/javascript" src="js/code.jquery.com_jquery-1.9.1.min.js"></script>
        <script type="text/javascript" src="js/jquery.bassistance.de_validate_additional-methods.js"></script>
        <script type="text/javascript" src="js/jquery.bassistance.de_validate_jquery.validate.js"></script>
    </head>
    <body>
        <div class="contenido">
            <center>
                <h2>REGISTRAR SECRETARIO</h2>
                <form id="registrarSecretarioForm">
                    <table>                        
                        <tr>
                            <td>Nombres :</td>
                            <td><input id="txtNombreS" name="txtNombreS" type="text"/></td>
                        </tr>
                        <tr>
                            <td>Apellido Paterno:</td>
                            <td><input id="txtApellidoPS" name="txtApellidoPS" type="text"/></td>
                        </tr>
                        <tr>
                            <td>Apellido Materno:</td>
                            <td><input id="txtApellidoMS" name="txtApellidoMS" type="text"/></td>
                        </tr>
                        <tr>
                            <td>Dni :</td>
                            <td><input id="txtDniS" name="txtDniS" type="text"/></td>
                        </tr>
                        <tr>
                            <td>Direccion :</td>
                            <td><input id="txtDireccionS" name="txtDireccionS" type="text"/></td>
                        </tr>
                        <tr>
                            <td>Telefono / cell :</td>
                            <td><input id="txtTelefonoS" name="txtTelefonoS" type="text"/></td>
                        </tr>
                        <tr>
                            <td>Usuario :</td>
                            <td><input id="txtusuarioS" name="txtusuarioS" type="text"/></td>
                        </tr>
                        <tr>
                            <td>Contraseña :</td>
                            <td><input id="txtpasswS" name="txtpasswS" type="password"/></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td><input type="button" value="Registrar" onclick="RegistrarSecretario()"/></td>
                        </tr>
                    </table>                
                </form>
            </center>
        </div>
    </body>
</html>
