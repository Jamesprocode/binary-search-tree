public class Movie {
    // instance variable
    public Movie left;
    public Movie right;
    public Double rating;
    public String title;
    public int year;

    // constructor
    public Movie(String title, int year, double rating) {
        this.title = title;
        this.year = year;
        this.rating = rating;
    }

    // methods
    public int compareTo(Movie m) {
        return this.title.compareToIgnoreCase(m.title);
    }

    public String toString() {
        return this.title + "(" + this.rating + ")";
    }

}
