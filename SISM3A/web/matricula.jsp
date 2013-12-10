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
        <script type="text/javascript" src="js/matricula.js"></script>
        <script type="text/javascript" src="js/ajax.googleapis.com_ajax_libs_jquery_1.10.2_jquery.min.js"></script>
        <script type="text/javascript" src="js/code.jquery.com_jquery-1.9.1.min.js"></script>
        <script type="text/javascript" src="js/jquery.bassistance.de_validate_additional-methods.js"></script>
        <script type="text/javascript" src="js/jquery.bassistance.de_validate_jquery.validate.js"></script>

    </head>
    <body>
        <div class="contenido">
            <center>
                <h2>Nueva Matricula</h2>
                <form id="MatriculaForm" method="POST" action="SRegistrarTutor">
                    <table>
                        <tr>
                            <td>Nombres :</td>
                            <td><input id="txtNombreAM" name="txtNombreAM" type="text"/></td>
                        </tr>
                        <tr>
                            <td>Apellido Paterno:</td>
                            <td><input id="txtApellidoPAM" name="txtApellidoPAM" type="text"/></td>
                        </tr>
                        <tr>
                            <td>Apellido Materno:</td>
                            <td><input id="txtApellidoMAM" name="txtApellidoMAM" type="text"/></td>
                        </tr>
                        <tr>
                            <td>Dni :</td>
                            <td><input id="txtDniAM" name="txtDniAM" type="text"/></td>
                        </tr>
                        <tr>
                            <td>Direccion :</td>
                            <td><input id="txtDireccionAM" name="txtDireccionAM" type="text"/></td>
                        </tr>
                        <tr>
                            <td>Telefono / cell :</td>
                            <td><input id="txtTelefonoAM" name="txtTelefonoAM" type="text"/></td>
                        </tr>
                        <tr>
                            <td>Escuela:</td>
                            <td><select id="EscuelaAM" name="EscuelaAM">
                                    <option>Agronomia</option>
                                    <option>Agricola</option>
                                    <option>Minas</option>
                                    <option>Sistemas</option>
                                    <option>Contabilida</option>
                                </select></td>
                        </tr>
                        <tr>
                            <td>Tipo Cobro:</td>
                            <td><select id="tipoPagoAM" name="tipoPagoAM">
                                    <option> -Tipo Pago- </option>                                
                                </select><input type="button" value="listar Cobro" onclick="listarTipoCobro()"/>
                            </td>
                        </tr>
                        <tr>
                            <td></td>
                            <td><input type="button" value="Registrar" onclick="matricular()"/></td>
                        </tr>
                    </table>                
                </form>
            </center>
        </div>
    </body>
</html>
