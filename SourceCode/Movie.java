public class Movie {

    public int movie_id;
    public String movie_title;
    public int duration;
    public String color;
    public String language;
    public String country;
    public String content_rating;
    public int budget;
    public int title_year;
    public float imdb_score;
    public float aspect_ratio;
    public String movie_imdb_link;

    public Movie(int movie_id, String movie_title, int duration, String color, String language, String country,
            String content_rating, int budget, int title_year, float imdb_score, float aspect_ratio,
            String movie_imdb_link) {
        this.movie_id = movie_id;
        this.movie_title = movie_title;
        this.duration = duration;
        this.color = color;
        this.language = language;
        this.country = country;
        this.content_rating = content_rating;
        this.budget = budget;
        this.title_year = title_year;
        this.imdb_score = imdb_score;
        this.aspect_ratio = aspect_ratio;
        this.movie_imdb_link = movie_imdb_link;
    }

    public Movie(int movie_id, String movie_title, int duration, String color, String language, String country) {
        this.movie_id = movie_id;
        this.movie_title = movie_title;
        this.duration = duration;
        this.color = color;
        this.language = language;
        this.country = country;
    }

    public Movie(int movie_id, String movie_title, String color, String language, String country, int budget) {
        this.movie_id = movie_id;
        this.movie_title = movie_title;
        this.color = color;
        this.language = language;
        this.country = country;
        this.budget = budget;
    }

    public Movie(int movie_id, String movie_title, float imdb_score, float aspect_ratio, String movie_imdb_link) {
        this.movie_id = movie_id;
        this.movie_title = movie_title;
        this.imdb_score = imdb_score;
        this.aspect_ratio = aspect_ratio;
        this.movie_imdb_link = movie_imdb_link;
    }

    /**
     * @return String
     */
    public int getMovie_id() {
        return movie_id;
    }

    /**
     * @param movie_id
     */
    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }

    /**
     * @return String
     */
    public String getMovie_title() {
        return movie_title;
    }

    /**
     * @param movie_title
     */
    public void setMovie_title(String movie_title) {
        this.movie_title = movie_title;
    }

    /**
     * @return String
     */
    public int getDuration() {
        return duration;
    }

    /**
     * @param duration
     */
    public void setDuration(int duration) {
        this.duration = duration;
    }

    /**
     * @return String
     */
    public String getColor() {
        return color;
    }

    /**
     * @param color
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * @return String
     */
    public String getLanguage() {
        return language;
    }

    /**
     * @param language
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * @return String
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * @return String
     */
    public String getContent_rating() {
        return content_rating;
    }

    /**
     * @param content_rating
     */
    public void setContent_rating(String content_rating) {
        this.content_rating = content_rating;
    }

    /**
     * @return String
     */
    public int getBudget() {
        return budget;
    }

    /**
     * @param budget
     */
    public void setBudget(int budget) {
        this.budget = budget;
    }

    /**
     * @return String
     */
    public int getTitle_year() {
        return title_year;
    }

    /**
     * @param title_year
     */
    public void setTitle_year(int title_year) {
        this.title_year = title_year;
    }

    /**
     * @return String
     */
    public float getImdb_score() {
        return imdb_score;
    }

    /**
     * @param imdb_score
     */
    public void setImdb_score(float imdb_score) {
        this.imdb_score = imdb_score;
    }

    /**
     * @return String
     */
    public float getAspect_ratio() {
        return aspect_ratio;
    }

    /**
     * @param aspect_ratio
     */
    public void setAspect_ratio(float aspect_ratio) {
        this.aspect_ratio = aspect_ratio;
    }

    /**
     * @return String
     */
    public String getMovie_imdb_link() {
        return movie_imdb_link;
    }

    /**
     * @param movie_imdb_link
     */
    public void setMovie_imdb_link(String movie_imdb_link) {
        this.movie_imdb_link = movie_imdb_link;
    }

    public int compareTo(Movie peliculas) {
        int res = 0;
        if (this.movie_id < peliculas.getMovie_id()) {
            res = -1;
        }
        if (this.movie_id > peliculas.getMovie_id()) {
            res = 1;
        }
        return res;
    }

    /**
     * @return String
     */
    @Override
    public String toString() {
        return "Movie [movie_id =" + movie_id + ", movie_title=" + movie_title + ", duration=" + duration + ", color="
                + color
                + ", language=" + language + ", country=" + country + ", content_rating="
                + content_rating + ", budget=" + budget + ", title_year=" + title_year + ", imdb_score=" + imdb_score
                + "aspect_ratio=" + aspect_ratio +
                ", movie_imdb_link=" + movie_imdb_link + "]";
    }

}