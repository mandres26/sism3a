<%-- 
    Document   : registrarCicloAcademico
    Created on : 02/12/2013, 02:24:46 PM
    Author     : davis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrar Ciclo Academico</title>
        <script type="text/javascript" src="js/jsCicloAcademico.js"></script>
        <script type="text/javascript" src="js/jsRegistrarTipoCobro.js"></script>
        <script type="text/javascript" src="js/ajax.googleapis.com_ajax_libs_jquery_1.10.2_jquery.min.js"></script>
        <script type="text/javascript" src="js/code.jquery.com_jquery-1.9.1.min.js"></script>
        <script type="text/javascript" src="js/jquery.bassistance.de_validate_additional-methods.js"></script>
        <script type="text/javascript" src="js/jquery.bassistance.de_validate_jquery.validate.js"></script>

        <script type="text/javascript" src="jquery.alerts-1.1/jquery.alerts.js"></script>  
        <link  rel="stylesheet" type="text/css" href="jquery.alerts-1.1/jquery.alerts.css" />


    </head>
    <body>
    <center>
        <div class="divEstilo">
            <fieldset style="width: 800px; height: 500px">
                <legend>Registrar de ciclo academico</legend>
                <form id="registrarCicloAcademicoForm">
                    <table style="width: 380px; height: 150px">
                        <tr>
                            <td>Tipo ciclo academico</td>
                            <td><input id="txtTipoCicloAcademico" type="text"name="txtTipoCicloAcademico" value=""/></td>
                        </tr>
                        <tr>
                            <td>Fecha inicio</td>
                            <td><input id="txtFechaInicio" type="text"name="txtFechaInicio" value=""/></td>
                            <td><note>dd/mm/yyy </note></td>
                        </tr>
                        <tr>
                            <td>Fecha fin</td>
                            <td><input id="txtFechaFin" type="text"name="txtFechaFin" value=""/></td>
                            <td><note>dd/mm/yyy </note></td>
                        </tr>
                        <tr>
                            <td>Costo total</td>
                            <td><input id="txtCosto" type="text"name="txtCosto"  value=""/></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td><input type="button" value="Registrar" onclick="RegistrarCicloAcademico()"/></td>
                        </tr>
                    </table>
                </form>
                <br/>
                <form  id="RegistrarTipoCobroForm">
                    <table style="width: 380px; height: 150px">
                        <tr>
                            <td>Codigo ciclo academico </td>
                            <td><input id="txtCiclo" type="text" name="txtCiclo" value=""/></td>
                        </tr>
                        <tr>
                            <td>Ciclo academico </td>
                            <td><input id="txtNombreCiclo" type="text" name="txtNombreCiclo" value=""/></td>
                        </tr>
                        <tr>
                            <td align="left">Cuotas</td>
                            <td><select  id="txtDenominacion" name="txtDenominacion" style="width: 142px">
                                    <option value="1 parte">Todo en I</option>
                                    <option value="2 partes">En  II partes</option>
                                    <option value="3 partes">En III partes</option>
                                </select>
                            </td> 
                        </tr>
                        <tr>
                            <td>Monto</td>
                            <td><input id="txtMonto" type="text"name="txtMonto" value=""/></td>
                        </tr>
                        <tr>
                        <tr>
                            <td></td>
                            <td><input type="button" value="Registrar" onclick="RegistrarTipoCobro()"/></td>
                        </tr>
                    </table>
                </form> 
            </fieldset>

        </div>
    </center>
</body>
</html>
