import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class InsertionSort {
    private ArrayList<Movie> peliculas;
    public int duration;
    public String color;
    public String language;
    private String nombreArcEscritura = "MovieInsertion.csv";

    public InsertionSort(ArrayList<Movie> peliculas) {
        if (peliculas == null) {
            this.peliculas = new ArrayList<Movie>();
        } else {
            this.peliculas = peliculas;
        }
    }

    public void Insertion(ArrayList<Movie> peliculas) {
        System.out.println("---- insertion sort ----"); // borrar despues

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
            }
            peliculas.set(j, key);
        }

        generarArchivoCSV();
    }

    public void generarArchivoCSV() {
        // Scanner sc = new Scanner(System.in);
        FileWriter fw;
        try {
            fw = new FileWriter(this.nombreArcEscritura);
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
