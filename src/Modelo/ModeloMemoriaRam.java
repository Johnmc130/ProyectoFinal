/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Clases.memoriaRam;
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
public class ModeloMemoriaRam extends memoriaRam{
    
    Conexion conectar = new Conexion();//Conectamos a la base
    Connection con;
    PreparedStatement ps;

    public static List<memoriaRam> listaTodasmemoriaRam() {
        Conexion conectar = new Conexion();
        List<memoriaRam> listamemoriaRam = new ArrayList<memoriaRam>();
        String sql;
        sql = "SELECT idmemoriaRam,marca,modelo,tipo,capacidad,precio,numeromodulos,stock, foto FROM memoria_ram";
        ResultSet rs = conectar.consultaBase(sql);
        try {
            while (rs.next()) {
                memoriaRam mimemoriaRam = new memoriaRam();
                mimemoriaRam.setIdMemoriaRam(rs.getInt("idmemoriaRam"));

                mimemoriaRam.setMarca(rs.getString("marca"));
                mimemoriaRam.setModelo(rs.getString("modelo"));
                mimemoriaRam.setTipo(rs.getString("tipo"));
                mimemoriaRam.setCapacidad(rs.getInt("capacidad"));
                mimemoriaRam.setPrecio(rs.getDouble("precio"));
                mimemoriaRam.setNumeroModulos(rs.getInt("numeromodulos"));
                mimemoriaRam.setStock(rs.getInt("Stock"));
                mimemoriaRam.setFoto(rs.getBytes("foto"));

                listamemoriaRam.add(mimemoriaRam);

            }
            rs.close();
            return listamemoriaRam;

        } catch (SQLException ex) {

            System.out.println("problemas en el listado");
            Logger.getLogger(ModeloMemoriaRam.class.getName()).log(Level.SEVERE, null, ex);
            return null;//CUANDO REGRESA NULL, HUBO ERROR EN EL QUERY
        }

    }
    
    public static List<memoriaRam> listaRAMCompartible(String tiporam) {
        // Se establece una conexión a la base de datos utilizando la clase Conexion
        Conexion conectar = new Conexion();
        // Se crea una lista vacía para almacenar las placas base compatibles
        List<memoriaRam> listamemoriaRam = new ArrayList<memoriaRam>();
        // Se define la consulta SQL para seleccionar las placas base compatibles con el socket dado
        String sql;
        sql = "SELECT idmemoriaRam,marca,modelo,tipo,capacidad,precio,numeromodulos,stock, foto FROM memoria_ram "
                + "WHERE tipo = ?";
        try {
            // Se prepara la sentencia SQL con el PreparedStatement para evitar inyección de SQL
            PreparedStatement pstmt = conectar.getConexion().prepareStatement(sql);
            // Se establece el valor del parámetro socket en la consulta SQL
            pstmt.setString(1, tiporam);
            // Se ejecuta la consulta y se obtiene un ResultSet con los resultados
            ResultSet rs = pstmt.executeQuery();
            // Se recorre el ResultSet para obtener cada fila de datos
            while (rs.next()) {
                // Se crea un objeto Placamadre y se asignan los valores de las columnas correspondientes
                memoriaRam miram = new memoriaRam();
                miram.setIdMemoriaRam(rs.getInt("idmemoriaRam"));
                miram.setMarca(rs.getString("marca"));
                miram.setModelo(rs.getString("modelo"));
                miram.setTipo(rs.getString("tipo"));
                miram.setCapacidad(rs.getInt("capacidad"));
                miram.setPrecio(rs.getDouble("precio"));
                miram.setNumeroModulos(rs.getInt("numeromodulos"));
                miram.setStock(rs.getInt("Stock"));
                //miram.setId_proveedor(rs.getInt("id_proveedor"));
                miram.setFoto(rs.getBytes("foto"));

                // Se agrega el objeto Placamadre a la lista de placas base compatibles
                listamemoriaRam.add(miram);
            }
            // Se cierra el ResultSet
            rs.close();
            // Se devuelve la lista de placas base compatibles
            return listamemoriaRam;

        } catch (SQLException ex) {
            // En caso de error, se imprime un mensaje de error en la consola y se devuelve null
            System.out.println("problemas en el listado");
            Logger.getLogger(ModeloPlacaMadre.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            // Se cierra la conexión a la base de datos
            conectar.cerrar();
        }
    }

    public SQLException grabarmemoriaRam() {

        String sql;//"INSERT INTO TABLA () VALUES()"
        sql = "INSERT INTO memoria_ram (marca, Modelo, tipo, capacidad, precio, numeromodulos, stock, foto) "
                + "VALUES('" + getMarca() + "','" + getModelo() + "','" + getTipo() + "','" + getCapacidad() + "','" + getPrecio() + "','" + getNumeroModulos() + "','" + getStock() + "','" + getFoto() + ")";

        return conectar.ejecutaConsulta(sql);
    }

    public SQLException eliminar() {
        String sql = "delete from memoria_ram where idmemoriaram='" + getIdMemoriaRam() + "'";

        return conectar.ejecutaConsulta(sql);

    }

    public SQLException editarmemoriaRam() {
        String sql;//"INSERT INTO TABLA () VALUES()"
        sql = "update memoria_ram set  marca='" + getMarca() + "', Modelo='" + getModelo() + "', tipo='" + getTipo() + "', capacidad='" + getCapacidad() + "', numeromodulos='" + getNumeroModulos() + "', precio='" + getPrecio() + "',stock='" + getStock() + "'where idmemoriaram='" + getIdMemoriaRam() + "'";

        return conectar.ejecutaConsulta(sql);

    }
//
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
