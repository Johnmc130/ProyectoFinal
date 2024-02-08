package Clases;

public class Administrador extends Persona {

    private int id_admin;
    private String contraseña;
    private String cedula_admin;

    public Administrador() {
    }

    public Administrador(int id_admin, String contraseña, String cedula_admin) {
        this.id_admin = id_admin;
        this.contraseña = contraseña;
        this.cedula_admin = cedula_admin;
    }

    public int getId_admin() {
        return id_admin;
    }

    public void setId_admin(int id_admin) {
        this.id_admin = id_admin;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getCedula_admin() {
        return cedula_admin;
    }

    public void setCedula_admin(String cedula_admin) {
        this.cedula_admin = cedula_admin;
    }

    @Override
    public String toString() {
        return "Administrador{" + "id_admin=" + id_admin + ", contrase\u00f1a=" + contraseña + ", cedula_admin=" + cedula_admin + '}';
    }

}
