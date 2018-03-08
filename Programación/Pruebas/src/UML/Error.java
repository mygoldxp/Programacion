/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UML;

/**
 *
 * @author v6222
 */
public class Error extends Exception{
    int cod;

    public Error(int cod) {
        this.cod = cod;
    }
    
    
}
