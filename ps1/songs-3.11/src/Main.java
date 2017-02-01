import java.util.Arrays;

public class Main {

    private static final String[] sashasSongs = { "Modern Jesus", "Yesterday", "So American", "All Your Light", "People Say", "Got It All"};
    private static final String[] bryansSongs = { "Starboy", "Side to Side", "Heathens", "Yesterday", "One Dance", "Bad Things" };

    public static void main(String[] args) {
        Main main = new Main();
        String[]matching = main.findMatching();
        System.out.println(Arrays.toString(matching));
    }

    private String[] findMatching() {
        //create array to hold matching strings
        final int minSze = Math.min(sashasSongs.length, bryansSongs.length);
        final String[] matching = new String[minSze];

        int k = 0;
        // For each song in Sasha's list
        for (String sashasSong : sashasSongs) {
            // For each song in Bryan's list
            for (int n = 0; n < bryansSongs.length; n++) {
                // Compare songs and if match add to the matching list
                if (sashasSong.equals(bryansSongs[n])) {
                    matching[k] = sashasSong;
                    k++;
                }
            }
        }
        //use sorting algorithm (double pointers to figure out songs)
        return matching;
    }
}
