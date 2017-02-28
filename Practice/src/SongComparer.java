import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Sasha on 2/23/17.
 */
class SongComparer {

    ArrayList comparesSongs(String[] one, String[] two) {


        ArrayList<String> commonSongs = new ArrayList();

        for (String songOne : one) {
            for (String songTwo : two) {
                if (songTwo.equals(songOne)) {
                    commonSongs.add(songOne);
                }
            }
        }
      return commonSongs;
    }

    void printSongs(ArrayList array){
         System.out.println(array);
    }
    
}
