<%-- 
    Document   : ListarExamen
    Created on : 29/11/2013, 04:02:28 PM
    Author     : davis
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="org.academia.dao.DAOExamen"%>
<%@page import="org.academia.bean.BExamen"%>
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
                    <td colspan="5"> Lista de Examen</td>
                </tr>
                <tr style="background-color: chocolate ">
                    <td>idExamen</td>
                    <td>Tipo Examen</td>
                    <td> fecha</td>
                    <td> nota</td>
                </tr>
                <% ArrayList<BExamen> lista = DAOExamen.listarExamen();
                    for (BExamen oBExamen : lista) {
                %>
                <tr>
                    <td><%=oBExamen.getIdExamen()%></td>
                    <td><%=oBExamen.getTipoExamen()%></td>
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
