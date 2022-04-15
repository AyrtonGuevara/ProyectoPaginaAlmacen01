<%-- 
    Document   : ModificarEmpleado
    Created on : 12-abr-2022, 20:22:35
    Author     : ayrton
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="Head.jsp"/>
<title>JSP Page</title>
<jsp:include page="Menu.jsp"/>
<div class="col-md-8">
    <div class="container card" style="margin-top: 20px">
        <h1 style="text-align: center" class="card-title">Modificar Empleado</h1>
        <div class="card-body row">
            <div class="col-md-1"></div>
            <div class="col-md-10">
                <jsp:useBean id="modificarEmpleado" scope="session" class="com.test.bean.EmpleadoBean"/>
                <jsp:useBean id="Opcioncargo" scope="session" class="com.test.bean.CargoBean"/>
                <%
                    String cod = request.getParameter("codEmpleado");
                    modificarEmpleado.MostrarEmpleado(cod);
                    if (request.getParameter("Modificar") != null) {
                        String Mensaje = "";
                        Mensaje = modificarEmpleado.ModificarEmpleado(request, cod);
                        out.print(Mensaje);
                    }
                %>
                <form method="POST">
                    <div class="row">
                        <div class="col-md-6">
                            <label>Nombre</label>
                            <input type="text" name="nombre" class="form-control" value="<%=modificarEmpleado.getEmpleadopojo().getNombreEmpleado()%>">
                        </div>
                        <div class="col-md-6">
                            <label>Apellido Paterno</label>
                            <input type="text" name="appaterno" class="form-control" value="<%=modificarEmpleado.getEmpleadopojo().getApellidoPaterno()%>">
                        </div>
                        <div class="col-md-6">
                            <label>Apellido Materno</label>
                            <input type="text" name="apmaterno" class="form-control" value="<%=modificarEmpleado.getEmpleadopojo().getApellidoMaterno()%>">
                        </div>
                        <div class="col-md-3">
                            <label>Cargo</label>
                            <select name="cargo" class="form-control">
                                <option value="<%=modificarEmpleado.getEmpleadopojo().getCargoEmpleado()%>">select</option>
                                <%=Opcioncargo.SelectCargo()%>
                            </select>
                        </div>
                        <div class="col-md-3">
                            <label>Edad</label>
                            <input type="text" name="edad" class="form-control" value="<%=modificarEmpleado.getEmpleadopojo().getEdadEmpleado()%>">
                        </div>
                        <div class="col-md-9">
                            <label>Direccion</label>
                            <input type="text" name="direccion" class="form-control" value="<%=modificarEmpleado.getEmpleadopojo().getDireccionEmpleado()%>">
                        </div>
                        <div class="col-md-3">
                            <label>C.I.</label>
                            <input type="text" name="ci" class="form-control" value="<%=modificarEmpleado.getEmpleadopojo().getCIEmpleado()%>">
                        </div>
                        <div class="col-md-3">
                            <br>
                            <input type="submit" name="Modificar" value="Modificar" class="btn btn-info">
                        </div>
                        </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
