<%-- 
    Document   : matricula
    Created on : 09/12/2013, 05:17:31 PM
    Author     : ABEL-LP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Matricula</title>
    </head>
    <body>
        <div class="contenido">
            <center>
                <h2>Nueva Matricula</h2>
                <form id="registrarTutorForm" method="POST" action="SRegistrarTutor">
                    <table>
                        <tr>
                            <td>Nombres :</td>
                            <td><input id="txtNombreT" name="txtNombreT" type="text"/></td>
                            <td><input id="txtApellidoP" name="txtApellidoP" type="text"/></td>
                            <td><input id="txtApellidoM" name="txtApellidoM" type="text"/></td>
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
            </center>
        </div>
    </body>
</html>
