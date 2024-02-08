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
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.sql.Types;

public class ModeloDatosEnvio extends DatosVenta {

    Conexion conectar = new Conexion();//Conectamos a la base
    Connection con;

    public boolean guardarDatosEnvio() {
        String sql = "INSERT INTO datosenvio (id_datos, nombres, apellidos, movil, direccion, numerocuenta, codigoseguridad, fechaexpiracion, nombreproducto, id_producto, id_cliente) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = conectar.getConexion()) {
            if (con == null || con.isClosed()) {
                System.out.println("La conexión es nula o está cerrada antes de intentar ejecutar la consulta.");
                return false;
            }

            try (PreparedStatement pst = con.prepareStatement(sql)) {

//                // Obtener el siguiente valor de la secuencia (ajusta según tu base de datos)
//                int siguienteId = obtenerSiguienteIdDatos();
//
//                // Establecer el valor de id_datos en el objeto antes de la inserción
//                setId_datos(siguienteId);
                // Resto del código para establecer otros valores
                pst.setInt(1, getId_datos());
                pst.setString(2, getNombres());
                pst.setString(3, getApellidos());
                pst.setString(4, getMovil());
                pst.setString(5, getDireccion());
                pst.setString(6, getNumeroCuenta());
                pst.setString(7, getCodigoSeguridad());
                pst.setObject(8, getFechaExpiracion(), Types.TIMESTAMP);
                pst.setString(9, getNombreProducto());
                pst.setInt(10, getId_producto());
                pst.setInt(11, getId_cliente());

                int result = pst.executeUpdate();
                System.out.println("Consulta ejecutada exitosamente. Filas afectadas: " + result);
                return result > 0;
            } catch (SQLException ex) {
                System.out.println("Error al ejecutar la consulta:");
                ex.printStackTrace();
                System.out.println("SQLState: " + ex.getSQLState());
                System.out.println("ErrorCode: " + ex.getErrorCode());
                return false;
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener la conexión:");
            ex.printStackTrace();
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("ErrorCode: " + ex.getErrorCode());
            return false;
        }
    }

    public boolean actualizarDatosEnvio() {
        String sql = "INSERT INTO datosenvio (id_datos, nombres, apellidos, movil, direccion, numerocuenta, codigoseguridad, fechaexpiracion, nombreproducto, id_producto, id_cliente) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conexion = new Conexion().getConexion();
                PreparedStatement pst = conexion.prepareStatement(sql)) {
            pst.setInt(1, getId_datos());
            pst.setString(2, getNombres());
            pst.setString(3, getApellidos());
            pst.setString(4, getMovil());
            pst.setString(5, getDireccion());
            pst.setString(6, getNumeroCuenta());
            pst.setString(7, getCodigoSeguridad());
            pst.setObject(8, getFechaExpiracion(), Types.TIMESTAMP);
            pst.setString(9, getNombreProducto());
            pst.setInt(10, getId_producto());
            pst.setInt(11, getId_cliente());
            
            
            int result = pst.executeUpdate();
            return result > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public int obtenerSiguienteIdDatos() {
        int siguienteId = 1; // Valor predeterminado si no hay registros
        try {
            if (conectar != null && !conectar.getConexion().isClosed());
            String sql = "SELECT MAX(id_datos) FROM datosenvio";
            PreparedStatement statement = conectar.getConexion().prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                siguienteId = resultSet.getInt(1) + 1;
            }
            return siguienteId;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloDatosEnvio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return siguienteId;
    }
}
