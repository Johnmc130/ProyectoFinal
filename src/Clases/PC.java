/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.util.ArrayList;

/**
 *
 * @author TheBigG
 */

public class PC {
    
    private int id;
    private int idProcesador = 0;
    private int idPlacaMadre = 0;
    private int idTarjetaGrafica = 0;
    private int idRam = 0;
    private int idFuentePoder = 0;
    private int idAlmacenamiento = 0;
    private int idGabinete = 0;
    private int idVentiladores = 0;
    private int idDisipador = 0;

    public PC() {
    }
    
    public PC(int id,int idProcesador, int idPlacaMadre, int idTarjetaGrafica, int idRam, int idFuentePoder, int idAlmacenamiento, int idGabinete, int idVentiladores, int idDisipador) {
        this.id = id;
        this.idProcesador = idProcesador;
        this.idPlacaMadre = idPlacaMadre;
        this.idTarjetaGrafica = idTarjetaGrafica;
        this.idRam = idRam;
        this.idFuentePoder = idFuentePoder;
        this.idAlmacenamiento = idAlmacenamiento;
        this.idGabinete = idGabinete;
        this.idVentiladores = idVentiladores;
        this.idDisipador = idDisipador;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdProcesador() {
        return idProcesador;
    }

    public void setIdProcesador(int idProcesador) {
        this.idProcesador = idProcesador;
    }

    public int getIdPlacaMadre() {
        return idPlacaMadre;
    }

    public void setIdPlacaMadre(int idPlacaMadre) {
        this.idPlacaMadre = idPlacaMadre;
    }

    public int getIdTarjetaGrafica() {
        return idTarjetaGrafica;
    }

    public void setIdTarjetaGrafica(int idTarjetaGrafica) {
        this.idTarjetaGrafica = idTarjetaGrafica;
    }

    public int getIdRam() {
        return idRam;
    }

    public void setIdRam(int idRam) {
        this.idRam = idRam;
    }

    public int getIdFuentePoder() {
        return idFuentePoder;
    }

    public void setIdFuentePoder(int idFuentePoder) {
        this.idFuentePoder = idFuentePoder;
    }

    public int getIdAlmacenamiento() {
        return idAlmacenamiento;
    }

    public void setIdAlmacenamiento(int idAlmacenamiento) {
        this.idAlmacenamiento = idAlmacenamiento;
    }

    public int getIdGabinete() {
        return idGabinete;
    }

    public void setIdGabinete(int idGabinete) {
        this.idGabinete = idGabinete;
    }

    public int getIdVentiladores() {
        return idVentiladores;
    }

    public void setIdVentiladores(int idVentiladores) {
        this.idVentiladores = idVentiladores;
    }

    public int getIdDisipador() {
        return idDisipador;
    }

    public void setIdDisipador(int idDisipador) {
        this.idDisipador = idDisipador;
    }

    @Override
    public String toString() {
        return "PC{" + "id=" + id + ", idProcesador=" + idProcesador + ", idPlacaMadre=" + idPlacaMadre + ", idTarjetaGrafica=" + idTarjetaGrafica + ", idRam=" + idRam + ", idFuentePoder=" + idFuentePoder + ", idAlmacenamiento=" + idAlmacenamiento + ", idGabinete=" + idGabinete + ", idVentiladores=" + idVentiladores + ", idDisipador=" + idDisipador + '}';
    }

  

}
