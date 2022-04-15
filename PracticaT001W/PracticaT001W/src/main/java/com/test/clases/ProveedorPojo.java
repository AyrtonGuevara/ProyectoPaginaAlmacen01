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
public class ProveedorPojo {
    private int idPorveedor;
    private String RazonSocialProveedor;
    private String ContactoProveedor;
    private String TelefonoContacto;
    private String DireccionProveedor;
    
    public ProveedorPojo(){
        
    }

    public int getIdPorveedor() {
        return idPorveedor;
    }

    public void setIdPorveedor(int idPorveedor) {
        this.idPorveedor = idPorveedor;
    }

    public String getRazonSocialProveedor() {
        return RazonSocialProveedor;
    }

    public void setRazonSocialProveedor(String RazonSocialProveedor) {
        this.RazonSocialProveedor = RazonSocialProveedor;
    }

    public String getContactoProveedor() {
        return ContactoProveedor;
    }

    public void setContactoProveedor(String ContactoProveedor) {
        this.ContactoProveedor = ContactoProveedor;
    }

    public String getTelefonoContacto() {
        return TelefonoContacto;
    }

    public void setTelefonoContacto(String TelefonoContacto) {
        this.TelefonoContacto = TelefonoContacto;
    }

    public String getDireccionProveedor() {
        return DireccionProveedor;
    }

    public void setDireccionProveedor(String DireccionProveedor) {
        this.DireccionProveedor = DireccionProveedor;
    }
    
}
