
package ed;

import javax.swing.JOptionPane;

public class Libros {
    private int ISBN;
    private String Titulo;
    private String Autor;
    private int N_pag;
    
    public void Datos(int dISBN, String dTitulo, String dAutor, int dN_pag){
        ISBN=dISBN;
        Titulo=dTitulo;
        Autor=dAutor;
        N_pag=dN_pag;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }

    public String getAutor() {
        return Autor;
    }

    public void setAutor(String Autor) {
        this.Autor = Autor;
    }

    public int getN_pag() {
        return N_pag;
    }

    public void setN_pag(int N_pag) {
        this.N_pag = N_pag;
    }
    
    public void extraer(){
        JOptionPane.showMessageDialog(null, "El ISBN es: " + ISBN + "\nTítulo: " + Titulo + "\nAutor: " + Autor + "\nNúmero de Páginas: " + N_pag);
    }
}
