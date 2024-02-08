/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Clases.PC;
import Clases.Procesador;
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

    public PC cargarPc(int id) {
        PC pc = null;
        try {
            // Construye la consulta SQL para obtener los datos de la cotización según el id
            String consulta = "SELECT * FROM cotizacion WHERE id = " + id;

            // Ejecuta la consulta y obtiene el resultado
            ResultSet resultado = conexion.consultaBase(consulta);

            // Verifica si hay resultados y lee los datos
            if (resultado.next()) {
                // Lee los valores de las columnas de la fila actual
                int idProcesador = resultado.getInt("id_procesador");
                int idPlacaMadre = resultado.getInt("id_placa_madre");
                int idTarjetaGrafica = resultado.getInt("id_tarjeta_grafica");
                int idRam = resultado.getInt("id_ram");
                int idFuentePoder = resultado.getInt("id_fuente_poder");
                int idAlmacenamiento = resultado.getInt("id_almacenamiento");
                int idGabinete = resultado.getInt("id_gabinete");
                int idDisipador = resultado.getInt("id_disipador");

                // Lee los valores de los ventiladores y los almacena en un ArrayList
                ArrayList<Integer> idVentiladores = new ArrayList<>();
                idVentiladores.add(resultado.getInt("id_ventilador_1"));
                idVentiladores.add(resultado.getInt("id_ventilador_2"));
                idVentiladores.add(resultado.getInt("id_ventilador_3"));

                // Crea una instancia de PC con los valores leídos
                pc = new PC(idProcesador, idPlacaMadre, idTarjetaGrafica, idRam,
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
    
    public static List<Procesador> cargaProcesadores() {
        // Obtener la conexión a la base de datos
        Conexion ConectaBD = new Conexion();
        List<Procesador> procesadores = new ArrayList<>();
        try (Connection Conexion = ConectaBD.getConexion()) {
            String query = "SELECT id_procesador, marca, modelo, nucleos_fisicos, ghz, socket, maximo_vram, watts, precio, imagen, id_proveedor, stock FROM procesador WHERE id";

            try (PreparedStatement statement = Conexion.prepareStatement(query); ResultSet resultSet = statement.executeQuery()) {

                while (resultSet.next()) {
                    Procesador procesador = new Procesador();
                    // Obtener datos de la fila actual del ResultSet
                    int id = resultSet.getInt("id_procesador");
                    byte[] imageData = resultSet.getBytes("imagen");
                    String marca = resultSet.getString("marca");
                    String modelo = resultSet.getString("modelo");
                    int nucleosFisicos = resultSet.getInt("nucleos_fisicos");
                    double ghz = resultSet.getDouble("ghz");
                    String socket = resultSet.getString("socket");
                    int maximoVram = resultSet.getInt("maximo_vram");
                    int watts = resultSet.getInt("watts");
                    double precio = resultSet.getDouble("precio");
                    int idProveedor = resultSet.getInt("id_proveedor");
                    int stock = resultSet.getInt("stock");

                    // Establecer los valores en el objeto Procesador
                    procesador.setIdProcesador(id);
                    procesador.setImagen(imageData);
                    procesador.setMarca(marca);
                    procesador.setModelo(modelo);
                    procesador.setNucleosFisicos(nucleosFisicos);
                    procesador.setGhz(ghz);
                    procesador.setSocket(socket);
                    procesador.setMaximoVram(maximoVram);
                    procesador.setWatts(watts);
                    procesador.setPrecio(precio);
                    procesador.setIdProveedor(idProveedor);
                    procesador.setStock(stock);
                    
                    procesadores.add(procesador);
                }
            }      
        } catch (SQLException e) {
            
        } finally{
            ConectaBD.cerrar();
        }
        return procesadores;
        
    }
}
