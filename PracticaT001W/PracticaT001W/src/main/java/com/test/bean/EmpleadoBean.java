/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.bean;

import com.test.clases.EmpleadoPojo;
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
public class EmpleadoBean {
    private Connection conexion;
    private PreparedStatement AgregarEmpleado;
    private PreparedStatement ModificarEmpleado;
    private PreparedStatement EliminarEmpleado;
    private VariablesConexion varConexion;
    private EmpleadoPojo empleadopojo;
    
    //constructor
    public EmpleadoBean()throws SQLException{
        varConexion=new VariablesConexion();
        varConexion.iniciarConexion();
        conexion=varConexion.getConexion();
        System.out.println("Conexion Iniciada");
    }
    @PreDestroy
    public void Desconectar(){
        varConexion.finalizarConexion();
    }
    public String RegistrarEmpleado(HttpServletRequest request){
        String Mensaje="";
        if (request == null) {
            return "";
        }
        if (conexion!=null) {
            try {
                //creando consulta
                StringBuilder query=new StringBuilder();
                query.append(" insert into Empleado ");
                query.append(" values (?,?,?,?,?,?,?,?,?) ");
                if (AgregarEmpleado==null) {
                    AgregarEmpleado=conexion.prepareStatement(query.toString());
                }
                String Nombre=request.getParameter("nombreEmpleado");
                String ApellidoPEmpleado=request.getParameter("ApellidoPEmpleado");
                String ApellidoMEmpleado=request.getParameter("ApellidoMEmpleado");
                String Edad=request.getParameter("Edad");
                int edad2=Integer.parseInt(Edad);
                String CI=request.getParameter("CI");
                int CI2=Integer.parseInt(CI);
                String c=request.getParameter("Cargo");
                int Cargo=Integer.parseInt(c);
                String Direccion=request.getParameter("Direccion");
                AgregarEmpleado.setString(1, null);
                AgregarEmpleado.setInt(2, Cargo);
                AgregarEmpleado.setString(3, Nombre);
                AgregarEmpleado.setString(4, ApellidoPEmpleado);
                AgregarEmpleado.setString(5, ApellidoMEmpleado);
                AgregarEmpleado.setInt(6, edad2);
                AgregarEmpleado.setString(7, Direccion);
                AgregarEmpleado.setInt(8, CI2);
                AgregarEmpleado.setString(9, "Activo");
                int resultado=AgregarEmpleado.executeUpdate();
                if (resultado==1) {
                    Mensaje="Rgistro Exitoso";
                }else{
                    Mensaje="Error del Registro";
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return Mensaje;
    }
    public String ListaEmpleado(){
        StringBuilder query=new StringBuilder();
        StringBuilder salida=new StringBuilder();
        query.append(" select c.NombreCargo, e.NombreEmpleado, e.ApellidoPaternoEmpleado, e.ApellidoMaternoEmpleado ");
        query.append(" ,e.EdadEmpleado, e.DireccionEmpleado, e.CIEmpleado, e.idEmpleado ");
        query.append(" from Empleado e inner join Cargo c on c.idCargo=e.CargoidCargo where e.estado like 'Activo' ");
        try {
            PreparedStatement pst=conexion.prepareStatement(query.toString());
            ResultSet res=pst.executeQuery();
            while (res.next()) {                
                salida.append("<tr><td>");
                salida.append(res.getString(1));
                salida.append("</td><td>");
                salida.append(res.getString(2));
                salida.append("</td><td>");
                salida.append(res.getString(3));
                salida.append(" ");
                salida.append(res.getString(4));
                salida.append("</td><td>");
                salida.append(res.getInt(5));
                salida.append("</td><td>");
                salida.append(res.getString(6));
                salida.append("</td><td>");
                salida.append(res.getInt(7));     
                salida.append("</td><td>");
                salida.append("<a href='ModificarEmpleado.jsp?codEmpleado=").append(res.getInt(8)).append("' class='btn btn-warning'>Modificar</a>");     
                salida.append("</td><td>");
                salida.append("<a href='ListaEmpleado.jsp?codEmpleado=").append(res.getInt(8)).append("' class='btn btn-danger' onclick='return ConfirmarEliminacion();'>Eliminar</a>");     
                salida.append("</td></tr>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return salida.toString();
    }
    public String selectEmpleado(){
        StringBuilder salida=new StringBuilder();
        StringBuilder query=new StringBuilder();
        query.append("select idEmpleado, NombreEmpleado, ApellidoPaternoEmpleado from Empleado");
        try {
            PreparedStatement pst=conexion.prepareStatement(query.toString());
            ResultSet res=pst.executeQuery();
            while (res.next()) {                
                salida.append("<option value=");
                salida.append(res.getInt(1));
                salida.append(">");
                salida.append(res.getString(2));
                salida.append(" ");
                salida.append(res.getString(3));
                salida.append("</option>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return salida.toString();
    }
    public void MostrarEmpleado(String codEmpleado){
        empleadopojo= new EmpleadoPojo();
        StringBuilder query=new StringBuilder();
        query.append(" select idempleado,cargoidcargo,nombreempleado,apellidopaternoempleado,apellidomaternoempleado,edadempleado,direccionempleado,ciempleado ");
        query.append(" from empleado where idEmpleado = ? ");
        try {
            PreparedStatement pst=conexion.prepareStatement(query.toString());
            pst.setInt(1, Integer.parseInt(codEmpleado));
            ResultSet res=pst.executeQuery();
            if (res.next()) {
                empleadopojo.setCodEmpleado(res.getInt(1));
                empleadopojo.setCargoEmpleado(res.getInt(2));
                empleadopojo.setNombreEmpleado(res.getString(3));
                empleadopojo.setApellidoPaterno(res.getString(4));
                empleadopojo.setApellidoMaterno(res.getString(5));
                empleadopojo.setEdadEmpleado(res.getInt(6));
                empleadopojo.setDireccionEmpleado(res.getString(7));
                empleadopojo.setCIEmpleado(res.getInt(8));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    public String ModificarEmpleado(HttpServletRequest request, String CodEmpleado){
        String mensaje="";
        if (request==null) {
            return "";
        }
        if (conexion!=null) {
            try {
                StringBuilder query=new StringBuilder();
                query.append(" UPDATE empleado SET CargoidCargo = ?, NombreEmpleado = ?, ApellidoPaternoEmpleado = ?,");
                query.append(" ApellidoMaternoEmpleado = ?, EdadEmpleado = ?, DireccionEmpleado = ?, CIEmpleado = ? ");
                query.append(" WHERE (idEmpleado = ?) ");
                if (ModificarEmpleado==null) {
                    ModificarEmpleado=conexion.prepareStatement(query.toString());
                }
                String Cargo=request.getParameter("cargo");
                int cargo2=Integer.parseInt(Cargo);
                String Nombre=request.getParameter("nombre");
                String ApellidoP=request.getParameter("appaterno");
                String ApellidoM=request.getParameter("apmaterno");
                String Edad=request.getParameter("edad");
                int edad2=Integer.parseInt(Edad);
                String Direccion=request.getParameter("direccion");
                String CI=request.getParameter("ci");
                int ci2=Integer.parseInt(CI);
                ModificarEmpleado.setInt(1, cargo2);
                ModificarEmpleado.setString(2, Nombre);
                ModificarEmpleado.setString(3, ApellidoP);
                ModificarEmpleado.setString(4, ApellidoM);
                ModificarEmpleado.setInt(5, edad2);
                ModificarEmpleado.setString(6, Direccion);
                ModificarEmpleado.setInt(7, ci2);
                ModificarEmpleado.setInt(8, Integer.parseInt(CodEmpleado==null?"0":CodEmpleado));
                int res=ModificarEmpleado.executeUpdate();
                if (res==1) {
                    mensaje="modificado con exito";
                }else{
                    mensaje="error al modificar";
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return mensaje;
    }
    public String EliminarEmpleado(HttpServletRequest request, String codigo){
        String Mensaje="";
        if (request==null) {
            return "";
        }
        if (conexion!=null) {
            try {
                StringBuilder query = new StringBuilder();
                query.append(" update empleado set Estado='Inactivo' where idEmpleado = ? ");
                EliminarEmpleado=conexion.prepareStatement(query.toString());
                EliminarEmpleado.setInt(1, Integer.parseInt(codigo));
                int res=EliminarEmpleado.executeUpdate();
                if (res==1) {
                    Mensaje="Eliminacion Exitosa";
                }else{
                    Mensaje="Error al eliminar";
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return Mensaje;
    }
    
    //g$s

    public EmpleadoPojo getEmpleadopojo() {
        return empleadopojo;
    }

    public void setEmpleadopojo(EmpleadoPojo empleadopojo) {
        this.empleadopojo = empleadopojo;
    }
    
    
}
