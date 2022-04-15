<%-- 
    Document   : AgregarProveedor
    Created on : 14-abr-2022, 15:15:18
    Author     : ayrton
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="Head.jsp"/>
<title>JSP Page</title>
<jsp:include page="Menu.jsp" />
<div class="col-md-8">
    <div class="card container" style="margin-top: 20px">
        <h1 style="text-align: center" class="card-title">Agregar Proveedor</h1>
        <div class="card-body row">
            <div class="col-md-1"></div>
            <div class="col-md-10">
                <form>
                    <jsp:useBean id="AgregarProveedor" scope="session" class="com.test.bean.ProveedorBean" />
                    <%
                        if (request.getParameter("agregar")!=null) {
                                String mensaje="";
                                mensaje=AgregarProveedor.AgregarProveedor(request);
                                out.print(mensaje);
                            }
                    %>
                    <div class="row">
                        <div class="col-md-6">
                            <label>Razon Social</label>
                            <input type="text" name="RazonSocial" class="form-control"/>
                        </div>
                        <div class="col-md-6">
                            <label>Contacto</label>
                            <input type="text" name="Contacto" class="form-control"/>
                        </div>
                        <div class="col-md-3">
                            <label>Telefono</label>
                            <input type="text" name="Telefono" class="form-control"/>
                        </div>
                        <div class="col-md-9">
                            <label>Dirección</label>
                            <input type="text" name="Direccion" class="form-control"/>
                        </div>
                        <div class="col-md-3">
                            <br>
                            <input type="submit" name="agregar" value="ACEPTAR" class="btn btn-info">
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>
</html>
