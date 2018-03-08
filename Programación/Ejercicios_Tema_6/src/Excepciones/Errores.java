/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Excepciones;

import javax.swing.JOptionPane;

/**
 *
 * @author v6222
 */
public class Errores extends Exception{
    public int cod;

    public Errores() {
    }

    public Errores(int cod) {
        this.cod = cod;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }
    
    public String getMessage(){
        String v="";
        switch(cod){
            case 1:
                v = "El formato del nombre es incorrecto.\n(Xxx) Primero Mayus y mínimo 3 letras.";
                break;
            case 2:
                v = "El formato del número de la S.S. es incorrecto.\nxx-xxxxxxxx-xx";
                break;
            case 3:
                v = "El formato de dirección es incorrecto.\nXx... nn nx\nNombre calle número piso y letra.";
                break;
            case 4:
                v = "El formato del Código postal es incorrecto.\nxxxxx";
                break;
            case 5:
                v = "El formato de la ciudad es incorrecto.\nMínimo 3 letras.";
                break;
        }
        return v;
    }
}
