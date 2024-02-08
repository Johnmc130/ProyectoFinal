package Modelo;

import Clases.Gabinete;
import Conexion.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;

/**
 *
 * @author MAX COMPUTERS
 */
public class ModeloGabinete extends Gabinete {

    Conexion conectar = new Conexion();//Conectamos a la base
    Connection con;
    PreparedStatement ps;

    public static List<Gabinete> listaGabinete() {
        Conexion conectar = new Conexion();
        List<Gabinete> listaplacamadre = new ArrayList<Gabinete>();
        String sql;
        sql = "SELECT idgabinete, marca, modelo, puertousb, ventiladores, tamanoventiladores,fuentedepoder,tamanomaxiodevideo,placamadre,bahias, precio,stock,proveedor,foto FROM gabinete";
        ResultSet rs = conectar.consultaBase(sql);
        try {
            while (rs.next()) {
                Gabinete miplaca = new Gabinete();
                miplaca.setIdgabinete(rs.getInt("idgabinete"));
                miplaca.setMarca(rs.getString("marca"));
                miplaca.setModelo(rs.getString("modelo"));
                miplaca.setPuertousb(rs.getString("puertousb"));
                miplaca.setVentiladores(rs.getString("ventiladores"));
                miplaca.setTamanoventilador(rs.getInt("tamanoventiladores"));
                miplaca.setFuentepoder(rs.getString("fuentedepoder"));
                miplaca.setTamanomaxvideo(rs.getInt("tamanomaxiodevideo"));
                miplaca.setPlacamadre(rs.getString("placamadre"));
                miplaca.setBahias(rs.getString("bahias"));
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

    public boolean grabarGabinete() {
        String sql = "INSERT INTO gabinete (idgabinete, marca, modelo, puertousb, ventiladores, tamanoventiladores, fuentedepoder, tamanomaxiodevideo, placamadre, bahias, precio, stock, proveedor, foto)"
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = conectar.getConexion();
                PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, getIdgabinete());
            ps.setString(2, getMarca());
            ps.setString(3, getModelo());
            ps.setString(4, getPuertousb());
            ps.setString(5, getVentiladores());
            ps.setInt(6, getTamanoventilador());
            ps.setString(7, getFuentepoder());
            ps.setInt(8, getTamanomaxvideo());
            ps.setString(9, getPlacamadre());
            ps.setString(10, getBahias());
            ps.setDouble(11, getPrecio());
            ps.setInt(12, getStock());
            ps.setInt(13, getProveedor());
            ps.setBytes(14, getFoto());

            int result = ps.executeUpdate();
            return result > 0;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public SQLException ModificarGabinete() {

        String sql = "UPDATE gabinete SET marca = ?, modelo = ?, puertousb = ?, ventiladores = ?, tamanoventiladores = ?, fuentedepoder = ?, tamanomaxiodevideo = ?,placamadre = ?,bahias = ?, precio = ?, stock = ?, proveedor = ?, foto = ? "
                + "WHERE idgabinete = ?";

        try (PreparedStatement preparedStatement = conectar.getConexion().prepareStatement(sql)) {
            // Configurar los parámetros
            
            preparedStatement.setString(1, getMarca());
            preparedStatement.setString(2, getModelo());
            preparedStatement.setString(3, getPuertousb());
            preparedStatement.setString(4, getVentiladores());
            preparedStatement.setInt(5, getTamanoventilador());
            preparedStatement.setString(6, getFuentepoder());
            preparedStatement.setInt(7, getTamanomaxvideo());
            preparedStatement.setString(8, getPlacamadre());
            preparedStatement.setString(9, getBahias());
            preparedStatement.setDouble(10, getPrecio());
            preparedStatement.setInt(11, getStock());
            preparedStatement.setInt(12, getProveedor());
            preparedStatement.setBytes(13, getFoto());

            // Establecer la cédula en el WHERE
            preparedStatement.setInt(14, getIdgabinete());
            // Ejecutar la actualización
            preparedStatement.executeUpdate();

            return null; // Devuelve null si es correcto.
        } catch (SQLException e) {
            e.printStackTrace();
            return e; // Devuelve la excepción si hay un error.
        }
    }


    
    public SQLException eliminarGabinete(String idgabin) {
        String sql = "DELETE FROM gabinete WHERE idgabinete = '" + idgabin + "'";
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

    public int obtenerSiguienteIdGabinete() {
        int siguienteId = 1; // Valor predeterminado si no hay registros
        try {
            if (conectar != null && !conectar.getConexion().isClosed());
            String sql = "SELECT MAX(idgabinete) FROM gabinete";
            PreparedStatement statement = conectar.getConexion().prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                siguienteId = resultSet.getInt(1) + 1;
            }
            return siguienteId;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloGabinete.class.getName()).log(Level.SEVERE, null, ex);
        }
        return siguienteId;
    }
    
    public static byte[] fotoGabinete(String id) {
        Conexion cpg = new Conexion();//Conectamos a la base

        Gabinete gabinete = new Gabinete();
        String sql;//SELECT * FROM TABLA
        sql = "SELECT foto FROM gabinete WHERE idgabinete = '" + id + "'";
        ResultSet rs = cpg.consultaBase(sql);
        try {
            while (rs.next()) {
                gabinete.setFoto(rs.getBytes("foto"));
            }
            rs.close();//CIERRO CONEXION CON LA BASE DE DATOS.
            return gabinete.getFoto();
        } catch (SQLException ex) {
            Logger.getLogger(ModeloGabinete.class.getName()).log(Level.SEVERE, null, ex);
            return null;//CUANDO REGRESA NULL, HUBO ERROR EN EL QUERY
        }

    }

}
