<%-- 
    Document   : ListarProducto
    Created on : 15-abr-2022, 15:51:37
    Author     : ayrton
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="Head.jsp"/>
<title>JSP Page</title>
<jsp:include page="Menu.jsp" />
<div class="col-md-8">
    <div class="container card" style="margin-top: 20px">
        <h1 style="text-align: center" class="card-title">Lista Productos</h1>
        <div class="card-body row">
            <div class="col-md-1"></div>
            <div class="col-md-10">
                <table class="table table-responsive table-hover">
                    <jsp:useBean id="ListarProducto" scope="session" class="com.test.bean.ProductoBean" />
                    <%
                        String cod = request.getParameter("codProducto");
                        if (cod != null) {
                            String Mensaje = ListarProducto.EliminarProducto(request, cod);
                            out.print(Mensaje);
                        }
                    %>
                    <thead>
                        <tr>
                            <th>Nombre Producto</th>
                            <th>Descripcion </th>
                            <th>Costo/U</th>
                            <th>Stock</th>
                            <th>Proveedor</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%=ListarProducto.ListaProducto()%>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
<script>
    funcion VerificarProducto(){
        var codigo2 = confirm("¿seguro?");
        console.log("codigo2" + codigo2);
                return codigo2;
    }
</script>
</body>
</html>
