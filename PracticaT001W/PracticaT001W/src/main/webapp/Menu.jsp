<%-- 
    Document   : Menu
    Created on : 13-abr-2022, 19:39:00
    Author     : ayrton
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<div class="container-fluid bg-info">
    <ul class="nav">
        <li class="nav-item">
            <a class="nav-link btn btn-info" href="index.jsp">Inicio</a>
        </li>
        <li class="nav-item ml-auto">
            <a class="nav-link float-left btn btn-info "href="#">Salir</a>
        </li>
    </ul>
</div>
<div class="row">
    <div class="col-md-2">
        <div id="accordion">
            <div class=" card ">
                <div class=" card card-header">
                    <a class="card-link btn btn-light" data-toggle="collapse" href="#uno">Cargo</a>
                </div>
                <div id="uno" class="collapse" data-parent="#accordion">
                    <div class="card-body" style="padding: 0px">
                        <ul class="list-group-flush" style="padding: 0px">
                            <li class="list-group-item list-group-item-action"><a href="AgregarCargo.jsp" class="btn btn-light nav-accordion">Agregar cargo</a></li>
                            <li class="list-group-item list-group-item-action"><a href="ListarCargo.jsp" class="btn btn-light nav-accordion">Listar cargos</a></li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class=" card ">
                <div class=" card card-header">
                    <a class="card-link btn btn-light" data-toggle="collapse" href="#dos">Empleado</a>
                </div>
                <div id="dos" class="collapse" data-parent="#accordion">
                    <div class="card-body " style="padding: 0px">
                        <ul class="list-group-flush" style="padding: 0px">
                            <li class="list-group-item list-group-item-action"><a href="AgregarEmpleado.jsp" class="btn btn-light nav-accordion">Agregar Empleado</a></li>
                            <li class="list-group-item list-group-item-action"><a href="ListaEmpleado.jsp" class="btn btn-light nav-accordion">Lista Empleados</a></li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class=" card ">
                <div class=" card card-header">
                    <a class="card-link btn btn-light" data-toggle="collapse" href="#tres">Usuario</a>
                </div>
                <div id="tres" class="collapse" data-parent="#accordion">
                    <div class="card-body" style="padding: 0px">
                        <ul class="list-group-flush" style="padding: 0px">
                            <li class="list-group-item list-group-item-action"><a href="AgregarUsuario.jsp" class="btn btn-light nav-accordion">Agregar Usuario</a></li>
                            <li class="list-group-item list-group-item-action"><a href="ListaUsuarios.jsp" class="btn btn-light nav-accordion">Listar Usuario</a></li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class=" card ">
                <div class=" card card-header">
                    <a class="card-link btn btn-light" data-toggle="collapse" href="#cuatro">Proveedor</a>
                </div>
                <div id="cuatro" class="collapse" data-parent="#accordion">
                    <div class="card-body" style="padding: 0px">
                        <ul class="list-group-flush" style="padding: 0px">
                            <li class="list-group-item list-group-item-action"><a href="AgregarProveedor.jsp" class="btn btn-light nav-accordion">Agregar Proveedor</a></li>
                            <li class="list-group-item list-group-item-action"><a href="ListaProveedores.jsp" class="btn btn-light nav-accordion">Listar Proveedor</a></li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class=" card ">
                <div class=" card card-header">
                    <a class="card-link btn btn-light" data-toggle="collapse" href="#cinco">Producto</a>
                </div>
                <div id="cinco" class="collapse" data-parent="#accordion">
                    <div class="card-body" style="padding: 0px">
                        <ul class="list-group-flush" style="padding: 0px">
                            <li class="list-group-item list-group-item-action"><a href="AgregarProducto.jsp" class="btn btn-light nav-accordion">Agregar Producto</a></li>
                            <li class="list-group-item list-group-item-action"><a href="ListarProducto.jsp" class="btn btn-light nav-accordion">Listar Productos</a></li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class=" card ">
                <div class=" card card-header">
                    <a class="card-link btn btn-light" data-toggle="collapse" href="#seis">Pedido</a>
                </div>
                
                <div id="seis" class="collapse" data-parent="#accordion">
                    <div class="card-body" style="padding: 0px">
                        <ul class="list-group-flush" style="padding: 0px">
                            <li class="list-group-item list-group-item-action"><a href="AgregarPedido.jsp" class="btn btn-light nav-accordion">Agregar Pedido</a></li>
                            <li class="list-group-item list-group-item-action"><a href="ListarPedidos.jsp" class="btn btn-light nav-accordion">Listar Pedidos</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="col-md-1"></div>



