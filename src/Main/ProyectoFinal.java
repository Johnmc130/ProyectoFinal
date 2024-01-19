package Main;


import Controlador.ArmadoJB;
import Controlador.CRUD_ProductosJB;
import Modelo.ModeloProcesador;
import Vista.Armado_JB;
import Vista.CRUD_Productos_JB;

import Controlador.ControladorlLogin;
import Modelo.ModeloCliente;
import Vista.VentanaLogin_JM;


public class ProyectoFinal {

    public static void main(String[] args) {

//        CRUD_Productos_JB vista = new CRUD_Productos_JB();
//        CRUD_ProductosJB control = new CRUD_ProductosJB(vista);
//        control.iniciar();
        
        ModeloProcesador mp = new ModeloProcesador();
        Armado_JB vistaA = new Armado_JB();
        ArmadoJB controlador = new ArmadoJB(mp, vistaA);
        controlador.Inicio();

        VentanaLogin_JM vista = new VentanaLogin_JM();
        Modelo.ModeloCliente mCliente = new ModeloCliente();
        ControladorlLogin cLogin = new ControladorlLogin(mCliente, vista);
        cLogin.iniciaControlador();

    }

}
