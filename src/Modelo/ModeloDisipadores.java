/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

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
public class ModeloDisipadores extends Disipadores {

    Conexion conectar = new Conexion();//Conectamos a la base
    Connection con;
    PreparedStatement ps;

    public static List<Disipadores> listaTodasDisipadores() {
        Conexion conectar = new Conexion();
        List<Disipadores> listaDisipadores = new ArrayList<Disipadores>();
        String sql;
        sql = "SELECT iddisipadores,marca,modelo,socket,rgb,ventiladores,precio,stock FROM disipadores";
        ResultSet rs = conectar.consultaBase(sql);
        try {
            while (rs.next()) {
                Disipadores midisipadores = new Disipadores();
                midisipadores.setIdDisipadores(rs.getInt("iddisipadores"));

                midisipadores.setMarca(rs.getString("marca"));
                midisipadores.setModelo(rs.getString("modelo"));
                midisipadores.setSocket(rs.getString("socket"));
                midisipadores.setRGB(rs.getString("rgb"));
                midisipadores.setVentiladores(rs.getInt("ventiladores"));

                midisipadores.setPrecio(rs.getDouble("precio"));
                midisipadores.setStock(rs.getInt("Stock"));

                listaDisipadores.add(midisipadores);

            }
            rs.close();
            return listaDisipadores;

        } catch (SQLException ex) {

            System.out.println("problemas en el listado");
            Logger.getLogger(ModeloDisipadores.class.getName()).log(Level.SEVERE, null, ex);
            return null;//CUANDO REGRESA NULL, HUBO ERROR EN EL QUERY
        }

    }

    public SQLException grabardisipadores() {

        String sql;//"INSERT INTO TABLA () VALUES()"
        sql = "INSERT INTO disipadores (marca, modelo, socket, rgb,ventiladores, precio, stock) "
                + "VALUES('" + getMarca() + "','" + getModelo() + "','" + getSocket() + "','" + getRGB() + "','" + getVentiladores() + "','" + getPrecio() +  "','" + getStock() + "')";

        return conectar.ejecutaConsulta(sql);
    }

    public SQLException eliminar() {
        String sql = "delete from disipadores where iddisipadores='" + getIdDisipadores() + "'";

        return conectar.ejecutaConsulta(sql);

    }

    public SQLException editardisipadores() {
        String sql;//"INSERT INTO TABLA () VALUES()"
        sql = "update disipadores set  marca='" + getMarca() + "', Modelo='" + getModelo() + "', socket='" + getSocket() + "', rgb='" + getRGB() + "', ventiladores='" + getVentiladores() + "', precio='" + getPrecio() + "',stock='" + getStock() + "'where iddisipadores='" + getIdDisipadores() + "'";

        return conectar.ejecutaConsulta(sql);

    }

//    public static ArrayList<Integer> obtenerCodigosProveedor() {
//        ArrayList<Integer> codigosProveedor = new ArrayList<>();
//
//        try (Connection conexion = new ConexionPg().getCon();
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

}
