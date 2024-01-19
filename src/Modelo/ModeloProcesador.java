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
            String query = "SELECT id_procesador, marca, modelo, Imagen FROM procesador";
            try (PreparedStatement statement = Conexion.prepareStatement(query); ResultSet resultSet = statement.executeQuery()) {

                while (resultSet.next()) {      
                    Procesador procesador= new Procesador();
                    int id = resultSet.getInt("id_procesador");
                    byte[] imageData = resultSet.getBytes("Imagen");
                    String marca = resultSet.getString("marca");
                    String modelo = resultSet.getString("modelo"); 
                    procesador.setIdProcesador(id);
                    procesador.setMarca(marca);
                    procesador.setModelo(modelo);
                    procesador.setImagen(imageData);
                    procesadores.add(procesador);
                }
            }
            Conexion.close();
        } catch (SQLException e) {
        }
        return procesadores;
    }
}
