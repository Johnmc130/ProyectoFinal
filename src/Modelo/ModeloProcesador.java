/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

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

public class ModeloProcesador {

    public static List<Procesador> cargaProcesadores() {
        // Obtener la conexión a la base de datos
        Conexion ConectaBD = new Conexion();
        List<Procesador> procesadores = new ArrayList<>();
        try (Connection Conexion = ConectaBD.getConexion()) {
            String query = "SELECT id_procesador, marca, modelo, nucleos_fisicos, ghz, socket, maximo_vram, watts, precio, imagen, id_proveedor, stock FROM procesador";

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
