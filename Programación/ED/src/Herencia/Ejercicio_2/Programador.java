/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Herencia.Ejercicio_2;

/**
 *
 * @author v6222
 */
public class Programador extends Empleado {
    private int lineasDeCodigoPorHora;
    private String lenguajeDominante;
    
    public Programador(){
        super();
    }
       
    public Programador(String pnombre, String pdni, int pedad, boolean pcasado, double psarario, int plineasDeCodigoPorHora, String plenguajeDominante){
        super(pnombre, pdni, pedad, pcasado, psarario);
        lineasDeCodigoPorHora = plineasDeCodigoPorHora;
        lenguajeDominante = plenguajeDominante;
    }

    public int getLineasDeCodigoPorHora() {
        return lineasDeCodigoPorHora;
    }

    public void setLineasDeCodigoPorHora(int lineasDeCodigoPorHora) {
        this.lineasDeCodigoPorHora = lineasDeCodigoPorHora;
    }

    public String getLenguajeDominante() {
        return lenguajeDominante;
    }

    public void setLenguajeDominante(String lenguajeDominante) {
        this.lenguajeDominante = lenguajeDominante;
    }

    @Override
    public String toString() {
        return super.toString() + "Programador\n" + "lineas De Codigo Por Hora\n" + lineasDeCodigoPorHora + "\nlenguaje Dominante\n" + lenguajeDominante;
    }    
    
    
}
