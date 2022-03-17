
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Ordenamiento {
    private String NombreArcLectura;
    private String NombreArcEscritura;
    private ArrayList<Movie> peliculas;

    boolean noVacio = false;
    boolean numColumnas = false;
    boolean procesoCompletado = false;

    public Ordenamiento(ArrayList<Movie> peliculas) {

        if (peliculas == null) {
            this.peliculas = new ArrayList<Movie>();
        } else {
            this.peliculas = peliculas;
        }
    }

    public void mostrarPeliculas() {
        // Se imprime el listado de alumnos
        for (Movie a : this.peliculas) {
            System.out.println(a.toString());
        }
    }

    public void elegirTipoOrdenamiento() {
        InsertionSort o = new InsertionSort(peliculas);

        int reply = JOptionPane.showConfirmDialog(null, "¿Desea ordenar mediante el metodo de InsertionSort?",
                "Creacion del archivo CSV", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            o.Insertion(peliculas);
        }
    }

}
