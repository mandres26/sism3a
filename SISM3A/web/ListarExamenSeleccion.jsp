<%-- 
    Document   : ListarExamenSeleccion
    Created on : 10/12/2013, 03:38:56 PM
    Author     : davis
--%>

<%@page import="org.academia.bean.BReporteExamen"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.academia.dao.DAOExamen"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reporte de examen</title>
    </head>
    <body>
    <center>
        <div>
            <table>
                <tr style="background-color: chocolate ">
                    <td colspan="5"> Lista de Examen Beca</td>
                </tr>
                <tr style="background-color: chocolate ">
                    <td>idExamen</td>
                    <td>Tipo Examen</td>
                    <td>Alumno</td>
                    <td> fecha</td>
                    <td> nota</td>
                </tr>
                <% ArrayList<BReporteExamen> lista = DAOExamen.listarExamenSeleccion();
                    for (BReporteExamen oBExamen : lista) {
                %>
                <tr>
                    <td><%=oBExamen.getIdExamen()%></td>
                    <td><%=oBExamen.getTipoExamen()%></td>
                    <td><%=oBExamen.getAlumno()%></td>
                    <td><%=oBExamen.getFecha()%></td>
                    <td><%=oBExamen.getNota()%></td>
                </tr>
                <%
                    }
                %>

            </table>
        </div>
    </center>
</body>
</html>

