package Clases;

import java.util.Date;

public class Persona {

    private String cedula;
    private String nombre;
    private String apellido;
    private Date fecha_nac;
    private int edad;
    private char sexo;
    private String direccion;
    private String telefono;

    public Persona() {
    }

    public Persona(String cedula, String nombre, String apellido, Date fecha_nac, int edad, char sexo, String direccion, String telefono) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecha_nac = fecha_nac;
        this.edad = edad;
        this.sexo = sexo;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(Date fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Persona{" + "cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido + ", fecha_nac=" + fecha_nac + ", edad=" + edad + ", sexo=" + sexo + ", direccion=" + direccion + ", telefono=" + telefono + '}';
    }

}
