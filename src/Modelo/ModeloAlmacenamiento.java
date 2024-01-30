/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Clases.almacenamiento;
import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author EDU
 */
public class ModeloAlmacenamiento extends almacenamiento {

    Conexion conectar = new Conexion();//Conectamos a la base
    Connection con;
    PreparedStatement ps;

    public static List<almacenamiento> listaTodasAlmacenamiento() {
        Conexion conectar = new Conexion();
        List<almacenamiento> listaAlmacenamiento = new ArrayList<almacenamiento>();
        String sql;
        sql = "SELECT idalmacenamiento,marca,Modelo,tipo,capacidad,precio,idproveedoralma,Stock FROM almacenamiento";
        ResultSet rs = conectar.consultaBase(sql);
        try {
            while (rs.next()) {
                almacenamiento miAlmacenamiento = new almacenamiento();
                miAlmacenamiento.setIdalmacenamiento(rs.getInt("idalmacenamiento"));

                miAlmacenamiento.setMarca(rs.getString("marca"));
                miAlmacenamiento.setModelo(rs.getString("modelo"));
                miAlmacenamiento.setTipo(rs.getString("tipo"));
                miAlmacenamiento.setCapacidad(rs.getInt("capacidad"));
                miAlmacenamiento.setPrecio(rs.getDouble("precio"));
                miAlmacenamiento.setId_proveedor(rs.getInt("idproveedoralma"));
                miAlmacenamiento.setStock(rs.getInt("Stock"));

                listaAlmacenamiento.add(miAlmacenamiento);

            }
            rs.close();
            return listaAlmacenamiento;

        } catch (SQLException ex) {

            System.out.println("problemas en el listado");
            Logger.getLogger(ModeloAlmacenamiento.class.getName()).log(Level.SEVERE, null, ex);
            return null;//CUANDO REGRESA NULL, HUBO ERROR EN EL QUERY
        }

    }

    public SQLException grabarAlmacenamiento() {

        String sql;//"INSERT INTO TABLA () VALUES()"
        sql = "INSERT INTO almacenamiento (marca, Modelo, tipo, capacidad, precio, idproveedoralma, stock) "
                + "VALUES('" + getMarca() + "','" + getModelo() + "','" + getTipo() + "','" + getCapacidad() + "','" + getPrecio() + "','" + getId_proveedor() + "','" + getStock() + "')";

        return conectar.ejecutaConsulta(sql);
    }

    public SQLException eliminar() {
        String sql = "delete from almacenamiento where idalmacenamiento='" + getIdalmacenamiento() + "'";

        return conectar.ejecutaConsulta(sql);

    }

    public SQLException editarAlmacenamiento() {
        String sql;//"INSERT INTO TABLA () VALUES()"
        sql = "update almacenamiento set  marca='" + getMarca() + "', Modelo='" + getModelo() + "', tipo='" + getTipo() + "', capacidad='" + getCapacidad() + "', precio='" + getPrecio() + "',stock='" + getStock() + "'where idalmacenamiento='" + getIdalmacenamiento() + "'";

        return conectar.ejecutaConsulta(sql);

    }

    public static ArrayList<Integer> obtenerCodigosProveedor() {
        ArrayList<Integer> codigosProveedor = new ArrayList<>();

        try (Connection conexion = new Conexion().getConexion();
                PreparedStatement pst = conexion.prepareStatement("SELECT idproveedor FROM proveedor");
                ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                int idProveedor = rs.getInt("idproveedor");
                codigosProveedor.add(idProveedor);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return codigosProveedor;
    }

}