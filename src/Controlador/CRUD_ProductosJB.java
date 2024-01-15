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
        vista.getBtProcesador().addActionListener(l -> crud(1));
        vista.getBtAtrasDlg().addActionListener(l -> atrasDlg());
    }

    public void crud(int numero) {
        switch (numero) {
            case 1:
                vista.getLblTitulo().setText("Procesadores");
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                break;
            case 9:
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
        vista.setEnabled(true);
        vista.setVisible(true);
    }
}
