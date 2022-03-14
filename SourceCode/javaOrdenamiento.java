import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class javaOrdenamiento {
    private String ArchivoCSVEntrada;
    private String ArchivoCSVSalida;
    private ArrayList<Movie> peliculas;

    boolean noVacio = false;
    boolean numColumnas = false;
    boolean procesoCompletado = false;

    public javaOrdenamiento(String archivoCSVEntrada, String archivoCSVSalida, ArrayList<Movie> peliculas) {
        this.ArchivoCSVEntrada = archivoCSVEntrada;
        this.ArchivoCSVSalida = archivoCSVSalida;

        if (peliculas == null) {
            this.peliculas = new ArrayList<Movie>();
        } else {
            this.peliculas = peliculas;
        }
    }

    public void leerArchivoCSV() {
        FileReader fr;
        try {
            fr = new FileReader(this.ArchivoCSVEntrada);
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
                    String movie_id = datosLinea[0].trim();
                    String movie_title = datosLinea[1].trim();
                    String duration = datosLinea[2].trim();
                    String color = datosLinea[3].trim();
                    String language = datosLinea[4].trim();
                    String country = datosLinea[5].trim();
                    String content_rating = datosLinea[6].trim();
                    String budget = datosLinea[7].trim();
                    String title_year = datosLinea[8].trim();
                    String imdb_score = datosLinea[9].trim();
                    String aspect_ratio = datosLinea[10].trim();
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

    public void mostrarPeliculas() {
        // Se imprime el listado de alumnos
        for (Movie a : this.peliculas) {
            System.out.println(a.toString());
        }
    }

    public void generarArchivoCSV() {
        // Scanner sc = new Scanner(System.in);
        FileWriter fw;
        try {
            fw = new FileWriter(this.ArchivoCSVSalida);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(
                    "movie_id,movie_title,duration,color,language,country,content_rating,budget,title_year,imdb_score,aspect_ratio,movie_imdb_link\n");
            String lineaTexto = "";
            for (Movie c : this.peliculas) {
                String text_movie_id = c.getMovie_id();
                String text_movie_title = c.getMovie_title();
                String text_duration = c.getDuration();
                String text_color = c.getColor();
                String text_language = c.getLanguage();
                String text_country = c.getCountry();
                String text_content_rating = c.getContent_rating();
                String text_budget = c.getBudget();
                String text_title_year = c.getTitle_year();
                String text_imdb_score = c.getImdb_score();
                String text_aspect_ratio = c.getAspect_ratio();
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
