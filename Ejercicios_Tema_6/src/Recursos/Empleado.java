package Recursos;

public class Empleado {
    public String nombre, fecha, ss;
    
    public Empleado(){
        
    }
    
    public Empleado(String nombre, String ss, String fecha){
        this.nombre = nombre;
        this.ss = ss;
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getSs() {
        return ss;
    }

    public void setSs(String ss) {
        this.ss = ss;
    }

    @Override
    public String toString() {
        return "El empleado " + nombre + ".\nNúmero S.S. " + ss + ".\nLleva desde el " + fecha + " en la empresa.\nEs el más antiguo.";
    }
    
    
}
