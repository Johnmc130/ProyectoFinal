package Clases;

public class Proveedor extends Persona {

    private int id_proveedor;
    private String contraseña;
    private String cedula_prov;

    public Proveedor() {
    }

    public Proveedor(int id_proveedor, String contraseña, String cedula_prov) {
        this.id_proveedor = id_proveedor;
        this.contraseña = contraseña;
        this.cedula_prov = cedula_prov;
    }

    public int getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getCedula_prov() {
        return cedula_prov;
    }

    public void setCedula_prov(String cedula_prov) {
        this.cedula_prov = cedula_prov;
    }

    @Override
    public String toString() {
        return "Proveedor{" + "id_proveedor=" + id_proveedor + ", contrase\u00f1a=" + contraseña + ", cedula_prov=" + cedula_prov + '}';
    }

}
