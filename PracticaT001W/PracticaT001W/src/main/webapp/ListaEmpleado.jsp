<%-- 
    Document   : ListaEmpleado
    Created on : 07-abr-2022, 12:01:35
    Author     : ayrton
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="Head.jsp"/>
<title>JSP Page</title>
<jsp:include page="Menu.jsp"/>
<div class="col-md-8">
    <div class="container card" style="margin-top: 20px">
        <h1 style="text-align: center" class="card-title">Lista Empleados</h1>
        <div class="card-body row">
            <div class="col-md-12">
                <table class="table table-responsive table-hover">
                    <jsp:useBean id="ListaEmpleado" scope="session" class="com.test.bean.EmpleadoBean"/>
                    <%
                        String codigo = request.getParameter("codEmpleado");
                        if (codigo != null) {
                            String salida = ListaEmpleado.EliminarEmpleado(request, codigo);
                            out.print(salida);
                        }
                    %>
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
            </div>
        </div>
    </div>
</div>

<script >
    function ConfirmarEliminacion() {
        var varcon = confirm("¿Seguro?");
        console.log("varConfirmacion" + varcon);
        return varcon;
    }
</script>
</body>
</html>
