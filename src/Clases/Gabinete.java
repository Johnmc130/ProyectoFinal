package Clases;

public class Gabinete {

    private int idgabinete;
    private String marca;
    private String modelo;
    private String puertousb;
    private String ventiladores;
    private int tamanoventilador;
    private String fuentepoder;
    private int tamanomaxvideo;
    private String formato;
    private String placamadre;
    private String bahias;
    private double precio;
    private int stock;
    private int proveedor;
    private byte[] foto;

    public Gabinete() {
    }

    public Gabinete(int idgabinete, String marca, String modelo, String puertousb, String ventiladores, int tamanoventilador, String fuentepoder, int tamanomaxvideo, String formato, String placamadre, String bahias, double precio, int stock, int proveedor, byte[] foto) {
        this.idgabinete = idgabinete;
        this.marca = marca;
        this.modelo = modelo;
        this.puertousb = puertousb;
        this.ventiladores = ventiladores;
        this.tamanoventilador = tamanoventilador;
        this.fuentepoder = fuentepoder;
        this.tamanomaxvideo = tamanomaxvideo;
        this.formato = formato;
        this.placamadre = placamadre;
        this.bahias = bahias;
        this.precio = precio;
        this.stock = stock;
        this.proveedor = proveedor;
        this.foto = foto;
    }

    public int getIdgabinete() {
        return idgabinete;
    }

    public void setIdgabinete(int idgabinete) {
        this.idgabinete = idgabinete;
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
        this.modelo = modelo;
    }

    public String getPuertousb() {
        return puertousb;
    }

    public void setPuertousb(String puertousb) {
        this.puertousb = puertousb;
    }

    public String getVentiladores() {
        return ventiladores;
    }

    public void setVentiladores(String ventiladores) {
        this.ventiladores = ventiladores;
    }

    public int getTamanoventilador() {
        return tamanoventilador;
    }

    public void setTamanoventilador(int tamanoventilador) {
        this.tamanoventilador = tamanoventilador;
    }

    public String getFuentepoder() {
        return fuentepoder;
    }

    public void setFuentepoder(String fuentepoder) {
        this.fuentepoder = fuentepoder;
    }

    public int getTamanomaxvideo() {
        return tamanomaxvideo;
    }

    public void setTamanomaxvideo(int tamanomaxvideo) {
        this.tamanomaxvideo = tamanomaxvideo;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public String getPlacamadre() {
        return placamadre;
    }

    public void setPlacamadre(String placamadre) {
        this.placamadre = placamadre;
    }

    public String getBahias() {
        return bahias;
    }

    public void setBahias(String bahias) {
        this.bahias = bahias;
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
        return "Gabinete{" + "idgabinete=" + idgabinete + ", marca=" + marca + ", modelo=" + modelo + ", puertousb=" + puertousb + ", ventiladores=" + ventiladores + ", tamanoventilador=" + tamanoventilador + ", fuentepoder=" + fuentepoder + ", tamanomaxvideo=" + tamanomaxvideo + ", formato=" + formato + ", placamadre=" + placamadre + ", bahias=" + bahias + ", precio=" + precio + ", stock=" + stock + ", proveedor=" + proveedor + ", foto=" + foto + '}';
    }

}
