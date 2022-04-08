<%-- 
    Document   : AgregarUsuario
    Created on : 07-abr-2022, 14:41:53
    Author     : ayrton
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">  
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:useBean id="AgregarUsuario" scope="session" class="com.test.bean.UsuarioBean"/>
        <jsp:useBean id="selectEmpleado" scope="session" class="com.test.bean.EmpleadoBean"/>
        <%
            if (request.getParameter("registrarUsuario")!=null) {
                    String mensaje=AgregarUsuario.AgregarUsuario(request);
                    out.print(mensaje);
                }
        %>
        <h1>Agregar Usuario</h1>
        <form>
            <label>Empleado</label>
            <select name="empleado" class="">
                <option selected>select</option>
                <%=selectEmpleado.selectEmpleado()%>
            </select>
            <label>Usuario</label>
            <input type="text" name="Usuario"/>
            <label>Contraseña</label>
            <input type="password" name="contrasena"/>
            <label>Repita la Contraseña</label>
            <input type="password" name="contrasena2"/>
            <input type="submit" value="REGISTRAR" name="registrarUsuario">
        </form>
        <a href="index.jsp">inicio</a>
    </body>
</html>
