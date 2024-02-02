package Clases;

public class Placamadre {

    private int idplacam;
    private String marca;
    private String modelo;
    private String puertosalmacenamiento;
    private String puertosusb;
    private String socket;
    private int tiposram;
    private int maximoram;
    private String ranuraexpansion;
    private String formato;
    private int watts;
    private double precio;
    private int stock;
    private int proveedor;
    private byte[] foto;

    public Placamadre() {
    }

    public Placamadre(int idplacam, String marca, String modelo, String puertosalmacenamiento, String puertosusb, String socket, int tiposram, int maximoram, String ranuraexpansion, String formato, int watts, double precio, int stock, int proveedor, byte[] foto) {
        this.idplacam = idplacam;
        this.marca = marca;
        this.modelo = modelo;
        this.puertosalmacenamiento = puertosalmacenamiento;
        this.puertosusb = puertosusb;
        this.socket = socket;
        this.tiposram = tiposram;
        this.maximoram = maximoram;
        this.ranuraexpansion = ranuraexpansion;
        this.formato = formato;
        this.watts = watts;
        this.precio = precio;
        this.stock = stock;
        this.proveedor = proveedor;
        this.foto = foto;
    }

    public int getIdplacam() {
        return idplacam;
    }

    public void setIdplacam(int idplacam) {
        this.idplacam = idplacam;
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

    public String getPuertosalmacenamiento() {
        return puertosalmacenamiento;
    }

    public void setPuertosalmacenamiento(String puertosalmacenamiento) {
        this.puertosalmacenamiento = puertosalmacenamiento;
    }

    public String getPuertosusb() {
        return puertosusb;
    }

    public void setPuertosusb(String puertosusb) {
        this.puertosusb = puertosusb;
    }

    public String getSocket() {
        return socket;
    }

    public void setSocket(String socket) {
        this.socket = socket;
    }

    public int getTiposram() {
        return tiposram;
    }

    public void setTiposram(int tiposram) {
        this.tiposram = tiposram;
    }

    public int getMaximoram() {
        return maximoram;
    }

    public void setMaximoram(int maximoram) {
        this.maximoram = maximoram;
    }

    public String getRanuraexpansion() {
        return ranuraexpansion;
    }

    public void setRanuraexpansion(String ranuraexpansion) {
        this.ranuraexpansion = ranuraexpansion;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public int getWatts() {
        return watts;
    }

    public void setWatts(int watts) {
        this.watts = watts;
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
        return "placamadre{" + "idplacam=" + idplacam + ", marca=" + marca + ", modelo=" + modelo + ", puertosalmacenamiento=" + puertosalmacenamiento + ", puertosusb=" + puertosusb + ", socket=" + socket + ", tiposram=" + tiposram + ", maximoram=" + maximoram + ", ranuraexpansion=" + ranuraexpansion + ", formato=" + formato + ", watts=" + watts + ", precio=" + precio + ", stock=" + stock + ", proveedor=" + proveedor + ", foto=" + foto + '}';
    }
    
    

}
