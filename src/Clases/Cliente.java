package Clases;

import java.util.Date;

public class Cliente extends Persona {

    private String id_cliente;
    private String contraseña;

    public Cliente() {
    }

    public Cliente(String id_cliente, String contraseña) {
        this.id_cliente = id_cliente;
        this.contraseña = contraseña;
    }

    public String getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(String id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id_cliente=" + id_cliente + ", contraseña=" + contraseña + '}';
    }

}
