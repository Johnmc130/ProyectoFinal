/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Vista.CRUD_Productos_JB;

/**
 *
 * @author TheBigG
 */
public class CRUD_ProductosJB {

    private CRUD_Productos_JB vista;

    public CRUD_ProductosJB(CRUD_Productos_JB vista) {
        this.vista = vista;
        vista.setVisible(true);
    }

    public void iniciar() {
        //Botones componentes
        vista.getBtProcesador().addActionListener(l -> crud(1));
        vista.getBtPlacaMadre().addActionListener(l -> crud(2));
        vista.getBtRam().addActionListener(l -> crud(3));
        vista.getBtAlmacenamiento().addActionListener(l -> crud(4));
        vista.getBtTarjetaGrafica().addActionListener(l -> crud(5));
        vista.getBtDisipador().addActionListener(l -> crud(6));
        vista.getBtVentiladores().addActionListener(l -> crud(7));
        vista.getBtFuente().addActionListener(l -> crud(8));
        vista.getBtGabinete().addActionListener(l -> crud(9));
        vista.getBtAtrasDlg().addActionListener(l -> atrasDlg());
    }

    public void crud(int numero) {
        switch (numero) {
            case 1:
                vista.getLblTitulo().setText("Procesadores");
                break;
            case 2:
                vista.getLblTitulo().setText("Placas madre");
                break;
            case 3:
                vista.getLblTitulo().setText("RAMs");
                break;
            case 4:
                vista.getLblTitulo().setText("Almacenamientos");
                break;
            case 5:
                vista.getLblTitulo().setText("Tarjetas Graficas");
                break;
            case 6:
                vista.getLblTitulo().setText("Disipadores");
                break;
            case 7:
                vista.getLblTitulo().setText("Ventiladores");
                break;
            case 8:
                vista.getLblTitulo().setText("Fuentes de Poder");
                break;
            case 9:
                vista.getLblTitulo().setText("Gabinetes");
                break;
        }
        vista.setEnabled(false);
        vista.getJdlgCRUD().setSize(600, 460);
        vista.getJdlgCRUD().setLocationRelativeTo(vista);
        vista.getJdlgCRUD().setUndecorated(true);

        vista.getJdlgCRUD().setVisible(true);

    }

    public void atrasDlg() {
        vista.getJdlgCRUD().setVisible(false);
        vista.getJdlgCRUD().dispose();
        vista.setEnabled(true);
        vista.setVisible(true);
    }
}
