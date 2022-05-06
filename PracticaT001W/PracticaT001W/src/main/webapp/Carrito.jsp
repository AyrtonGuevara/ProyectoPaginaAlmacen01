<%-- 
    Document   : Carrito
    Created on : 27-abr-2022, 16:19:32
    Author     : ayrton
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>  
<!DOCTYPE html>
<jsp:include page="Head.jsp"/>
<title>JSP Page</title>
<jsp:include page="Menu.jsp"/>
<div class="col-md-8">
    <div class="container card" style="margin-top: 20px">
        <h1 style="text-align: center" class="card-title">Carrito</h1>
        <div class="card-body row">
            <div class="col-md-1"></div>
            <div class="col-md-10">
                <jsp:useBean id="pedido" scope="session" class="com.test.bean.PedidoBean" />
                <form>
                    <%
                        if (request.getParameter("PROV") != null) {}
                        
                    %>
                    <label>Proveedor</label>
                    <input type="text" value="<%=pedido.getPedidopojo().getRSproveedor()%>" disabled/>
                    <label>Proveedor</label>
                    <input type="date" name="fecha"/>
                    <table class="table table-responsive table-hover">
                        <thead>
                        <th>Producto</th>
                        <th>Cantidad</th>
                        <th>Costo Unitario</th>
                        <th>Precio</th>
                        </thead>
                        <tbody>
                            <%=pedido.getPedidopojo().getCarrito()%>
                        </tbody>
                    </table>
                    <input type="submit" name="Carrito" value="Aceptar" class="btn btn-info">
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
