import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        String Origen = "C:\\Users\\BlueW\\OneDrive - Universidad Autonoma de Yucatan\\Desktop\\Uni\\EstructuraDatos\\ADA06_E3\\EstructuraADA06_E3\\Lib";
        String NombreArcLectura = Origen + "\\Movie.csv";
        String nombreArcEscritura = Origen + "\\MoviesOrdenado";

        ArrayList<Movie> peliculas = new ArrayList<Movie>();

        controladorCSV c = new controladorCSV(NombreArcLectura, nombreArcEscritura, peliculas);
        Ordenamiento o = new Ordenamiento(peliculas, nombreArcEscritura);

        c.leerArchivoCSV(); // lee el archivo
        // o.mostrarPeliculas(); // imprime el listado de peliculas

        if (c.noVacio && c.numColumnas) {
            o.elegirTipoOrdenamiento();
            // o.mostrarPeliculas(); // imprime el listado de peliculas

            long endTime = System.currentTimeMillis();
            long timeElapsed = endTime - startTime;
            JOptionPane.showMessageDialog(null, "Fin del proceso\nTiempo de ejecución: " + timeElapsed);
        }
    }
}
