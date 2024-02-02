/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author EDU
 */
public class FuentePoder {

    private int idFuentePoder;
    private String marca;
    private String modelo;
    private String watts;
    private String certificacion; //:80Plus
    private String modular;	//:si/no
    private String formato;   	//:ATX -----------compativilidad con Gabinete
    private double precio;
    private int id_proveedor;

    private int Stock;

    public FuentePoder(int idFuentePoder, String marca, String modelo, String watts, String certificacion, String modular, String formato, double precio, int id_proveedor, int Stock) {
        this.idFuentePoder = idFuentePoder;
        this.marca = marca;
        this.modelo = modelo;
        this.watts = watts;
        this.certificacion = certificacion;
        this.modular = modular;
        this.formato = formato;
        this.precio = precio;
        this.id_proveedor = id_proveedor;
        this.Stock = Stock;

    }

    public int getIdFuentePoder() {
        return idFuentePoder;
    }

    public void setIdFuentePoder(int idFuentePoder) {
        this.idFuentePoder = idFuentePoder;
    }
    
    

    public FuentePoder() {
    }

    public int getStock() {
        return Stock;
    }

    public void setStock(int Stock) {
        this.Stock = Stock;
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
        this.modelo =  modelo;
    }

    public String getWatts() {
        return watts;
    }

    public void setWatts(String watts) {
        this.watts = watts;
    }

    public String getCertificacion() {
        return certificacion;
    }

    public void setCertificacion(String Certificacion) {
        this.certificacion = Certificacion;
    }

    public String getModular() {
        return modular;
    }

    public void setModular(String modular) {
        this.modular = modular;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
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
