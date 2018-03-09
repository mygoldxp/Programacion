
package t6p2e1;

import Modelo.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;

public class T6p2e1 {
    // Todos los estudios que existen en el mundo
    private static Estudio[] listaEstudios = new Estudio[5];
    
     // Todos las películas que existen en el mundo
    private static ArrayList<Pelicula> listaPeliculas;

    public static void main(String[] args) {
      try{
          crearEstudios();
          crearPeliculas();
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
        //listaEstudios[2] = new Estudio("Warner Bros", "California"," C/ c","www.warner.es",sdf.parse("1956-01-10"),"EEUU",telefonos);
        listaEstudios[2] = new Estudio();
        listaEstudios[2].setNombre("Warner Bros");
        listaEstudios[2].setPais("EEUU");
        listaEstudios[2].setCiudad("California");
        listaEstudios[2].setDireccion(" C/ c");
        listaEstudios[2].setFechaFundacion(null);
        listaEstudios[2].setDirWeb("www.warner.es");
        listaEstudios[2].setTelefonos(telefonos);
        listaEstudios[2].setFechaFundacion(sdf.parse("1956-01-10"));
        
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
    
    public static void buscarEstudioConMasPeliculas() throws Exception{
        // En estudio No tengo las películas
        // contador de peliculas de cada estudio
        // arrays coincidentes
        int numeroPeliculas[] = new int[5];
        Arrays.fill(numeroPeliculas, 0);
        
        // Por cada Estudio recorro la lista de películas para ver si está o no.
        for(int z = 0;z < listaEstudios.length; z++)
            for(int x=0; x < listaPeliculas.size();x++)
            {
                boolean salir = false;
                for(int y=0; y < listaPeliculas.get(x).getListaEstudios().size() && salir == false; y++)
                {
                    if (listaPeliculas.get(x).getListaEstudios().get(y)== listaEstudios[z])
                    {
                        numeroPeliculas[z]+= 1;
                        salir = true;                    }
                }
            }
        
        // Busco el máximo contador
        int maximo = 0;
        int posicion = 0;
        for (int x = 0; x < numeroPeliculas.length; x++)
            if(numeroPeliculas[x] > maximo)
            {
                maximo = numeroPeliculas[x];
                posicion = x;
            }
        
        javax.swing.JOptionPane.showMessageDialog(null,"El estudio que más películas ha producido es: " + listaEstudios[posicion].getNombre() + " y ha producido "+ maximo);
    }
}
