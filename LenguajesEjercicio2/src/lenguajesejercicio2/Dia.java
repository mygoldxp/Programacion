/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lenguajesejercicio2;

import java.util.ArrayList;

/**
 *
 * @author v6222
 */
public class Dia {
    
    private String fecha, uv;
    
    ArrayList <Probabilidad> lPrecipitacion ;
    ArrayList <Probabilidad> lNieve ;
    ArrayList <Probabilidad> lCielo ;
    
    ArrayList <Viento> lViento;
    ArrayList <Viento> lRacha;
    
    ArrayList <Temperatura> lTemperatura;
    ArrayList <Temperatura> lTermica;
    ArrayList <Temperatura> lRelativa;

    public Dia() {
        lPrecipitacion = new ArrayList();
        lNieve = new ArrayList();
        lCielo = new ArrayList();
        lViento = new ArrayList();
        lRacha = new ArrayList();
        lTemperatura = new ArrayList();
        lTermica = new ArrayList();
        lRelativa = new ArrayList();
    }

    public Dia(String fecha, String uv) {
        this.fecha = fecha;
        this.uv = uv;
        lPrecipitacion = new ArrayList();
        lNieve = new ArrayList();
        lCielo = new ArrayList();
        lViento = new ArrayList();
        lRacha = new ArrayList();
        lTemperatura = new ArrayList();
        lTermica = new ArrayList();
        lRelativa = new ArrayList();
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getUv() {
        return uv;
    }

    public void setUv(String uv) {
        this.uv = uv;
    }

    public ArrayList<Probabilidad> getlPrecipitacion() {
        return lPrecipitacion;
    }

    public void setlPrecipitacion(Probabilidad pre) {
        lPrecipitacion.add(pre);
    }

    public ArrayList<Probabilidad> getlNieve() {
        return lNieve;
    }

    public void setlNieve(Probabilidad pre) {
        lNieve.add(pre);
    }

    public ArrayList<Probabilidad> getlCielo() {
        return lCielo;
    }

    public void setlCielo(Probabilidad pre) {
        lCielo.add(pre);
    }

    public ArrayList<Viento> getlViento() {
        return lViento;
    }

    public void setlViento(Viento pre) {
        lViento.add(pre);
    }

    public ArrayList<Viento> getlRacha() {
        return lRacha;
    }

    public void setlRacha(Viento pre) {
        lRacha.add(pre);
    }

    public ArrayList<Temperatura> getlTemperatura() {
        return lTemperatura;
    }

    public void setlTemperatura(Temperatura pre) {
        lTemperatura.add(pre);
    }

    public ArrayList<Temperatura> getlTermica() {
        return lTermica;
    }

    public void setlTermica(Temperatura pre) {
        lTermica.add(pre);
    }

    public ArrayList<Temperatura> getlRelativa() {
        return lRelativa;
    }

    public void setlRelativa(Temperatura pre) {
        lRelativa.add(pre);
    }

    
    
    @Override
    public String toString() {
        String pre = "";
        for(Probabilidad or : lPrecipitacion){
            pre += "\n--->Precipitación: Periodo " + or.getPeriodo() + " probabilidad " + or.getProbabilidad();
        }
        String nieve = "";
        for(Probabilidad or : lNieve){
            nieve += "\n--->Nieve: Periodo " + or.getPeriodo() + " probabilidad " + or.getProbabilidad();
        }
        String cielo = "";
        for(Probabilidad or : lCielo){
            cielo += "\n--->Cielo: Periodo " + or.getPeriodo() + " descripción " + or.getDescripcion() + " probabilidad " + or.getProbabilidad();
        }
        String viento = "";
        for(Viento or : lViento){
            viento += "\n--->Viento: Periodo " + or.getPeriodo() + " dirección " + or.getDireccion()+ " velocidad " + or.getVelocidad();
        }
        String racha = "";
        for(Viento or : lRacha){
            racha += "\n--->Racha: Periodo " + or.getPeriodo() + " máxima " + or.getVelocidad();
        }
        String temp = "";
        for(Temperatura or : lTemperatura){
            String dato = "";
            for(Dato ur : or.ldato){
                dato += "\n------>Hora " + ur.getHora() + " dato " + ur.getDato();
            }
            temp += "\n--->Temperatura: máxima " + or.getMaxima()+ " mínima " + or.getMinima() + dato;
        }
        String termica = "";
        for(Temperatura or : lTermica){
            String dato = "";
            for(Dato ur : or.ldato){
                dato += "\n------>Hora " + ur.getHora() + " dato " + ur.getDato();
            }
            temp += "\n--->Térmica: máxima " + or.getMaxima()+ " mínima " + or.getMinima() + dato;
        }
        String relativa = "";
        for(Temperatura or : lRelativa){
            String dato = "";
            for(Dato ur : or.ldato){
                dato += "\n------>Hora " + ur.getHora() + " dato " + ur.getDato();
            }
            temp += "\n--->Relativa: máxima " + or.getMaxima()+ " mínima " + or.getMinima() + dato;
        }
        
        
        return "Dia " + "fecha=" + fecha + " " + pre + nieve + cielo + viento + racha + temp + termica + relativa +
                "\n--->uv=" + uv + "\n\n";
    }
    
    
    
}
