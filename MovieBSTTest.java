
public class MovieBSTTest {
    public static void main(String[] args) {
        Movie a = new Movie("a", 2002, 10);
        Movie b = new Movie("b", 2003, 9);
        Movie c = new Movie("c", 2002, 0);
        Movie d = new Movie("d", 2002, 10);

        // System.out.println(a.compareTo(b));
        // System.out.println(a.compareTo(a));
        // System.out.println(d.compareTo(a));

        MovieBST bst = new MovieBST();
        bst.add(b);
        bst.add(a);
        bst.add(c);
        bst.add(d);
        // System.out.println(a);
        System.out.println(bst.getHeight());
        bst.inOrder();
        System.out.println(bst.getRatingByTitle("d"));
    }
}
