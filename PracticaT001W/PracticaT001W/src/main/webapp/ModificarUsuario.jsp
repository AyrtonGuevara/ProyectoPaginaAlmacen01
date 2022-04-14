<%-- 
    Document   : ModificarUsuario
    Created on : 12-abr-2022, 22:09:20
    Author     : ayrton
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="Head.jsp"/>
<title>JSP Page</title>
<jsp:include page="Menu.jsp"/>
<div class="col-md-8">
    <div class="container card" style="margin-top: 20px">
        <h1 style="text-align: center" class="card-title">Modificar Usuario</h1>
        <div class="card-body row">
            <div class="col-md-1"></div>
            <div class="col-md-10">
                <jsp:useBean id="modificarUsuario" scope="session" class="com.test.bean.UsuarioBean"/>
                <jsp:useBean id="selectEmpleado" scope="session" class="com.test.bean.EmpleadoBean"/>
                <jsp:useBean id="selectRol" scope="session" class="com.test.bean.RolBean"/>
                <%
                    String cod = request.getParameter("codUsuario");
                    modificarUsuario.MostrarUsuario(cod);
                    if (request.getParameter("Modificar") != null) {
                        String Mensaje = "";
                        Mensaje = modificarUsuario.ModificarUsuario(request, cod);
                        out.print(Mensaje);
                    }
                %>
                <form method="POST">
                    <div class="row">
                        <div class="col-md-3">
                            <label>Empleado</label>
                            <select name="empleado" class="form-control">
                                <option value="<%=modificarUsuario.getUsuariopojo().getEmpleadoUsuario()%>">select</option>
                                <%=selectEmpleado.selectEmpleado()%>
                            </select>
                        </div>
                        <div class="col-md-3">
                            <label>Rol</label>
                            <select name="rol" class="form-control">
                                <option value="<%=modificarUsuario.getUsuariopojo().getRolUsuario()%>">select</option>
                                <%=selectRol.SelectRol()%>
                            </select>
                        </div>
                        <div class="col-md-3">
                            <label>Nombre Usuario</label>
                            <input type="test" name="nombre" class="form-control" value="<%=modificarUsuario.getUsuariopojo().getNombreUsuario()%>">
                        </div>
                        <div class="col-md-3"></div>
                        <div class="col-md-3">
                            <br>
                            <input type="submit" name="Modificar" value="Modificar" class="btn btn-info">
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
