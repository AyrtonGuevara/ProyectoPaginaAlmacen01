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
public class CargoBean {
    //atributos
    private Connection conexion;
    private PreparedStatement AgregarCargo;
    private VariablesConexion variableConexion;
    //constructores
    public CargoBean() throws SQLException{
        variableConexion=new VariablesConexion();
        variableConexion.iniciarConexion();
        conexion=variableConexion.getConexion();
        System.out.println("Conexion iniciada");
    }
    @PreDestroy
    public void CerrarConexion(){
        variableConexion.finalizarConexion();
    }
    //metodos
    public String RegistrarCargo(HttpServletRequest request){
        String mensaje ="";
        if (request ==null) {
            return "";
        }
        if (conexion !=null) {
            try {
                StringBuilder query= new StringBuilder();
                query.append("insert into cargo ");
                query.append(" values (?,?) ");
                //enviando consulta
                if (AgregarCargo==null) {
                    AgregarCargo=conexion.prepareStatement(query.toString());
                }
                //rescatando datos
                String nombreCargo=request.getParameter("NombreCargo");
                AgregarCargo.setString(1, null);
                AgregarCargo.setString(2, nombreCargo);
                mensaje=AgregarCargo.toString();
                //consulta
                int registro=AgregarCargo.executeUpdate();
                if (registro==1) {
                    mensaje="registro exitoso";
                }else{
                    mensaje="error del registro";
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return mensaje;
    }
    
    public String ListaCargo(){
        StringBuilder salida=new StringBuilder();
        StringBuilder query=new StringBuilder();
        query.append(" select nombrecargo from cargo ");
        try {
            PreparedStatement pst=conexion.prepareStatement(query.toString());
            ResultSet res=pst.executeQuery();
            while (res.next()) {                
                salida.append("<tr><td>");
                salida.append(res.getString(1));
                salida.append("</td></tr>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return salida.toString();
    }
    //g&s
}
