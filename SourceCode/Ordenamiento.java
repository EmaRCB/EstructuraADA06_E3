
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
        // q.Quick(peliculas);
        int seleccion = JOptionPane.showOptionDialog(
                null,
                "Seleccione opcion",
                "Selector de opciones",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null, // null para icono por defecto.
                new Object[] { "InsertionSort", "QuickSort", "RadixSort " }, // null para YESS, NO y CANCEL
                null);
        seleccion += 1;
        System.out.println(seleccion);

        if (seleccion == 1) {
            InsertionSort i = new InsertionSort(peliculas);
            i.Insertion(peliculas);
        } else {
            if (seleccion == 2) {

                QuickSort q = new QuickSort(peliculas);
                q.Quick(peliculas);
            } else {

                RadixSort m = new RadixSort(peliculas);
                m.Radix(peliculas);

            }
        }

        /*
         * int reply = JOptionPane.showConfirmDialog(null,
         * "¿Desea ordenar mediante el metodo de InsertionSort?",
         * "Creacion del archivo CSV", JOptionPane.YES_NO_OPTION);
         * if (reply == JOptionPane.YES_OPTION) {
         * q.Quick(peliculas);
         * // i.Insertion(peliculas);
         * }
         * 
         */
    }

}
