/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Clases.*;
import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author TheBigG
 */
public class ModeloPcResumen {

    private Conexion conexion;

    public ModeloPcResumen() {
        conexion = new Conexion();
    }

    public static PC cargarPc(int id) {
          Conexion conexion = new Conexion();
        PC pc = null;
        try {
            // Construye la consulta SQL para obtener los datos de la cotización según el id
            String consulta = "SELECT * FROM cotizacion WHERE id = " + id;

            // Ejecuta la consulta y obtiene el resultado
            ResultSet resultado = conexion.consultaBase(consulta);

            // Verifica si hay resultados y lee los datos
            if (resultado.next()) {
                // Lee los valores de las columnas de la fila actual
                int idPc = resultado.getInt("id");
                int idProcesador = resultado.getInt("id_procesador");
                int idPlacaMadre = resultado.getInt("id_placa_madre");
                int idTarjetaGrafica = resultado.getInt("id_tarjeta_grafica");
                int idRam = resultado.getInt("id_ram");
                int idFuentePoder = resultado.getInt("id_fuente_poder");
                int idAlmacenamiento = resultado.getInt("id_almacenamiento");
                int idGabinete = resultado.getInt("id_gabinete");
                int idDisipador = resultado.getInt("id_disipador");
                int idVentiladores = resultado.getInt("id_ventilador");

                // Crea una instancia de PC con los valores leídos
                pc = new PC(idPc, idProcesador, idPlacaMadre, idTarjetaGrafica, idRam,
                        idFuentePoder, idAlmacenamiento, idGabinete, idVentiladores, idDisipador);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            // Cierra la conexión
            conexion.cerrar();
        }
        return pc;
    }

    // Método para cargar un procesador por su ID
    public static Procesador cargarProcesador(int id) {
        Conexion conexion = new Conexion();
        Procesador procesador = null;
        try {
            String consulta = "SELECT * FROM procesador WHERE idprocesador = " + id;
            ResultSet resultado = conexion.consultaBase(consulta);
            if (resultado.next()) {
                procesador = new Procesador();
                procesador.setIdProcesador(resultado.getInt("idprocesador"));
                procesador.setMarca(resultado.getString("marca"));
                procesador.setModelo(resultado.getString("modelo"));
                procesador.setNucleosFisicos(resultado.getInt("nucleosfisicos"));
                procesador.setGhz(resultado.getDouble("ghz"));
                procesador.setSocket(resultado.getString("socket"));
                procesador.setMaximoVram(resultado.getInt("maximoram"));
                procesador.setWatts(resultado.getInt("watts"));
                procesador.setPrecio(resultado.getDouble("precio"));
                procesador.setIdProveedor(resultado.getInt("proveedor"));
                procesador.setImagen(resultado.getBytes("imagen"));
                procesador.setStock(resultado.getInt("stock"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            conexion.cerrar();
        }
        return procesador;
    }

    // Método para cargar una placa madre por su ID
    public static Placamadre cargarPlacaMadre(int id) {
        Conexion conexion = new Conexion();
        Placamadre placaMadre = null;
        try {
            String consulta = "SELECT * FROM placamadre WHERE idplacamadre = " + id;
            ResultSet rs = conexion.consultaBase(consulta);
            if (rs.next()) {
                placaMadre = new Placamadre();
                placaMadre.setIdplacam(rs.getInt("idplacamadre"));
                placaMadre.setMarca(rs.getString("marca"));
                placaMadre.setModelo(rs.getString("modelo"));
                placaMadre.setPuertosalmacenamiento(rs.getString("puertosdealmacenamiento"));
                placaMadre.setPuertosusb(rs.getString("puertousb"));
                placaMadre.setSocket(rs.getString("socket"));
                placaMadre.setTiposram(rs.getString("tiporam"));
                placaMadre.setMaximoram(rs.getInt("maximoram"));
                placaMadre.setRanuraexpansion(rs.getString("ranurasexpansion"));
                placaMadre.setFormato(rs.getString("formato"));
                placaMadre.setWatts(rs.getInt("watts"));
                placaMadre.setPrecio(rs.getDouble("precio"));
                placaMadre.setStock(rs.getInt("Stock"));
                placaMadre.setProveedor(rs.getInt("proveedor"));
                placaMadre.setFoto(rs.getBytes("foto"));
                
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            conexion.cerrar();
        }
        
        return placaMadre;
    }

    // Método para cargar una tarjeta gráfica por su ID
    public static Tarjetagrafica cargarTarjetaGrafica(int id) {
        Conexion conexion = new Conexion();
        Tarjetagrafica tarjetaGrafica = null;
        try {
            String consulta = "SELECT * FROM tarjetagrafica WHERE idtarjetagrafica = " + id;
            ResultSet resultado = conexion.consultaBase(consulta);
            if (resultado.next()) {
                tarjetaGrafica = new Tarjetagrafica();
                tarjetaGrafica.setIdtarjetag(resultado.getInt("idtarjetagrafica"));
                tarjetaGrafica.setMarca(resultado.getString("marca"));
                tarjetaGrafica.setModelo(resultado.getString("modelo"));
                tarjetaGrafica.setVram(resultado.getInt("vram"));
                tarjetaGrafica.setDlss(resultado.getString("dlss"));
                tarjetaGrafica.setFsr(resultado.getString("fsr"));
                tarjetaGrafica.setWatts(resultado.getInt("watts"));
                tarjetaGrafica.setTamano(resultado.getInt("tamano"));
                tarjetaGrafica.setPrecio(resultado.getDouble("precio"));
                tarjetaGrafica.setStock(resultado.getInt("stock"));
                tarjetaGrafica.setProveedor(resultado.getInt("proveedor"));
                tarjetaGrafica.setFoto(resultado.getBytes("foto"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            conexion.cerrar();
        }
        return tarjetaGrafica;
    }

    // Método para cargar memoria RAM por su ID
    public static memoriaRam cargarMemoriaRam(int id) {
        Conexion conexion = new Conexion();
        memoriaRam memoriaRam = null;
        try {
            String consulta = "SELECT * FROM memoria_ram WHERE idmemoriaram = " + id;
            ResultSet resultado = conexion.consultaBase(consulta);
            if (resultado.next()) {
                memoriaRam = new memoriaRam();
                memoriaRam.setIdMemoriaRam(resultado.getInt("idmemoriaram"));
                memoriaRam.setMarca(resultado.getString("marca"));
                memoriaRam.setModelo(resultado.getString("modelo"));
                memoriaRam.setNumeroModulos(resultado.getInt("numeromodulos"));
                memoriaRam.setCapacidad(resultado.getInt("capacidad"));
                memoriaRam.setTipo(resultado.getString("tipo"));
                memoriaRam.setPrecio(resultado.getDouble("precio"));
                memoriaRam.setId_proveedor(resultado.getInt("id_proveedor"));
                memoriaRam.setStock(resultado.getInt("stock"));
                memoriaRam.setFoto(resultado.getBytes("foto"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            conexion.cerrar();
        }
        return memoriaRam;
    }

    // Método para cargar Fuente de Poder por su ID
    public static FuentePoder cargarFuentePoder(int id) {
        Conexion conexion = new Conexion();
        FuentePoder fuentePoder = null;
        try {
            String consulta = "SELECT * FROM fuente_poder WHERE idfuentepoder = " + id;
            ResultSet resultado = conexion.consultaBase(consulta);
            if (resultado.next()) {
                fuentePoder = new FuentePoder();
                fuentePoder.setIdFuentePoder(resultado.getInt("idfuentepoder"));
                fuentePoder.setMarca(resultado.getString("marca"));
                fuentePoder.setModelo(resultado.getString("modelo"));
                fuentePoder.setWatts(resultado.getString("watts"));
                fuentePoder.setCertificacion(resultado.getString("certificacion"));
                fuentePoder.setModular(resultado.getString("modular"));
                fuentePoder.setFormato(resultado.getString("formato"));
                fuentePoder.setPrecio(resultado.getDouble("precio"));
                fuentePoder.setId_proveedor(resultado.getInt("id_proveedor"));
                fuentePoder.setStock(resultado.getInt("stock"));
                fuentePoder.setFoto(resultado.getBytes("foto"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            conexion.cerrar();
        }
        return fuentePoder;
    }

    // Método para cargar Almacenamiento por su ID
    public static almacenamiento cargarAlmacenamiento(int id) {
        Conexion conexion = new Conexion();
        almacenamiento almacenamiento = null;
        try {
            String consulta = "SELECT * FROM almacenamiento WHERE idalmacenamiento = " + id;
            ResultSet resultado = conexion.consultaBase(consulta);
            if (resultado.next()) {
                almacenamiento = new almacenamiento();
                almacenamiento.setIdalmacenamiento(resultado.getInt("idalmacenamiento"));
                almacenamiento.setMarca(resultado.getString("marca"));
                almacenamiento.setModelo(resultado.getString("modelo"));
                almacenamiento.setTipo(resultado.getString("tipo"));
                almacenamiento.setCapacidad(resultado.getInt("capacidad"));
                almacenamiento.setStock(resultado.getInt("stock"));
                almacenamiento.setPrecio(resultado.getDouble("precio"));
                almacenamiento.setId_proveedor(resultado.getInt("idproveedoralma"));
                almacenamiento.setFoto(resultado.getBytes("foto"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            conexion.cerrar();
        }
        return almacenamiento;
    }

    // Método para cargar Gabinete por su ID
    public static Gabinete cargarGabinete(int id) {
        Conexion conexion = new Conexion();
        Gabinete gabinete = null;
        try {
            String consulta = "SELECT * FROM gabinete WHERE idgabinete = " + id;
            ResultSet resultado = conexion.consultaBase(consulta);
            if (resultado.next()) {
                gabinete = new Gabinete();
                gabinete.setIdgabinete(resultado.getInt("idgabinete"));
                gabinete.setMarca(resultado.getString("marca"));
                gabinete.setModelo(resultado.getString("modelo"));
                gabinete.setPuertousb(resultado.getString("puertousb"));
                gabinete.setVentiladores(resultado.getString("ventiladores"));
                gabinete.setTamanoventilador(resultado.getInt("tamanoventiladores"));
                gabinete.setFuentepoder(resultado.getString("fuentedepoder"));
                gabinete.setTamanomaxvideo(resultado.getInt("tamanomaxiodevideo"));
                gabinete.setPlacamadre(resultado.getString("placamadre"));
                gabinete.setBahias(resultado.getString("bahias"));
                gabinete.setPrecio(resultado.getDouble("precio"));
                gabinete.setStock(resultado.getInt("stock"));
                gabinete.setProveedor(resultado.getInt("proveedor"));
                gabinete.setFoto(resultado.getBytes("foto"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            conexion.cerrar();
        }
        System.out.println(gabinete.toString());
        return gabinete;
    }

    // Método para cargar Ventiladores por su ID
    public static Ventiladores cargarVentiladores(int id) {
        Conexion conexion = new Conexion();
        Ventiladores ventiladores = null;
        try {
            String consulta = "SELECT * FROM ventiladores WHERE idventiladores = " + id;
            ResultSet resultado = conexion.consultaBase(consulta);
            if (resultado.next()) {
                ventiladores = new Ventiladores();
                ventiladores.setIdVentiladores(resultado.getInt("idventiladores"));
                ventiladores.setMarca(resultado.getString("marca"));
                ventiladores.setModelo(resultado.getString("modelo"));
                ventiladores.setRGB(resultado.getString("rgb"));
                ventiladores.setTamaño(resultado.getInt("tamaño"));
                ventiladores.setPrecio(resultado.getDouble("precio"));
                ventiladores.setId_proveedor(resultado.getInt("id_proveedor"));
                ventiladores.setStock(resultado.getInt("stock"));
                ventiladores.setFoto(resultado.getBytes("foto"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            conexion.cerrar();
        }
        return ventiladores;
    }

    // Método para cargar Disipadores por su ID
    public static Disipadores cargarDisipadores(int id) {
        Conexion conexion = new Conexion();
        Disipadores disipadores = null;
        try {
            String consulta = "SELECT * FROM disipadores WHERE iddisipadores = " + id;
            ResultSet resultado = conexion.consultaBase(consulta);
            if (resultado.next()) {
                disipadores = new Disipadores();
                disipadores.setIdDisipadores(resultado.getInt("iddisipadores"));
                disipadores.setMarca(resultado.getString("marca"));
                disipadores.setModelo(resultado.getString("modelo"));
                disipadores.setSocket(resultado.getString("socket"));
                disipadores.setRGB(resultado.getString("rgb"));
                disipadores.setVentiladores(resultado.getInt("ventiladores"));
                disipadores.setPrecio(resultado.getDouble("precio"));
                disipadores.setStock(resultado.getInt("stock"));
                disipadores.setFoto(resultado.getBytes("foto"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            conexion.cerrar();
        }
        return disipadores;
    }

}
