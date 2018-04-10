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
    
    int n;

    public Error(int n) {
        this.n = n;
    }
    
    @Override
    public String getMessage(){
        String dato = "";
        switch(n){
            case 1:
                dato = "Opción inexistente.";
                break;
                
            case 2:
                dato = "Nombre no válido.";
                break;
                
            case 3:
                dato = "Edad no válida.";
                break;
                
            case 4:
                dato = "Profesión no válida.";
                break;
                
            case 5:
                dato = "Teléfono no válido.";
                break;
                
            case 6:
                dato = "Ya existe esta Persona.";
                break;
                
            case 7:
                dato = "No existe esta Persona.";
                break;
        }
        return dato;
    }
}
