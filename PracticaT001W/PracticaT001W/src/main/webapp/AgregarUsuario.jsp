<%-- 
    Document   : AgregarUsuario
    Created on : 07-abr-2022, 14:41:53
    Author     : ayrton
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="Head.jsp"/>
<title>JSP Page</title>
<jsp:include page="Menu.jsp"/>
<jsp:useBean id="AgregarUsuario" scope="session" class="com.test.bean.UsuarioBean"/>
<jsp:useBean id="selectEmpleado" scope="session" class="com.test.bean.EmpleadoBean"/>
<jsp:useBean id="selectRol" scope="session" class="com.test.bean.RolBean"/>
<%
    if (request.getParameter("registrarUsuario") != null) {
        String mensaje = AgregarUsuario.AgregarUsuario(request);
        out.print(mensaje);
    }
%>
<div class="col-md-8">
    <div class="container card" style="margin-top: 20px">
        <h1 style="text-align: center" class="card-title">Agregar Usuario</h1>
        <div class="card-body row">
            <div class="col-md-1"></div>
            <div class="col-md-10">
                <form>
                    <div class="row">
                        <div class="col-md-3">
                            <label>Empleado</label>
                            <select name="empleado" class="form-control">
                                <option selected>select</option>
                                <%=selectEmpleado.selectEmpleado()%>
                            </select>
                        </div>
                            <div class="col-md-3">
                            <label>Rol</label>
                            <select name="rol" class="form-control">
                                <option value="<%=selectRol.SelectRol()%>">select</option>
                                <%=selectRol.SelectRol()%>
                            </select>
                        </div>
                        <div class="col-md-6">
                            <label>Usuario</label>
                            <input type="text" name="Usuario" class="form-control"/>
                        </div>
                        <div class="col-md-6">
                            <label>Contraseña</label>
                            <input type="password" name="contrasena" class="form-control"/>
                        </div>
                        <div class="col-md-6">
                            <label>Repita la Contraseña</label>
                            <input type="password" name="contrasena2" class="form-control"/>
                        </div>
                        <div class="col-md-6"><br>
                            <input type="submit" value="REGISTRAR" name="registrarUsuario" class="btn btn-info">
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
