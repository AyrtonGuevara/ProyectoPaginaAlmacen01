<%-- 
    Document   : ModificarCargo
    Created on : 12-abr-2022, 15:33:35
    Author     : ayrton
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="Head.jsp"/>
<title>JSP Page</title>
<jsp:include page="Menu.jsp"/>
<div class="col-md-8">
    <div class="container card" style="margin-top: 20px">
        <h1 style="text-align: center" class="card-title">Modificar Cargo</h1>
        <div class="card-body row">
            <div class="col-md-1"></div>
            <div class="col-md-10">
                <jsp:useBean id="modificarCargo" scope="session" class="com.test.bean.CargoBean"/>
                <%
                    //rescatar codigo de cargo
                    String codCargo = request.getParameter("codCargo");
                    //buscando cargo
                    modificarCargo.MostrarCargo(codCargo);
                    if (request.getParameter("Modificar") != null) {
                        String salida = modificarCargo.ModidficarCargo(request, codCargo);
                        out.print(salida);
                    }
                %>
                <form method="POST">
                    <div class="row">
                        <div class="col-md-3"></div>
                        <div class="col-md-6">
                            <label>Nombre Cargo</label>
                            <input type="text" name="nombreCargo" class="form-control" value="<%=modificarCargo.getModCargo().getNombreCargo()%>">
                        </div>
                        <div class="col-md-6">
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
