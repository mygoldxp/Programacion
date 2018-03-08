
package t6p2e2;

import Modelo.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;

public class T6p2e2 {
    // Todos los estudios que existen en el mundo
    private static Estudio[] listaEstudios = new Estudio[5];
    
     // Todos las películas que existen en el mundo
    private static ArrayList<Pelicula> listaPeliculas;

    public static void main(String[] args) {
      try{
          crearEstudios();
          crearPeliculas();
          //relacionarEstudiosConPeliculas();
          buscarPeliculaMasLarga();
          buscarEstudioConMasPeliculas();
      }
      catch(Exception e)
      {
          javax.swing.JOptionPane.showMessageDialog(null,e.getClass());
      }
    }
    
    public static void crearEstudios() throws Exception{
        // Crear objetos de tipo estudio sin películas
        
        // Necesitamos un objeto de tipo SimpleDateFormat para convertir un String en un objeto Date
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
        // Lista de telefonos
        ArrayList<String> telefonos = new ArrayList();
        telefonos.add("111111111");
        telefonos.add("111111112");
        listaEstudios[0] = new Estudio("Universal", "Los Angeles"," C/ a","www.universal.es",sdf.parse("1950-09-23"),"EEUU",telefonos);
        
        telefonos = new ArrayList();
        telefonos.add("222222222");
        telefonos.add("222222223");
        listaEstudios[1] = new Estudio("Walt Disney", "Los Angeles"," C/ b","www.disney.es",sdf.parse("1960-09-23"),"EEUU",telefonos);
        
        telefonos = new ArrayList();
        telefonos.add("333333333");
        telefonos.add("333333334");
        listaEstudios[2] = new Estudio("Warner Bros", "California"," C/ c","www.warner.es",sdf.parse("1956-01-10"),"EEUU",telefonos);
        /*listaEstudios[2] = new Estudio();
        listaEstudios[2].setNombre("Warner Bros");
        listaEstudios[2].setPais("EEUU");
        listaEstudios[2].setCiudad("California");
        listaEstudios[2].setDireccion(" C/ c");
        listaEstudios[2].setFechaFundacion(null);
        listaEstudios[2].setDirWeb("www.warner.es");
        listaEstudios[2].setTelefonos(telefonos);
        listaEstudios[2].setFechaFundacion(sdf.parse("1956-01-10"));*/
        
        telefonos = new ArrayList();
        telefonos.add("444444444");
        telefonos.add("444444445");
        listaEstudios[3] = new Estudio("Paramount", "Los Angeles"," C/ d","www.paramount.es",sdf.parse("1955-09-23"),"EEUU",telefonos);
        
        telefonos = new ArrayList();
        telefonos.add("555555555");
        telefonos.add("555555556");
        listaEstudios[4] = new Estudio("20Th Century Fox", "Los Angeles"," C/ e","www.fox.es",sdf.parse("1953-09-23"),"EEUU",telefonos);
    }
    
    public static void crearPeliculas() throws Exception{
        // Creo peliculas ya con los estudios
        
        listaPeliculas = new ArrayList();
        
        // char[4] para el año
        char[] año = new char[4];
        año[0] = '1';
        año[1] = '9';
        año[2] = '8';
        año[3] = '0';
        // Estudios de la película
        ArrayList <Estudio> lista = new ArrayList();
        lista.add(listaEstudios[0]);
        lista.add(listaEstudios[2]);
        Pelicula p = new Pelicula("ET",año,90.7f,"Infantil",lista);
        listaPeliculas.add(p);
        
        año = new char[4];
        año[0] = '1';
        año[1] = '9';
        año[2] = '9';
        año[3] = '7';
        // Estudios de la película
        lista = new ArrayList();
        lista.add(listaEstudios[1]);
        lista.add(listaEstudios[2]);
        listaPeliculas.add(new Pelicula("Titanic",año,180,"Romántica",lista));
        
        año = new char[4];
        año[0] = '2';
        año[1] = '0';
        año[2] = '0';
        año[3] = '3';
        // Estudios de la película
        lista = new ArrayList();
        lista.add(listaEstudios[4]);
        listaPeliculas.add(new Pelicula("El señor de los anillos",año,133,"Ciencia ficción",lista));
        
        año = new char[4];
        año[0] = '2';
        año[1] = '0';
        año[2] = '0';
        año[3] = '3';
        // Estudios de la película
        lista = new ArrayList();
        lista.add(listaEstudios[3]);
        lista.add(listaEstudios[4]);
        lista.add(listaEstudios[1]);
        lista.add(listaEstudios[2]);
        listaPeliculas.add(new Pelicula("Piratas del Caribe",año,220,"Aventuras",lista));
        
        año = new char[4];
        año[0] = '1';
        año[1] = '9';
        año[2] = '9';
        año[3] = '4';
        // Estudios de la película
        lista = new ArrayList();
        lista.add(listaEstudios[1]);
        listaPeliculas.add(new Pelicula("El rey león",año,97,"Infantil",lista));
        
        
    }
    
    public static void relacionarEstudiosConPeliculas() throws Exception{
        ArrayList<Pelicula> lista = new ArrayList();
        
        lista.add(listaPeliculas.get(0));
        listaEstudios[0].setListaPeliculas(lista);
        
        lista = new ArrayList();
        lista.add(listaPeliculas.get(1));
        lista.add(listaPeliculas.get(3));
        lista.add(listaPeliculas.get(4));
        listaEstudios[1].setListaPeliculas(lista);
        
        lista = new ArrayList();
        lista.add(listaPeliculas.get(0));
        lista.add(listaPeliculas.get(1));
        lista.add(listaPeliculas.get(3));
        listaEstudios[2].setListaPeliculas(lista);
        
        lista = new ArrayList();
        lista.add(listaPeliculas.get(3));
        listaEstudios[3].setListaPeliculas(lista);
        
        lista = new ArrayList();
        lista.add(listaPeliculas.get(2));
        lista.add(listaPeliculas.get(3));
        listaEstudios[4].setListaPeliculas(lista);
        
    }
    
    public static void buscarPeliculaMasLarga() throws Exception{
        float maximo = 0;
        Pelicula objeto=null;
        for(int x=0; x < listaPeliculas.size();x++)
        {
            if (listaPeliculas.get(x).getDuracion() > maximo)
            {
                maximo = listaPeliculas.get(x).getDuracion();
                objeto = listaPeliculas.get(x);
                // También me puedo quedar con la posición
            }
        }
        
        // Nombre de todos los estudios que han producido la película
        String mensaje = "";
        for (int x = 0; x < objeto.getListaEstudios().size();x++)
            mensaje += " " + objeto.getListaEstudios().get(x).getNombre();
        
        javax.swing.JOptionPane.showMessageDialog(null," La pelicula más larga es " + objeto.getTitulo()+ " y se ha producido en " + mensaje);
    }
    
    public static void buscarEstudioConMasPeliculas(){
        float maximo = 0;
        Estudio objeto=null;
        for(int x=0; x < listaEstudios.length;x++)
            if (listaEstudios[x].getListaPeliculas().size() > maximo)
            {
                maximo = listaEstudios[x].getListaPeliculas().size();
                objeto = listaEstudios[x];
            }
        String mensaje = " El estudio que más películas ha producido es " + objeto.getNombre() + " y ha producido " + objeto.getListaPeliculas().size() + " peliculas cuyos títulos son: ";
        for (int x = 0; x < objeto.getListaPeliculas().size();x++)
            mensaje += "\n" + objeto.getListaPeliculas().get(x).getTitulo();
        
        javax.swing.JOptionPane.showMessageDialog(null,mensaje);
}
}
