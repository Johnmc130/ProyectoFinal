package Modelo;

import Clases.Persona;
import Conexion.Conexion;
import java.sql.*;
import java.util.*;
import javax.swing.*;

public class ModeloPersona extends Persona {

    Conexion base = new Conexion();

    public SQLException createPersona() {
        String query = "INSERT INTO persona (cedula, nombre, apellido, fecha_nac, edad, sexo, correo, direccion, telefono) "
                + "VALUES ('" + getCedula()
                + "','" + getNombre()
                + "','" + getApellido()
                + "','" + getFecha_nac()
                + "','" + getEdad()
                + "','" + getSexo()
                + "','" + getCorreo()
                + "','" + getDireccion()
                + "','" + getTelefono() + "')";

        return base.ejecutaConsulta(query);
    }

    public static List<Persona> requestPersonas() {
        Conexion base = new Conexion();
        List<Persona> listaPersonas = new ArrayList<>();

        String query = "SELECT * FROM persona";

        ResultSet rs = base.consultaBase(query);

        try {
            while (rs.next()) {
                Persona persona = new Persona();
                persona.setNombre(rs.getString("nombre"));
                persona.setApellido(rs.getString("apellido"));
                persona.setFecha_nac(rs.getDate("fecha_nac"));
                persona.setEdad(rs.getInt("edad"));
                persona.setSexo(rs.getString("sexo").charAt(0));
                persona.setCorreo(rs.getString("correo"));
                persona.setDireccion(rs.getString("direccion"));
                persona.setTelefono(rs.getString("telefono"));

                listaPersonas.add(persona);
            }
            rs.close();
            return listaPersonas;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Advertencia", JOptionPane.WARNING_MESSAGE);
            return null;
        }
    }

    public SQLException updatePersona() {
        String query = "UPDATE persona SET "
                + "nombre = '" + getNombre()
                + "', apellido = '" + getApellido()
                + "', fecha_nac = '" + getFecha_nac()
                + "', edad = '" + getEdad()
                + "', sexo = '" + getSexo()
                + "', correo = '" + getCorreo()
                + "', direccion = '" + getDireccion()
                + "', telefono = '" + getTelefono()
                + "' WHERE cedula = '" + getCedula() + "'";

        return base.ejecutaConsulta(query);
    }

    public SQLException deletePersona() {
        String query = "DELETE FROM persona WHERE cedula = '" + getCedula() + "'";
        return base.ejecutaConsulta(query);
    }

    public boolean existePersona(String cedula) {
        Conexion base = new Conexion();

        try {
            String query = "SELECT cedula FROM persona WHERE cedula = '" + cedula + "'";

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
