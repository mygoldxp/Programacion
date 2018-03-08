/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Errores;
/**
 *
 * @author v6222
 */
public class Error extends Exception{
    public int error;

    public Error() {
    }

    public Error(int error) {
        this.error = error;
    }

    @Override
    public String getMessage(){
        String dato="";
        switch(error)
        {
            case 1: dato = "Letra(N), Nnn";
            
            break;
            
            case 2: dato = "Letra(N), Nnn";
            break;
            
            case 3: dato = "Numérico(N), NNNNNNNNN";
            break;
            
            case 4: dato = "Alfanumérico, ejemplo@ejemplo.es";
            break;
            
            case 5: dato = "La fecha de nacimiento NO puede ser superior a la fecha actual.";
            break;
        }
    return dato;        
    }
}
