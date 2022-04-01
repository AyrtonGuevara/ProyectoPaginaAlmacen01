<%-- 
    Document   : ListarCargo
    Created on : 01-abr-2022, 10:19:06
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
        <h1>Lista de Categorias</h1>
        <table border="1">
            <jsp:useBean id="ListaCargoBean" scope="session" class="com.test.bean.CargoBean"/>
            <thead>
                <tr>
                    <th>categoria</th>
                </tr>
            </thead>
            <tbody>
                <%=ListaCargoBean.ListaCargo()%>
            </tbody>
        </table>
        <a href="index.jsp">inicio</a>
    </body>
</html>