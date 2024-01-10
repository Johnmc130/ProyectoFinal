package Modelo;

import Clases.Cliente;
import Conexion.Conexion;
import java.sql.SQLException;

public class ModeloCliente extends Cliente {

    Conexion base = new Conexion();

    public SQLException createCliente() {
        String query = "INSERT INTO cliente (id_cliente, usuario, contraseña)"
                + "VALUES ('" + getId_cliente()
                + "','" + getUsuario()
                + "','" + getContraseña() + "')";

        return base.ejecutaConsulta(query);
    }

}
