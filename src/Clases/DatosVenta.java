/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author Steven Zhicay
 */
public class DatosVenta {

    private int id_cliente;
    private String nombres;
    private String apellidos;
    private String movil;
    private String direccion;
    private String numeroCuenta;
    private String codigoSeguridad;
    private String fechaExpiracion;

    public DatosVenta() {
    }

    public DatosVenta(int id_cliente, String nombres, String apellidos, String movil, String direccion, String numeroCuenta, String codigoSeguridad, String fechaExpiracion) {
        this.id_cliente = id_cliente;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.movil = movil;
        this.direccion = direccion;
        this.numeroCuenta = numeroCuenta;
        this.codigoSeguridad = codigoSeguridad;
        this.fechaExpiracion = fechaExpiracion;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
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

    public String getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(String fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }

    @Override
    public String toString() {
        return "DatosVenta{" + "id_cliente=" + id_cliente + ", nombres=" + nombres + ", apellidos=" + apellidos + ", movil=" + movil + ", direccion=" + direccion + ", numeroCuenta=" + numeroCuenta + ", codigoSeguridad=" + codigoSeguridad + ", fechaExpiracion=" + fechaExpiracion + '}';
    }
}
