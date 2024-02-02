/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author EDU
 */
public class Ventiladores {

    private int idVentiladores;
    private String marca;
    private String modelo;
    private String RGB; //si/no
    private int tamaño; // : 120 mm -----------compativilidad con Gabinetes
    private double precio;
    private int id_proveedor;
    private int stock;

    public Ventiladores() {
    }

    public Ventiladores(int idVentiladores, String marca, String modelo, String RGB, int tamaño, double precio, int id_proveedor, int stock) {
        this.idVentiladores = idVentiladores;
        this.marca = marca;
        this.modelo = modelo;
        this.RGB = RGB;
        this.tamaño = tamaño;
        this.precio = precio;
        this.id_proveedor = id_proveedor;
        this.stock = stock;
    }

    public int getIdVentiladores() {
        return idVentiladores;
    }

    public void setIdVentiladores(int idVentiladores) {
        this.idVentiladores = idVentiladores;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getRGB() {
        return RGB;
    }

    public void setRGB(String RGB) {
        this.RGB = RGB;
    }

    public int getTamaño() {
        return tamaño;
    }

    public void setTamaño(int tamaño) {
        this.tamaño = tamaño;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

}
