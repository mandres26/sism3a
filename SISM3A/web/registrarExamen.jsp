<%-- 
    Document   : registrarExamen
    Created on : 29/11/2013, 10:50:04 AM
    Author     : davis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript" src="js/jsRegistrar.js.js"></script>
        <script type="text/javascript" src="js/jsHelpFunction.js"></script>
        <script type="text/javascript" src="jqgrid/js/jquery.ui.datepicker.min.js"></script>
        <script type="text/javascript" src="jqgrid/js/jquery.min.js"></script>
        <title>JSP Page</title>
    </head>
    <body>
    <center>
        <h1>Registrar tipo cobro</h1>
        <div class="divEstilo">
            <fieldset>
                <legend>Registrar tipo cobro</legend>
                <form method="post" action="SRegistrarExamen">
                    <div>
                        <input type="hidden" name ="accion" value="RegistrarExamen"/>
                        <table >
                            <tr>
                                <td>Tipo examen</td>
                                <td><input type="text"name="txtTipoExamen" value=""/></td>
                            </tr>
                            <tr>
                                <td>Nota</td>
                                <td><input type="text"name="txtNota" value=""/></td>
                            </tr>
                            <tr>
                            <%--<div class="col-md-3" >
                                <label>FechaOperacion</label>
                                <input id="txtFecOpeacion" class="form-control" type="text">
                            </div> --%>
                            </tr>

                            <tr>
                                <td>Fecha</td>
                                <td><input type="text"name="txtFecha" value=""/></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td><input type="submit" value="Registrar" name="btnRegistrar"/></td>
                            </tr>
                        </table>
                    </div>
                </form>
            </fieldset>
        </div>
    </body>
</html>
