/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.bean;

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
    private VariablesConexion varConexion;
    
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
                query.append(" values (?,?,?,?,?,?,?,?) ");
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
                Mensaje=AgregarEmpleado.toString();
                AgregarEmpleado.setString(5, ApellidoMEmpleado);
                Mensaje=AgregarEmpleado.toString();
                AgregarEmpleado.setInt(6, edad2);
                Mensaje=AgregarEmpleado.toString();
                AgregarEmpleado.setString(7, Direccion);
                Mensaje=AgregarEmpleado.toString();
                AgregarEmpleado.setInt(8, CI2);
                Mensaje=AgregarEmpleado.toString();
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
        query.append(" from Empleado e inner join Cargo c on c.idCargo=e.CargoidCargo");
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
}
