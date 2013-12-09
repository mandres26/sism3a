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
        <title>Registro de ciclo academico</title>
    </head>
    <body>
    <center>
        <div class="divEstilo">
            <fieldset>
                <legend>Registrar de ciclo academico</legend>
                <form method="post" action="SRegistrarCicloAcademico">
                    <div>
                        <input type="hidden" name ="accion" value="RegistrarCicloAcademico"/>
                        <table>
                            <tr>
                                <td>Tipo ciclo academico</td>
                                <td><input type="text"name="txtTipoCicloAcademico" value=""/></td>
                            </tr>
                            <tr>
                                <td>Fecha inicio</td>
                                <td><input type="text"name="txtFechaInicio" value=""/></td>
                                <td><note>dd/mm/yyy </note></td>
                            </tr>
                            <tr>
                                <td>Fecha fin</td>
                                <td><input type="text"name="txtFechaFin" value=""/></td>
                                <td><note>dd/mm/yyy </note></td>
                            </tr>
                            <tr>
                                <td>Costo total</td>
                                <td><input type="text"name="txtCosto"  value=""/></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td><input type="submit" value="Registrar" name="btnRegistrar"/></td>
                            </tr>
                        </table>

                    </div>
                </form>
                <br/>
                <form method="post" action="SRegistrarTipoCobro">
                    <div>
                        <input type="hidden" name ="accion" value="RegistrarTipoCobro"/>
                        <table>
                            <td align="right">Denominacion:</td>
                            <td><select  id="txtDenominacion" name="txtDenominacion" style="width: 142px">
                                    <option value="1 parte">Todo en I</option>
                                    <option value="2 partes">En  II partes</option>
                                    <option value="3 partes">En III partes</option>
                                </select>
                            </td>
                            <tr>
                                <td>Monto</td>
                                <td><input type="text"name="txtMonto" value=""/></td>
                            </tr>
                            <tr>
                            <tr>
                                <td></td>
                                <td><input type="submit" value="Registrar" name="btnRegistrar" onclick="javascript:alert('agregado...')"/></td>
                            </tr>
                        </table>
                    </div>
                </form> 
            </fieldset>

        </div>
    </center>
</body>
</html>
