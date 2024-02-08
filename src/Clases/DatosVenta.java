/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.Date;

/**
 *
 * @author Steven Zhicay
 */
public class DatosVenta {

    private int id_datos;
    private String nombres;
    private String apellidos;
    private String movil;
    private String direccion;
    private String numeroCuenta;
    private String codigoSeguridad;
    private Date fechaExpiracion;
    private String nombreProducto;
    private int id_producto;
    private int id_cliente;

    public DatosVenta() {
    }

    public DatosVenta(int id_datos, String nombres, String apellidos, String movil, String direccion, String numeroCuenta, String codigoSeguridad, Date fechaExpiracion, String nombreProducto, int id_producto, int id_cliente) {
        this.id_datos = id_datos;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.movil = movil;
        this.direccion = direccion;
        this.numeroCuenta = numeroCuenta;
        this.codigoSeguridad = codigoSeguridad;
        this.fechaExpiracion = fechaExpiracion;
        this.nombreProducto = nombreProducto;
        this.id_producto = id_producto;
        this.id_cliente = id_cliente;
    }

    public int getId_datos() {
        return id_datos;
    }

    public void setId_datos(int id_datos) {
        this.id_datos = id_datos;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getMovil() {
        return movil;
    }

    public void setMovil(String movil) {
        this.movil = movil;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getCodigoSeguridad() {
        return codigoSeguridad;
    }

    public void setCodigoSeguridad(String codigoSeguridad) {
        this.codigoSeguridad = codigoSeguridad;
    }

    public Date getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(Date fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    @Override
    public String toString() {
        return "DatosVenta{" + "id_datos=" + id_datos + ", nombres=" + nombres + ", apellidos=" + apellidos + ", movil=" + movil + ", direccion=" + direccion + ", numeroCuenta=" + numeroCuenta + ", codigoSeguridad=" + codigoSeguridad + ", fechaExpiracion=" + fechaExpiracion + ", nombreProducto=" + nombreProducto + ", id_producto=" + id_producto + ", id_cliente=" + id_cliente + '}';
    }

}
