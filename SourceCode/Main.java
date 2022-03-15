import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        String Origen = "C:\\Users\\BlueW\\OneDrive - Universidad Autonoma de Yucatan\\Desktop\\Uni\\EstructuraDatos\\ADA06_E3\\EstructuraADA06_E3\\";
        String ArchivoCSVEntrada = Origen + "Movie.csv";
        String ArchivoCSVSalida = Origen + "MovieFinal.csv";

        ArrayList<Movie> peliculas = new ArrayList<Movie>();

        javaOrdenamiento c = new javaOrdenamiento(ArchivoCSVEntrada, ArchivoCSVSalida, peliculas);

        c.leerArchivoCSV(); // lee el archivo ListaAlumnos.csv
        // c.mostrarPeliculas(); // imprime el listado de Alumnos

        if (c.noVacio && c.numColumnas) {
            c.elegirTipoOrdenamiento();
            int reply = JOptionPane.showConfirmDialog(null, "¿Desea crear el archivo CSV?",
                    "Creacion del archivo CSV", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION) {
                c.generarArchivoCSV();
            } else {
                JOptionPane.showMessageDialog(null,
                        "No se pudo realizar el registro de calificaciones",
                        "ERROR", JOptionPane.WARNING_MESSAGE);
            }

            JOptionPane.showMessageDialog(null, "Fin del proceso");
        }
    }
}
