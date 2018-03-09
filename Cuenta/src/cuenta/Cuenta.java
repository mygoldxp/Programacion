package cuenta;

import javax.swing.JOptionPane;

public class Cuenta {

    public static void main(String[] args) {

        Cuentas cuenta1 = new Cuentas(new Personas("Marron", "Negro", 173d, 75d, "Alex","jajaja", 15), 100);
        Cuentas cuenta2 = new Cuentas(new Personas("Blanco", "Negro", 170d, 80d, "Unai","Puelles López", 18), 50);
        Cuentas cuenta3 = new Cuentas(new Personas("Negro", "Rojo", 190d, 85d, "Sergio","Zulueta", 19));

        cuenta1.Obtener();
        cuenta2.Extraer();
        cuenta3.Ingresar();
        cuenta2.TransferenciaD(cuenta1.TransferenciaO(cuenta2.getTitular()));
        
        
    }

}

