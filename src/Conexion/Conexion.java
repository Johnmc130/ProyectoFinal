package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Conexion {

    Connection conexion;

    public Conexion() {
        String cadenaConexion = "jdbc:postgresql://localhost:5432/Proyecto_Final";
        String usuario = "postgres";
        String contraseña = "18658";

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Advertencia", JOptionPane.WARNING_MESSAGE);
        }

        try {
            conexion = DriverManager.getConnection(cadenaConexion, usuario, contraseña);
            JOptionPane.showMessageDialog(null, "Conexion Exitosa");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }

    public Connection getConexion() {
        return conexion;
    }

    public ResultSet consultaBase(String consulta) {
        try {
            Statement sentencia = conexion.createStatement();
            return sentencia.executeQuery(consulta);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
        return null;
    }

    public SQLException ejecutaConsulta(String consulta) {
        try {
            try (Statement sentencia = conexion.createStatement()) {
                sentencia.execute(consulta);
            }
            return null;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Advertencia", JOptionPane.WARNING_MESSAGE);
            return e;
        }
    }
}
