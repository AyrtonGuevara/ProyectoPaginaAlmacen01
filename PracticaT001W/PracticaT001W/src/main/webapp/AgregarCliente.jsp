<%-- 
    Document   : AgregarCliente
    Created on : 12-may-2022, 10:38:01
    Author     : ayrton
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="Head.jsp"/>
<title>Agregar Cliente</title>
<jsp:include page="Menu.jsp"/>
<jsp:useBean id="cliente" scope="session" class="com.test.bean.ClienteBean"/>
<%
        if (request.getParameter("AgregarCliente")!=null) {
                String Mensaje=cliente.RegistrarCliente(request);
                out.print(Mensaje);
            }
%>
<div class="col-md-8">
    <div class="container card" style="margin-top: 20px">
        <h1 style="text-align: center" class="card-title">Agregar Cliente</h1>
        <div class="card-body row">
            <div class="col-md-1"></div>
            <div class="col-md-10">
                <form>
                    <div class="row">
                        <div class="col-md-6">
                            <label>Nombre Cliente</label>
                            <input type="texr" name="NombreCliente" class="form-control">
                        </div>
                        <div class="col-md-6">
                            <label>Apellido Cliente</label>
                            <input type="texr" name="ApellidoCliente" class="form-control">
                        </div>
                        <div class="col-md-12">
                            <label>NIT/CI Cliente</label>
                            <input type="texr" name="NITCI" class="form-control">
                        </div>
                        <div class="col-md-6"><br>
                            <input type="submit" value="ACEPTAR" name="AgregarCliente" class="btn btn-info">
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
