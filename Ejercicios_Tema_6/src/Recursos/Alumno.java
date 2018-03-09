package Recursos;

public class Alumno {
    
    int num, telf;
    String nom, dir;
    
    public Alumno(){
    
    }
    
    public Alumno(int num, String nom, String dir, int telf){
        this.num = num;
        this.nom = nom;
        this.dir = dir;
        this.telf = telf;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getTelf() {
        return telf;
    }

    public void setTelf(int telf) {
        this.telf = telf;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }
    
    
}
