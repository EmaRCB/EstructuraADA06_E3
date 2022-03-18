

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JOptionPane;

public class RadixSort {
    private ArrayList<Movie> peliculas;
    private String nombreArcEscritura = "MovieRadix.csv";

    public RadixSort(ArrayList<Movie> peliculas) {
        if (peliculas == null) {
            this.peliculas = new ArrayList<Movie>();
        } else {
            this.peliculas = peliculas;
        }
    }

    static int getMax(int array[], int n) {
        int MAX = array[0];

        for (int i = 1; i < n; i++){
            if (array[i] > MAX){
                MAX = array[i];
            }
        }


        return MAX;
    }
    public static void Radix(ArrayList<Movie> peliculas2, int n) {
        int m = getMax(peliculas2, n);

        for (int exp = 1; m / exp > 0; exp *= 10)
            sort(peliculas2, n, exp);
    }

    static void sort(int arr[], int n, int exp) {
        int output[] = new int[n];
        int i;
        int count[] = new int[10];
        Arrays.fill(count, 0);

        for (i = 0; i < n; i++)
            count[(arr[i] / exp) % 10]++;

        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];

        for (i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        for (i = 0; i < n; i++)
            arr[i] = output[i];
    }

    public static void swap(ArrayList<Movie> peliculas, int i, int j) {
        Movie key = new Movie(0, "", 0, "", "", "");
        key.movie_id = peliculas.get(i).movie_id;
        key.movie_title = peliculas.get(i).movie_title;
        key.duration = peliculas.get(i).duration;
        key.color = peliculas.get(i).color;
        key.language = peliculas.get(i).language;
        key.country = peliculas.get(i).country;

        int temp = peliculas.get(i).duration;
        peliculas.get(i).duration = peliculas.get(j).duration;
        peliculas.get(j).duration = temp;

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

        peliculas.set(j, key);
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
