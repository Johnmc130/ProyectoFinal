package Main;

import Controlador.ControladorlLogin;
import Modelo.ModeloCliente;
import Vista.VentanaLogin_JM;

public class ProyectoFinal {

    public static void main(String[] args) {
        VentanaLogin_JM vista = new VentanaLogin_JM();
        Modelo.ModeloCliente mCliente = new ModeloCliente();
        ControladorlLogin cLogin = new ControladorlLogin(mCliente, vista);
        cLogin.iniciaControlador();
    }

}
