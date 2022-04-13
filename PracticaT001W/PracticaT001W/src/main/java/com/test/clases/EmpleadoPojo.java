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
public class EmpleadoPojo implements Serializable{
    private int codEmpleado;
    private int CargoEmpleado;
    private String NombreEmpleado;
    private String ApellidoPaterno;
    private String ApellidoMaterno;
    private int edadEmpleado;
    private String DireccionEmpleado;
    private int CIEmpleado;
    
    public EmpleadoPojo(){
        
    }

    public int getCodEmpleado() {
        return codEmpleado;
    }

    public void setCodEmpleado(int codEmpleado) {
        this.codEmpleado = codEmpleado;
    }

    public int getCargoEmpleado() {
        return CargoEmpleado;
    }

    public void setCargoEmpleado(int CargoEmpleado) {
        this.CargoEmpleado = CargoEmpleado;
    }

    public String getNombreEmpleado() {
        return NombreEmpleado;
    }

    public void setNombreEmpleado(String NombreEmpleado) {
        this.NombreEmpleado = NombreEmpleado;
    }

    public String getApellidoPaterno() {
        return ApellidoPaterno;
    }

    public void setApellidoPaterno(String ApellidoPaterno) {
        this.ApellidoPaterno = ApellidoPaterno;
    }

    public String getApellidoMaterno() {
        return ApellidoMaterno;
    }

    public void setApellidoMaterno(String ApellidoMaterno) {
        this.ApellidoMaterno = ApellidoMaterno;
    }

    public int getEdadEmpleado() {
        return edadEmpleado;
    }

    public void setEdadEmpleado(int edadEmpleado) {
        this.edadEmpleado = edadEmpleado;
    }

    public String getDireccionEmpleado() {
        return DireccionEmpleado;
    }

    public void setDireccionEmpleado(String DireccionEmpleado) {
        this.DireccionEmpleado = DireccionEmpleado;
    }

    public int getCIEmpleado() {
        return CIEmpleado;
    }

    public void setCIEmpleado(int CIEmpleado) {
        this.CIEmpleado = CIEmpleado;
    }


    
    
}
