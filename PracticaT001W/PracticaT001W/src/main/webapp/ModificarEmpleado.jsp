<%-- 
    Document   : ModificarEmpleado
    Created on : 12-abr-2022, 20:22:35
    Author     : ayrton
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:useBean id="modificarEmpleado" scope="session" class="com.test.bean.EmpleadoBean"/>
        <jsp:useBean id="Opcioncargo" scope="session" class="com.test.bean.CargoBean"/>
        <%
            String cod=request.getParameter("codEmpleado");
            modificarEmpleado.MostrarEmpleado(cod);
            if (request.getParameter("Modificar")!=null) {
                    String Mensaje="";
                    Mensaje = modificarEmpleado.ModificarEmpleado(request,cod);
                    out.print(Mensaje);
                }
        %>
        <h1>Modificar Empleado</h1>
        <form method="POST">
            <label>Cargo</label>
            <select name="cargo">
                <option value="<%=modificarEmpleado.getEmpleadopojo().getCargoEmpleado()%>">select</option>
                <%=Opcioncargo.SelectCargo()%>
            </select>
            <label>Nombre</label>
            <input type="text" name="nombre" value="<%=modificarEmpleado.getEmpleadopojo().getNombreEmpleado()%>">
            <label>Apellido Paterno</label>
            <input type="text" name="appaterno" value="<%=modificarEmpleado.getEmpleadopojo().getApellidoPaterno()%>">
            <label>Apellido Materno</label>
            <input type="text" name="apmaterno" value="<%=modificarEmpleado.getEmpleadopojo().getApellidoMaterno()%>">
            <label>Edad</label>
            <input type="text" name="edad" value="<%=modificarEmpleado.getEmpleadopojo().getEdadEmpleado()%>">
            <label>Direccion</label>
            <input type="text" name="direccion" value="<%=modificarEmpleado.getEmpleadopojo().getDireccionEmpleado()%>">
            <label>C.I.</label>
            <input type="text" name="ci" value="<%=modificarEmpleado.getEmpleadopojo().getCIEmpleado()%>">
            <input type="submit" name="Modificar" value="Modificar">
        </form>
    </body>
</html>
