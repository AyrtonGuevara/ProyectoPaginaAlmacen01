<%-- 
    Document   : ListarCargo
    Created on : 01-abr-2022, 10:19:06
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
            <div class="col-md-3"></div>
            <div class="col-md-6">
                <table class="table table-responsive table-hover">
                    <jsp:useBean id="ListaCargoBean" scope="session" class="com.test.bean.CargoBean"/>
                    <%
                        String codCargo = request.getParameter("codCargo");
                        if (codCargo != null) {
                            String Salida = ListaCargoBean.EliminarCargo(request, codCargo);
                            out.print(Salida);
                        }
                    %>
                    <thead>
                        <tr>
                            <th>categoria</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%=ListaCargoBean.ListaCargo()%>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
<script >
    function ConfirmarEliminacion() {
        var varcon = confirm("¿seguro?");
        console.log('varConfirm' + varcon);
        return varcon;
    }
</script>
</body>
</html>