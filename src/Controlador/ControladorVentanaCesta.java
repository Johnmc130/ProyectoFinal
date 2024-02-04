/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.VentanaCesta;
import Vista.VentanaDatosEnvio;

/**
 *
 * @author Steven Zhicay
 */
public class ControladorVentanaCesta {

    private VentanaCesta vista;

    public ControladorVentanaCesta(VentanaCesta vista) {

        this.vista = vista;
        vista.setVisible(true);

    }

    public void Inicio() {
        vista.setLocationRelativeTo(null);
        iniciarControl();
        System.out.println("aqui");
    }

    public void iniciarControl() {
        vista.getBtnRealizarPedido().addActionListener(l -> botonPedido());
    }

    public void botonPedido() {
        VentanaCesta v = new VentanaCesta();
        v.setVisible(false);
        VentanaDatosEnvio p = new VentanaDatosEnvio();
        v.setVisible(true);
    }
}
