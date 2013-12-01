<%-- 
    Document   : Mensaje
    Created on : 29/11/2013, 11:05:27 AM
    Author     : davis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Mensaje</h1>
        <%= request.getParameter("men")%>
        <a href="index.jsp">Volver al inicio</a>
        <h1>Mensaje</h1>
    </body>
</html>
