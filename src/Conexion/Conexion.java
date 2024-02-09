package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Conexion {

    Connection conexion;

    public Conexion() {
        String cadenaConexion = "jdbc:postgresql://localhost:5432/Proyecto_Final";
        String usuario = "postgres";
        String contraseña = "1234";

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Advertencia", JOptionPane.WARNING_MESSAGE);
        }

        try {
            conexion = DriverManager.getConnection(cadenaConexion, usuario, contraseña);
            System.out.println("Conexion Exitosa");       
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
    
    public SQLException cerrar(){
        try {
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("cerrado");
        return null;
    }
}
