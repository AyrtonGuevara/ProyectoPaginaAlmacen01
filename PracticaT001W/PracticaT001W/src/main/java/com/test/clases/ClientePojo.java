/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.clases;

/**
 *
 * @author ayrton
 */
public class ClientePojo {
    private int idcliente;
    private String NombreCliente;
    private String ApellidoCliente;
    private String NITCI;
    
    public ClientePojo(){
        
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public String getNombreCliente() {
        return NombreCliente;
    }

    public void setNombreCliente(String NombreCliente) {
        this.NombreCliente = NombreCliente;
    }

    public String getApellidoCliente() {
        return ApellidoCliente;
    }

    public void setApellidoCliente(String ApellidoCliente) {
        this.ApellidoCliente = ApellidoCliente;
    }

    public String getNITCI() {
        return NITCI;
    }

    public void setNITCI(String NITCI) {
        this.NITCI = NITCI;
    }
    
    
}
