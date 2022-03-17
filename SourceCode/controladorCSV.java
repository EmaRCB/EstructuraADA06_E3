import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class controladorCSV {

    String nombreArcLectura;
    String nombreArcEscritura;
    ArrayList<Movie> peliculas;

    boolean noVacio = false;
    boolean numColumnas = false;
    boolean procesoCompletado = false;

    public controladorCSV(String nombreArcLectura, String nombreArcEscritura, ArrayList<Movie> peliculas) {
        this.nombreArcLectura = nombreArcLectura;
        this.nombreArcEscritura = nombreArcEscritura;
        
        if (peliculas == null) {
            this.peliculas = new ArrayList<Movie>();
        } else {
            this.peliculas = peliculas;
        }
    }
    public void leerArchivoCSV() {
        FileReader fr;
        try {
            fr = new FileReader(this.nombreArcLectura);
            String linea = "";
            BufferedReader br = new BufferedReader(fr);
            int skip = 0;
            while ((linea = br.readLine()) != null) {
                noVacio = true;
                String[] datosLinea = linea.split(","); // lee una nueva celda cuando lee una coma

                if (datosLinea.length != 12) {
                    numColumnas = true;
                    JOptionPane.showMessageDialog(null, "El archivo no tiene el numero de columnas esperadas");

                    // break;
                } else {
                    numColumnas = true;

                }

                if (skip == 0) {
                    skip++;
                } else {
                    int movie_id = Integer.parseInt(datosLinea[0].trim());
                    String movie_title = datosLinea[1].trim();
                    int duration = Integer.parseInt(datosLinea[2].trim());
                    String color = datosLinea[3].trim();
                    String language = datosLinea[4].trim();
                    String country = datosLinea[5].trim();
                    String content_rating = datosLinea[6].trim();
                    int budget = Integer.parseInt(datosLinea[7].trim());
                    int title_year = Integer.parseInt(datosLinea[8].trim());
                    float imdb_score = Float.parseFloat(datosLinea[9].trim());
                    float aspect_ratio = Float.parseFloat(datosLinea[10].trim());
                    String movie_imdb_link = datosLinea[11].trim();

                    Movie a = new Movie(movie_id, movie_title, duration, color, language, country, content_rating,
                            budget,
                            title_year, imdb_score, aspect_ratio, movie_imdb_link);

                    this.peliculas.add(a);
                }
            }

            if (!noVacio && (linea = br.readLine()) == null) {
                JOptionPane.showMessageDialog(null, "El archivo seleccionado esta vacio");
            }

            br.close();
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null,
                    "El archivo de estudiantes no existe, por lo tanto no se podran capturar calificaciones", "ERROR",
                    JOptionPane.WARNING_MESSAGE);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null,
                    "El archivo no tiene las columnas esperadas, por lo tanto no se podran capturar calificaciones",
                    "ERROR",
                    JOptionPane.WARNING_MESSAGE);
        }
    }

    public void generarArchivoCSV() {
        // Scanner sc = new Scanner(System.in);
        FileWriter fw;
        try {
            fw = new FileWriter(this.nombreArcEscritura);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(
                    "movie_id,movie_title,duration,color,language,country,content_rating,budget,title_year,imdb_score,aspect_ratio,movie_imdb_link\n");
            String lineaTexto = "";
            for (Movie c : this.peliculas) {
                int text_movie_id = c.getMovie_id();
                String text_movie_title = c.getMovie_title();
                int text_duration = c.getDuration();
                String text_color = c.getColor();
                String text_language = c.getLanguage();
                String text_country = c.getCountry();
                String text_content_rating = c.getContent_rating();
                int text_budget = c.getBudget();
                int text_title_year = c.getTitle_year();
                float text_imdb_score = c.getImdb_score();
                float text_aspect_ratio = c.getAspect_ratio();
                String text_movie_imdb_link = c.getMovie_imdb_link();

                lineaTexto = text_movie_id + "," + text_movie_title + "," + text_duration + "," + text_color + "," +
                        text_language + "," + text_country + "," + text_content_rating + "," + text_budget + ","
                        + text_title_year
                        + "," + text_imdb_score + "," + text_aspect_ratio + "," + text_movie_imdb_link + "\n";
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
