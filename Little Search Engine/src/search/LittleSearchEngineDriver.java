package search;

import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.HashMap;

/**
 * Created by Sasha on 3/31/17.
 */
public class LittleSearchEngineDriver {

    public static void main(String[]args) {
        LittleSearchEngine engine = new LittleSearchEngine();
        try {
            engine.makeIndex("docs.txt", "noisewords.txt");
            HashMap<String, Occurrence> hashMap = engine.loadKeyWords("AliceCh1.txt");
            System.out.println(Collections.singletonList(hashMap));

        }   catch (FileNotFoundException e) {
            System.out.println("File does not exist");
            System.out.println(e);
        }
    }
}
