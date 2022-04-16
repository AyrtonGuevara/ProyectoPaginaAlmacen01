<%-- 
    Document   : AgregarProducto
    Created on : 15-abr-2022, 15:51:24
    Author     : ayrton
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="Head.jsp"/>
<title>JSP Page</title>
<jsp:include page="Menu.jsp"/>

<div class="col-md-8">
    <div class="container card" style="margin-top: 20px">
        <h1 style="text-align: center" class="card-title">Agregar Producto</h1>
        <div class="card-body row">
            <div class="col-md-1"></div>
            <div class="col-md-10">
                <form>
                    <jsp:useBean id="agregarProducto" scope="session" class="com.test.bean.ProductoBean"/>
                    <jsp:useBean id="selectProveedor" scope="session" class="com.test.bean.ProveedorBean"/>
                    <%
                        if (request.getParameter("Agregar")!=null) {
                                String mensaje=agregarProducto.AgregarProducto(request);
                                out.print(mensaje);
                            }
                    %>
                    <div class="row">
                        <div class="col-md-6">
                            <label>Nombre</label>
                            <input type="text" name="NombreProducto" class="form-control">
                        </div>
                        <div class="col-md-3">
                            <label>Proveedor</label>
                            <select name="Proveedor" class="form-control">
                                <option selected>Select</option>
                                <%=selectProveedor.SelectProveedor()%>
                            </select>
                        </div>
                        <div class="col-md-3">
                            <label>Costo/u</label>
                            <input type="number" name="Costo" class="form-control">
                        </div>
                        <div class="col-md-12">
                            <label>Descripcion</label>
                            <input type="text" name="Descripcion" class="form-control">
                        </div>
                        <div class="col-md-6">
                            <br>
                            <input type="submit" name="Agregar" value="ACEPTAR" class="btn btn-info     "/>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
