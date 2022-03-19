
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import javax.swing.JOptionPane;

public class RadixSort {
    private ArrayList<Movie> peliculas;
    private String nombreArcEscritura;
    public static int numComp = 0;
    public static int numInt = 0;

    public RadixSort(ArrayList<Movie> peliculas, String nombreArcEscritura) {
        this.nombreArcEscritura = nombreArcEscritura;
        if (peliculas == null) {
            this.peliculas = new ArrayList<Movie>();
        } else {
            this.peliculas = peliculas;
        }
    }

    public void Radix(ArrayList<Movie> peliculas) {
        System.out.println("---- radix sort ----");
        int n = peliculas.size();
        sort(peliculas, n);

        int decision = JOptionPane.showOptionDialog(
                null,
                "Seleccione opcion",
                "Selector de opciones",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null, // null para icono por defecto.
                new Object[] { "Ascendente", "Descendente" },
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

    public static void sort(ArrayList<Movie> peliculas, int n) {

        int i = 1;
        Movie key = new Movie(0, "", 0, "", "", "");
        key.movie_id = peliculas.get(i).movie_id;
        key.movie_title = peliculas.get(i).movie_title;
        key.duration = peliculas.get(i).duration;
        key.color = peliculas.get(i).color;
        key.language = peliculas.get(i).language;
        key.country = peliculas.get(i).country;

        // Encuentra el num. maximo
        int m = getMax(peliculas, n);

        for (int exp = 1; m / exp > 0; exp *= 10) {
            countSort(peliculas, n, exp);

        }

    }

    public static int getMax(ArrayList<Movie> peliculas, int n) {
        int i = 1;
        Movie key = new Movie(0, "", 0, "", "", "");
        key.movie_id = peliculas.get(i).movie_id;
        key.movie_title = peliculas.get(i).movie_title;
        key.duration = peliculas.get(i).duration;
        key.color = peliculas.get(i).color;
        key.language = peliculas.get(i).language;
        key.country = peliculas.get(i).country;
        int mx = peliculas.get(0).duration;

        for (i = 1; i < n; i++)
            if ((peliculas.get(i).duration) > mx)
                mx = peliculas.get(i).duration;
        return mx;
    }

    public static void countSort(ArrayList<Movie> peliculas, int n, int exp) {
        int output[] = new int[n]; // output array
        int i = 1;
        int count[] = new int[peliculas.size()];
        Arrays.fill(count, 0);

        Movie key = new Movie(0, "", 0, "", "", "");
        key.movie_id = peliculas.get(i).movie_id;
        key.movie_title = peliculas.get(i).movie_title;
        key.duration = peliculas.get(i).duration;
        key.color = peliculas.get(i).color;
        key.language = peliculas.get(i).language;
        key.country = peliculas.get(i).country;

        for (i = 0; i < n; i++)
            count[(peliculas.get(i).duration / exp) % 10]++;

        for (i = 1; i < 10; i++) {
            count[i] += count[i - 1];
            numInt++;
        }

        for (i = n - 1; i >= 0; i--) {
            output[count[(peliculas.get(i).duration / exp) % 10] - 1] = peliculas.get(i).duration;
            numComp++;
            count[(peliculas.get(i).duration / exp) % 10]--;
        }

        for (i = 0; i < n; i++)
            peliculas.get(i).duration = output[i];
    }

    public void generarArchivoCSV() {
        // Scanner sc = new Scanner(System.in);
        FileWriter fw;
        try {
            fw = new FileWriter(this.nombreArcEscritura + "RadixSort.csv");
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
                // String text_content_rating = c.getContent_rating();
                // int text_budget = c.getBudget();
                // int text_title_year = c.getTitle_year();
                // float text_imdb_score = c.getImdb_score();
                // float text_aspect_ratio = c.getAspect_ratio();
                // String text_movie_imdb_link = c.getMovie_imdb_link();

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
