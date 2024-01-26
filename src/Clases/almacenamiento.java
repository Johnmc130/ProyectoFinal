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
public class almacenamiento {

    private int Idalmacenamiento;

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public almacenamiento(int Idalmacenamiento) {
        this.Idalmacenamiento = Idalmacenamiento;
    }
    private String marca;
    private String Modelo;
    private String tipo;	//:ssd, hdd o m2
    private int capacidad;
    private int stock;
    private double precio;
    private int id_proveedor;

    public almacenamiento() {
    }

    public almacenamiento(String marca, String Modelo, String tipo, int capacidad, double precio, int id_proveedor) {
        this.marca = marca;
        this.Modelo = Modelo;
        this.tipo = tipo;
        this.capacidad = capacidad;
        this.precio = precio;
        this.id_proveedor = id_proveedor;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return Modelo;
    }

    public int getIdalmacenamiento() {
        return Idalmacenamiento;
    }

    public void setIdalmacenamiento(int Idalmacenamiento) {
        this.Idalmacenamiento = Idalmacenamiento;
    }

    public void setModelo(String Modelo) {
        this.Modelo = Modelo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
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

}
