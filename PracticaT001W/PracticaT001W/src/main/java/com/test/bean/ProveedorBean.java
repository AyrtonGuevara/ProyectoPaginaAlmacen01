/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.bean;

import com.test.clases.ProveedorPojo;
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
public class ProveedorBean {

    private Connection conexion;
    private PreparedStatement AgregarProveedor;
    private PreparedStatement ModificarProveedor;
    private PreparedStatement EliminarProveedor;
    private VariablesConexion varcon;
    private ProveedorPojo proveedorpojo;

    public ProveedorBean() throws SQLException {
        varcon = new VariablesConexion();
        varcon.iniciarConexion();
        conexion = varcon.getConexion();
    }

    @PreDestroy
    public void CerrarConexion() {
        varcon.finalizarConexion();
    }

    public String AgregarProveedor(HttpServletRequest request) {
        String Mensaje = "";
        if (request == null) {
            return "";
        }
        if (conexion != null) {
            try {
                StringBuilder query = new StringBuilder();
                query.append(" insert into proveedor ");
                query.append(" values (?,?,?,?,?,?) ");
                if (AgregarProveedor == null) {
                    AgregarProveedor = conexion.prepareStatement(query.toString());
                }
                String RazonSocial = request.getParameter("RazonSocial");
                String Contaco = request.getParameter("Contacto");
                String Telefono = request.getParameter("Telefono");
                String Direccion = request.getParameter("Direccion");
                AgregarProveedor.setString(1, null);
                AgregarProveedor.setString(2, RazonSocial);
                AgregarProveedor.setString(3, Contaco);
                AgregarProveedor.setString(4, Telefono);
                AgregarProveedor.setString(5, Direccion);
                AgregarProveedor.setString(6, "Activo");
                int res = AgregarProveedor.executeUpdate();
                if (res == 1) {
                    Mensaje = "Registro Exitoso";
                } else {
                    Mensaje = "Error en el registro";
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return Mensaje;
    }

    public String ListarProveedores() {
        StringBuilder query = new StringBuilder();
        StringBuilder salida = new StringBuilder();
        query.append(" select RazonSocialProveedor, ContactoProveedor, TelefonoContactoProveedor, DireccionProveedor, idProveedor from proveedor where estado like 'Activo' ");
        try {
            PreparedStatement pst = conexion.prepareStatement(query.toString());
            ResultSet rst = pst.executeQuery();
            while (rst.next()) {
                salida.append("<tr><td>");
                salida.append(rst.getString(1));
                salida.append("</td><td>");
                salida.append(rst.getString(2));
                salida.append("</td><td>");
                salida.append(rst.getString(3));
                salida.append("</td><td>");
                salida.append(rst.getString(4));
                salida.append("</td><td>");
                salida.append("<a href='ModificarProveedor.jsp?codProveedor=").append(rst.getString(5)).append("' style='btn btn-warning' >Modificar</a>");
                salida.append("</td><td>");
                salida.append("<a href='ListaProveedores.jsp?codProveedor=").append(rst.getString(5)).append("' onclick='VerificacionEliminar()' style='btn btn-danger' >Eliminar</a>");
                salida.append("</td></tr>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return salida.toString();
    }

    public void BuscarProveedor(String codProveedor) {
        proveedorpojo = new ProveedorPojo();
        StringBuilder query = new StringBuilder();
        query.append("select idproveedor, razonsocialproveedor, contactoproveedor, telefonocontactoproveedor, direccionproveedor from proveedor where idproveedor = ?");
        try {
            PreparedStatement pst = conexion.prepareStatement(query.toString());
            pst.setInt(1, Integer.parseInt(codProveedor));
            ResultSet rst = pst.executeQuery();
            if (rst.next()) {
                proveedorpojo.setIdPorveedor(rst.getInt(1));
                proveedorpojo.setRazonSocialProveedor(rst.getString(2));
                proveedorpojo.setContactoProveedor(rst.getString(3));
                proveedorpojo.setTelefonoContacto(rst.getString(4));
                proveedorpojo.setDireccionProveedor(rst.getString(5));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String ModificarProveedor(HttpServletRequest request, String Codigo) {
        String mensaje = "";
        if (request == null) {
            return "";
        }
        if (conexion != null) {
            try {
                StringBuilder query = new StringBuilder();
                query.append(" update proveedor set RazonSocialProveedor = ?, ContactoProveedor = ?, TelefonoContactoProveedor = ?, DireccionProveedor = ? where (idProveedor = ?) ");
                if (ModificarProveedor == null) {
                    ModificarProveedor = conexion.prepareStatement(query.toString());
                }
                String RazonSocial = request.getParameter("RazonSocial");
                String Contacto = request.getParameter("Contacto");
                String Telefono = request.getParameter("Telefono");
                String Direccion = request.getParameter("Direccion");
                ModificarProveedor.setString(1, RazonSocial);
                ModificarProveedor.setString(2, Contacto);
                ModificarProveedor.setString(3, Telefono);
                ModificarProveedor.setString(4, Direccion);
                ModificarProveedor.setInt(5, Integer.parseInt(Codigo == null ? "0" : Codigo));
                int res = ModificarProveedor.executeUpdate();
                if (res == 1) {
                    mensaje = "Modificacion Exitosa";
                } else {
                    mensaje = "Error al modificar";
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return mensaje;
    }

    public String EliminarProveedor(HttpServletRequest request, String Codigo) {
        String mensaje = "";
        if (request == null) {
            return "";
        }
        if (conexion != null) {
            try {
                StringBuilder query = new StringBuilder();
                query.append(" update proveedor set estado = 'Inactivo' where idproveedor = ? ");
                if (EliminarProveedor == null) {
                    EliminarProveedor = conexion.prepareStatement(query.toString());
                }
                EliminarProveedor.setInt(1, Integer.parseInt(Codigo==null?"0":Codigo));
                int res=EliminarProveedor.executeUpdate();
                if (res==1) {
                    mensaje="Se elimino Correctamente";
                }else{
                    mensaje="Error en la eliminacion";
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return mensaje;
    }

    public ProveedorPojo getProveedorpojo() {
        return proveedorpojo;
    }

    public void setProveedorpojo(ProveedorPojo proveedorpojo) {
        this.proveedorpojo = proveedorpojo;
    }

}
