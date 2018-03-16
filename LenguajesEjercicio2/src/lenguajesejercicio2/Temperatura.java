/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lenguajesejercicio2;

import java.util.ArrayList;

/**
 *
 * @author v6222
 */
public class Temperatura {
 
    String maxima, minima;
    ArrayList <Dato> ldato;

    public Temperatura() {
        ldato = new ArrayList();
    }

    public Temperatura(String maxima, String minima) {
        this.maxima = maxima;
        this.minima = minima;
        this.ldato = new ArrayList();
    }

    public String getMaxima() {
        return maxima;
    }

    public void setMaxima(String maxima) {
        this.maxima = maxima;
    }

    public String getMinima() {
        return minima;
    }

    public void setMinima(String minima) {
        this.minima = minima;
    }

    public ArrayList<Dato> getLdato() {
        return ldato;
    }

    public void setLdato(Dato dato) {
        this.ldato.add(dato);
    }

    
    
}
