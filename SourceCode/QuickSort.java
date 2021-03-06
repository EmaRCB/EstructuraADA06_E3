import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JOptionPane;

public class QuickSort {
    private ArrayList<Movie> peliculas;
    private String nombreArcEscritura;
    public static int numComp = 0;
    public static int numInt = 0;

    public QuickSort(ArrayList<Movie> peliculas, String nombreArcEscritura) {
        this.nombreArcEscritura = nombreArcEscritura;
        if (peliculas == null) {
            this.peliculas = new ArrayList<Movie>();
        } else {
            this.peliculas = peliculas;
        }
    }

    public void Quick(ArrayList<Movie> peliculas) {
        System.out.println("---- quick sort ----");

        sort(peliculas, 0, (peliculas.size() - 1));

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

    public static void swap(ArrayList<Movie> peliculas, int i, int j) {
        Movie key = new Movie(0, "", "", "", "", 0);
        key.movie_id = peliculas.get(i).movie_id;
        key.movie_title = peliculas.get(i).movie_title;
        key.color = peliculas.get(i).color;
        key.language = peliculas.get(i).language;
        key.country = peliculas.get(i).country;
        key.budget = peliculas.get(i).budget;

        int temp = peliculas.get(i).budget;
        peliculas.get(i).budget = peliculas.get(j).budget;
        peliculas.get(j).budget = temp;

        String temp2 = peliculas.get(i).color;
        peliculas.get(i).color = peliculas.get(j).color;
        peliculas.get(j).color = temp2;

        String temp3 = peliculas.get(i).country;
        peliculas.get(i).country = peliculas.get(j).country;
        peliculas.get(j).country = temp3;

        String temp4 = peliculas.get(i).language;
        peliculas.get(i).language = peliculas.get(j).language;
        peliculas.get(j).language = temp4;

        int temp5 = peliculas.get(i).movie_id;
        peliculas.get(i).movie_id = peliculas.get(j).movie_id;
        peliculas.get(j).movie_id = temp5;

        String temp6 = peliculas.get(i).movie_title;
        peliculas.get(i).movie_title = peliculas.get(j).movie_title;
        peliculas.get(j).movie_title = temp6;

        // numInt++; // aumenta uno al numero de comparaciones
        peliculas.set(j, key);
    }

    public static int partition(ArrayList<Movie> peliculas, int low, int high) {

        Movie key = new Movie(0, "", 0, "", "", "");
        key.movie_id = peliculas.get(high).movie_id;
        key.movie_title = peliculas.get(high).movie_title;
        key.budget = peliculas.get(high).budget;
        key.color = peliculas.get(high).color;
        key.language = peliculas.get(high).language;
        key.country = peliculas.get(high).country;

        // pivot
        int pivot = peliculas.get(high).budget;

        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {

            // Si el elemento actual es menor que el pivote
            if (peliculas.get(j).budget < pivot) {

                i++;
                swap(peliculas, i, j);
                numInt++;
            }
            numComp++;
        }
        if (pivot > 0) {
            numComp++; // aumenta uno al numero de comparaciones
        }
        swap(peliculas, i + 1, high);
        return (i + 1);
    }

    public static void sort(ArrayList<Movie> peliculas, int low, int high) {
        if (low < high) {

            // pi is partitioning index, arr[p]
            // is now at right place
            int pi = partition(peliculas, low, high);

            // Separately sort elements before
            // partition and after partition
            sort(peliculas, low, pi - 1);
            sort(peliculas, pi + 1, high);
        }
    }

    public void generarArchivoCSV() {
        // Scanner sc = new Scanner(System.in);
        FileWriter fw;
        try {
            fw = new FileWriter(this.nombreArcEscritura + "QuickSort.csv");
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(
                    "movie_id,movie_title,color,language,country,budget\n");
            String lineaTexto = "";
            for (Movie c : this.peliculas) {
                int text_movie_id = c.getMovie_id();
                String text_movie_title = c.getMovie_title();
                // int text_duration = c.getDuration();
                String text_color = c.getColor();
                String text_language = c.getLanguage();
                String text_country = c.getCountry();
                // String text_content_rating = c.getContent_rating();
                int text_budget = c.getBudget();
                // int text_title_year = c.getTitle_year();
                // float text_imdb_score = c.getImdb_score();
                // float text_aspect_ratio = c.getAspect_ratio();
                // String text_movie_imdb_link = c.getMovie_imdb_link();

                lineaTexto = text_movie_id + "," + text_movie_title + "," + text_color + "," +
                        text_language + "," + text_country + "," + text_budget + "," + "\n";
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