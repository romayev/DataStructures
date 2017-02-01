import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Songs {

    private static final String[] sashasSongs = { "Modern Jesus", "Yesterday", "So American", "All Your Light", "People Say", "Got It All"};
    private static final String[] bryansSongs = { "Starboy", "Side to Side", "Heathens", "Yesterday", "One Dance", "Bad Things" };

    private final List<String> sashasList = new ArrayList<String>(Arrays.asList(sashasSongs));
    private final List<String> bryansList = new ArrayList<String>(Arrays.asList(bryansSongs));

    private Songs() {
        super();
        Collections.sort(sashasList);
        Collections.sort(bryansList);
    }

    public static void main(String[] args) {
        Songs songs = new Songs();
        List<String> commonSongs = songs.findMatching();
        System.out.println(commonSongs);
    }

    private List<String> findMatching() {
        List<String> commonSongs = new ArrayList<String>();
        for (String sashasSong: sashasList) {
            for (String bryansSong: bryansList) {
                if (sashasSong.equals(bryansSong)) {
                    commonSongs.add(sashasSong);
                }
            }
        }
        return commonSongs;
    }
}
