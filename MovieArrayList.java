/**
 * Do not modify.
 * 
 * @author Celia Chen
 */
public class MovieArrayList {

	private Movie[] movies;
	private int size;

	public MovieArrayList() {
		this.movies = new Movie[7];
		this.size = 0;
	}

	/**
	 * size() method returns the size of the current MovieArrayList.
	 */
	public int size() {
		return this.size;
	}

	/**
	 * add(movie) method takes a Movie movie as parameter,
	 * adds the movie to list. Returns true if the movie is
	 * added successfully.
	 */
	public boolean add(Movie movie) {
		boolean hasAdded = false;
		for (int i = 0; i < this.movies.length; i++) {
			if (this.movies[i] == null) {
				this.movies[i] = movie;
				hasAdded = (this.movies[i] != null);
				size++;
				return hasAdded;
			}
		}

		Movie[] newMovies = new Movie[this.movies.length * 2];
		for (int i = 0; i < this.movies.length; i++) {
			newMovies[i] = this.movies[i];
		}

		newMovies[this.movies.length] = movie;
		hasAdded = (newMovies[this.movies.length] != null);
		this.movies = newMovies;
		size++;
		return hasAdded;
	}

	/**
	 * getRatingByTitle(title) method takes a String title as parameter,
	 * returns the rating associated to the first occurrence of the Movie with the
	 * same title.
	 * Returns -1 if there is no movie of given title.
	 */
	public double getRatingByTitle(String title) {
		for (int i = 0; i < this.movies.length; i++) {

			if (this.movies[i] != null && this.movies[i].title.equals(title)) {
				return this.movies[i].rating;
			}
		}
		return -1;
	}
}
