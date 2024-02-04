package Main;

import Controlador.ArmadoPlacaJB;
import Controlador.ArmadoProcJB;
import Controlador.CRUD_ProductosJB;
import Controlador.ControladorAlmacenamiento;
import Controlador.ControladorVenDatosEnvio;
import Controlador.ControladorVentanaPrin;
import Modelo.ModeloProcesador;
import Vista.ArmadoProc_JB;
import Vista.CRUD_Productos_JB;

import Controlador.ControladorlLogin;
import Modelo.ModeloAlmacenamiento;
import Modelo.ModeloCliente;
import Modelo.ModeloDatosEnvio;
import Modelo.ModeloPersona;
import Vista.ArmadoPlaca_JB;
import Vista.VentanaDatosEnvio;
import Vista.VentanaLogin_JM;
import Vista.VentanaPrincipal;
import Vistas.CrearAlmacenamiento;

public class ProyectoFinal {

    public static void main(String[] args) {

//        CRUD_Productos_JB vista = new CRUD_Productos_JB();
//        CRUD_ProductosJB control = new CRUD_ProductosJB(vista);
//        control.iniciar();
//        ArmadoProc_JB vistaA = new ArmadoProc_JB();
//        ArmadoProcJB controlador = new ArmadoProcJB(vistaA);
//        controlador.Inicio();
//        VentanaPrincipal v = new VentanaPrincipal();
//        ControladorVentanaPrin contro = new ControladorVentanaPrin(v);
//        contro.iniciarControl();
//          CrearAlmacenamiento vis = new CrearAlmacenamiento();
//          Modelo.ModeloAlmacenamiento mAl = new ModeloAlmacenamiento();
//          ControladorAlmacenamiento Clo = new ControladorAlmacenamiento(mAl, vis);
//          Clo.iniciaControl();
        VentanaDatosEnvio dat = new VentanaDatosEnvio();
        ModeloDatosEnvio mDtos = new ModeloDatosEnvio();
        ModeloPersona mPersona = new ModeloPersona();
        ModeloCliente mCliente = new ModeloCliente();
        ControladorVenDatosEnvio log = new ControladorVenDatosEnvio(mCliente, mPersona, mDtos, dat);
        log.iniciaControlador();

//        ArmadoPlaca_JB vistaA = new ArmadoPlaca_JB();
//        ArmadoPlacaJB controlador = new ArmadoPlacaJB(vistaA);
//        controlador.Inicio();
//        VentanaLogin_JM vista = new VentanaLogin_JM();
//        Modelo.ModeloCliente mCliente = new ModeloCliente();
//        ControladorlLogin cLogin = new ControladorlLogin(mCliente, vista);
//        cLogin.iniciaControlador();
    }

}
