/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Excepciones;

/**
 *
 * @author 1gprogexa15
 */
public class Error extends Exception{
    
    int cod;

    public Error() {
    }

    public Error(int cod) {
        this.cod = cod;
    }

    @Override
    public String getMessage(){
        String dato ="";
        switch(cod){
            case 1:
                dato ="El título de la película es obligatorio y tiene el siguiente formato:\nNnn (Ejemplo: Masacre)";
                break;
                
            case 2:
                dato ="El género de la película es Obligatorio de indicar";
                break;
                
            case 3:
                dato ="El tipo de persona es obligatorio de indicar, ACTOR, DIRECTOR o GUINISTA.";
                break;
                
            case 4:
                dato ="El nombre es Obligatorio y tiene el siguiente formato:\nNnn (Ejemplo: Jon)";
                break;
                
            case 5:
                dato ="La fecha de nacimiento es Obligatorio y tiene un formato dd-mm-aaaa";
                break;
                
            case 6:
                dato ="Ha habido un problema a la hora de guardar.";
                break;
        }
        return dato;
    }
    
}
