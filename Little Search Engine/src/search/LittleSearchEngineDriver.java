package search;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Sasha on 3/31/17.
 */
public class LittleSearchEngineDriver {

    public static void main(String[]args) {
        LittleSearchEngine engine = new LittleSearchEngine();
        try {
            engine.makeIndex("docs.txt", "noisewords.txt");
            print(engine);

        }   catch (FileNotFoundException e) {
            System.out.println("File does not exist");
            System.out.println(e);
        }
    }

    private static void print(LittleSearchEngine engine) {
       System.out.print(engine.keywordsIndex.size());
        for (Map.Entry<String, ArrayList<Occurrence>> entry : engine.keywordsIndex.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            System.out.println(key + "          OCCURENCE: " + value);
        }
    }
}
