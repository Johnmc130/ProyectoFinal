
package Clases;

/**
 *
 * @author TheBigG
 */
public class Procesador {
    private int idProcesador;
    private String marca;
    private String modelo;
    private int nucleosFisicos;
    private double ghz;
    private String socket;
    private int maximoVram;
    private int watts;
    private double precio;
    private byte[] imagen;
    private int stock;
    private int idProveedor;

    // Constructor
    public Procesador() {
        // Constructor vacío
    }

    public Procesador(int idProcesador, String marca, String modelo, int nucleosFisicos, double ghz, String socket, int maximoVram, int watts, double precio, byte[] imagen, int stock, int idProveedor) {
        this.idProcesador = idProcesador;
        this.marca = marca;
        this.modelo = modelo;
        this.nucleosFisicos = nucleosFisicos;
        this.ghz = ghz;
        this.socket = socket;
        this.maximoVram = maximoVram;
        this.watts = watts;
        this.precio = precio;
        this.imagen = imagen;
        this.stock = stock;
        this.idProveedor = idProveedor;
    }
    
    

    public int getIdProcesador() {
        return idProcesador;
    }

    public void setIdProcesador(int idProcesador) {
        this.idProcesador = idProcesador;
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

    public int getNucleosFisicos() {
        return nucleosFisicos;
    }

    public void setNucleosFisicos(int nucleosFisicos) {
        this.nucleosFisicos = nucleosFisicos;
    }

    public double getGhz() {
        return ghz;
    }

    public void setGhz(double ghz) {
        this.ghz = ghz;
    }

    public String getSocket() {
        return socket;
    }

    public void setSocket(String socket) {
        this.socket = socket;
    }

    public int getMaximoVram() {
        return maximoVram;
    }

    public void setMaximoVram(int maximoVram) {
        this.maximoVram = maximoVram;
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

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    
}
