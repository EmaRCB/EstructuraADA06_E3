
import java.util.ArrayList;

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
            System.out.println(a.getMovie_id());
        }
    }

    public void elegirTipoOrdenamiento() {

        Insertion(peliculas);
    }

    public void Insertion(ArrayList<Movie> peliculas) {
        System.out.println("insertion sort");
        // Sort the list
        int n = 0;
        for (Movie a : this.peliculas) {
            n++;
        }
        int[] array = new int[n];

        for (Movie a : this.peliculas) {
            array[a.getMovie_id() - 1] = a.getDuration();
        }

        // arreglo antes de ser ordenado
        for (int i = 0; i < n; ++i)
            System.out.print(array[i] + " ");

        System.out.println();

        // metodo de ordenamiento
        for (int i = 1; i < n; ++i) {
            int key = array[i];
            int j = i - 1;

            /*
             * Move elements of arr[0..i-1], that are
             * greater than key, to one position ahead
             * of their current position
             */
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }

        // Arreglo despues de ser odenado
        for (int i = 0; i < n; ++i)
            System.out.print(array[i] + " ");

        System.out.println();
    }

}
