package Main;

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
        sql = "SELECT idgabinete, marca, modelo, puertousb, ventiladores, tamanoventiladores,fuentedepoder,tamanomaxiodevideo,placamadre,bahias, precio,stock,proveedor FROM gabinete";
        ResultSet rs = conectar.consultaBase(sql);
        try {
            while (rs.next()) {
                Gabinete migabinete = new Gabinete();
                migabinete.setIdgabinete(rs.getInt("idgabinete"));
                migabinete.setMarca(rs.getString("marca"));
                migabinete.setModelo(rs.getString("modelo"));
                migabinete.setPuertousb(rs.getString("puertousb"));
                migabinete.setVentiladores(rs.getString("ventiladores"));
                migabinete.setTamanoventilador(rs.getInt("tamanoventiladores"));
                migabinete.setFuentepoder(rs.getString("fuentedepoder"));
                migabinete.setTamanomaxvideo(rs.getInt("tamanomaxiodevideo"));
                migabinete.setPlacamadre(rs.getString("placamadre"));
                migabinete.setBahias(rs.getString("bahias"));
                migabinete.setPrecio(rs.getDouble("precio"));
                migabinete.setStock(rs.getInt("Stock"));
                migabinete.setProveedor(rs.getInt("proveedor"));

                listaplacamadre.add(migabinete);

            }
            rs.close();
            return listaplacamadre;

        } catch (SQLException ex) {

            System.out.println("problemas en el listado");
            Logger.getLogger(ModeloGabinete.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public boolean grabarPlacamadre() {
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

    public boolean editarPlacamadre() {
        return false;
       
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

}
