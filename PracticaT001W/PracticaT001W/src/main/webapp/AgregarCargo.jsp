<%-- 
    Document   : AgregarCargo
    Created on : 31-mar-2022, 19:32:41
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
        <jsp:useBean id="Cargo" scope="session" class="com.test.bean.CargoBean"/>
        <%
            if (request.getParameter("AgregarCargo")!=null) {
                    String mensaje=Cargo.RegistrarCargo(request);
                    out.print(mensaje);
                }
        %>
        <h1>Agregar cargo</h1>
        <div>
            <form>
                <input type="texr" name="NombreCargo">
                <input type="submit" value="ACEPTAR" name="AgregarCargo">
            </form>
        </div>
        <a href="index.jsp">Inicio</a>
    </body>
</html>
