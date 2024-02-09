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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author TheBigG
 */

public class ModeloProcesador extends Procesador{
    
    Conexion conectar = new Conexion();//Conectamos a la base
    Connection con;

    public static List<Procesador> listaProcesador() {
        Conexion conectar = new Conexion();
        List<Procesador> listaprocesador = new ArrayList<Procesador>();
        String sql;
        sql = "SELECT idprocesador, marca, modelo, nucleosfisicos, ghz, socket, maximoram, watts, precio, stock, proveedor,imagen FROM procesador";
        ResultSet rs = conectar.consultaBase(sql);
        try {
            while (rs.next()) {
                Procesador miprocesa = new Procesador();
                miprocesa.setIdProcesador(rs.getInt("idprocesador"));
                miprocesa.setMarca(rs.getString("marca"));
                miprocesa.setModelo(rs.getString("modelo"));
                miprocesa.setNucleosFisicos(rs.getInt("nucleosfisicos"));
                miprocesa.setGhz(rs.getDouble("ghz"));
                miprocesa.setSocket(rs.getString("socket"));
                miprocesa.setMaximoVram(rs.getInt("maximoram"));
                miprocesa.setWatts(rs.getInt("watts"));
                miprocesa.setPrecio(rs.getDouble("precio"));
                miprocesa.setStock(rs.getInt("Stock"));
                miprocesa.setIdProveedor(rs.getInt("proveedor"));
                miprocesa.setImagen(rs.getBytes("imagen"));

                listaprocesador.add(miprocesa);

            }
            rs.close();
            return listaprocesador;

        } catch (SQLException ex) {

            System.out.println("problemas en el listado");
            Logger.getLogger(ModeloPlacaMadre.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public boolean grabarProcesador() {
        String sql = "INSERT INTO procesador (idprocesador, marca, modelo, nucleosfisicos, ghz, socket, maximoram, watts, precio, stock, proveedor, imagen) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = conectar.getConexion();
                PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, getIdProcesador());
            ps.setString(2, getMarca());
            ps.setString(3, getModelo());
            ps.setInt(4, getNucleosFisicos());
            ps.setDouble(5, getGhz());
            ps.setString(6, getSocket());
            ps.setInt(7, getMaximoVram());
            ps.setInt(8, getWatts());
            ps.setDouble(9, getPrecio());
            ps.setInt(10, getStock());
            ps.setInt(11, getIdProveedor());
            ps.setBytes(12, getImagen());

            int result = ps.executeUpdate();
            return result > 0;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public SQLException ModificarProcesador() {
        String sql = "UPDATE procesador SET marca = ?, modelo = ?, nucleosfisicos = ?, ghz = ?, socket = ?, maximoram = ?, watts = ?, precio = ?, stock = ?, proveedor = ?, imagen = ? "
            + "WHERE idprocesador = ?";


        try (PreparedStatement preparedStatement = conectar.getConexion().prepareStatement(sql)) {
            // Configurar los parámetros

            preparedStatement.setString(1, getMarca());
            preparedStatement.setString(2, getModelo());
            preparedStatement.setInt(3, getNucleosFisicos());
            preparedStatement.setDouble(4, getGhz());
            preparedStatement.setString(5, getSocket());
            preparedStatement.setInt(6, getMaximoVram());
            preparedStatement.setInt(7, getWatts());
            preparedStatement.setDouble(8, getPrecio());
            preparedStatement.setInt(9, getStock());
            preparedStatement.setInt(10, getIdProveedor());
            preparedStatement.setBytes(11, getImagen());

            // Establecer el id en el WHERE
            preparedStatement.setInt(12, getIdProcesador());
            // Ejecutar la actualización
            preparedStatement.executeUpdate();

            return null; // Devuelve null si es correcto.
        } catch (SQLException e) {
            e.printStackTrace();
            return e; // Devuelve la excepción si hay un error.
        }
    }

    public SQLException eliminarProcesador(String idprocesador) {
        String sql = "DELETE FROM procesador WHERE idprocesador = '" + idprocesador + "'";
        return conectar.ejecutaConsulta(sql);
    }

    public static ArrayList<Integer> obtenerCodigosProveedor() {
        ArrayList<Integer> codigosProveedor = new ArrayList<>();

        try (Connection conexion = new Conexion().getConexion();
                PreparedStatement pst = conexion.prepareStatement("SELECT idproveedor FROM proveedor");
                ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                int idProveedor = rs.getInt("idproveedor");
                codigosProveedor.add(idProveedor);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return codigosProveedor;
    }

    public int obtenerSiguienteIdProcesador() {
        int siguienteId = 1; // Valor predeterminado si no hay registros
        try {
            if (conectar != null && !conectar.getConexion().isClosed());
            String sql = "SELECT MAX(idprocesador) FROM procesador";
            PreparedStatement statement = conectar.getConexion().prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                siguienteId = resultSet.getInt(1) + 1;
            }
            return siguienteId;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloProcesador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return siguienteId;
    }

    public static byte[] fotoProcesador(String id) {
        Conexion cpg = new Conexion();//Conectamos a la base

        Procesador procesador = new Procesador();
        String sql;//SELECT * FROM TABLA
        sql = "SELECT imagen FROM procesador WHERE idprocesador = '" + id + "'";
        ResultSet rs = cpg.consultaBase(sql);
        try {
            while (rs.next()) {

                procesador.setImagen(rs.getBytes("imagen"));
            }
            rs.close();//CIERRO CONEXION CON LA BASE DE DATOS.
            return procesador.getImagen();
        } catch (SQLException ex) {
            Logger.getLogger(ModeloProcesador.class.getName()).log(Level.SEVERE, null, ex);
            return null;//CUANDO REGRESA NULL, HUBO ERROR EN EL QUERY
        }

    }

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
