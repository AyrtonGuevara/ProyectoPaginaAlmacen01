<%-- 
    Document   : ModificarCliente
    Created on : 12-may-2022, 11:18:58
    Author     : ayrton
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="Head.jsp"/>
<title>JSP Page</title>
<jsp:include page="Menu.jsp"/>
<div class="col-md-8">
    <div class="container card" style="margin-top: 20px">
        <h1 style="text-align: center" class="card-title">Modificar Cliente</h1>
        <div class="card-body row">
            <div class="col-md-1"></div>
            <div class="col-md-10">
                <jsp:useBean id="Cliente" scope="session" class="com.test.bean.ClienteBean"/>
                <%
                    String codigoCliente=request.getParameter("codCliente");
                    Cliente.MostrarCliente(codigoCliente);
                    if (request.getParameter("Modificar")!=null) {
                            String Mensaje=Cliente.ModificarCliente(request, codigoCliente);
                            out.print(Mensaje);
                        }
                %>
                <form method="POST">
                    <div class="row">
                        <div class="col-md-6">
                            <label>Nombre Cliente</label>
                            <input type="text" name="NombreCliente" class="form-control" value="<%=Cliente.getClientepojo().getNombreCliente()%>">
                        </div>
                        <div class="col-md-6">
                            <label>Apellido Cliente</label>
                            <input type="text" name="ApellidoCliente" class="form-control" value="<%=Cliente.getClientepojo().getApellidoCliente()%>">
                        </div>
                        <div class="col-md-6">
                            <label>NIT / CI Cliente</label>
                            <input type="text" name="nitci" class="form-control" value="<%=Cliente.getClientepojo().getNITCI()%>">
                        </div>
                        <div class="col-md-6">
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
