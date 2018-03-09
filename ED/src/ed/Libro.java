package ed;

import ed.Libros;
import javax.swing.JOptionPane;

public class Libro {
    
    public static void main(String[] args) {
        Libros Libro1 = new Libros(), Libro2= new Libros();
        Libro1.Datos(1111111111, "Marcianitos", "Jon", 200);
        Libro2.Datos(222222222, "LOE", "Juan", 400);
        
        Libro1.extraer();
        Libro2.extraer();
     
    }
}
