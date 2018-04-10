/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lenguajesejercicio4;

/**
 *
 * @author v6222
 */
public class Pelicula {
    
    String categoria, titulo, director;
    int anyo, duracion;
    String medida;

    public Pelicula() {
    }

    public Pelicula(String categoria, String titulo, String director, int anyo, int duracion, String medida) {
        this.categoria = categoria;
        this.titulo = titulo;
        this.director = director;
        this.anyo = anyo;
        this.duracion = duracion;
        this.medida = medida;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getAnyo() {
        return anyo;
    }

    public void setAnyo(int anyo) {
        this.anyo = anyo;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getMedida() {
        return medida;
    }

    public void setMedida(String medida) {
        this.medida = medida;
    }
    
    
    
}
