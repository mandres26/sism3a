<%-- 
    Document   : registrarTipoCobro
    Created on : 30/11/2013, 12:30:21 AM
    Author     : davis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript" src="js/jsExamen.js"></script>
        <script type="text/javascript" src="jqgrid/script/jquery.ui.datepicker.min.js"></script>
        <script type="text/javascript" src="jqgrid/script/jquery-ui-1.10.3.custom.min.js"></script>
        <title>JSP Page</title>
    </head>
    <body>
    <center>
        <h1>Registrar tipo cobro</h1>
        <div class="divEstilo">
            <fieldset>
                <legend>Registrar tipo cobro</legend>
                <form method="post" action="SRegistrarTipoCobro">
                    <div>
                        <input type="hidden" name ="accion" value="RegistrarTipoCobro"/>
                        <table>
                            <tr>
                                <td>Denominacion</td>
                                <td><input type="text"name="txtDenominacion" value=""/></td>
                            </tr>
                            <tr>
                                <td>Monto</td>
                                <td><input type="text"name="txtMonto" value=""/></td>
                            </tr>
                            <tr>
                            <tr>
                                <td></td>
                                <td><input type="submit" value="Registrar" name="btnRegistrar"/></td>
                            </tr>
                        </table>
                    </div>
                </form>
            </fieldset>

        </div>
    </center>
</body>
</html>
