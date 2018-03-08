package Modelo;

public class Empleado extends Persona{
    
    private double sueldo_bruto;
    
    public Empleado(String nombre,int edad,double sueldo)
    {
        super(nombre,edad);
        sueldo_bruto = sueldo;
    }

    public double getSueldo_bruto() {
        return sueldo_bruto;
    }

    public void setSueldo_bruto(double sueldo_bruto) {
        this.sueldo_bruto = sueldo_bruto;
    }
    
    @Override
    public String mostrar(){
        return this.getNombre() + " " + this.getEdad() + " " + this.getSueldo_bruto();
    }
    
}
