/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Steven Zhicay
 */
import Clases.DatosVenta;
import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ModeloDatosEnvio extends DatosVenta {

    public void guardarOActualizarDatosEnvio(int idCliente) {
        if (datosEnvioExisten(idCliente)) {
            actualizarDatosEnvio(idCliente);
        } else {
            guardarDatosEnvio(idCliente);
        }
    }

    private boolean datosEnvioExisten(int idCliente) {
        String sql = "SELECT * FROM datosenvio WHERE id_cliente = ?";
        try (Connection conexion = new Conexion().getConexion();
             PreparedStatement pst = conexion.prepareStatement(sql)) {
            pst.setInt(1, idCliente);
            try (ResultSet rs = pst.executeQuery()) {
                return rs.next();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    private void guardarDatosEnvio(int idCliente) {
        String sql = "INSERT INTO datosenvio (id_cliente, nombres, apellidos, movil, direccion) VALUES (?, ?, ?, ?, ?)";
        try (Connection conexion = new Conexion().getConexion();
             PreparedStatement pst = conexion.prepareStatement(sql)) {
            pst.setInt(1, idCliente);
            pst.setString(2, getNombres());
            pst.setString(3, getApellidos());
            pst.setString(4, getMovil());
            pst.setString(5, getDireccion());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Datos Guardados");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void actualizarDatosEnvio(int idCliente) {
        String sql = "UPDATE datosenvio SET nombres=?, apellidos=?, movil=?, direccion=? WHERE id_cliente=?";
        try (Connection conexion = new Conexion().getConexion();
             PreparedStatement pst = conexion.prepareStatement(sql)) {
            pst.setString(1, getNombres());
            pst.setString(2, getApellidos());
            pst.setString(3, getMovil());
            pst.setString(4, getDireccion());
            pst.setInt(5, idCliente);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Datos Actualizados");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void guardarDatosTarjeta(int idCliente) {
        String sql = "INSERT INTO tarjetacliente (id_cliente, numerocuenta, codigoseguridad, fechaexpiracion) VALUES (?, ?, ?, ?)";
        try (Connection conexion = new Conexion().getConexion();
             PreparedStatement pst = conexion.prepareStatement(sql)) {
            pst.setInt(1, idCliente);
            pst.setString(2, getNumeroCuenta());
            pst.setString(3, getCodigoSeguridad());
            pst.setString(4, getFechaExpiracion());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Datos Guardados");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void actualizarDatosTarjeta(int idCliente) {
        String sql = "UPDATE tarjetacliente SET numerocuenta=?, codigoseguridad=?, fechaexpiracion=? WHERE id_cliente=?";
        try (Connection conexion = new Conexion().getConexion();
             PreparedStatement pst = conexion.prepareStatement(sql)) {
            pst.setString(1, getNumeroCuenta());
            pst.setString(2, getCodigoSeguridad());
            pst.setString(3, getFechaExpiracion());
            pst.setInt(4, idCliente);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Datos Actualizados");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}


