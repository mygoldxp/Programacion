
package ejemploparsers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;
import java.util.Scanner;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class PeliculasDOM {
    List misPeliculas;
    Document dom;

    public PeliculasDOM() {
   
        parsearDocumentoXML();
    }
    
    public static void main(String args[]) {

        //create an instance
        PeliculasDOM pelis = new PeliculasDOM();

        //run the example
        pelis.ejecutar();
    }
    
    public void ejecutar() {
        System.out.println("Empezando... ");
        String opcion = "0";
        Scanner sc = new Scanner(System.in);
        
        do {
        
            System.out.println("Qué acción deseas realizar:");
            System.out.println("1 - Leer fichero peliculas.xml");
            System.out.println("2 - Agregar una película al fichero");
            System.out.println("3 - Borrar una película del fichero");
            System.out.println("4 - Salir");
            
            opcion = sc.nextLine();
        
            switch (opcion){
                case "1":
                    //creamos la lista para almacenar los objetos película
                    misPeliculas = new ArrayList();
                    leerDocumento();
                    mostrarDocumento();
                    break;
                case "2":
                    agregarPelicula();
                    printToFile();
                    break;
                case "3":
                    borrarPelicula();
                    printToFile();
                    break;
                case "4":
                    System.out.println("Has escogido la opción salir, hasta luego!");
                    break;
                default:
                    System.out.println("Opción incorrecta, vuelve a intentarlo...");
                    break;            
            }

        }while (!opcion.equals("4"));
        printToFile();
        System.out.println("Fichero generado correctamente...");
    }

    //Cargamos el documento en memoria en forma de arbol DOM
    private void parsearDocumentoXML() {

        //get an instance of factory
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            //get an instance of builder
            DocumentBuilder db = dbf.newDocumentBuilder();

            //create an instance of DOM
            dom = db.parse("../peliculas.xml");

        } catch (ParserConfigurationException pce) {
            //dump it
            System.out.println("Error while trying to instantiate DocumentBuilder " + pce);
            System.exit(1);
        } catch (SAXException se) {
            se.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }
    
    //Leer la información del documento y mostrarla por pantalla
    private void leerDocumento() {
        //Obtenemos la referencia al elemento raiz
        Element docEle = dom.getDocumentElement();

        //Obtenemos un NodeList con todos los elementos pelicula
        NodeList nl = docEle.getElementsByTagName("pelicula");
        if (nl != null && nl.getLength() > 0) {
            for (int i = 0; i < nl.getLength(); i++) {

                //obtenemos el elemento película
                Element el = (Element) nl.item(i);

                //obtenemos el objeto película
                Pelicula p = getPelicula(el);

                //añadimos la película a la lista
                misPeliculas.add(p);
            }
        }
    }

    private Pelicula getPelicula(Element pelEl) {

	//Por cada elemento <pelicula> cogemos los valores de texto o enteros
        //de sus hijos y atributos (categoria, titulo, director, anyo, duracion y medida)
        //Obtenemos el atributo categoría directamente del elemento
        String categoria = pelEl.getAttribute("categoria");
        
        //Obtenemos los textos del título y director
        String titulo = getTextValue(pelEl, "titulo");
        String director = getTextValue(pelEl, "director");
        
        //Obtenemos los valores enteros del anyo y duración
        int anyo = getIntValue(pelEl, "anyo");
        int duracion = getIntValue(pelEl, "duracion");

        //Obtenemos el atributo medida del elemento duración
        String medida = getAtributo(pelEl, "duracion", "medida");

        //Creamos un objeto Película con la información obtenida
        Pelicula p = new Pelicula(categoria, titulo, director, anyo, duracion, medida);

        return p;
    }

    private String getTextValue(Element ele, String tagName) {
        String textVal = null;
        NodeList nl = ele.getElementsByTagName(tagName);
        if (nl != null && nl.getLength() > 0) {
            Element el = (Element) nl.item(0);
            textVal = el.getFirstChild().getNodeValue();
        }

        return textVal;
    }

    private int getIntValue(Element ele, String tagName) {

        return Integer.parseInt(getTextValue(ele, tagName));
        
    }
    
    private String getAtributo(Element empEl, String etiqueta, String att) {
        String atributo = "";
        NodeList nl = empEl.getElementsByTagName(etiqueta);
        if (nl != null && nl.getLength() > 0) {
            Element el = (Element) nl.item(0);
            atributo = el.getAttribute(att);
        }

        return atributo;
    }

    private void mostrarDocumento() {

        System.out.println("Películas contenidas en el fichero'" + misPeliculas.size() + "'.");

        Iterator it = misPeliculas.iterator();
        while (it.hasNext()) {
            System.out.println(it.next().toString());
        }
    }

    //Agregar nuevas películas al documento
    private void agregarPelicula() {

        //Variables locales
        String respuesta = "S";
        String categoria;
        String titulo;
        String director;
        int anyo;
        int duracion;
        String medida;
        
        //Obtenemos el elemento raiz <peliculas>
        Element raizPeliculasEle = dom.getDocumentElement();
        
        do{
            Scanner sc = new Scanner(System.in);
            System.out.println("Introduce la categoría de la película:");
            categoria = sc.nextLine();
            System.out.println("Introduce el título de la película:");
            titulo = sc.nextLine();
            System.out.println("Introduce el director de la película:");
            director = sc.nextLine();
            System.out.println("Introduce el año de la película:");
            anyo = Integer.parseInt(sc.nextLine());
            System.out.println("Introduce la duración de la película:");
            duracion = Integer.parseInt(sc.nextLine());
            System.out.println("Introduce la unidad de medida de la duración de la película:");
            medida = sc.nextLine();
            
            Pelicula p = new Pelicula(categoria, titulo, director, anyo, duracion, medida);
            Element peliculaEle = crearElementoPelicula(p);
            raizPeliculasEle.appendChild(peliculaEle);
            
            System.out.println("Desea insertar información de otra película? (S/N)");
            respuesta = sc.nextLine();
        }
        while (respuesta == "S");
    }


    private Element crearElementoPelicula(Pelicula p) {

        //creamos el elemento padre contacto
        Element peliculaEle = dom.createElement("pelicula");
        peliculaEle.setAttribute("categoria", p.getCategoria());
        
        //creamos el elemento titulo y el texto del titulo y lo agregamos al elemento pelicula
        Element titEle = dom.createElement("titulo");
        Text titText = dom.createTextNode(p.getTitulo());
        titEle.appendChild(titText);
        peliculaEle.appendChild(titEle);

        //creamos el elemento director y el texto del director y lo agregamos al elemento pelicula
        Element dirEle = dom.createElement("director");
        Text dirText = dom.createTextNode(p.getDirector());
        dirEle.appendChild(dirText);
        peliculaEle.appendChild(dirEle);
        
        //creamos el elemento anyo y el texto del anyo y lo agregamos al elemento pelicula
        Element anyoEle = dom.createElement("anyo");
        Text anyoText = dom.createTextNode(String.valueOf(p.getAnyo()));
        anyoEle.appendChild(anyoText);
        peliculaEle.appendChild(anyoEle);
        
        //creamos el elemento duracion, su atributo y el texto de la duracion y lo agregamos al elemento pelicula
        Element durEle = dom.createElement("duracion");
        durEle.setAttribute("medida", p.getMedida());
        Text durText = dom.createTextNode(String.valueOf(p.getDuracion()));
        durEle.appendChild(durText);
        peliculaEle.appendChild(durEle);
        
        return peliculaEle;

    }

    //Borramos la película del arbol DOM
    private void borrarPelicula(){
    
        String respuesta = "S";
        
        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("Introduce el título de la película que quieres eliminar:");
            String titulo = sc.nextLine();
            
        //Obtenemos la referencia al elemento raiz
        Element docEle = dom.getDocumentElement();

        //Obtenemos un NodeList con todos los elementos pelicula
        NodeList nl = docEle.getElementsByTagName("pelicula");
        if (nl != null && nl.getLength() > 0) {
            for (int i = 0; i < nl.getLength(); i++) {

                //obtenemos el elemento película
                Element peli = (Element) nl.item(i);
                //si coicide el título borramos el elemento del arbol DOM
                if (titulo.equalsIgnoreCase(getTextValue(peli, "titulo")))
                { 
                    docEle.removeChild(peli);
                }
            }
        }
            
            System.out.println("Deseas seguir eliminando películas? (S/N)");
            respuesta = sc.nextLine().toUpperCase();
        }while(!respuesta.equals("N"));
    }
    
    //Escribir la información del arbol DOM en memoria a un documento xml
    private void printToFile() {

        try {
            OutputFormat format = new OutputFormat(dom);
            format.setIndenting(true);

            XMLSerializer serializer = new XMLSerializer(
                    new FileOutputStream(new File("../peliculas.xml")), format);

            serializer.serialize(dom);

        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }

}
