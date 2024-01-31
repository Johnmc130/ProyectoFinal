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
    PreparedStatement ps;

    public static List<Placamadre> listaPlacaMadre() {
        Conexion conectar = new Conexion();
        List<Placamadre> listaplacamadre = new ArrayList<Placamadre>();
        String sql;
        sql = "SELECT idplacamadre, marca, modelo, puertosdealmacenamiento, puertousb, socket, tiporam, maximoram, ranurasexpansion, formato, watts, precio, stock, proveedor FROM placamadre";
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
                miplaca.setTiposram(rs.getInt("tiporam"));
                miplaca.setMaximoram(rs.getInt("maximoram"));
                miplaca.setRanuraexpansion(rs.getString("ranurasexpansion"));
                miplaca.setFormato(rs.getString("formato"));
                miplaca.setWatts(rs.getInt("watts"));
                miplaca.setPrecio(rs.getDouble("precio"));
                miplaca.setStock(rs.getInt("Stock"));
                miplaca.setProveedor(rs.getInt("proveedor"));

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
            ps.setInt(7, getTiposram());
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

    public boolean editarPlacamadre() {
        String sql = "UPDATE placamadre SET marca = ?, modelo = ?, puertosdealmacenamiento = ?, puertousb = ?, socket = ?, "
                + "tiporam = ?, maximoram = ?, ranurasexpansion = ?, formato = ?, watts = ?, precio = ?, stock = ?, proveedor = ?, foto = ? "
                + "WHERE idplacamadre = ?";

        try (Connection con = conectar.getConexion();
                PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, getMarca());
            ps.setString(2, getModelo());
            ps.setString(3, getPuertosalmacenamiento());
            ps.setString(4, getPuertosusb());
            ps.setString(5, getSocket());
            ps.setInt(6, getTiposram());
            ps.setInt(7, getMaximoram());
            ps.setString(8, getRanuraexpansion());
            ps.setString(9, getFormato());
            ps.setInt(10, getWatts());
            ps.setDouble(11, getPrecio());
            ps.setInt(12, getStock());
            ps.setInt(13, getProveedor());
            ps.setBytes(14, getFoto());
            ps.setInt(15, getIdplacam());

            int result = ps.executeUpdate();
            return result > 0;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean eliminarPlacamadre() {
        String sql = "DELETE FROM placamadre WHERE idplacamadre = ?";

        try (Connection con = conectar.getConexion();
                PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, getIdplacam());

            int result = ps.executeUpdate();
            return result > 0;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
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

}
