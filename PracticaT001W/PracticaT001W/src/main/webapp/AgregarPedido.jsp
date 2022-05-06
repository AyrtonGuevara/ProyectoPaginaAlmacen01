<%-- 
    Document   : AgregarPedido
    Created on : 19-abr-2022, 17:15:29
    Author     : ayrton
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="Head.jsp"/>
<title>JSP Page</title>
<jsp:include page="Menu.jsp"/>
<div class="col-md-8">
    <div class="container card" style="margin-top: 20px">
        <h1 style="text-align: center" class="card-title">Realizar Pedido</h1>
        <div class="card-body row">
            <div class="col-md-1"></div>
            <div class="col-md-10">
                <jsp:useBean id="proveedor" scope="session" class="com.test.bean.ProveedorBean" />
                <jsp:useBean id="pedido" scope="session" class="com.test.bean.PedidoBean" />
                <form method="POST">
                    <div class="row">
                        <div class="col-md-6">
                            <select name="proveedor" class="form-control">
                                <option selected>select</option>
                                <%=proveedor.SelectProveedor()%>
                            </select>
                        </div>
                        <div class="col-md-6">
                            <input type="submit" value="Buscar" name="PROV" class="btn btn-info">
                        </div>
                        <%
                            if (request.getParameter("PROV") != null) {
                        %>
                        <br>
                        <table class="table table-responsive table-hover">
                            <thead>
                            <th>Proveedor</th>
                            <th>Producto</th>
                            <th>Stock Disponible</th>
                            <th>Cantidad del Pedido</th>
                            </thead>
                            <tbody>
                                <%=pedido.ListaProductoPedido(request)%>
                            </tbody>
                        </table>
                        <input type="submit" name="Carrito" value="Aceptar" class="btn btn-info">
                        <%
                            }
                            if (request.getParameter("Carrito") != null) {
                                int proveedor1 = pedido.getPedidopojo().getProveedor();
                                int Contador = pedido.getPedidopojo().getCantidadProductos();
                                pedido.MostrarCarrito(request, proveedor1, Contador);
                                response.sendRedirect("Carrito.jsp");

                            }
                        %>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
