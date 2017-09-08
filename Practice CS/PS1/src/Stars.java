/**
 * Created by Sasha on 8/24/17.
 */
public class Stars {

    private static int NUMBER_OF_LINES = 5;
    private static String star = "*";

    public static void main(String[] args) {
        printStars();
    }

    private static void printStars() {
        for (int i = 0; i < NUMBER_OF_LINES; i++ ) {
           for (int j = 0; j <= i; j++) {
               System.out.print(star + " ");
           }
            System.out.println();
        }

    }
    //basic operations are printing star, space, and line.
    // 15 stars, 10 spaces, 5 lines, 40 total ops
    // n print new lines
}
