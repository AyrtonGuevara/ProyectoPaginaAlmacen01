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
public class PedidoPojo implements Serializable{
    private int CantidadProductos;
    private String Carrito;
    private int proveedor;
    private String RSproveedor;
    private float TotalPedido;
    private int[] ListaProductos;
    
    public PedidoPojo(){
    }

    public int getCantidadProductos() {
        return CantidadProductos;
    }

    public void setCantidadProductos(int CantidadProductos) {
        this.CantidadProductos = CantidadProductos;
    }

    public String getCarrito() {
        return Carrito;
    }

    public void setCarrito(String Carrito) {
        this.Carrito = Carrito;
    }

    public int getProveedor() {
        return proveedor;
    }

    public void setProveedor(int proveedor) {
        this.proveedor = proveedor;
    }

    public String getRSproveedor() {
        return RSproveedor;
    }

    public void setRSproveedor(String RSproveedor) {
        this.RSproveedor = RSproveedor;
    }

    public float getTotalPedido() {
        return TotalPedido;
    }

    public void setTotalPedido(float TotalPedido) {
        this.TotalPedido = TotalPedido;
    }

    public int[] getListaProductos() {
        return ListaProductos;
    }

    public void setListaProductos(int[] ListaProductos) {
        this.ListaProductos = ListaProductos;
    }
    
    
    
}
