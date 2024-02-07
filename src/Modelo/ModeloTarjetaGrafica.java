package Main;

import Clases.Tarjetagrafica;
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
public class ModeloTarjetaGrafica extends Tarjetagrafica {

    Conexion conectar = new Conexion();//Conectamos a la base
    Connection con;
    PreparedStatement ps;

    public static List<Tarjetagrafica> listaTarjetagrafica() {
        Conexion conectar = new Conexion();
        List<Tarjetagrafica> listaTarjetagrafica = new ArrayList<Tarjetagrafica>();
        String sql;
        sql = "SELECT idtarjetagrafica, marca, modelo, vram, dlss, fsr,watts,tamano, precio,stock,proveedor FROM tarjetagrafica";
        ResultSet rs = conectar.consultaBase(sql);
        try {
            while (rs.next()) {
                Tarjetagrafica mitarje = new Tarjetagrafica();
                mitarje.setIdtarjetag(rs.getInt("idtarjetagrafica"));
                mitarje.setMarca(rs.getString("marca"));
                mitarje.setModelo(rs.getString("modelo"));
                mitarje.setVram(rs.getInt("vram"));
                mitarje.setDlss(rs.getString("dlss"));
                mitarje.setFsr(rs.getString("fsr"));
                mitarje.setWatts(rs.getInt("watts"));
                mitarje.setTamano(rs.getInt("tamano"));
                mitarje.setPrecio(rs.getDouble("precio"));
                mitarje.setStock(rs.getInt("Stock"));
                mitarje.setProveedor(rs.getInt("proveedor"));

                listaTarjetagrafica.add(mitarje);

            }
            rs.close();
            return listaTarjetagrafica;

        } catch (SQLException ex) {

            System.out.println("problemas en el listado");
            Logger.getLogger(ModeloTarjetaGrafica.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public boolean grabarPlacamadre() {
        String sql = "INSERT INTO tarjetagrafica (idtarjetagrafica, marca, modelo, vram, dlss, fsr, watts, tamano, precio, stock, proveedor, foto)"
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = conectar.getConexion();
                PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, getIdtarjetag());
            ps.setString(2, getMarca());
            ps.setString(3, getModelo());
            ps.setInt(4, getVram());
            ps.setString(5, getDlss());
            ps.setString(6, getFsr());
            ps.setInt(7, getWatts());
            ps.setInt(8, getTamano());
            ps.setDouble(9, getPrecio());
            ps.setInt(10, getStock());
            ps.setInt(11, getProveedor());
            ps.setBytes(12, getFoto());

            int result = ps.executeUpdate();
            conectar.cerrar();
            return result > 0;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public Tarjetagrafica obtenerDatosTarjeta(int idTarjeta) {
        String sql = "SELECT idtarjetagrafica, marca, modelo, vram, dlss, fsr, watts, tamano, precio, stock, proveedor, foto FROM tarjetagrafica WHERE idtarjetagrafica = ?";
        try (Connection con = conectar.getConexion();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idTarjeta);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Tarjetagrafica tarjeta = new Tarjetagrafica();
                tarjeta.setIdtarjetag(rs.getInt("idtarjetagrafica"));
                tarjeta.setMarca(rs.getString("marca"));
                tarjeta.setModelo(rs.getString("modelo"));
                tarjeta.setVram(rs.getInt("vram"));
                tarjeta.setDlss(rs.getString("dlss"));
                tarjeta.setFsr(rs.getString("fsr"));
                tarjeta.setWatts(rs.getInt("watts"));
                tarjeta.setTamano(rs.getInt("tamano"));
                tarjeta.setPrecio(rs.getDouble("precio"));
                tarjeta.setStock(rs.getInt("stock"));
                tarjeta.setProveedor(rs.getInt("proveedor"));
                tarjeta.setFoto(rs.getBytes("foto"));
                conectar.cerrar();
                return tarjeta;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public boolean actualizarTarjeta(Tarjetagrafica tarjeta) {
        String sql = "UPDATE tarjetagrafica SET marca=?, modelo=?, vram=?, dlss=?, fsr=?, watts=?, tamano=?, precio=?, stock=?, proveedor=?, foto=? WHERE idtarjetagrafica=?";
        try (Connection con = conectar.getConexion();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, tarjeta.getMarca());
            ps.setString(2, tarjeta.getModelo());
            ps.setInt(3, tarjeta.getVram());
            ps.setString(4, tarjeta.getDlss());
            ps.setString(5, tarjeta.getFsr());
            ps.setInt(6, tarjeta.getWatts());
            ps.setInt(7, tarjeta.getTamano());
            ps.setDouble(8, tarjeta.getPrecio());
            ps.setInt(9, tarjeta.getStock());
            ps.setInt(10, tarjeta.getProveedor());
            ps.setBytes(11, tarjeta.getFoto());
            ps.setInt(12, tarjeta.getIdtarjetag());

            int result = ps.executeUpdate();
            conectar.cerrar();
            return result > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean eliminarPlacamadre() {
        return false;

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
            return codigosProveedor;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return codigosProveedor;
    }

    public int obtenerSiguienteIdtarjetag() {
        int siguienteId = 1; // Valor predeterminado si no hay registros
        try {
            if (conectar != null && !conectar.getConexion().isClosed());
            String sql = "SELECT MAX(idtarjetagrafica) FROM tarjetagrafica";
            PreparedStatement statement = conectar.getConexion().prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                siguienteId = resultSet.getInt(1) + 1;
            }
            conectar.cerrar();
            return siguienteId;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloTarjetaGrafica.class.getName()).log(Level.SEVERE, null, ex);
        }
        return siguienteId;
    }

}
