
package Recursos;
import javax.swing.*;
public class Circunferencia {
    public double radio;
    
    public Circunferencia(){
        
    }
    
    public Circunferencia(double radio){
        this.radio = radio;
    }

    public double getLongitud(){
        return 2 * Math.PI * radio;
    }
    
    public double getArea(){
        return Math.PI * Math.pow(radio, 2);
    }
    
    public double getVolumen(){
        return 4 * Math.PI * Math.pow(radio, 3)/ 3;
    }
    
    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }
    
}
