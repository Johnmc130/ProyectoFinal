/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Clases.FuentePoder;
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
public class ModeloFuentePoder extends FuentePoder {

    Conexion conectar = new Conexion();//Conectamos a la base
    Connection con;
    PreparedStatement ps;

    public static List<FuentePoder> listaTodasFuentePoder() {
        Conexion conectar = new Conexion();
        List<FuentePoder> listaFuentePoder = new ArrayList<FuentePoder>();
        String sql;
        sql = " SELECT idfuentepoder, marca, modelo, certificacion, modular, formato, precio, stock, watts, foto FROM fuente_poder";
        ResultSet rs = conectar.consultaBase(sql);
        try {
            while (rs.next()) {
                FuentePoder miFuentePoder = new FuentePoder();
                miFuentePoder.setIdFuentePoder(rs.getInt("idfuentepoder"));
                miFuentePoder.setMarca(rs.getString("marca"));
                miFuentePoder.setModelo(rs.getString("modelo"));
                miFuentePoder.setCertificacion(rs.getString("certificacion"));
                miFuentePoder.setModular(rs.getString("modular"));
                miFuentePoder.setFormato(rs.getString("formato"));
                miFuentePoder.setPrecio(rs.getDouble("precio"));

                miFuentePoder.setStock(rs.getInt("stock"));
                miFuentePoder.setFoto(rs.getBytes("foto"));

                miFuentePoder.setWatts(rs.getString("watts"));

                listaFuentePoder.add(miFuentePoder);

            }
            rs.close();
            return listaFuentePoder;

        } catch (SQLException ex) {

            System.out.println("problemas en el listado");
            Logger.getLogger(ModeloFuentePoder.class.getName()).log(Level.SEVERE, null, ex);
            return null;//CUANDO REGRESA NULL, HUBO ERROR EN EL QUERY
        }

    }

    public static List<FuentePoder> listaTodasFuentePoderCompatibles(String formato) {
        Conexion conectar = new Conexion();
        List<FuentePoder> listaFuentePoder = new ArrayList<FuentePoder>();
        String sql;
        sql = " SELECT idfuentepoder, marca, modelo, certificacion, modular, formato, precio, stock, watts, foto "
                + "FROM fuente_poder"
                + " WHERE formato = ?";

        try {
            // Se prepara la sentencia SQL con el PreparedStatement para evitar inyección de SQL
            PreparedStatement pstmt = conectar.getConexion().prepareStatement(sql);
            // Se establece el valor del parámetro socket en la consulta SQL
            pstmt.setString(1, formato);
            // Se ejecuta la consulta y se obtiene un ResultSet con los resultados
            ResultSet rs = pstmt.executeQuery();
            // Se recorre el ResultSet para obtener cada fila de datos
            while (rs.next()) {
                FuentePoder miFuentePoder = new FuentePoder();
                miFuentePoder.setIdFuentePoder(rs.getInt("idfuentepoder"));
                miFuentePoder.setMarca(rs.getString("marca"));
                miFuentePoder.setModelo(rs.getString("modelo"));
                miFuentePoder.setCertificacion(rs.getString("certificacion"));
                miFuentePoder.setModular(rs.getString("modular"));
                miFuentePoder.setFormato(rs.getString("formato"));
                miFuentePoder.setPrecio(rs.getDouble("precio"));

                miFuentePoder.setStock(rs.getInt("stock"));
                miFuentePoder.setFoto(rs.getBytes("foto"));

                miFuentePoder.setWatts(rs.getString("watts"));

                listaFuentePoder.add(miFuentePoder);

            }
            rs.close();
            return listaFuentePoder;

        } catch (SQLException ex) {

            System.out.println("problemas en el listado");
            Logger.getLogger(ModeloFuentePoder.class.getName()).log(Level.SEVERE, null, ex);
            return null;//CUANDO REGRESA NULL, HUBO ERROR EN EL QUERY
        }

    }

    public SQLException grabarFuentePoder() {

        String sql;//"INSERT INTO TABLA () VALUES()"
        sql = "INSERT INTO fuente_poder (marca, modelo, certificacion, modular,formato, watts, precio, stock,foto) "
                + "VALUES('" + getMarca() + "','" + getModelo() + "','" + getCertificacion() + "','" + getModular() + "','" + getFormato() + "','" + getWatts() + "','" + getPrecio() + "','" + getStock() + "','" + getFoto() + "')";

        return conectar.ejecutaConsulta(sql);
    }

    public SQLException eliminar() {
        String sql = "delete from fuente_poder where idfuentepoder='" + getIdFuentePoder() + "'";

        return conectar.ejecutaConsulta(sql);

    }

    public SQLException editarFuentePoder() {
        String sql;//"INSERT INTO TABLA () VALUES()"
        sql = "update fuente_poder set  marca='" + getMarca() + "', modelo='" + getModelo() + "', certificacion='" + getCertificacion() + "', modular='" + getModular() + "', formato='" + getFormato() + "', watts='" + getWatts() + "', precio='" + getPrecio() + "',stock='" + getStock() + "'where idfuentepoder='" + getIdFuentePoder() + "'";

        return conectar.ejecutaConsulta(sql);

    }

//    public static ArrayList<Integer> obtenerCodigosProveedor() {
//        ArrayList<Integer> codigosProveedor = new ArrayList<>();
//
//        try (Connection conexion = new Conexion().getConexion();
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
