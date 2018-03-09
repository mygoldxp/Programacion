/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Excepcion;

/**
 *
 * @author Jon
 */
public class Error extends Exception {
    int n;

    public Error(int n) {
        this.n = n;
    }
    
    @Override
    public String getMessage(){
        String dato = "";
        switch(n){
            case 1:
                dato = "El nombre del Evento ha de tener un formato Nn, Ejemplo: Palacio de congresos";
                break;
                
            case 2:
                dato = "El lugar del Evento ha de tener un formato Nn, Ejemplo: Oficina piso primero 222";
                break;
                
            case 3:
                dato = "Las plazas han de ser numéricas con un valor mínimo de 0.";
                break;
                
            case 4:
                dato = "La fecha del evento ha de ser posterior a la fecha actual.";
                break;
                
            case 5:
                dato = "El nombre ha de tener un formato Nn, Ejemplo: Mario";
                break;
                
            case 6:
                dato = "Los apellidos tienen un formato Nn, Ejemplo: Arias rubio";
                break;
                
            case 7:
                dato = "El DNI tiene un formato DDDDDDDDN, Ejemplo 00000000A";
                break;
                
            case 8:
                dato = "La dirección ha de tener un formato Nn, Ejemplo: General loma 5";
                break;
                
            case 9:
                dato = "La edad ha de ser numérico, con un valor mínimo de 0.";
                break;
                
            case 10:
                dato = "El teléfono tiene un formato numérico mínimo de 9 dígitos y debe comenzar por 6,7,8 o 9, Ejemplo 666666666";
                break;
                
            case 11:
                dato = "El evento ya existe.";
                break;
                
            case 12:
                dato = "El CIF tiene un formato NDDDDDDDD, Ejemplo A00000000";
                break;
             
                
            case 13:
                dato = "El nombre de la empresa ha de tener un formato Nn, Ejemplo: San maniego s.l.";
                break;
                
            case 14:
                dato = "No se puede añadir a esta persona, ya que no existe en esta empresa.";
                break;   
                
        }
        return dato;
    }
}
