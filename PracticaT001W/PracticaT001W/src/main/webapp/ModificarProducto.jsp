<%-- 
    Document   : ModificarProducto
    Created on : 15-abr-2022, 15:51:49
    Author     : ayrton
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="Head.jsp"/>
<title>JSP Page</title>
<jsp:include page="Menu.jsp"/>

<div class="col-md-8">
    <div class="container card" style="margin-top: 20px">
        <h1 style="text-align: center" class="card-title">Modificar Producto</h1>
        <div class="card-body row">
            <div class="col-md-1"></div>
            <div class="col-md-10">
                <form method="POST">
                    <jsp:useBean id="ModificarProducto" scope="session" class="com.test.bean.ProductoBean"/>
                    <jsp:useBean id="SelectProveedor" scope="session" class="com.test.bean.ProveedorBean"/>
                    <%
                        String cod=request.getParameter("codProducto");
                        ModificarProducto.MostrarProducto(cod);
                        if (request.getParameter("Modificar")!=null) {
                                String Mensaje=ModificarProducto.ModificarProducto(request, cod);
                                out.print(Mensaje);
                            }
                    %>
                    <div class="row">
                        <div class="col-md-6">
                            <label>Nombre</label>
                            <input type="text" name="NombreProducto" class="form-control" value="<%=ModificarProducto.getProductopojo().getNombreProducto()%>">
                        </div>
                        <div class="col-md-3">
                            <label>Proveedor</label>
                            <select name="Proveedor" class="form-control">
                                <option value="<%=ModificarProducto.getProductopojo().getIdProveedor()%>">select</option>
                                <%=SelectProveedor.SelectProveedor()%>
                            </select>
                        </div>
                        <div class="col-md-3">
                            <label>Costo/u</label>
                            <input type="number" name="Costo" class="form-control" value="<%=ModificarProducto.getProductopojo().getCostoProducto()%>">
                        </div>
                        <div class="col-md-9">
                            <label>Descripcion</label>
                            <input type="text" name="descripcion" class="form-control" value="<%=ModificarProducto.getProductopojo().getDescripcion()%>">
                        </div>
                        <div class="col-md-3">
                            <label>Stock</label>
                            <input type="number" name="Stock" class="form-control" value="<%=ModificarProducto.getProductopojo().getStockProducto()%>">
                        </div>
                        <div class="col-md-6">
                            <br>
                            <input type="submit" name="Modificar" value="ACEPTAR" class="btn btn-info     "/>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
    </body>
</html>
