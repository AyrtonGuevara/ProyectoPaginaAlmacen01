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

/**
 *
 * @author ayrton
 */
public class RolBean {
    private Connection conexion;
    private VariablesConexion varcon;
    
    public RolBean() throws SQLException{
        varcon = new VariablesConexion();
        varcon.iniciarConexion();
        conexion=varcon.getConexion();
    }
    
    public String SelectRol(){
        StringBuilder salida=new StringBuilder();
        StringBuilder query=new StringBuilder();
        query.append(" select * from rol ");
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
}
