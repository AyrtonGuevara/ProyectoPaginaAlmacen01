/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.clases;

import java.io.Serializable;

/**
 *
 * @author ayrton
 */
public class UsuarioPojo implements Serializable{
    private int IdUsuario;
    private int EmpleadoUsuario;
    private int RolUsuario;
    private String NombreUsuario;
    public UsuarioPojo(){
        
    }

    public int getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(int IdUsuario) {
        this.IdUsuario = IdUsuario;
    }

    public int getEmpleadoUsuario() {
        return EmpleadoUsuario;
    }

    public void setEmpleadoUsuario(int EmpleadoUsuario) {
        this.EmpleadoUsuario = EmpleadoUsuario;
    }

    public int getRolUsuario() {
        return RolUsuario;
    }

    public void setRolUsuario(int RolUsuario) {
        this.RolUsuario = RolUsuario;
    }

    public String getNombreUsuario() {
        return NombreUsuario;
    }

    public void setNombreUsuario(String NombreUsuario) {
        this.NombreUsuario = NombreUsuario;
    }
    
}
