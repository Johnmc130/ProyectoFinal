package Modelo;

import Clases.Cliente;
import Conexion.Conexion;
import java.awt.HeadlessException;
import java.sql.*;
import java.util.*;
import javax.swing.*;

public class ModeloCliente extends Cliente {

    Conexion base = new Conexion();

    public SQLException createCliente() {
        String query = "INSERT INTO cliente (id_cliente, contraseña) "
                + "VALUES ('" + getId_cliente()
                + "','" + getContraseña() + "')";

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
                cliente.setId_cliente(rs.getString("id_cliente"));
                cliente.setContraseña(rs.getString("contraseña"));

                listaClientes.add(cliente);
            }
            rs.close();
            return listaClientes;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Advertencia", JOptionPane.WARNING_MESSAGE);
            return null;
        }
    }

    public SQLException updateCliente() {
        String query = "UPDATE cliente SET "
                + "contraseña = '" + getContraseña()
                + "' WHERE id_cliente = '" + getId_cliente() + "'";

        return base.ejecutaConsulta(query);
    }

    public SQLException deleteCliente() {
        String query = "DELETE FROM cliente WHERE id_cliente = '" + getId_cliente() + "'";
        return base.ejecutaConsulta(query);
    }

    public boolean loginCliente(String cedula, String contraseña) {
        Conexion base = new Conexion();

        try {
            String query = "SELECT id_cliente, contraseña FROM cliente WHERE id_cliente = '" + cedula + "' AND contraseña ='" + contraseña + "'";

            ResultSet resultSet = base.consultaBase(query);

            if (resultSet.next()) {
                return true;
            } else {
                return false;
            }
        } catch (HeadlessException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Advertencia", JOptionPane.WARNING_MESSAGE);
            return false;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Advertencia", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }

}
