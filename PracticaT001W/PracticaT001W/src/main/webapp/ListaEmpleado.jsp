<%-- 
    Document   : ListaEmpleado
    Created on : 07-abr-2022, 12:01:35
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
        <h1>Lista de Empleados</h1>
        <table border="1">
            <jsp:useBean id="ListaEmpleado" scope="session" class="com.test.bean.EmpleadoBean"/>
            <thead>
                <tr>
                    <th>Cargo</th>
                    <th>Nombre</th>
                    <th>Apellido</th>
                    <th>Edad</th>
                    <th>Direccion</th>
                    <th>C.I.</th>
                </tr>
            </thead>
            <tbody>
               <%=ListaEmpleado.ListaEmpleado()%>
            </tbody>
        </table>

    </body>
</html>
