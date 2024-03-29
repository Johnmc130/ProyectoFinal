/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Clases.Disipadores;
import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

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
        List<Disipadores> listaDisipadores = new ArrayList<>();
        String sql;
        sql = "SELECT iddisipadores,marca,modelo,socket,rgb,ventiladores,precio,stock, foto FROM disipadores";
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
                midisipadores.setFoto(rs.getBytes("foto"));

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

    public static List<Disipadores> listaTodasDisipadoresCompatibles(String Socket) {
        Conexion conectar = new Conexion();
        List<Disipadores> listaDisipadores = new ArrayList<>();
        String sql;
        sql = "SELECT iddisipadores,marca,modelo,socket,rgb,ventiladores,precio,stock, foto "
                + "FROM disipadores "
                + "WHERE socket = ?";
        try {
            // Se prepara la sentencia SQL con el PreparedStatement para evitar inyecciÃ³n de SQL
            PreparedStatement pstmt = conectar.getConexion().prepareStatement(sql);
            // Se establece el valor del parÃ¡metro socket en la consulta SQL
            pstmt.setString(1, Socket);
            // Se ejecuta la consulta y se obtiene un ResultSet con los resultados
            ResultSet rs = pstmt.executeQuery();
            // Se recorre el ResultSet para obtener cada fila de datos
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
                midisipadores.setFoto(rs.getBytes("foto"));

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
        sql = "INSERT INTO disipadores (marca, modelo, socket, rgb,ventiladores, precio, stock, foto) "
                + "VALUES('" + getMarca() + "','" + getModelo() + "','" + getSocket() + "','" + getRGB() + "','" + getVentiladores() + "','" + getPrecio() + "','" + getStock() + "','" + getFoto() + "')";

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

    public int obtenerSiguienteId() {
        int siguienteId = 1; // Valor predeterminado si no hay registros
        try {
            if (conectar != null && !conectar.getConexion().isClosed());
            String sql = "SELECT MAX(iddisipadores) FROM disipadores";
            PreparedStatement statement = conectar.getConexion().prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                siguienteId = resultSet.getInt(1) + 1;
            }
            return siguienteId;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return siguienteId;
    }

}
