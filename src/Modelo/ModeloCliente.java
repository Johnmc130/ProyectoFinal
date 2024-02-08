package Modelo;

import Clases.Cliente;
import Conexion.Conexion;
import java.sql.*;
import java.util.*;
import javax.swing.*;

public class ModeloCliente extends Cliente {

    Conexion base = new Conexion();

    public SQLException createCliente() {
        String query = "INSERT INTO cliente (contraseña, cedula_cli) "
                + "VALUES ('" + getContraseña()
                + "','" + getCedula_cli() + "')";

        return base.ejecutaConsulta(query);
    }

    public static List<Cliente> requestClientes() {
        Conexion base = new Conexion();
        List<Cliente> listaClientes = new ArrayList<>();

        String query = "SELECT * FROM cliente";

        ResultSet rs = base.consultaBase(query);

        try {
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId_cliente(rs.getInt("id_cliente"));
                cliente.setContraseña(rs.getString("contraseña"));
                cliente.setCedula_cli(rs.getString("cedula_cli"));

                listaClientes.add(cliente);
            }
            rs.close();
            return listaClientes;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Advertencia", JOptionPane.WARNING_MESSAGE);
            return null;
        }
    }

    public static List<Cliente> requestClientebyID(String cedula) {
        Conexion base = new Conexion();
        List<Cliente> listaClientes = new ArrayList<>();

        String query = "SELECT c.id_cliente, c.contraseña, c.cedula_cli, p.nombre, p.apellido, p.fecha_nac, p.edad, p.sexo, p.correo, p.direccion, p.telefono "
                + "FROM cliente c "
                + "JOIN persona p ON c.cedula_cli = p.cedula "
                + "WHERE c.cedula_cli = ?";

        try (PreparedStatement preparedStatement = base.getConexion().prepareStatement(query)) {
            preparedStatement.setString(1, cedula);
            try (ResultSet rs = preparedStatement.executeQuery()) {
                while (rs.next()) {
                    Cliente cliente = new Cliente();
                    cliente.setId_cliente(rs.getInt("id_cliente"));
                    cliente.setContraseña(rs.getString("contraseña"));
                    cliente.setCedula_cli(rs.getString("cedula_cli"));

                    // Hereda automáticamente los atributos de Persona
                    cliente.setNombre(rs.getString("nombre"));
                    cliente.setApellido(rs.getString("apellido"));
                    cliente.setFecha_nac(rs.getDate("fecha_nac"));
                    cliente.setEdad(rs.getInt("edad"));
                    cliente.setSexo(rs.getString("sexo").charAt(0));
                    cliente.setCorreo(rs.getString("correo"));
                    cliente.setDireccion(rs.getString("direccion"));
                    cliente.setTelefono(rs.getString("telefono"));

                    listaClientes.add(cliente);
                }
            }
            return listaClientes;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Advertencia", JOptionPane.WARNING_MESSAGE);
            return null;
        }
    }

    public SQLException updateCliente() {
        String query = "UPDATE cliente SET "
                + "contraseña = '" + getContraseña()
                + "' WHERE cedula_cli = '" + getCedula_cli() + "'";

        return base.ejecutaConsulta(query);
    }

    public SQLException deleteCliente() {
        String query = "DELETE FROM cliente WHERE cedula_cli = '" + getCedula_cli() + "'";
        return base.ejecutaConsulta(query);
    }

    public boolean loginCliente(String cedula, String contraseña) {
        Conexion base = new Conexion();

        try {
            String query = "SELECT cedula_cli, contraseña FROM cliente WHERE cedula_cli = '" + cedula + "' AND contraseña ='" + contraseña + "'";

            ResultSet resultSet = base.consultaBase(query);

            if (resultSet.next()) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Advertencia", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }

    public boolean existeCliente(String cedula) {
        Conexion base = new Conexion();

        try {
            String query = "SELECT cedula_cli FROM cliente WHERE cedula_cli = '" + cedula + "'";

            ResultSet resultSet = base.consultaBase(query);

            if (resultSet.next()) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Advertencia", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }

}
