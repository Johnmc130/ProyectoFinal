package Modelo;

import Clases.Administrador;
import Conexion.Conexion;
import java.sql.*;
import java.util.*;
import javax.swing.*;

public class ModeloAdministrador extends Administrador {

    Conexion base = new Conexion();

    public SQLException createAdmin() {
        String query = "INSERT INTO administrador (contraseña, cedula_admin) "
                + "VALUES ('" + getContraseña()
                + "','" + getCedula_admin() + "')";

        return base.ejecutaConsulta(query);
    }

    public static List<Administrador> requestAdmins() {
        Conexion base = new Conexion();
        List<Administrador> litaAdmins = new ArrayList<>();

        String query = "SELECT * FROM administrador";

        ResultSet rs = base.consultaBase(query);

        try {
            while (rs.next()) {
                Administrador admins = new Administrador();
                admins.setId_admin(rs.getInt("id_admin"));
                admins.setContraseña(rs.getString("contraseña"));
                admins.setCedula_admin(rs.getString("cedula_admin"));
                litaAdmins.add(admins);
            }
            rs.close();
            return litaAdmins;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Advertencia", JOptionPane.WARNING_MESSAGE);
            return null;
        }
    }

    public static List<Administrador> requestAdminbyID(String cedula) {
        Conexion base = new Conexion();
        List<Administrador> litaAdmins = new ArrayList<>();

        String query = "SELECT a.id_admin, a.contraseña, a.cedula_admin, p.nombre, p.apellido, p.fecha_nac, p.edad, p.sexo, p.correo, p.direccion, p.telefono "
                + "FROM administrador a "
                + "JOIN persona p ON a.cedula_admin = p.cedula "
                + "WHERE a.cedula_admin = '" + cedula + "'";

        try {
            ResultSet rs = base.consultaBase(query);
            while (rs.next()) {
                Administrador admin = new Administrador();
                admin.setId_admin(rs.getInt("id_admin"));
                admin.setContraseña(rs.getString("contraseña"));
                admin.setCedula_admin(rs.getString("cedula_admin"));
                admin.setNombre(rs.getString("nombre"));
                admin.setApellido(rs.getString("apellido"));
                admin.setFecha_nac(rs.getDate("fecha_nac"));
                admin.setEdad(rs.getInt("edad"));
                admin.setSexo(rs.getString("sexo").charAt(0));
                admin.setCorreo(rs.getString("correo"));
                admin.setDireccion(rs.getString("direccion"));
                admin.setTelefono(rs.getString("telefono"));

                litaAdmins.add(admin);
            }
            return litaAdmins;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Advertencia", JOptionPane.WARNING_MESSAGE);
            return null;
        }
    }

    public SQLException updateAdmin() {
        String query = "UPDATE administrador SET "
                + "contraseña = '" + getContraseña()
                + "' WHERE cedula_admin = '" + getCedula_admin() + "'";

        return base.ejecutaConsulta(query);
    }

    public SQLException deleteCliente() {
        String query = "DELETE FROM administrador WHERE cedula_admin = '" + getCedula_admin() + "'";
        return base.ejecutaConsulta(query);
    }

    public boolean loginAdmin(String cedula, String contraseña) {
        Conexion base = new Conexion();

        try {
            String query = "SELECT contraseña, cedula_admin FROM administrador WHERE cedula_admin = '" + cedula + "' AND contraseña ='" + contraseña + "'";

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

    public boolean existeAdmin(String cedula) {
        Conexion base = new Conexion();

        try {
            String query = "SELECT cedula_admin FROM administrador WHERE cedula_admin = '" + cedula + "'";

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
