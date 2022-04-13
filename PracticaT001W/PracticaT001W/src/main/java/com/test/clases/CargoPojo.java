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
public class CargoPojo implements Serializable{
    private int codcargo;
    private String NombreCargo;
    
    public CargoPojo(){
        
    }

    public int getCodcargo() {
        return codcargo;
    }

    public void setCodcargo(int codcargo) {
        this.codcargo = codcargo;
    }

    public String getNombreCargo() {
        return NombreCargo;
    }

    public void setNombreCargo(String NombreCargo) {
        this.NombreCargo = NombreCargo;
    }
    
}
