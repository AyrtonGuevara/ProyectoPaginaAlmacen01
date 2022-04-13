/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.bean;

import com.test.clases.CargoPojo;
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
    private PreparedStatement ModificarCargo;
    private VariablesConexion variableConexion;
    private CargoPojo modCargo;
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
        query.append(" select nombrecargo, idcargo from cargo ");
        try {
            PreparedStatement pst=conexion.prepareStatement(query.toString());
            ResultSet res=pst.executeQuery();
            while (res.next()) {                
                salida.append("<tr><td>");
                salida.append(res.getString(1));
                salida.append("</td><td>");
                salida.append("<a href='ModificarCargo.jsp?codCargo=").append(res.getInt(2)).append("'>Modificar</a>");
                salida.append("</td></tr>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return salida.toString();
    }
    
    public String SelectCargo(){
        StringBuilder salida=new StringBuilder();
        StringBuilder query=new StringBuilder();
        query.append(" select * from cargo ");
        try {
            PreparedStatement pst=conexion.prepareStatement(query.toString());
            ResultSet res=pst.executeQuery();
            while (res.next()) {                
                salida.append("<option value= ");
                salida.append(res.getInt(1));
                salida.append(">");
                salida.append(res.getString(2));
                salida.append("</option>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return salida.toString();
    }
    
    public void MostrarCargo(String codCargo){
        modCargo=new CargoPojo();
        StringBuilder query=new StringBuilder();
        StringBuilder salida=new StringBuilder();
        query.append(" select idcargo, nombrecargo from cargo where estado like 'Activo' and idCargo = ? ");
        try {
            PreparedStatement pst=conexion.prepareStatement(query.toString());
            pst.setInt(1, Integer.parseInt(codCargo));
            ResultSet rst=pst.executeQuery();
            if (rst.next()) {
                modCargo.setCodcargo(rst.getInt(1));
                modCargo.setNombreCargo(rst.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public String ModidficarCargo(HttpServletRequest request,String CodCargo){
        String salida="";
        if (request==null) {
            return "";
        }
        if (conexion!=null) {
            try {
                StringBuilder query=new StringBuilder();
                query.append(" UPDATE `cargo` SET `NombreCargo` = ? WHERE (`idCargo` = ?); ");
                if (ModificarCargo == null) {
                    ModificarCargo=conexion.prepareStatement(query.toString());
                }
                String nombre=request.getParameter("nombreCargo");
                modCargo.setNombreCargo(nombre);
                ModificarCargo.setString(1, nombre);
                ModificarCargo.setInt(2, Integer.parseInt(CodCargo==null?"0":CodCargo));
                int resultado=ModificarCargo.executeUpdate();
                if (resultado==1) {
                    salida="exito al modificar";
                }else{
                    salida="error al modificar";
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return salida;
    }
    //g&s

    public CargoPojo getModCargo() {
        return modCargo;
    }

    public void setModCargo(CargoPojo modCargo) {
        this.modCargo = modCargo;
    }
    
}
