import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        String Origen = "C:\\Users\\BlueW\\OneDrive - Universidad Autonoma de Yucatan\\Desktop\\Uni\\EstructuraDatos\\ADA06_E3\\EstructuraADA06_E3\\";
        String NombreArcLectura = Origen + "Movie.csv";
        String nombreArcEscritura = Origen + "MovieFinal.csv";

        ArrayList<Movie> peliculas = new ArrayList<Movie>();
        System.out.println("hola");
        controladorCSV c = new controladorCSV(NombreArcLectura, nombreArcEscritura, peliculas);
        Ordenamiento o = new Ordenamiento(peliculas);

        c.leerArchivoCSV(); // lee el archivo
        // o.mostrarPeliculas(); // imprime el listado de peliculas

        if (c.noVacio && c.numColumnas) {
            o.elegirTipoOrdenamiento();
            // o.mostrarPeliculas(); // imprime el listado de peliculas

            JOptionPane.showMessageDialog(null, "Fin del proceso");
        }
    }
}
