<%-- 
    Document   : AgregarCargo
    Created on : 31-mar-2022, 19:32:41
    Author     : ayrton
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="Head.jsp"/>
<title>JSP Page</title>
<jsp:include page="Menu.jsp"/>
<jsp:useBean id="AgregarCargoBean" scope="session" class="com.test.bean.CargoBean"/>
<%
    if (request.getParameter("AgregarCargo") != null) {
        String mensaje = AgregarCargoBean.RegistrarCargo(request);
        out.print(mensaje);
    }
%>
<div class="col-md-8">
    <div class="container card" style="margin-top: 20px">
        <h1 style="text-align: center" class="card-title">Agregar Cargo</h1>
        <div class="card-body row">
            <div class="col-md-1"></div>
            <div class="col-md-10">
                <form>
                    <div class="row">
                        <div class="col-md-1"></div>
                        <div class="col-md-10">
                            <label>Cargo</label>
                            <input type="texr" name="NombreCargo" class="form-control">
                        </div>
                        <div class="col-md-6"><br>
                            <input type="submit" value="ACEPTAR" name="AgregarCargo" class="btn btn-info">
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
