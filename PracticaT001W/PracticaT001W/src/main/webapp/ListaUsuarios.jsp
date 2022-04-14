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
        <script type="text/javascript">
            function ConfirmarEliminacion (){
                var varveri=confirm("¿seguro?");
                console.log("VarConfirmacion"+varveri);
                return varveri;
            }
        </script>
    </head>
    <body>
        <h1>Lista Usuarios</h1>
        <table border="1">
            <jsp:useBean id="ListaUsuarios" scope="session" class="com.test.bean.UsuarioBean"/>
            <%
                String codigo=request.getParameter("codUsuario");
                if (codigo!=null) {
                        String Mensaje="";
                        Mensaje=ListaUsuarios.EliminarUsuario(request, codigo);
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
                <a href="index.jsp">inicio</a>
    </body>
</html>
