/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.bean;

import com.test.clases.ProductoPojo;
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
public class ProductoBean {

    private PreparedStatement AgregarProducto;
    private PreparedStatement ModificarProducto;
    private PreparedStatement EliminarProducto;
    private Connection conexion;
    private VariablesConexion varcon;
    private ProductoPojo productopojo;

    public ProductoBean() throws SQLException {
        varcon = new VariablesConexion();
        varcon.iniciarConexion();
        conexion = varcon.getConexion();
    }

    @PreDestroy
    public void CerrarSession() {
        varcon.finalizarConexion();
    }

    public String AgregarProducto(HttpServletRequest request) {
        String Mensaje = "";
        if (request == null) {
            return "";
        }
        if (conexion != null) {
            try {
                StringBuilder query=new StringBuilder();
                query.append(" insert into producto values (?,?,?,?,?,?,?) ");
                if (AgregarProducto==null) {
                    AgregarProducto=conexion.prepareStatement(query.toString());
                }
                String proveedor=request.getParameter("Proveedor");
                int proveedor2=Integer.parseInt(proveedor);
                String nombre=request.getParameter("NombreProducto");
                String descripcion=request.getParameter("Descripcion");
                String costo=request.getParameter("Costo");
                float costo2=Float.parseFloat(costo);
                AgregarProducto.setString(1, null);
                AgregarProducto.setInt(2, proveedor2);
                AgregarProducto.setString(3, nombre);
                AgregarProducto.setString(4, descripcion);
                AgregarProducto.setFloat(5, costo2);
                AgregarProducto.setInt(6, 0);
                AgregarProducto.setString(7, "Activo");
                Mensaje=AgregarProducto.toString();
                int res=AgregarProducto.executeUpdate();
                if (res==1) {
                    Mensaje="Registro Exitoso";
                }else{
                    Mensaje="Error en el Registro";
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return Mensaje;
    }
    public String ListaProducto(){
        StringBuilder query=new StringBuilder();
        StringBuilder Salida=new StringBuilder();
        query.append(" select pd.NombreProducto, pd.DescripcionProducto, pd.CostoProducto, pd.StockProducto, po.RazonSocialProveedor, pd.idProducto from producto pd inner join proveedor po on po.idProveedor=pd.proveedoridProveedor where pd.estado like 'Activo' ");
        if (conexion!=null) {
            try {
                PreparedStatement pst=conexion.prepareStatement(query.toString());
                ResultSet rst=pst.executeQuery();
                while (rst.next()) {                    
                    Salida.append("<tr><td>");
                    Salida.append(rst.getString(1));
                    Salida.append("</td><td>");
                    Salida.append(rst.getString(2));
                    Salida.append("</td><td>");
                    Salida.append(rst.getFloat(3));
                    Salida.append("</td><td>");
                    Salida.append(rst.getInt(4));
                    Salida.append("</td><td>");
                    Salida.append(rst.getString(5));
                    Salida.append("</td><td>");
                    Salida.append("<a href='ModificarProducto.jsp?codProducto=").append(rst.getString(6)).append("' class='btn btn-warning'>Modificar</a>");
                    Salida.append("</td><td>");
                    Salida.append("<a href='ListarProducto.jsp?codProducto=").append(rst.getString(6)).append("' onclick='VerificarProducto()' class='btn btn-danger'>Eliminar</a>");
                    Salida.append("</td></tr>");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return Salida.toString();
    }
    public void MostrarProducto(String CodProducto){
        productopojo=new ProductoPojo();
        StringBuilder query=new StringBuilder();
        query.append(" select * from producto where idproducto = ?");
        if (conexion!=null) {
            try {
                PreparedStatement pst=conexion.prepareStatement(query.toString());
                pst.setInt(1, Integer.parseInt(CodProducto==null?"0":CodProducto));
                ResultSet res=pst.executeQuery();
                if (res.next()) {
                    productopojo.setIdProducto(res.getInt(1));
                    productopojo.setIdProveedor(res.getInt(2));
                    productopojo.setNombreProducto(res.getString(3));
                    productopojo.setDescripcion(res.getString(4));
                    productopojo.setCostoProducto(res.getFloat(5));
                    productopojo.setStockProducto(res.getInt(6));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }        
    }
    public String ModificarProducto(HttpServletRequest request, String codProducto){
        String Mensaje="";
        if (request==null) {
            return"";
        }
        if (conexion!=null) {
            try {
                StringBuilder query=new StringBuilder();
                query.append(" update producto set proveedoridproveedor = ? ,nombreproducto = ? ,descripcionproducto = ? ,costoproducto = ? ,stockproducto  = ? where idproducto = ? ");
                if (ModificarProducto==null) {
                    ModificarProducto=conexion.prepareStatement(query.toString());
                }
                String proveedor=request.getParameter("Proveedor");
                int proveedor2=Integer.parseInt(proveedor);
                String nombre=request.getParameter("NombreProducto");
                String descripcion=request.getParameter("descripcion");
                String costo=request.getParameter("Costo");
                float costo2=Float.parseFloat(costo);
                String stock=request.getParameter("Stock");
                int stock2=Integer.parseInt(stock);
                ModificarProducto.setInt(1, proveedor2);
                ModificarProducto.setString(2, nombre);
                ModificarProducto.setString(3, descripcion);
                ModificarProducto.setFloat(4, costo2);
                ModificarProducto.setInt(5, stock2);
                ModificarProducto.setInt(6, Integer.parseInt(codProducto==null?"0":codProducto));
                int res=ModificarProducto.executeUpdate();
                if (res==1) {
                    Mensaje="Modificacion exitosa";
                }else{
                    Mensaje="Error al Modificar";
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return Mensaje;
    }
    public String EliminarProducto(HttpServletRequest request, String CodigoProducto){
        String Mensaje="";
        if (request==null) {
            return"";
        }
        if (conexion!=null) {
            try {
                StringBuilder query=new StringBuilder();
                query.append(" update producto set estado = 'Inactivo' where idproducto = ? ");
                if (EliminarProducto==null) {
                    EliminarProducto=conexion.prepareStatement(query.toString());
                }
                EliminarProducto.setInt(1, Integer.parseInt(CodigoProducto==null?"0":CodigoProducto));
                int res=EliminarProducto.executeUpdate();
                if (res==1) {
                    Mensaje="Eliminacion exitosa";
                }else{
                    Mensaje="Error al Eliminar";
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return Mensaje;
    }
    //g&s

    public ProductoPojo getProductopojo() {
        return productopojo;
    }

    public void setProductopojo(ProductoPojo productopojo) {
        this.productopojo = productopojo;
    }
    
}
