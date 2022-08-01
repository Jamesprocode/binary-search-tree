import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * You may use the helper methods provided.
 * Feel free to add any additional helper methods if needed.
 * 
 * @author Celia Chen
 *
 */

public class Homework3 {

	/**
	 * This method takes a MovieArrayList and a movie title,
	 * calls getRatingByTitle(movieTitle) method,
	 * returns the elasped time it took in nanoseconds.
	 */
	// list
	private static long getElapsedTime(MovieArrayList list, String movieTitle) {
		long startTime = System.nanoTime();
		System.out.println("get rating: " + list.getRatingByTitle(movieTitle));
		long endTime = System.nanoTime();
		long timeElapsed = endTime - startTime;
		return timeElapsed;
	}

	/**
	 * This method takes a MovieBST and a movie title,
	 * calls getRatingByTitle(movieTitle) method,
	 * returns the elasped time it took in nanoseconds.
	 */
	// tree
	private static long getElapsedTime(MovieBST tree, String movieTitle) {
		long startTime = System.nanoTime();
		System.out.println("get rating: " + tree.getRatingByTitle(movieTitle));
		long endTime = System.nanoTime();
		long timeElapsed = endTime - startTime;
		return timeElapsed;
	}

	/**
	 * This method takes a JSONObject movie,
	 * parse and extract the title, the year and the rating from the JSONObject,
	 * constructs and returns a Movie object containing the information.
	 */

	private static Movie parseMovieObject(JSONObject movie) {

		// Get movie title
		String title = (String) movie.get("title");
		// Get movie year
		String year = (String) movie.get("year");
		// Get movie rating
		String rating = (String) movie.get("rating");

		Movie m = new Movie(title, Integer.parseInt(year), Double.parseDouble(rating));
		return m;
	}

	public static void main(String[] args) {
		// BST
		MovieBST moviesBST = new MovieBST();
		// Arr
		MovieArrayList moviesArr = new MovieArrayList();

		JSONParser parser = new JSONParser();
		try {
			Object obj = parser.parse(new FileReader("movies1.json"));
			// JSONObject jsonObject = new JSONObject(obj);
			JSONArray movielist = (JSONArray) obj;
			for (int i = 0; i < movielist.size(); i++) {
				JSONObject movie = (JSONObject) movielist.get(i);
				Movie m = parseMovieObject(movie);
				moviesArr.add(m);
				moviesBST.add(m);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}

		// System.out.println("length: " + movielist.size());
		// System.out.println("height: " + moviesBST.getHeight());

		// test time
		// System.out.println("Movie Array Search Time: " + getElapsedTime(moviesArr,
		// "Toy Story"));
		// System.out.println("MovieBST Search Time: " + getElapsedTime(moviesBST, "Toy
		// Story"));
		long[] arr = new long[3];
		long[] bst = new long[3];

		for (int i = 0; i < 3; i++) {
			// System.out.println("Movie Array Search Time: " + getElapsedTime(moviesArr,
			// "Toy Story"));
			arr[i] = getElapsedTime(moviesArr, "Toy Story");
			// System.out.println("MovieBST Search Time: " +
			// getElapsedTime(moviesBST,"ToyStory"));
			bst[i] = getElapsedTime(moviesBST, "Toy Story");
		}
		double aveArr = (double) (Arrays.stream(arr).sum() / arr.length);
		double aveBST = (double) (Arrays.stream(bst).sum() / bst.length);

		System.out.println(aveArr / 1000000000);
		System.out.println(aveBST / 1000000000);

	}
}
