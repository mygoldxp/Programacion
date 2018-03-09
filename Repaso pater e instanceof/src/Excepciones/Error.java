/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Excepciones;

/**
 *
 * @author Jon
 */
public class Error extends Exception{
    int cod;

    public Error(int cod) {
        this.cod = cod;
    }
    
    @Override
    public String getMessage(){
        String dato = "";
        switch(cod){
            case 1:
                dato = "Inválido";
                break;
                
            case 2:
                dato = "Nada";
                break;
        }
        return dato;
    }
}
