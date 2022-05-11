<%-- 
    Document   : ListarPedidos
    Created on : 19-abr-2022, 17:15:39
    Author     : ayrton
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="Head.jsp"/>
<title>JSP Page</title>
<jsp:include page="Menu.jsp"/>
<div class="col-md-8">
    <div class="container card" style="margin-top: 20px">
        <h1 style="text-align: center" class="card-title">Lista Pedidos</h1>
        <div class="card-body row">
            <div class="col-md-1"></div>
            <div class="col-md-10">
                <jsp:useBean id="ListaPedido" scope="session" class="com.test.bean.PedidoBean"/>
                <table class="table table-responsive table-hover">
                    <thead>
                        <tr>
                            <th>Numero de Pedido</th>
                            <th>Proveedor</th>
                            <th>Producto</th>
                            <th>Fecha pedido</th>
                            <th>Cantidad</th>
                            <th>Coste</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%=ListaPedido.ListaPedidos()%>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>

</body>
</html>
