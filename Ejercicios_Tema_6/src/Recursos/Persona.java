package Recursos;

public class Persona {
    
    public String nombre, fecha, direccion, cp, ciudad;
    
    public Persona(){
        
    }
    
    public Persona(String nombre, String fecha, String direccion, String cp, String ciudad){
        this.nombre = nombre;
        this.fecha = fecha;
        this.direccion = direccion;
        this.cp = cp;
        this.ciudad = ciudad;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    @Override
    public String toString() {
        return "La persona " + nombre + "\nNacido con fecha " + fecha + "\nVive en " + direccion + ", " + cp + ", " + ciudad + "\nEs el de mayor edad de todas. ";
    }
    
}
