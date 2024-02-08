package Modelo;

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

    public static List<Tarjetagrafica> listaTarjetaGrafica() {
        Conexion conectar = new Conexion();
        List<Tarjetagrafica> listaTarjetagrafica = new ArrayList<Tarjetagrafica>();
        String sql;
        sql = "SELECT idtarjetagrafica, marca, modelo, vram, dlss, fsr,watts,tamano, precio,stock,proveedor,foto FROM tarjetagrafica";
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
                mitarje.setFoto(rs.getBytes("foto"));

                listaTarjetagrafica.add(mitarje);

            }
            rs.close();
            return listaTarjetagrafica;

        } catch (SQLException ex) {

            System.out.println("Problemas en el listado");
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

    public SQLException ModificarPTarjetagrafica() {

        String sql = "UPDATE tarjetagrafica SET marca = ?, modelo = ?, vram = ?, dlss = ?, fsr = ?, watts = ?, tamano = ?, precio = ?, stock = ?, proveedor = ?, foto = ? "
                + "WHERE idtarjetagrafica = ?";

        try (PreparedStatement preparedStatement = conectar.getConexion().prepareStatement(sql)) {
            // Configurar los parámetros
            
            preparedStatement.setString(1, getMarca());
            preparedStatement.setString(2, getModelo());
            preparedStatement.setInt(3, getVram());
            preparedStatement.setString(4, getDlss());
            preparedStatement.setString(5, getFsr());
            preparedStatement.setInt(6, getWatts());
            preparedStatement.setInt(7, getTamano());
            preparedStatement.setDouble(8, getPrecio());
            preparedStatement.setInt(9, getStock());
            preparedStatement.setInt(10, getProveedor());
            preparedStatement.setBytes(11, getFoto());

            // Establecer la cédula en el WHERE
            preparedStatement.setInt(12, getIdtarjetag());
            // Ejecutar la actualización
            preparedStatement.executeUpdate();

            return null; // Devuelve null si es correcto.
        } catch (SQLException e) {
            e.printStackTrace();
            return e; // Devuelve la excepción si hay un error.
        }
    }


    
    public SQLException eliminarPersona(String idtarje) {
        String sql = "DELETE FROM tarjetagrafica WHERE idtarjetagrafica = '" + idtarje + "'";
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
            return siguienteId;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloPlacaMadre.class.getName()).log(Level.SEVERE, null, ex);
        }
        return siguienteId;
    }

        public static byte[] fotoTarjeta(String id) {
        Conexion cpg = new Conexion();//Conectamos a la base

        Tarjetagrafica tarjetag = new Tarjetagrafica();
        String sql;//SELECT * FROM TABLA
        sql = "SELECT foto FROM tarjetagrafica WHERE idtarjetagrafica = '" + id + "'";
        ResultSet rs = cpg.consultaBase(sql);
        try {
            while (rs.next()) {

                tarjetag.setFoto(rs.getBytes("foto"));
            }
            rs.close();//CIERRO CONEXION CON LA BASE DE DATOS.
            return tarjetag.getFoto();
        } catch (SQLException ex) {
            Logger.getLogger(ModeloTarjetaGrafica.class.getName()).log(Level.SEVERE, null, ex);
            return null;//CUANDO REGRESA NULL, HUBO ERROR EN EL QUERY
        }

    }
}
