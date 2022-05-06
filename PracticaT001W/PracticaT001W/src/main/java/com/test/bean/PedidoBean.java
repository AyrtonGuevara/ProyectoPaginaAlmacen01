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
                    Salida.append(res.getString(1));
                    Salida.append("</td><td>");
                    Salida.append(res.getString(2));
                    Salida.append("</td><td>");
                    Salida.append(res.getString(3));
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
                Salida.append("<tr>");
                while (res.next()) {
                    pedidopojo.setRSproveedor(res.getString(1));
                    String cS = Integer.toString(c);
                    String cantidad = request.getParameter(cS);
                    int cantidad2 = Integer.parseInt(cantidad);
                    if (cantidad2 > 0) {
                        Salida.append("<td> <input name='");
                        idprod = res.getInt(2);
                        Salida.append(idprod);
                        productos[c] = idprod;
                        Salida.append("' type='text' value='");
                        Salida.append(res.getString(3));
                        Salida.append("' disabled/>");
                        Salida.append("</td>");

                        Salida.append("<td> <input name='cantidad");
                        Salida.append(c2);
                        Salida.append("' type='text' value='");
                        Salida.append(cantidad2);
                        Salida.append("' disabled/>");

                        Salida.append("<td>");
                        flo = res.getFloat(4);
                        Salida.append(flo);
                        Salida.append("</td>");
   
                        sum = cantidad2 * flo;

                        Salida.append("<td> <input name='total");
                        Salida.append(c2);
                        Salida.append("' type='text' value='");
                        Salida.append(sum);
                        Salida.append("' disabled/>");

                        sum2 = sum2 + sum;
                        //costo unitario y todal
                        c2++;
                    }
                    c++;
                }
                Salida.append("</tr>");

                pedidopojo.setCarrito(Salida.toString());
                pedidopojo.setTotalPedido(sum2);
                pedidopojo.setListaProductos(productos);
                pedidopojo.setCantidadProductos(c2);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public PedidoPojo getPedidopojo() {
        return pedidopojo;
    }

    public void setPedidopojo(PedidoPojo pedidopojo) {
        this.pedidopojo = pedidopojo;
    }

}
