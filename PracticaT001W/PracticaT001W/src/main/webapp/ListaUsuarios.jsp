<%-- 
    Document   : ListaUsuarios
    Created on : 11-abr-2022, 20:01:14
    Author     : ayrton
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="Head.jsp"/>
<title>JSP Page</title>
<jsp:include page="Menu.jsp"/>
<div class="col-md-8">
    <div class="container card" style="margin-top: 20px">
        <h1 style="text-align: center" class="card-title">Lista Usuarios</h1>
        <div class="card-body row">
            <div class="col-md-2"></div>
            <div class="col-md-8">
                <table class="table table-responsive table-hover">
                    <jsp:useBean id="ListaUsuarios" scope="session" class="com.test.bean.UsuarioBean"/>
                    <%
                        String codigo = request.getParameter("codUsuario");
                        if (codigo != null) {
                            String Mensaje = "";
                            Mensaje = ListaUsuarios.EliminarUsuario(request, codigo);
                            out.print(Mensaje);
                        }
                    %>
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
            </div>
        </div>
    </div>
</div>
</div>
<script>
    function ConfirmarEliminacion() {
        var varveri = confirm("¿seguro?");
        console.log("VarConfirmacion" + varveri);
        return varveri;
    }
</script>
</body>
</html>
