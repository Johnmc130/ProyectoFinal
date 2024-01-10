package Clases;

import java.util.Date;

public class Cliente extends Persona {

    private String id_cliente;
    private String usuario;
    private String contraseña;

    public Cliente() {
    }

    public Cliente(String id_cliente, String usuario, String contraseña, String cedula, String nombre, String apellido, Date fecha_nac, int edad, char sexo, String direccion, String telefono) {
        super(cedula, nombre, apellido, fecha_nac, edad, sexo, direccion, telefono);
        this.id_cliente = id_cliente;
        this.usuario = usuario;
        this.contraseña = contraseña;
    }

    public String getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(String id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id_cliente=" + id_cliente + ", usuario=" + usuario + ", contrase\u00f1a=" + contraseña + '}';
    }

}
