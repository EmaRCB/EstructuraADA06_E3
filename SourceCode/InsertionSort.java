import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JOptionPane;

public class InsertionSort {
    private ArrayList<Movie> peliculas;
    private String nombreArcEscritura;
    public int numComp = 0;
    public int numInt = 0;

    public InsertionSort(ArrayList<Movie> peliculas, String nombreArcEscritura) {
        this.nombreArcEscritura = nombreArcEscritura;
        if (peliculas == null) {
            this.peliculas = new ArrayList<Movie>();
        } else {
            this.peliculas = peliculas;
        }
    }

    public void Insertion(ArrayList<Movie> peliculas) {
        System.out.println("---- insertion sort ----"); // boorrar despues

        // metodo de ordenamiento InsertionSort
        int i, j;

        for (i = 1; i < peliculas.size(); i++) {

            Movie key = new Movie(0, "", 0, "", "", "");
            key.movie_id = peliculas.get(i).movie_id;
            key.movie_title = peliculas.get(i).movie_title;
            key.duration = peliculas.get(i).duration;
            key.color = peliculas.get(i).color;
            key.language = peliculas.get(i).language;
            key.country = peliculas.get(i).country;
            j = i;
            while ((j > 0) && (peliculas.get(j - 1).duration > key.duration)) {
                peliculas.set(j, peliculas.get(j - 1));
                j--;
                numComp++; // aumenta uno al numero de comparaciones
                numInt++; // aumento uno al numero de intercambios
            }
            if (j > 0) {
                numComp++; // aumenta uno al numero de comparaciones
            }
            peliculas.set(j, key);
        }

        // El usuario decide si ordena en manera ascendente o descendente
        int decision = JOptionPane.showOptionDialog(
                null,
                "Seleccione opcion",
                "Selector de opciones",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null, // null para icono por defecto.
                new Object[] { "Ascendente", "Descendente" }, // null para YESS, NO y CANCEL
                null);

        if (decision == 1) {
            Collections.reverse(peliculas);
            generarArchivoCSV();
        } else {
            generarArchivoCSV();
        }

        // Imprime el numero de comparaciones e intercambios
        JOptionPane.showMessageDialog(null,
                "Numero de comparaciones: " + numComp + "\nNumero de intercambios: " + numInt);
    }

    public void generarArchivoCSV() {
        FileWriter fw;
        try {
            fw = new FileWriter(this.nombreArcEscritura + "InsertionSort.csv");
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(
                    "movie_id,movie_title,duration,color,language,country\n");
            String lineaTexto = "";
            for (Movie c : this.peliculas) {
                int text_movie_id = c.getMovie_id();
                String text_movie_title = c.getMovie_title();
                int text_duration = c.getDuration();
                String text_color = c.getColor();
                String text_language = c.getLanguage();
                String text_country = c.getCountry();

                lineaTexto = text_movie_id + "," + text_movie_title + "," + text_duration + "," + text_color + "," +
                        text_language + "," + text_country + "," + "\n";
                bw.write(lineaTexto);
            }
            bw.flush();
            bw.close();
            fw.close();
            JOptionPane.showMessageDialog(null, "Archivo creado exitosamente");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
