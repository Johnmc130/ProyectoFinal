package Clases;

public class Cliente extends Persona {

    private int id_cliente;
    private String contraseña;
    private String cedula_cli;

    public Cliente() {
    }

    public Cliente(int id_cliente, String contraseña, String cedula_cli) {
        this.id_cliente = id_cliente;
        this.contraseña = contraseña;
        this.cedula_cli = cedula_cli;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getCedula_cli() {
        return cedula_cli;
    }

    public void setCedula_cli(String cedula_cli) {
        this.cedula_cli = cedula_cli;
    }

}
