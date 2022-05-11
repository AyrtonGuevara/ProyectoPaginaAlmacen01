/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.bean;

import com.test.clases.PedidoPojo;
import com.test.conexion.VariablesConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.annotation.PreDestroy;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author ayrton
 */
public class PedidoBean {

    private PreparedStatement AgregarPedido;
    private PreparedStatement AgregarDetallePedido;
    private PreparedStatement CambiarStock;
    private Connection conexion;
    private VariablesConexion varcon;
    private PedidoPojo pedidopojo;

    public PedidoBean() throws SQLException {
        varcon = new VariablesConexion();
        varcon.iniciarConexion();
        conexion = varcon.getConexion();
    }

    @PreDestroy
    public void CerraSesion() {
        varcon.finalizarConexion();
    }

    public String ListaProductoPedido(HttpServletRequest request) {
        StringBuilder Salida = new StringBuilder();
        StringBuilder query = new StringBuilder();
        pedidopojo = new PedidoPojo();
        int a = 0;
        if (request == null) {
            return "";
        }
        if (conexion != null) {
            try {
                query.append(" select p.idproveedor,p.razonsocialproveedor,pe.idproducto,pe.nombreproducto,pe.stockproducto from proveedor p inner join producto pe on pe.proveedoridproveedor=p.idproveedor where p.estado like 'Activo' and  p.idproveedor = ? ");
                PreparedStatement pst = conexion.prepareStatement(query.toString());
                String codigo = request.getParameter("proveedor");
                int codigo2 = Integer.parseInt(codigo);
                pedidopojo.setProveedor(codigo2);
                pst.setInt(1, codigo2);
                ResultSet res = pst.executeQuery();
                while (res.next()) {
                    a++;
                    Salida.append("<tr><td>");
                    Salida.append(res.getString(2));
                    Salida.append("</td><td>");
                    Salida.append(res.getString(4));
                    Salida.append("</td><td>");
                    Salida.append(res.getString(5));
                    Salida.append("</td><td>");
                    Salida.append("<input type='number' name='").append(a).append("'/>");
                }
                pedidopojo.setCantidadProductos(a);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return Salida.toString();
    }

    public void MostrarCarrito(HttpServletRequest request, int proveedor, int contador) {
        System.out.println("pasa");
        StringBuilder Salida = new StringBuilder();
        StringBuilder query = new StringBuilder();
        pedidopojo = new PedidoPojo();
        int contador2 = contador, c = 1, c2 = 0, idprod;
        float sum = 0, flo = 0, sum2 = 0;
        int[] productos = new int[contador + 1];
        if (conexion != null) {
            try {
                query.append(" select p.razonsocialproveedor,pe.idproducto,pe.nombreproducto, pe.CostoProducto from proveedor p inner join producto pe on pe.proveedoridproveedor=p.idproveedor where p.estado like 'Activo' and  p.idproveedor = ? ");
                PreparedStatement pst = conexion.prepareStatement(query.toString());
                pedidopojo.setProveedor(proveedor);
                pst.setInt(1, proveedor);
                ResultSet res = pst.executeQuery();

                while (res.next()) {
                    Salida.append("<tr>");
                    pedidopojo.setRSproveedor(res.getString(1));
                    String cS = Integer.toString(c);
                    String cantidad = request.getParameter(cS);
                    int cantidad2 = Integer.parseInt(cantidad.equals("") ? "0" : cantidad);
                    if (cantidad2 > 0) {
                        Salida.append("<td> <input name='");
                        idprod = res.getInt(2);
                        Salida.append(idprod);
                        productos[c2] = idprod;
                        Salida.append("' type='text' value='");
                        Salida.append(res.getString(3));
                        Salida.append("' disabled/>");
                        Salida.append("</td>");

                        Salida.append("<td> <input name='cantidad");
                        Salida.append(c2);
                        Salida.append("' type='text' value='");
                        Salida.append(cantidad2);
                        Salida.append("' /></td>");//aqui

                        Salida.append("<td>");
                        flo = res.getFloat(4);
                        Salida.append(flo);
                        Salida.append("</td>");

                        sum = cantidad2 * flo;

                        Salida.append("<td> <input name='total");
                        Salida.append(c2);
                        Salida.append("' type='text' value='");
                        Salida.append(sum);
                        Salida.append("' /></td>");//aquitambien

                        sum2 = sum2 + sum;
                        //costo unitario y todal
                        c2++;
                    }
                    c++;
                    Salida.append("</tr>");
                }

                pedidopojo.setCarrito(Salida.toString());
                pedidopojo.setTotalPedido(sum2);
                pedidopojo.setListaProductos(productos);
                pedidopojo.setCantidadProductos(c2);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public String finPedido(HttpServletRequest request, int idproveedor, float totalpedido, int[] listap, int cantidadp) {
        String Mensaje = "";
        int idpedido = 0;
        if (request == null) {
            return "";
        }
        if (conexion != null) {
            try {
                StringBuilder query = new StringBuilder();
                StringBuilder query2 = new StringBuilder();
                query.append("insert into pedido ");
                query.append(" values (?,?,?,?)");
                if (AgregarPedido == null) {
                    AgregarPedido = conexion.prepareStatement(query.toString());
                }
                String fecha = request.getParameter("fecha");
                AgregarPedido.setString(1, null);
                AgregarPedido.setInt(2, idproveedor);
                AgregarPedido.setString(3, fecha);
                AgregarPedido.setFloat(4, totalpedido);
                int resu = AgregarPedido.executeUpdate();
                if (resu == 1) {
                    query2.append(" select idpedido from pedido order by idpedido desc limit 1 ");
                    PreparedStatement pst = conexion.prepareStatement(query2.toString());
                    ResultSet res = pst.executeQuery();
                    while (res.next()) {
                        idpedido = res.getInt(1);
                    }
                    int cantidadp2 = cantidadp, c = 0, stock = 0;
                    String cantidadproducto = "cantidad";
                    String costoproducto = "total";
                    while (cantidadp2 > 0) {
                        cantidadproducto = cantidadproducto + c;
                        costoproducto = costoproducto + c;
                        StringBuilder query3 = new StringBuilder();
                        query3.append("insert into detallepedido ");
                        query3.append(" values (?,?,?,?,?) ");
                        AgregarDetallePedido = conexion.prepareStatement(query3.toString());
                        String cantidadprod = request.getParameter(cantidadproducto);
                        int cantidadprod2 = Integer.parseInt(cantidadprod);
                        String costoprod = request.getParameter(costoproducto);
                        float costoprod2 = Float.parseFloat(costoprod);
                        AgregarDetallePedido.setString(1, null);
                        AgregarDetallePedido.setInt(2, idpedido);
                        AgregarDetallePedido.setInt(3, listap[c]); //idproducto
                        AgregarDetallePedido.setInt(4, cantidadprod2); //cantidad
                        AgregarDetallePedido.setFloat(5, costoprod2); //costo
                        String asd = AgregarDetallePedido.toString();////
                        cantidadp2--;

                        AgregarDetallePedido.executeUpdate();
                        cantidadproducto = "cantidad";
                        costoproducto = "total";
                        //agregando el stock al inventario
                        StringBuilder query4 = new StringBuilder();
                        StringBuilder query5 = new StringBuilder();
                        query4.append("select stockproducto from producto where idproducto = ?");
                        PreparedStatement pst2 = conexion.prepareStatement(query4.toString());
                        pst2.setInt(1, listap[c]);
                        String aasd = pst2.toString(); /////
                        ResultSet rst2 = pst2.executeQuery();
                        while (rst2.next()) {
                            stock = rst2.getInt(1);
                        }
                        stock = stock + cantidadprod2;
                        query5.append(" update producto set stockproducto = ? where idproducto = ?");
                        CambiarStock = conexion.prepareStatement(query5.toString());
                        CambiarStock.setInt(1, stock);
                        CambiarStock.setInt(2, listap[c]);
                        String assd = CambiarStock.toString(); ////
                        CambiarStock.executeUpdate();
                        stock = 0;
                        c++;
                    }

                } else {
                    Mensaje = "Error en Registrar Pedido";
                }
            } catch (Exception e) {
            }
        }
        return Mensaje;
    }

    public String ListaPedidos() {
        StringBuilder salida = new StringBuilder();
        StringBuilder query = new StringBuilder();
        query.append(" select p.idpedido ,prov.razonsocialproveedor, prod.nombreproducto, p.fechapedido,  detp.cantidaddetallepedido, detp.costodetallepedido ");
        query.append(" from pedido p inner join detallepedido detp  on p.idpedido=detp.pedidoidpedido ");
        query.append(" inner join producto prod on detp.productoidproducto=prod.idproducto ");
        query.append(" inner join proveedor prov on p.proveedoridproveedor=prov.idproveedor ");
        query.append(" order by p.idpedido");
        if (conexion != null) {
            try {
                PreparedStatement pst = conexion.prepareStatement(query.toString());
                ResultSet res = pst.executeQuery();
                while (res.next()) {
                    salida.append("<tr><td>");
                    salida.append(res.getInt(1));
                    salida.append("</td><td>");
                    salida.append(res.getString(2));
                    salida.append("</td><td>");
                    salida.append(res.getString(3));
                    salida.append("</td><td>");
                    salida.append(res.getString(4));
                    salida.append("</td><td>");
                    salida.append(res.getInt(5));
                    salida.append("</td><td>"   );
                    salida.append(res.getFloat(6));
                    salida.append("</td></tr>");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return salida.toString();
    }

    public PedidoPojo getPedidopojo() {
        return pedidopojo;
    }

    public void setPedidopojo(PedidoPojo pedidopojo) {
        this.pedidopojo = pedidopojo;
    }

}
