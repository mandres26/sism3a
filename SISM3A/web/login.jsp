<%-- 
    Document   : login
    Created on : 01/12/2013, 01:19:58 AM
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
        <div class="contenido">
            <center>
                <fieldset style="width: 300px">
                    <legend>Datos Usuario</legend>
                    <form action="SLogin" method="post">
                        <table border="0">
                            <tbody>
                                <tr>
                                    <td>usuario</td>
                                    <td><input type="text" name="txtUsuario" value="" /></td>
                                </tr>
                                <tr>
                                    <td>password</td>
                                    <td><input type="password" name="txtPassword" value="" /></td>
                                </tr>
                                <tr>
                                    <td><input type="submit" value="Login" /></td>
                                </tr>
                            </tbody>
                        </table>

                    </form>
                </fieldset>
            </center>

        </div>
    </body>
</html>
