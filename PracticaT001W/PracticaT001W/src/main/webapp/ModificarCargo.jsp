<%-- 
    Document   : ModificarCargo
    Created on : 12-abr-2022, 15:33:35
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
        <h1>Modificar Cargo</h1>
        <jsp:useBean id="modificarCargo" scope="session" class="com.test.bean.CargoBean"/>
        <%
            //rescatar codigo de cargo
            String codCargo=request.getParameter("codCargo");
            //buscando cargo
            modificarCargo.MostrarCargo(codCargo);
            if (request.getParameter("Modificar")!=null) {
                    String salida=modificarCargo.ModidficarCargo(request, codCargo);
                    out.print(salida);
                }
        %>
        <form method="POST">
            <input type="text" name="nombreCargo" value="<%=modificarCargo.getModCargo().getNombreCargo()%>">
            <br>
            <input type="submit" name="Modificar" value="Modificar">
        </form>
    </body>
</html>
