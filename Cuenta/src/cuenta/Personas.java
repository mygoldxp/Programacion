/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cuenta;

/**
 *
 * @author v6222
 */
public class Personas {
    private String Color_Ojo;
    private String Color_Pelo;
    private Double Altura;
    private Double Peso;
    private String nombre, apellidos;
    private int edad=0;
    
        
    public Personas(String DColor_Ojo, String DColor_Pelo, Double DAltura, Double DPeso, String Dnombre, String Dapellidos, int Dedad){
        
        Color_Ojo=DColor_Ojo;
        Color_Pelo=DColor_Pelo;
        Altura=DAltura;
        Peso=DPeso;
        nombre=Dnombre;
        apellidos=Dapellidos;
        edad = Dedad;
                
    }

    public String getColor_Ojo() {
        return Color_Ojo;
    }

    public void setColor_Ojo(String Color_Ojo) {
        this.Color_Ojo = Color_Ojo;
    }

    public String getColor_Pelo() {
        return Color_Pelo;
    }

    public void setColor_Pelo(String Color_Pelo) {
        this.Color_Pelo = Color_Pelo;
    }

    public Double getAltura() {
        return Altura;
    }

    public void setAltura(Double Altura) {
        this.Altura = Altura;
    }

    public Double getPeso() {
        return Peso;
    }

    public void setPeso(Double Peso) {
        this.Peso = Peso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    
}
