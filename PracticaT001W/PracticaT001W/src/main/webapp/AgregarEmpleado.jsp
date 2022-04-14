<%-- 
    Document   : AgregarEmpleado
    Created on : 01-abr-2022, 20:16:02
    Author     : ayrton
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="Head.jsp"/>
<title>JSP Page</title>
<jsp:include page="Menu.jsp"/>
<jsp:useBean id="AgregarEmpleado" scope="session" class="com.test.bean.EmpleadoBean"/>
<jsp:useBean id="OpcionCargo" scope="session" class="com.test.bean.CargoBean"/>
<%
    if (request.getParameter("AgregarEmpleado") != null) {
        String mensaje = AgregarEmpleado.RegistrarEmpleado(request);
        out.print(mensaje);
    }
%>

<div class="col-md-8">
    <div class="container card" style="margin-top: 20px">
        <h1 style="text-align: center" class="card-title">Agregar Empleado</h1>
        <div class="card-body row">
            <div class="col-md-1"></div>
            <div class="col-md-10">
                <form>
                    <div class="row">
                        <div class="col-md-6">
                            <label>Nombre</label>
                            <input type="text" name="nombreEmpleado" class="form-control">
                        </div>
                        <div class="col-md-6">
                            <label>Apellido Paterno</label>
                            <input type="text" name="ApellidoPEmpleado" class="form-control">
                        </div>
                        <div class="col-md-6">
                            <label>Apellido Materno</label>
                            <input type="text" name="ApellidoMEmpleado" class="form-control">
                        </div>
                        <div class="col-md-3">
                            <label>Edad</label>
                            <input type="number" name="Edad" class="form-control">
                        </div>
                        <div class="col-md-3">
                            <label>C.I.</label>
                            <input type="number" name="CI" class="form-control">
                        </div>
                        <div class="col-md-3">
                            <label>Cargo</label>
                            <select name="Cargo" class="form-control custom-select">
                                <option selected>select</option>
                                <%=OpcionCargo.SelectCargo()%>
                            </select>
                        </div>
                        <div class="col-md-9">
                            <label>Direccion</label>
                            <input type="text" name="Direccion" class="form-control">
                        </div>
                        <div class="col-md-6">
                            <br>
                            <input type="submit" name="AgregarEmpleado" value="ACEPTAR" class="btn btn-info">
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</div>
</body>
</html>
