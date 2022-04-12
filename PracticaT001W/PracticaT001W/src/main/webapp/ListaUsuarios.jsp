<%-- 
    Document   : ListaUsuarios
    Created on : 11-abr-2022, 20:01:14
    Author     : ayrton
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Lista Usuarios</h1>
        <table border="1">
            <jsp:useBean id="ListaUsuarios" scope="session" class="com.test.bean.UsuarioBean"/>
            <thead>
                <tr>
                    <th>Empleado</th>
                    <th>Rol</th>
                    <th>Usuario</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <%=ListaUsuarios.ListaUsuario()%>
                </tr>
            </tbody>
        </table>
                <a href="index.jsp"></a>
    </body>
</html>
