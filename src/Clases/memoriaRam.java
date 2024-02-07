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
public class memoriaRam {

    private int idMemoriaRam;
    private String marca;
    private String modelo;
    private int numeroModulos;
    private int capacidad;	//cuanta cantidad de ram
    private String tipo;	//:ddr4 o ddr5	-----------compativilidad con placa madre
    private double precio;
    private int id_proveedor;
    private int stock;
    private byte[] foto;

    public memoriaRam() {
    }

    public memoriaRam(int idMemoriaRam, String marca, String modelo, int numeroModulos, int capacidad, String tipo, double precio, int id_proveedor, int stock, byte[] foto) {
        this.idMemoriaRam = idMemoriaRam;
        this.marca = marca;
        this.modelo = modelo;
        this.numeroModulos = numeroModulos;
        this.capacidad = capacidad;
        this.tipo = tipo;
        this.precio = precio;
        this.id_proveedor = id_proveedor;
        this.stock = stock;
        this.foto = foto;
    }

    public int getIdMemoriaRam() {
        return idMemoriaRam;
    }

    public void setIdMemoriaRam(int idMemoriaRam) {
        this.idMemoriaRam = idMemoriaRam;
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

    public int getNumeroModulos() {
        return numeroModulos;
    }

    public void setNumeroModulos(int numeroModulos) {
        this.numeroModulos = numeroModulos;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    @Override
    public String toString() {
        return "memoriaRam{" + "idMemoriaRam=" + idMemoriaRam + ", marca=" + marca + ", modelo=" + modelo + ", numeroModulos=" + numeroModulos + ", capacidad=" + capacidad + ", tipo=" + tipo + ", precio=" + precio + ", id_proveedor=" + id_proveedor + ", stock=" + stock + ", foto=" + foto + '}';
    }

    

}
