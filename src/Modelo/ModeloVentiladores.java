/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Clases.Ventiladores;
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
public class ModeloVentiladores extends Ventiladores {
    
    Conexion conectar = new Conexion();//Conectamos a la base
    Connection con;
    PreparedStatement ps;

    public static List<Ventiladores> listaTodasventiladores() {
        Conexion conectar = new Conexion();
        List<Ventiladores> listaVentiladores = new ArrayList<Ventiladores>();
        String sql;
        sql = "SELECT idventiladores,marca,modelo,rgb,tamaño,precio,Stock, foto FROM ventiladores";
        ResultSet rs = conectar.consultaBase(sql);
        try {
            while (rs.next()) {
                Ventiladores miventiladores = new Ventiladores();
                miventiladores.setIdVentiladores(rs.getInt("idventiladores"));

                miventiladores.setMarca(rs.getString("marca"));
                miventiladores.setModelo(rs.getString("modelo"));
                miventiladores.setRGB(rs.getString("rgb"));
                miventiladores.setTamaño(rs.getInt("tamaño"));
                miventiladores.setPrecio(rs.getDouble("precio"));
                miventiladores.setStock(rs.getInt("Stock"));
                                miventiladores.setFoto(rs.getBytes("foto"));


                listaVentiladores.add(miventiladores);

            }
            rs.close();
            return listaVentiladores;

        } catch (SQLException ex) {

            System.out.println("problemas en el listado");
            Logger.getLogger(ModeloVentiladores.class.getName()).log(Level.SEVERE, null, ex);
            return null;//CUANDO REGRESA NULL, HUBO ERROR EN EL QUERY
        }

    }

    public static List<Ventiladores> listaTodasventiladoresCompatibles(int tamano) {
        Conexion conectar = new Conexion();
        List<Ventiladores> listaVentiladores = new ArrayList<Ventiladores>();
        String sql;
        sql = "SELECT idventiladores,marca,modelo,rgb,tamaño,precio,Stock, foto "
                + "FROM ventiladores "
                + "WHERE tamaño = ?";
        try {
            // Se prepara la sentencia SQL con el PreparedStatement para evitar inyección de SQL
            PreparedStatement pstmt = conectar.getConexion().prepareStatement(sql);
            // Se establece el valor del parámetro socket en la consulta SQL
            pstmt.setInt(1, tamano);
            // Se ejecuta la consulta y se obtiene un ResultSet con los resultados
            ResultSet rs = pstmt.executeQuery();
            // Se recorre el ResultSet para obtener cada fila de datos
            while (rs.next()) {
                Ventiladores miventiladores = new Ventiladores();
                miventiladores.setIdVentiladores(rs.getInt("idventiladores"));

                miventiladores.setMarca(rs.getString("marca"));
                miventiladores.setModelo(rs.getString("modelo"));
                miventiladores.setRGB(rs.getString("rgb"));
                miventiladores.setTamaño(rs.getInt("tamaño"));
                miventiladores.setPrecio(rs.getDouble("precio"));
                miventiladores.setStock(rs.getInt("Stock"));
                miventiladores.setFoto(rs.getBytes("foto"));


                listaVentiladores.add(miventiladores);

            }
            rs.close();
            return listaVentiladores;

        } catch (SQLException ex) {

            System.out.println("problemas en el listado");
            Logger.getLogger(ModeloVentiladores.class.getName()).log(Level.SEVERE, null, ex);
            return null;//CUANDO REGRESA NULL, HUBO ERROR EN EL QUERY
        }

    }
    
    public SQLException grabarventiladores() {

        String sql;//"INSERT INTO TABLA () VALUES()"
        sql = "INSERT INTO ventiladores (marca, modelo, rgb, tamaño, precio, stock, foto) "
                + "VALUES('" + getMarca() + "','" + getModelo() + "','" + getRGB() + "','" + getTamaño() + "','" + getPrecio() + "','" + getStock() + "','" + getFoto() + "')";

        return conectar.ejecutaConsulta(sql);
    }

    public SQLException eliminar() {
        String sql = "delete from ventiladores where idventiladores='" + getIdVentiladores() + "'";

        return conectar.ejecutaConsulta(sql);

    }

    public SQLException editarventiladores() {
        String sql;//"INSERT INTO TABLA () VALUES()"
        sql = "update ventiladores set  marca='" + getMarca() + "', Modelo='" + getModelo() + "', rgb='" + getRGB() + "', tamaño='" + getTamaño() + "', precio='" + getPrecio() + "',stock='" + getStock() + "'where idventiladores='" + getIdVentiladores() + "'";

        return conectar.ejecutaConsulta(sql);

    }

//    public static ArrayList<Integer> obtenerCodigosProveedor() {
//        ArrayList<Integer> codigosProveedor = new ArrayList<>();
//
//        try (Connection conexion = new Conexion().getCon();
//                PreparedStatement pst = conexion.prepareStatement("SELECT idproveedor FROM proveedor");
//                ResultSet rs = pst.executeQuery()) {
//
//            while (rs.next()) {
//                int idProveedor = rs.getInt("idproveedor");
//                codigosProveedor.add(idProveedor);
//            }
//
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return codigosProveedor;
//    }
//
//    
}
