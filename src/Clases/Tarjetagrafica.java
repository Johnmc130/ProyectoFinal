package Clases;

public class Tarjetagrafica {

    private int idtarjetag;
    private String marca;
    private String modelo;
    private int vram;
    private String dlss;
    private String fsr;
    private int watts;
    private int tamano;
    private double precio;
    private int stock;
    private int proveedor;
    private byte[] foto;

    public Tarjetagrafica() {
    }

    public Tarjetagrafica(int idtarjetag, String marca, String modelo, int vram, String dlss, String fsr, int watts, int tamano, double precio, int stock, int proveedor, byte[] foto) {
        this.idtarjetag = idtarjetag;
        this.marca = marca;
        this.modelo = modelo;
        this.vram = vram;
        this.dlss = dlss;
        this.fsr = fsr;
        this.watts = watts;
        this.tamano = tamano;
        this.precio = precio;
        this.stock = stock;
        this.proveedor = proveedor;
        this.foto = foto;
    }
    
    public int getIdtarjetag() {
        return idtarjetag;
    }

    public void setIdtarjetag(int idtarjetag) {
        this.idtarjetag = idtarjetag;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getVram() {
        return vram;
    }

    public void setVram(int vram) {
        this.vram = vram;
    }

    public String getDlss() {
        return dlss;
    }

    public void setDlss(String dlss) {
        this.dlss = dlss;
    }

    public String getFsr() {
        return fsr;
    }

    public void setFsr(String fsr) {
        this.fsr = fsr;
    }

    public int getWatts() {
        return watts;
    }

    public void setWatts(int watts) {
        this.watts = watts;
    }

    public int getTamano() {
        return tamano;
    }

    public void setTamano(int tamano) {
        this.tamano = tamano;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getProveedor() {
        return proveedor;
    }

    public void setProveedor(int proveedor) {
        this.proveedor = proveedor;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    @Override
    public String toString() {
        return "Tarjetagrafica{" + "idtarjetag=" + idtarjetag + ", marca=" + marca + ", modelo=" + modelo + ", vram=" + vram + ", dlss=" + dlss + ", fsr=" + fsr + ", watts=" + watts + ", tamano=" + tamano + ", precio=" + precio + ", stock=" + stock + ", proveedor=" + proveedor + ", foto=" + foto + '}';
    }

}
