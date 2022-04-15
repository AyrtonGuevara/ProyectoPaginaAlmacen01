<%-- 
    Document   : ListaProveedores
    Created on : 14-abr-2022, 16:01:40
    Author     : ayrton
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="Head.jsp"/>
<title>JSP Page</title>
<jsp:include page="Menu.jsp"/>
<div class="col-md-8">
    <div class="container card" style="margin-top: 20px">
        <h1 style="text-align: center" class="card-title">Lista Proveedores</h1>
        <div class="card-body row">
            <div class="col-md-1"></div>
            <div class="col-md-10">
                <table class="table table-responsive table-hover">
                    <jsp:useBean id="ListarProveedores" scope="session" class="com.test.bean.ProveedorBean"/>
                    <%
                        String codigo=request.getParameter("codProveedor");
                        if (codigo!=null) {
                                String Salida=ListarProveedores.EliminarProveedor(request, codigo);
                                out.print(Salida);
                            }
                    %>
                    <thead>
                    <th>Razon Social</th>
                    <th>Contacto</th>
                    <th>Telefono</th>
                    <th>Direccion</th>
                    <th></th>
                    <th></th>
                    </thead>
                    <tbody>
                        <%=ListarProveedores.ListarProveedores()%>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
<script>
    function VerificacionEliminar(){
        var varcodigo= confirm("¿seguro?");
        console.log("codigo"+varcodigo);
        return varcodigo;
    }
</script>
</body>
</html>
