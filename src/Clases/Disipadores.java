
package Clases;


public class Disipadores {

    private int idDisipadores;
    private String marca;
    private String modelo;
    private String Socket;	//	-----------compativilidad con procesador
    private String RGB;	//:si/no
    private int Ventiladores; //: 1,2 o 3
    private double precio;
    private int id_proveedor;
    private int Stock;
    private byte[] foto;

    public Disipadores() {
    }

    public Disipadores(int idDisipadores, String marca, String modelo, String Socket, String RGB, int Ventiladores, double precio, int id_proveedor, int Stock, byte[] foto) {
        this.idDisipadores = idDisipadores;
        this.marca = marca;
        this.modelo = modelo;
        this.Socket = Socket;
        this.RGB = RGB;
        this.Ventiladores = Ventiladores;
        this.precio = precio;
        this.id_proveedor = id_proveedor;
        this.Stock = Stock;
        this.foto = foto;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

  

    public int getIdDisipadores() {
        return idDisipadores;
    }

    public void setIdDisipadores(int idDisipadores) {
        this.idDisipadores = idDisipadores;
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

    public String getSocket() {
        return Socket;
    }

    public void setSocket(String Socket) {
        this.Socket = Socket;
    }

    public String getRGB() {
        return RGB;
    }

    public void setRGB(String RGB) {
        this.RGB = RGB;
    }

    public int getVentiladores() {
        return Ventiladores;
    }

    public void setVentiladores(int Ventiladores) {
        this.Ventiladores = Ventiladores;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public int getStock() {
        return Stock;
    }

    public void setStock(int Stock) {
        this.Stock = Stock;
    }

}
