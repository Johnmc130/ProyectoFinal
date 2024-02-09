package Modelo;

import Clases.Placamadre;
import Conexion.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author MAX COMPUTERS
 */
public class ModeloPlacaMadre extends Placamadre {

    Conexion conectar = new Conexion();//Conectamos a la base
    Connection con;

    public static List<Placamadre> listaPlacaMadre() {
        Conexion conectar = new Conexion();
        List<Placamadre> listaplacamadre = new ArrayList<Placamadre>();
        String sql;
        sql = "SELECT idplacamadre, marca, modelo, puertosdealmacenamiento, puertousb, socket, tiporam, maximoram, ranurasexpansion, formato, watts, precio, stock, proveedor,foto FROM placamadre";
        ResultSet rs = conectar.consultaBase(sql);
        try {
            while (rs.next()) {
                Placamadre miplaca = new Placamadre();
                miplaca.setIdplacam(rs.getInt("idplacamadre"));
                miplaca.setMarca(rs.getString("marca"));
                miplaca.setModelo(rs.getString("modelo"));
                miplaca.setPuertosalmacenamiento(rs.getString("puertosdealmacenamiento"));
                miplaca.setPuertosusb(rs.getString("puertousb"));
                miplaca.setSocket(rs.getString("socket"));
                miplaca.setTiposram(rs.getString("tiporam"));
                miplaca.setMaximoram(rs.getInt("maximoram"));
                miplaca.setRanuraexpansion(rs.getString("ranurasexpansion"));
                miplaca.setFormato(rs.getString("formato"));
                miplaca.setWatts(rs.getInt("watts"));
                miplaca.setPrecio(rs.getDouble("precio"));
                miplaca.setStock(rs.getInt("Stock"));
                miplaca.setProveedor(rs.getInt("proveedor"));
                miplaca.setFoto(rs.getBytes("foto"));

                listaplacamadre.add(miplaca);

            }
            rs.close();
            return listaplacamadre;

        } catch (SQLException ex) {

            System.out.println("problemas en el listado");
            Logger.getLogger(ModeloPlacaMadre.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public static List<Placamadre> listaPlacaMadreCompartible(String socket) {
        // Se establece una conexión a la base de datos utilizando la clase Conexion
        Conexion conectar = new Conexion();
        // Se crea una lista vacía para almacenar las placas base compatibles
        List<Placamadre> listaplacamadre = new ArrayList<Placamadre>();
        // Se define la consulta SQL para seleccionar las placas base compatibles con el socket dado
        String sql;
        sql = "SELECT idplacamadre, marca, modelo, puertosdealmacenamiento, puertousb, socket, tiporam, maximoram, "
                + "ranurasexpansion, formato, watts, precio, stock, proveedor, foto "
                + "FROM placamadre "
                + "WHERE socket = ?";
        try {
            // Se prepara la sentencia SQL con el PreparedStatement para evitar inyección de SQL
            PreparedStatement pstmt = conectar.getConexion().prepareStatement(sql);
            // Se establece el valor del parámetro socket en la consulta SQL
            pstmt.setString(1, socket);
            // Se ejecuta la consulta y se obtiene un ResultSet con los resultados
            ResultSet rs = pstmt.executeQuery();
            // Se recorre el ResultSet para obtener cada fila de datos
            while (rs.next()) {
                // Se crea un objeto Placamadre y se asignan los valores de las columnas correspondientes
                Placamadre miplaca = new Placamadre();
                miplaca.setIdplacam(rs.getInt("idplacamadre"));
                miplaca.setMarca(rs.getString("marca"));
                miplaca.setModelo(rs.getString("modelo"));
                miplaca.setPuertosalmacenamiento(rs.getString("puertosdealmacenamiento"));
                miplaca.setPuertosusb(rs.getString("puertousb"));
                miplaca.setSocket(rs.getString("socket"));
                miplaca.setTiposram(rs.getString("tiporam"));
                miplaca.setMaximoram(rs.getInt("maximoram"));
                miplaca.setRanuraexpansion(rs.getString("ranurasexpansion"));
                miplaca.setFormato(rs.getString("formato"));
                miplaca.setWatts(rs.getInt("watts"));
                miplaca.setPrecio(rs.getDouble("precio"));
                miplaca.setStock(rs.getInt("Stock"));
                miplaca.setProveedor(rs.getInt("proveedor"));
                miplaca.setFoto(rs.getBytes("foto"));

                // Se agrega el objeto Placamadre a la lista de placas base compatibles
                listaplacamadre.add(miplaca);
            }
            // Se cierra el ResultSet
            rs.close();
            // Se devuelve la lista de placas base compatibles
            return listaplacamadre;

        } catch (SQLException ex) {
            // En caso de error, se imprime un mensaje de error en la consola y se devuelve null
            System.out.println("problemas en el listado");
            Logger.getLogger(ModeloPlacaMadre.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            // Se cierra la conexión a la base de datos
            conectar.cerrar();
        }
    }

    public boolean grabarPlacamadre() {
        String sql = "INSERT INTO placamadre (idplacamadre, marca, modelo, puertosdealmacenamiento, puertousb, socket, tiporam, maximoram, ranurasexpansion, formato, watts, precio, stock, proveedor,foto) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = conectar.getConexion();
                PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, getIdplacam());
            ps.setString(2, getMarca());
            ps.setString(3, getModelo());
            ps.setString(4, getPuertosalmacenamiento());
            ps.setString(5, getPuertosusb());
            ps.setString(6, getSocket());
            ps.setString(7, getTiposram());
            ps.setInt(8, getMaximoram());
            ps.setString(9, getRanuraexpansion());
            ps.setString(10, getFormato());
            ps.setInt(11, getWatts());
            ps.setDouble(12, getPrecio());
            ps.setInt(13, getStock());
            ps.setInt(14, getProveedor());
            ps.setBytes(15, getFoto());

            int result = ps.executeUpdate();
            return result > 0;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public SQLException ModificarPlacamadre() {
        String sql = "UPDATE placamadre SET marca = ?, modelo = ?, puertosdealmacenamiento = ?, puertousb = ?, socket = ?, "
                + "tiporam = ?, maximoram = ?, ranurasexpansion = ?, formato = ?, watts = ?, precio = ?, stock = ?, proveedor = ?, foto = ? "
                + "WHERE idplacamadre = ?";

        try (PreparedStatement preparedStatement = conectar.getConexion().prepareStatement(sql)) {
            // Configurar los parámetros

            preparedStatement.setString(1, getMarca());
            preparedStatement.setString(2, getModelo());
            preparedStatement.setString(3, getPuertosalmacenamiento());
            preparedStatement.setString(4, getPuertosusb());
            preparedStatement.setString(5, getSocket());
            preparedStatement.setString(6, getTiposram());
            preparedStatement.setInt(7, getMaximoram());
            preparedStatement.setString(8, getRanuraexpansion());
            preparedStatement.setString(9, getFormato());
            preparedStatement.setInt(10, getWatts());
            preparedStatement.setDouble(11, getPrecio());
            preparedStatement.setInt(12, getStock());
            preparedStatement.setInt(13, getProveedor());
            preparedStatement.setBytes(14, getFoto());

            // Establecer el id en el WHERE
            preparedStatement.setInt(15, getIdplacam());
            // Ejecutar la actualización
            preparedStatement.executeUpdate();

            return null; // Devuelve null si es correcto.
        } catch (SQLException e) {
            e.printStackTrace();
            return e; // Devuelve la excepción si hay un error.
        }
    }

    public SQLException eliminarPlacaMadre(String idplaca) {
        String sql = "DELETE FROM placamadre WHERE idplacamadre = '" + idplaca + "'";
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

    public int obtenerSiguienteIdPlacaMadre() {
        int siguienteId = 1; // Valor predeterminado si no hay registros
        try {
            if (conectar != null && !conectar.getConexion().isClosed());
            String sql = "SELECT MAX(idplacamadre) FROM placamadre";
            PreparedStatement statement = conectar.getConexion().prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                siguienteId = resultSet.getInt(1) + 1;
            }
            return siguienteId;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloPlacaMadre.class.getName()).log(Level.SEVERE, null, ex);
        }
        return siguienteId;
    }

    public static byte[] fotoPlaca(String id) {
        Conexion cpg = new Conexion();//Conectamos a la base

        Placamadre placamadre = new Placamadre();
        String sql;//SELECT * FROM TABLA
        sql = "SELECT foto FROM placamadre WHERE idplacamadre = '" + id + "'";
        ResultSet rs = cpg.consultaBase(sql);
        try {
            while (rs.next()) {

                placamadre.setFoto(rs.getBytes("foto"));
            }
            rs.close();//CIERRO CONEXION CON LA BASE DE DATOS.
            return placamadre.getFoto();
        } catch (SQLException ex) {
            Logger.getLogger(ModeloPlacaMadre.class.getName()).log(Level.SEVERE, null, ex);
            return null;//CUANDO REGRESA NULL, HUBO ERROR EN EL QUERY
        }

    }
}
