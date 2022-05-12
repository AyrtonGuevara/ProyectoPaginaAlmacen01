/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.bean;

import com.test.clases.ClientePojo;
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
public class ClienteBean {
    private PreparedStatement agregarCliente;
    private PreparedStatement modificarCliente;
    private PreparedStatement eliminarCliente;
    private Connection conexion;
    private VariablesConexion varcon;
    private ClientePojo clientepojo;
    
    public ClienteBean() throws SQLException{
        varcon=new VariablesConexion();
        varcon.iniciarConexion();
        conexion=varcon.getConexion();
    }
    
    @PreDestroy
    public void CerrarSesion(){
        varcon.finalizarConexion();
    }
    public String RegistrarCliente(HttpServletRequest request){
        String mensaje="";
        if (request==null) {
            return"";
        }
        if (conexion!=null) {
            try {
                StringBuilder query=new StringBuilder();
                query.append(" insert into cliente ");
                query.append(" values (?,?,?,?,?) ");
                if (agregarCliente==null) {
                    agregarCliente=conexion.prepareStatement(query.toString());
                }
                String nombre=request.getParameter("NombreCliente");
                String apellido=request.getParameter("ApellidoCliente");
                String NITCI=request.getParameter("NITCI");
                agregarCliente.setString(1, null);
                agregarCliente.setString(2, nombre);
                agregarCliente.setString(3, apellido);
                agregarCliente.setString(4, NITCI);
                agregarCliente.setString(5, "Activo");
                int res=agregarCliente.executeUpdate();
                if (res==1) {
                    mensaje="registro exitoso";
                }else{
                    mensaje="error al registrar";
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return mensaje;
    }
    public String ListaClientes(){
        StringBuilder salida=new StringBuilder();
        StringBuilder query=new StringBuilder();
        query.append("select nombrecliente,apellidocliente,nitcliente,idcliente from cliente where estado like 'Activo' ");
        if (conexion!=null) {
            try {
                PreparedStatement pst=conexion.prepareStatement(query.toString());
                ResultSet res=pst.executeQuery();
                while (res.next()) {                    
                    salida.append("<tr><td>");
                    salida.append(res.getString(1));
                    salida.append(" ");
                    salida.append(res.getString(2));
                    salida.append("</td><td>");
                    salida.append(res.getString(3));
                    salida.append("</td><td>");
                    salida.append("<a href='ModificarCliente.jsp?codCliente=").append(res.getInt(4)).append("' class='btn btn-warning'>Modificar</a>");
                    salida.append("</td><td>");
                    salida.append("<a href='ListaClientes.jsp?codCliente=").append(res.getInt(4)).append("' class='btn btn-danger' onclick='return ConfirmarEliminacion();' >Eliminar</a>");
                    salida.append("</td></tr>");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return salida.toString();
    }
    public void MostrarCliente(String codCliente){
        clientepojo=new ClientePojo();
        StringBuilder query=new StringBuilder();
        query.append("select idcliente, nombrecliente,apellidocliente,nitcliente from cliente where idcliente = ? ");
        try {
            PreparedStatement pst=conexion.prepareStatement(query.toString());
            pst.setInt(1, Integer.parseInt(codCliente));
            ResultSet res=pst.executeQuery();
            if (res.next()) {
                clientepojo.setIdcliente(res.getInt(1));
                clientepojo.setNombreCliente(res.getString(2));
                clientepojo.setApellidoCliente(res.getString(3));
                clientepojo.setNITCI(res.getString(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public String ModificarCliente(HttpServletRequest request, String codCliente){
        String mensaje="";
        if (request==null) {
            return "";
        }
        if (conexion!=null) {
            try {
                StringBuilder query=new StringBuilder();
                query.append(" update cliente set nombrecliente=?, apellidocliente=?, nitcliente=? ");
                query.append(" where idcliente = ? ");
                if (modificarCliente==null) {
                    modificarCliente=conexion.prepareStatement(query.toString());
                }
                String nombre=request.getParameter("NombreCliente");
                String apellido=request.getParameter("ApellidoCliente");
                String nitci=request.getParameter("nitci");
                modificarCliente.setString(1, nombre);
                modificarCliente.setString(2, apellido);
                modificarCliente.setString(3, nitci);
                modificarCliente.setInt(4, Integer.parseInt(codCliente==null?"0":codCliente));
                int res=modificarCliente.executeUpdate();
                if (res==1) {
                    mensaje="modificacion exitosa";
                }else{
                    mensaje="error en la modificacion";
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return mensaje;
    }
    
    public String EliminarCliente(HttpServletRequest request, String codCliente){
        String Mensaje="";
        if (request==null) {
            return "";
        }
        if (conexion!=null) {
            try {
                StringBuilder query=new StringBuilder();
                query.append(" update cliente set estado='Inactivo' where idCliente = ? ");
                if (eliminarCliente==null) {
                    eliminarCliente=conexion.prepareStatement(query.toString());
                }
                eliminarCliente.setInt(1, Integer.parseInt(codCliente==null?"0":codCliente));
                int res=eliminarCliente.executeUpdate();
                if (res==1) {
                    Mensaje="Exito al eliminar";
                }else{
                    Mensaje="error al eliminar";
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return Mensaje;
    }
    

    public ClientePojo getClientepojo() {
        return clientepojo;
    }

    public void setClientepojo(ClientePojo clientepojo) {
        this.clientepojo = clientepojo;
    }
    
}
