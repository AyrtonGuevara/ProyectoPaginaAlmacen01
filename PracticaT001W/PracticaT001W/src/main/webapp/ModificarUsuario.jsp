<%-- 
    Document   : ModificarUsuario
    Created on : 12-abr-2022, 22:09:20
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
        <jsp:useBean id="modificarUsuario" scope="session" class="com.test.bean.UsuarioBean"/>
        <jsp:useBean id="selectEmpleado" scope="session" class="com.test.bean.EmpleadoBean"/>
        <jsp:useBean id="selectRol" scope="session" class="com.test.bean.RolBean"/>
        <%
            String cod=request.getParameter("codUsuario");
            modificarUsuario.MostrarUsuario(cod);
            if (request.getParameter("Modificar")!=null) {
                    String Mensaje="";
                    Mensaje = modificarUsuario.ModificarUsuario(request,cod);
                    out.print(Mensaje);
                }
        %>
        <h1>Modificar Usuario</h1>
        <form method="POST">
            <label>Empleado</label>
            <select name="empleado">
                <option value="<%=modificarUsuario.getUsuariopojo().getEmpleadoUsuario()%>">select</option>
                <%=selectEmpleado.selectEmpleado()%>
            </select>
            <label>Rol</label>
            <select name="rol">
                <option value="<%=modificarUsuario.getUsuariopojo().getRolUsuario()%>">select</option>
                <%=selectRol.SelectRol()%>
            </select>
            <label>Nombre Usuario</label>
            <input type="test" name="nombre" value="<%=modificarUsuario.getUsuariopojo().getNombreUsuario()%>">
            <input type="submit" name="Modificar" value="Modificar">
        </form>
    </body>
</html>
