package Modelo;

import Clases.Proveedor;
import Conexion.Conexion;
import java.sql.*;
import java.util.*;
import javax.swing.*;

public class ModeloProveedor extends Proveedor {

    Conexion base = new Conexion();

    public SQLException createProveedor() {
        String query = "INSERT INTO proveedor (contraseña, cedula_prov) "
                + "VALUES ('" + getContraseña()
                + "','" + getCedula_prov() + "')";

        return base.ejecutaConsulta(query);
    }

    public static List<Proveedor> requestProveedor() {
        Conexion base = new Conexion();
        List<Proveedor> listaProveedores = new ArrayList<>();

        String query = "SELECT * FROM proveedor";

        ResultSet rs = base.consultaBase(query);

        try {
            while (rs.next()) {
                Proveedor proveedores = new Proveedor();
                proveedores.setId_proveedor(rs.getInt("idproveedor"));
                proveedores.setContraseña(rs.getString("contraseña"));
                proveedores.setCedula_prov(rs.getString("cedula_prov"));
                listaProveedores.add(proveedores);
            }
            rs.close();
            return listaProveedores;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Advertencia", JOptionPane.WARNING_MESSAGE);
            return null;
        }
    }

    public static List<Proveedor> requestProvbyID(String cedula) {
        Conexion base = new Conexion();
        List<Proveedor> listaProv = new ArrayList<>();

        String query = "SELECT pr.idproveedor, pr.contraseña, pr.cedula_prov, p.nombre, p.apellido, p.fecha_nac, p.edad, p.sexo, p.correo, p.direccion, p.telefono "
                + "FROM proovedor pr "
                + "JOIN persona p ON pr.cedula_prov = p.cedula "
                + "WHERE pr.cedula_prov = '" + cedula + "'";

        try {
            ResultSet rs = base.consultaBase(query);
            while (rs.next()) {
                Proveedor admin = new Proveedor();
                admin.setId_proveedor(rs.getInt("idproveedor"));
                admin.setContraseña(rs.getString("contraseña"));
                admin.setCedula_prov(rs.getString("cedula_prov"));

                // Hereda automáticamente los atributos de Persona
                admin.setNombre(rs.getString("nombre"));
                admin.setApellido(rs.getString("apellido"));
                admin.setFecha_nac(rs.getDate("fecha_nac"));
                admin.setEdad(rs.getInt("edad"));
                admin.setSexo(rs.getString("sexo").charAt(0));
                admin.setCorreo(rs.getString("correo"));
                admin.setDireccion(rs.getString("direccion"));
                admin.setTelefono(rs.getString("telefono"));

                listaProv.add(admin);
            }
            return listaProv;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Advertencia", JOptionPane.WARNING_MESSAGE);
            return null;
        }
    }

    public SQLException updateProveedor() {
        String query = "UPDATE proveedor SET "
                + "contraseña = '" + getContraseña()
                + "' WHERE cedula_prov = '" + getCedula_prov() + "'";

        return base.ejecutaConsulta(query);
    }

    public SQLException deleteProveedor() {
        String query = "DELETE FROM proveedor WHERE cedula_prov = '" + getCedula_prov() + "'";
        return base.ejecutaConsulta(query);
    }

    public boolean loginProveedor(String cedula, String contraseña) {
        Conexion base = new Conexion();

        try {
            String query = "SELECT contraseña, cedula_prov FROM proveedor WHERE cedula_prov = '" + cedula + "' AND contraseña ='" + contraseña + "'";

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

    public boolean existeProv(String cedula) {
        Conexion base = new Conexion();

        try {
            String query = "SELECT cedula_prov FROM proveedor WHERE cedula_prov = '" + cedula + "'";

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
