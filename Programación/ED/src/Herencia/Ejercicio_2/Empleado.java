package Herencia.Ejercicio_2;

import javax.swing.JOptionPane;

/**
 *
 * @author v6222
 */
public class Empleado {
    protected String nombre;
    protected String dni;
    protected int edad;
    protected boolean casado;
    protected double salario;

    public Empleado(){
        
    }
    
    public Empleado(String enombre, String edni, int eedad, boolean ecasado, double esarario){
        nombre = enombre;
        dni = edni;
        edad = eedad;
        casado = ecasado;
        salario = esarario;     
    }
    
    public String Clasificacion(){

        if(edad <= 21){
            return "Principiante";
        }
        else if(edad > 35){
            return "Senior";
        }
        else{
            return "Intermedio";
        }
    }
    
    public void Aumento(double asalario){
        salario = ((asalario /100) * salario) + salario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public boolean isCasado() {
        return casado;
    }

    public void setCasado(boolean casado) {
        this.casado = casado;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Empleado " + Clasificacion() + "\n" + "nombre=" + nombre + "\ndni=" + dni + "\nedad=" + edad + "\ncasado=" + casado + "\nsalario=" + salario;
    }
    
    
}
