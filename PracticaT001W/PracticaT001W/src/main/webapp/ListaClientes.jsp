<%-- 
    Document   : ListaClientes
    Created on : 12-may-2022, 11:16:47
    Author     : ayrton
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="Head.jsp"/>
<title>JSP Page</title>
<jsp:include page="Menu.jsp"/>
<div class="col-md-8">
    <div class="container card" style="margin-top: 20px">
        <h1 style="text-align: center" class="card-title">Lista Clientes</h1>
        <div class="card-body row">
            <div class="col-md-2"></div>
            <div class="col-md-8">
                <table class="table table-responsive table-hover">
                    <jsp:useBean id="Cliente" scope="session" class="com.test.bean.ClienteBean"/>
                    <%
                        String codigo = request.getParameter("codCliente");
                        if (codigo != null) {
                            System.out.println("pasa");
                            String salida = Cliente.EliminarCliente(request, codigo);
                            out.print(salida);
                        }
                    %>
                    <thead>
                        <tr>
                            <th>Nombre Cliente</th>
                            <th>NIT / CI</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%=Cliente.ListaClientes()%>
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
