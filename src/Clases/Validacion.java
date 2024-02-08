package Clases;

public class Validacion {

    public boolean Cedula(String cedula) {
        try {
            if (cedula.length() != 10) {
                return false;
            }
            int provincia = Integer.parseInt(cedula.substring(0, 2));
            if (provincia < 1 || provincia > 24) {
                return false;
            }

            int tercerDigito = Integer.parseInt(cedula.substring(2, 3));
            if (tercerDigito > 6) {
                return false;
            }
            int[] coeficientes = {2, 1, 2, 1, 2, 1, 2, 1, 2};
            int verificador = Integer.parseInt(cedula.substring(9, 10));
            int suma = 0;
            for (int i = 0; i < coeficientes.length; i++) {
                int digito = Integer.parseInt(cedula.substring(i, i + 1));
                int producto = digito * coeficientes[i];
                if (producto > 9) {
                    producto -= 9;
                }
                suma += producto;
            }
            int digitoVerificadorCalculado = 10 - (suma % 10);
            if (digitoVerificadorCalculado == 10) {
                digitoVerificadorCalculado = 0;
            }
            if (digitoVerificadorCalculado != verificador) {
                return false;
            } else {
                return true;
            }
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean Contraseña(String Contrasena) {
        if (Contrasena.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$")) {
            return true;
        } else if (Contrasena.length() < 8) {
            return false;
        } else {
            return false;
        }
    }

    public boolean Texto(String Texto) {
        if (Texto.matches("^[a-zA-z]{1,15}$")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean Numeros(String Numeros) {
        if (Numeros.matches("^[0-9]+$")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean Web(String Web) {
        if (Web.matches("^(www\\.)[a-zA-Z0-9]+\\.com$")) {
            return true;
        } else {
            return false;
        }

    }

}
