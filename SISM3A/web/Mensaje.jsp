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
    <center>
        <div>
            <h1>Error de login</h1>
            <%= request.getParameter("men")%>
            <p>=============================</p>
            <a href="login.jsp">Reintentar</a>
            <p>=============================</p>            
            <h4>¡¡¡Tu usuario y/o password es incorrecto!!!</h4>
        </div>
    </center>
</body>
</html>
