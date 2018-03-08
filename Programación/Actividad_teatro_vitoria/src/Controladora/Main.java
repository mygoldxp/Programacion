/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladora;

import UML.Actuacion;
import UML.Director;
import UML.Obra;
import UML.Teatro;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author v6222
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    static ArrayList <Teatro> listaTeatro;
    
    public static void main(String[] args) {
        // TODO code application logic here
        Teatro t1 = new Teatro(1, "Teatro Principal", "Calle San Prudencio, 32", true);
        Teatro t2 = new Teatro(2, "Teatro Federico García Lorca", "Calle Senda de los Echanove 3", false);
        Teatro t3 = new Teatro(3, "Teatro Beñat Etxepare", "Calle Plaza Zuberoa, 1", true);
        
        Director d1 = new Director("71712233S", "Mario", "Gas", "Española");
        Director d2 = new Director("44647483J", "David", "Serrano", "Española");
        Director d3 = new Director("44561288F", "Pablo", "Messiez", "Argentina");
        
        Actuacion a1 = new Actuacion(1, "15/02/2018 a las 22:00h", false);
        Actuacion a2 = new Actuacion(2, "26/02/2018 a las 20:00h", true);
        Actuacion a3 = new Actuacion(3, "29/02/2018 a las 17:00h", true);
        Actuacion a4 = new Actuacion(4, "02/03/2018 a las 22:00h", false);
        Actuacion a5 = new Actuacion(5, "03/03/2018 a las 22:00h", false);
        Actuacion a6 = new Actuacion(6, "04/03/2018 a las 22:00h", true);
        Actuacion a7 = new Actuacion(7, "05/03/2018 a las 22:00h", true);
        Actuacion a8 = new Actuacion(8, "12/03/2018 a las 20:00h", false);
        Actuacion a9 = new Actuacion(9, "13/03/2018 a las 20:00h", false);
        Actuacion a10 = new Actuacion(10, "18/03/2018 a las 17:00h", true);
        Actuacion a11 = new Actuacion(11, "12/04/2018 a las 21:00h", false);
        Actuacion a12 = new Actuacion(12, "13/04/2018 a las 21:00h", true);
        Actuacion a13 = new Actuacion(13, "14/04/2018 a las 21:00h", true);
        
        t1.setListaObra(new Obra(1, "Incendio", d1));
        t2.setListaObra(new Obra(1, "Incendio", d1));
        t3.setListaObra(new Obra(1, "Incendio", d1));
        t1.setListaObra(new Obra(2, "Cartas de amor", d2));
        t2.setListaObra(new Obra(2, "Cartas de amor", d2));
        t3.setListaObra(new Obra(2, "Cartas de amor", d2));
        t1.setListaObra(new Obra(3, "Todo el tiempo del mundo", d3));
        
        t1.getListaObra().get(0).setListaActuacion(a1);
        t2.getListaObra().get(0).setListaActuacion(a3);
        t3.getListaObra().get(0).setListaActuacion(a2);
        
        t1.getListaObra().get(1).setListaActuacion(a4);
        t1.getListaObra().get(1).setListaActuacion(a5);
        t1.getListaObra().get(1).setListaActuacion(a6);
        t1.getListaObra().get(1).setListaActuacion(a7);
        t3.getListaObra().get(1).setListaActuacion(a8);
        t3.getListaObra().get(1).setListaActuacion(a9);
        t2.getListaObra().get(1).setListaActuacion(a10);
        
        t1.getListaObra().get(2).setListaActuacion(a11);
        t1.getListaObra().get(2).setListaActuacion(a12);
        t1.getListaObra().get(2).setListaActuacion(a13);
        
        listaTeatro = new ArrayList();
        listaTeatro.add(t1);
        listaTeatro.add(t2);
        listaTeatro.add(t3);
        
        d1.setDni("88888888");
        mostrar();
    }
    
    public static void mostrar(){
        String obra = "Incendio";
        String datos ="";
        for(Teatro t: listaTeatro){
            if(t.isEstado()){
                datos += "\nEl teatro " + t.getNombre();
                for(Obra o: t.getListaObra()){
                    if(o.getNombre().equals(obra)){
                        datos += " con la obra " + o.getNombre() + ", tiene el siguiente horario:";
                        for(Actuacion a : o.getListaActuacion()){
                            if(a.isEstado()){
                                datos += "\n" + a.getHorario(); 
                            }
                        }
                    }
                }
            }
        }
        
        JOptionPane.showMessageDialog(null, datos);
    }

}
