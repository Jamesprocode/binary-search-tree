import java.util.NoSuchElementException;

public class MovieBST {
    // instance variable
    private Movie root;
    private int size;

    // constructor
    public MovieBST() {

    }

    // methods
    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    public void add(Movie movie) {
        if (isEmpty()) {
            this.root = movie;
        } else {
            this.root = add(movie, this.root);
        }
        this.size++;
    }

    private Movie add(Movie add, Movie root) {
        int compare = add.compareTo(root);
        // System.out.println(compare);
        if (compare <= 0) {
            if (root.left == null) {
                root.left = add;
                // System.out.println(root.left);
            } else {
                root.left = add(add, root.left);
            }
        } else {
            if (root.right == null) {
                root.right = add;
                // System.out.println(root.right);
            } else {
                root.right = add(add, root.right);

            }
        }

        return root;
    }

    public int getHeight() {
        return getHeight(this.root);
    }

    // get height helper
    private int getHeight(Movie movie) {
        // when the node is null, height is 0
        if (movie == null) {
            return 0;
        } else {
            // System.out.println("height: " + Math.max(getHeight(movie.left),
            // getHeight(movie.right)));

            // System.out.println("height: " + 1 + Math.max(getHeight(movie.left),
            // getHeight(movie.right)));
            // int x = 1 + Math.max(getHeight(movie.left), getHeight(movie.right));
            // System.out.println("height: " + x);
            return 1 + Math.max(getHeight(movie.left), getHeight(movie.right));
        }
    }

    public Movie getMax() {
        if (this.root == null) {
            throw new NoSuchElementException();
        } else {
            return getMax(this.root);
        }
    }

    private Movie getMax(Movie movie) {
        if (movie.right == null) {
            return movie;
        } else {
            return getMax(movie.right);
        }
    }

    public void inOrder() {
        inOrder(this.root);
    }

    private void inOrder(Movie movie) {
        if (movie == null) {
            return;
        } else {
            inOrder(movie.left);
            if (movie.equals(getMax())) {
                System.out.println(movie);
            } else {
                System.out.print(movie + ", ");
            }
            inOrder(movie.right);
        }
    }

    public double getRatingByTitle(String title) {
        if (isEmpty()) {
            return -1;
        } else {
            return getRatingByTitle(title, this.root);
        }
    }

    private double getRatingByTitle(String title, Movie movie) {
        Movie get = new Movie(title, 0, 0);
        int compare = get.compareTo(root);

        if (movie == null) {
            return -1;
        }
        if (get.title.equals(movie.title)) {
            return movie.rating;
        } else if (compare <= 0) {
            return getRatingByTitle(title, movie.left);
        } else if (compare > 0) {
            return getRatingByTitle(title, movie.right);
        }

        return -1;
    }

}
