/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.bean;

import com.test.conexion.VariablesConexion;
import com.test.encryped.encriptacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.annotation.PreDestroy;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author ayrton
 */
public class UsuarioBean {

    private PreparedStatement agregarusuario;
    private Connection conexion;
    private VariablesConexion varcon;

    public UsuarioBean() throws SQLException {
        varcon = new VariablesConexion();
        varcon.iniciarConexion();
        conexion = varcon.getConexion();
    }

    @PreDestroy
    public void CerrarConexion() {
        varcon.finalizarConexion();
    }

    public String AgregarUsuario(HttpServletRequest request) {
        String Mensaje = "";
        if (request == null) {
            return "";
        }
        if (conexion != null) {
            try {
                StringBuilder query = new StringBuilder();
                query.append("insert into usuario ");
                query.append(" values (?,?,?,?) ");
                if (agregarusuario==null) {
                    agregarusuario=conexion.prepareStatement(query.toString());
                }
                String id=request.getParameter("empleado");
                String usuario=request.getParameter("Usuario");
                String contraseña=request.getParameter("contrasena");
                String contraseña2=request.getParameter("contrasena2");
                String contraseñaN="";
                if (contraseña.equalsIgnoreCase(contraseña2)) {
                    encriptacion en=new encriptacion();
                    contraseñaN=en.encrip(contraseña);
                }else{
                    //????
                }
                agregarusuario.setString(1, null);
                agregarusuario.setString(2, id);
                agregarusuario.setString(3, usuario);
                agregarusuario.setString(4, contraseñaN);
                Mensaje = agregarusuario.toString();
                int resultado = agregarusuario.executeUpdate();
                if (resultado==1) {
                    Mensaje="exito al registrar";
                }else{
                    Mensaje="Error de registro";
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return Mensaje;
    }
}
