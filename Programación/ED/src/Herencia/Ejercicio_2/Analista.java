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
public class Analista extends Empleado{
    private int personasacargo;
    
    public Analista(){
        
    }
    
    public Analista(String anombre, String adni, int aedad, boolean acasado, double asarario, int apersonasacargo){
        super(anombre, adni, aedad, acasado, asarario);
        personasacargo = apersonasacargo;
    }

    public int getPersonasacargo() {
        return personasacargo;
    }

    public void setPersonasacargo(int personasacargo) {
        this.personasacargo = personasacargo;
    }

    @Override
    public String toString() {
        return super.toString() + "\nAnalista\n" + "personas a cargo\n" + personasacargo ;
    }
    
    public void Aumento(double porcentaje){
        porcentaje+= 5;
        salario = (porcentaje /100 * salario) + salario;
    }
    
}
