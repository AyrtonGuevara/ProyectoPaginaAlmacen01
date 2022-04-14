/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.bean;

import com.test.clases.UsuarioPojo;
import com.test.conexion.VariablesConexion;
import com.test.encryped.encriptacion;
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
public class UsuarioBean {

    private PreparedStatement agregarusuario;
    private PreparedStatement modificarusuario;
    private PreparedStatement Eliminarusuario;
    private Connection conexion;
    private VariablesConexion varcon;
    private UsuarioPojo usuariopojo;

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
                if (agregarusuario == null) {
                    agregarusuario = conexion.prepareStatement(query.toString());
                }
                String id = request.getParameter("empleado");
                String usuario = request.getParameter("Usuario");
                String contraseña = request.getParameter("contrasena");
                String contraseña2 = request.getParameter("contrasena2");
                String contraseñaN = "";
                if (contraseña.equalsIgnoreCase(contraseña2)) {
                    encriptacion en = new encriptacion();
                    contraseñaN = en.encrip(contraseña);
                } else {
                    //????
                }
                agregarusuario.setString(1, null);
                agregarusuario.setString(2, id);
                agregarusuario.setString(3, usuario);
                agregarusuario.setString(4, contraseñaN);
                Mensaje = agregarusuario.toString();
                int resultado = agregarusuario.executeUpdate();
                if (resultado == 1) {
                    Mensaje = "exito al registrar";
                } else {
                    Mensaje = "Error de registro";
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return Mensaje;
    }

    public String ListaUsuario() {
        StringBuilder salida = new StringBuilder();
        StringBuilder query = new StringBuilder();
        query.append(" select e.nombreempleado, e.apellidopaternoempleado, r.rol, u.NombreUsuario, u.idUsuario from usuario u ");
        query.append(" inner join rol r on r.idrol=u.RolidRol ");
        query.append(" inner Join empleado e on e.idempleado=u.empleadoidempleado where u.estado like 'Activo' ");
        try {
            PreparedStatement pst = conexion.prepareStatement(query.toString());
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                salida.append("<td>");
                salida.append(res.getString(1));
                salida.append(" ");
                salida.append(res.getString(2));
                salida.append("</td><td>");
                salida.append(res.getString(3));
                salida.append("</td><td>");
                salida.append(res.getString(4));
                salida.append("</td><td>");
                salida.append("<a href='ModificarUsuario.jsp?codUsuario=").append(res.getInt(5)).append("'>Modificar </a>");
                salida.append("</td><td>");
                salida.append("<a href='ListaUsuarios.jsp?codUsuario=").append(res.getInt(5)).append("' onclick='ConfirmarEliminacion();'>Eliminar</a>");
                salida.append("</td>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return salida.toString();
    }

    public void MostrarUsuario(String codUsuario) {
        usuariopojo = new UsuarioPojo();
        StringBuilder query = new StringBuilder();
        query.append(" Select idusuario,empleadoidempleado,rolidrol,nombreusuario from usuario where idusuario = ? ");
        try {
            PreparedStatement pst = conexion.prepareStatement(query.toString());
            pst.setInt(1, Integer.parseInt(codUsuario));
            ResultSet res = pst.executeQuery();
            if (res.next()) {
                usuariopojo.setIdUsuario(res.getInt(1));
                usuariopojo.setEmpleadoUsuario(res.getInt(2));
                usuariopojo.setRolUsuario(res.getInt(3));
                usuariopojo.setNombreUsuario(res.getString(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String ModificarUsuario(HttpServletRequest request, String codUsuario) {
        String mensaje = "";
        if (request == null) {
            return "";
        }
        if (conexion != null) {
            try {

                StringBuilder query = new StringBuilder();
                query.append(" update usuario set empleadoidempleado = ?, rolidrol = ?,nombreusuario=? ");
                query.append(" where idusuario = ? ");
                if (modificarusuario == null) {
                    modificarusuario = conexion.prepareStatement(query.toString());
                }
                String idempleado=request.getParameter("empleado");
                int idempleado2=Integer.parseInt(idempleado);
                String idrol=request.getParameter("rol");
                int idrol2=Integer.parseInt(idrol);
                String nombre=request.getParameter("nombre");
                modificarusuario.setInt(1, idempleado2);
                modificarusuario.setInt(2, idrol2);
                modificarusuario.setString(3, nombre);
                modificarusuario.setInt(4, Integer.parseInt(codUsuario==null?"0":codUsuario));
                mensaje=modificarusuario.toString();
                int res=modificarusuario.executeUpdate();
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
    public String EliminarUsuario(HttpServletRequest request, String Codigo){
        String Mensaje ="";
        if (request ==null) {
            return "";
        }
        if (conexion!=null) {
            try {
                StringBuilder query=new StringBuilder();
                query.append(" update usuario set estado='Inactivo' where idUsuario = ? ");
                Eliminarusuario=conexion.prepareStatement(query.toString());
                Eliminarusuario.setInt(1, Integer.parseInt(Codigo));
                int res=Eliminarusuario.executeUpdate();
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

    public UsuarioPojo getUsuariopojo() {
        return usuariopojo;
    }

    public void setUsuariopojo(UsuarioPojo usuariopojo) {
        this.usuariopojo = usuariopojo;
    }

}
