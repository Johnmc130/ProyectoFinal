package Modelo;

import Clases.Persona;
import Conexion.Conexion;
import java.sql.SQLException;

public class ModeloPersona extends Persona {

    Conexion base = new Conexion();

    public SQLException createPersona() {
        String query = "INSERT INTO persona (cedula, nombre, apellido, fecha_nac, edad, sexo, direccion, telefono) "
                + "VALUES ('" + getCedula()
                + "','" + getNombre()
                + "','" + getApellido()
                + "','" + getFecha_nac()
                + "','" + getEdad()
                + "','" + getSexo()
                + "','" + getDireccion()
                + "','" + getTelefono() + "')";

        return base.ejecutaConsulta(query);
    }

}
